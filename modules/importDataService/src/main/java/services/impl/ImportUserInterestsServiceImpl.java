package services.impl;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
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
import services.ImportUserInterestsService;
import services.VocabularyService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(service = ImportUserInterestsService.class)
public class ImportUserInterestsServiceImpl implements ImportUserInterestsService {

    @Reference
    private VocabularyService vocabularyService;
    @Reference
    CategoryService categoryService;
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");
    @Override
    public void importUserInterests() {
        System.out.println("***Importing user interests...");

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") +"user_interests.json")) {
            if (inputStream == null) {
                System.out.println("***Error: user_interests.json not found.");
                return;
            }

            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray userDetailsArray = jsonObject.getJSONArray("interests");

            // Mapa para almacenar interests por user_id
            Map<String, List<String>> userInterestsMap = new HashMap<>();

            // Agrupar interests por user_id
            for (int i = 0; i < userDetailsArray.length(); i++) {
                JSONObject userDetailsObject = userDetailsArray.getJSONObject(i);
                String externalReferenceCode = userDetailsObject.getString("user_id");
                String interestLabel = userDetailsObject.getString("label");

                List<String> userInterests = userInterestsMap.getOrDefault(externalReferenceCode, new ArrayList<>());
                userInterests.add(interestLabel);
                userInterestsMap.put(externalReferenceCode, userInterests);
            }

            long groupId = 20119;
            long userId = 20122; // Ajusta el userId según tus necesidades

            long vocabularyId = vocabularyService.getOrCreateVocabulary(groupId);

            // actualizar sus interests
            for (Map.Entry<String, List<String>> entry : userInterestsMap.entrySet()) {
                String externalReferenceCode = entry.getKey();
                List<String> interestLabels = entry.getValue();

                try {
                    // Buscar usuario por External Reference Code
                    User user = UserLocalServiceUtil.getUserByExternalReferenceCode(externalReferenceCode, PortalUtil.getDefaultCompanyId());

                    List<String> interestsNames = new ArrayList<>();

                    for (String interestLabel : interestLabels) {
                        AssetCategory interest = categoryService.getCategoryByLabel(interestLabel, vocabularyId);
                        if (interest != null) {
                            interestsNames.add(interest.getName());
                        } else {
                            System.out.println("***Warning: Category not found for label: " + interestLabel);
                        }
                    }

                    String[] interestsNamesArray = interestsNames.toArray(new String[0]);

                    UserLocalServiceUtil.updateAsset(user.getUserId(), user, null, interestsNamesArray);
                    System.out.println("***Updated user " + externalReferenceCode + " with interests.");
                } catch (PortalException e) {
                    System.out.println("***Error finding user with external reference code: " + externalReferenceCode);
                    e.printStackTrace();
                } catch (SystemException e) {
                    System.out.println("***Error updating user with external reference code: " + externalReferenceCode);
                    e.printStackTrace();
                }
            }

            System.out.println("***User details imported");

        } catch (IOException e) {
            System.out.println("***Error reading user_details.json.");
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("***Error parsing user_details.json.");
            e.printStackTrace();
        }
    }
}
