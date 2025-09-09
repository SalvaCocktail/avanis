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
 * This class is a wrapper for {@link BookingAgenda}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookingAgenda
 * @generated
 */
public class BookingAgendaWrapper
	extends BaseModelWrapper<BookingAgenda>
	implements BookingAgenda, ModelWrapper<BookingAgenda> {

	public BookingAgendaWrapper(BookingAgenda bookingAgenda) {
		super(bookingAgenda);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("calendarBookingAgendaId", getCalendarBookingAgendaId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("day", getDay());
		attributes.put("startHour", getStartHour());
		attributes.put("endHour", getEndHour());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("calendarBookingId", getCalendarBookingId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long calendarBookingAgendaId = (Long)attributes.get(
			"calendarBookingAgendaId");

		if (calendarBookingAgendaId != null) {
			setCalendarBookingAgendaId(calendarBookingAgendaId);
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

		Long day = (Long)attributes.get("day");

		if (day != null) {
			setDay(day);
		}

		Long startHour = (Long)attributes.get("startHour");

		if (startHour != null) {
			setStartHour(startHour);
		}

		Long endHour = (Long)attributes.get("endHour");

		if (endHour != null) {
			setEndHour(endHour);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long calendarBookingId = (Long)attributes.get("calendarBookingId");

		if (calendarBookingId != null) {
			setCalendarBookingId(calendarBookingId);
		}
	}

	@Override
	public BookingAgenda cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the calendar booking agenda ID of this booking agenda.
	 *
	 * @return the calendar booking agenda ID of this booking agenda
	 */
	@Override
	public long getCalendarBookingAgendaId() {
		return model.getCalendarBookingAgendaId();
	}

	/**
	 * Returns the calendar booking ID of this booking agenda.
	 *
	 * @return the calendar booking ID of this booking agenda
	 */
	@Override
	public long getCalendarBookingId() {
		return model.getCalendarBookingId();
	}

	/**
	 * Returns the company ID of this booking agenda.
	 *
	 * @return the company ID of this booking agenda
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this booking agenda.
	 *
	 * @return the create date of this booking agenda
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the day of this booking agenda.
	 *
	 * @return the day of this booking agenda
	 */
	@Override
	public long getDay() {
		return model.getDay();
	}

	/**
	 * Returns the description of this booking agenda.
	 *
	 * @return the description of this booking agenda
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the end hour of this booking agenda.
	 *
	 * @return the end hour of this booking agenda
	 */
	@Override
	public long getEndHour() {
		return model.getEndHour();
	}

	/**
	 * Returns the group ID of this booking agenda.
	 *
	 * @return the group ID of this booking agenda
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this booking agenda.
	 *
	 * @return the modified date of this booking agenda
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this booking agenda.
	 *
	 * @return the primary key of this booking agenda
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the start hour of this booking agenda.
	 *
	 * @return the start hour of this booking agenda
	 */
	@Override
	public long getStartHour() {
		return model.getStartHour();
	}

	/**
	 * Returns the title of this booking agenda.
	 *
	 * @return the title of this booking agenda
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this booking agenda.
	 *
	 * @return the user ID of this booking agenda
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this booking agenda.
	 *
	 * @return the user name of this booking agenda
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this booking agenda.
	 *
	 * @return the user uuid of this booking agenda
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this booking agenda.
	 *
	 * @return the uuid of this booking agenda
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
	 * Sets the calendar booking agenda ID of this booking agenda.
	 *
	 * @param calendarBookingAgendaId the calendar booking agenda ID of this booking agenda
	 */
	@Override
	public void setCalendarBookingAgendaId(long calendarBookingAgendaId) {
		model.setCalendarBookingAgendaId(calendarBookingAgendaId);
	}

	/**
	 * Sets the calendar booking ID of this booking agenda.
	 *
	 * @param calendarBookingId the calendar booking ID of this booking agenda
	 */
	@Override
	public void setCalendarBookingId(long calendarBookingId) {
		model.setCalendarBookingId(calendarBookingId);
	}

	/**
	 * Sets the company ID of this booking agenda.
	 *
	 * @param companyId the company ID of this booking agenda
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this booking agenda.
	 *
	 * @param createDate the create date of this booking agenda
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the day of this booking agenda.
	 *
	 * @param day the day of this booking agenda
	 */
	@Override
	public void setDay(long day) {
		model.setDay(day);
	}

	/**
	 * Sets the description of this booking agenda.
	 *
	 * @param description the description of this booking agenda
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the end hour of this booking agenda.
	 *
	 * @param endHour the end hour of this booking agenda
	 */
	@Override
	public void setEndHour(long endHour) {
		model.setEndHour(endHour);
	}

	/**
	 * Sets the group ID of this booking agenda.
	 *
	 * @param groupId the group ID of this booking agenda
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this booking agenda.
	 *
	 * @param modifiedDate the modified date of this booking agenda
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this booking agenda.
	 *
	 * @param primaryKey the primary key of this booking agenda
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the start hour of this booking agenda.
	 *
	 * @param startHour the start hour of this booking agenda
	 */
	@Override
	public void setStartHour(long startHour) {
		model.setStartHour(startHour);
	}

	/**
	 * Sets the title of this booking agenda.
	 *
	 * @param title the title of this booking agenda
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this booking agenda.
	 *
	 * @param userId the user ID of this booking agenda
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this booking agenda.
	 *
	 * @param userName the user name of this booking agenda
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this booking agenda.
	 *
	 * @param userUuid the user uuid of this booking agenda
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this booking agenda.
	 *
	 * @param uuid the uuid of this booking agenda
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
	protected BookingAgendaWrapper wrap(BookingAgenda bookingAgenda) {
		return new BookingAgendaWrapper(bookingAgenda);
	}

}