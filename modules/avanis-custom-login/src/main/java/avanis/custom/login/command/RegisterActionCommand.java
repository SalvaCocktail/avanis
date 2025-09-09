package avanis.custom.login.command;

import avanis.custom.login.constants.AvanisCustomLoginPortletKeys;
import avanis.custom.login.hubspot.HubspotService;
import avanis.custom.login.utils.RegisterUtil;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name="+ AvanisCustomLoginPortletKeys.AVANISCUSTOMLOGIN,
                "mvc.command.name=/register"
        },
        service = MVCActionCommand.class
)
public class RegisterActionCommand extends BaseMVCActionCommand {

    @Reference
    HubspotService _hubspotService;
    @Reference
    private UserService _userService;

    private static Log _log = LogFactoryUtil.getLog(RegisterActionCommand.class);

    @Override
    protected void doProcessAction(ActionRequest actionRequest,
                                   ActionResponse actionResponse) throws Exception {

        ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String email = ParamUtil.getString(actionRequest, "email");
        String screenName =  ParamUtil.getString(actionRequest, "alias");
        if(!doesUserExist(email, screenName,themeDisplay.getCompanyId())){
            User user = RegisterUtil.createUser(_userService,actionRequest,themeDisplay);
            sendRegisterMail(user, actionRequest, themeDisplay);

            boolean allowNotifications = ParamUtil.getBoolean(actionRequest, "allowNotifications");
            if(allowNotifications){
                saveAllNotificationSettings(user);
            }

            user.setStatus(WorkflowConstants.STATUS_PENDING);
            UserLocalServiceUtil.updateUser(user);
            _log.info("***INFO*** Registered user: " + user.getUserId());
        }
        else {
            if(Validator.isNull(UserLocalServiceUtil.fetchUserByEmailAddress(themeDisplay.getCompanyId(),email))){
                _log.error("***Nombre de usuario ya registrado: " + screenName);
                SessionErrors.add(actionRequest, "alias.existe");
                actionRequest.setAttribute("REDIRECT", "/tipo-registro");
            } else {
                _log.error("***ERROR*** User already exists with email: " + ParamUtil.getString(actionRequest, "email"));
                sendAlreadyRegistered(actionRequest);
            }
        }
        super.sendRedirect(actionRequest, actionResponse);
    }

    public boolean doesUserExist(String emailAddress, String screenName, long companyId ) {

        Boolean usuarioValido = Boolean.FALSE;
        try {
            if(Validator.isNotNull(UserLocalServiceUtil.fetchUserByScreenName(companyId,screenName)) ||
                    Validator.isNotNull(UserLocalServiceUtil.fetchUserByEmailAddress(companyId,emailAddress))){
                _log.info("***Nombre de usuario o mail ya registrados: " + screenName+", "+emailAddress);
                usuarioValido = Boolean.TRUE;
            }
        }catch (Exception e){
            _log.info("***Nombre de usuario o mail no registrados: " + screenName+", "+emailAddress);
        }

        return usuarioValido;
    }

    private static final String SECRET_KEY_TEXT = "(95,U~KhPZpoy>ft)l-*¿Nm/155@VXe$Dc";
    private static final String AES_ALGORITHM = "AES/GCM/NoPadding";
    private static final int IV_SIZE = 12; // 12 bytes para GCM
    private static final int TAG_BIT_LENGTH = 128; // Longitud del tag de autenticación en bits

    public static byte[] generateKey(String text) throws Exception {
        // Convierte el texto a bytes
        byte[] textBytes = text.getBytes(StandardCharsets.UTF_8);

        // Genera un hash SHA-256
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        byte[] hash = sha256.digest(textBytes);

        // Recorta o utiliza el hash directamente, ya que SHA-256 genera exactamente 32 bytes
        return Arrays.copyOf(hash, 32);
    }

