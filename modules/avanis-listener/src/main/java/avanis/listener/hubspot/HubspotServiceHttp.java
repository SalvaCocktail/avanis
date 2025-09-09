package avanis.listener.hubspot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.dynamic.data.mapping.model.LocalizedValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.journal.model.JournalArticle;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.util.PropsUtil;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component(immediate = true, service = HubspotService.class)
public class HubspotServiceHttp implements HubspotService{

    private  final String HUBSPOT_API_KEY = PropsUtil.get("hubspot.apiKey");
    private  final ObjectMapper jacksonMapper = new ObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    private  final Log _log = LogFactoryUtil.getLog(HubspotServiceHttp.class);
    private  final String ENVIRONMENT = PropsUtil.get("portal.environment");
    private  final String BASE_URL = PropsUtil.get("hubspot.baseUrl");

    public  void sendMail(HubspotEmail email) {
        try {
            String url = BASE_URL+"/email/public/v1/singleEmail/send";
            String data = jacksonMapper.writeValueAsString(email);
            _log.info("DATA -> "+data);
            _log.info("Sending email to " + url);
            String filteredData = data.replaceAll(",\"\\w+\":null", "");
            String filteredData2 = filteredData.replaceAll("\\{\"\\w+\":null,", "{");
            sendPostRequest(url, filteredData2);
        } catch (Exception e) {
            _log.error("There was an error while sending a mail", e);
        }
    }

    @Override
    public void sendEmailNotificacionAyudaVencimiento(User user, JournalArticle model, String fechaFinSolicitudStr, Long diasRestantes, String explotacionName) {
        _log.debug("Inicio sendEmailNotificacionAyudaVencimiento()");
        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "110271183044";


        HubspotEmail email = new HubspotEmail(emailId,
            new EmailProperties("Avanis <hola@avanis.es>", user.getEmailAddress()),

            Arrays.asList(
                    new CustomPropertyEmail("environment", subjectPrefix),
                    new CustomPropertyEmail("userName", user.getFullName()),
                    new CustomPropertyEmail("nombreAyuda", model.getTitle()),
                    new CustomPropertyEmail("fechaVencimiento", fechaFinSolicitudStr),
                    new CustomPropertyEmail("diasRestantes", String.valueOf(diasRestantes)),
                    new CustomPropertyEmail("date", fechaFinSolicitudStr),
                    new CustomPropertyEmail("nombreParcela", explotacionName)
                    )
        );
        sendMail(email);
        _log.debug("Fin sendEmailNotificacionAyudaVencimiento()");
    }

    @Override
    public void sendEmailNotificacionAyudaNueva(User user, JournalArticle model, String explotacionName, String urlSitio) {
        _log.debug("Inicio sendEmailNotificacionAyudaVencimiento()");
        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "110270494686";
        String fechaInicio = StringPool.BLANK;
        String montos = StringPool.BLANK;
        String entidad = StringPool.BLANK;
        String beneficiario = StringPool.BLANK;
        String entryURL = urlSitio + "/w/" + model.getUrlTitle();

        try {
            DDMFormValues ddmFormValues = model.getDDMFormValues();

            if (ddmFormValues != null) {
                List<DDMFormFieldValue> ddmFormFieldValues = ddmFormValues.getDDMFormFieldValues();

                for (DDMFormFieldValue fieldValue : ddmFormFieldValues) {
                    if (fieldValue.getFieldReference().equals("fechaInicioSolicitud")) {
                        LocalizedValue localizedValue = (LocalizedValue) fieldValue.getValue();
                        fechaInicio = formatearFecha(localizedValue.getString(LocaleUtil.fromLanguageId(model.getDefaultLanguageId())));
                    }else if (fieldValue.getFieldReference().equals("montos")) {
                        LocalizedValue localizedValue = (LocalizedValue) fieldValue.getValue();
                        montos = localizedValue.getString(LocaleUtil.fromLanguageId(model.getDefaultLanguageId()));
                    }else if (fieldValue.getFieldReference().equals("entidad")) {
                        LocalizedValue localizedValue = (LocalizedValue) fieldValue.getValue();
                        entidad = localizedValue.getString(LocaleUtil.fromLanguageId(model.getDefaultLanguageId()));
                    }else if (fieldValue.getFieldReference().equals("beneficiario")) {
                        LocalizedValue localizedValue = (LocalizedValue) fieldValue.getValue();
                        beneficiario = localizedValue.getString(LocaleUtil.fromLanguageId(model.getDefaultLanguageId()));
                    }
                }
            }
        } catch (Exception e) {
            _log.error("Error obteniendo el campo fechaFinSolicitud", e);
        }


        HubspotEmail email = new HubspotEmail(emailId,
                new EmailProperties("Avanis <hola@avanis.es>", user.getEmailAddress()),

                Arrays.asList(
                        new CustomPropertyEmail("environment", subjectPrefix),
                        new CustomPropertyEmail("userName", user.getFullName()),
                        new CustomPropertyEmail("nombreAyuda", model.getTitle()),
                        new CustomPropertyEmail("fechaAyuda", fechaInicio),
                        new CustomPropertyEmail("montoAyuda", montos),
                        new CustomPropertyEmail("entidad", entidad),
                        new CustomPropertyEmail("tipoBeneficiario", beneficiario),
                        new CustomPropertyEmail("nombreParcela", explotacionName),
                        new CustomPropertyEmail("urlAyuda", entryURL)
                )
        );
        sendMail(email);
        _log.debug("Fin sendEmailNotificacionAyudaVencimiento()");
    }

