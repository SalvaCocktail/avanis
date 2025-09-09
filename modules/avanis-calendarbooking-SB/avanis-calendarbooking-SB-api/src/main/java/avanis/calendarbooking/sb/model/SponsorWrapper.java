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
 * This class is a wrapper for {@link Sponsor}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Sponsor
 * @generated
 */
public class SponsorWrapper
	extends BaseModelWrapper<Sponsor>
	implements ModelWrapper<Sponsor>, Sponsor {

	public SponsorWrapper(Sponsor sponsor) {
		super(sponsor);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("sponsorId", getSponsorId());
		attributes.put("calendarBookingId", getCalendarBookingId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("iconUrl", getIconUrl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long sponsorId = (Long)attributes.get("sponsorId");

		if (sponsorId != null) {
			setSponsorId(sponsorId);
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

		String iconUrl = (String)attributes.get("iconUrl");

		if (iconUrl != null) {
			setIconUrl(iconUrl);
		}
	}

	@Override
	public Sponsor cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the calendar booking ID of this sponsor.
	 *
	 * @return the calendar booking ID of this sponsor
	 */
	@Override
	public long getCalendarBookingId() {
		return model.getCalendarBookingId();
	}

	/**
	 * Returns the company ID of this sponsor.
	 *
	 * @return the company ID of this sponsor
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this sponsor.
	 *
	 * @return the create date of this sponsor
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this sponsor.
	 *
	 * @return the group ID of this sponsor
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the icon url of this sponsor.
	 *
	 * @return the icon url of this sponsor
	 */
	@Override
	public String getIconUrl() {
		return model.getIconUrl();
	}

	/**
	 * Returns the modified date of this sponsor.
	 *
	 * @return the modified date of this sponsor
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this sponsor.
	 *
	 * @return the name of this sponsor
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this sponsor.
	 *
	 * @return the primary key of this sponsor
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sponsor ID of this sponsor.
	 *
	 * @return the sponsor ID of this sponsor
	 */
	@Override
	public long getSponsorId() {
		return model.getSponsorId();
	}

	/**
	 * Returns the user ID of this sponsor.
	 *
	 * @return the user ID of this sponsor
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this sponsor.
	 *
	 * @return the user name of this sponsor
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this sponsor.
	 *
	 * @return the user uuid of this sponsor
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this sponsor.
	 *
	 * @return the uuid of this sponsor
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
	 * Sets the calendar booking ID of this sponsor.
	 *
	 * @param calendarBookingId the calendar booking ID of this sponsor
	 */
	@Override
	public void setCalendarBookingId(long calendarBookingId) {
		model.setCalendarBookingId(calendarBookingId);
	}

	/**
	 * Sets the company ID of this sponsor.
	 *
	 * @param companyId the company ID of this sponsor
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this sponsor.
	 *
	 * @param createDate the create date of this sponsor
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this sponsor.
	 *
	 * @param groupId the group ID of this sponsor
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the icon url of this sponsor.
	 *
	 * @param iconUrl the icon url of this sponsor
	 */
	@Override
	public void setIconUrl(String iconUrl) {
		model.setIconUrl(iconUrl);
	}

	/**
	 * Sets the modified date of this sponsor.
	 *
	 * @param modifiedDate the modified date of this sponsor
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this sponsor.
	 *
	 * @param name the name of this sponsor
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this sponsor.
	 *
	 * @param primaryKey the primary key of this sponsor
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sponsor ID of this sponsor.
	 *
	 * @param sponsorId the sponsor ID of this sponsor
	 */
	@Override
	public void setSponsorId(long sponsorId) {
		model.setSponsorId(sponsorId);
	}

	/**
	 * Sets the user ID of this sponsor.
	 *
	 * @param userId the user ID of this sponsor
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this sponsor.
	 *
	 * @param userName the user name of this sponsor
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this sponsor.
	 *
	 * @param userUuid the user uuid of this sponsor
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this sponsor.
	 *
	 * @param uuid the uuid of this sponsor
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
	protected SponsorWrapper wrap(Sponsor sponsor) {
		return new SponsorWrapper(sponsor);
	}

}