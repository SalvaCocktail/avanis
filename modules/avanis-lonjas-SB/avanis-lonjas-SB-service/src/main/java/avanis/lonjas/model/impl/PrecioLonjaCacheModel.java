/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.model.impl;

import avanis.lonjas.model.PrecioLonja;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PrecioLonja in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PrecioLonjaCacheModel
	implements CacheModel<PrecioLonja>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PrecioLonjaCacheModel)) {
			return false;
		}

		PrecioLonjaCacheModel precioLonjaCacheModel =
			(PrecioLonjaCacheModel)object;

		if (entityId == precioLonjaCacheModel.entityId) {
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
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", entityId=");
		sb.append(entityId);
		sb.append(", productoId=");
		sb.append(productoId);
		sb.append(", lonjaId=");
		sb.append(lonjaId);
		sb.append(", grupoId=");
		sb.append(grupoId);
		sb.append(", subGrupoId=");
		sb.append(subGrupoId);
		sb.append(", areaId=");
		sb.append(areaId);
		sb.append(", fecha=");
		sb.append(fecha);
		sb.append(", nombreProducto=");
		sb.append(nombreProducto);
		sb.append(", precioAnterior=");
		sb.append(precioAnterior);
		sb.append(", precioUltimo=");
		sb.append(precioUltimo);
		sb.append(", precioMaximo=");
		sb.append(precioMaximo);
		sb.append(", precioMedio=");
		sb.append(precioMedio);
		sb.append(", precioMinimo=");
		sb.append(precioMinimo);
		sb.append(", precioOrigen=");
		sb.append(precioOrigen);
		sb.append(", anteriorEuros=");
		sb.append(anteriorEuros);
		sb.append(", ultimoEuros=");
		sb.append(ultimoEuros);
		sb.append(", unidadMedida=");
		sb.append(unidadMedida);
		sb.append(", unidadLarga=");
		sb.append(unidadLarga);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PrecioLonja toEntityModel() {
		PrecioLonjaImpl precioLonjaImpl = new PrecioLonjaImpl();

		if (uuid == null) {
			precioLonjaImpl.setUuid("");
		}
		else {
			precioLonjaImpl.setUuid(uuid);
		}

		precioLonjaImpl.setEntityId(entityId);
		precioLonjaImpl.setProductoId(productoId);
		precioLonjaImpl.setLonjaId(lonjaId);
		precioLonjaImpl.setGrupoId(grupoId);
		precioLonjaImpl.setSubGrupoId(subGrupoId);
		precioLonjaImpl.setAreaId(areaId);

		if (fecha == Long.MIN_VALUE) {
			precioLonjaImpl.setFecha(null);
		}
		else {
			precioLonjaImpl.setFecha(new Date(fecha));
		}

		if (nombreProducto == null) {
			precioLonjaImpl.setNombreProducto("");
		}
		else {
			precioLonjaImpl.setNombreProducto(nombreProducto);
		}

		if (precioAnterior == null) {
			precioLonjaImpl.setPrecioAnterior("");
		}
		else {
			precioLonjaImpl.setPrecioAnterior(precioAnterior);
		}

		if (precioUltimo == null) {
			precioLonjaImpl.setPrecioUltimo("");
		}
		else {
			precioLonjaImpl.setPrecioUltimo(precioUltimo);
		}

		if (precioMaximo == null) {
			precioLonjaImpl.setPrecioMaximo("");
		}
		else {
			precioLonjaImpl.setPrecioMaximo(precioMaximo);
		}

		if (precioMedio == null) {
			precioLonjaImpl.setPrecioMedio("");
		}
		else {
			precioLonjaImpl.setPrecioMedio(precioMedio);
		}

		if (precioMinimo == null) {
			precioLonjaImpl.setPrecioMinimo("");
		}
		else {
			precioLonjaImpl.setPrecioMinimo(precioMinimo);
		}

		if (precioOrigen == null) {
			precioLonjaImpl.setPrecioOrigen("");
		}
		else {
			precioLonjaImpl.setPrecioOrigen(precioOrigen);
		}

		if (anteriorEuros == null) {
			precioLonjaImpl.setAnteriorEuros("");
		}
		else {
			precioLonjaImpl.setAnteriorEuros(anteriorEuros);
		}

		if (ultimoEuros == null) {
			precioLonjaImpl.setUltimoEuros("");
		}
		else {
			precioLonjaImpl.setUltimoEuros(ultimoEuros);
		}

		if (unidadMedida == null) {
			precioLonjaImpl.setUnidadMedida("");
		}
		else {
			precioLonjaImpl.setUnidadMedida(unidadMedida);
		}

		if (unidadLarga == null) {
			precioLonjaImpl.setUnidadLarga("");
		}
		else {
			precioLonjaImpl.setUnidadLarga(unidadLarga);
		}

		if (createDate == Long.MIN_VALUE) {
			precioLonjaImpl.setCreateDate(null);
		}
		else {
			precioLonjaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			precioLonjaImpl.setModifiedDate(null);
		}
		else {
			precioLonjaImpl.setModifiedDate(new Date(modifiedDate));
		}

		precioLonjaImpl.resetOriginalValues();

		return precioLonjaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		entityId = objectInput.readLong();

		productoId = objectInput.readLong();

		lonjaId = objectInput.readLong();

		grupoId = objectInput.readLong();

		subGrupoId = objectInput.readLong();

		areaId = objectInput.readLong();
		fecha = objectInput.readLong();
		nombreProducto = objectInput.readUTF();
		precioAnterior = objectInput.readUTF();
		precioUltimo = objectInput.readUTF();
		precioMaximo = objectInput.readUTF();
		precioMedio = objectInput.readUTF();
		precioMinimo = objectInput.readUTF();
		precioOrigen = objectInput.readUTF();
		anteriorEuros = objectInput.readUTF();
		ultimoEuros = objectInput.readUTF();
		unidadMedida = objectInput.readUTF();
		unidadLarga = objectInput.readUTF();
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

		objectOutput.writeLong(productoId);

		objectOutput.writeLong(lonjaId);

		objectOutput.writeLong(grupoId);

		objectOutput.writeLong(subGrupoId);

		objectOutput.writeLong(areaId);
		objectOutput.writeLong(fecha);

		if (nombreProducto == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nombreProducto);
		}

		if (precioAnterior == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(precioAnterior);
		}

		if (precioUltimo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(precioUltimo);
		}

		if (precioMaximo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(precioMaximo);
		}

		if (precioMedio == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(precioMedio);
		}

		if (precioMinimo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(precioMinimo);
		}

		if (precioOrigen == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(precioOrigen);
		}

		if (anteriorEuros == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(anteriorEuros);
		}

		if (ultimoEuros == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ultimoEuros);
		}

		if (unidadMedida == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(unidadMedida);
		}

		if (unidadLarga == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(unidadLarga);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long entityId;
	public long productoId;
	public long lonjaId;
	public long grupoId;
	public long subGrupoId;
	public long areaId;
	public long fecha;
	public String nombreProducto;
	public String precioAnterior;
	public String precioUltimo;
	public String precioMaximo;
	public String precioMedio;
	public String precioMinimo;
	public String precioOrigen;
	public String anteriorEuros;
	public String ultimoEuros;
	public String unidadMedida;
	public String unidadLarga;
	public long createDate;
	public long modifiedDate;

}