    // Método auxiliar para visualizar la clave generada en formato hexadecimal
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static String generateToken(String emailAddress, String keyUser) {
        try {
            // Generar un vector de inicialización (IV)
            SecureRandom secureRandom = new SecureRandom();
            byte[] iv = new byte[IV_SIZE];
            secureRandom.nextBytes(iv);

            // Crear el contenido del token
            long currentTime = System.currentTimeMillis();
            String tokenData = currentTime + ":" + emailAddress + ":" + keyUser;

            byte[] secretKeyBytes  = generateKey(SECRET_KEY_TEXT);

            // Configurar el cifrador
            Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
            SecretKeySpec secretKey = new SecretKeySpec(secretKeyBytes, "AES");
            GCMParameterSpec gcmSpec = new GCMParameterSpec(TAG_BIT_LENGTH, iv);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, gcmSpec);

            // Cifrar los datos
            byte[] encryptedData = cipher.doFinal(tokenData.getBytes(StandardCharsets.UTF_8));

            // Concatenar IV y datos cifrados para formar el token
            byte[] token = new byte[iv.length + encryptedData.length];
            System.arraycopy(iv, 0, token, 0, iv.length);
            System.arraycopy(encryptedData, 0, token, iv.length, encryptedData.length);

            // Codificar el token en Base64
            return Base64.getUrlEncoder().encodeToString(token);
        } catch (Exception e) {
            throw new RuntimeException("Error al generar el token", e);
        }
    }

//    public static String generateToken(String emailAddress, String keyUser) {
//        long currentTime = System.currentTimeMillis();
//        String tokenData = currentTime + ":" + emailAddress+ ":" + keyUser;
//        return Base64.getEncoder().encodeToString(tokenData.getBytes());
//    }

    private void sendRegisterMail(User user, ActionRequest actionRequest, ThemeDisplay themeDisplay){
        String emailAddress = ParamUtil.getString(actionRequest, "email");
        String firstName = ParamUtil.getString(actionRequest, "name");
        String lastName = ParamUtil.getString(actionRequest, "apellidos");
        String keyUser = ParamUtil.getString(actionRequest, "password");
        String phone = ParamUtil.getString(actionRequest, "phone");
        boolean allowNewsletter = ParamUtil.getBoolean(actionRequest, "allowNewsLetter");

        String signupUrl = PortalUtil.getPortalURL(actionRequest)+"/completar-perfil?token="+generateToken(emailAddress, keyUser);
        _hubspotService.sendSignupRequestCreatedEmailUseCase(emailAddress,firstName,signupUrl);
        sendFormsToHubspot(emailAddress, firstName, lastName, phone, allowNewsletter, signupUrl);

    }

    private void saveAllNotificationSettings(User principal) {
        long adminUserId = 20122;
        PermissionChecker originalPermissionChecker = PermissionThreadLocal.getPermissionChecker();

        try {
            User adminUser = UserLocalServiceUtil.getUser(adminUserId);
            PermissionChecker adminPermissionChecker = PermissionCheckerFactoryUtil.create(adminUser);
            PermissionThreadLocal.setPermissionChecker(adminPermissionChecker);
            ExpandoBridge expandoBridge = principal.getExpandoBridge();
            String[] notifications = {
                    "comments", "likes", "surveys_results", "followers",
                    "mentions", "achievements", "ayudas_nuevas", "ayudas_porvencer", "ayudas_reactivacion"
            };

            Arrays.stream(notifications)
                    .forEach(notification -> {
                        expandoBridge.setAttribute(notification + "_notification", "all");
                        _log.info("Actualizada notificación -> " + notification);
                    });

        } catch (Exception e) {
            _log.error("Error al actualizar las notificaciones del usuario -> " + principal.getUserId(), e);
        } finally {
            PermissionThreadLocal.setPermissionChecker(originalPermissionChecker);
            _log.info("Permisos restaurados al estado original.");
        }
    }

    private void sendFormsToHubspot(String email, String firstname, String lastName, String phone, boolean allowNewsletter, String signupUrl) {
        try{
            _hubspotService.formSignupRequest(email,firstname, lastName, phone, allowNewsletter, signupUrl);
            if(allowNewsletter){
                _hubspotService.subscribeNewsletter(email);
            }
        }catch (Exception e){
            //empty if fails not block
        }
    }

    private void sendAlreadyRegistered(ActionRequest actionRequest){
        String emailAddress = ParamUtil.getString(actionRequest, "email");
        String firstName = ParamUtil.getString(actionRequest, "name");
        String url = PortalUtil.getPortalURL(actionRequest);
        _hubspotService.sendUserIsAlreadyRegistered(emailAddress,firstName,url+"/es/login",
                url+"/es/web/guest/login?p_p_id=avanis_custom_login_AvanisCustomLoginPortlet_INSTANCE_dghd&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_avanis_custom_login_AvanisCustomLoginPortlet_INSTANCE_dghd_mvcPath=%2Frequest-reset-password.jsp");
    }


}