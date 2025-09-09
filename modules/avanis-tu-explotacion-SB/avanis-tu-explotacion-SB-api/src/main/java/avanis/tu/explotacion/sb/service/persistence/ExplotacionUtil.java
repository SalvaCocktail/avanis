/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.tu.explotacion.sb.service.persistence;

import avanis.tu.explotacion.sb.model.Explotacion;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the explotacion service. This utility wraps <code>avanis.tu.explotacion.sb.service.persistence.impl.ExplotacionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExplotacionPersistence
 * @generated
 */
public class ExplotacionUtil {

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
	public static void clearCache(Explotacion explotacion) {
		getPersistence().clearCache(explotacion);
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
	public static Map<Serializable, Explotacion> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Explotacion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Explotacion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Explotacion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Explotacion> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Explotacion update(Explotacion explotacion) {
		return getPersistence().update(explotacion);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Explotacion update(
		Explotacion explotacion, ServiceContext serviceContext) {

		return getPersistence().update(explotacion, serviceContext);
	}

	/**
	 * Returns all the explotacions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching explotacions
	 */
	public static List<Explotacion> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the explotacions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @return the range of matching explotacions
	 */
	public static List<Explotacion> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the explotacions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching explotacions
	 */
	public static List<Explotacion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Explotacion> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the explotacions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching explotacions
	 */
	public static List<Explotacion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Explotacion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first explotacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public static Explotacion findByUuid_First(
			String uuid, OrderByComparator<Explotacion> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first explotacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public static Explotacion fetchByUuid_First(
		String uuid, OrderByComparator<Explotacion> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last explotacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public static Explotacion findByUuid_Last(
			String uuid, OrderByComparator<Explotacion> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last explotacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public static Explotacion fetchByUuid_Last(
		String uuid, OrderByComparator<Explotacion> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the explotacions before and after the current explotacion in the ordered set where uuid = &#63;.
	 *
	 * @param explotacionId the primary key of the current explotacion
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next explotacion
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	public static Explotacion[] findByUuid_PrevAndNext(
			long explotacionId, String uuid,
			OrderByComparator<Explotacion> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getPersistence().findByUuid_PrevAndNext(
			explotacionId, uuid, orderByComparator);
	}

	/**
	 * Removes all the explotacions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of explotacions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching explotacions
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the explotacions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching explotacions
	 */
	public static List<Explotacion> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

	/**
	 * Returns a range of all the explotacions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @return the range of matching explotacions
	 */
	public static List<Explotacion> findByuserId(
		long userId, int start, int end) {

		return getPersistence().findByuserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the explotacions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching explotacions
	 */
	public static List<Explotacion> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Explotacion> orderByComparator) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the explotacions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching explotacions
	 */
	public static List<Explotacion> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Explotacion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first explotacion in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public static Explotacion findByuserId_First(
			long userId, OrderByComparator<Explotacion> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first explotacion in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public static Explotacion fetchByuserId_First(
		long userId, OrderByComparator<Explotacion> orderByComparator) {

		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last explotacion in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public static Explotacion findByuserId_Last(
			long userId, OrderByComparator<Explotacion> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last explotacion in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public static Explotacion fetchByuserId_Last(
		long userId, OrderByComparator<Explotacion> orderByComparator) {

		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the explotacions before and after the current explotacion in the ordered set where userId = &#63;.
	 *
	 * @param explotacionId the primary key of the current explotacion
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next explotacion
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	public static Explotacion[] findByuserId_PrevAndNext(
			long explotacionId, long userId,
			OrderByComparator<Explotacion> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getPersistence().findByuserId_PrevAndNext(
			explotacionId, userId, orderByComparator);
	}

	/**
	 * Removes all the explotacions where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of explotacions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching explotacions
	 */
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Returns all the explotacions where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @return the matching explotacions
	 */
	public static List<Explotacion> findByuserIdReaded(
		long userId, boolean readed) {

		return getPersistence().findByuserIdReaded(userId, readed);
	}

	/**
	 * Returns a range of all the explotacions where userId = &#63; and readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @return the range of matching explotacions
	 */
	public static List<Explotacion> findByuserIdReaded(
		long userId, boolean readed, int start, int end) {

		return getPersistence().findByuserIdReaded(userId, readed, start, end);
	}

	/**
	 * Returns an ordered range of all the explotacions where userId = &#63; and readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching explotacions
	 */
	public static List<Explotacion> findByuserIdReaded(
		long userId, boolean readed, int start, int end,
		OrderByComparator<Explotacion> orderByComparator) {

		return getPersistence().findByuserIdReaded(
			userId, readed, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the explotacions where userId = &#63; and readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching explotacions
	 */
	public static List<Explotacion> findByuserIdReaded(
		long userId, boolean readed, int start, int end,
		OrderByComparator<Explotacion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByuserIdReaded(
			userId, readed, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first explotacion in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public static Explotacion findByuserIdReaded_First(
			long userId, boolean readed,
			OrderByComparator<Explotacion> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getPersistence().findByuserIdReaded_First(
			userId, readed, orderByComparator);
	}

	/**
	 * Returns the first explotacion in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public static Explotacion fetchByuserIdReaded_First(
		long userId, boolean readed,
		OrderByComparator<Explotacion> orderByComparator) {

		return getPersistence().fetchByuserIdReaded_First(
			userId, readed, orderByComparator);
	}

	/**
	 * Returns the last explotacion in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public static Explotacion findByuserIdReaded_Last(
			long userId, boolean readed,
			OrderByComparator<Explotacion> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getPersistence().findByuserIdReaded_Last(
			userId, readed, orderByComparator);
	}

	/**
	 * Returns the last explotacion in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public static Explotacion fetchByuserIdReaded_Last(
		long userId, boolean readed,
		OrderByComparator<Explotacion> orderByComparator) {

		return getPersistence().fetchByuserIdReaded_Last(
			userId, readed, orderByComparator);
	}

	/**
	 * Returns the explotacions before and after the current explotacion in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param explotacionId the primary key of the current explotacion
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next explotacion
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	public static Explotacion[] findByuserIdReaded_PrevAndNext(
			long explotacionId, long userId, boolean readed,
			OrderByComparator<Explotacion> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getPersistence().findByuserIdReaded_PrevAndNext(
			explotacionId, userId, readed, orderByComparator);
	}

	/**
	 * Removes all the explotacions where userId = &#63; and readed = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 */
	public static void removeByuserIdReaded(long userId, boolean readed) {
		getPersistence().removeByuserIdReaded(userId, readed);
	}

	/**
	 * Returns the number of explotacions where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @return the number of matching explotacions
	 */
	public static int countByuserIdReaded(long userId, boolean readed) {
		return getPersistence().countByuserIdReaded(userId, readed);
	}

	/**
	 * Returns the explotacion where externalCodeReference = &#63; and userId = &#63; or throws a <code>NoSuchExplotacionException</code> if it could not be found.
	 *
	 * @param externalCodeReference the external code reference
	 * @param userId the user ID
	 * @return the matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public static Explotacion findByexternalCodeReferenceAndUserId(
			String externalCodeReference, long userId)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getPersistence().findByexternalCodeReferenceAndUserId(
			externalCodeReference, userId);
	}

	/**
	 * Returns the explotacion where externalCodeReference = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalCodeReference the external code reference
	 * @param userId the user ID
	 * @return the matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public static Explotacion fetchByexternalCodeReferenceAndUserId(
		String externalCodeReference, long userId) {

		return getPersistence().fetchByexternalCodeReferenceAndUserId(
			externalCodeReference, userId);
	}

	/**
	 * Returns the explotacion where externalCodeReference = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalCodeReference the external code reference
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public static Explotacion fetchByexternalCodeReferenceAndUserId(
		String externalCodeReference, long userId, boolean useFinderCache) {

		return getPersistence().fetchByexternalCodeReferenceAndUserId(
			externalCodeReference, userId, useFinderCache);
	}

	/**
	 * Removes the explotacion where externalCodeReference = &#63; and userId = &#63; from the database.
	 *
	 * @param externalCodeReference the external code reference
	 * @param userId the user ID
	 * @return the explotacion that was removed
	 */
	public static Explotacion removeByexternalCodeReferenceAndUserId(
			String externalCodeReference, long userId)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getPersistence().removeByexternalCodeReferenceAndUserId(
			externalCodeReference, userId);
	}

	/**
	 * Returns the number of explotacions where externalCodeReference = &#63; and userId = &#63;.
	 *
	 * @param externalCodeReference the external code reference
	 * @param userId the user ID
	 * @return the number of matching explotacions
	 */
	public static int countByexternalCodeReferenceAndUserId(
		String externalCodeReference, long userId) {

		return getPersistence().countByexternalCodeReferenceAndUserId(
			externalCodeReference, userId);
	}

	/**
	 * Returns all the explotacions where isMain = &#63; and userId = &#63;.
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @return the matching explotacions
	 */
	public static List<Explotacion> findByisMainAndUser(
		boolean isMain, long userId) {

		return getPersistence().findByisMainAndUser(isMain, userId);
	}

	/**
	 * Returns a range of all the explotacions where isMain = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @return the range of matching explotacions
	 */
	public static List<Explotacion> findByisMainAndUser(
		boolean isMain, long userId, int start, int end) {

		return getPersistence().findByisMainAndUser(isMain, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the explotacions where isMain = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching explotacions
	 */
	public static List<Explotacion> findByisMainAndUser(
		boolean isMain, long userId, int start, int end,
		OrderByComparator<Explotacion> orderByComparator) {

		return getPersistence().findByisMainAndUser(
			isMain, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the explotacions where isMain = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching explotacions
	 */
	public static List<Explotacion> findByisMainAndUser(
		boolean isMain, long userId, int start, int end,
		OrderByComparator<Explotacion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByisMainAndUser(
			isMain, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first explotacion in the ordered set where isMain = &#63; and userId = &#63;.
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public static Explotacion findByisMainAndUser_First(
			boolean isMain, long userId,
			OrderByComparator<Explotacion> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getPersistence().findByisMainAndUser_First(
			isMain, userId, orderByComparator);
	}

	/**
	 * Returns the first explotacion in the ordered set where isMain = &#63; and userId = &#63;.
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public static Explotacion fetchByisMainAndUser_First(
		boolean isMain, long userId,
		OrderByComparator<Explotacion> orderByComparator) {

		return getPersistence().fetchByisMainAndUser_First(
			isMain, userId, orderByComparator);
	}

	/**
	 * Returns the last explotacion in the ordered set where isMain = &#63; and userId = &#63;.
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public static Explotacion findByisMainAndUser_Last(
			boolean isMain, long userId,
			OrderByComparator<Explotacion> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getPersistence().findByisMainAndUser_Last(
			isMain, userId, orderByComparator);
	}

	/**
	 * Returns the last explotacion in the ordered set where isMain = &#63; and userId = &#63;.
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public static Explotacion fetchByisMainAndUser_Last(
		boolean isMain, long userId,
		OrderByComparator<Explotacion> orderByComparator) {

		return getPersistence().fetchByisMainAndUser_Last(
			isMain, userId, orderByComparator);
	}

	/**
	 * Returns the explotacions before and after the current explotacion in the ordered set where isMain = &#63; and userId = &#63;.
	 *
	 * @param explotacionId the primary key of the current explotacion
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next explotacion
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	public static Explotacion[] findByisMainAndUser_PrevAndNext(
			long explotacionId, boolean isMain, long userId,
			OrderByComparator<Explotacion> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getPersistence().findByisMainAndUser_PrevAndNext(
			explotacionId, isMain, userId, orderByComparator);
	}

	/**
	 * Removes all the explotacions where isMain = &#63; and userId = &#63; from the database.
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 */
	public static void removeByisMainAndUser(boolean isMain, long userId) {
		getPersistence().removeByisMainAndUser(isMain, userId);
	}

	/**
	 * Returns the number of explotacions where isMain = &#63; and userId = &#63;.
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @return the number of matching explotacions
	 */
	public static int countByisMainAndUser(boolean isMain, long userId) {
		return getPersistence().countByisMainAndUser(isMain, userId);
	}

	/**
	 * Returns the explotacion where explotacionId = &#63; and userId = &#63; or throws a <code>NoSuchExplotacionException</code> if it could not be found.
	 *
	 * @param explotacionId the explotacion ID
	 * @param userId the user ID
	 * @return the matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public static Explotacion findByidAndUserId(long explotacionId, long userId)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getPersistence().findByidAndUserId(explotacionId, userId);
	}

	/**
	 * Returns the explotacion where explotacionId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param explotacionId the explotacion ID
	 * @param userId the user ID
	 * @return the matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public static Explotacion fetchByidAndUserId(
		long explotacionId, long userId) {

		return getPersistence().fetchByidAndUserId(explotacionId, userId);
	}

	/**
	 * Returns the explotacion where explotacionId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param explotacionId the explotacion ID
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public static Explotacion fetchByidAndUserId(
		long explotacionId, long userId, boolean useFinderCache) {

		return getPersistence().fetchByidAndUserId(
			explotacionId, userId, useFinderCache);
	}

	/**
	 * Removes the explotacion where explotacionId = &#63; and userId = &#63; from the database.
	 *
	 * @param explotacionId the explotacion ID
	 * @param userId the user ID
	 * @return the explotacion that was removed
	 */
	public static Explotacion removeByidAndUserId(
			long explotacionId, long userId)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getPersistence().removeByidAndUserId(explotacionId, userId);
	}

	/**
	 * Returns the number of explotacions where explotacionId = &#63; and userId = &#63;.
	 *
	 * @param explotacionId the explotacion ID
	 * @param userId the user ID
	 * @return the number of matching explotacions
	 */
	public static int countByidAndUserId(long explotacionId, long userId) {
		return getPersistence().countByidAndUserId(explotacionId, userId);
	}

	/**
	 * Returns all the explotacions where readed = &#63;.
	 *
	 * @param readed the readed
	 * @return the matching explotacions
	 */
	public static List<Explotacion> findByreaded(boolean readed) {
		return getPersistence().findByreaded(readed);
	}

	/**
	 * Returns a range of all the explotacions where readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param readed the readed
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @return the range of matching explotacions
	 */
	public static List<Explotacion> findByreaded(
		boolean readed, int start, int end) {

		return getPersistence().findByreaded(readed, start, end);
	}

	/**
	 * Returns an ordered range of all the explotacions where readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param readed the readed
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching explotacions
	 */
	public static List<Explotacion> findByreaded(
		boolean readed, int start, int end,
		OrderByComparator<Explotacion> orderByComparator) {

		return getPersistence().findByreaded(
			readed, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the explotacions where readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param readed the readed
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching explotacions
	 */
	public static List<Explotacion> findByreaded(
		boolean readed, int start, int end,
		OrderByComparator<Explotacion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByreaded(
			readed, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first explotacion in the ordered set where readed = &#63;.
	 *
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public static Explotacion findByreaded_First(
			boolean readed, OrderByComparator<Explotacion> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getPersistence().findByreaded_First(readed, orderByComparator);
	}

	/**
	 * Returns the first explotacion in the ordered set where readed = &#63;.
	 *
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public static Explotacion fetchByreaded_First(
		boolean readed, OrderByComparator<Explotacion> orderByComparator) {

		return getPersistence().fetchByreaded_First(readed, orderByComparator);
	}

	/**
	 * Returns the last explotacion in the ordered set where readed = &#63;.
	 *
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	public static Explotacion findByreaded_Last(
			boolean readed, OrderByComparator<Explotacion> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getPersistence().findByreaded_Last(readed, orderByComparator);
	}

	/**
	 * Returns the last explotacion in the ordered set where readed = &#63;.
	 *
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	public static Explotacion fetchByreaded_Last(
		boolean readed, OrderByComparator<Explotacion> orderByComparator) {

		return getPersistence().fetchByreaded_Last(readed, orderByComparator);
	}

	/**
	 * Returns the explotacions before and after the current explotacion in the ordered set where readed = &#63;.
	 *
	 * @param explotacionId the primary key of the current explotacion
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next explotacion
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	public static Explotacion[] findByreaded_PrevAndNext(
			long explotacionId, boolean readed,
			OrderByComparator<Explotacion> orderByComparator)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getPersistence().findByreaded_PrevAndNext(
			explotacionId, readed, orderByComparator);
	}

	/**
	 * Removes all the explotacions where readed = &#63; from the database.
	 *
	 * @param readed the readed
	 */
	public static void removeByreaded(boolean readed) {
		getPersistence().removeByreaded(readed);
	}

	/**
	 * Returns the number of explotacions where readed = &#63;.
	 *
	 * @param readed the readed
	 * @return the number of matching explotacions
	 */
	public static int countByreaded(boolean readed) {
		return getPersistence().countByreaded(readed);
	}

	/**
	 * Caches the explotacion in the entity cache if it is enabled.
	 *
	 * @param explotacion the explotacion
	 */
	public static void cacheResult(Explotacion explotacion) {
		getPersistence().cacheResult(explotacion);
	}

	/**
	 * Caches the explotacions in the entity cache if it is enabled.
	 *
	 * @param explotacions the explotacions
	 */
	public static void cacheResult(List<Explotacion> explotacions) {
		getPersistence().cacheResult(explotacions);
	}

	/**
	 * Creates a new explotacion with the primary key. Does not add the explotacion to the database.
	 *
	 * @param explotacionId the primary key for the new explotacion
	 * @return the new explotacion
	 */
	public static Explotacion create(long explotacionId) {
		return getPersistence().create(explotacionId);
	}

	/**
	 * Removes the explotacion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param explotacionId the primary key of the explotacion
	 * @return the explotacion that was removed
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	public static Explotacion remove(long explotacionId)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getPersistence().remove(explotacionId);
	}

	public static Explotacion updateImpl(Explotacion explotacion) {
		return getPersistence().updateImpl(explotacion);
	}

	/**
	 * Returns the explotacion with the primary key or throws a <code>NoSuchExplotacionException</code> if it could not be found.
	 *
	 * @param explotacionId the primary key of the explotacion
	 * @return the explotacion
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	public static Explotacion findByPrimaryKey(long explotacionId)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getPersistence().findByPrimaryKey(explotacionId);
	}

	/**
	 * Returns the explotacion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param explotacionId the primary key of the explotacion
	 * @return the explotacion, or <code>null</code> if a explotacion with the primary key could not be found
	 */
	public static Explotacion fetchByPrimaryKey(long explotacionId) {
		return getPersistence().fetchByPrimaryKey(explotacionId);
	}

	/**
	 * Returns all the explotacions.
	 *
	 * @return the explotacions
	 */
	public static List<Explotacion> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the explotacions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @return the range of explotacions
	 */
	public static List<Explotacion> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the explotacions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of explotacions
	 */
	public static List<Explotacion> findAll(
		int start, int end, OrderByComparator<Explotacion> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the explotacions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of explotacions
	 */
	public static List<Explotacion> findAll(
		int start, int end, OrderByComparator<Explotacion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the explotacions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of explotacions.
	 *
	 * @return the number of explotacions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ExplotacionPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ExplotacionPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ExplotacionPersistence _persistence;

}