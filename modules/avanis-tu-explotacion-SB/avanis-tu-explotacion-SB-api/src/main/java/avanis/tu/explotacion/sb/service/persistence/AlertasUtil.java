/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.tu.explotacion.sb.service.persistence;

import avanis.tu.explotacion.sb.model.Alertas;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the alertas service. This utility wraps <code>avanis.tu.explotacion.sb.service.persistence.impl.AlertasPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AlertasPersistence
 * @generated
 */
public class AlertasUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Alertas alertas) {
		getPersistence().clearCache(alertas);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Alertas> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Alertas> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Alertas> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Alertas> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Alertas> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Alertas update(Alertas alertas) {
		return getPersistence().update(alertas);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Alertas update(
		Alertas alertas, ServiceContext serviceContext) {

		return getPersistence().update(alertas, serviceContext);
	}

	/**
	 * Returns all the alertases where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching alertases
	 */
	public static List<Alertas> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the alertases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @return the range of matching alertases
	 */
	public static List<Alertas> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the alertases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching alertases
	 */
	public static List<Alertas> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Alertas> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the alertases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching alertases
	 */
	public static List<Alertas> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Alertas> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first alertas in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching alertas
	 * @throws NoSuchAlertasException if a matching alertas could not be found
	 */
	public static Alertas findByUuid_First(
			String uuid, OrderByComparator<Alertas> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchAlertasException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first alertas in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching alertas, or <code>null</code> if a matching alertas could not be found
	 */
	public static Alertas fetchByUuid_First(
		String uuid, OrderByComparator<Alertas> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last alertas in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching alertas
	 * @throws NoSuchAlertasException if a matching alertas could not be found
	 */
	public static Alertas findByUuid_Last(
			String uuid, OrderByComparator<Alertas> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchAlertasException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last alertas in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching alertas, or <code>null</code> if a matching alertas could not be found
	 */
	public static Alertas fetchByUuid_Last(
		String uuid, OrderByComparator<Alertas> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the alertases before and after the current alertas in the ordered set where uuid = &#63;.
	 *
	 * @param alertaId the primary key of the current alertas
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next alertas
	 * @throws NoSuchAlertasException if a alertas with the primary key could not be found
	 */
	public static Alertas[] findByUuid_PrevAndNext(
			long alertaId, String uuid,
			OrderByComparator<Alertas> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchAlertasException {

		return getPersistence().findByUuid_PrevAndNext(
			alertaId, uuid, orderByComparator);
	}

	/**
	 * Removes all the alertases where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of alertases where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching alertases
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the alertases where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching alertases
	 */
	public static List<Alertas> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

	/**
	 * Returns a range of all the alertases where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @return the range of matching alertases
	 */
	public static List<Alertas> findByuserId(long userId, int start, int end) {
		return getPersistence().findByuserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the alertases where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching alertases
	 */
	public static List<Alertas> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Alertas> orderByComparator) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the alertases where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching alertases
	 */
	public static List<Alertas> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Alertas> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first alertas in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching alertas
	 * @throws NoSuchAlertasException if a matching alertas could not be found
	 */
	public static Alertas findByuserId_First(
			long userId, OrderByComparator<Alertas> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchAlertasException {

		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first alertas in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching alertas, or <code>null</code> if a matching alertas could not be found
	 */
	public static Alertas fetchByuserId_First(
		long userId, OrderByComparator<Alertas> orderByComparator) {

		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last alertas in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching alertas
	 * @throws NoSuchAlertasException if a matching alertas could not be found
	 */
	public static Alertas findByuserId_Last(
			long userId, OrderByComparator<Alertas> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchAlertasException {

		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last alertas in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching alertas, or <code>null</code> if a matching alertas could not be found
	 */
	public static Alertas fetchByuserId_Last(
		long userId, OrderByComparator<Alertas> orderByComparator) {

		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the alertases before and after the current alertas in the ordered set where userId = &#63;.
	 *
	 * @param alertaId the primary key of the current alertas
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next alertas
	 * @throws NoSuchAlertasException if a alertas with the primary key could not be found
	 */
	public static Alertas[] findByuserId_PrevAndNext(
			long alertaId, long userId,
			OrderByComparator<Alertas> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchAlertasException {

		return getPersistence().findByuserId_PrevAndNext(
			alertaId, userId, orderByComparator);
	}

	/**
	 * Removes all the alertases where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of alertases where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching alertases
	 */
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Returns all the alertases where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @return the matching alertases
	 */
	public static List<Alertas> findByuserIdReaded(
		long userId, boolean readed) {

		return getPersistence().findByuserIdReaded(userId, readed);
	}

	/**
	 * Returns a range of all the alertases where userId = &#63; and readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @return the range of matching alertases
	 */
	public static List<Alertas> findByuserIdReaded(
		long userId, boolean readed, int start, int end) {

		return getPersistence().findByuserIdReaded(userId, readed, start, end);
	}

	/**
	 * Returns an ordered range of all the alertases where userId = &#63; and readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching alertases
	 */
	public static List<Alertas> findByuserIdReaded(
		long userId, boolean readed, int start, int end,
		OrderByComparator<Alertas> orderByComparator) {

		return getPersistence().findByuserIdReaded(
			userId, readed, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the alertases where userId = &#63; and readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching alertases
	 */
	public static List<Alertas> findByuserIdReaded(
		long userId, boolean readed, int start, int end,
		OrderByComparator<Alertas> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByuserIdReaded(
			userId, readed, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first alertas in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching alertas
	 * @throws NoSuchAlertasException if a matching alertas could not be found
	 */
	public static Alertas findByuserIdReaded_First(
			long userId, boolean readed,
			OrderByComparator<Alertas> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchAlertasException {

		return getPersistence().findByuserIdReaded_First(
			userId, readed, orderByComparator);
	}

	/**
	 * Returns the first alertas in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching alertas, or <code>null</code> if a matching alertas could not be found
	 */
	public static Alertas fetchByuserIdReaded_First(
		long userId, boolean readed,
		OrderByComparator<Alertas> orderByComparator) {

		return getPersistence().fetchByuserIdReaded_First(
			userId, readed, orderByComparator);
	}

	/**
	 * Returns the last alertas in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching alertas
	 * @throws NoSuchAlertasException if a matching alertas could not be found
	 */
	public static Alertas findByuserIdReaded_Last(
			long userId, boolean readed,
			OrderByComparator<Alertas> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchAlertasException {

		return getPersistence().findByuserIdReaded_Last(
			userId, readed, orderByComparator);
	}

	/**
	 * Returns the last alertas in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching alertas, or <code>null</code> if a matching alertas could not be found
	 */
	public static Alertas fetchByuserIdReaded_Last(
		long userId, boolean readed,
		OrderByComparator<Alertas> orderByComparator) {

		return getPersistence().fetchByuserIdReaded_Last(
			userId, readed, orderByComparator);
	}

	/**
	 * Returns the alertases before and after the current alertas in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param alertaId the primary key of the current alertas
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next alertas
	 * @throws NoSuchAlertasException if a alertas with the primary key could not be found
	 */
	public static Alertas[] findByuserIdReaded_PrevAndNext(
			long alertaId, long userId, boolean readed,
			OrderByComparator<Alertas> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchAlertasException {

		return getPersistence().findByuserIdReaded_PrevAndNext(
			alertaId, userId, readed, orderByComparator);
	}

	/**
	 * Removes all the alertases where userId = &#63; and readed = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 */
	public static void removeByuserIdReaded(long userId, boolean readed) {
		getPersistence().removeByuserIdReaded(userId, readed);
	}

	/**
	 * Returns the number of alertases where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @return the number of matching alertases
	 */
	public static int countByuserIdReaded(long userId, boolean readed) {
		return getPersistence().countByuserIdReaded(userId, readed);
	}

	/**
	 * Caches the alertas in the entity cache if it is enabled.
	 *
	 * @param alertas the alertas
	 */
	public static void cacheResult(Alertas alertas) {
		getPersistence().cacheResult(alertas);
	}

	/**
	 * Caches the alertases in the entity cache if it is enabled.
	 *
	 * @param alertases the alertases
	 */
	public static void cacheResult(List<Alertas> alertases) {
		getPersistence().cacheResult(alertases);
	}

	/**
	 * Creates a new alertas with the primary key. Does not add the alertas to the database.
	 *
	 * @param alertaId the primary key for the new alertas
	 * @return the new alertas
	 */
	public static Alertas create(long alertaId) {
		return getPersistence().create(alertaId);
	}

	/**
	 * Removes the alertas with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param alertaId the primary key of the alertas
	 * @return the alertas that was removed
	 * @throws NoSuchAlertasException if a alertas with the primary key could not be found
	 */
	public static Alertas remove(long alertaId)
		throws avanis.tu.explotacion.sb.exception.NoSuchAlertasException {

		return getPersistence().remove(alertaId);
	}

	public static Alertas updateImpl(Alertas alertas) {
		return getPersistence().updateImpl(alertas);
	}

	/**
	 * Returns the alertas with the primary key or throws a <code>NoSuchAlertasException</code> if it could not be found.
	 *
	 * @param alertaId the primary key of the alertas
	 * @return the alertas
	 * @throws NoSuchAlertasException if a alertas with the primary key could not be found
	 */
	public static Alertas findByPrimaryKey(long alertaId)
		throws avanis.tu.explotacion.sb.exception.NoSuchAlertasException {

		return getPersistence().findByPrimaryKey(alertaId);
	}

	/**
	 * Returns the alertas with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param alertaId the primary key of the alertas
	 * @return the alertas, or <code>null</code> if a alertas with the primary key could not be found
	 */
	public static Alertas fetchByPrimaryKey(long alertaId) {
		return getPersistence().fetchByPrimaryKey(alertaId);
	}

	/**
	 * Returns all the alertases.
	 *
	 * @return the alertases
	 */
	public static List<Alertas> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the alertases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @return the range of alertases
	 */
	public static List<Alertas> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the alertases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of alertases
	 */
	public static List<Alertas> findAll(
		int start, int end, OrderByComparator<Alertas> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the alertases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of alertases
	 */
	public static List<Alertas> findAll(
		int start, int end, OrderByComparator<Alertas> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the alertases from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of alertases.
	 *
	 * @return the number of alertases
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AlertasPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AlertasPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AlertasPersistence _persistence;

}