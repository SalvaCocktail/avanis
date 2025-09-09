/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.model.impl;

import avanis.calendarbooking.sb.model.BookingAgenda;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BookingAgenda in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BookingAgendaCacheModel
	implements CacheModel<BookingAgenda>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BookingAgendaCacheModel)) {
			return false;
		}

		BookingAgendaCacheModel bookingAgendaCacheModel =
			(BookingAgendaCacheModel)object;

		if (calendarBookingAgendaId ==
				bookingAgendaCacheModel.calendarBookingAgendaId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, calendarBookingAgendaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", calendarBookingAgendaId=");
		sb.append(calendarBookingAgendaId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", day=");
		sb.append(day);
		sb.append(", startHour=");
		sb.append(startHour);
		sb.append(", endHour=");
		sb.append(endHour);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", calendarBookingId=");
		sb.append(calendarBookingId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BookingAgenda toEntityModel() {
		BookingAgendaImpl bookingAgendaImpl = new BookingAgendaImpl();

		if (uuid == null) {
			bookingAgendaImpl.setUuid("");
		}
		else {
			bookingAgendaImpl.setUuid(uuid);
		}

		bookingAgendaImpl.setCalendarBookingAgendaId(calendarBookingAgendaId);
		bookingAgendaImpl.setGroupId(groupId);
		bookingAgendaImpl.setCompanyId(companyId);
		bookingAgendaImpl.setUserId(userId);

		if (userName == null) {
			bookingAgendaImpl.setUserName("");
		}
		else {
			bookingAgendaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			bookingAgendaImpl.setCreateDate(null);
		}
		else {
			bookingAgendaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			bookingAgendaImpl.setModifiedDate(null);
		}
		else {
			bookingAgendaImpl.setModifiedDate(new Date(modifiedDate));
		}

		bookingAgendaImpl.setDay(day);
		bookingAgendaImpl.setStartHour(startHour);
		bookingAgendaImpl.setEndHour(endHour);

		if (title == null) {
			bookingAgendaImpl.setTitle("");
		}
		else {
			bookingAgendaImpl.setTitle(title);
		}

		if (description == null) {
			bookingAgendaImpl.setDescription("");
		}
		else {
			bookingAgendaImpl.setDescription(description);
		}

		bookingAgendaImpl.setCalendarBookingId(calendarBookingId);

		bookingAgendaImpl.resetOriginalValues();

		return bookingAgendaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		calendarBookingAgendaId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		day = objectInput.readLong();

		startHour = objectInput.readLong();

		endHour = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();

		calendarBookingId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(calendarBookingAgendaId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(day);

		objectOutput.writeLong(startHour);

		objectOutput.writeLong(endHour);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(calendarBookingId);
	}

	public String uuid;
	public long calendarBookingAgendaId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long day;
	public long startHour;
	public long endHour;
	public String title;
	public String description;
	public long calendarBookingId;

}