package services;


public interface VocabularyService {

    long getOrCreateVocabulary(long groupId);

    long getOrCreateVocabulary(long groupId, String vocabularyName, String associatedAssetType);

    long getOrCreateVocabulary(long groupId, String vocabularyName, String associatedAssetType, Boolean multiValue);
}
