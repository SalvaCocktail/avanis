/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.social.follow.sb.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SocialFollow}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialFollow
 * @generated
 */
public class SocialFollowWrapper
	extends BaseModelWrapper<SocialFollow>
	implements ModelWrapper<SocialFollow>, SocialFollow {

	public SocialFollowWrapper(SocialFollow socialFollow) {
		super(socialFollow);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("socialFollowId", getSocialFollowId());
		attributes.put("accepted", isAccepted());
		attributes.put("followsTo", getFollowsTo());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
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

		Long socialFollowId = (Long)attributes.get("socialFollowId");

		if (socialFollowId != null) {
			setSocialFollowId(socialFollowId);
		}

		Boolean accepted = (Boolean)attributes.get("accepted");

		if (accepted != null) {
			setAccepted(accepted);
		}

		Long followsTo = (Long)attributes.get("followsTo");

		if (followsTo != null) {
			setFollowsTo(followsTo);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
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
	public SocialFollow cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the accepted of this social follow.
	 *
	 * @return the accepted of this social follow
	 */
	@Override
	public boolean getAccepted() {
		return model.getAccepted();
	}

	/**
	 * Returns the company ID of this social follow.
	 *
	 * @return the company ID of this social follow
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this social follow.
	 *
	 * @return the create date of this social follow
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the follows to of this social follow.
	 *
	 * @return the follows to of this social follow
	 */
	@Override
	public long getFollowsTo() {
		return model.getFollowsTo();
	}

	/**
	 * Returns the group ID of this social follow.
	 *
	 * @return the group ID of this social follow
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this social follow.
	 *
	 * @return the modified date of this social follow
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this social follow.
	 *
	 * @return the primary key of this social follow
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the social follow ID of this social follow.
	 *
	 * @return the social follow ID of this social follow
	 */
	@Override
	public long getSocialFollowId() {
		return model.getSocialFollowId();
	}

	/**
	 * Returns the user ID of this social follow.
	 *
	 * @return the user ID of this social follow
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this social follow.
	 *
	 * @return the user name of this social follow
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this social follow.
	 *
	 * @return the user uuid of this social follow
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this social follow.
	 *
	 * @return the uuid of this social follow
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this social follow is accepted.
	 *
	 * @return <code>true</code> if this social follow is accepted; <code>false</code> otherwise
	 */
	@Override
	public boolean isAccepted() {
		return model.isAccepted();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this social follow is accepted.
	 *
	 * @param accepted the accepted of this social follow
	 */
	@Override
	public void setAccepted(boolean accepted) {
		model.setAccepted(accepted);
	}

	/**
	 * Sets the company ID of this social follow.
	 *
	 * @param companyId the company ID of this social follow
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this social follow.
	 *
	 * @param createDate the create date of this social follow
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the follows to of this social follow.
	 *
	 * @param followsTo the follows to of this social follow
	 */
	@Override
	public void setFollowsTo(long followsTo) {
		model.setFollowsTo(followsTo);
	}

	/**
	 * Sets the group ID of this social follow.
	 *
	 * @param groupId the group ID of this social follow
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this social follow.
	 *
	 * @param modifiedDate the modified date of this social follow
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this social follow.
	 *
	 * @param primaryKey the primary key of this social follow
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the social follow ID of this social follow.
	 *
	 * @param socialFollowId the social follow ID of this social follow
	 */
	@Override
	public void setSocialFollowId(long socialFollowId) {
		model.setSocialFollowId(socialFollowId);
	}

	/**
	 * Sets the user ID of this social follow.
	 *
	 * @param userId the user ID of this social follow
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this social follow.
	 *
	 * @param userName the user name of this social follow
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this social follow.
	 *
	 * @param userUuid the user uuid of this social follow
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this social follow.
	 *
	 * @param uuid the uuid of this social follow
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
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected SocialFollowWrapper wrap(SocialFollow socialFollow) {
		return new SocialFollowWrapper(socialFollow);
	}

}