package avanis.thread.logger.scheduler;

import avanis.thread.logger.sb.model.ThreadLog;
import avanis.thread.logger.sb.service.ThreadLogLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.scheduler.messaging.SchedulerResponse;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

@Component(
    immediate = true,
    property = {
        "destination.name=" + DestinationNames.SCHEDULER_DISPATCH
    },
    service = MessageListener.class
)
public class ThreadLoggerScheduler extends BaseMessageListener {

    private static final Log _log = LogFactoryUtil.getLog(ThreadLoggerScheduler.class);

    private volatile boolean _initialized;
    private static final String _DEFAULT_CRON_EXPRESSION = "0 0/5 * * * ?";

    @Reference
    private TriggerFactory _triggerFactory;

    @Reference
    private SchedulerEngineHelper _schedulerEngineHelper;

    @Reference
    private ThreadLogLocalService _threadLogLocalService;

    @Reference
    private CounterLocalService _counterLocalService;

    protected void doReceive(Message message) throws Exception {
        if (getJobName().equals(message.get("JOB_NAME"))) {
            _log.debug("*** Inicio ThreadLoggerScheduler doReceive()");

            try {
                _log.debug("Message::" + message);
            } catch (Exception e) {
                _log.error(e);
            }

            try {
                ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
                ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);

                for (ThreadInfo threadInfo : threadInfos) {
                    String name = threadInfo.getThreadName();
                    String stack = threadInfo.toString();
                    Thread.State state = threadInfo.getThreadState();

                    if ((name.startsWith("http-nio") || name.contains("Worker")  || name.contains("Sidecar")
                            || stack.contains("avanis") || stack.contains("com.liferay.portal"))
                            && (state == Thread.State.RUNNABLE || state == Thread.State.BLOCKED)) {

                        _log.debug("THREAD: " + name + " [" + state + "]");
                        _log.debug("StackTrace -> "+stack);

                        try {
                            ThreadLog threadLog = _threadLogLocalService.createThreadLog(
                                    _counterLocalService.increment(ThreadLog.class.getName()));

                            threadLog.setCreateDate(new Date());
                            threadLog.setThreadName(name);
                            threadLog.setThreadState(state.name());
                            threadLog.setStackTrace(stack);

                            if (Validator.isNotNull(threadInfo.getLockedMonitors()) && threadInfo.getLockedMonitors().length > 0) {
                                threadLog.setLockName(threadInfo.getLockedMonitors()[0].getClassName());
                            }

                            if (threadInfo.getLockOwnerName() != null) {
                                threadLog.setLockOwnerName(threadInfo.getLockOwnerName());
                                threadLog.setLockOwnerId(threadInfo.getLockOwnerId());
                            }

                            _threadLogLocalService.updateThreadLog(threadLog);
                            _log.info("threadLog agregado -> "+ threadLog.getThreadLogId());

                        } catch (Exception ex) {
                            _log.error("No se pudo guardar el thread " + name, ex);
                        }
                    }

                }
            } catch (Exception e) {
                _log.error("Error al capturar los threads", e);
            }

            _log.debug("*** Fin ThreadLoggerScheduler doReceive()");
        }
    }

    @Activate
    protected void activate(Map<String, Object> properties) {
        _log.info("*** Inicio ThreadLoggerScheduler Activate()");

        String description = "Ejecucion ThreadLoggerScheduler";
        String destinationName = DestinationNames.SCHEDULER_DISPATCH;

        String jobName = getJobName();
        String groupName = getGroupName();

        String cronExpression = _DEFAULT_CRON_EXPRESSION;
        _log.info(" cronExpression: " + cronExpression);

        Trigger jobTrigger = _triggerFactory.createTrigger(jobName, groupName, null, null, cronExpression, TimeZone.getTimeZone("Europe/Madrid"));

        Message message = new Message();
        message.put("JOB_NAME", jobName);
        message.put("GROUP_NAME", groupName);

        try{
            SchedulerResponse schedulerResponse = _schedulerEngineHelper.getScheduledJob(jobName, groupName,getStorageType());
            if(schedulerResponse != null){
                _schedulerEngineHelper.delete(jobName, groupName, getStorageType());
            }
            _schedulerEngineHelper.schedule(jobTrigger, getStorageType(), description, destinationName, message);
        } catch (Exception e) {
            _log.error(" Error creando ThreadLoggerScheduler: " + e.getMessage());
        }
        _log.info("*** Fin ThreadLoggerScheduler Activate()");
    }

    @Deactivate
    protected void deactivate() {
        if (_initialized) {
            try {
                _schedulerEngineHelper.delete(getJobName(), getGroupName(), getStorageType());
            } catch (SchedulerException se) {
                if (_log.isWarnEnabled()) {
                    _log.warn("Unable to unschedule trigger", se);
                }
            }
        }
        _initialized = false;
        _log.debug(" ThreadLoggerScheduler deactivated.");
    }

    protected StorageType getStorageType() {
        return StorageType.MEMORY_CLUSTERED;
    }

    private String getJobName(){
        return "thread_logger_scheduled_job";
    }

    private String getGroupName(){
        return getClass().getName();
    }

}
