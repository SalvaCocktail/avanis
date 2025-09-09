/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PrecioLonja}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PrecioLonja
 * @generated
 */
public class PrecioLonjaWrapper
	extends BaseModelWrapper<PrecioLonja>
	implements ModelWrapper<PrecioLonja>, PrecioLonja {

	public PrecioLonjaWrapper(PrecioLonja precioLonja) {
		super(precioLonja);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("entityId", getEntityId());
		attributes.put("productoId", getProductoId());
		attributes.put("lonjaId", getLonjaId());
		attributes.put("grupoId", getGrupoId());
		attributes.put("subGrupoId", getSubGrupoId());
		attributes.put("areaId", getAreaId());
		attributes.put("fecha", getFecha());
		attributes.put("nombreProducto", getNombreProducto());
		attributes.put("precioAnterior", getPrecioAnterior());
		attributes.put("precioUltimo", getPrecioUltimo());
		attributes.put("precioMaximo", getPrecioMaximo());
		attributes.put("precioMedio", getPrecioMedio());
		attributes.put("precioMinimo", getPrecioMinimo());
		attributes.put("precioOrigen", getPrecioOrigen());
		attributes.put("anteriorEuros", getAnteriorEuros());
		attributes.put("ultimoEuros", getUltimoEuros());
		attributes.put("unidadMedida", getUnidadMedida());
		attributes.put("unidadLarga", getUnidadLarga());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long entityId = (Long)attributes.get("entityId");

		if (entityId != null) {
			setEntityId(entityId);
		}

		Long productoId = (Long)attributes.get("productoId");

		if (productoId != null) {
			setProductoId(productoId);
		}

		Long lonjaId = (Long)attributes.get("lonjaId");

		if (lonjaId != null) {
			setLonjaId(lonjaId);
		}

		Long grupoId = (Long)attributes.get("grupoId");

		if (grupoId != null) {
			setGrupoId(grupoId);
		}

		Long subGrupoId = (Long)attributes.get("subGrupoId");

		if (subGrupoId != null) {
			setSubGrupoId(subGrupoId);
		}

		Long areaId = (Long)attributes.get("areaId");

		if (areaId != null) {
			setAreaId(areaId);
		}

		Date fecha = (Date)attributes.get("fecha");

		if (fecha != null) {
			setFecha(fecha);
		}

		String nombreProducto = (String)attributes.get("nombreProducto");

		if (nombreProducto != null) {
			setNombreProducto(nombreProducto);
		}

		String precioAnterior = (String)attributes.get("precioAnterior");

		if (precioAnterior != null) {
			setPrecioAnterior(precioAnterior);
		}

		String precioUltimo = (String)attributes.get("precioUltimo");

		if (precioUltimo != null) {
			setPrecioUltimo(precioUltimo);
		}

		String precioMaximo = (String)attributes.get("precioMaximo");

		if (precioMaximo != null) {
			setPrecioMaximo(precioMaximo);
		}

		String precioMedio = (String)attributes.get("precioMedio");

		if (precioMedio != null) {
			setPrecioMedio(precioMedio);
		}

		String precioMinimo = (String)attributes.get("precioMinimo");

		if (precioMinimo != null) {
			setPrecioMinimo(precioMinimo);
		}

		String precioOrigen = (String)attributes.get("precioOrigen");

		if (precioOrigen != null) {
			setPrecioOrigen(precioOrigen);
		}

		String anteriorEuros = (String)attributes.get("anteriorEuros");

		if (anteriorEuros != null) {
			setAnteriorEuros(anteriorEuros);
		}

		String ultimoEuros = (String)attributes.get("ultimoEuros");

		if (ultimoEuros != null) {
			setUltimoEuros(ultimoEuros);
		}

		String unidadMedida = (String)attributes.get("unidadMedida");

		if (unidadMedida != null) {
			setUnidadMedida(unidadMedida);
		}

		String unidadLarga = (String)attributes.get("unidadLarga");

		if (unidadLarga != null) {
			setUnidadLarga(unidadLarga);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public PrecioLonja cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the anterior euros of this precio lonja.
	 *
	 * @return the anterior euros of this precio lonja
	 */
	@Override
	public String getAnteriorEuros() {
		return model.getAnteriorEuros();
	}

	/**
	 * Returns the area ID of this precio lonja.
	 *
	 * @return the area ID of this precio lonja
	 */
	@Override
	public long getAreaId() {
		return model.getAreaId();
	}

	/**
	 * Returns the create date of this precio lonja.
	 *
	 * @return the create date of this precio lonja
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the entity ID of this precio lonja.
	 *
	 * @return the entity ID of this precio lonja
	 */
	@Override
	public long getEntityId() {
		return model.getEntityId();
	}

	/**
	 * Returns the fecha of this precio lonja.
	 *
	 * @return the fecha of this precio lonja
	 */
	@Override
	public Date getFecha() {
		return model.getFecha();
	}

	/**
	 * Returns the grupo ID of this precio lonja.
	 *
	 * @return the grupo ID of this precio lonja
	 */
	@Override
	public long getGrupoId() {
		return model.getGrupoId();
	}

	/**
	 * Returns the lonja ID of this precio lonja.
	 *
	 * @return the lonja ID of this precio lonja
	 */
	@Override
	public long getLonjaId() {
		return model.getLonjaId();
	}

	/**
	 * Returns the modified date of this precio lonja.
	 *
	 * @return the modified date of this precio lonja
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nombre producto of this precio lonja.
	 *
	 * @return the nombre producto of this precio lonja
	 */
	@Override
	public String getNombreProducto() {
		return model.getNombreProducto();
	}

	/**
	 * Returns the precio anterior of this precio lonja.
	 *
	 * @return the precio anterior of this precio lonja
	 */
	@Override
	public String getPrecioAnterior() {
		return model.getPrecioAnterior();
	}

	/**
	 * Returns the precio maximo of this precio lonja.
	 *
	 * @return the precio maximo of this precio lonja
	 */
	@Override
	public String getPrecioMaximo() {
		return model.getPrecioMaximo();
	}

	/**
	 * Returns the precio medio of this precio lonja.
	 *
	 * @return the precio medio of this precio lonja
	 */
	@Override
	public String getPrecioMedio() {
		return model.getPrecioMedio();
	}

	/**
	 * Returns the precio minimo of this precio lonja.
	 *
	 * @return the precio minimo of this precio lonja
	 */
	@Override
	public String getPrecioMinimo() {
		return model.getPrecioMinimo();
	}

	/**
	 * Returns the precio origen of this precio lonja.
	 *
	 * @return the precio origen of this precio lonja
	 */
	@Override
	public String getPrecioOrigen() {
		return model.getPrecioOrigen();
	}

	/**
	 * Returns the precio ultimo of this precio lonja.
	 *
	 * @return the precio ultimo of this precio lonja
	 */
	@Override
	public String getPrecioUltimo() {
		return model.getPrecioUltimo();
	}

	/**
	 * Returns the primary key of this precio lonja.
	 *
	 * @return the primary key of this precio lonja
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the producto ID of this precio lonja.
	 *
	 * @return the producto ID of this precio lonja
	 */
	@Override
	public long getProductoId() {
		return model.getProductoId();
	}

	/**
	 * Returns the sub grupo ID of this precio lonja.
	 *
	 * @return the sub grupo ID of this precio lonja
	 */
	@Override
	public long getSubGrupoId() {
		return model.getSubGrupoId();
	}

	/**
	 * Returns the ultimo euros of this precio lonja.
	 *
	 * @return the ultimo euros of this precio lonja
	 */
	@Override
	public String getUltimoEuros() {
		return model.getUltimoEuros();
	}

	/**
	 * Returns the unidad larga of this precio lonja.
	 *
	 * @return the unidad larga of this precio lonja
	 */
	@Override
	public String getUnidadLarga() {
		return model.getUnidadLarga();
	}

	/**
	 * Returns the unidad medida of this precio lonja.
	 *
	 * @return the unidad medida of this precio lonja
	 */
	@Override
	public String getUnidadMedida() {
		return model.getUnidadMedida();
	}

	/**
	 * Returns the uuid of this precio lonja.
	 *
	 * @return the uuid of this precio lonja
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the anterior euros of this precio lonja.
	 *
	 * @param anteriorEuros the anterior euros of this precio lonja
	 */
	@Override
	public void setAnteriorEuros(String anteriorEuros) {
		model.setAnteriorEuros(anteriorEuros);
	}

	/**
	 * Sets the area ID of this precio lonja.
	 *
	 * @param areaId the area ID of this precio lonja
	 */
	@Override
	public void setAreaId(long areaId) {
		model.setAreaId(areaId);
	}

	/**
	 * Sets the create date of this precio lonja.
	 *
	 * @param createDate the create date of this precio lonja
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the entity ID of this precio lonja.
	 *
	 * @param entityId the entity ID of this precio lonja
	 */
	@Override
	public void setEntityId(long entityId) {
		model.setEntityId(entityId);
	}

	/**
	 * Sets the fecha of this precio lonja.
	 *
	 * @param fecha the fecha of this precio lonja
	 */
	@Override
	public void setFecha(Date fecha) {
		model.setFecha(fecha);
	}

	/**
	 * Sets the grupo ID of this precio lonja.
	 *
	 * @param grupoId the grupo ID of this precio lonja
	 */
	@Override
	public void setGrupoId(long grupoId) {
		model.setGrupoId(grupoId);
	}

	/**
	 * Sets the lonja ID of this precio lonja.
	 *
	 * @param lonjaId the lonja ID of this precio lonja
	 */
	@Override
	public void setLonjaId(long lonjaId) {
		model.setLonjaId(lonjaId);
	}

	/**
	 * Sets the modified date of this precio lonja.
	 *
	 * @param modifiedDate the modified date of this precio lonja
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nombre producto of this precio lonja.
	 *
	 * @param nombreProducto the nombre producto of this precio lonja
	 */
	@Override
	public void setNombreProducto(String nombreProducto) {
		model.setNombreProducto(nombreProducto);
	}

	/**
	 * Sets the precio anterior of this precio lonja.
	 *
	 * @param precioAnterior the precio anterior of this precio lonja
	 */
	@Override
	public void setPrecioAnterior(String precioAnterior) {
		model.setPrecioAnterior(precioAnterior);
	}

	/**
	 * Sets the precio maximo of this precio lonja.
	 *
	 * @param precioMaximo the precio maximo of this precio lonja
	 */
	@Override
	public void setPrecioMaximo(String precioMaximo) {
		model.setPrecioMaximo(precioMaximo);
	}

	/**
	 * Sets the precio medio of this precio lonja.
	 *
	 * @param precioMedio the precio medio of this precio lonja
	 */
	@Override
	public void setPrecioMedio(String precioMedio) {
		model.setPrecioMedio(precioMedio);
	}

	/**
	 * Sets the precio minimo of this precio lonja.
	 *
	 * @param precioMinimo the precio minimo of this precio lonja
	 */
	@Override
	public void setPrecioMinimo(String precioMinimo) {
		model.setPrecioMinimo(precioMinimo);
	}

	/**
	 * Sets the precio origen of this precio lonja.
	 *
	 * @param precioOrigen the precio origen of this precio lonja
	 */
	@Override
	public void setPrecioOrigen(String precioOrigen) {
		model.setPrecioOrigen(precioOrigen);
	}

	/**
	 * Sets the precio ultimo of this precio lonja.
	 *
	 * @param precioUltimo the precio ultimo of this precio lonja
	 */
	@Override
	public void setPrecioUltimo(String precioUltimo) {
		model.setPrecioUltimo(precioUltimo);
	}

	/**
	 * Sets the primary key of this precio lonja.
	 *
	 * @param primaryKey the primary key of this precio lonja
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the producto ID of this precio lonja.
	 *
	 * @param productoId the producto ID of this precio lonja
	 */
	@Override
	public void setProductoId(long productoId) {
		model.setProductoId(productoId);
	}

	/**
	 * Sets the sub grupo ID of this precio lonja.
	 *
	 * @param subGrupoId the sub grupo ID of this precio lonja
	 */
	@Override
	public void setSubGrupoId(long subGrupoId) {
		model.setSubGrupoId(subGrupoId);
	}

	/**
	 * Sets the ultimo euros of this precio lonja.
	 *
	 * @param ultimoEuros the ultimo euros of this precio lonja
	 */
	@Override
	public void setUltimoEuros(String ultimoEuros) {
		model.setUltimoEuros(ultimoEuros);
	}

	/**
	 * Sets the unidad larga of this precio lonja.
	 *
	 * @param unidadLarga the unidad larga of this precio lonja
	 */
	@Override
	public void setUnidadLarga(String unidadLarga) {
		model.setUnidadLarga(unidadLarga);
	}

	/**
	 * Sets the unidad medida of this precio lonja.
	 *
	 * @param unidadMedida the unidad medida of this precio lonja
	 */
	@Override
	public void setUnidadMedida(String unidadMedida) {
		model.setUnidadMedida(unidadMedida);
	}

	/**
	 * Sets the uuid of this precio lonja.
	 *
	 * @param uuid the uuid of this precio lonja
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected PrecioLonjaWrapper wrap(PrecioLonja precioLonja) {
		return new PrecioLonjaWrapper(precioLonja);
	}

}