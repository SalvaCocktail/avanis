/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.model.impl;

import avanis.lonjas.model.ProductoExplot;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProductoExplot in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductoExplotCacheModel
	implements CacheModel<ProductoExplot>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductoExplotCacheModel)) {
			return false;
		}

		ProductoExplotCacheModel productoExplotCacheModel =
			(ProductoExplotCacheModel)object;

		if (entityId == productoExplotCacheModel.entityId) {
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
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", entityId=");
		sb.append(entityId);
		sb.append(", lonjaId=");
		sb.append(lonjaId);
		sb.append(", productoId=");
		sb.append(productoId);
		sb.append(", precioLonjaId=");
		sb.append(precioLonjaId);
		sb.append(", explotacionId=");
		sb.append(explotacionId);
		sb.append(", orden=");
		sb.append(orden);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProductoExplot toEntityModel() {
		ProductoExplotImpl productoExplotImpl = new ProductoExplotImpl();

		if (uuid == null) {
			productoExplotImpl.setUuid("");
		}
		else {
			productoExplotImpl.setUuid(uuid);
		}

		productoExplotImpl.setEntityId(entityId);
		productoExplotImpl.setLonjaId(lonjaId);
		productoExplotImpl.setProductoId(productoId);
		productoExplotImpl.setPrecioLonjaId(precioLonjaId);
		productoExplotImpl.setExplotacionId(explotacionId);
		productoExplotImpl.setOrden(orden);

		if (createDate == Long.MIN_VALUE) {
			productoExplotImpl.setCreateDate(null);
		}
		else {
			productoExplotImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			productoExplotImpl.setModifiedDate(null);
		}
		else {
			productoExplotImpl.setModifiedDate(new Date(modifiedDate));
		}

		productoExplotImpl.resetOriginalValues();

		return productoExplotImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		entityId = objectInput.readLong();

		lonjaId = objectInput.readLong();

		productoId = objectInput.readLong();

		precioLonjaId = objectInput.readLong();

		explotacionId = objectInput.readLong();

		orden = objectInput.readLong();
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

		objectOutput.writeLong(productoId);

		objectOutput.writeLong(precioLonjaId);

		objectOutput.writeLong(explotacionId);

		objectOutput.writeLong(orden);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long entityId;
	public long lonjaId;
	public long productoId;
	public long precioLonjaId;
	public long explotacionId;
	public long orden;
	public long createDate;
	public long modifiedDate;

}