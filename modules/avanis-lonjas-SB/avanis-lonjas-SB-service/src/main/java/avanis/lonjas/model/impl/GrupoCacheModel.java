/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.model.impl;

import avanis.lonjas.model.Grupo;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Grupo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GrupoCacheModel implements CacheModel<Grupo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof GrupoCacheModel)) {
			return false;
		}

		GrupoCacheModel grupoCacheModel = (GrupoCacheModel)object;

		if (entityId == grupoCacheModel.entityId) {
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
		sb.append(", grupoId=");
		sb.append(grupoId);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Grupo toEntityModel() {
		GrupoImpl grupoImpl = new GrupoImpl();

		if (uuid == null) {
			grupoImpl.setUuid("");
		}
		else {
			grupoImpl.setUuid(uuid);
		}

		grupoImpl.setEntityId(entityId);
		grupoImpl.setGrupoId(grupoId);

		if (nombre == null) {
			grupoImpl.setNombre("");
		}
		else {
			grupoImpl.setNombre(nombre);
		}

		if (createDate == Long.MIN_VALUE) {
			grupoImpl.setCreateDate(null);
		}
		else {
			grupoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			grupoImpl.setModifiedDate(null);
		}
		else {
			grupoImpl.setModifiedDate(new Date(modifiedDate));
		}

		grupoImpl.resetOriginalValues();

		return grupoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		entityId = objectInput.readLong();

		grupoId = objectInput.readLong();
		nombre = objectInput.readUTF();
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

		objectOutput.writeLong(grupoId);

		if (nombre == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nombre);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long entityId;
	public long grupoId;
	public String nombre;
	public long createDate;
	public long modifiedDate;

}