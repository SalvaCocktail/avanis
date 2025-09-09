package avanis.lonjas.scheduler;

import avanis.lonjas.cache.LonjasCacheUtil;
import avanis.lonjas.model.Lonja;
import avanis.lonjas.scheduler.util.LonjasSchedulerUtil;
import avanis.lonjas.service.LonjaLocalServiceUtil;
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
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CompletableFuture;

@Component(
    immediate = true, property = {
        "destination.name=" + DestinationNames.SCHEDULER_DISPATCH
    },
    service = MessageListener.class
)

public class LonjasCronScheduler extends BaseMessageListener {

    private static final Log _log = LogFactoryUtil.getLog(LonjasCronScheduler.class);

    private volatile boolean _initialized;
    private static final String _DEFAULT_CRON_EXPRESSION = "0 1 1 1/1 * ? *";
    private static final SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");

    @Reference
    private LonjasSchedulerUtil _lonjasSchedulerUtil;
    @Reference
    private TriggerFactory _triggerFactory;
    @Reference
    private LonjasCacheUtil _lonjasCacheUtil;

    @Reference
    private SchedulerEngineHelper _schedulerEngineHelper;

    private void processGrupos() {
        try {
            String gruposResponse = _lonjasSchedulerUtil.getInformation("Grupos", "http://sbd.telelonjas.es:9090/XML/ListaGrupos");
            if (gruposResponse != null) {
                _lonjasSchedulerUtil.saveGrupos(gruposResponse);
            } else {
                _log.warn("No data received for Grupos.");
            }
        } catch (Exception e) {
            _log.error("Error processing Grupos.", e);
        }
    }

    private void processSubGrupos() {
        try {
            String subGruposResponse = _lonjasSchedulerUtil.getInformation("SubGrupos", "http://sbd.telelonjas.es:9090/XML/ListaSubgrupos");
            if (subGruposResponse != null) {
                _lonjasSchedulerUtil.saveSubGrupos(subGruposResponse);
            } else {
                _log.warn("No data received for SubGrupos.");
            }
        } catch (Exception e) {
            _log.error("Error processing SubGrupos.", e);
        }
    }

    private void processAreas() {
        try {
            String areasResponse = _lonjasSchedulerUtil.getInformation("Areas", "http://sbd.telelonjas.es:9090/XML/ListaAreas");
            if (areasResponse != null) {
                _lonjasSchedulerUtil.saveAreas(areasResponse);
            } else {
                _log.warn("No data received for Areas.");
            }
        } catch (Exception e) {
            _log.error("Error processing Areas.", e);
        }
    }

    private void processLonjas() {
        try {
            String lonjasResponse = _lonjasSchedulerUtil.getInformation("Lonjas", "http://sbd.telelonjas.es:9090/XML/ListaLonjas");
            if (lonjasResponse != null && !lonjasResponse.isEmpty()) {
                _lonjasSchedulerUtil.saveLonjas(lonjasResponse);
            } else {
                _log.warn("No se recibió información de Lonjas.");
            }
        } catch (Exception e) {
            _log.error("Error al procesar las Lonjas.", e);
        }
    }

    private void processFechasLonjas() {
        try {
            List<Lonja> lonjaList = LonjaLocalServiceUtil.getLonjas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
            if (lonjaList.isEmpty()) {
                _log.warn("No Lonjas found for fetching Fechas.");
                return;
            }

            _log.debug("Processing Fechas Lonjas for " + lonjaList.size() + " Lonjas.");

            for (Lonja lonja : lonjaList) {
                String fechasResponse = _lonjasSchedulerUtil.getInformation(
                        "FechasLonja",
                        "http://sbd.telelonjas.es:9090/XML/FechasLonja/IdLonja=" + lonja.getLonjaId()
                );

                if (fechasResponse != null) {
                    _lonjasSchedulerUtil.saveFechasLonjas(fechasResponse, lonja.getLonjaId());
                } else {
                    _log.warn("No data received for Fechas Lonjas with Lonja ID: " + lonja.getLonjaId());
                }
            }
        } catch (Exception e) {
            _log.error("Error processing Fechas Lonjas.", e);
        }
    }

