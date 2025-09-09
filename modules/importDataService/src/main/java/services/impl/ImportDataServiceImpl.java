package services.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import services.*;


@Component(immediate = true,
        property = {
                "osgi.command.scope=importService",
                "osgi.command.function=allData",
                "osgi.command.function=customFields",
                "osgi.command.function=publications",
                "osgi.command.function=publicationsImages",
                "osgi.command.function=userImages",
                "osgi.command.function=messages",
                "osgi.command.function=roles",
                "osgi.command.function=assignRolesToUsers",
                "osgi.command.function=usersDetails",
                "osgi.command.function=userInterests",
                "osgi.command.function=users",
                "osgi.command.function=categories",
                "osgi.command.function=plots",
                "osgi.command.function=messageThemes",
                "osgi.command.function=permissions",
                "osgi.command.function=publicationThemes",
                "osgi.command.function=dedications",
                "osgi.command.function=userDedications",
                "osgi.command.function=updateCategoriesERC",
                "osgi.command.function=messageTypes",
                "osgi.command.function=likes",
                "osgi.command.function=privatizeMessages",
                "osgi.command.function=updateIsPasswordSet"
        },
        service = ImportDataService.class)
public class ImportDataServiceImpl implements ImportDataService {

    @Reference
    ImportRolesService importRolesService;
    @Reference
    ImportUserService importUserService;
    @Reference
    ImportPublicationsService importPublicationsService;
    @Reference
    ImportMessagesService importMessagesService;
    @Reference
    ImportCategoriesService importCategoriesService;
    @Reference
    ImportUserDetailService importUserDetailService;
    @Reference
    ImportUserInterestsService importUserInterestsService;
    @Reference
    ImportPlotsService importPlotsService;
    @Reference
    ImportMessageThemesService importMessageThemesService;
    @Reference
    ImportPublicationThemesService importPublicationThemesService;
    @Reference
    ImportDedicationService importDedicationService;
    @Reference
    ImportLikesService importLikesService;
    @Reference
    ImportCustomFieldsService importCustomFieldsService;
    @Reference
    ImportPublicationImagesService importPublicationImagesService;
    @Reference
    ImportUserImagesService importUserImagesService;
    @Reference
    PrivatizeMessagesService privatizeMessagesService;
    @Reference
    UpdateIsPasswordSetService updateIsPasswordSetService;


    @Override
    public void allData() {
        importCustomFieldsService.importCustomFields();
        importRolesService.importRoles();
        importUserService.importUsers();
        importRolesService.assignRolesToUsers();
        importPublicationsService.importPublications();
        importPublicationImagesService.importPublicationImages();
        importCategoriesService.importCategories();
        importCategoriesService.importMessageTypes();
        importCategoriesService.updateCategoriesExternalReferenceCode();
        importMessagesService.importMessages();
        importUserDetailService.importUserDetails();
        importUserInterestsService.importUserInterests();
        importDedicationService.importDedications();
        importDedicationService.importUserDedications();
        importMessageThemesService.importMessageThemes();
        importPublicationThemesService.importPublicationThemes();
        importPlotsService.importPlotsSB();
        importLikesService.importLikes();
    }

    public void users() {
        importUserService.importUsers();
    }

    @Override
    public void customFields() {
        importCustomFieldsService.importCustomFields();
    }

    public void permissions() {
        importRolesService.setPermissions();
    }

    public void messages() {
        importMessagesService.importMessages();
    }

    @Override
    public void messageTypes() {
        importMessagesService.updateTypes();
    }


    public void categories() {
        importCategoriesService.importCategories();
        importCategoriesService.importMessageTypes();
        importCategoriesService.updateCategoriesExternalReferenceCode();
    }

    public void dedications() {
        importDedicationService.importDedications();
    }

    public void userDedications() {
        importDedicationService.importUserDedications();
    }

    public void usersDetails() {
        importUserDetailService.importUserDetails();
    }

    public void userInterests() {
        importUserInterestsService.importUserInterests();
    }

    @Override
    public void plots() {
        importPlotsService.importPlotsSB();
    }

    public void roles() {
        importRolesService.importRoles();
    }

    public void assignRolesToUsers() {
        importRolesService.assignRolesToUsers();
    }

    public void messageThemes() {
        importMessageThemesService.importMessageThemes();
    }

    public void publicationThemes() {
        importPublicationThemesService.importPublicationThemes();
    }

    @Override
    public void publications() {
        importPublicationsService.importPublications();
    }

    @Override
    public void publicationsImages() {
        importPublicationImagesService.importPublicationImages();
    }

    @Override
    public void userImages() {
        importUserImagesService.importUserImages();
    }

    @Override
    public void updateCategoriesERC() {

        importCategoriesService.updateCategoriesExternalReferenceCode();
    }

    @Override
    public void likes() {
        importLikesService.importLikes();
    }

    @Override
    public void privatizeMessages() {
        privatizeMessagesService.privatizeMessages();
    }

    @Override
    public void updateIsPasswordSet() {
        updateIsPasswordSetService.updateIsPasswordSet();
    }


}