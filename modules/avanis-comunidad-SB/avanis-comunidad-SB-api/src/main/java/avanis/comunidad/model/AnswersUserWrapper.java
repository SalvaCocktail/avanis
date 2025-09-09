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
 * This class is a wrapper for {@link AnswersUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnswersUser
 * @generated
 */
public class AnswersUserWrapper
	extends BaseModelWrapper<AnswersUser>
	implements AnswersUser, ModelWrapper<AnswersUser> {

	public AnswersUserWrapper(AnswersUser answersUser) {
		super(answersUser);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("answerUserId", getAnswerUserId());
		attributes.put("answerId", getAnswerId());
		attributes.put("userId", getUserId());
		attributes.put("surveyId", getSurveyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long answerUserId = (Long)attributes.get("answerUserId");

		if (answerUserId != null) {
			setAnswerUserId(answerUserId);
		}

		Long answerId = (Long)attributes.get("answerId");

		if (answerId != null) {
			setAnswerId(answerId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long surveyId = (Long)attributes.get("surveyId");

		if (surveyId != null) {
			setSurveyId(surveyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public AnswersUser cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the answer ID of this answers user.
	 *
	 * @return the answer ID of this answers user
	 */
	@Override
	public long getAnswerId() {
		return model.getAnswerId();
	}

	/**
	 * Returns the answer user ID of this answers user.
	 *
	 * @return the answer user ID of this answers user
	 */
	@Override
	public long getAnswerUserId() {
		return model.getAnswerUserId();
	}

	/**
	 * Returns the answer user uuid of this answers user.
	 *
	 * @return the answer user uuid of this answers user
	 */
	@Override
	public String getAnswerUserUuid() {
		return model.getAnswerUserUuid();
	}

	/**
	 * Returns the create date of this answers user.
	 *
	 * @return the create date of this answers user
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the modified date of this answers user.
	 *
	 * @return the modified date of this answers user
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this answers user.
	 *
	 * @return the primary key of this answers user
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the survey ID of this answers user.
	 *
	 * @return the survey ID of this answers user
	 */
	@Override
	public long getSurveyId() {
		return model.getSurveyId();
	}

	/**
	 * Returns the user ID of this answers user.
	 *
	 * @return the user ID of this answers user
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this answers user.
	 *
	 * @return the user uuid of this answers user
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this answers user.
	 *
	 * @return the uuid of this answers user
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
	 * Sets the answer ID of this answers user.
	 *
	 * @param answerId the answer ID of this answers user
	 */
	@Override
	public void setAnswerId(long answerId) {
		model.setAnswerId(answerId);
	}

	/**
	 * Sets the answer user ID of this answers user.
	 *
	 * @param answerUserId the answer user ID of this answers user
	 */
	@Override
	public void setAnswerUserId(long answerUserId) {
		model.setAnswerUserId(answerUserId);
	}

	/**
	 * Sets the answer user uuid of this answers user.
	 *
	 * @param answerUserUuid the answer user uuid of this answers user
	 */
	@Override
	public void setAnswerUserUuid(String answerUserUuid) {
		model.setAnswerUserUuid(answerUserUuid);
	}

	/**
	 * Sets the create date of this answers user.
	 *
	 * @param createDate the create date of this answers user
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the modified date of this answers user.
	 *
	 * @param modifiedDate the modified date of this answers user
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this answers user.
	 *
	 * @param primaryKey the primary key of this answers user
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the survey ID of this answers user.
	 *
	 * @param surveyId the survey ID of this answers user
	 */
	@Override
	public void setSurveyId(long surveyId) {
		model.setSurveyId(surveyId);
	}

	/**
	 * Sets the user ID of this answers user.
	 *
	 * @param userId the user ID of this answers user
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this answers user.
	 *
	 * @param userUuid the user uuid of this answers user
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this answers user.
	 *
	 * @param uuid the uuid of this answers user
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
	protected AnswersUserWrapper wrap(AnswersUser answersUser) {
		return new AnswersUserWrapper(answersUser);
	}

}