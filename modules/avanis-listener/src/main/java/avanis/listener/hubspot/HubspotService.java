package avanis.listener.hubspot;

import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.model.User;

public interface HubspotService {
    void sendEmailNotificacionAyudaVencimiento(User user, JournalArticle model, String fechaFinSolicitudStr, Long diasrestantes, String explotacionName);

    void sendEmailNotificacionAyudaNueva(User user, JournalArticle model, String explotacionName, String urlSitio);

    void sendEmailNotificacionAyuda(User user, JournalArticle model, String explotacionName, String urlSitio);
}
