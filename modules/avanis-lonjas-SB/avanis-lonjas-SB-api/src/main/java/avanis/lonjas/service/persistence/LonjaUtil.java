/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence;

import avanis.lonjas.model.Lonja;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the lonja service. This utility wraps <code>avanis.lonjas.service.persistence.impl.LonjaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LonjaPersistence
 * @generated
 */
public class LonjaUtil {

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
	public static void clearCache(Lonja lonja) {
		getPersistence().clearCache(lonja);
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
	public static Map<Serializable, Lonja> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Lonja> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Lonja> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Lonja> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Lonja> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Lonja update(Lonja lonja) {
		return getPersistence().update(lonja);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Lonja update(Lonja lonja, ServiceContext serviceContext) {
		return getPersistence().update(lonja, serviceContext);
	}

	/**
	 * Returns all the lonjas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching lonjas
	 */
	public static List<Lonja> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the lonjas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @return the range of matching lonjas
	 */
	public static List<Lonja> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the lonjas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lonjas
	 */
	public static List<Lonja> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Lonja> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lonjas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lonjas
	 */
	public static List<Lonja> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Lonja> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lonja
	 * @throws NoSuchLonjaException if a matching lonja could not be found
	 */
	public static Lonja findByUuid_First(
			String uuid, OrderByComparator<Lonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchLonjaException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lonja, or <code>null</code> if a matching lonja could not be found
	 */
	public static Lonja fetchByUuid_First(
		String uuid, OrderByComparator<Lonja> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lonja
	 * @throws NoSuchLonjaException if a matching lonja could not be found
	 */
	public static Lonja findByUuid_Last(
			String uuid, OrderByComparator<Lonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchLonjaException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lonja, or <code>null</code> if a matching lonja could not be found
	 */
	public static Lonja fetchByUuid_Last(
		String uuid, OrderByComparator<Lonja> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the lonjas before and after the current lonja in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current lonja
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lonja
	 * @throws NoSuchLonjaException if a lonja with the primary key could not be found
	 */
	public static Lonja[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			OrderByComparator<Lonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchLonjaException {

		return getPersistence().findByUuid_PrevAndNext(
			entityId, uuid, orderByComparator);
	}

	/**
	 * Removes all the lonjas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of lonjas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching lonjas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the lonjas where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @return the matching lonjas
	 */
	public static List<Lonja> findBylonjaId(long lonjaId) {
		return getPersistence().findBylonjaId(lonjaId);
	}

	/**
	 * Returns a range of all the lonjas where lonjaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @return the range of matching lonjas
	 */
	public static List<Lonja> findBylonjaId(long lonjaId, int start, int end) {
		return getPersistence().findBylonjaId(lonjaId, start, end);
	}

	/**
	 * Returns an ordered range of all the lonjas where lonjaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lonjas
	 */
	public static List<Lonja> findBylonjaId(
		long lonjaId, int start, int end,
		OrderByComparator<Lonja> orderByComparator) {

		return getPersistence().findBylonjaId(
			lonjaId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lonjas where lonjaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lonjas
	 */
	public static List<Lonja> findBylonjaId(
		long lonjaId, int start, int end,
		OrderByComparator<Lonja> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBylonjaId(
			lonjaId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lonja
	 * @throws NoSuchLonjaException if a matching lonja could not be found
	 */
	public static Lonja findBylonjaId_First(
			long lonjaId, OrderByComparator<Lonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchLonjaException {

		return getPersistence().findBylonjaId_First(lonjaId, orderByComparator);
	}

	/**
	 * Returns the first lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lonja, or <code>null</code> if a matching lonja could not be found
	 */
	public static Lonja fetchBylonjaId_First(
		long lonjaId, OrderByComparator<Lonja> orderByComparator) {

		return getPersistence().fetchBylonjaId_First(
			lonjaId, orderByComparator);
	}

	/**
	 * Returns the last lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lonja
	 * @throws NoSuchLonjaException if a matching lonja could not be found
	 */
	public static Lonja findBylonjaId_Last(
			long lonjaId, OrderByComparator<Lonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchLonjaException {

		return getPersistence().findBylonjaId_Last(lonjaId, orderByComparator);
	}

	/**
	 * Returns the last lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lonja, or <code>null</code> if a matching lonja could not be found
	 */
	public static Lonja fetchBylonjaId_Last(
		long lonjaId, OrderByComparator<Lonja> orderByComparator) {

		return getPersistence().fetchBylonjaId_Last(lonjaId, orderByComparator);
	}

	/**
	 * Returns the lonjas before and after the current lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param entityId the primary key of the current lonja
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lonja
	 * @throws NoSuchLonjaException if a lonja with the primary key could not be found
	 */
	public static Lonja[] findBylonjaId_PrevAndNext(
			long entityId, long lonjaId,
			OrderByComparator<Lonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchLonjaException {

		return getPersistence().findBylonjaId_PrevAndNext(
			entityId, lonjaId, orderByComparator);
	}

	/**
	 * Removes all the lonjas where lonjaId = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 */
	public static void removeBylonjaId(long lonjaId) {
		getPersistence().removeBylonjaId(lonjaId);
	}

	/**
	 * Returns the number of lonjas where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @return the number of matching lonjas
	 */
	public static int countBylonjaId(long lonjaId) {
		return getPersistence().countBylonjaId(lonjaId);
	}

	/**
	 * Returns all the lonjas where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the matching lonjas
	 */
	public static List<Lonja> findBynombre(String nombre) {
		return getPersistence().findBynombre(nombre);
	}

	/**
	 * Returns a range of all the lonjas where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @return the range of matching lonjas
	 */
	public static List<Lonja> findBynombre(String nombre, int start, int end) {
		return getPersistence().findBynombre(nombre, start, end);
	}

	/**
	 * Returns an ordered range of all the lonjas where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lonjas
	 */
	public static List<Lonja> findBynombre(
		String nombre, int start, int end,
		OrderByComparator<Lonja> orderByComparator) {

		return getPersistence().findBynombre(
			nombre, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lonjas where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lonjas
	 */
	public static List<Lonja> findBynombre(
		String nombre, int start, int end,
		OrderByComparator<Lonja> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBynombre(
			nombre, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first lonja in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lonja
	 * @throws NoSuchLonjaException if a matching lonja could not be found
	 */
	public static Lonja findBynombre_First(
			String nombre, OrderByComparator<Lonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchLonjaException {

		return getPersistence().findBynombre_First(nombre, orderByComparator);
	}

	/**
	 * Returns the first lonja in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lonja, or <code>null</code> if a matching lonja could not be found
	 */
	public static Lonja fetchBynombre_First(
		String nombre, OrderByComparator<Lonja> orderByComparator) {

		return getPersistence().fetchBynombre_First(nombre, orderByComparator);
	}

	/**
	 * Returns the last lonja in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lonja
	 * @throws NoSuchLonjaException if a matching lonja could not be found
	 */
	public static Lonja findBynombre_Last(
			String nombre, OrderByComparator<Lonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchLonjaException {

		return getPersistence().findBynombre_Last(nombre, orderByComparator);
	}

	/**
	 * Returns the last lonja in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lonja, or <code>null</code> if a matching lonja could not be found
	 */
	public static Lonja fetchBynombre_Last(
		String nombre, OrderByComparator<Lonja> orderByComparator) {

		return getPersistence().fetchBynombre_Last(nombre, orderByComparator);
	}

	/**
	 * Returns the lonjas before and after the current lonja in the ordered set where nombre = &#63;.
	 *
	 * @param entityId the primary key of the current lonja
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lonja
	 * @throws NoSuchLonjaException if a lonja with the primary key could not be found
	 */
	public static Lonja[] findBynombre_PrevAndNext(
			long entityId, String nombre,
			OrderByComparator<Lonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchLonjaException {

		return getPersistence().findBynombre_PrevAndNext(
			entityId, nombre, orderByComparator);
	}

	/**
	 * Removes all the lonjas where nombre = &#63; from the database.
	 *
	 * @param nombre the nombre
	 */
	public static void removeBynombre(String nombre) {
		getPersistence().removeBynombre(nombre);
	}

	/**
	 * Returns the number of lonjas where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the number of matching lonjas
	 */
	public static int countBynombre(String nombre) {
		return getPersistence().countBynombre(nombre);
	}

	/**
	 * Caches the lonja in the entity cache if it is enabled.
	 *
	 * @param lonja the lonja
	 */
	public static void cacheResult(Lonja lonja) {
		getPersistence().cacheResult(lonja);
	}

	/**
	 * Caches the lonjas in the entity cache if it is enabled.
	 *
	 * @param lonjas the lonjas
	 */
	public static void cacheResult(List<Lonja> lonjas) {
		getPersistence().cacheResult(lonjas);
	}

	/**
	 * Creates a new lonja with the primary key. Does not add the lonja to the database.
	 *
	 * @param entityId the primary key for the new lonja
	 * @return the new lonja
	 */
	public static Lonja create(long entityId) {
		return getPersistence().create(entityId);
	}

	/**
	 * Removes the lonja with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the lonja
	 * @return the lonja that was removed
	 * @throws NoSuchLonjaException if a lonja with the primary key could not be found
	 */
	public static Lonja remove(long entityId)
		throws avanis.lonjas.exception.NoSuchLonjaException {

		return getPersistence().remove(entityId);
	}

	public static Lonja updateImpl(Lonja lonja) {
		return getPersistence().updateImpl(lonja);
	}

	/**
	 * Returns the lonja with the primary key or throws a <code>NoSuchLonjaException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the lonja
	 * @return the lonja
	 * @throws NoSuchLonjaException if a lonja with the primary key could not be found
	 */
	public static Lonja findByPrimaryKey(long entityId)
		throws avanis.lonjas.exception.NoSuchLonjaException {

		return getPersistence().findByPrimaryKey(entityId);
	}

	/**
	 * Returns the lonja with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the lonja
	 * @return the lonja, or <code>null</code> if a lonja with the primary key could not be found
	 */
	public static Lonja fetchByPrimaryKey(long entityId) {
		return getPersistence().fetchByPrimaryKey(entityId);
	}

	/**
	 * Returns all the lonjas.
	 *
	 * @return the lonjas
	 */
	public static List<Lonja> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @return the range of lonjas
	 */
	public static List<Lonja> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lonjas
	 */
	public static List<Lonja> findAll(
		int start, int end, OrderByComparator<Lonja> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lonjas
	 */
	public static List<Lonja> findAll(
		int start, int end, OrderByComparator<Lonja> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the lonjas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of lonjas.
	 *
	 * @return the number of lonjas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LonjaPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(LonjaPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile LonjaPersistence _persistence;

}