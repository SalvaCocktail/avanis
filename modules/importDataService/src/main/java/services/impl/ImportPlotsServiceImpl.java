package services.impl;


import avanis.tu.explotacion.sb.model.Explotacion;
import avanis.tu.explotacion.sb.service.ExplotacionLocalService;
import avanis.tu.explotacion.sb.service.ExplotacionLocalServiceUtil;
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
import services.ImportPlotsService;
import services.VocabularyService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component(service = ImportPlotsService.class)
public class ImportPlotsServiceImpl implements ImportPlotsService {


    @Reference
    private VocabularyService vocabularyService;
    @Reference
    private CategoryService categoryService;
    @Reference
    private ExplotacionLocalService explotacionLocalService;
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");


    @Override
    public void importPlotsSB() {
        System.out.println("***Importing plots...");
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") + "plots.json")) {
            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray plotsArray = jsonObject.getJSONArray("plots");

            for (int i = 0; i < plotsArray.length(); i++) {


                JSONObject plotObject = plotsArray.getJSONObject(i);

                User user = UserLocalServiceUtil.fetchUserByExternalReferenceCode(plotObject.getString("user_id"), PortalUtil.getDefaultCompanyId());


                if (user == null) {
                    System.out.println("***Error user " + plotObject.getString("user_id") + " does not exist.");
                } else {

                    if (explotacionAlreadyExist(plotObject.getString("id"), user.getUserId())) {
                        System.out.println("***Error explotacion " + plotObject.getString("id") + " already exists.");
                    } else {

                        String categories = getCategories(plotObject.getString("categories"));
                        long[] categoryIds = null;

                        if (!categories.isBlank()) {
                            String[] categoriesArray = categories.split(",");
                            categoryIds = new long[categoriesArray.length];


                            for (int j = 0; j < categoriesArray.length; j++) {
                                categoryIds[j] = Long.parseLong(categoriesArray[j]);
                            }
                        }

                        Explotacion explotacion = ExplotacionLocalServiceUtil.createOrUpdate(
                                -1,
                                plotObject.getString("id"),
                                plotObject.getString("province"),
                                plotObject.getDouble("longitude"),
                                plotObject.getInt("height"),
                                plotObject.getString("location"),
                                plotObject.getString("name"),
                                plotObject.getDouble("latitude"),
                                plotObject.getString("meteored_location_id"),
                                plotObject.getInt("size"),
                                plotObject.getString("size_unit"),
                                plotObject.getBoolean("is_main"),
                                false,
                                user,
                                categoryIds,
                                false
                        );

                        System.out.println("***Plot " + plotObject.getString("id") + " added to user " + user.getExternalReferenceCode());

                    }
                }
            }

            System.out.println("***Plots Imported");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    private Boolean explotacionAlreadyExist(String externalReferenceCode, long userId) {
        try {
            Explotacion importedExplotacion = ExplotacionLocalServiceUtil.findByExternalCodeReferenceAndUser(externalReferenceCode, userId);
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    private String getCategories(String categories) throws PortalException {
        StringBuilder categoriesIds = new StringBuilder();

        for (String category : categories.split(",")) {
            if (!category.equals("")) {
                long globalGroupId = 20119;

                long vocabularyId = vocabularyService.getOrCreateVocabulary(globalGroupId);
                AssetCategory assetCategory = categoryService.getCategoryByLabel(getFinalCategoryLabel(category.trim()), vocabularyId);
                if (assetCategory == null) {
                    System.out.println("***Category " + category + " does not exist");
                } else {
                    if (categoriesIds.length() == 0) {
                        categoriesIds = new StringBuilder(String.valueOf(assetCategory.getCategoryId()));
                    } else {
                        categoriesIds.append(",").append(assetCategory.getCategoryId());
                    }
                }
            }
        }

        return categoriesIds.toString();
    }


    private String getFinalCategoryLabel(String rawLabel) {
        String res;

        switch (rawLabel) {
            case "SHELL_FRUITS":
                res = "shelled_fruits";
                break;
            case "OTHER_STOCKBREEDING":
                res = "stockbreeding_others";
                break;
            case "MILK_GOAT":
                res = "dairy_goat";
                break;
            case "DAIRY_SHEEP":
                res = "dairy_ovine";
                break;
            case "FORAGING":
                res = "foragers";
                break;
            case "MEAT_BEEF":
                res = "beef";
                break;
            case "MEAT_SHEEP":
                res = "meat_ovine";
                break;
            case "OTHER_AGRICULTURE":
                res = "agriculture_others";
                break;
            case "ROOT_AND_TUBERS":
                res = "tubers";
                break;
            default:
                res = rawLabel;
        }

        return res;
    }


}