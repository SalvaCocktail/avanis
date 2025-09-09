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
 * This class is a wrapper for {@link ProductoUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductoUser
 * @generated
 */
public class ProductoUserWrapper
	extends BaseModelWrapper<ProductoUser>
	implements ModelWrapper<ProductoUser>, ProductoUser {

	public ProductoUserWrapper(ProductoUser productoUser) {
		super(productoUser);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("entityId", getEntityId());
		attributes.put("lonjaId", getLonjaId());
		attributes.put("productoId", getProductoId());
		attributes.put("precioLonjaId", getPrecioLonjaId());
		attributes.put("userId", getUserId());
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

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
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
	public ProductoUser cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the create date of this producto user.
	 *
	 * @return the create date of this producto user
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the entity ID of this producto user.
	 *
	 * @return the entity ID of this producto user
	 */
	@Override
	public long getEntityId() {
		return model.getEntityId();
	}

	/**
	 * Returns the lonja ID of this producto user.
	 *
	 * @return the lonja ID of this producto user
	 */
	@Override
	public long getLonjaId() {
		return model.getLonjaId();
	}

	/**
	 * Returns the modified date of this producto user.
	 *
	 * @return the modified date of this producto user
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the orden of this producto user.
	 *
	 * @return the orden of this producto user
	 */
	@Override
	public long getOrden() {
		return model.getOrden();
	}

	/**
	 * Returns the precio lonja ID of this producto user.
	 *
	 * @return the precio lonja ID of this producto user
	 */
	@Override
	public long getPrecioLonjaId() {
		return model.getPrecioLonjaId();
	}

	/**
	 * Returns the primary key of this producto user.
	 *
	 * @return the primary key of this producto user
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the producto ID of this producto user.
	 *
	 * @return the producto ID of this producto user
	 */
	@Override
	public long getProductoId() {
		return model.getProductoId();
	}

	/**
	 * Returns the user ID of this producto user.
	 *
	 * @return the user ID of this producto user
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this producto user.
	 *
	 * @return the user uuid of this producto user
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this producto user.
	 *
	 * @return the uuid of this producto user
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
	 * Sets the create date of this producto user.
	 *
	 * @param createDate the create date of this producto user
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the entity ID of this producto user.
	 *
	 * @param entityId the entity ID of this producto user
	 */
	@Override
	public void setEntityId(long entityId) {
		model.setEntityId(entityId);
	}

	/**
	 * Sets the lonja ID of this producto user.
	 *
	 * @param lonjaId the lonja ID of this producto user
	 */
	@Override
	public void setLonjaId(long lonjaId) {
		model.setLonjaId(lonjaId);
	}

	/**
	 * Sets the modified date of this producto user.
	 *
	 * @param modifiedDate the modified date of this producto user
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the orden of this producto user.
	 *
	 * @param orden the orden of this producto user
	 */
	@Override
	public void setOrden(long orden) {
		model.setOrden(orden);
	}

	/**
	 * Sets the precio lonja ID of this producto user.
	 *
	 * @param precioLonjaId the precio lonja ID of this producto user
	 */
	@Override
	public void setPrecioLonjaId(long precioLonjaId) {
		model.setPrecioLonjaId(precioLonjaId);
	}

	/**
	 * Sets the primary key of this producto user.
	 *
	 * @param primaryKey the primary key of this producto user
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the producto ID of this producto user.
	 *
	 * @param productoId the producto ID of this producto user
	 */
	@Override
	public void setProductoId(long productoId) {
		model.setProductoId(productoId);
	}

	/**
	 * Sets the user ID of this producto user.
	 *
	 * @param userId the user ID of this producto user
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this producto user.
	 *
	 * @param userUuid the user uuid of this producto user
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this producto user.
	 *
	 * @param uuid the uuid of this producto user
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
	protected ProductoUserWrapper wrap(ProductoUser productoUser) {
		return new ProductoUserWrapper(productoUser);
	}

}