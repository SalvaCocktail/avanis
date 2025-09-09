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
import org.osgi.service.component.annotations.Component;
import org.apache.commons.io.IOUtils;
import org.osgi.service.component.annotations.Reference;
import services.CategoryService;
import services.ImportUserDetailService;
import services.VocabularyService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Component(service = ImportUserDetailService.class)
public class ImportUserDetailServiceImpl implements ImportUserDetailService {
    @Reference
    private VocabularyService vocabularyService;
    @Reference
    CategoryService categoryService;
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    @Override
    public void importUserDetails() {
        System.out.println("***Importing user details...");

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") + "user_details.json")) {
            if (inputStream == null) {
                System.out.println("***Error: user_details.json not found.");
                return;
            }

            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray userDetailsArray = jsonObject.getJSONArray("details");

            // Mapa para almacenar details por user_id
            Map<String, List<String>> userInterestsMap = new HashMap<>();

            // Agrupar details por user_id
            for (int i = 0; i < userDetailsArray.length(); i++) {
                JSONObject userDetailsObject = userDetailsArray.getJSONObject(i);
                String externalReferenceCode = userDetailsObject.getString("user_id");
                String categoryLabel = userDetailsObject.getString("label");

                List<String> userInterests = userInterestsMap.getOrDefault(externalReferenceCode, new ArrayList<>());
                userInterests.add(categoryLabel);
                userInterestsMap.put(externalReferenceCode, userInterests);
            }

            long groupId = 20119;
            long userId = 20122; // Ajusta el userId según tus necesidades

            long vocabularyId = vocabularyService.getOrCreateVocabulary(groupId);

            // actualizar sus details
            for (Map.Entry<String, List<String>> entry : userInterestsMap.entrySet()) {
                String externalReferenceCode = entry.getKey();
                List<String> categoryLabels = entry.getValue();

                try {
                    // Buscar usuario por External Reference Code
                    User user = UserLocalServiceUtil.getUserByExternalReferenceCode(externalReferenceCode, PortalUtil.getDefaultCompanyId());

                    long[] detailsIds = new long[categoryLabels.size()];
                    int index = 0;

                    for (String categoryLabel : categoryLabels) {
                        AssetCategory interest = categoryService.getCategoryByLabel(categoryLabel, vocabularyId);
                        if (interest != null) {
                            detailsIds[index++] = interest.getCategoryId();
                        } else {
                            System.out.println("***Warning: Category not found for label: " + categoryLabel);
                        }
                    }

                    UserLocalServiceUtil.updateAsset(user.getUserId(), user, detailsIds, null);
                    System.out.println("***Updated user " + externalReferenceCode + " with categories: " + Arrays.toString(detailsIds));
                } catch (PortalException e) {
                    System.out.println("***Error finding user with external reference code: " + externalReferenceCode);
                    e.printStackTrace();
                } catch (SystemException e) {
                    System.out.println("***Error updating user with external reference code: " + externalReferenceCode);
                } catch (Exception e) {
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