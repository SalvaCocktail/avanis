/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.service.impl;

import avanis.comunidad.model.Surveys;
import avanis.comunidad.service.base.SurveysLocalServiceBaseImpl;
import avanis.comunidad.service.persistence.SurveysPersistence;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=avanis.comunidad.model.Surveys",
	service = AopService.class
)
public class SurveysLocalServiceImpl extends SurveysLocalServiceBaseImpl {

	public Surveys createUpdate(long surveyId, long userId, long groupId, String question, int expireHours)  {

		Calendar cal = GregorianCalendar.getInstance();

        Surveys survey = fetchSurveys(surveyId);
        if(Validator.isNull(survey)){
			survey = createSurveys(counterLocalService.increment(Surveys.class.getName()));
		}

		survey.setQuestion(question);
		survey.setUserId(userId);
		survey.setGroupId(groupId);

		// Aquí irá asset correspondiente (messageId), automático por el momento
		survey.setAssetId(counterLocalService.increment());

		survey.setCreateDate(cal.getTime());
		survey.setModifiedDate(cal.getTime());

		Calendar calExpire = GregorianCalendar.getInstance();
		calExpire.setTime(cal.getTime());
		calExpire.add(Calendar.HOUR, expireHours);
		survey.setCreateDate(cal.getTime());
		survey.setModifiedDate(cal.getTime());
		survey.setExpireDate(calExpire.getTime());

		return updateSurveys(survey);
	}

	public List<Surveys> getSurveysByAssetId(long assetId) {
		return surveysPersistence.findByassetId(assetId);
	}

}
