package avanis.listener.notificaciones;

import aQute.bnd.annotation.metatype.Configurable;
import avanis.listener.configuration.AvanisListenerConfiguration;
import avanis.listener.constants.AvanisListenerConstants;
import avanis.listener.hubspot.HubspotService;
import avanis.listener.util.AvanisListenerUtil;
import avanis.listener.vo.UserExplotacionInfo;
import avanis.tu.explotacion.sb.model.Explotacion;
import avanis.tu.explotacion.sb.service.ExplotacionLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component(
    immediate = true,
    configurationPid = "avanis.listener.configuration.AvanisListenerConfiguration",
    service = AvanisNotificacionesUtil.class
)
public class AvanisNotificacionesUtil {
    private static final Log _log = LogFactoryUtil.getLog(AvanisNotificacionesUtil.class);
    private volatile AvanisListenerConfiguration _config;

    @Reference
    private AssetEntryLocalService _assetEntryLocalService;

    @Reference
    private AssetCategoryLocalService _assetCategoryLocalService;

    @Reference
    private AvanisListenerUtil _avanisListenerUtil;

    @Reference
    private HubspotService _hubspotService;

    @Reference
    private UserLocalService _userLocalService;

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _config = Configurable.createConfigurable(AvanisListenerConfiguration.class, properties);
    }

    public void gestionarAyudaVencimiento(JournalArticle model, long diasRestantes, String fechaFinSolicitudStr) {
        long classPK = model.getResourcePrimKey();
        AssetEntry assetEntryJournal = _assetEntryLocalService.fetchEntry(JournalArticle.class.getName(), classPK);

        List<String> categoryNamesNormalizadas = assetEntryJournal != null
                ? Arrays.stream(assetEntryJournal.getCategoryIds())
                .mapToObj(categoryId -> {
                    AssetCategory category = _assetCategoryLocalService.fetchCategory(categoryId);
                    return category != null ? normalizeString(category.getName()) : null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList())
                : Collections.emptyList();

        Map<User, List<String>> userPreferencesMap = new HashMap<>();
        List<User> users = _userLocalService.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

        for (User user : users) {
            List<Explotacion> explotaciones = ExplotacionLocalServiceUtil.findByUserId(user.getUserId());

            List<String> misPreferenciasNormalizadas = explotaciones.stream()
                    .filter(Explotacion::getAllowNotifications)
                    .flatMap(explotacion -> {
                        AssetEntry assetEntryExplotacion = _assetEntryLocalService.fetchEntry(Explotacion.class.getName(), explotacion.getExplotacionId());
                        return assetEntryExplotacion != null ?
                                assetEntryExplotacion.getCategories().stream()
                                        .map(category -> {
                                            try {
                                                AssetCategory assetCategory = _assetCategoryLocalService.getAssetCategory(category.getCategoryId());
                                                return assetCategory != null ? normalizeString(assetCategory.getName()) : null;
                                            } catch (Exception e) {
                                                _log.error("Error obteniendo la categoría: " + e.getMessage());
                                                return null;
                                            }
                                        }).filter(Objects::nonNull) : Stream.empty();
                    }).distinct().collect(Collectors.toList());

            if (!misPreferenciasNormalizadas.isEmpty()) {
                userPreferencesMap.put(user, misPreferenciasNormalizadas);
            }
        }

        userPreferencesMap.forEach((user, preferences) -> {
            List<Explotacion> explotaciones = ExplotacionLocalServiceUtil.findByUserId(user.getUserId());

            explotaciones.stream()
                .filter(Explotacion::getAllowNotifications)
                .forEach(explotacion -> {
                    AssetEntry assetEntryExplotacion = _assetEntryLocalService.fetchEntry(Explotacion.class.getName(), explotacion.getExplotacionId());

                    if (assetEntryExplotacion != null) {
                        boolean matchesPreference = assetEntryExplotacion.getCategories().stream()
                                .map(category -> {
                                    try {
                                        AssetCategory assetCategory = _assetCategoryLocalService.getAssetCategory(category.getCategoryId());
                                        return assetCategory != null ? normalizeString(assetCategory.getName()) : null;
                                    } catch (Exception e) {
                                        _log.error("Error obteniendo la categoría: " + e.getMessage());
                                        return null;
                                    }
                                })
                                .filter(Objects::nonNull)
                                .anyMatch(categoryNamesNormalizadas::contains);

                        if (matchesPreference) {
                            String title = _config.getTituloVencimiento().replace("[title]", model.getTitle()) + " " + normalizeString(explotacion.getName());
                            String body = _config.getSubtituloVencimiento().replace("[tiempo]", String.valueOf(diasRestantes));
                            String ayudasNotificaciones = getNotificationSetting(user, "ayudas_porvencer");

                            if ("all".equalsIgnoreCase(ayudasNotificaciones)) {
                                sendAyudaNotificationV2(user, model, title, body);
                                sendEmailNotificacionAyudaVencimiento(user, model, fechaFinSolicitudStr, diasRestantes, normalizeString(explotacion.getName()));
                            } else if ("app".equalsIgnoreCase(ayudasNotificaciones)) {
                                sendAyudaNotificationV2(user, model, title, body);
                            } else if ("email".equalsIgnoreCase(ayudasNotificaciones)) {
                                sendEmailNotificacionAyudaVencimiento(user, model, fechaFinSolicitudStr, diasRestantes, normalizeString(explotacion.getName()));
                            }
                        }
                    }
                });
        });
    }


    private String getNotificationSetting(User principal, String notificationName) {
        PermissionChecker originalPermissionChecker = PermissionThreadLocal.getPermissionChecker();
        try {
            // Inicializar el PermissionChecker con el usuario actual
            PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(principal);
            PermissionThreadLocal.setPermissionChecker(permissionChecker);

            // Acceder al ExpandoBridge y obtener el valor deseado
            ExpandoBridge expandoBridge = principal.getExpandoBridge();
            String[] notificationSettings = (String[]) expandoBridge.getAttribute(notificationName + "_notification");
            return (notificationSettings != null && notificationSettings.length > 0) ? notificationSettings[0] : "none";

        } catch (Exception e) {
            e.printStackTrace();
            return "none";
        } finally {
            // Restaurar el PermissionChecker original para evitar problemas de contexto
            PermissionThreadLocal.setPermissionChecker(originalPermissionChecker);
        }
    }

    public void sendEmailNotificacionAyudaNueva(User user, JournalArticle model, String explotacionName) {
        _hubspotService.sendEmailNotificacionAyudaNueva(user, model, explotacionName, _config.urlSitio());
    }

    private void sendEmailNotificacionAyudaVencimiento(User user, JournalArticle model, String fechaFinSolicitudStr, long diasRestantes, String explotacionName) {
        _hubspotService.sendEmailNotificacionAyudaVencimiento(user, model, fechaFinSolicitudStr, diasRestantes, explotacionName);
    }

    private String normalizeString(String input) {
        return _avanisListenerUtil.normalizeString(input);
    }

    public void sendAyudaNotification(UserExplotacionInfo userToSend, JournalArticle article) {
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setUserId(userToSend.getUser().getUserId());
        serviceContext.setCompanyId(PortalUtil.getDefaultCompanyId());
        serviceContext.setPortalURL(PortalUtil.getCDNHostHttps(PortalUtil.getDefaultCompanyId()));

        String title = _config.getTitulo() + " " + userToSend.getExplotacionName();
        String body = _config.getSubtitulo().replace("[title]", article.getTitle());
        String entryURL = _config.urlSitio() + "/w/" + article.getUrlTitle();

        sendNotification(userToSend.getUser().getUserId(), title, body, entryURL, serviceContext);
    }

    public void sendAyudaNotificationV2(User userToSend, JournalArticle article, String title, String body) {
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setUserId(userToSend.getUserId());
        serviceContext.setCompanyId(PortalUtil.getDefaultCompanyId());
        serviceContext.setPortalURL(PortalUtil.getCDNHostHttps(PortalUtil.getDefaultCompanyId()));

        String entryURL = _config.urlSitio() + "/w/" + article.getUrlTitle();

        sendNotification(userToSend.getUserId(), title, body, entryURL, serviceContext);
    }

    private static void sendNotification(long userId, String title, String body, String entryUrl, ServiceContext serviceContext) {
        try {

            JSONObject notificationEventJSONObject = JSONFactoryUtil.createJSONObject();
            notificationEventJSONObject.put("title", title);
            notificationEventJSONObject.put("body", body);
            notificationEventJSONObject.put("entryURL", entryUrl);

            String portletId = AvanisListenerConstants.AVANISCOMUNIDAD;

            UserNotificationEventLocalServiceUtil.addUserNotificationEvent(
                userId,
                portletId,
                (new Date()).getTime(),
                UserNotificationDeliveryConstants.TYPE_WEBSITE,
                0,
                notificationEventJSONObject.toString(),
                false,
                serviceContext
            );

        } catch (PortalException e) {
            e.printStackTrace();
        }
    }

    public void sendEmailNotificacionAyuda(User user, JournalArticle model, String explotacionName) {
        _hubspotService.sendEmailNotificacionAyuda(user, model, explotacionName, _config.urlSitio());
    }
}
