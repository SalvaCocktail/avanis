package avanis.listener.scheduler;

import aQute.bnd.annotation.metatype.Configurable;
import avanis.listener.configuration.AvanisListenerConfiguration;
import avanis.listener.notificaciones.AvanisNotificacionesUtil;
import com.liferay.dynamic.data.mapping.model.LocalizedValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
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
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;


@Component(
    immediate = true, property = {
        "destination.name=" + DestinationNames.SCHEDULER_DISPATCH
    },
    configurationPid = "avanis.listener.configuration.AvanisListenerConfiguration",
    service = MessageListener.class
)
public class AyudasNotificacionesCronScheduler extends BaseMessageListener {
    private static final Log _log = LogFactoryUtil.getLog(AyudasNotificacionesCronScheduler.class);

    private volatile boolean _initialized;
    private static final String _DEFAULT_CRON_EXPRESSION = "0 0 7 1/1 * ? *";

    @Reference
    private TriggerFactory _triggerFactory;

    @Reference
    private SchedulerEngineHelper _schedulerEngineHelper;

    @Reference
    private AvanisNotificacionesUtil _avanisNotificacionesUtil;

    @Reference
    private JournalArticleLocalService _journalArticleLocalService;

    private volatile AvanisListenerConfiguration _config;

    protected void doReceive(Message message) throws Exception {
        if (getJobName().equals(message.get("JOB_NAME"))) {
            _log.debug("Inicio AyudasNotificacionesCronScheduler doReceive()");

            try {
                _log.debug("Message::" + message);
            } catch (Exception e) {
                e.printStackTrace();
            }

            List<JournalArticle> validArticles = new ArrayList<>();
            Set<String> processedArticleIds = new HashSet<>();

            List<JournalArticle> articles = _journalArticleLocalService.getArticlesByStructureId(
                    _config.getGroupIdPortal(), _config.getIdEstructuraAyuda(), WorkflowConstants.STATUS_APPROVED, -1, -1, null);

            if (articles != null && !articles.isEmpty()) {
                for (JournalArticle article : articles) {
                    if (processedArticleIds.contains(article.getArticleId())) {
                        continue;
                    }

                    validArticles.add(article);
                    processedArticleIds.add(article.getArticleId());
                }
            }

            for (JournalArticle articulo : validArticles) {
                try {
                    DDMFormValues ddmFormValues = articulo.getDDMFormValues();

                    if (ddmFormValues != null) {
                        List<DDMFormFieldValue> ddmFormFieldValues = ddmFormValues.getDDMFormFieldValues();

                        for (DDMFormFieldValue fieldValue : ddmFormFieldValues) {
                            if (fieldValue.getFieldReference().equals("fechaFinSolicitud")) {
                                LocalizedValue localizedValue = (LocalizedValue) fieldValue.getValue();

                                String fechaFinSolicitudStr = localizedValue.getString(LocaleUtil.fromLanguageId(articulo.getDefaultLanguageId()));

                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                LocalDate fechaFinSolicitud = LocalDate.parse(fechaFinSolicitudStr, formatter);

                                LocalDate fechaActual = LocalDate.now();
                                long diasRestantes = ChronoUnit.DAYS.between(fechaActual, fechaFinSolicitud);

                                if (diasRestantes == _config.getDiasVencimientos()) {
                                    _avanisNotificacionesUtil.gestionarAyudaVencimiento(articulo, diasRestantes, fechaFinSolicitudStr);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    _log.error("Error obteniendo el campo fechaFinSolicitud", e);
                }
            }
            _log.debug("Fin AyudasNotificacionesCronScheduler doReceive()");
        }
    }

    @Activate
    protected void activate(Map<String, Object> properties	) {
        _log.info("Inicio AyudasNotificacionesCronScheduler Activate()");
        _config = Configurable.createConfigurable(AvanisListenerConfiguration.class, properties);

        String description = "Ejecucion diaria para recuperar fechas ayudas.";
        String destinationName = DestinationNames.SCHEDULER_DISPATCH;

        String jobName = getJobName();
        String groupName = getGroupName();

        String cronExpression = (Validator.isNotNull(_config.cronExpressionNotificacionesAyudas())) ? _config.cronExpressionNotificacionesAyudas() : _DEFAULT_CRON_EXPRESSION;
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
            _log.error(" Error creando AyudasNotificacionesCronScheduler: " + cronExpression);
            e.printStackTrace();
        }
        _log.info("Fin AyudasNotificacionesCronScheduler Activate()");
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
        _log.debug(" AyudasNotificacionesCronScheduler deactivated.");
    }

    protected StorageType getStorageType() {
        return StorageType.MEMORY_CLUSTERED;
    }

    private String getJobName(){
        return "ayudas_notificaciones_scheduled_job";
    }

    private String getGroupName(){
        return getClass().getName();
    }
}
