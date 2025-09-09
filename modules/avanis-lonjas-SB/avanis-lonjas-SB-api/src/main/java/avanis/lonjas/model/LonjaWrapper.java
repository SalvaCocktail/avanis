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
 * This class is a wrapper for {@link Lonja}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Lonja
 * @generated
 */
public class LonjaWrapper
	extends BaseModelWrapper<Lonja> implements Lonja, ModelWrapper<Lonja> {

	public LonjaWrapper(Lonja lonja) {
		super(lonja);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("entityId", getEntityId());
		attributes.put("lonjaId", getLonjaId());
		attributes.put("nombre", getNombre());
		attributes.put("pais", getPais());
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

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}

		String pais = (String)attributes.get("pais");

		if (pais != null) {
			setPais(pais);
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
	public Lonja cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the create date of this lonja.
	 *
	 * @return the create date of this lonja
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the entity ID of this lonja.
	 *
	 * @return the entity ID of this lonja
	 */
	@Override
	public long getEntityId() {
		return model.getEntityId();
	}

	/**
	 * Returns the lonja ID of this lonja.
	 *
	 * @return the lonja ID of this lonja
	 */
	@Override
	public long getLonjaId() {
		return model.getLonjaId();
	}

	/**
	 * Returns the modified date of this lonja.
	 *
	 * @return the modified date of this lonja
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nombre of this lonja.
	 *
	 * @return the nombre of this lonja
	 */
	@Override
	public String getNombre() {
		return model.getNombre();
	}

	/**
	 * Returns the pais of this lonja.
	 *
	 * @return the pais of this lonja
	 */
	@Override
	public String getPais() {
		return model.getPais();
	}

	/**
	 * Returns the primary key of this lonja.
	 *
	 * @return the primary key of this lonja
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this lonja.
	 *
	 * @return the uuid of this lonja
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
	 * Sets the create date of this lonja.
	 *
	 * @param createDate the create date of this lonja
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the entity ID of this lonja.
	 *
	 * @param entityId the entity ID of this lonja
	 */
	@Override
	public void setEntityId(long entityId) {
		model.setEntityId(entityId);
	}

	/**
	 * Sets the lonja ID of this lonja.
	 *
	 * @param lonjaId the lonja ID of this lonja
	 */
	@Override
	public void setLonjaId(long lonjaId) {
		model.setLonjaId(lonjaId);
	}

	/**
	 * Sets the modified date of this lonja.
	 *
	 * @param modifiedDate the modified date of this lonja
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nombre of this lonja.
	 *
	 * @param nombre the nombre of this lonja
	 */
	@Override
	public void setNombre(String nombre) {
		model.setNombre(nombre);
	}

	/**
	 * Sets the pais of this lonja.
	 *
	 * @param pais the pais of this lonja
	 */
	@Override
	public void setPais(String pais) {
		model.setPais(pais);
	}

	/**
	 * Sets the primary key of this lonja.
	 *
	 * @param primaryKey the primary key of this lonja
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this lonja.
	 *
	 * @param uuid the uuid of this lonja
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
	protected LonjaWrapper wrap(Lonja lonja) {
		return new LonjaWrapper(lonja);
	}

}