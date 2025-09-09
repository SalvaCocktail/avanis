package avanis.compartir.email.portlet.portlet;

import avanis.compartir.email.portlet.constants.AvanisCompartirEmailPortletKeys;
import avanis.compartir.email.portlet.hubspot.HubspotService;
import avanis.utils.api.util.AvanisUtils;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.model.DDMFormField;
import com.liferay.dynamic.data.mapping.model.Value;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.service.MBMessageLocalServiceUtil;
import com.liferay.message.boards.util.MBUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.xml.Document;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author jesusblasco
 */
@Component(
        property = {
                "javax.portlet.version=3.0",
                "com.liferay.portlet.display-category=avanis",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "com.liferay.portlet.add-default-resource=true",
                "javax.portlet.display-name=AvanisCompartirEmail",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + AvanisCompartirEmailPortletKeys.AVANISCOMPARTIREMAIL,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class AvanisCompartirEmailPortlet extends MVCPortlet {

    @Reference
    HubspotService _hubspotService;

    @Reference
    private AvanisUtils _avanisUtils;

    private final Log _log = LogFactoryUtil.getLog(AvanisCompartirEmailPortlet.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String resourceName = renderRequest.getRenderParameters().getValue("resourceName");
        String resourceId = renderRequest.getRenderParameters().getValue("resourceId");
        String url = renderRequest.getRenderParameters().getValue("url");

        renderRequest.setAttribute("resourceName", resourceName);
        renderRequest.setAttribute("resourceId", resourceId);
        renderRequest.setAttribute("url", url);
        try {
            User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
            renderRequest.setAttribute("usermail", user.getEmailAddress());
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }

        super.doView(renderRequest, renderResponse);
    }

    @Override
    public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {

        //obtener url de la publicacion
        _log.info("Entra el process action de compartir");
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        try {
            String resourceName = ParamUtil.getString(actionRequest, "resourceName");
            long resourceId = ParamUtil.getLong(actionRequest, "resourceId", 0);

            switch (resourceName) {
                case "MBMessage":
                    MBMessage message = MBMessageLocalServiceUtil.getMessage(resourceId);
                    sendShareEmail(message, themeDisplay, actionRequest);
                    break;
                case "AyudasSubvenciones":
                    JournalArticle journalArticle = JournalArticleLocalServiceUtil.getArticle(themeDisplay.getScopeGroupId(), String.valueOf(resourceId));
                    sendShareEmail(journalArticle, themeDisplay, actionRequest);
                    break;
                case "Eventos":
                    CalendarBooking calendarBooking = CalendarBookingLocalServiceUtil.getCalendarBooking(resourceId);
                    sendShareEmail(calendarBooking, themeDisplay, actionRequest);
                    break;
                default:
                    BlogsEntry blogEntry = BlogsEntryLocalServiceUtil.getEntry(themeDisplay.getScopeGroupId(),
                            getTitleByUrl(themeDisplay.getURLCurrent()));
                    sendShareEmail(blogEntry, themeDisplay, actionRequest);
                    break;
            }
        } catch (PortalException e) {
            _log.error("Excepción compartiendo noticia", e);
            throw new RuntimeException(e);
        }
    }

    public static String getTitleByUrl(String url) {
        if (url == null || url.isEmpty()) {
            return null;
        }
        String[] parts = url.split(StringPool.SLASH);
        // Devolver la última parte de la cadena
        String subCadena = parts[parts.length - 1];
        if (parts[parts.length - 1].contains(StringPool.QUESTION)) {
            String[] partstmp = subCadena.split("\\?");
            subCadena = partstmp[0];
        }
        return subCadena;
    }

    private void sendShareEmail(CalendarBooking calendarBooking, ThemeDisplay themeDisplay, PortletRequest portletRequest) throws PortalException {
        String url = ParamUtil.getString(portletRequest, "url");

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");

        String eventName = calendarBooking.getTitle(themeDisplay.getLocale());
        String eventDay = dateFormat.format(new Date(calendarBooking.getStartTime()));

        String eventHour;
        if(calendarBooking.isAllDay()){
            eventHour = "Todo el día";
        } else {
            eventHour = timeFormat.format(new Date(calendarBooking.getStartTime()));
        }

        String eventType = getEventType(calendarBooking);
        String eventLocation = calendarBooking.getLocation();

        String eventUrl;
        if(Validator.isNotNull(url)){
            eventUrl = url + "?eventTitle=" + (String) calendarBooking.getExpandoBridge().getAttribute("event_url");
        } else {
            eventUrl = PortalUtil.getPortalURL(themeDisplay) + themeDisplay.getURLCurrent();
        }
        _log.debug("subsidyUrl: " + eventUrl);

        String userEmail = UserLocalServiceUtil.getUser(themeDisplay.getUserId()).getEmailAddress();
        String emails = ParamUtil.getString(portletRequest, "emails");
        String shareMsg = _avanisUtils.sanitizeInputSimpleText(ParamUtil.getString(portletRequest, "mensaje"));
        _log.info("shareMsg -> "+shareMsg);

        _log.info("Se va a enviable el evento calendar : " + eventName + " a emails: " + emails);

        String[] emailList = emails.split(",");
        for (String s : emailList) {
            if (s == null || s.isEmpty()) break;
            Thread thread = new Thread(() -> {
                _log.info("Enviando la noticia a " + s);
                _hubspotService.sendShareEventEmailUseCase(eventName, eventDay, eventHour, eventType, eventUrl, eventLocation, shareMsg, userEmail,
                        s);
            });
            thread.start();
        }
    }
    private void sendShareEmail(JournalArticle journalArticle, ThemeDisplay themeDisplay, PortletRequest portletRequest) throws PortalException {
        String url = ParamUtil.getString(portletRequest, "url");
        String subsidyName = journalArticle.getTitle();

        //Document document = journalArticle.getDocument();
        String subsidyDate = "";
        String subsidyAmount = "";
        String subsidyOrg = "";

        DDMFormValues jaDDMFormValues = journalArticle.getDDMFormValues();
        List<DDMFormFieldValue> dDMFormFieldValues = jaDDMFormValues.getDDMFormFieldValues();
        for (DDMFormFieldValue ddmFormFieldValue : dDMFormFieldValues) {
            if("fechaInicioSolicitud".equals(ddmFormFieldValue.getFieldReference())) {
                Value value = ddmFormFieldValue.getValue();
                subsidyDate = value.getString(themeDisplay.getLocale());
                DDMFormField dDMFormField = ddmFormFieldValue.getDDMFormField();
                Map<String, Object> properties = dDMFormField.getProperties();
                DDMFormValues dDMFormValues = ddmFormFieldValue.getDDMFormValues();
                DDMForm DDMForm = dDMFormValues.getDDMForm();
            }
            if("montos".equals(ddmFormFieldValue.getFieldReference())) {
                Value value = ddmFormFieldValue.getValue();
                subsidyAmount = value.getString(themeDisplay.getLocale());
            }
            if("entidad".equals(ddmFormFieldValue.getFieldReference())) {
                Value value = ddmFormFieldValue.getValue();
                subsidyOrg = value.getString(themeDisplay.getLocale());
            }
        }

        String subsidyUrl;
        if(Validator.isNotNull(url)){
            subsidyUrl = url;
        } else {
            //Layout layout = journalArticle.getLayout();
            //String friendlyURL = layout.getFriendlyURL(themeDisplay.getLocale());
            subsidyUrl = PortalUtil.getPortalURL(themeDisplay) + themeDisplay.getURLCurrent();
        }
        _log.debug("subsidyUrl: " + subsidyUrl);

        AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(JournalArticle.class.getName(), journalArticle.getResourcePrimKey());
        List<AssetCategory> assetCategoriyList = assetEntry.getCategories();
        String[] assetCategoriyNameList = new String[assetCategoriyList.size()];
        for (int i = 0; i < assetCategoriyNameList.length; i++) {
            AssetCategory assetCategory = assetCategoriyList.get(i);
            assetCategoriyNameList[i] = assetCategory.getName();
        }
        String subsidyCategories = String.join(",",assetCategoriyNameList);

        String userEmail = UserLocalServiceUtil.getUser(themeDisplay.getUserId()).getEmailAddress();
        String emails = ParamUtil.getString(portletRequest, "emails");
        String message = _avanisUtils.sanitizeInputSimpleText(ParamUtil.getString(portletRequest, "mensaje"));
        _log.info("message -> "+message);

        _log.info("Se va a enviar subsidy: " + subsidyName + " a emails: " + emails);

        String[] emailList = emails.split(",");
        for (String s : emailList) {
            if (s == null || s.isEmpty()) break;
            String finalSubsidyOrg = subsidyOrg;
            String finalSubsidyAmount = subsidyAmount;
            String finalSubsidyDate = subsidyDate;
            Thread thread = new Thread(() -> {
                _log.info("Enviando la noticia a " + s);
                _hubspotService.sendShareSubsidyEmailUseCase(subsidyName, finalSubsidyDate, finalSubsidyAmount, subsidyCategories, finalSubsidyOrg, subsidyUrl, message, userEmail,
                        s);

            });
            thread.start();
        }
    }

    private void sendShareEmail(BlogsEntry blogEntry, ThemeDisplay themeDisplay, PortletRequest portletRequest) throws PortalException {
        String newsTitle = blogEntry.getTitle();
        String newsSubtitle = blogEntry.getSubtitle();
        Date datePublishes = blogEntry.getDisplayDate();
        String imgUrl = blogEntry.getSmallImageURL(themeDisplay);
        String publicationUrl = themeDisplay.getURLCurrent();
        String originalUserEmail = UserLocalServiceUtil.getUser(themeDisplay.getUserId()).getEmailAddress();

        // Nueva variable para evitar modificar userEmail directamente, ya que es usada en expresion lambda y al tener que ser final no se puede modificar
        final String userEmail = "default@liferay.com".equals(originalUserEmail) ? "Avanis" : originalUserEmail;
        String emails = ParamUtil.getString(portletRequest, "emails");
        String message = _avanisUtils.sanitizeInputSimpleText(ParamUtil.getString(portletRequest, "mensaje"));
        _log.info("message -> "+message);

        _log.info("Se va a enviar la noticia" + newsTitle + " a emails: " + emails);

        String[] emailList = emails.split(",");
        for (String s : emailList) {
            if (s == null || s.isEmpty()) break;
            Thread thread = new Thread(() -> {
                _log.info("Enviando la noticia a " + s);
                _hubspotService.sendShareNewsEmailUseCase(newsTitle, newsSubtitle, datePublishes.toInstant(), imgUrl, publicationUrl, message, userEmail,
                        s);

            });
            thread.start();
        }

    }

    private void sendShareEmail(MBMessage mbMessage, ThemeDisplay themeDisplay, PortletRequest portletRequest) throws PortalException {
        String visibility = getVisibility(mbMessage);
        if ("public".equals(visibility)) {

            User author = UserLocalServiceUtil.getUser(mbMessage.getUserId());
            String replyUsername = author.getScreenName();
            String msgBody = mbMessage.getBody();
            if(Validator.isNotNull(msgBody)){
                msgBody = msgBody.replace("&quot;\n", "&quot; ").replace("&quot;", "\"").replace("&amp;", "&");
            }
            if (mbMessage.isFormatBBCode()) {
                msgBody = MBUtil.getBBCodeHTML(msgBody, themeDisplay.getPathThemeImages());
            }
            String replyMessage = String.valueOf(msgBody);
            String messageProfileImage = author.getPortraitURL(themeDisplay);
            String messageURL = PortalUtil.getPortalURL(themeDisplay) + "/comunidad/-/publicaciones/" + mbMessage.getRootMessageId();
            String userEmail = UserLocalServiceUtil.getUser(themeDisplay.getUserId()).getEmailAddress();
            String emails = ParamUtil.getString(portletRequest, "emails");
            String message = _avanisUtils.sanitizeInputSimpleText(ParamUtil.getString(portletRequest, "mensaje"));
            _log.info("message -> "+message);


            String[] emailList = emails.split(",");
            for (String s : emailList) {
                if (s == null || s.isEmpty()) break;
                Thread thread = new Thread(() -> {
                    _log.info("Enviando el mensaje a " + s);
                    _hubspotService.sendShareCommentsEmailUseCase(replyUsername, replyMessage, messageProfileImage, messageURL, message, userEmail, s);

                });
                thread.start();
            }
        }

    }

    private static String getVisibility(MBMessage message) {
        ExpandoBridge expandoBridge = message.getExpandoBridge();
        String visibility;
        String[] visibilities = (String[]) expandoBridge.getAttribute("visibility");

        if (visibilities != null && visibilities.length > 0) {
            visibility = visibilities[0];
        } else {
            visibility = "registered";
        }
        return visibility;
    }

    private static String getEventType(CalendarBooking calendarBooking) {
        ExpandoBridge expandoBridge = calendarBooking.getExpandoBridge();
        String eventType;
        String[] eventTypes = (String[]) expandoBridge.getAttribute("event_type");

        if (eventTypes != null && eventTypes.length > 0) {
            eventType = eventTypes[0];
        } else {
            eventType = "all";
        }
        return eventType;
    }
}
