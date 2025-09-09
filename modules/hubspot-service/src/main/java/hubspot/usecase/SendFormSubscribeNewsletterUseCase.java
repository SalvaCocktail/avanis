package hubspot.usecase;

import hubspot.model.forms.SubscribeNewsletterFormProperties;
import hubspot.service.api.HubspotService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = SendFormSubscribeNewsletterUseCase.class,
        property = {
                "osgi.command.scope=hubspotService",
                "osgi.command.function=sendFormSubscribeNewsletter"})
public class SendFormSubscribeNewsletterUseCase {

    @Reference
    private HubspotService hubspotService;

    String subscriptionId = "318144747";

    public void execute(SubscribeNewsletterFormProperties subscribeNewsletterFormProperties){
        hubspotService.subscribeNewsletter(subscribeNewsletterFormProperties.getEmail(), subscriptionId);
    }

}
