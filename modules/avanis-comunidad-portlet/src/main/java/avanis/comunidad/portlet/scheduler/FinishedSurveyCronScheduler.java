package avanis.comunidad.portlet.scheduler;

import aQute.bnd.annotation.metatype.Configurable;
import avanis.comunidad.model.Surveys;
import avanis.comunidad.portlet.util.AvanisComunidadUtil;
import avanis.comunidad.service.SurveysLocalServiceUtil;
import avanis.listener.configuration.AvanisListenerConfiguration;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.*;
import com.liferay.portal.kernel.scheduler.*;
import com.liferay.portal.kernel.scheduler.messaging.SchedulerResponse;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.util.*;

@Component(
        immediate = true,
        property = {
                "destination.name=" + DestinationNames.SCHEDULER_DISPATCH
        },
        service = MessageListener.class
)
public class FinishedSurveyCronScheduler extends BaseMessageListener {

    private static final Log _log = LogFactoryUtil.getLog(FinishedSurveyCronScheduler.class);

    private volatile boolean _initialized;
    private static final String _DEFAULT_CRON_EXPRESSION = "0 0/30 * 1/1 * ? *";

    @Reference
    private TriggerFactory _triggerFactory;

    @Reference
    private SchedulerEngineHelper _schedulerEngineHelper;

    @Reference
    private JournalArticleLocalService _journalArticleLocalService;


    protected void doReceive(Message message) throws Exception {
        if (getJobName().equals(message.get("JOB_NAME"))) {
            _log.info("notifying surveys");
            List<Surveys> notifiableSurveys;

            DynamicQuery notifiableSurveysQuery = SurveysLocalServiceUtil.dynamicQuery();
            notifiableSurveysQuery.add(RestrictionsFactoryUtil.ne("notified", true));
            notifiableSurveysQuery.add(RestrictionsFactoryUtil.lt("expireDate", new Date()));

            notifiableSurveys = SurveysLocalServiceUtil.dynamicQuery(notifiableSurveysQuery);

            for (Surveys surveys : notifiableSurveys) {
                AvanisComunidadUtil.sendSurveyResultsNotification(surveys);
                surveys.setNotified(true);
                SurveysLocalServiceUtil.updateSurveys(surveys);
            }
        }


    }

    @Activate
    protected void activate(Map<String, Object> properties) {
        _log.info("Inicio AyudasNotificacionesCronScheduler Activate()");

        String description = "Ejecucion diaria para recuperar fechas ayudas.";
        String destinationName = DestinationNames.SCHEDULER_DISPATCH;

        String jobName = getJobName();
        String groupName = getGroupName();

        String cronExpression = _DEFAULT_CRON_EXPRESSION;
        _log.info(" cronExpression: " + cronExpression);

        Trigger jobTrigger = _triggerFactory.createTrigger(jobName, groupName, null, null, cronExpression, TimeZone.getTimeZone("Europe/Madrid"));

        Message message = new Message();
        message.put("JOB_NAME", jobName);
        message.put("GROUP_NAME", groupName);

        try {
            SchedulerResponse schedulerResponse = _schedulerEngineHelper.getScheduledJob(jobName, groupName, getStorageType());
            if (schedulerResponse != null) {
                _schedulerEngineHelper.delete(jobName, groupName, getStorageType());
            }
            _schedulerEngineHelper.schedule(jobTrigger, getStorageType(), description, destinationName, message);
        } catch (Exception e) {
            _log.error(" Error creando AyudasNotificacionesCronScheduler: " + cronExpression);
            e.printStackTrace();
        }
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
        _log.debug(" FinishedSurveyCronScheduler deactivated.");
    }

    protected StorageType getStorageType() {
        return StorageType.MEMORY_CLUSTERED;
    }

    private String getJobName() {
        return "finished-survey-notificaciones_scheduled_job";
    }

    private String getGroupName() {
        return getClass().getName();
    }
}
