/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.model.impl;

import avanis.comunidad.model.AnswersUser;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AnswersUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AnswersUserCacheModel
	implements CacheModel<AnswersUser>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AnswersUserCacheModel)) {
			return false;
		}

		AnswersUserCacheModel answersUserCacheModel =
			(AnswersUserCacheModel)object;

		if (answerUserId == answersUserCacheModel.answerUserId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, answerUserId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", answerUserId=");
		sb.append(answerUserId);
		sb.append(", answerId=");
		sb.append(answerId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", surveyId=");
		sb.append(surveyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AnswersUser toEntityModel() {
		AnswersUserImpl answersUserImpl = new AnswersUserImpl();

		if (uuid == null) {
			answersUserImpl.setUuid("");
		}
		else {
			answersUserImpl.setUuid(uuid);
		}

		answersUserImpl.setAnswerUserId(answerUserId);
		answersUserImpl.setAnswerId(answerId);
		answersUserImpl.setUserId(userId);
		answersUserImpl.setSurveyId(surveyId);

		if (createDate == Long.MIN_VALUE) {
			answersUserImpl.setCreateDate(null);
		}
		else {
			answersUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			answersUserImpl.setModifiedDate(null);
		}
		else {
			answersUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		answersUserImpl.resetOriginalValues();

		return answersUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		answerUserId = objectInput.readLong();

		answerId = objectInput.readLong();

		userId = objectInput.readLong();

		surveyId = objectInput.readLong();
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

		objectOutput.writeLong(answerUserId);

		objectOutput.writeLong(answerId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(surveyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long answerUserId;
	public long answerId;
	public long userId;
	public long surveyId;
	public long createDate;
	public long modifiedDate;

}