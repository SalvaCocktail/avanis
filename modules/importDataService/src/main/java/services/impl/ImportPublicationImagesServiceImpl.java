package services.impl;


import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.friendly.url.service.FriendlyURLEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.util.PropsUtil;
import org.apache.commons.io.IOUtils;
import org.osgi.service.component.annotations.Component;

import services.ImportPublicationImagesService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;



@Component(service = ImportPublicationImagesService.class)
public class ImportPublicationImagesServiceImpl implements ImportPublicationImagesService {

    private final String ENVIRONMENT = PropsUtil.get("portal.environment");

    private final static long GROUP_ID = 20117;
    private final static long FOLDER_ID = 103395;


    @Override
    public void importPublicationImages() {

        System.out.println("***Importing images...");

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(("production".equals(ENVIRONMENT) ? "production/" : "") + "publications.json")) {
            String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);

            JSONArray appPublicationsArray = jsonObject.getJSONArray("gorm_publication");

            for (int i = 0; i < appPublicationsArray.length(); i++) {

                JSONObject publicationObject = appPublicationsArray.getJSONObject(i);
                long groupId = GroupLocalServiceUtil.getGroup(PortalUtil.getDefaultCompanyId(), "Guest").getGroupId();
                String externalReferenceCode = publicationObject.getString("id");
                String slug = publicationObject.getString("slug");
                String imageUrl = publicationObject.getString("thumbnail_url");

                BlogsEntry blog = BlogsEntryLocalServiceUtil.fetchBlogsEntryByExternalReferenceCode(externalReferenceCode, groupId);
                String fileName = getFileName(imageUrl);

                if (blog == null) {
                    System.out.println("***ERROR Blog " + externalReferenceCode + " does not exist.");
                } else {
                    if (fileName == null) {
                        System.out.println("***ERROR Blog " + externalReferenceCode + " has no image.");
                    } else {
                        DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.fetchFileEntry(GROUP_ID, FOLDER_ID, fileName);
                        if (fileEntry != null) {
                            blog.setCoverImageFileEntryId(fileEntry.getFileEntryId());

                            blog = BlogsEntryLocalServiceUtil.updateBlogsEntry(blog);
                            System.out.println("***Image " + fileName + " added to blog " + externalReferenceCode);
                        } else {
                            System.out.println("***ERROR Image " + fileName + "  not found for blog " + externalReferenceCode);
                        }
                    }


                    if (slug != null && !slug.isBlank()) {
                        long classNameId = PortalUtil.getClassNameId(BlogsEntry.class.getName());
                        long classPK = blog.getEntryId();

                        ServiceContext serviceContext = new ServiceContext();
                        try {
                            // Añadir la URL amigable
                            FriendlyURLEntryLocalServiceUtil.addFriendlyURLEntry(
                                    groupId,
                                    classNameId,
                                    classPK,
                                    slug,
                                    serviceContext
                            );

                            System.out.println("***Updated blog " + externalReferenceCode + " with the following friendly url: " + slug);
                        } catch (Exception e) {
                            System.out.println("***ERROR Blog " + externalReferenceCode + " cannot have the following friendly url: " + slug);
                        }
                    }


                }


            }
            System.out.println("Images imported");
        } catch (SystemException | IOException e) {
            e.printStackTrace();
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }


    }


    private String getFileName(String url) {
        if (url == null || url.isBlank()) {
            return null;
        } else {
            String res = "";
            String[] splitedUrl = url.split("/");

            res = splitedUrl[splitedUrl.length - 1].split("\\.")[0];

            return res;
        }
    }
}