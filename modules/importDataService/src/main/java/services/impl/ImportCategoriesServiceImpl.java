package services.impl;

import com.liferay.asset.kernel.exception.DuplicateCategoryException;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.util.PropsUtil;
import org.apache.commons.io.IOUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import services.CategoryService;
import services.ImportCategoriesService;
import services.VocabularyService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component(service = ImportCategoriesService.class)
public class ImportCategoriesServiceImpl implements ImportCategoriesService {

    @Reference
    private VocabularyService vocabularyService;
    @Reference
    CategoryService categoryService;

    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    @Override
    public void importCategories() {
        System.out.println("***Importing categories...");

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") + "category.json")) {

            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray categoryArray = jsonObject.getJSONArray("category");

            long userId = 20122;
            long companyId = PortalUtil.getDefaultCompanyId();
            long groupId = 20119; //Global group
            long vocabularyId = vocabularyService.getOrCreateVocabulary(groupId);

            for (int i = 0; i < categoryArray.length(); i++) {
                JSONObject categoryObject = categoryArray.getJSONObject(i);
                String categoryId = categoryObject.getString("id");
                String categoryLabel = categoryService.translateCategory(categoryObject.getString("label"));

                categoryService.createCategory(categoryId, userId, companyId, groupId, vocabularyId, categoryLabel);
            }

            System.out.println("***Categories imported");
            importSubcategories(groupId);

        } catch (PortalException | SystemException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void importMessageTypes() {
        System.out.println("***Importing message types...");
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") + "message_types.json")) {

            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray categoryArray = jsonObject.getJSONArray("types");

            long userId = 20122;
            long companyId = PortalUtil.getDefaultCompanyId();
            long groupId = GroupLocalServiceUtil.getGroup(PortalUtil.getDefaultCompanyId(), "Guest").getGroupId();

            long vocabularyId = vocabularyService.getOrCreateVocabulary(groupId, "message types", "com.liferay.message.boards.model.MBMessage");

            for (int i = 0; i < categoryArray.length(); i++) {
                JSONObject categoryObject = categoryArray.getJSONObject(i);
                String categoryLabel = categoryService.translateCategory(categoryObject.getString("type"));

                categoryService.createCategory(null, userId, companyId, groupId, vocabularyId, categoryLabel);
            }

            System.out.println("***Message types imported");

        } catch (PortalException | SystemException | IOException e) {
            e.printStackTrace();
        }

    }

    private void importSubcategories(long groupId) {
        System.out.println("***Importing subcategories...");

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") + "subcategory.json")) {

            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray subcategoryArray = jsonObject.getJSONArray("Subcategories");

            long userId = 20122;
            long companyId = PortalUtil.getDefaultCompanyId();

            long vocabularyId = vocabularyService.getOrCreateVocabulary(groupId);

            for (int i = 0; i < subcategoryArray.length(); i++) {
                JSONObject subcategoryObject = subcategoryArray.getJSONObject(i);
                String categoryLabel = subcategoryObject.getString("category_label");
                String subcategoryLabel = categoryService.translateCategory(subcategoryObject.getString("subcategory_label"));

                AssetCategory parentCategory = categoryService.getCategoryByLabel(categoryLabel, vocabularyId);

                if (parentCategory != null) {
                    long parentCategoryId = parentCategory.getCategoryId();

                    if (!subcategoryAlreadyExist(subcategoryLabel, parentCategoryId)) {
                        try {
                            ServiceContext serviceContext = createServiceContext(groupId, companyId);

                            Locale esLocale = new Locale("es", "ES");
                            Locale enLocale = new Locale("en", "US");
                            Map<Locale, String> titleMap = new HashMap<>();
                            titleMap.put(esLocale, subcategoryLabel);
                            titleMap.put(enLocale, subcategoryLabel);

                            AssetCategory subcategory = AssetCategoryLocalServiceUtil.addCategory(
                                    null,
                                    userId,
                                    groupId,
                                    parentCategoryId,
                                    titleMap,
                                    null,
                                    vocabularyId,
                                    null,
                                    serviceContext
                            );

                            System.out.println("***Subcategory " + subcategoryLabel + " added under category '" + categoryLabel + "'");

                        } catch (DuplicateCategoryException e) {
                            System.out.println("***Subcategory already exists: " + subcategoryLabel);
                        }
                    }
                } else {
                    System.out.println("***La categoría padre '" + categoryLabel + "' no se encontró. Asegúrate de que exista antes de agregar subcategorías.");
                }
            }

            System.out.println("***Subcategories imported");

        } catch (PortalException | IOException e) {
            e.printStackTrace();
        }
    }

    private boolean subcategoryAlreadyExist(String subcategoryLabel, long parentCategoryId) {
        try {
            List<AssetCategory> categories = AssetCategoryLocalServiceUtil.getChildCategories(parentCategoryId);

            for (AssetCategory category : categories) {
                if (category.getTitle(LocaleUtil.getDefault()).equalsIgnoreCase(subcategoryLabel)) {
                    System.out.println("***Subcategory " + subcategoryLabel + " already exists under parent category ID " + parentCategoryId);
                    return true;
                }
            }
        } catch (SystemException e) {
            e.printStackTrace();
        }

        return false;
    }

    private ServiceContext createServiceContext(long groupId, long companyId) {
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setScopeGroupId(groupId);
        serviceContext.setCompanyId(companyId);
        serviceContext.setAddGroupPermissions(true);
        serviceContext.setAddGuestPermissions(true);
        return serviceContext;
    }

    public void updateCategoriesExternalReferenceCode() {
        System.out.println("***Updating external references code...");

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") + "category.json")) {
            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray categoryArray = jsonObject.getJSONArray("category");

            long groupId = 20119; //Global group
            long vocabularyId = vocabularyService.getOrCreateVocabulary(groupId);

            for (int i = 0; i < categoryArray.length(); i++) {
                JSONObject categoryObject = categoryArray.getJSONObject(i);
                String categoryId = categoryObject.getString("id");
                String categoryLabel = categoryObject.getString("label");

                AssetCategory category = categoryService.getCategoryByLabel(categoryLabel, vocabularyId);
                category.setExternalReferenceCode(categoryId);
                AssetCategoryLocalServiceUtil.updateAssetCategory(category);

                System.out.println("Category " + this.categoryService.translateCategory(categoryLabel) + " updated with ERC: " + categoryId);

            }

            System.out.println("***External references code updated");
        } catch (PortalException | SystemException | IOException e) {
            e.printStackTrace();
        }


    }
}
