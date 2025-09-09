/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.model.impl;

import avanis.lonjas.model.SubGrupo;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SubGrupo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SubGrupoCacheModel
	implements CacheModel<SubGrupo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SubGrupoCacheModel)) {
			return false;
		}

		SubGrupoCacheModel subGrupoCacheModel = (SubGrupoCacheModel)object;

		if (entityId == subGrupoCacheModel.entityId) {
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
		sb.append(", subGrupoId=");
		sb.append(subGrupoId);
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
	public SubGrupo toEntityModel() {
		SubGrupoImpl subGrupoImpl = new SubGrupoImpl();

		if (uuid == null) {
			subGrupoImpl.setUuid("");
		}
		else {
			subGrupoImpl.setUuid(uuid);
		}

		subGrupoImpl.setEntityId(entityId);
		subGrupoImpl.setSubGrupoId(subGrupoId);
		subGrupoImpl.setGrupoId(grupoId);

		if (nombre == null) {
			subGrupoImpl.setNombre("");
		}
		else {
			subGrupoImpl.setNombre(nombre);
		}

		if (createDate == Long.MIN_VALUE) {
			subGrupoImpl.setCreateDate(null);
		}
		else {
			subGrupoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			subGrupoImpl.setModifiedDate(null);
		}
		else {
			subGrupoImpl.setModifiedDate(new Date(modifiedDate));
		}

		subGrupoImpl.resetOriginalValues();

		return subGrupoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		entityId = objectInput.readLong();

		subGrupoId = objectInput.readLong();

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

		objectOutput.writeLong(subGrupoId);

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
	public long subGrupoId;
	public long grupoId;
	public String nombre;
	public long createDate;
	public long modifiedDate;

}