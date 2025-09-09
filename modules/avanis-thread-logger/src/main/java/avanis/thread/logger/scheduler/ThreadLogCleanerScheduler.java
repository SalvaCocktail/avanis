package avanis.thread.logger.scheduler;

import avanis.thread.logger.sb.service.ThreadLogLocalService;
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
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.util.Map;
import java.util.TimeZone;

@Component(
    immediate = true,
    property = {
        "destination.name=" + DestinationNames.SCHEDULER_DISPATCH
    },
    service = MessageListener.class
)
public class ThreadLogCleanerScheduler extends BaseMessageListener {

    private static final Log _log = LogFactoryUtil.getLog(ThreadLogCleanerScheduler.class);

    private volatile boolean _initialized;
    private static final String _DEFAULT_CRON_EXPRESSION = "0 1 0 * * ?";// Todos los días a las 00:01

    @Reference
    private TriggerFactory _triggerFactory;

    @Reference
    private SchedulerEngineHelper _schedulerEngineHelper;

    @Reference
    private ThreadLogLocalService _threadLogLocalService;

    protected void doReceive(Message message) throws Exception {
        if (getJobName().equals(message.get("JOB_NAME"))) {
            _log.debug("*** Inicio ThreadLogCleanerScheduler doReceive()");

            try {
                _log.debug("Message::" + message);
            } catch (Exception e) {
                _log.error(e);
            }

            _threadLogLocalService.deleteAll();

            _log.debug("*** Fin ThreadLogCleanerScheduler doReceive()");
        }
    }

    @Activate
    protected void activate(Map<String, Object> properties) {
        _log.info("*** Inicio ThreadLogCleanerScheduler Activate()");

        String description = "Ejecucion ThreadLogCleanerScheduler";
        String destinationName = DestinationNames.SCHEDULER_DISPATCH;

        String jobName = getJobName();
        String groupName = getGroupName();

        String cronExpression = _DEFAULT_CRON_EXPRESSION;
        _log.debug(" cronExpression: " + cronExpression);

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
            _log.error(" Error creando ThreadLogCleanerScheduler: " + e.getMessage());
        }
        _log.info("*** Fin ThreadLogCleanerScheduler Activate()");
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
        _log.debug(" ThreadLogCleanerScheduler deactivated.");
    }

    protected StorageType getStorageType() {
        return StorageType.MEMORY_CLUSTERED;
    }

    private String getJobName(){
        return "thread_logger_clean_scheduled_job";
    }

    private String getGroupName(){
        return getClass().getName();
    }

}
