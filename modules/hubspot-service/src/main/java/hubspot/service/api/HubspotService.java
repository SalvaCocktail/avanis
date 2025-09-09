package hubspot.service.api;

import hubspot.model.mails.HubspotEmail;

import java.util.List;

/**
 * @author josehermo
 */
public interface HubspotService {
    void sendFormData(String data, String portalId, String formGuid);
    void subscribeNewsletter(String email, String subscriptionId);
    void unsubscribeNewsletter(String email, String subscriptionId);
    void sendMail(HubspotEmail email);
    boolean isSubscribed(String email, String subscriptionId);
    boolean isRenewingSubscription(String email);
    void formAboutMe(String userEmail, String dedication, String agriculture, String stockBreeding, String sales,
                     String transforming, String techAgrotech, String startups, String other,
                     List<String> agricultureActivity, List<String> stockBreedingActivity);

    void formInterest(String userEmail, List<String> agricultureInterest, List<String> stockBreedingInterest, List<String> otherInterest);
}