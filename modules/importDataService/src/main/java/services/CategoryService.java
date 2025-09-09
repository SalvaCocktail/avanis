package services;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.portal.kernel.exception.PortalException;

public interface CategoryService {
    AssetCategory getCategoryByLabel(String categoryLabel, long vocabularyId);

    long[] addCategory(String className, long classId, long newCategory);

    void createCategory(String externalReferenceCode, long userId, long companyId, long groupId, long vocabularyId, String categoryLabel) throws PortalException;


    String translateCategory(String category);
}
