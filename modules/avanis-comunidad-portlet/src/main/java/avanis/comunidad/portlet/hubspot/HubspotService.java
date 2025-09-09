package avanis.comunidad.portlet.hubspot;


import avanis.comunidad.portlet.hubspot.model.email.MentionsAndTagMailProperties;

public interface HubspotService {
    public void sendMentionsAndTag(MentionsAndTagMailProperties mentionsAndTagMailProperties);
}
