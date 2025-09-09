/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.tu.explotacion.sb.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Alertas}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Alertas
 * @generated
 */
public class AlertasWrapper
	extends BaseModelWrapper<Alertas>
	implements Alertas, ModelWrapper<Alertas> {

	public AlertasWrapper(Alertas alertas) {
		super(alertas);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("alertaId", getAlertaId());
		attributes.put("explotacionId", getExplotacionId());
		attributes.put("userId", getUserId());
		attributes.put("description", getDescription());
		attributes.put("endDate", getEndDate());
		attributes.put("startDate", getStartDate());
		attributes.put("risk", getRisk());
		attributes.put("phenomenom", getPhenomenom());
		attributes.put("scope", getScope());
		attributes.put("probability", getProbability());
		attributes.put("type", getType());
		attributes.put("readed", isReaded());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("externalCodeReference", getExternalCodeReference());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long alertaId = (Long)attributes.get("alertaId");

		if (alertaId != null) {
			setAlertaId(alertaId);
		}

		Long explotacionId = (Long)attributes.get("explotacionId");

		if (explotacionId != null) {
			setExplotacionId(explotacionId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String endDate = (String)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String startDate = (String)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		String risk = (String)attributes.get("risk");

		if (risk != null) {
			setRisk(risk);
		}

		String phenomenom = (String)attributes.get("phenomenom");

		if (phenomenom != null) {
			setPhenomenom(phenomenom);
		}

		String scope = (String)attributes.get("scope");

		if (scope != null) {
			setScope(scope);
		}

		String probability = (String)attributes.get("probability");

		if (probability != null) {
			setProbability(probability);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Boolean readed = (Boolean)attributes.get("readed");

		if (readed != null) {
			setReaded(readed);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String externalCodeReference = (String)attributes.get(
			"externalCodeReference");

		if (externalCodeReference != null) {
			setExternalCodeReference(externalCodeReference);
		}
	}

	@Override
	public Alertas cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the alerta ID of this alertas.
	 *
	 * @return the alerta ID of this alertas
	 */
	@Override
	public long getAlertaId() {
		return model.getAlertaId();
	}

	/**
	 * Returns the create date of this alertas.
	 *
	 * @return the create date of this alertas
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this alertas.
	 *
	 * @return the description of this alertas
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the end date of this alertas.
	 *
	 * @return the end date of this alertas
	 */
	@Override
	public String getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the explotacion ID of this alertas.
	 *
	 * @return the explotacion ID of this alertas
	 */
	@Override
	public long getExplotacionId() {
		return model.getExplotacionId();
	}

	/**
	 * Returns the external code reference of this alertas.
	 *
	 * @return the external code reference of this alertas
	 */
	@Override
	public String getExternalCodeReference() {
		return model.getExternalCodeReference();
	}

	/**
	 * Returns the modified date of this alertas.
	 *
	 * @return the modified date of this alertas
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the phenomenom of this alertas.
	 *
	 * @return the phenomenom of this alertas
	 */
	@Override
	public String getPhenomenom() {
		return model.getPhenomenom();
	}

	/**
	 * Returns the primary key of this alertas.
	 *
	 * @return the primary key of this alertas
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the probability of this alertas.
	 *
	 * @return the probability of this alertas
	 */
	@Override
	public String getProbability() {
		return model.getProbability();
	}

	/**
	 * Returns the readed of this alertas.
	 *
	 * @return the readed of this alertas
	 */
	@Override
	public boolean getReaded() {
		return model.getReaded();
	}

	/**
	 * Returns the risk of this alertas.
	 *
	 * @return the risk of this alertas
	 */
	@Override
	public String getRisk() {
		return model.getRisk();
	}

	/**
	 * Returns the scope of this alertas.
	 *
	 * @return the scope of this alertas
	 */
	@Override
	public String getScope() {
		return model.getScope();
	}

	/**
	 * Returns the start date of this alertas.
	 *
	 * @return the start date of this alertas
	 */
	@Override
	public String getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the type of this alertas.
	 *
	 * @return the type of this alertas
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this alertas.
	 *
	 * @return the user ID of this alertas
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this alertas.
	 *
	 * @return the user uuid of this alertas
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this alertas.
	 *
	 * @return the uuid of this alertas
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this alertas is readed.
	 *
	 * @return <code>true</code> if this alertas is readed; <code>false</code> otherwise
	 */
	@Override
	public boolean isReaded() {
		return model.isReaded();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the alerta ID of this alertas.
	 *
	 * @param alertaId the alerta ID of this alertas
	 */
	@Override
	public void setAlertaId(long alertaId) {
		model.setAlertaId(alertaId);
	}

	/**
	 * Sets the create date of this alertas.
	 *
	 * @param createDate the create date of this alertas
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this alertas.
	 *
	 * @param description the description of this alertas
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the end date of this alertas.
	 *
	 * @param endDate the end date of this alertas
	 */
	@Override
	public void setEndDate(String endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the explotacion ID of this alertas.
	 *
	 * @param explotacionId the explotacion ID of this alertas
	 */
	@Override
	public void setExplotacionId(long explotacionId) {
		model.setExplotacionId(explotacionId);
	}

	/**
	 * Sets the external code reference of this alertas.
	 *
	 * @param externalCodeReference the external code reference of this alertas
	 */
	@Override
	public void setExternalCodeReference(String externalCodeReference) {
		model.setExternalCodeReference(externalCodeReference);
	}

	/**
	 * Sets the modified date of this alertas.
	 *
	 * @param modifiedDate the modified date of this alertas
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the phenomenom of this alertas.
	 *
	 * @param phenomenom the phenomenom of this alertas
	 */
	@Override
	public void setPhenomenom(String phenomenom) {
		model.setPhenomenom(phenomenom);
	}

	/**
	 * Sets the primary key of this alertas.
	 *
	 * @param primaryKey the primary key of this alertas
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the probability of this alertas.
	 *
	 * @param probability the probability of this alertas
	 */
	@Override
	public void setProbability(String probability) {
		model.setProbability(probability);
	}

	/**
	 * Sets whether this alertas is readed.
	 *
	 * @param readed the readed of this alertas
	 */
	@Override
	public void setReaded(boolean readed) {
		model.setReaded(readed);
	}

	/**
	 * Sets the risk of this alertas.
	 *
	 * @param risk the risk of this alertas
	 */
	@Override
	public void setRisk(String risk) {
		model.setRisk(risk);
	}

	/**
	 * Sets the scope of this alertas.
	 *
	 * @param scope the scope of this alertas
	 */
	@Override
	public void setScope(String scope) {
		model.setScope(scope);
	}

	/**
	 * Sets the start date of this alertas.
	 *
	 * @param startDate the start date of this alertas
	 */
	@Override
	public void setStartDate(String startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the type of this alertas.
	 *
	 * @param type the type of this alertas
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this alertas.
	 *
	 * @param userId the user ID of this alertas
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this alertas.
	 *
	 * @param userUuid the user uuid of this alertas
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this alertas.
	 *
	 * @param uuid the uuid of this alertas
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
	protected AlertasWrapper wrap(Alertas alertas) {
		return new AlertasWrapper(alertas);
	}

}