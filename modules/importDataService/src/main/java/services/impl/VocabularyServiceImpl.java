package services.impl;

import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.util.PropsUtil;
import org.osgi.service.component.annotations.Component;
import services.VocabularyService;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component(service = VocabularyService.class)
public class VocabularyServiceImpl implements VocabularyService {

    private static final String VOCABULARY_NAME = "avanis";
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");
    private AssetVocabulary createVocabulary(String name, long groupId, long userId, String associatedAssetType, Boolean multiValue) throws PortalException {
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setScopeGroupId(groupId);
        serviceContext.setAddGroupPermissions(true);
        serviceContext.setAddGuestPermissions(true);

        Map<Locale, String> titleMap = new HashMap<>();
        titleMap.put(LocaleUtil.getDefault(), name);
        String settings = null;

        if (associatedAssetType != null) {
            long messageBoardClassNameId = PortalUtil.getClassNameId(associatedAssetType);

            settings = String.format(
                    "multiValued=%b\nselectedClassNameIds=%d:-1",
                    multiValue,
                    messageBoardClassNameId);
        }

        AssetVocabulary vocabulary = AssetVocabularyLocalServiceUtil.addVocabulary(
                userId, groupId, name, titleMap, null, settings, serviceContext
        );


        // Otorgar permisos de visualización a todos los usuarios
        // addViewPermissions(vocabulary, groupId, userId);

        return vocabulary;
    }

    @Override
    public long getOrCreateVocabulary(long groupId) {
        return this.getOrCreateVocabulary(groupId, VOCABULARY_NAME, null);
    }

    @Override
    public long getOrCreateVocabulary(long groupId, String vocabularyName, String associatedAssetType) {
        return this.getOrCreateVocabulary(groupId, vocabularyName, associatedAssetType, false);
    }

    @Override
    public long getOrCreateVocabulary(long groupId, String vocabularyName, String associatedAssetType, Boolean multiValue) {
        try {
            // Verificar si el vocabulario existe
            AssetVocabulary vocabulary = AssetVocabularyLocalServiceUtil.fetchGroupVocabulary(groupId, vocabularyName);
            if (vocabulary != null) {
                return vocabulary.getVocabularyId();
            }

            // Si no existe, crearlo utilizando el servicio VocabularyService
            vocabulary = createVocabulary(vocabularyName, groupId, 20122, associatedAssetType, multiValue);
            return vocabulary.getVocabularyId();
        } catch (PortalException | SystemException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private void addViewPermissions(AssetVocabulary vocabulary, long groupId, long userId) throws PortalException {
        try {
            ResourcePermissionLocalServiceUtil.addResourcePermission(
                    PortalUtil.getDefaultCompanyId(),
                    AssetVocabulary.class.getName(),
                    ResourceConstants.SCOPE_INDIVIDUAL,
                    String.valueOf(vocabulary.getVocabularyId()),
                    groupId,
                    ActionKeys.VIEW
            );

            // Agregar permisos de vista para los roles Guest y User
            ResourcePermissionLocalServiceUtil.addResourcePermission(
                    PortalUtil.getDefaultCompanyId(),
                    AssetVocabulary.class.getName(),
                    ResourceConstants.SCOPE_INDIVIDUAL,
                    String.valueOf(vocabulary.getVocabularyId()),
                    userId,
                    ActionKeys.VIEW
            );
        } catch (SystemException e) {
            e.printStackTrace();
        }
    }
}
