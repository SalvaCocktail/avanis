package services.impl;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.service.MBMessageLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.util.PropsUtil;
import org.apache.commons.io.IOUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import services.CategoryService;
import services.ImportMessageThemesService;
import services.VocabularyService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component(service = ImportMessageThemesService.class)
public class ImportMessageThemesServiceImpl implements ImportMessageThemesService {

    @Reference
    private VocabularyService vocabularyService;
    @Reference
    CategoryService categoryService;
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");
    @Override
    public void importMessageThemes() {
        System.out.println("***Importing message categories...");

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") +"message_themes.json")) {
            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray messageThemesArray = jsonObject.getJSONArray("themes");
            long groupId = GroupLocalServiceUtil.getGroup(PortalUtil.getDefaultCompanyId(), "Guest").getGroupId();
            long userId = 20122; // Ajusta el userId según tus necesidades
            long globalGroupId = 20119;

            long vocabularyId = vocabularyService.getOrCreateVocabulary(globalGroupId);

            for (int i = 0; i < messageThemesArray.length(); i++) {
                JSONObject messageThemeObject = messageThemesArray.getJSONObject(i);

                String messageExternalId = messageThemeObject.getString("id");
                String categoryLabel = messageThemeObject.getString("label");

                MBMessage message = MBMessageLocalServiceUtil.fetchMBMessageByExternalReferenceCode(messageExternalId, groupId);

                if (message != null) {
                    AssetCategory category = categoryService.getCategoryByLabel(categoryLabel, vocabularyId);
                    if (category != null) {
                        long[] categoryIds = categoryService.addCategory(MBMessage.class.getName(), message.getMessageId(), category.getCategoryId());
                        MBMessageLocalServiceUtil.updateAsset(message.getUserId(), message, categoryIds, null, null);
                        System.out.println("***Message " + messageExternalId + " associated with category " + categoryLabel);
                    } else {
                        System.out.println("***Category " + categoryLabel + " not found");
                    }
                } else {
                    System.out.println("***Message " + messageExternalId + " not found");
                }
            }

            System.out.println("***Message categories imported");
        } catch (IOException | PortalException | SystemException e) {
            e.printStackTrace();
        }
    }
}
