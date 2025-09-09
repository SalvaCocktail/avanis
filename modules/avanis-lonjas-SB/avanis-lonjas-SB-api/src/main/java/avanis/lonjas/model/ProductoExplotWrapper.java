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
 * This class is a wrapper for {@link ProductoExplot}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductoExplot
 * @generated
 */
public class ProductoExplotWrapper
	extends BaseModelWrapper<ProductoExplot>
	implements ModelWrapper<ProductoExplot>, ProductoExplot {

	public ProductoExplotWrapper(ProductoExplot productoExplot) {
		super(productoExplot);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("entityId", getEntityId());
		attributes.put("lonjaId", getLonjaId());
		attributes.put("productoId", getProductoId());
		attributes.put("precioLonjaId", getPrecioLonjaId());
		attributes.put("explotacionId", getExplotacionId());
		attributes.put("orden", getOrden());
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

		Long lonjaId = (Long)attributes.get("lonjaId");

		if (lonjaId != null) {
			setLonjaId(lonjaId);
		}

		Long productoId = (Long)attributes.get("productoId");

		if (productoId != null) {
			setProductoId(productoId);
		}

		Long precioLonjaId = (Long)attributes.get("precioLonjaId");

		if (precioLonjaId != null) {
			setPrecioLonjaId(precioLonjaId);
		}

		Long explotacionId = (Long)attributes.get("explotacionId");

		if (explotacionId != null) {
			setExplotacionId(explotacionId);
		}

		Long orden = (Long)attributes.get("orden");

		if (orden != null) {
			setOrden(orden);
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
	public ProductoExplot cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the create date of this producto explot.
	 *
	 * @return the create date of this producto explot
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the entity ID of this producto explot.
	 *
	 * @return the entity ID of this producto explot
	 */
	@Override
	public long getEntityId() {
		return model.getEntityId();
	}

	/**
	 * Returns the explotacion ID of this producto explot.
	 *
	 * @return the explotacion ID of this producto explot
	 */
	@Override
	public long getExplotacionId() {
		return model.getExplotacionId();
	}

	/**
	 * Returns the lonja ID of this producto explot.
	 *
	 * @return the lonja ID of this producto explot
	 */
	@Override
	public long getLonjaId() {
		return model.getLonjaId();
	}

	/**
	 * Returns the modified date of this producto explot.
	 *
	 * @return the modified date of this producto explot
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the orden of this producto explot.
	 *
	 * @return the orden of this producto explot
	 */
	@Override
	public long getOrden() {
		return model.getOrden();
	}

	/**
	 * Returns the precio lonja ID of this producto explot.
	 *
	 * @return the precio lonja ID of this producto explot
	 */
	@Override
	public long getPrecioLonjaId() {
		return model.getPrecioLonjaId();
	}

	/**
	 * Returns the primary key of this producto explot.
	 *
	 * @return the primary key of this producto explot
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the producto ID of this producto explot.
	 *
	 * @return the producto ID of this producto explot
	 */
	@Override
	public long getProductoId() {
		return model.getProductoId();
	}

	/**
	 * Returns the uuid of this producto explot.
	 *
	 * @return the uuid of this producto explot
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
	 * Sets the create date of this producto explot.
	 *
	 * @param createDate the create date of this producto explot
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the entity ID of this producto explot.
	 *
	 * @param entityId the entity ID of this producto explot
	 */
	@Override
	public void setEntityId(long entityId) {
		model.setEntityId(entityId);
	}

	/**
	 * Sets the explotacion ID of this producto explot.
	 *
	 * @param explotacionId the explotacion ID of this producto explot
	 */
	@Override
	public void setExplotacionId(long explotacionId) {
		model.setExplotacionId(explotacionId);
	}

	/**
	 * Sets the lonja ID of this producto explot.
	 *
	 * @param lonjaId the lonja ID of this producto explot
	 */
	@Override
	public void setLonjaId(long lonjaId) {
		model.setLonjaId(lonjaId);
	}

	/**
	 * Sets the modified date of this producto explot.
	 *
	 * @param modifiedDate the modified date of this producto explot
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the orden of this producto explot.
	 *
	 * @param orden the orden of this producto explot
	 */
	@Override
	public void setOrden(long orden) {
		model.setOrden(orden);
	}

	/**
	 * Sets the precio lonja ID of this producto explot.
	 *
	 * @param precioLonjaId the precio lonja ID of this producto explot
	 */
	@Override
	public void setPrecioLonjaId(long precioLonjaId) {
		model.setPrecioLonjaId(precioLonjaId);
	}

	/**
	 * Sets the primary key of this producto explot.
	 *
	 * @param primaryKey the primary key of this producto explot
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the producto ID of this producto explot.
	 *
	 * @param productoId the producto ID of this producto explot
	 */
	@Override
	public void setProductoId(long productoId) {
		model.setProductoId(productoId);
	}

	/**
	 * Sets the uuid of this producto explot.
	 *
	 * @param uuid the uuid of this producto explot
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
	protected ProductoExplotWrapper wrap(ProductoExplot productoExplot) {
		return new ProductoExplotWrapper(productoExplot);
	}

}