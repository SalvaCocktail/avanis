package hubspot.usecase;

import hubspot.model.forms.SignupRequestFormProperties;
import hubspot.service.api.HubspotService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Component(immediate = true, service = SendFormsUseCase.class,
        property = {
                "osgi.command.scope=hubspotService",
                "osgi.command.function=sendForms"})
public class SendFormsUseCase {

    @Reference
    private HubspotService hubspotService;

    public void sendForms(){
        System.out.println("Sending forms");
        formSignupUser("testing@test.com");
    }

     void formSignupRequest(SignupRequestFormProperties signupRequestFormProperties){
        String portalId = "144059530";
        String formGuid = "c8a77855-cc41-4756-823f-353bd4e18abd";
        String data = "{" +
                "\"fields\":[" +
                addDataEmail(signupRequestFormProperties.getUsername()) +
                addDataString("firstname", signupRequestFormProperties.getName()) +
                addDataString("lastname", signupRequestFormProperties.getSurnames()) +
                addDataString("phone", signupRequestFormProperties.getPhone()) +
                addDataString("consentimiento_newsletter", signupRequestFormProperties.isAllowNewsLetter() ? "SI" : "NO") +
                addDataString("crear_cuenta___formulario_1", "SI") +
                addDataString("enlace_univoco_de_registro", signupRequestFormProperties.getSignUpUrl()) +
                addDataString("fecha_registro___paso_0", getDateAsStringFormated(new Date())) +
                "]" +
                "}";
        hubspotService.sendFormData(data,portalId,formGuid);
    }

    public void formSignupUser(String email){
        String portalId = "144059530";
        String formGuid= "9d27296d-ff45-4d7a-82ba-50c5b02c5891";
        String data = "{ " +
                "\"fields\":[" +
                addDataEmail(email) +
                addDataString("informacion_sobre_la_cuenta", "SI") +
                addDataString("fecha_validacion_cuenta", getDateAsStringFormated(new Date()))+
                "]" +
                "}";
        hubspotService.sendFormData(data,portalId,formGuid);
    }

    public void fromRenewingNewsletter (String email){
       String portalId= "144059530";
       String formGuid= "c8a77855-cc41-4756-823f-353bd4e18abd";
       String data ="{ " +
               "\"fields\":[" +
               addDataEmail(email) +
               addDataString("consentimiento_newsletter", "RESUSCRIBIR") +
               "]" +
               "}";
        hubspotService.sendFormData(data,portalId,formGuid);
    }

    public void formLoginUser(String email, String userId){
        String portalId = "144059530";
        String formGuid = "8e49d99f-6a5c-4e17-be66-a1797211dab4";
        String data = "{ " +
                "\"fields\":[" +
                addDataEmail(email) +
                addDataString("id_usuario", userId) +
                addDataString("fecha_ultimo_login", getDateAsStringFormated(new Date()))+
                "]" +
                "}";
        hubspotService.sendFormData(data,portalId,formGuid);
    }



    private String getDetailsAndInterests(Set<String> agricultureDetailsTheme, Set<String> stockbreedingDetailsTheme,
                                                 Set<String> agricultureInterestsTheme, Set<String> stockbreedingInterestsTheme, Set<String> otherInterests) {
        StringBuilder result = new StringBuilder();
        if (agricultureDetailsTheme != null && !agricultureDetailsTheme.isEmpty())
            result.append(addDataFromThemes(agricultureDetailsTheme, "subcategoria_agricultura___actividad___all"));
        if (stockbreedingDetailsTheme != null && !stockbreedingDetailsTheme.isEmpty())
            result.append(addDataFromThemes(stockbreedingDetailsTheme, "subcategoria_ganaderia___actividad___all"));
        if (agricultureInterestsTheme != null && !agricultureInterestsTheme.isEmpty())
            result.append(addDataFromThemes(agricultureInterestsTheme, "agricultura___interes___all"));
        if (stockbreedingInterestsTheme != null && !stockbreedingInterestsTheme.isEmpty())
            result.append(addDataFromThemes(stockbreedingInterestsTheme, "ganaderia___interes___all"));
        if (otherInterests != null && !otherInterests.isEmpty())
            result.append(addDataFromCategories(otherInterests, "otros_interes___all"));
        return result.toString();
    }

    private String addDataFromThemes(Set<String> themes, String name){
        StringBuilder result = new StringBuilder();
        themes.forEach( theme ->
        {
            if(result.length()==0) result.append(theme);
            else result.append(",").append(theme);
        });
        return addDataString(name, result.toString());
    }


    private String  addDataFromCategories(Set<String> categories, String name){
        StringBuilder result = new StringBuilder();
        categories.forEach( category ->
        {
            if(result.length()==0) result.append(category);
            else result.append(",").append(category);
        });
        return addDataString(name, result.toString());
    }

    private String getDedicationData(List<String> dedication) {
        StringBuilder result = new StringBuilder();
        result.append(addDataString("agricoltura___actividad",dedication.contains("agriculture") ? "SI" : "NO" ));
        result.append(addDataString("ganaderia___actividad",dedication.contains("stockbreeding") ? "SI" : "NO" ));
        result.append(addDataString("venta_de_productos_o_servicios___actividad",dedication.contains("sale-of-products-or-services") ? "SI" : "NO" ));
        result.append(addDataString("industria_transformadora___actividad",dedication.contains("transforming-industry") ? "SI" : "NO" ));
        result.append(addDataString("startups__tecnologia_y_agrotech___actividad",dedication.contains("technology-and-agrotech") ? "SI" : "NO" ));
        result.append(addDataString("startups___actividad",dedication.contains("startups") ? "SI" : "NO" ));
        result.append(addDataString("otro_sectores___actividad",dedication.contains("other") ? "SI" : "NO" ));
        return result.toString();
    }

    private String addDataEmail(String email){
        return "{" +
                "\"objectTypeId\": \"0-1\"," +
                "\"name\": \"email\"," +
                "\"value\": \""+email+"\""+
                "}";
    }

    private String addDataString(String name, String value){
        return value.isBlank() ? "" :
                ",{\n" +
                "\"objectTypeId\": \"0-1\",\n" +
                "\"name\": \" "+ name+"\",\n" +
                "\"value\": \" "+value+"\"\n" +
                "}";
    }
    private String getDateAsStringFormated(Date date ){
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        return df.format(date);
    }
}
