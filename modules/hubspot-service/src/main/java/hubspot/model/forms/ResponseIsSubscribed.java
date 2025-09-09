package hubspot.model.forms;

import java.util.List;

public class ResponseIsSubscribed {
    String recipient;
    List<SubscriptionStatus> subscriptionStatuses;

    public String getRecipient() {
        return recipient;
    }

    public List<SubscriptionStatus> getSubscriptionStatuses() {
        return subscriptionStatuses;
    }
}
