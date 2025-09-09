/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.model.impl;

import avanis.lonjas.model.Area;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Area in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AreaCacheModel implements CacheModel<Area>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AreaCacheModel)) {
			return false;
		}

		AreaCacheModel areaCacheModel = (AreaCacheModel)object;

		if (entityId == areaCacheModel.entityId) {
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
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", entityId=");
		sb.append(entityId);
		sb.append(", areaId=");
		sb.append(areaId);
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
	public Area toEntityModel() {
		AreaImpl areaImpl = new AreaImpl();

		if (uuid == null) {
			areaImpl.setUuid("");
		}
		else {
			areaImpl.setUuid(uuid);
		}

		areaImpl.setEntityId(entityId);
		areaImpl.setAreaId(areaId);
		areaImpl.setSubGrupoId(subGrupoId);
		areaImpl.setGrupoId(grupoId);

		if (nombre == null) {
			areaImpl.setNombre("");
		}
		else {
			areaImpl.setNombre(nombre);
		}

		if (createDate == Long.MIN_VALUE) {
			areaImpl.setCreateDate(null);
		}
		else {
			areaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			areaImpl.setModifiedDate(null);
		}
		else {
			areaImpl.setModifiedDate(new Date(modifiedDate));
		}

		areaImpl.resetOriginalValues();

		return areaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		entityId = objectInput.readLong();

		areaId = objectInput.readLong();

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

		objectOutput.writeLong(areaId);

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
	public long areaId;
	public long subGrupoId;
	public long grupoId;
	public String nombre;
	public long createDate;
	public long modifiedDate;

}