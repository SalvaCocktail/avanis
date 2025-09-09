package avanis.listener.service;

import avanis.ayudas.subvenciones.cache.AyudasCacheUtil;
import avanis.listener.notificaciones.AvanisNotificacionesUtil;
import avanis.listener.util.AvanisListenerUtil;
import avanis.listener.vo.UserExplotacionInfo;
import avanis.tu.explotacion.sb.model.Explotacion;
import avanis.tu.explotacion.sb.service.ExplotacionLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.dynamic.data.mapping.model.LocalizedValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleModel;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.trash.helper.TrashHelper;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component(service = ModelListener.class)
public class AvanisAyudasSubvencionesListener extends BaseModelListener<JournalArticle> {

    private static final Log _log = LogFactoryUtil.getLog(AvanisAyudasSubvencionesListener.class);

    @Reference
    private AssetEntryLocalService _assetEntryLocalService;

    @Reference
    private AssetCategoryLocalService _assetCategoryLocalService;

    @Reference
    private AvanisListenerUtil _avanisListenerUtil;

    @Reference
    private AvanisNotificacionesUtil _avanisNotificacionesUtil;

    @Reference
    private TrashHelper _trashHelper;

    @Reference
    private UserLocalService _userLocalService;

    @Reference
    private AyudasCacheUtil _ayudasCacheUtil;

    public Class<?> getModelClass() {
        return JournalArticle.class;
    }

    public void onAfterUpdate(JournalArticle originalModel, JournalArticle model) throws ModelListenerException {
        if (model.getStatus() != WorkflowConstants.STATUS_APPROVED) {
            return;
        }

        if (model.getDDMStructure().getName().toLowerCase().contains("ayudas_subvenciones")) {
            AyudasCacheUtil.removeFromCache("ayudas_user_" + model.getUserId());
            _log.info("Cache eliminada para el usuario: " + model.getUserId());

            if (model.getVersion() == 1.0) {
                gestionarAyuda(model, true);
            } else if (model.getVersion() > 1.0 && model.getModifiedDate().after(model.getCreateDate())) {
                List<JournalArticle> articleVersions = JournalArticleLocalServiceUtil.getArticlesByResourcePrimKey(model.getResourcePrimKey());
                JournalArticle previousVersion = ListUtil.filter(
                        articleVersions,
                        article -> article.isApproved() && article.getVersion() < model.getVersion()
                ).stream().max(Comparator.comparingDouble(JournalArticleModel::getVersion)).orElse(null);

                if (previousVersion != null && !(model.getUrlTitle().contains("ayudas/") ^ previousVersion.getUrlTitle().contains("ayudas/"))) {
                    String fechaInicioActual = obtenerFecha(model, "fechaInicioSolicitud");
                    String fechaFinActual = obtenerFecha(model, "fechaFinSolicitud");

                    String fechaInicioAnterior = obtenerFecha(previousVersion, "fechaInicioSolicitud");
                    String fechaFinAnterior = obtenerFecha(previousVersion, "fechaFinSolicitud");

                    if (!fechaInicioActual.equals(fechaInicioAnterior) || !fechaFinActual.equals(fechaFinAnterior)) {
                        gestionarAyuda(model, false);
                    }
                }
            }
        }
    }

    private String obtenerFecha(JournalArticle articulo, String tipoFecha) {
        try {
            DDMFormValues ddmFormValues = articulo.getDDMFormValues();

            if (ddmFormValues != null) {
                List<DDMFormFieldValue> ddmFormFieldValues = ddmFormValues.getDDMFormFieldValues();

                for (DDMFormFieldValue fieldValue : ddmFormFieldValues) {
                    if (fieldValue.getFieldReference().equals(tipoFecha)) {
                        LocalizedValue localizedValue = (LocalizedValue) fieldValue.getValue();
                        return localizedValue.getString(LocaleUtil.fromLanguageId(articulo.getDefaultLanguageId()));
                    }
                }
            }
        } catch (Exception e) {
            _log.error("Error obteniendo el campo " + tipoFecha, e);
        }
        return "";
    }

    private void gestionarAyuda(JournalArticle model, boolean nuevaAyuda) {
        _log.info("Iniciando gestión de ayuda para el artículo: " + model.getArticleId());

        // Eliminar caché global de ayudas
        AyudasCacheUtil.removeFromCache("all_ayudas");
        AyudasCacheUtil.removeFromCache("mis_ayudas_general");
        _log.info("Cache global eliminada tras actualización de ayudas.");

        // Obtener las categorías del JournalArticle en cuestión y normalizarlas
        List<String> categoryNamesNormalizadas = obtenerCategoriasNormalizadas(model);

        // Obtener todas las explotaciones en el sistema
        List<Explotacion> explotaciones = ExplotacionLocalServiceUtil.getExplotacions(-1, -1);

        for (Explotacion explotacion : explotaciones) {
            List<String> categoriasExplotacionNormalizadas = obtenerCategoriasExplotacionNormalizadas(explotacion);

            boolean hasMatchingCategory = categoryNamesNormalizadas.stream()
                    .anyMatch(categoriasExplotacionNormalizadas::contains);

            if (hasMatchingCategory) {
                _log.info("Explotación con ID " + explotacion.getExplotacionId() + " tiene una categoría coincidente.");
            }
        }

        _log.info("Finalizada la gestión de ayuda para el artículo: " + model.getArticleId());
    }

