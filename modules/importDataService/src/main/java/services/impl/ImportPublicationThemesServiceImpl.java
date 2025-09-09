package services.impl;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalServiceUtil;
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
import services.ImportPublicationThemesService;
import services.VocabularyService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component(service = ImportPublicationThemesService.class)
public class ImportPublicationThemesServiceImpl implements ImportPublicationThemesService {

    @Reference
    private VocabularyService vocabularyService;
    @Reference
    CategoryService categoryService;
    private final String ENVIRONMENT = PropsUtil.get("portal.environment");
    @Override
    public void importPublicationThemes() {
        System.out.println("***Importing blog categories...");

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") +"publication_themes.json")) {
            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray blogCategoriesArray = jsonObject.getJSONArray("themes");
            long groupId = GroupLocalServiceUtil.getGroup(PortalUtil.getDefaultCompanyId(), "Guest").getGroupId();
            long globalGroupId = 20119;
            long vocabularyId = vocabularyService.getOrCreateVocabulary(globalGroupId);

            for (int i = 0; i < blogCategoriesArray.length(); i++) {
                JSONObject blogCategoryObject = blogCategoriesArray.getJSONObject(i);

                String blogEntryExternalId = blogCategoryObject.getString("id");
                String categoryLabel = blogCategoryObject.getString("label");

                BlogsEntry blogsEntry = BlogsEntryLocalServiceUtil.fetchBlogsEntryByExternalReferenceCode(blogEntryExternalId, groupId);

                if (blogsEntry != null) {
                    AssetCategory category = categoryService.getCategoryByLabel(categoryLabel, vocabularyId);
                    if (category != null) {
                        long[] categoryIds = categoryService.addCategory(BlogsEntry.class.getName(), blogsEntry.getEntryId(), category.getCategoryId());
                        BlogsEntryLocalServiceUtil.updateAsset(blogsEntry.getUserId(), blogsEntry, categoryIds, null, null, null);
                        System.out.println("***Blog entry " + blogEntryExternalId + " associated with category " + categoryLabel);
                    } else {
                        System.out.println("***Category " + categoryLabel + " not found");
                    }
                } else {
                    System.out.println("***Blog entry " + blogEntryExternalId + " not found");
                }
            }

            System.out.println("***Blog categories imported");
        } catch (IOException | PortalException | SystemException e) {
            e.printStackTrace();
        }
    }
}
