package avanis.custom.login.portlet;

import avanis.custom.login.command.RegisterActionCommand;
import avanis.custom.login.constants.AvanisCustomLoginPortletKeys;
import avanis.custom.login.hubspot.HubspotService;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetTagLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.auth.session.AuthenticatedSessionManagerUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author joaquinparrilla
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=avanis",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-javascript=/js/register.js",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=AvanisCustomLogin",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/login_acount.jsp",
		"javax.portlet.name=" + AvanisCustomLoginPortletKeys.AVANISCUSTOMLOGIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AvanisCustomLoginPortlet extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(AvanisCustomLoginPortlet.class);

	private static final String HUBSPOT_SUBSCRIPTION_ID = "318144747";
	private static final String REDIRECT_AFTER_SUBMIT = "/comunidad";
	private static final long EXPIRATION_TIME = TimeUnit.HOURS.toMillis(72); // 72 hours in milliseconds
	private static final String SECRET_KEY_TEXT = "(95,U~KhPZpoy>ft)l-*¿Nm/155@VXe$Dc";
	private static final String AES_ALGORITHM = "AES/GCM/NoPadding";
//	private static final long EXPIRATION_TIME = 15 * 60 * 1000; // 15 minutos en milisegundos


	@Reference
	private HubspotService hubspotService;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		HttpServletResponse httpRes = PortalUtil.getHttpServletResponse(renderResponse);
		//String tempToken = RegisterActionCommand.generateToken("test@gmail.com","Tomacastanya2");
		boolean rememberMe = ParamUtil.getBoolean(renderRequest, "rememberMe");
		String tempToken = httpReq.getParameter("token");

		loadPreferences(themeDisplay.getUser(), renderRequest);
		String urlsessionGoogle = PropsUtil.get("google.login.url");
		String jspRedirect = null;
		renderRequest.setAttribute("URL", themeDisplay.getURLCurrent());
		renderRequest.setAttribute("URLPortal", themeDisplay.getURLPortal());
		renderRequest.setAttribute("urlsessionGoogle", urlsessionGoogle);
		renderRequest.setAttribute("token", tempToken);
		renderRequest.setAttribute("tokenvalid", validateToken(tempToken));

		try {
			if(!Validator.isNotNull(tempToken)){
				if (themeDisplay.getURLCurrent().contains("tipo-registro")) {
					jspRedirect = "/register_acount.jsp";
				}else if (themeDisplay.getURLCurrent().contains("completar-perfil")) {
					jspRedirect = "/register_acount_steps.jsp";
				}else if (themeDisplay.getURLCurrent().contains("reset-pass")) {
					jspRedirect = "/request-reset-password.jsp";
				}else if (themeDisplay.getURLCurrent().contains("generar-nueva-pass")) {
					jspRedirect = "/reset-pass.jsp";
				} else if (themeDisplay.getURLCurrent().contains("reset-two-pass")) {
					jspRedirect = "/reset-two-password.jsp";
				}else if (themeDisplay.getURLCurrent().contains("tipo-registro")) {
					jspRedirect = "/tipo-registro.jsp";
				}
			}else {
				if(validateToken(tempToken) && validateTokenEmail(tempToken)){
					_log.info("***token valido doView***");
					String email = getEmailbyToken(tempToken);
					String pass =  getUserKeybyToken(tempToken);
					String authType = CompanyConstants.AUTH_TYPE_EA;
					if(validateTokenKey(tempToken) && themeDisplay.getURLCurrent().contains("completar-perfil")){
						User user = UserLocalServiceUtil.getUser(UserLocalServiceUtil.getUserIdByEmailAddress(
								themeDisplay.getCompanyId(), email));
						user.setStatus(WorkflowConstants.STATUS_APPROVED);
						try{
							hubspotService.formSignupUser(user.getEmailAddress());
						} catch (Exception e){
							_log.error("Falla el envío de signupForm a hubspot");
							//No bloqueamos si falla el envío a hubspot, que siga ejecutando.
						}
						UserLocalServiceUtil.updateUser(user);
						AuthenticatedSessionManagerUtil.login(
								httpReq, httpRes, email, pass,
								true, authType);

						jspRedirect = "/register_acount_steps.jsp";
					}else if (themeDisplay.getURLCurrent().contains("generar-nueva-pass") && validateToken(tempToken)){
						jspRedirect = "/reset-pass.jsp";
					}
				}else {
					renderRequest.setAttribute("tokenvalid", false);
				}
			}
		} catch (Exception e) {
			_log.error("***ERROR*** Procesado customLogin: ", e);
		}

		if(Validator.isNotNull(jspRedirect)){
			getPortletContext().getRequestDispatcher(jspRedirect).include(
					renderRequest, renderResponse);
		}

		super.doView(renderRequest, renderResponse);
	}

	// Validar si el token es válido basado en el tiempo de expiración
	public static boolean validateToken(String token) {
		try {
			if (token == null) return false;
			String decodedToken = decryptToken(token);
			String[] parts = decodedToken.split(":");
			long tokenTime = Long.parseLong(parts[0]);

			long currentTime = System.currentTimeMillis();
			return (currentTime - tokenTime) <= EXPIRATION_TIME;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Validar si el correo electrónico incluido en el token es válido
	public static boolean validateTokenEmail(String token) {
		try {
			if (token == null) return false;
			String decodedToken = decryptToken(token);
			String[] parts = decodedToken.split(":");
			String email = parts[1];
			return Validator.isEmailAddress(email);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Obtener el correo electrónico del token
	public static String getEmailbyToken(String token) {
		try {
			String decodedToken = decryptToken(token);
			String[] parts = decodedToken.split(":");
			return parts[1];
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Validar si la clave del usuario incluida en el token es válida
	public static boolean validateTokenKey(String token) {
		try {
			if (token == null) return false;
			String decodedToken = decryptToken(token);
			String[] parts = decodedToken.split(":");
			String keyUser = parts[2];
			return Validator.isNotNull(keyUser);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Obtener la clave del usuario del token
	public static String getUserKeybyToken(String token) {
		try {
			String decodedToken = decryptToken(token);
			String[] parts = decodedToken.split(":");
			return parts[2];
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// Método para descifrar el token
	private static String decryptToken(String token) throws Exception {
		if (token == null || token.isEmpty()) {
			throw new IllegalArgumentException("Token no puede ser nulo o vacío");
		}

		try {
			// Decodificar el token desde Base64 (usando URL-safe decoder)
			byte[] tokenWithIv = Base64.getUrlDecoder().decode(token);

			// Extraer IV (los primeros 12 bytes)
			byte[] iv = new byte[12];
			System.arraycopy(tokenWithIv, 0, iv, 0, iv.length);

			// Extraer los datos cifrados
			byte[] encryptedData = new byte[tokenWithIv.length - iv.length];
			System.arraycopy(tokenWithIv, iv.length, encryptedData, 0, encryptedData.length);

			// Generar la clave secreta
			byte[] secretKeyBytes = RegisterActionCommand.generateKey(SECRET_KEY_TEXT);
			SecretKeySpec secretKey = new SecretKeySpec(secretKeyBytes, "AES");

			// Configurar el descifrado
			Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
			GCMParameterSpec gcmSpec = new GCMParameterSpec(128, iv);
			cipher.init(Cipher.DECRYPT_MODE, secretKey, gcmSpec);

			// Descifrar los datos
			byte[] decryptedData = cipher.doFinal(encryptedData);

			return new String(decryptedData, StandardCharsets.UTF_8);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("El token contiene caracteres Base64 no válidos", e);
		} catch (Exception e) {
			throw new Exception("Error al descifrar el token", e);
		}
	}

//	public static boolean validateToken(String token) {
//		if(token == null) return false;
//		String decodedToken = new String(Base64.getDecoder().decode(token));
//		String[] parts = decodedToken.split(":");
//		long tokenTime = Long.parseLong(parts[0]);
//
//		long currentTime = System.currentTimeMillis();
//		return (currentTime - tokenTime) <= EXPIRATION_TIME;
//	}
//
//	public static boolean validateTokenEmail(String token) {
//		if(token == null) return false;
//		String decodedToken = new String(Base64.getDecoder().decode(token));
//		String[] parts = decodedToken.split(":");
//		String email = parts[1];
//		return Validator.isEmailAddress(email);
//	}
//
//	public static String getEmailbyToken(String token) {
//		String decodedToken = new String(Base64.getDecoder().decode(token));
//		String[] parts = decodedToken.split(":");
//		String email = parts[1];
//		return email;
//	}
//
//	public static boolean validateTokenKey(String token) {
//		if(token == null) return false;
//		String decodedToken = new String(Base64.getDecoder().decode(token));
//		String[] parts = decodedToken.split(":");
//		String keyUser = parts[2];
//		return Validator.isNotNull(keyUser);
//	}
//
//	public static String getUserKeybyToken(String token) {
//		String decodedToken = new String(Base64.getDecoder().decode(token));
//		String[] parts = decodedToken.split(":");
//		String keyUser = parts[2];
//		return keyUser;
//	}

	@ProcessAction(name = "recoverPassword")
	public void recoverPassword(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {

		String emailAddress = ParamUtil.getString(actionRequest, "email-address");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if (Validator.isNotNull(UserLocalServiceUtil.getUserIdByEmailAddress(
					themeDisplay.getCompanyId(), emailAddress))){
				isUserRegister(themeDisplay, emailAddress);
			}
		} catch (PortalException e) {
			_log.error("***ERROR: al intentar recuperar la contrasena:" + emailAddress);
			actionRequest.setAttribute("error", true);
		}
	}

	@ProcessAction(name = "resetpassword")
	public void resetPassword(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		String token = ParamUtil.getString(actionRequest, "token");
		String password = ParamUtil.getString(actionRequest, "password");
		String passwordValidate = ParamUtil.getString(actionRequest, "re-password");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String redirectURL = ParamUtil.getString(actionRequest, "mvcPath");

		try {
			if(validateToken(token) && validateTokenEmail(token)) {
				_log.info("***token valido resetpassword***");
				if (Validator.isNotNull(UserLocalServiceUtil.getUserIdByEmailAddress(
						themeDisplay.getCompanyId(), getEmailbyToken(token))) && passwordValidate.equals(password)){
					String email = getEmailbyToken(token);
					User user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(), email);
					UserLocalServiceUtil.updatePassword(user.getUserId(), password, passwordValidate, false, true);
				}
			}else {
				_log.error("***ERROR: al intentar procesar token contrasena:" + getEmailbyToken(token));
			}
		} catch (PortalException e) {
			_log.error("***ERROR: al intentar recuperar la contrasena:" + getEmailbyToken(token));
		}
		actionResponse.sendRedirect(redirectURL);
	}

	private void isUserRegister(ThemeDisplay themeDisplay, String emailAddress) throws PortalException {
		User user = UserLocalServiceUtil.getUserByEmailAddress(
				themeDisplay.getCompanyId(), emailAddress);
		String token = RegisterActionCommand.generateToken(user.getEmailAddress(),user.getPassword());
		String urlEmailResetPassToken = themeDisplay.getPortalURL()+"/generar-nueva-pass?token="+token;
		sendRecoveryEmail(user.getLogin(), user.getFirstName(),urlEmailResetPassToken);
		_log.info("Se ha enviado un correo electronico de recuperacion de contrasenya: " + emailAddress);
	}

	private void sendRecoveryEmail(String email, String name, String urlEmailResetPassToken) {
		hubspotService.sendPasswordResetEmailUseCase(email, name, urlEmailResetPassToken);
	}

	@ProcessAction(name = "savePreferences")
	public void savePreferences(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User principal = themeDisplay.getUser();
		// Recoger datos del paso 1
		String dedicationLevel = ParamUtil.getString(actionRequest, "dedicationLevel");
		String[] selectedDedications = ParamUtil.getParameterValues(actionRequest, "selectedDedications");
		String[] selectedAgricultureCategories = ParamUtil.getParameterValues(actionRequest, "selectedAgricultureCategories");
		String[] selectedStockbreadingCategories = ParamUtil.getParameterValues(actionRequest, "selectedStockbreadingCategories");

		// Recoger datos del paso 2
		String[] userOtherAgricultureCategories = ParamUtil.getParameterValues(actionRequest, "otherAgricultureCategory");
		String[] userOtherStockbreadingCategories = ParamUtil.getParameterValues(actionRequest, "otherStockbreadingCategory");
		String[] userOtherCategories = ParamUtil.getParameterValues(actionRequest, "otherCategory");
		String customInterests = ParamUtil.getString(actionRequest, "customInterests");
		String[] customInterestsArray = customInterests.split(",");

		List<AssetCategory> dedicationCategories = getGlobalCategory("user dedications");
		List<AssetCategory> agricultureCategories = getGlobalSubcategories(AvanisCustomLoginPortletKeys.AGRICULTURE_CATEGORY_ERC);
		List<AssetCategory> stockbreadingCategories = getGlobalSubcategories(AvanisCustomLoginPortletKeys.STOCKBREADING_CATEGORY_ERC);

		List<Long> selectedDedicationCategoryIds = new ArrayList();
		for (AssetCategory category: dedicationCategories) {
			if (IntStream.range(0, selectedDedications.length).anyMatch(i -> category.getName().equalsIgnoreCase(selectedDedications[i]))) {
				selectedDedicationCategoryIds.add(category.getCategoryId());
			}
		}
		List<Long> selectedAgricultureCategoryIds = new ArrayList();
		for (AssetCategory category: agricultureCategories) {
			if (IntStream.range(0, selectedAgricultureCategories.length).anyMatch(i -> category.getName().equalsIgnoreCase(selectedAgricultureCategories[i]))) {
				selectedAgricultureCategoryIds.add(category.getCategoryId());
			}
		}
		List<Long> selectedStockbreadingCategoryIds = new ArrayList();
		for (AssetCategory category: stockbreadingCategories) {
			if (IntStream.range(0, selectedStockbreadingCategories.length).anyMatch(i -> category.getName().equalsIgnoreCase(selectedStockbreadingCategories[i]))) {
				selectedStockbreadingCategoryIds.add(category.getCategoryId());
			}
		}

		Long[] userCategoryIds = Stream.of(
						selectedDedicationCategoryIds,
						selectedAgricultureCategoryIds,
						selectedStockbreadingCategoryIds
				).flatMap(Collection::stream)
				.collect(Collectors.toList())
				.toArray(Long[]::new);


		String[] userInterests = Stream.of(
						userOtherAgricultureCategories,
						userOtherStockbreadingCategories,
						userOtherCategories,
						customInterestsArray
				)
				.flatMap(Stream::of)
				.filter(interest -> interest != null && !interest.trim().isEmpty())
				.toArray(String[]::new);

		UserLocalServiceUtil.updateAsset(principal.getUserId(), principal, ArrayUtil.toArray(userCategoryIds), userInterests);
		//UserLocalServiceUtil.updateAsset(principal.getUserId(), principal, ArrayUtil.toArray(userCategoryIds.toArray(Long[]::new)), userInterests);

		try{
			processFormInterests(principal.getEmailAddress(), dedicationLevel,selectedDedications, selectedAgricultureCategories, selectedStockbreadingCategories, userOtherAgricultureCategories,
					userOtherStockbreadingCategories, userOtherCategories);
		}catch (Exception e){
			_log.error("Error sending form to hubspot");
		}
		// Redirigir después de enviar el formulario
		actionResponse.sendRedirect(REDIRECT_AFTER_SUBMIT);

    /*
    Boolean allowNewsLetter = ParamUtil.getBoolean(actionRequest, "allowNewsLetter");
    if (allowNewsLetter) {
        hubspotService.subscribeNewsletter(principal.getEmailAddress(), HUBSPOT_SUBSCRIPTION_ID);
    } else {
        hubspotService.unsubscribeNewsletter(principal.getEmailAddress(), HUBSPOT_SUBSCRIPTION_ID);
    }
    */
	}


	public void loadPreferences(User principal, PortletRequest portletRequest) {
		List<String> userAssetTags = AssetTagLocalServiceUtil.getTags(User.class.getName(), principal.getUserId()).stream().map(AssetTag::getName).map(String::toLowerCase).collect(Collectors.toList());
		List<AssetCategory> otherCategories = getGlobalCategory("avanis").stream().filter(assetCategory -> assetCategory.getParentCategoryId() == 0).collect(Collectors.toList());
		Boolean allowNewsLetter = true; //hubspotService.isSubscribed(principal.getEmailAddress(), HUBSPOT_SUBSCRIPTION_ID);
		Boolean allowNotifications = true; //hubspotService.isSubscribed(principal.getEmailAddress(), HUBSPOT_SUBSCRIPTION_ID);

		portletRequest.setAttribute("agricultureCategories", getGlobalSubcategories(AvanisCustomLoginPortletKeys.AGRICULTURE_CATEGORY_ERC));
		portletRequest.setAttribute("stockbreadingCategories", getGlobalSubcategories(AvanisCustomLoginPortletKeys.STOCKBREADING_CATEGORY_ERC));
		portletRequest.setAttribute("otherCategories", otherCategories);
		portletRequest.setAttribute("userInterests", userAssetTags);
		portletRequest.setAttribute("dedications", getGlobalCategory("user dedications"));
		portletRequest.setAttribute("allowNewsLetter", allowNewsLetter);
		portletRequest.setAttribute("allowNotifications", allowNotifications);
	}

	private List<AssetCategory> getGlobalCategory(String vocabularyName) {
		long globalGroupId = 20119;
		AssetVocabulary vocabulary = null;
		try {
			vocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(globalGroupId, vocabularyName);
			return AssetCategoryLocalServiceUtil.getVocabularyCategories(
					vocabulary.getVocabularyId(), 0, Integer.MAX_VALUE, null
			);

		} catch (PortalException e) {
			return new ArrayList<>();
		}

	}
	private List<AssetCategory> getGlobalSubcategories(String externalReferenceCode) {

		try {
			long groupId = 20119; //Global group
			long parentCategoryId = AssetCategoryLocalServiceUtil.getAssetCategoryByExternalReferenceCode(externalReferenceCode, groupId).getCategoryId();

			return AssetCategoryLocalServiceUtil.getChildCategories(parentCategoryId);


		} catch (PortalException e) {
			return new ArrayList<>();
		}

	}

	private void processFormInterests(String email, String dedicationLevel, String[] selectedDedications, String[] selectedAgricultureCategories,
									  String[] selectedStockbreadingCategories, String[] userOtherAgricultureCategories, String[] userOtherStockbreadingCategories, String[] userOtherCategories) {
		String agriculture = Arrays.asList(selectedDedications).contains("Agricultura") ? "SI" : "NO";
		String stockBreeding = Arrays.asList(selectedDedications).contains("Ganadería") ? "SI" : "NO";
		String transforming = Arrays.asList(selectedDedications).contains("Industria transformadora") ? "SI" : "NO";
		String other = Arrays.asList(selectedDedications).contains("Otros sectores") ? "SI" : "NO";
		String startups = Arrays.asList(selectedDedications).contains("Startups") ? "SI" : "NO";
		String techAgrotech = Arrays.asList(selectedDedications).contains("Tecnología y Agrotech") ? "SI" : "NO";
		String sales = Arrays.asList(selectedDedications).contains("Venta de productos o servicios") ? "SI" : "NO";
		List<String> agricultureActivity = Arrays.asList(selectedAgricultureCategories);
		List<String> stockBreedingActivity = Arrays.asList(selectedStockbreadingCategories);
		List<String> agricultureInterest = Arrays.asList(userOtherAgricultureCategories);
		List<String> stockBreedingInterest = Arrays.asList(userOtherStockbreadingCategories);
		List<String> otherInterest = Arrays.asList(userOtherCategories);
		_log.info("Selected dedications:" + Arrays.toString(selectedDedications));
		hubspotService.formPreferencesSteps(email, dedicationLevel,agriculture,stockBreeding,sales, transforming,techAgrotech,
				startups, other,agricultureActivity,stockBreedingActivity,agricultureInterest,stockBreedingInterest,otherInterest);
	}
}
