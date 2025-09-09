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
 * This class is a wrapper for {@link Explotacion}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Explotacion
 * @generated
 */
public class ExplotacionWrapper
	extends BaseModelWrapper<Explotacion>
	implements Explotacion, ModelWrapper<Explotacion> {

	public ExplotacionWrapper(Explotacion explotacion) {
		super(explotacion);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("explotacionId", getExplotacionId());
		attributes.put("provincia", getProvincia());
		attributes.put("longitude", getLongitude());
		attributes.put("height", getHeight());
		attributes.put("location", getLocation());
		attributes.put("name", getName());
		attributes.put("latitude", getLatitude());
		attributes.put("meteoredid", getMeteoredid());
		attributes.put("size", getSize());
		attributes.put("sizeUnit", getSizeUnit());
		attributes.put("isMain", isIsMain());
		attributes.put("allowNotifications", isAllowNotifications());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
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

		Long explotacionId = (Long)attributes.get("explotacionId");

		if (explotacionId != null) {
			setExplotacionId(explotacionId);
		}

		String provincia = (String)attributes.get("provincia");

		if (provincia != null) {
			setProvincia(provincia);
		}

		Double longitude = (Double)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		Integer height = (Integer)attributes.get("height");

		if (height != null) {
			setHeight(height);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Double latitude = (Double)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		String meteoredid = (String)attributes.get("meteoredid");

		if (meteoredid != null) {
			setMeteoredid(meteoredid);
		}

		Integer size = (Integer)attributes.get("size");

		if (size != null) {
			setSize(size);
		}

		String sizeUnit = (String)attributes.get("sizeUnit");

		if (sizeUnit != null) {
			setSizeUnit(sizeUnit);
		}

		Boolean isMain = (Boolean)attributes.get("isMain");

		if (isMain != null) {
			setIsMain(isMain);
		}

		Boolean allowNotifications = (Boolean)attributes.get(
			"allowNotifications");

		if (allowNotifications != null) {
			setAllowNotifications(allowNotifications);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
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
	public Explotacion cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the allow notifications of this explotacion.
	 *
	 * @return the allow notifications of this explotacion
	 */
	@Override
	public boolean getAllowNotifications() {
		return model.getAllowNotifications();
	}

	/**
	 * Returns the create date of this explotacion.
	 *
	 * @return the create date of this explotacion
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the explotacion ID of this explotacion.
	 *
	 * @return the explotacion ID of this explotacion
	 */
	@Override
	public long getExplotacionId() {
		return model.getExplotacionId();
	}

	/**
	 * Returns the external code reference of this explotacion.
	 *
	 * @return the external code reference of this explotacion
	 */
	@Override
	public String getExternalCodeReference() {
		return model.getExternalCodeReference();
	}

	/**
	 * Returns the height of this explotacion.
	 *
	 * @return the height of this explotacion
	 */
	@Override
	public Integer getHeight() {
		return model.getHeight();
	}

	/**
	 * Returns the is main of this explotacion.
	 *
	 * @return the is main of this explotacion
	 */
	@Override
	public boolean getIsMain() {
		return model.getIsMain();
	}

	/**
	 * Returns the latitude of this explotacion.
	 *
	 * @return the latitude of this explotacion
	 */
	@Override
	public Double getLatitude() {
		return model.getLatitude();
	}

	/**
	 * Returns the location of this explotacion.
	 *
	 * @return the location of this explotacion
	 */
	@Override
	public String getLocation() {
		return model.getLocation();
	}

	/**
	 * Returns the longitude of this explotacion.
	 *
	 * @return the longitude of this explotacion
	 */
	@Override
	public Double getLongitude() {
		return model.getLongitude();
	}

	/**
	 * Returns the meteoredid of this explotacion.
	 *
	 * @return the meteoredid of this explotacion
	 */
	@Override
	public String getMeteoredid() {
		return model.getMeteoredid();
	}

	/**
	 * Returns the modified date of this explotacion.
	 *
	 * @return the modified date of this explotacion
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this explotacion.
	 *
	 * @return the name of this explotacion
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this explotacion.
	 *
	 * @return the primary key of this explotacion
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the provincia of this explotacion.
	 *
	 * @return the provincia of this explotacion
	 */
	@Override
	public String getProvincia() {
		return model.getProvincia();
	}

	/**
	 * Returns the readed of this explotacion.
	 *
	 * @return the readed of this explotacion
	 */
	@Override
	public boolean getReaded() {
		return model.getReaded();
	}

	/**
	 * Returns the size of this explotacion.
	 *
	 * @return the size of this explotacion
	 */
	@Override
	public Integer getSize() {
		return model.getSize();
	}

	/**
	 * Returns the size unit of this explotacion.
	 *
	 * @return the size unit of this explotacion
	 */
	@Override
	public String getSizeUnit() {
		return model.getSizeUnit();
	}

	/**
	 * Returns the user ID of this explotacion.
	 *
	 * @return the user ID of this explotacion
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this explotacion.
	 *
	 * @return the user name of this explotacion
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this explotacion.
	 *
	 * @return the user uuid of this explotacion
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this explotacion.
	 *
	 * @return the uuid of this explotacion
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this explotacion is allow notifications.
	 *
	 * @return <code>true</code> if this explotacion is allow notifications; <code>false</code> otherwise
	 */
	@Override
	public boolean isAllowNotifications() {
		return model.isAllowNotifications();
	}

	/**
	 * Returns <code>true</code> if this explotacion is is main.
	 *
	 * @return <code>true</code> if this explotacion is is main; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsMain() {
		return model.isIsMain();
	}

	/**
	 * Returns <code>true</code> if this explotacion is readed.
	 *
	 * @return <code>true</code> if this explotacion is readed; <code>false</code> otherwise
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
	 * Sets whether this explotacion is allow notifications.
	 *
	 * @param allowNotifications the allow notifications of this explotacion
	 */
	@Override
	public void setAllowNotifications(boolean allowNotifications) {
		model.setAllowNotifications(allowNotifications);
	}

	/**
	 * Sets the create date of this explotacion.
	 *
	 * @param createDate the create date of this explotacion
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the explotacion ID of this explotacion.
	 *
	 * @param explotacionId the explotacion ID of this explotacion
	 */
	@Override
	public void setExplotacionId(long explotacionId) {
		model.setExplotacionId(explotacionId);
	}

	/**
	 * Sets the external code reference of this explotacion.
	 *
	 * @param externalCodeReference the external code reference of this explotacion
	 */
	@Override
	public void setExternalCodeReference(String externalCodeReference) {
		model.setExternalCodeReference(externalCodeReference);
	}

	/**
	 * Sets the height of this explotacion.
	 *
	 * @param height the height of this explotacion
	 */
	@Override
	public void setHeight(Integer height) {
		model.setHeight(height);
	}

	/**
	 * Sets whether this explotacion is is main.
	 *
	 * @param isMain the is main of this explotacion
	 */
	@Override
	public void setIsMain(boolean isMain) {
		model.setIsMain(isMain);
	}

	/**
	 * Sets the latitude of this explotacion.
	 *
	 * @param latitude the latitude of this explotacion
	 */
	@Override
	public void setLatitude(Double latitude) {
		model.setLatitude(latitude);
	}

	/**
	 * Sets the location of this explotacion.
	 *
	 * @param location the location of this explotacion
	 */
	@Override
	public void setLocation(String location) {
		model.setLocation(location);
	}

	/**
	 * Sets the longitude of this explotacion.
	 *
	 * @param longitude the longitude of this explotacion
	 */
	@Override
	public void setLongitude(Double longitude) {
		model.setLongitude(longitude);
	}

	/**
	 * Sets the meteoredid of this explotacion.
	 *
	 * @param meteoredid the meteoredid of this explotacion
	 */
	@Override
	public void setMeteoredid(String meteoredid) {
		model.setMeteoredid(meteoredid);
	}

	/**
	 * Sets the modified date of this explotacion.
	 *
	 * @param modifiedDate the modified date of this explotacion
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this explotacion.
	 *
	 * @param name the name of this explotacion
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this explotacion.
	 *
	 * @param primaryKey the primary key of this explotacion
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the provincia of this explotacion.
	 *
	 * @param provincia the provincia of this explotacion
	 */
	@Override
	public void setProvincia(String provincia) {
		model.setProvincia(provincia);
	}

	/**
	 * Sets whether this explotacion is readed.
	 *
	 * @param readed the readed of this explotacion
	 */
	@Override
	public void setReaded(boolean readed) {
		model.setReaded(readed);
	}

	/**
	 * Sets the size of this explotacion.
	 *
	 * @param size the size of this explotacion
	 */
	@Override
	public void setSize(Integer size) {
		model.setSize(size);
	}

	/**
	 * Sets the size unit of this explotacion.
	 *
	 * @param sizeUnit the size unit of this explotacion
	 */
	@Override
	public void setSizeUnit(String sizeUnit) {
		model.setSizeUnit(sizeUnit);
	}

	/**
	 * Sets the user ID of this explotacion.
	 *
	 * @param userId the user ID of this explotacion
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this explotacion.
	 *
	 * @param userName the user name of this explotacion
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this explotacion.
	 *
	 * @param userUuid the user uuid of this explotacion
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this explotacion.
	 *
	 * @param uuid the uuid of this explotacion
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
	protected ExplotacionWrapper wrap(Explotacion explotacion) {
		return new ExplotacionWrapper(explotacion);
	}

}