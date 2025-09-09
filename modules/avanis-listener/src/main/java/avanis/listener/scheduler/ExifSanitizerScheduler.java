package avanis.listener.scheduler;

import aQute.bnd.annotation.metatype.Configurable;
import avanis.listener.configuration.AvanisListenerConfiguration;
import avanis.listener.configuration.SchedulersExpresionConfiguration;
import avanis.listener.util.ExifSanitizerUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
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

import java.util.List;
import java.util.Map;
import java.util.TimeZone;

@Component(
    immediate = true,
    property = {
        "destination.name=" + DestinationNames.SCHEDULER_DISPATCH
    },
    configurationPid = "avanis.listener.configuration.SchedulersExpresionConfiguration",
    service = MessageListener.class
)
public class ExifSanitizerScheduler extends BaseMessageListener {
    private static final Log _log = LogFactoryUtil.getLog(ExifSanitizerScheduler.class);

    private volatile boolean _initialized;
    private static final String _DEFAULT_CRON_EXPRESSION = "0 0 7 1/1 * ? *";

    @Reference
    private TriggerFactory _triggerFactory;

    @Reference
    private SchedulerEngineHelper _schedulerEngineHelper;

    @Reference
    private DLFileEntryLocalService _dlFileEntryLocalService;

    @Reference
    private ExifSanitizerUtil _exifSanitizerUtil;

    private volatile SchedulersExpresionConfiguration _config;

    protected void doReceive(Message message) throws Exception {
        if (getJobName().equals(message.get("JOB_NAME"))) {
            _log.debug("Inicio ExifSanitizerScheduler doReceive()");

            try {
                _log.debug("Message::" + message);
            } catch (Exception e) {
                _log.error(e);
            }

            List<DLFileEntry> fileEntries = _dlFileEntryLocalService.getDLFileEntries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
            if(!fileEntries.isEmpty()){

                for (DLFileEntry fileEntry : fileEntries) {
                    if (_exifSanitizerUtil.isImage(fileEntry.getFileName())) {
                        _log.debug("Sanitizing EXIF DLFileEntry: " + fileEntry.getFileName());
                        _exifSanitizerUtil.sanitizeExif(fileEntry);
                    }
                }
            }
        }
        _log.debug("Fin ExifSanitizerScheduler doReceive()");
    }

    @Activate
    protected void activate(Map<String, Object> properties	) {
        _log.debug("Inicio ExifSanitizerScheduler Activate()");
        _config = Configurable.createConfigurable(SchedulersExpresionConfiguration.class, properties);

        String description = "Ejecucion diaria para recuperar fechas ayudas.";
        String destinationName = DestinationNames.SCHEDULER_DISPATCH;

        String jobName = getJobName();
        String groupName = getGroupName();

        String cronExpression = (Validator.isNotNull(_config.cronExpressionExifSanitizer())) ? _config.cronExpressionExifSanitizer() : _DEFAULT_CRON_EXPRESSION;
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
            _log.error(" Error creando ExifSanitizerScheduler: " + cronExpression);
            e.printStackTrace();
        }
        _log.debug("Fin ExifSanitizerScheduler Activate()");
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
        _log.debug(" ExifSanitizerScheduler deactivated.");
    }

    protected StorageType getStorageType() {
        return StorageType.MEMORY_CLUSTERED;
    }

    private String getJobName(){
        return "exif_sanitizer_scheduled_job";
    }

    private String getGroupName(){
        return getClass().getName();
    }

}