    private void processPreciosLonjas() {
        try {
            List<Lonja> lonjaList = LonjaLocalServiceUtil.getLonjas(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

            lonjaList.forEach(lonja -> {
                List<Date> fechasSinPrecios = _lonjasSchedulerUtil.getFechasSinPrecios(lonja.getLonjaId());
                _log.debug("Ctda fechasSinPrecios -> "+fechasSinPrecios.size());
                fechasSinPrecios.forEach(fecha -> {
                    String fechaStr = _lonjasSchedulerUtil.formatFechaToUrl(fecha); // formato para URL
                    String preciosResponse = _lonjasSchedulerUtil.getInformation(
                            "PreciosLonja",
                            "http://sbd.telelonjas.es:9090/XML/PreciosLonja/IdLonja=" + lonja.getLonjaId() + "&Fecha=" + fechaStr
                    );

                    if (preciosResponse != null) {
                        _lonjasSchedulerUtil.savePreciosLonjas(preciosResponse, lonja.getLonjaId(), sdfInput.format(fecha));
                    } else {
                        _log.warn("No data for PreciosLonja - LonjaId: " + lonja.getLonjaId() + ", Fecha: " + fechaStr);
                    }
                });
            });
        } catch (Exception e) {
            _log.error("Error processing Precios Lonjas.", e);
        }
    }

    protected void doReceive(Message message) {
        if (getJobName().equals(message.get("JOB_NAME"))) {
            _log.info("*** LonjasCronScheduler INICIA ***");
            CompletableFuture<Void> loadEntitiesFuture = CompletableFuture.allOf(
                    CompletableFuture.runAsync(this::processGrupos),
                    CompletableFuture.runAsync(this::processSubGrupos),
                    CompletableFuture.runAsync(this::processAreas)
            );

            loadEntitiesFuture.join();
            _log.info("Grupos, SubGrupos y Áreas cargados exitosamente.");

            CompletableFuture<Void> loadLonjasFuture = CompletableFuture.runAsync(this::processLonjas);
            loadLonjasFuture.join();
            _log.info("Lonjas cargadas exitosamente.");

            CompletableFuture<Void> loadFechasLonjasFuture = CompletableFuture.runAsync(this::processFechasLonjas);
            loadFechasLonjasFuture.join();
            _log.info("Fechas Lonjas cargadas exitosamente.");

            CompletableFuture<Void> loadPreciosLonjasFuture = CompletableFuture.runAsync(this::processPreciosLonjas);
            loadPreciosLonjasFuture.join();
            _log.info("Precios Lonjas cargados exitosamente.");

            _lonjasCacheUtil.removeFromCache("listAreas");
            _lonjasCacheUtil.removeFromCache("gruposLonjas");
            _lonjasCacheUtil.removeFromCache("lonjasTodas");
            _lonjasCacheUtil.removeFromCache("listaProductos");
            _lonjasCacheUtil.removeFromCache("listPrecioLonja");
            _log.info("TODA Cache Lonjas Eliminada");

            _log.info("*** LonjasCronScheduler FINALIZA ***");
        }
    }

    @Activate
    protected void activate() {
        String description = "Ejecución diaria para recuperar datos Lojas.";
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
            _log.error(" Error creando LonjasCronScheduler: " + cronExpression);
            _log.error(e);
        }
        _log.info(" LonjasCronScheduler activated.");
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
        _log.info(" LonjasCronScheduler deactivated.");
    }

    protected StorageType getStorageType() {
        return StorageType.MEMORY_CLUSTERED;
    }

    private String getJobName(){
        return "lonjas_scheduled_job";
    }

    private String getGroupName(){
        return getClass().getName();
    }

}
