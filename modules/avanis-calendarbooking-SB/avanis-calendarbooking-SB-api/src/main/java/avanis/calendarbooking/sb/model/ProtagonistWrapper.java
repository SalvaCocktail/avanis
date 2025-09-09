/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Protagonist}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Protagonist
 * @generated
 */
public class ProtagonistWrapper
	extends BaseModelWrapper<Protagonist>
	implements ModelWrapper<Protagonist>, Protagonist {

	public ProtagonistWrapper(Protagonist protagonist) {
		super(protagonist);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("protagonistId", getProtagonistId());
		attributes.put("calendarBookingId", getCalendarBookingId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("lastName", getLastName());
		attributes.put("profession", getProfession());
		attributes.put("bio", getBio());
		attributes.put("portraitUrl", getPortraitUrl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long protagonistId = (Long)attributes.get("protagonistId");

		if (protagonistId != null) {
			setProtagonistId(protagonistId);
		}

		Long calendarBookingId = (Long)attributes.get("calendarBookingId");

		if (calendarBookingId != null) {
			setCalendarBookingId(calendarBookingId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String profession = (String)attributes.get("profession");

		if (profession != null) {
			setProfession(profession);
		}

		String bio = (String)attributes.get("bio");

		if (bio != null) {
			setBio(bio);
		}

		String portraitUrl = (String)attributes.get("portraitUrl");

		if (portraitUrl != null) {
			setPortraitUrl(portraitUrl);
		}
	}

	@Override
	public Protagonist cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the bio of this protagonist.
	 *
	 * @return the bio of this protagonist
	 */
	@Override
	public String getBio() {
		return model.getBio();
	}

	/**
	 * Returns the calendar booking ID of this protagonist.
	 *
	 * @return the calendar booking ID of this protagonist
	 */
	@Override
	public long getCalendarBookingId() {
		return model.getCalendarBookingId();
	}

	/**
	 * Returns the company ID of this protagonist.
	 *
	 * @return the company ID of this protagonist
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this protagonist.
	 *
	 * @return the create date of this protagonist
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this protagonist.
	 *
	 * @return the group ID of this protagonist
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the last name of this protagonist.
	 *
	 * @return the last name of this protagonist
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the modified date of this protagonist.
	 *
	 * @return the modified date of this protagonist
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this protagonist.
	 *
	 * @return the name of this protagonist
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the portrait url of this protagonist.
	 *
	 * @return the portrait url of this protagonist
	 */
	@Override
	public String getPortraitUrl() {
		return model.getPortraitUrl();
	}

	/**
	 * Returns the primary key of this protagonist.
	 *
	 * @return the primary key of this protagonist
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the profession of this protagonist.
	 *
	 * @return the profession of this protagonist
	 */
	@Override
	public String getProfession() {
		return model.getProfession();
	}

	/**
	 * Returns the protagonist ID of this protagonist.
	 *
	 * @return the protagonist ID of this protagonist
	 */
	@Override
	public long getProtagonistId() {
		return model.getProtagonistId();
	}

	/**
	 * Returns the user ID of this protagonist.
	 *
	 * @return the user ID of this protagonist
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this protagonist.
	 *
	 * @return the user name of this protagonist
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this protagonist.
	 *
	 * @return the user uuid of this protagonist
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this protagonist.
	 *
	 * @return the uuid of this protagonist
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
	 * Sets the bio of this protagonist.
	 *
	 * @param bio the bio of this protagonist
	 */
	@Override
	public void setBio(String bio) {
		model.setBio(bio);
	}

	/**
	 * Sets the calendar booking ID of this protagonist.
	 *
	 * @param calendarBookingId the calendar booking ID of this protagonist
	 */
	@Override
	public void setCalendarBookingId(long calendarBookingId) {
		model.setCalendarBookingId(calendarBookingId);
	}

	/**
	 * Sets the company ID of this protagonist.
	 *
	 * @param companyId the company ID of this protagonist
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this protagonist.
	 *
	 * @param createDate the create date of this protagonist
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this protagonist.
	 *
	 * @param groupId the group ID of this protagonist
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the last name of this protagonist.
	 *
	 * @param lastName the last name of this protagonist
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the modified date of this protagonist.
	 *
	 * @param modifiedDate the modified date of this protagonist
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this protagonist.
	 *
	 * @param name the name of this protagonist
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the portrait url of this protagonist.
	 *
	 * @param portraitUrl the portrait url of this protagonist
	 */
	@Override
	public void setPortraitUrl(String portraitUrl) {
		model.setPortraitUrl(portraitUrl);
	}

	/**
	 * Sets the primary key of this protagonist.
	 *
	 * @param primaryKey the primary key of this protagonist
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the profession of this protagonist.
	 *
	 * @param profession the profession of this protagonist
	 */
	@Override
	public void setProfession(String profession) {
		model.setProfession(profession);
	}

	/**
	 * Sets the protagonist ID of this protagonist.
	 *
	 * @param protagonistId the protagonist ID of this protagonist
	 */
	@Override
	public void setProtagonistId(long protagonistId) {
		model.setProtagonistId(protagonistId);
	}

	/**
	 * Sets the user ID of this protagonist.
	 *
	 * @param userId the user ID of this protagonist
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this protagonist.
	 *
	 * @param userName the user name of this protagonist
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this protagonist.
	 *
	 * @param userUuid the user uuid of this protagonist
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this protagonist.
	 *
	 * @param uuid the uuid of this protagonist
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
	protected ProtagonistWrapper wrap(Protagonist protagonist) {
		return new ProtagonistWrapper(protagonist);
	}

}