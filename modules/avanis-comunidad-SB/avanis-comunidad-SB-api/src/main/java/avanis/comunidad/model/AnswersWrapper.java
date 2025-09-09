/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Answers}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Answers
 * @generated
 */
public class AnswersWrapper
	extends BaseModelWrapper<Answers>
	implements Answers, ModelWrapper<Answers> {

	public AnswersWrapper(Answers answers) {
		super(answers);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("answerId", getAnswerId());
		attributes.put("surveyId", getSurveyId());
		attributes.put("answer", getAnswer());
		attributes.put("counterAnswer", getCounterAnswer());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long answerId = (Long)attributes.get("answerId");

		if (answerId != null) {
			setAnswerId(answerId);
		}

		Long surveyId = (Long)attributes.get("surveyId");

		if (surveyId != null) {
			setSurveyId(surveyId);
		}

		String answer = (String)attributes.get("answer");

		if (answer != null) {
			setAnswer(answer);
		}

		Integer counterAnswer = (Integer)attributes.get("counterAnswer");

		if (counterAnswer != null) {
			setCounterAnswer(counterAnswer);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public Answers cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the answer of this answers.
	 *
	 * @return the answer of this answers
	 */
	@Override
	public String getAnswer() {
		return model.getAnswer();
	}

	/**
	 * Returns the answer ID of this answers.
	 *
	 * @return the answer ID of this answers
	 */
	@Override
	public long getAnswerId() {
		return model.getAnswerId();
	}

	/**
	 * Returns the counter answer of this answers.
	 *
	 * @return the counter answer of this answers
	 */
	@Override
	public int getCounterAnswer() {
		return model.getCounterAnswer();
	}

	/**
	 * Returns the create date of this answers.
	 *
	 * @return the create date of this answers
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the primary key of this answers.
	 *
	 * @return the primary key of this answers
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the survey ID of this answers.
	 *
	 * @return the survey ID of this answers
	 */
	@Override
	public long getSurveyId() {
		return model.getSurveyId();
	}

	/**
	 * Returns the uuid of this answers.
	 *
	 * @return the uuid of this answers
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the answer of this answers.
	 *
	 * @param answer the answer of this answers
	 */
	@Override
	public void setAnswer(String answer) {
		model.setAnswer(answer);
	}

	/**
	 * Sets the answer ID of this answers.
	 *
	 * @param answerId the answer ID of this answers
	 */
	@Override
	public void setAnswerId(long answerId) {
		model.setAnswerId(answerId);
	}

	/**
	 * Sets the counter answer of this answers.
	 *
	 * @param counterAnswer the counter answer of this answers
	 */
	@Override
	public void setCounterAnswer(int counterAnswer) {
		model.setCounterAnswer(counterAnswer);
	}

	/**
	 * Sets the create date of this answers.
	 *
	 * @param createDate the create date of this answers
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the primary key of this answers.
	 *
	 * @param primaryKey the primary key of this answers
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the survey ID of this answers.
	 *
	 * @param surveyId the survey ID of this answers
	 */
	@Override
	public void setSurveyId(long surveyId) {
		model.setSurveyId(surveyId);
	}

	/**
	 * Sets the uuid of this answers.
	 *
	 * @param uuid the uuid of this answers
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected AnswersWrapper wrap(Answers answers) {
		return new AnswersWrapper(answers);
	}

}