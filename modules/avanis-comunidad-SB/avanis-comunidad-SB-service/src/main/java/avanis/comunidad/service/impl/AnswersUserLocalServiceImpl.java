/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.service.impl;

import avanis.comunidad.model.Answers;
import avanis.comunidad.model.AnswersUser;
import avanis.comunidad.service.base.AnswersUserLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=avanis.comunidad.model.AnswersUser",
	service = AopService.class
)
public class AnswersUserLocalServiceImpl
	extends AnswersUserLocalServiceBaseImpl {

	public List<AnswersUser> getAnswersUserBySurveyIdUserId(long surveyId, long userId) {
		return answersUserPersistence.findBysurveyIdUserId(surveyId, userId);
	}

	public List<AnswersUser> getAnswersUserByAnswerIdSUserId(long answerId, long userId) {
		return answersUserPersistence.findByanswerIdUserId(answerId, userId);
	}

	public List<AnswersUser> getAnswersUserBySurveyId(long surveyId) {
		return answersUserPersistence.findBysurveyId(surveyId);
	}

	public List<AnswersUser> getAnswersUserByUserId(long userId) {
		return answersUserPersistence.findByuserId(userId);
	}
}
