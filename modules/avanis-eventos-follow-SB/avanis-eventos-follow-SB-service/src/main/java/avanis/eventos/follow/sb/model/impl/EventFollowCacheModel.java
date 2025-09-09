/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.eventos.follow.sb.model.impl;

import avanis.eventos.follow.sb.model.EventFollow;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EventFollow in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EventFollowCacheModel
	implements CacheModel<EventFollow>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EventFollowCacheModel)) {
			return false;
		}

		EventFollowCacheModel eventFollowCacheModel =
			(EventFollowCacheModel)object;

		if (eventFollowId == eventFollowCacheModel.eventFollowId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, eventFollowId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", eventFollowId=");
		sb.append(eventFollowId);
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
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EventFollow toEntityModel() {
		EventFollowImpl eventFollowImpl = new EventFollowImpl();

		if (uuid == null) {
			eventFollowImpl.setUuid("");
		}
		else {
			eventFollowImpl.setUuid(uuid);
		}

		eventFollowImpl.setEventFollowId(eventFollowId);
		eventFollowImpl.setGroupId(groupId);
		eventFollowImpl.setCompanyId(companyId);
		eventFollowImpl.setUserId(userId);

		if (userName == null) {
			eventFollowImpl.setUserName("");
		}
		else {
			eventFollowImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			eventFollowImpl.setCreateDate(null);
		}
		else {
			eventFollowImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			eventFollowImpl.setModifiedDate(null);
		}
		else {
			eventFollowImpl.setModifiedDate(new Date(modifiedDate));
		}

		eventFollowImpl.setEventId(eventId);

		eventFollowImpl.resetOriginalValues();

		return eventFollowImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		eventFollowId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		eventId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(eventFollowId);

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

		objectOutput.writeLong(eventId);
	}

	public String uuid;
	public long eventFollowId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long eventId;

}