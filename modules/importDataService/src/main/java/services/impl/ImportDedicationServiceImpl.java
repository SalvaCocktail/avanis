package services.impl;


import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.util.PropsUtil;
import org.apache.commons.io.IOUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import services.CategoryService;
import services.ImportDedicationService;
import services.VocabularyService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;


@Component(service = ImportDedicationService.class)
public class ImportDedicationServiceImpl implements ImportDedicationService {

    @Reference
    private VocabularyService vocabularyService;
    @Reference
    private CategoryService categoryService;

    private static final String VOCABULARY_NAME = "user dedications";

    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    @Override
    public void importDedications() {
        System.out.println("***Importing dedications...");
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") +"dedications.json")) {

            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray categoryArray = jsonObject.getJSONArray("dedications");

            long userId = 20122;
            long companyId = PortalUtil.getDefaultCompanyId();
            long groupId = 20119;
            long vocabularyId = vocabularyService.getOrCreateVocabulary(groupId, VOCABULARY_NAME, "com.liferay.portal.kernel.model.User", true);

            for (int i = 0; i < categoryArray.length(); i++) {
                JSONObject categoryObject = categoryArray.getJSONObject(i);
                String categoryLabel = categoryService.translateCategory(categoryObject.getString("dedication_string"));

                categoryService.createCategory(null, userId, companyId, groupId, vocabularyId, categoryLabel);

            }

            System.out.println("***Dedications imported");

        } catch (PortalException | SystemException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void importUserDedications() {
        System.out.println("***Assigning dedications to users...");
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") +"user_dedication.json")) {
            long companyId = PortalUtil.getDefaultCompanyId();
            long groupId = 20119;

            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray userDedicationsArray = jsonObject.getJSONArray("dedications");

            for (int i = 0; i < userDedicationsArray.length(); i++) {

                JSONObject dedicationObject = userDedicationsArray.getJSONObject(i);
                User user = UserLocalServiceUtil.fetchUserByExternalReferenceCode(dedicationObject.getString("user_id"), companyId);
                long vocabularyId = vocabularyService.getOrCreateVocabulary(groupId, VOCABULARY_NAME, "com.liferay.portal.kernel.model.User", true);
                AssetCategory category = categoryService.getCategoryByLabel(dedicationObject.getString("dedication_string"), vocabularyId);

                if (user == null) {
                    System.out.println("***User " + dedicationObject.getString("user_id") + " does not exist.");
                } else if (category == null) {
                    System.out.println("***Category " + dedicationObject.getString("dedication_string") + " does not exist.");
                } else {
                    long[] categoryIds = categoryService.addCategory(User.class.getName(), user.getUserId(), category.getCategoryId());
                    UserLocalServiceUtil.updateAsset(user.getUserId(), user, categoryIds, null);
                    System.out.println("***Updated user " + dedicationObject.getString("user_id") + " category: " + categoryService.translateCategory(dedicationObject.getString("dedication_string")) + " was added");
                }

            }

            System.out.println("***Dedications assigned");

        } catch (PortalException | SystemException | IOException e) {
            e.printStackTrace();
        }
    }
}
