package services.impl;

import com.liferay.asset.kernel.exception.DuplicateCategoryException;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import org.osgi.service.component.annotations.Component;
import services.CategoryService;

import java.util.*;

@Component(service = CategoryService.class)
public class CategoryServiceImpl implements CategoryService {

    @Override
    public AssetCategory getCategoryByLabel(String categoryLabel, long vocabularyId) {
        try {
            String translatedCategoryLabel = this.translateCategory(categoryLabel);
            List<AssetCategory> categories = AssetCategoryLocalServiceUtil.getVocabularyCategories(
                    vocabularyId, 0, Integer.MAX_VALUE, null
            );

            for (AssetCategory category : categories) {
                if (category.getTitle(LocaleUtil.getDefault()).equalsIgnoreCase(translatedCategoryLabel)) {
                    return category;
                }
            }
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return null;
    }

    public long[] addCategory(String className, long classId, long newCategory) {
        long[] currentCategoryIdsPrimitive = AssetCategoryLocalServiceUtil.getCategoryIds(
                className, classId
        );

        Long[] currentCategoryIds = Arrays.stream(currentCategoryIdsPrimitive).boxed().toArray(Long[]::new);

        Set<Long> combinedCategoryIdsSet = new HashSet<>();
        combinedCategoryIdsSet.add(newCategory);
        combinedCategoryIdsSet.addAll(Arrays.asList(currentCategoryIds));


        return combinedCategoryIdsSet.stream().mapToLong(Long::longValue).toArray();

    }


    @Override
    public void createCategory(String externalReferenceCode, long userId, long companyId, long groupId, long vocabularyId, String categoryLabel) throws PortalException {
        if (!categoryAlreadyExist(categoryLabel, vocabularyId)) {
            try {
                ServiceContext serviceContext = createServiceContext(groupId, companyId);

                Locale esLocale = new Locale("es", "ES");
                Locale enLocale = new Locale("en", "US");
                Map<Locale, String> titleMap = new HashMap<>();
                titleMap.put(esLocale, categoryLabel);
                titleMap.put(enLocale, categoryLabel);

                AssetCategory category = AssetCategoryLocalServiceUtil.addCategory(
                        externalReferenceCode,
                        userId,
                        groupId,
                        0,
                        titleMap,
                        null,
                        vocabularyId,
                        null,
                        serviceContext
                );


                System.out.println("***Category " + categoryLabel + " added with ID: " + category.getCategoryId());

            } catch (DuplicateCategoryException e) {
                System.out.println("***Category already exists: " + categoryLabel);
            }
        }
    }

    @Override
    public String translateCategory(String category) {
        switch (category.toLowerCase()) {

            case "regulations_and_aid":
                return "Normativa y ayudas";
            case "logistics_and_machinery":
                return "Logística y maquinaria";
            case "agriculture":
                return "Agricultura";
            case "stockbreeding":
                return "Ganadería";
            case "innovation-and_development":
                return "Innovación y desarrollo";
            case "commerce_and_market":
                return "Comercio y mercado";
            case "sustainability_and_collaborations":
                return "Sostenibilidad y medio ambiente";
            case "companies_and_collaborations":
                return "Empresas y colaboraciones";
            case "supplies":
                return "Insumos";
            case "pac":
                return "PAC";
            case "legislation":
                return "Legislación";
            case "subsidies":
                return "Subvenciones";
            case "storage_and_tools":
                return "Almacenaje y herramientas";
            case "logistics_vehicles_transport":
                return "Logística, vehículos y transporte";
            case "machinery":
                return "Maquinaria";
            case "maintenance_and_repairs":
                return "Mantenimiento y reparaciones";
            case "fruit_trees":
                return "Frutales";
            case "vineyard":
                return "Viñedos";
            case "olive_grove":
                return "Olivares";
            case "cereals":
                return "Cereales";
            case "legumes":
                return "Leguminosas";
            case "oilseed":
                return "Oleaginosas";
            case "vegetables":
                return "Hortalizas";
            case "tubers":
                return "Tubérculos";
            case "foragers":
                return "Forrajeros";
            case "agriculture_others":
                return "Otros de agricultura";
            case "plant_health":
                return "Sanidad vegetal";
            case "dairy_cattle":
                return "Vacuno de leche";
            case "beef":
                return "Vacuno de carne";
            case "dairy_ovine":
                return "Ovino de leche";
            case "dairy_goat":
                return "Caprino de leche";
            case "porcine":
                return "Porcino";
            case "poultry_farming":
                return "Avicultura";
            case "rabbit_farming":
                return "Cunicultura";
            case "stockbreeding_others":
                return "Otros de ganadería";
            case "animal_health":
                return "Sanidad animal";
            case "digitization":
                return "Digitalización";
            case "research_and_development":
                return "Investigación y desarrollo";
            case "innovation":
                return "Innovación";
            case "buy_and_sell":
                return "Compra y venta";
            case "import_and_export":
                return "Importación y exportación";
            case "ecological_agriculture":
                return "Agricultura ecológica";
            case "rural_development":
                return "Desarrollo rural";
            case "ranchers":
                return "Ganaderos";
            case "agricultural":
                return "Agrícolas";
            case "shelled_fruits":
                return "Frutos de cáscara";
            case "meat_ovine":
                return "Ovino de carne";
            case "meat_goat":
                return "Caprino de carne";
            case "water_reserve":
                return "Reserva hídrica";
            case "meteorology":
                return "Meteorología";
            case "sale-of-products-or-services":
                return "Venta de productos o servicios";
            case "other":
                return "Otros sectores";
            case "technology-and-agrotech":
                return "Tecnología y Agrotech";
            case "transforming-industry":
                return "Industria transformadora";
            case "startups":
                return "Startups";
            case "announcements":
                return "Anuncios";
            case "recommendations":
                return "Recomendaciones";
            case "notices":
                return "Avisos";
            case "news":
                return "Novedades";
            case "collaborations":
                return "Colaboraciones";
            case "questions":
                return "Preguntas";
            default:
                return category;
        }
    }

    private boolean categoryAlreadyExist(String categoryLabel, long vocabularyId) {
        try {
            List<AssetCategory> categories = AssetCategoryLocalServiceUtil.getVocabularyCategories(
                    vocabularyId, 0, Integer.MAX_VALUE, null
            );

            for (AssetCategory category : categories) {
                if (category.getTitle(LocaleUtil.getDefault()).equalsIgnoreCase(categoryLabel)) {
                    System.out.println("***Category " + categoryLabel + " already exists");
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
}
