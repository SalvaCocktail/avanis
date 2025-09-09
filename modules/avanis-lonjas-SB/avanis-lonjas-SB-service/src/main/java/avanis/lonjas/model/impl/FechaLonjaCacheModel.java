/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.model.impl;

import avanis.lonjas.model.FechaLonja;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FechaLonja in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FechaLonjaCacheModel
	implements CacheModel<FechaLonja>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FechaLonjaCacheModel)) {
			return false;
		}

		FechaLonjaCacheModel fechaLonjaCacheModel =
			(FechaLonjaCacheModel)object;

		if (entityId == fechaLonjaCacheModel.entityId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, entityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", entityId=");
		sb.append(entityId);
		sb.append(", lonjaId=");
		sb.append(lonjaId);
		sb.append(", fecha=");
		sb.append(fecha);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FechaLonja toEntityModel() {
		FechaLonjaImpl fechaLonjaImpl = new FechaLonjaImpl();

		if (uuid == null) {
			fechaLonjaImpl.setUuid("");
		}
		else {
			fechaLonjaImpl.setUuid(uuid);
		}

		fechaLonjaImpl.setEntityId(entityId);
		fechaLonjaImpl.setLonjaId(lonjaId);

		if (fecha == Long.MIN_VALUE) {
			fechaLonjaImpl.setFecha(null);
		}
		else {
			fechaLonjaImpl.setFecha(new Date(fecha));
		}

		if (createDate == Long.MIN_VALUE) {
			fechaLonjaImpl.setCreateDate(null);
		}
		else {
			fechaLonjaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			fechaLonjaImpl.setModifiedDate(null);
		}
		else {
			fechaLonjaImpl.setModifiedDate(new Date(modifiedDate));
		}

		fechaLonjaImpl.resetOriginalValues();

		return fechaLonjaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		entityId = objectInput.readLong();

		lonjaId = objectInput.readLong();
		fecha = objectInput.readLong();
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

		objectOutput.writeLong(entityId);

		objectOutput.writeLong(lonjaId);
		objectOutput.writeLong(fecha);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long entityId;
	public long lonjaId;
	public long fecha;
	public long createDate;
	public long modifiedDate;

}