    @Override
    public void sendEmailNotificacionAyuda(User user, JournalArticle model, String explotacionName, String urlSitio) {
        _log.debug("Inicio sendEmailNotificacionAyudaVencimiento()");
        String subjectPrefix = "production".equals(ENVIRONMENT) ? "[Avanis - ${Environment.current.name}] " : "";
        String emailId = "110272175330";
        String fechaInicio = StringPool.BLANK;
        String fechaFin = StringPool.BLANK;
        String montos = StringPool.BLANK;
        String entidad = StringPool.BLANK;
        String beneficiario = StringPool.BLANK;
        String entryURL = urlSitio + "/w/" + model.getUrlTitle();

        try {
            DDMFormValues ddmFormValues = model.getDDMFormValues();

            if (ddmFormValues != null) {
                List<DDMFormFieldValue> ddmFormFieldValues = ddmFormValues.getDDMFormFieldValues();

                for (DDMFormFieldValue fieldValue : ddmFormFieldValues) {
                    if (fieldValue.getFieldReference().equals("fechaInicioSolicitud")) {
                        LocalizedValue localizedValue = (LocalizedValue) fieldValue.getValue();
                        fechaInicio = formatearFecha(localizedValue.getString(LocaleUtil.fromLanguageId(model.getDefaultLanguageId())));
                    }else if (fieldValue.getFieldReference().equals("montos")) {
                        LocalizedValue localizedValue = (LocalizedValue) fieldValue.getValue();
                        montos = localizedValue.getString(LocaleUtil.fromLanguageId(model.getDefaultLanguageId()));
                    }else if (fieldValue.getFieldReference().equals("entidad")) {
                        LocalizedValue localizedValue = (LocalizedValue) fieldValue.getValue();
                        entidad = localizedValue.getString(LocaleUtil.fromLanguageId(model.getDefaultLanguageId()));
                    }else if (fieldValue.getFieldReference().equals("beneficiario")) {
                        LocalizedValue localizedValue = (LocalizedValue) fieldValue.getValue();
                        beneficiario = localizedValue.getString(LocaleUtil.fromLanguageId(model.getDefaultLanguageId()));
                    }else if (fieldValue.getFieldReference().equals("fechaFinSolicitud")) {
                        LocalizedValue localizedValue = (LocalizedValue) fieldValue.getValue();
                        fechaFin = formatearFecha(localizedValue.getString(LocaleUtil.fromLanguageId(model.getDefaultLanguageId())));
                    }
                }
            }
        } catch (Exception e) {
            _log.error("Error obteniendo el campo fechaFinSolicitud", e);
        }


        HubspotEmail email = new HubspotEmail(emailId,
                new EmailProperties("Avanis <hola@avanis.es>", user.getEmailAddress()),

                Arrays.asList(
                        new CustomPropertyEmail("environment", subjectPrefix),
                        new CustomPropertyEmail("userName", user.getFullName()),
                        new CustomPropertyEmail("nombreAyuda", model.getTitle()),
                        new CustomPropertyEmail("fechaAyuda", fechaInicio),
                        new CustomPropertyEmail("montoAyuda", montos),
                        new CustomPropertyEmail("entidad", entidad),
                        new CustomPropertyEmail("tipoBeneficiario", beneficiario),
                        new CustomPropertyEmail("nombreParcela", explotacionName),
                        new CustomPropertyEmail("fechaTermino", fechaFin),
                        new CustomPropertyEmail("urlAyuda", entryURL)
                )
        );
        sendMail(email);
        _log.debug("Fin sendEmailNotificacionAyudaVencimiento()");
    }

    private HttpResponse<String> sendPostRequest(String uri, String body) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .headers("Content-Type", "application/json", "authorization", "Bearer " + HUBSPOT_API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private String formatearFecha(String fechaInicioSolicitudSTR){
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = inputFormat.parse(fechaInicioSolicitudSTR);

            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy", LocaleUtil.getDefault());
            return outputFormat.format(date);
        } catch (Exception e) {
            return fechaInicioSolicitudSTR;
        }
    }
}
