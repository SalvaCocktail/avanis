/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.model.impl;

import avanis.comunidad.model.Answers;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Answers in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AnswersCacheModel implements CacheModel<Answers>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AnswersCacheModel)) {
			return false;
		}

		AnswersCacheModel answersCacheModel = (AnswersCacheModel)object;

		if (answerId == answersCacheModel.answerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, answerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", answerId=");
		sb.append(answerId);
		sb.append(", surveyId=");
		sb.append(surveyId);
		sb.append(", answer=");
		sb.append(answer);
		sb.append(", counterAnswer=");
		sb.append(counterAnswer);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Answers toEntityModel() {
		AnswersImpl answersImpl = new AnswersImpl();

		if (uuid == null) {
			answersImpl.setUuid("");
		}
		else {
			answersImpl.setUuid(uuid);
		}

		answersImpl.setAnswerId(answerId);
		answersImpl.setSurveyId(surveyId);

		if (answer == null) {
			answersImpl.setAnswer("");
		}
		else {
			answersImpl.setAnswer(answer);
		}

		answersImpl.setCounterAnswer(counterAnswer);

		if (createDate == Long.MIN_VALUE) {
			answersImpl.setCreateDate(null);
		}
		else {
			answersImpl.setCreateDate(new Date(createDate));
		}

		answersImpl.resetOriginalValues();

		return answersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		answerId = objectInput.readLong();

		surveyId = objectInput.readLong();
		answer = objectInput.readUTF();

		counterAnswer = objectInput.readInt();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(answerId);

		objectOutput.writeLong(surveyId);

		if (answer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(answer);
		}

		objectOutput.writeInt(counterAnswer);
		objectOutput.writeLong(createDate);
	}

	public String uuid;
	public long answerId;
	public long surveyId;
	public String answer;
	public int counterAnswer;
	public long createDate;

}