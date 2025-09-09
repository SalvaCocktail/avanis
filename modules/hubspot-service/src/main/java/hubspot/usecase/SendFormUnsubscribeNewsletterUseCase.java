package hubspot.usecase;

import hubspot.model.forms.SubscribeNewsletterFormProperties;
import hubspot.service.api.HubspotService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = SendFormUnsubscribeNewsletterUseCase.class,
        property = {
                "osgi.command.scope=hubspotService",
                "osgi.command.function=sendFormUnsubscribeNewsletter"})
public class SendFormUnsubscribeNewsletterUseCase {

    @Reference
    private HubspotService hubspotService;

    String subscriptionId = "318144747";

    public void sendFormUnsubscribeNewsletter(){
        System.out.println("SendFormUnsubscribeNewsletterUseCase");
    }

    public void execute(SubscribeNewsletterFormProperties subscribeNewsletterFormProperties){
        hubspotService.unsubscribeNewsletter(subscribeNewsletterFormProperties.getEmail(), subscriptionId);
    }

}
