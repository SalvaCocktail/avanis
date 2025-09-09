/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.social.follow.sb.model.impl;

import avanis.social.follow.sb.model.SocialFollow;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SocialFollow in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SocialFollowCacheModel
	implements CacheModel<SocialFollow>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SocialFollowCacheModel)) {
			return false;
		}

		SocialFollowCacheModel socialFollowCacheModel =
			(SocialFollowCacheModel)object;

		if (socialFollowId == socialFollowCacheModel.socialFollowId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, socialFollowId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", socialFollowId=");
		sb.append(socialFollowId);
		sb.append(", accepted=");
		sb.append(accepted);
		sb.append(", followsTo=");
		sb.append(followsTo);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SocialFollow toEntityModel() {
		SocialFollowImpl socialFollowImpl = new SocialFollowImpl();

		if (uuid == null) {
			socialFollowImpl.setUuid("");
		}
		else {
			socialFollowImpl.setUuid(uuid);
		}

		socialFollowImpl.setSocialFollowId(socialFollowId);
		socialFollowImpl.setAccepted(accepted);
		socialFollowImpl.setFollowsTo(followsTo);
		socialFollowImpl.setGroupId(groupId);
		socialFollowImpl.setCompanyId(companyId);
		socialFollowImpl.setUserId(userId);

		if (userName == null) {
			socialFollowImpl.setUserName("");
		}
		else {
			socialFollowImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			socialFollowImpl.setCreateDate(null);
		}
		else {
			socialFollowImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			socialFollowImpl.setModifiedDate(null);
		}
		else {
			socialFollowImpl.setModifiedDate(new Date(modifiedDate));
		}

		socialFollowImpl.resetOriginalValues();

		return socialFollowImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		socialFollowId = objectInput.readLong();

		accepted = objectInput.readBoolean();

		followsTo = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(socialFollowId);

		objectOutput.writeBoolean(accepted);

		objectOutput.writeLong(followsTo);

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
	}

	public String uuid;
	public long socialFollowId;
	public boolean accepted;
	public long followsTo;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}