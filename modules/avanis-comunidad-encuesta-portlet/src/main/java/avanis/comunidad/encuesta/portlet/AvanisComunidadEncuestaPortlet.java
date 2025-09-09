package avanis.comunidad.encuesta.portlet;

import avanis.comunidad.encuesta.constants.AvanisComunidadEncuestaPortletKeys;
import avanis.comunidad.model.Answers;
import avanis.comunidad.model.Surveys;
import avanis.comunidad.service.AnswersLocalService;
import avanis.comunidad.service.AnswersUserLocalService;
import avanis.comunidad.service.SurveysLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;
import java.util.*;

import static avanis.comunidad.encuesta.constants.Constants.*;

/**
 * @author Antonio Ruiz Hervas
 */
@Component(
		property = {
				"com.liferay.portlet.display-category=Avanis",
				"com.liferay.portlet.header-portlet-css=/css/main.css",
				"com.liferay.portlet.instanceable=true",
				"javax.portlet.display-name=Avanis Comunidad Encuesta",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/view.jsp",
				"javax.portlet.name=" + AvanisComunidadEncuestaPortletKeys.AVANIS_COMUNIDAD_ENCUESTA_PORTLET,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user",
				"javax.portlet.version=3.0"
		},
		service = Portlet.class
)
public class AvanisComunidadEncuestaPortlet extends MVCPortlet {

	@Reference
	private SurveysLocalService _surveysLocalService;

	@Reference
	private AnswersLocalService _answersLocalService;

	@Reference
	private AnswersUserLocalService _answersUserLocalService;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		long groupId = themeDisplay.getScopeGroupId();

		long surveyId = ParamUtil.getLong(renderRequest, SURVEY_ID);
		if(Validator.isNotNull(surveyId))
			renderRequest.setAttribute(SURVEY_ID, surveyId);

		include(viewTemplate, renderRequest, renderResponse);
	}

	@ProcessAction(name = "createSurvey")
	public void createSurvey(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException, PortalException {

		Date newDate = new Date();
		Calendar cal = GregorianCalendar.getInstance();

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long userId = themeDisplay.getUserId();

		long surveyId = ParamUtil.getLong(actionRequest, SURVEY_ID, -1);
		String question = ParamUtil.getString(actionRequest, QUESTION);
		String[] answers = ParamUtil.getStringValues(actionRequest, ANSWERS);
		int expireHours = ParamUtil.getInteger(actionRequest, EXPIRE_HOURS, 0);

		Surveys survey = _surveysLocalService.createUpdate(surveyId, userId, groupId, question, expireHours);

		List<Long> answersIds = new ArrayList<Long>();
		for (int i = 0; i < answers.length; i++) { answersIds.add(-1L);}
		List<Answers> answerList = _answersLocalService.createUpdate(answers, answersIds, survey.getSurveyId());

	}

}
