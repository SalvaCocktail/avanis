/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.tu.explotacion.sb.model.impl;

import avanis.tu.explotacion.sb.model.Explotacion;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Explotacion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ExplotacionCacheModel
	implements CacheModel<Explotacion>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ExplotacionCacheModel)) {
			return false;
		}

		ExplotacionCacheModel explotacionCacheModel =
			(ExplotacionCacheModel)object;

		if (explotacionId == explotacionCacheModel.explotacionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, explotacionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", explotacionId=");
		sb.append(explotacionId);
		sb.append(", provincia=");
		sb.append(provincia);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", height=");
		sb.append(height);
		sb.append(", location=");
		sb.append(location);
		sb.append(", name=");
		sb.append(name);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append(", meteoredid=");
		sb.append(meteoredid);
		sb.append(", size=");
		sb.append(size);
		sb.append(", sizeUnit=");
		sb.append(sizeUnit);
		sb.append(", isMain=");
		sb.append(isMain);
		sb.append(", allowNotifications=");
		sb.append(allowNotifications);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
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
	public Explotacion toEntityModel() {
		ExplotacionImpl explotacionImpl = new ExplotacionImpl();

		if (uuid == null) {
			explotacionImpl.setUuid("");
		}
		else {
			explotacionImpl.setUuid(uuid);
		}

		explotacionImpl.setExplotacionId(explotacionId);

		if (provincia == null) {
			explotacionImpl.setProvincia("");
		}
		else {
			explotacionImpl.setProvincia(provincia);
		}

		explotacionImpl.setLongitude(longitude);
		explotacionImpl.setHeight(height);

		if (location == null) {
			explotacionImpl.setLocation("");
		}
		else {
			explotacionImpl.setLocation(location);
		}

		if (name == null) {
			explotacionImpl.setName("");
		}
		else {
			explotacionImpl.setName(name);
		}

		explotacionImpl.setLatitude(latitude);

		if (meteoredid == null) {
			explotacionImpl.setMeteoredid("");
		}
		else {
			explotacionImpl.setMeteoredid(meteoredid);
		}

		explotacionImpl.setSize(size);

		if (sizeUnit == null) {
			explotacionImpl.setSizeUnit("");
		}
		else {
			explotacionImpl.setSizeUnit(sizeUnit);
		}

		explotacionImpl.setIsMain(isMain);
		explotacionImpl.setAllowNotifications(allowNotifications);
		explotacionImpl.setUserId(userId);

		if (userName == null) {
			explotacionImpl.setUserName("");
		}
		else {
			explotacionImpl.setUserName(userName);
		}

		explotacionImpl.setReaded(readed);

		if (createDate == Long.MIN_VALUE) {
			explotacionImpl.setCreateDate(null);
		}
		else {
			explotacionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			explotacionImpl.setModifiedDate(null);
		}
		else {
			explotacionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (externalCodeReference == null) {
			explotacionImpl.setExternalCodeReference("");
		}
		else {
			explotacionImpl.setExternalCodeReference(externalCodeReference);
		}

		explotacionImpl.resetOriginalValues();

		return explotacionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		explotacionId = objectInput.readLong();
		provincia = objectInput.readUTF();

		longitude = objectInput.readDouble();

		height = objectInput.readInt();
		location = objectInput.readUTF();
		name = objectInput.readUTF();

		latitude = objectInput.readDouble();
		meteoredid = objectInput.readUTF();

		size = objectInput.readInt();
		sizeUnit = objectInput.readUTF();

		isMain = objectInput.readBoolean();

		allowNotifications = objectInput.readBoolean();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();

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

		objectOutput.writeLong(explotacionId);

		if (provincia == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(provincia);
		}

		objectOutput.writeDouble(longitude);

		objectOutput.writeInt(height);

		if (location == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(location);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeDouble(latitude);

		if (meteoredid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(meteoredid);
		}

		objectOutput.writeInt(size);

		if (sizeUnit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sizeUnit);
		}

		objectOutput.writeBoolean(isMain);

		objectOutput.writeBoolean(allowNotifications);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
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
	public long explotacionId;
	public String provincia;
	public double longitude;
	public int height;
	public String location;
	public String name;
	public double latitude;
	public String meteoredid;
	public int size;
	public String sizeUnit;
	public boolean isMain;
	public boolean allowNotifications;
	public long userId;
	public String userName;
	public boolean readed;
	public long createDate;
	public long modifiedDate;
	public String externalCodeReference;

}