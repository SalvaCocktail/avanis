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
 * This class is a wrapper for {@link SubGrupo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubGrupo
 * @generated
 */
public class SubGrupoWrapper
	extends BaseModelWrapper<SubGrupo>
	implements ModelWrapper<SubGrupo>, SubGrupo {

	public SubGrupoWrapper(SubGrupo subGrupo) {
		super(subGrupo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("entityId", getEntityId());
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
	public SubGrupo cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the create date of this sub grupo.
	 *
	 * @return the create date of this sub grupo
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the entity ID of this sub grupo.
	 *
	 * @return the entity ID of this sub grupo
	 */
	@Override
	public long getEntityId() {
		return model.getEntityId();
	}

	/**
	 * Returns the grupo ID of this sub grupo.
	 *
	 * @return the grupo ID of this sub grupo
	 */
	@Override
	public long getGrupoId() {
		return model.getGrupoId();
	}

	/**
	 * Returns the modified date of this sub grupo.
	 *
	 * @return the modified date of this sub grupo
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nombre of this sub grupo.
	 *
	 * @return the nombre of this sub grupo
	 */
	@Override
	public String getNombre() {
		return model.getNombre();
	}

	/**
	 * Returns the primary key of this sub grupo.
	 *
	 * @return the primary key of this sub grupo
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sub grupo ID of this sub grupo.
	 *
	 * @return the sub grupo ID of this sub grupo
	 */
	@Override
	public long getSubGrupoId() {
		return model.getSubGrupoId();
	}

	/**
	 * Returns the uuid of this sub grupo.
	 *
	 * @return the uuid of this sub grupo
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
	 * Sets the create date of this sub grupo.
	 *
	 * @param createDate the create date of this sub grupo
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the entity ID of this sub grupo.
	 *
	 * @param entityId the entity ID of this sub grupo
	 */
	@Override
	public void setEntityId(long entityId) {
		model.setEntityId(entityId);
	}

	/**
	 * Sets the grupo ID of this sub grupo.
	 *
	 * @param grupoId the grupo ID of this sub grupo
	 */
	@Override
	public void setGrupoId(long grupoId) {
		model.setGrupoId(grupoId);
	}

	/**
	 * Sets the modified date of this sub grupo.
	 *
	 * @param modifiedDate the modified date of this sub grupo
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nombre of this sub grupo.
	 *
	 * @param nombre the nombre of this sub grupo
	 */
	@Override
	public void setNombre(String nombre) {
		model.setNombre(nombre);
	}

	/**
	 * Sets the primary key of this sub grupo.
	 *
	 * @param primaryKey the primary key of this sub grupo
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sub grupo ID of this sub grupo.
	 *
	 * @param subGrupoId the sub grupo ID of this sub grupo
	 */
	@Override
	public void setSubGrupoId(long subGrupoId) {
		model.setSubGrupoId(subGrupoId);
	}

	/**
	 * Sets the uuid of this sub grupo.
	 *
	 * @param uuid the uuid of this sub grupo
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
	protected SubGrupoWrapper wrap(SubGrupo subGrupo) {
		return new SubGrupoWrapper(subGrupo);
	}

}