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
 * This class is a wrapper for {@link FechaLonja}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FechaLonja
 * @generated
 */
public class FechaLonjaWrapper
	extends BaseModelWrapper<FechaLonja>
	implements FechaLonja, ModelWrapper<FechaLonja> {

	public FechaLonjaWrapper(FechaLonja fechaLonja) {
		super(fechaLonja);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("entityId", getEntityId());
		attributes.put("lonjaId", getLonjaId());
		attributes.put("fecha", getFecha());
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

		Date fecha = (Date)attributes.get("fecha");

		if (fecha != null) {
			setFecha(fecha);
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
	public FechaLonja cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the create date of this fecha lonja.
	 *
	 * @return the create date of this fecha lonja
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the entity ID of this fecha lonja.
	 *
	 * @return the entity ID of this fecha lonja
	 */
	@Override
	public long getEntityId() {
		return model.getEntityId();
	}

	/**
	 * Returns the fecha of this fecha lonja.
	 *
	 * @return the fecha of this fecha lonja
	 */
	@Override
	public Date getFecha() {
		return model.getFecha();
	}

	/**
	 * Returns the lonja ID of this fecha lonja.
	 *
	 * @return the lonja ID of this fecha lonja
	 */
	@Override
	public long getLonjaId() {
		return model.getLonjaId();
	}

	/**
	 * Returns the modified date of this fecha lonja.
	 *
	 * @return the modified date of this fecha lonja
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this fecha lonja.
	 *
	 * @return the primary key of this fecha lonja
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this fecha lonja.
	 *
	 * @return the uuid of this fecha lonja
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
	 * Sets the create date of this fecha lonja.
	 *
	 * @param createDate the create date of this fecha lonja
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the entity ID of this fecha lonja.
	 *
	 * @param entityId the entity ID of this fecha lonja
	 */
	@Override
	public void setEntityId(long entityId) {
		model.setEntityId(entityId);
	}

	/**
	 * Sets the fecha of this fecha lonja.
	 *
	 * @param fecha the fecha of this fecha lonja
	 */
	@Override
	public void setFecha(Date fecha) {
		model.setFecha(fecha);
	}

	/**
	 * Sets the lonja ID of this fecha lonja.
	 *
	 * @param lonjaId the lonja ID of this fecha lonja
	 */
	@Override
	public void setLonjaId(long lonjaId) {
		model.setLonjaId(lonjaId);
	}

	/**
	 * Sets the modified date of this fecha lonja.
	 *
	 * @param modifiedDate the modified date of this fecha lonja
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this fecha lonja.
	 *
	 * @param primaryKey the primary key of this fecha lonja
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this fecha lonja.
	 *
	 * @param uuid the uuid of this fecha lonja
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
	protected FechaLonjaWrapper wrap(FechaLonja fechaLonja) {
		return new FechaLonjaWrapper(fechaLonja);
	}

}