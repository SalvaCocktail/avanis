/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.model.impl;

import avanis.calendarbooking.sb.model.Sponsor;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Sponsor in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SponsorCacheModel implements CacheModel<Sponsor>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SponsorCacheModel)) {
			return false;
		}

		SponsorCacheModel sponsorCacheModel = (SponsorCacheModel)object;

		if (sponsorId == sponsorCacheModel.sponsorId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, sponsorId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", sponsorId=");
		sb.append(sponsorId);
		sb.append(", calendarBookingId=");
		sb.append(calendarBookingId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", iconUrl=");
		sb.append(iconUrl);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Sponsor toEntityModel() {
		SponsorImpl sponsorImpl = new SponsorImpl();

		if (uuid == null) {
			sponsorImpl.setUuid("");
		}
		else {
			sponsorImpl.setUuid(uuid);
		}

		sponsorImpl.setSponsorId(sponsorId);
		sponsorImpl.setCalendarBookingId(calendarBookingId);
		sponsorImpl.setGroupId(groupId);
		sponsorImpl.setCompanyId(companyId);
		sponsorImpl.setUserId(userId);

		if (userName == null) {
			sponsorImpl.setUserName("");
		}
		else {
			sponsorImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			sponsorImpl.setCreateDate(null);
		}
		else {
			sponsorImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			sponsorImpl.setModifiedDate(null);
		}
		else {
			sponsorImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			sponsorImpl.setName("");
		}
		else {
			sponsorImpl.setName(name);
		}

		if (iconUrl == null) {
			sponsorImpl.setIconUrl("");
		}
		else {
			sponsorImpl.setIconUrl(iconUrl);
		}

		sponsorImpl.resetOriginalValues();

		return sponsorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		sponsorId = objectInput.readLong();

		calendarBookingId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		iconUrl = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(sponsorId);

		objectOutput.writeLong(calendarBookingId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (iconUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(iconUrl);
		}
	}

	public String uuid;
	public long sponsorId;
	public long calendarBookingId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String iconUrl;

}