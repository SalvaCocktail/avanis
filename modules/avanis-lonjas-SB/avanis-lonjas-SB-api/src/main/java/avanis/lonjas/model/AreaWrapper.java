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
 * This class is a wrapper for {@link Area}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Area
 * @generated
 */
public class AreaWrapper
	extends BaseModelWrapper<Area> implements Area, ModelWrapper<Area> {

	public AreaWrapper(Area area) {
		super(area);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("entityId", getEntityId());
		attributes.put("areaId", getAreaId());
		attributes.put("subGrupoId", getSubGrupoId());
		attributes.put("grupoId", getGrupoId());
		attributes.put("nombre", getNombre());
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

		Long areaId = (Long)attributes.get("areaId");

		if (areaId != null) {
			setAreaId(areaId);
		}

		Long subGrupoId = (Long)attributes.get("subGrupoId");

		if (subGrupoId != null) {
			setSubGrupoId(subGrupoId);
		}

		Long grupoId = (Long)attributes.get("grupoId");

		if (grupoId != null) {
			setGrupoId(grupoId);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
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
	public Area cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the area ID of this area.
	 *
	 * @return the area ID of this area
	 */
	@Override
	public long getAreaId() {
		return model.getAreaId();
	}

	/**
	 * Returns the create date of this area.
	 *
	 * @return the create date of this area
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the entity ID of this area.
	 *
	 * @return the entity ID of this area
	 */
	@Override
	public long getEntityId() {
		return model.getEntityId();
	}

	/**
	 * Returns the grupo ID of this area.
	 *
	 * @return the grupo ID of this area
	 */
	@Override
	public long getGrupoId() {
		return model.getGrupoId();
	}

	/**
	 * Returns the modified date of this area.
	 *
	 * @return the modified date of this area
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nombre of this area.
	 *
	 * @return the nombre of this area
	 */
	@Override
	public String getNombre() {
		return model.getNombre();
	}

	/**
	 * Returns the primary key of this area.
	 *
	 * @return the primary key of this area
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sub grupo ID of this area.
	 *
	 * @return the sub grupo ID of this area
	 */
	@Override
	public long getSubGrupoId() {
		return model.getSubGrupoId();
	}

	/**
	 * Returns the uuid of this area.
	 *
	 * @return the uuid of this area
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
	 * Sets the area ID of this area.
	 *
	 * @param areaId the area ID of this area
	 */
	@Override
	public void setAreaId(long areaId) {
		model.setAreaId(areaId);
	}

	/**
	 * Sets the create date of this area.
	 *
	 * @param createDate the create date of this area
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the entity ID of this area.
	 *
	 * @param entityId the entity ID of this area
	 */
	@Override
	public void setEntityId(long entityId) {
		model.setEntityId(entityId);
	}

	/**
	 * Sets the grupo ID of this area.
	 *
	 * @param grupoId the grupo ID of this area
	 */
	@Override
	public void setGrupoId(long grupoId) {
		model.setGrupoId(grupoId);
	}

	/**
	 * Sets the modified date of this area.
	 *
	 * @param modifiedDate the modified date of this area
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nombre of this area.
	 *
	 * @param nombre the nombre of this area
	 */
	@Override
	public void setNombre(String nombre) {
		model.setNombre(nombre);
	}

	/**
	 * Sets the primary key of this area.
	 *
	 * @param primaryKey the primary key of this area
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sub grupo ID of this area.
	 *
	 * @param subGrupoId the sub grupo ID of this area
	 */
	@Override
	public void setSubGrupoId(long subGrupoId) {
		model.setSubGrupoId(subGrupoId);
	}

	/**
	 * Sets the uuid of this area.
	 *
	 * @param uuid the uuid of this area
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
	protected AreaWrapper wrap(Area area) {
		return new AreaWrapper(area);
	}

}