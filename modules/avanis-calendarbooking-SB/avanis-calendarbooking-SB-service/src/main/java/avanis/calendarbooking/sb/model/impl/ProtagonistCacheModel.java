/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.model.impl;

import avanis.calendarbooking.sb.model.Protagonist;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Protagonist in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProtagonistCacheModel
	implements CacheModel<Protagonist>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProtagonistCacheModel)) {
			return false;
		}

		ProtagonistCacheModel protagonistCacheModel =
			(ProtagonistCacheModel)object;

		if (protagonistId == protagonistCacheModel.protagonistId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, protagonistId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", protagonistId=");
		sb.append(protagonistId);
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
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", profession=");
		sb.append(profession);
		sb.append(", bio=");
		sb.append(bio);
		sb.append(", portraitUrl=");
		sb.append(portraitUrl);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Protagonist toEntityModel() {
		ProtagonistImpl protagonistImpl = new ProtagonistImpl();

		if (uuid == null) {
			protagonistImpl.setUuid("");
		}
		else {
			protagonistImpl.setUuid(uuid);
		}

		protagonistImpl.setProtagonistId(protagonistId);
		protagonistImpl.setCalendarBookingId(calendarBookingId);
		protagonistImpl.setGroupId(groupId);
		protagonistImpl.setCompanyId(companyId);
		protagonistImpl.setUserId(userId);

		if (userName == null) {
			protagonistImpl.setUserName("");
		}
		else {
			protagonistImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			protagonistImpl.setCreateDate(null);
		}
		else {
			protagonistImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			protagonistImpl.setModifiedDate(null);
		}
		else {
			protagonistImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			protagonistImpl.setName("");
		}
		else {
			protagonistImpl.setName(name);
		}

		if (lastName == null) {
			protagonistImpl.setLastName("");
		}
		else {
			protagonistImpl.setLastName(lastName);
		}

		if (profession == null) {
			protagonistImpl.setProfession("");
		}
		else {
			protagonistImpl.setProfession(profession);
		}

		if (bio == null) {
			protagonistImpl.setBio("");
		}
		else {
			protagonistImpl.setBio(bio);
		}

		if (portraitUrl == null) {
			protagonistImpl.setPortraitUrl("");
		}
		else {
			protagonistImpl.setPortraitUrl(portraitUrl);
		}

		protagonistImpl.resetOriginalValues();

		return protagonistImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		protagonistId = objectInput.readLong();

		calendarBookingId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		lastName = objectInput.readUTF();
		profession = objectInput.readUTF();
		bio = objectInput.readUTF();
		portraitUrl = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(protagonistId);

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

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (profession == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(profession);
		}

		if (bio == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bio);
		}

		if (portraitUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(portraitUrl);
		}
	}

	public String uuid;
	public long protagonistId;
	public long calendarBookingId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String lastName;
	public String profession;
	public String bio;
	public String portraitUrl;

}