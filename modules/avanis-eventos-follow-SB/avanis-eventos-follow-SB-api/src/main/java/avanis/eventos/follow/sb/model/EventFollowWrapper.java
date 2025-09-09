/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.eventos.follow.sb.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EventFollow}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventFollow
 * @generated
 */
public class EventFollowWrapper
	extends BaseModelWrapper<EventFollow>
	implements EventFollow, ModelWrapper<EventFollow> {

	public EventFollowWrapper(EventFollow eventFollow) {
		super(eventFollow);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("eventFollowId", getEventFollowId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("eventId", getEventId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long eventFollowId = (Long)attributes.get("eventFollowId");

		if (eventFollowId != null) {
			setEventFollowId(eventFollowId);
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

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}
	}

	@Override
	public EventFollow cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this event follow.
	 *
	 * @return the company ID of this event follow
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this event follow.
	 *
	 * @return the create date of this event follow
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the event follow ID of this event follow.
	 *
	 * @return the event follow ID of this event follow
	 */
	@Override
	public long getEventFollowId() {
		return model.getEventFollowId();
	}

	/**
	 * Returns the event ID of this event follow.
	 *
	 * @return the event ID of this event follow
	 */
	@Override
	public long getEventId() {
		return model.getEventId();
	}

	/**
	 * Returns the group ID of this event follow.
	 *
	 * @return the group ID of this event follow
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this event follow.
	 *
	 * @return the modified date of this event follow
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this event follow.
	 *
	 * @return the primary key of this event follow
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this event follow.
	 *
	 * @return the user ID of this event follow
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this event follow.
	 *
	 * @return the user name of this event follow
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this event follow.
	 *
	 * @return the user uuid of this event follow
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this event follow.
	 *
	 * @return the uuid of this event follow
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
	 * Sets the company ID of this event follow.
	 *
	 * @param companyId the company ID of this event follow
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this event follow.
	 *
	 * @param createDate the create date of this event follow
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the event follow ID of this event follow.
	 *
	 * @param eventFollowId the event follow ID of this event follow
	 */
	@Override
	public void setEventFollowId(long eventFollowId) {
		model.setEventFollowId(eventFollowId);
	}

	/**
	 * Sets the event ID of this event follow.
	 *
	 * @param eventId the event ID of this event follow
	 */
	@Override
	public void setEventId(long eventId) {
		model.setEventId(eventId);
	}

	/**
	 * Sets the group ID of this event follow.
	 *
	 * @param groupId the group ID of this event follow
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this event follow.
	 *
	 * @param modifiedDate the modified date of this event follow
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this event follow.
	 *
	 * @param primaryKey the primary key of this event follow
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this event follow.
	 *
	 * @param userId the user ID of this event follow
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this event follow.
	 *
	 * @param userName the user name of this event follow
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this event follow.
	 *
	 * @param userUuid the user uuid of this event follow
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this event follow.
	 *
	 * @param uuid the uuid of this event follow
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
	protected EventFollowWrapper wrap(EventFollow eventFollow) {
		return new EventFollowWrapper(eventFollow);
	}

}