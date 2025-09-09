package services;


public interface ImportDataService {

    void allData();

    void users();
    void customFields();

    void roles();

    void assignRolesToUsers();

    void usersDetails();

    void userInterests();

    void plots();

    void categories();

    void messageThemes();

    void publicationThemes();
    void publications();
    void publicationsImages();
    void userImages();

    void permissions();

    void messages();

    void messageTypes();

    void dedications();

    void userDedications();

    void updateCategoriesERC();

    void likes();

    void privatizeMessages();

    void updateIsPasswordSet();
}
