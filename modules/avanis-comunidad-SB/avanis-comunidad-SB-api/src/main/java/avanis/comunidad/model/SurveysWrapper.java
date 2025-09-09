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
 * This class is a wrapper for {@link Surveys}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Surveys
 * @generated
 */
public class SurveysWrapper
	extends BaseModelWrapper<Surveys>
	implements ModelWrapper<Surveys>, Surveys {

	public SurveysWrapper(Surveys surveys) {
		super(surveys);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("surveyId", getSurveyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("assetId", getAssetId());
		attributes.put("question", getQuestion());
		attributes.put("expireHours", getExpireHours());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("expireDate", getExpireDate());
		attributes.put("notified", getNotified());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long surveyId = (Long)attributes.get("surveyId");

		if (surveyId != null) {
			setSurveyId(surveyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long assetId = (Long)attributes.get("assetId");

		if (assetId != null) {
			setAssetId(assetId);
		}

		String question = (String)attributes.get("question");

		if (question != null) {
			setQuestion(question);
		}

		Integer expireHours = (Integer)attributes.get("expireHours");

		if (expireHours != null) {
			setExpireHours(expireHours);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date expireDate = (Date)attributes.get("expireDate");

		if (expireDate != null) {
			setExpireDate(expireDate);
		}

		Boolean notified = (Boolean)attributes.get("notified");

		if (notified != null) {
			setNotified(notified);
		}
	}

	@Override
	public Surveys cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the asset ID of this surveys.
	 *
	 * @return the asset ID of this surveys
	 */
	@Override
	public long getAssetId() {
		return model.getAssetId();
	}

	/**
	 * Returns the create date of this surveys.
	 *
	 * @return the create date of this surveys
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the expire date of this surveys.
	 *
	 * @return the expire date of this surveys
	 */
	@Override
	public Date getExpireDate() {
		return model.getExpireDate();
	}

	/**
	 * Returns the expire hours of this surveys.
	 *
	 * @return the expire hours of this surveys
	 */
	@Override
	public int getExpireHours() {
		return model.getExpireHours();
	}

	/**
	 * Returns the group ID of this surveys.
	 *
	 * @return the group ID of this surveys
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this surveys.
	 *
	 * @return the modified date of this surveys
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the notified of this surveys.
	 *
	 * @return the notified of this surveys
	 */
	@Override
	public Boolean getNotified() {
		return model.getNotified();
	}

	/**
	 * Returns the primary key of this surveys.
	 *
	 * @return the primary key of this surveys
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the question of this surveys.
	 *
	 * @return the question of this surveys
	 */
	@Override
	public String getQuestion() {
		return model.getQuestion();
	}

	/**
	 * Returns the survey ID of this surveys.
	 *
	 * @return the survey ID of this surveys
	 */
	@Override
	public long getSurveyId() {
		return model.getSurveyId();
	}

	/**
	 * Returns the user ID of this surveys.
	 *
	 * @return the user ID of this surveys
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this surveys.
	 *
	 * @return the user uuid of this surveys
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this surveys.
	 *
	 * @return the uuid of this surveys
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
	 * Sets the asset ID of this surveys.
	 *
	 * @param assetId the asset ID of this surveys
	 */
	@Override
	public void setAssetId(long assetId) {
		model.setAssetId(assetId);
	}

	/**
	 * Sets the create date of this surveys.
	 *
	 * @param createDate the create date of this surveys
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the expire date of this surveys.
	 *
	 * @param expireDate the expire date of this surveys
	 */
	@Override
	public void setExpireDate(Date expireDate) {
		model.setExpireDate(expireDate);
	}

	/**
	 * Sets the expire hours of this surveys.
	 *
	 * @param expireHours the expire hours of this surveys
	 */
	@Override
	public void setExpireHours(int expireHours) {
		model.setExpireHours(expireHours);
	}

	/**
	 * Sets the group ID of this surveys.
	 *
	 * @param groupId the group ID of this surveys
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this surveys.
	 *
	 * @param modifiedDate the modified date of this surveys
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the notified of this surveys.
	 *
	 * @param notified the notified of this surveys
	 */
	@Override
	public void setNotified(Boolean notified) {
		model.setNotified(notified);
	}

	/**
	 * Sets the primary key of this surveys.
	 *
	 * @param primaryKey the primary key of this surveys
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the question of this surveys.
	 *
	 * @param question the question of this surveys
	 */
	@Override
	public void setQuestion(String question) {
		model.setQuestion(question);
	}

	/**
	 * Sets the survey ID of this surveys.
	 *
	 * @param surveyId the survey ID of this surveys
	 */
	@Override
	public void setSurveyId(long surveyId) {
		model.setSurveyId(surveyId);
	}

	/**
	 * Sets the user ID of this surveys.
	 *
	 * @param userId the user ID of this surveys
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this surveys.
	 *
	 * @param userUuid the user uuid of this surveys
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this surveys.
	 *
	 * @param uuid the uuid of this surveys
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
	protected SurveysWrapper wrap(Surveys surveys) {
		return new SurveysWrapper(surveys);
	}

}