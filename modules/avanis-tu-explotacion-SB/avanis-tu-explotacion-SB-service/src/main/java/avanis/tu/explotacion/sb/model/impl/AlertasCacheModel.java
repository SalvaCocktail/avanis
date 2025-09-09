/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.tu.explotacion.sb.model.impl;

import avanis.tu.explotacion.sb.model.Alertas;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Alertas in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AlertasCacheModel implements CacheModel<Alertas>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AlertasCacheModel)) {
			return false;
		}

		AlertasCacheModel alertasCacheModel = (AlertasCacheModel)object;

		if (alertaId == alertasCacheModel.alertaId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, alertaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", alertaId=");
		sb.append(alertaId);
		sb.append(", explotacionId=");
		sb.append(explotacionId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", risk=");
		sb.append(risk);
		sb.append(", phenomenom=");
		sb.append(phenomenom);
		sb.append(", scope=");
		sb.append(scope);
		sb.append(", probability=");
		sb.append(probability);
		sb.append(", type=");
		sb.append(type);
		sb.append(", readed=");
		sb.append(readed);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", externalCodeReference=");
		sb.append(externalCodeReference);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Alertas toEntityModel() {
		AlertasImpl alertasImpl = new AlertasImpl();

		if (uuid == null) {
			alertasImpl.setUuid("");
		}
		else {
			alertasImpl.setUuid(uuid);
		}

		alertasImpl.setAlertaId(alertaId);
		alertasImpl.setExplotacionId(explotacionId);
		alertasImpl.setUserId(userId);

		if (description == null) {
			alertasImpl.setDescription("");
		}
		else {
			alertasImpl.setDescription(description);
		}

		if (endDate == null) {
			alertasImpl.setEndDate("");
		}
		else {
			alertasImpl.setEndDate(endDate);
		}

		if (startDate == null) {
			alertasImpl.setStartDate("");
		}
		else {
			alertasImpl.setStartDate(startDate);
		}

		if (risk == null) {
			alertasImpl.setRisk("");
		}
		else {
			alertasImpl.setRisk(risk);
		}

		if (phenomenom == null) {
			alertasImpl.setPhenomenom("");
		}
		else {
			alertasImpl.setPhenomenom(phenomenom);
		}

		if (scope == null) {
			alertasImpl.setScope("");
		}
		else {
			alertasImpl.setScope(scope);
		}

		if (probability == null) {
			alertasImpl.setProbability("");
		}
		else {
			alertasImpl.setProbability(probability);
		}

		if (type == null) {
			alertasImpl.setType("");
		}
		else {
			alertasImpl.setType(type);
		}

		alertasImpl.setReaded(readed);

		if (createDate == Long.MIN_VALUE) {
			alertasImpl.setCreateDate(null);
		}
		else {
			alertasImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			alertasImpl.setModifiedDate(null);
		}
		else {
			alertasImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (externalCodeReference == null) {
			alertasImpl.setExternalCodeReference("");
		}
		else {
			alertasImpl.setExternalCodeReference(externalCodeReference);
		}

		alertasImpl.resetOriginalValues();

		return alertasImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		alertaId = objectInput.readLong();

		explotacionId = objectInput.readLong();

		userId = objectInput.readLong();
		description = objectInput.readUTF();
		endDate = objectInput.readUTF();
		startDate = objectInput.readUTF();
		risk = objectInput.readUTF();
		phenomenom = objectInput.readUTF();
		scope = objectInput.readUTF();
		probability = objectInput.readUTF();
		type = objectInput.readUTF();

		readed = objectInput.readBoolean();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		externalCodeReference = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(alertaId);

		objectOutput.writeLong(explotacionId);

		objectOutput.writeLong(userId);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (endDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(endDate);
		}

		if (startDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(startDate);
		}

		if (risk == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(risk);
		}

		if (phenomenom == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phenomenom);
		}

		if (scope == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(scope);
		}

		if (probability == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(probability);
		}

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeBoolean(readed);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (externalCodeReference == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalCodeReference);
		}
	}

	public String uuid;
	public long alertaId;
	public long explotacionId;
	public long userId;
	public String description;
	public String endDate;
	public String startDate;
	public String risk;
	public String phenomenom;
	public String scope;
	public String probability;
	public String type;
	public boolean readed;
	public long createDate;
	public long modifiedDate;
	public String externalCodeReference;

}