    private List<String> obtenerCategoriasNormalizadas(JournalArticle model) {
        List<String> categoryNamesNormalizadas = new ArrayList<>();
        long classPK = model.getResourcePrimKey();
        AssetEntry assetEntryJournal = _assetEntryLocalService.fetchEntry(JournalArticle.class.getName(), classPK);
        if (assetEntryJournal != null) {
            long[] categoryIds = assetEntryJournal.getCategoryIds();
            List<String> categoryNames = Arrays.stream(categoryIds)
                    .mapToObj(categoryId -> _assetCategoryLocalService.fetchCategory(categoryId))
                    .filter(Objects::nonNull)
                    .map(AssetCategory::getName)
                    .collect(Collectors.toList());
            categoryNamesNormalizadas = categoryNames.stream()
                    .map(this::normalizeString)
                    .collect(Collectors.toList());
        }
        _log.info("obtenerCategoriasNormalizadas() -> "+categoryNamesNormalizadas);
        return categoryNamesNormalizadas;
    }

    private List<String> obtenerCategoriasExplotacionNormalizadas(Explotacion explotacion) {
        List<String> categoriasNormalizadas = new ArrayList<>();
        AssetEntry assetEntryExplotacion = _assetEntryLocalService.fetchEntry(Explotacion.class.getName(), explotacion.getExplotacionId());
        if (assetEntryExplotacion != null) {
            List<String> categoriasExplotacion = assetEntryExplotacion.getCategories().stream()
                    .map(category -> _assetCategoryLocalService.fetchCategory(category.getCategoryId()))
                    .filter(Objects::nonNull)
                    .map(AssetCategory::getName)
                    .collect(Collectors.toList());
            categoriasNormalizadas = categoriasExplotacion.stream()
                    .map(this::normalizeString)
                    .collect(Collectors.toList());
        }
        _log.debug("obtenerCategoriasExplotacionNormalizadas() -> "+categoriasNormalizadas);
        return categoriasNormalizadas;
    }

    private void enviarNotificacionParaExplotacion(User user, Explotacion explotacion, JournalArticle model, boolean nuevaAyuda) {
        _log.debug("enviarNotificacionParaExplotacion()");
        String ayudasNotificaciones = getNotificationSetting(user, "ayudas_nuevas");

        if (nuevaAyuda) {
            if (ayudasNotificaciones.equalsIgnoreCase("all")) {
                _avanisNotificacionesUtil.sendAyudaNotification(new UserExplotacionInfo(user, explotacion.getName()), model);
                _avanisNotificacionesUtil.sendEmailNotificacionAyudaNueva(user, model, explotacion.getName());
            } else if (ayudasNotificaciones.equalsIgnoreCase("app")) {
                _avanisNotificacionesUtil.sendAyudaNotification(new UserExplotacionInfo(user, explotacion.getName()), model);
            } else if (ayudasNotificaciones.equalsIgnoreCase("email")) {
                _avanisNotificacionesUtil.sendEmailNotificacionAyudaNueva(user, model, explotacion.getName());
            }
        } else {
            if (ayudasNotificaciones.equalsIgnoreCase("all")) {
                _avanisNotificacionesUtil.sendAyudaNotification(new UserExplotacionInfo(user, explotacion.getName()), model);
                _avanisNotificacionesUtil.sendEmailNotificacionAyuda(user, model, explotacion.getName());
            } else if (ayudasNotificaciones.equalsIgnoreCase("app")) {
                _avanisNotificacionesUtil.sendAyudaNotification(new UserExplotacionInfo(user, explotacion.getName()), model);
            } else if (ayudasNotificaciones.equalsIgnoreCase("email")) {
                _avanisNotificacionesUtil.sendEmailNotificacionAyuda(user, model, explotacion.getName());
            }
        }
    }

    private String normalizeString(String input) {
        return _avanisListenerUtil.normalizeString(input);
    }

    private String getNotificationSetting(User principal, String notificationName) {
        ExpandoBridge expandoBridge = principal.getExpandoBridge();
        String[] notificationSettings = (String[]) expandoBridge.getAttribute(notificationName + "_notification");
        return (notificationSettings != null && notificationSettings.length > 0) ? notificationSettings[0] : "none";
    }

    @Override
    public void onAfterRemove(JournalArticle model) throws ModelListenerException {
        try {
            if (!_trashHelper.isInTrashExplicitly(model)) {
                _log.info("Ayuda eliminada desde contenido web. Limpiando caché.");
                AyudasCacheUtil.removeFromCache("all_ayudas");
                AyudasCacheUtil.removeFromCache("mis_ayudas_general");
            } else {
                _log.info("Ayuda eliminada desde la papelera. No limpiamos caché.");
            }
        } catch (Exception e) {
            _log.error("Error al verificar si el artículo está en la papelera", e);
        }
    }

    @Override
    public void onAfterCreate(JournalArticle model) throws ModelListenerException {
        if (model.getStatus() != WorkflowConstants.STATUS_APPROVED) {
            return;
        }

        if (model.getDDMStructure().getName().toLowerCase().contains("ayudas_subvenciones")) {
            _log.info("Nueva ayuda creada. Limpiando caché.");
            AyudasCacheUtil.removeFromCache("all_ayudas");
            AyudasCacheUtil.removeFromCache("mis_ayudas_general");
            gestionarAyuda(model, true);
        }
    }
}
