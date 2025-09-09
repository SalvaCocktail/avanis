/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.model.impl;

import avanis.comunidad.model.Surveys;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Surveys in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SurveysCacheModel implements CacheModel<Surveys>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SurveysCacheModel)) {
			return false;
		}

		SurveysCacheModel surveysCacheModel = (SurveysCacheModel)object;

		if (surveyId == surveysCacheModel.surveyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, surveyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", surveyId=");
		sb.append(surveyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", assetId=");
		sb.append(assetId);
		sb.append(", question=");
		sb.append(question);
		sb.append(", expireHours=");
		sb.append(expireHours);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", expireDate=");
		sb.append(expireDate);
		sb.append(", notified=");
		sb.append(notified);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Surveys toEntityModel() {
		SurveysImpl surveysImpl = new SurveysImpl();

		if (uuid == null) {
			surveysImpl.setUuid("");
		}
		else {
			surveysImpl.setUuid(uuid);
		}

		surveysImpl.setSurveyId(surveyId);
		surveysImpl.setGroupId(groupId);
		surveysImpl.setUserId(userId);
		surveysImpl.setAssetId(assetId);

		if (question == null) {
			surveysImpl.setQuestion("");
		}
		else {
			surveysImpl.setQuestion(question);
		}

		surveysImpl.setExpireHours(expireHours);

		if (createDate == Long.MIN_VALUE) {
			surveysImpl.setCreateDate(null);
		}
		else {
			surveysImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			surveysImpl.setModifiedDate(null);
		}
		else {
			surveysImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (expireDate == Long.MIN_VALUE) {
			surveysImpl.setExpireDate(null);
		}
		else {
			surveysImpl.setExpireDate(new Date(expireDate));
		}

		surveysImpl.setNotified(notified);

		surveysImpl.resetOriginalValues();

		return surveysImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		surveyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();

		assetId = objectInput.readLong();
		question = objectInput.readUTF();

		expireHours = objectInput.readInt();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		expireDate = objectInput.readLong();

		notified = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(surveyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(assetId);

		if (question == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(question);
		}

		objectOutput.writeInt(expireHours);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(expireDate);

		objectOutput.writeBoolean(notified);
	}

	public String uuid;
	public long surveyId;
	public long groupId;
	public long userId;
	public long assetId;
	public String question;
	public int expireHours;
	public long createDate;
	public long modifiedDate;
	public long expireDate;
	public boolean notified;

}