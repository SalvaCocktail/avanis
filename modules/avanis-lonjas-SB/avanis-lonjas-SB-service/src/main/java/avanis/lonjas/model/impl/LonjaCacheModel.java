/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.model.impl;

import avanis.lonjas.model.Lonja;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Lonja in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LonjaCacheModel implements CacheModel<Lonja>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LonjaCacheModel)) {
			return false;
		}

		LonjaCacheModel lonjaCacheModel = (LonjaCacheModel)object;

		if (entityId == lonjaCacheModel.entityId) {
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
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", entityId=");
		sb.append(entityId);
		sb.append(", lonjaId=");
		sb.append(lonjaId);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append(", pais=");
		sb.append(pais);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Lonja toEntityModel() {
		LonjaImpl lonjaImpl = new LonjaImpl();

		if (uuid == null) {
			lonjaImpl.setUuid("");
		}
		else {
			lonjaImpl.setUuid(uuid);
		}

		lonjaImpl.setEntityId(entityId);
		lonjaImpl.setLonjaId(lonjaId);

		if (nombre == null) {
			lonjaImpl.setNombre("");
		}
		else {
			lonjaImpl.setNombre(nombre);
		}

		if (pais == null) {
			lonjaImpl.setPais("");
		}
		else {
			lonjaImpl.setPais(pais);
		}

		if (createDate == Long.MIN_VALUE) {
			lonjaImpl.setCreateDate(null);
		}
		else {
			lonjaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			lonjaImpl.setModifiedDate(null);
		}
		else {
			lonjaImpl.setModifiedDate(new Date(modifiedDate));
		}

		lonjaImpl.resetOriginalValues();

		return lonjaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		entityId = objectInput.readLong();

		lonjaId = objectInput.readLong();
		nombre = objectInput.readUTF();
		pais = objectInput.readUTF();
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

		if (nombre == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nombre);
		}

		if (pais == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pais);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long entityId;
	public long lonjaId;
	public String nombre;
	public String pais;
	public long createDate;
	public long modifiedDate;

}