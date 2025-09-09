package avanis.comunidad.portlet.hubspot;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@JsonSerialize
public class HubspotEmail {
    String emailId;
    EmailProperties message;
    List<CustomPropertyEmail> customProperties;

    public HubspotEmail() {
    }

    public HubspotEmail(String emailId, EmailProperties message, List<CustomPropertyEmail> customProperties) {
        this.emailId = emailId;
        this.message = message;
        this.customProperties = customProperties;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public EmailProperties getMessage() {
        return message;
    }

    public void setMessage(EmailProperties message) {
        this.message = message;
    }

    public List<CustomPropertyEmail> getCustomProperties() {
        return customProperties;
    }

    public void setCustomProperties(List<CustomPropertyEmail> customProperties) {
        this.customProperties = customProperties;
    }
}
