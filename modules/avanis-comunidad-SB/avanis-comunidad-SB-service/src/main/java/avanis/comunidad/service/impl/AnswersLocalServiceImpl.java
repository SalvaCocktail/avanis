/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.service.impl;

import avanis.comunidad.model.Answers;
import avanis.comunidad.service.base.AnswersLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=avanis.comunidad.model.Answers",
	service = AopService.class
)
public class AnswersLocalServiceImpl extends AnswersLocalServiceBaseImpl {

	public List<Answers> createUpdate(String[] answers, List<Long> answersIds, long surveyId) {

		List<Answers> answerList = new ArrayList<>();

		Calendar cal = GregorianCalendar.getInstance();

		for (int i = 0; i < answers.length; i++) {
			Answers answer = fetchAnswers(answersIds.get(i));
			if (Validator.isNull(answersIds.get(i)) || answersIds.get(i) == -1) {
				answer = createAnswers(counterLocalService.increment(Answers.class.getName()));
			}

			answer.setSurveyId(surveyId);
			answer.setAnswer(answers[i]);
			answer.setCounterAnswer(0);
			answer.setCreateDate(cal.getTime());

			answerList.add(updateAnswers(answer));
		}

		return answerList;
	}

	public List<Answers> getAnswersBySurveyId(long surveyId) {
		return answersPersistence.findBysurveyId(surveyId);
	}
}
