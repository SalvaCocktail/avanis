package hubspot.usecase;

import hubspot.model.forms.IsSubscribedFormProperties;
import hubspot.service.api.HubspotService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = SendFormIsSubscribedUseCase.class,
        property = {
                "osgi.command.scope=hubspotService",
                "osgi.command.function=isSubscribed"})
public class SendFormIsSubscribedUseCase {

    @Reference
    private HubspotService hubspotService;

    String subscriptionId = "318144747";
    public void isSubscribed(){
        System.out.println("SendFormIsSubscribedUseCase");
    }

    public boolean execute(IsSubscribedFormProperties isSubscribedFormProperties){
        return hubspotService.isSubscribed(isSubscribedFormProperties.getEmail(),subscriptionId);
    }
}
