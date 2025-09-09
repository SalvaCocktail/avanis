/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence;

import avanis.lonjas.model.FechaLonja;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the fecha lonja service. This utility wraps <code>avanis.lonjas.service.persistence.impl.FechaLonjaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FechaLonjaPersistence
 * @generated
 */
public class FechaLonjaUtil {

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
	public static void clearCache(FechaLonja fechaLonja) {
		getPersistence().clearCache(fechaLonja);
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
	public static Map<Serializable, FechaLonja> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FechaLonja> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FechaLonja> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FechaLonja> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FechaLonja> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FechaLonja update(FechaLonja fechaLonja) {
		return getPersistence().update(fechaLonja);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FechaLonja update(
		FechaLonja fechaLonja, ServiceContext serviceContext) {

		return getPersistence().update(fechaLonja, serviceContext);
	}

	/**
	 * Returns all the fecha lonjas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fecha lonjas
	 */
	public static List<FechaLonja> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the fecha lonjas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FechaLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fecha lonjas
	 * @param end the upper bound of the range of fecha lonjas (not inclusive)
	 * @return the range of matching fecha lonjas
	 */
	public static List<FechaLonja> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the fecha lonjas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FechaLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fecha lonjas
	 * @param end the upper bound of the range of fecha lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fecha lonjas
	 */
	public static List<FechaLonja> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FechaLonja> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the fecha lonjas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FechaLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fecha lonjas
	 * @param end the upper bound of the range of fecha lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching fecha lonjas
	 */
	public static List<FechaLonja> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FechaLonja> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first fecha lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fecha lonja
	 * @throws NoSuchFechaLonjaException if a matching fecha lonja could not be found
	 */
	public static FechaLonja findByUuid_First(
			String uuid, OrderByComparator<FechaLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchFechaLonjaException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first fecha lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fecha lonja, or <code>null</code> if a matching fecha lonja could not be found
	 */
	public static FechaLonja fetchByUuid_First(
		String uuid, OrderByComparator<FechaLonja> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last fecha lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fecha lonja
	 * @throws NoSuchFechaLonjaException if a matching fecha lonja could not be found
	 */
	public static FechaLonja findByUuid_Last(
			String uuid, OrderByComparator<FechaLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchFechaLonjaException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last fecha lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fecha lonja, or <code>null</code> if a matching fecha lonja could not be found
	 */
	public static FechaLonja fetchByUuid_Last(
		String uuid, OrderByComparator<FechaLonja> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the fecha lonjas before and after the current fecha lonja in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current fecha lonja
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fecha lonja
	 * @throws NoSuchFechaLonjaException if a fecha lonja with the primary key could not be found
	 */
	public static FechaLonja[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			OrderByComparator<FechaLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchFechaLonjaException {

		return getPersistence().findByUuid_PrevAndNext(
			entityId, uuid, orderByComparator);
	}

	/**
	 * Removes all the fecha lonjas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of fecha lonjas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fecha lonjas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the fecha lonjas where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @return the matching fecha lonjas
	 */
	public static List<FechaLonja> findBylonjaId(long lonjaId) {
		return getPersistence().findBylonjaId(lonjaId);
	}

	/**
	 * Returns a range of all the fecha lonjas where lonjaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FechaLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param start the lower bound of the range of fecha lonjas
	 * @param end the upper bound of the range of fecha lonjas (not inclusive)
	 * @return the range of matching fecha lonjas
	 */
	public static List<FechaLonja> findBylonjaId(
		long lonjaId, int start, int end) {

		return getPersistence().findBylonjaId(lonjaId, start, end);
	}

	/**
	 * Returns an ordered range of all the fecha lonjas where lonjaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FechaLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param start the lower bound of the range of fecha lonjas
	 * @param end the upper bound of the range of fecha lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fecha lonjas
	 */
	public static List<FechaLonja> findBylonjaId(
		long lonjaId, int start, int end,
		OrderByComparator<FechaLonja> orderByComparator) {

		return getPersistence().findBylonjaId(
			lonjaId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the fecha lonjas where lonjaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FechaLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param start the lower bound of the range of fecha lonjas
	 * @param end the upper bound of the range of fecha lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching fecha lonjas
	 */
	public static List<FechaLonja> findBylonjaId(
		long lonjaId, int start, int end,
		OrderByComparator<FechaLonja> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBylonjaId(
			lonjaId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first fecha lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fecha lonja
	 * @throws NoSuchFechaLonjaException if a matching fecha lonja could not be found
	 */
	public static FechaLonja findBylonjaId_First(
			long lonjaId, OrderByComparator<FechaLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchFechaLonjaException {

		return getPersistence().findBylonjaId_First(lonjaId, orderByComparator);
	}

	/**
	 * Returns the first fecha lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fecha lonja, or <code>null</code> if a matching fecha lonja could not be found
	 */
	public static FechaLonja fetchBylonjaId_First(
		long lonjaId, OrderByComparator<FechaLonja> orderByComparator) {

		return getPersistence().fetchBylonjaId_First(
			lonjaId, orderByComparator);
	}

	/**
	 * Returns the last fecha lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fecha lonja
	 * @throws NoSuchFechaLonjaException if a matching fecha lonja could not be found
	 */
	public static FechaLonja findBylonjaId_Last(
			long lonjaId, OrderByComparator<FechaLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchFechaLonjaException {

		return getPersistence().findBylonjaId_Last(lonjaId, orderByComparator);
	}

	/**
	 * Returns the last fecha lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fecha lonja, or <code>null</code> if a matching fecha lonja could not be found
	 */
	public static FechaLonja fetchBylonjaId_Last(
		long lonjaId, OrderByComparator<FechaLonja> orderByComparator) {

		return getPersistence().fetchBylonjaId_Last(lonjaId, orderByComparator);
	}

	/**
	 * Returns the fecha lonjas before and after the current fecha lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param entityId the primary key of the current fecha lonja
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fecha lonja
	 * @throws NoSuchFechaLonjaException if a fecha lonja with the primary key could not be found
	 */
	public static FechaLonja[] findBylonjaId_PrevAndNext(
			long entityId, long lonjaId,
			OrderByComparator<FechaLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchFechaLonjaException {

		return getPersistence().findBylonjaId_PrevAndNext(
			entityId, lonjaId, orderByComparator);
	}

	/**
	 * Removes all the fecha lonjas where lonjaId = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 */
	public static void removeBylonjaId(long lonjaId) {
		getPersistence().removeBylonjaId(lonjaId);
	}

	/**
	 * Returns the number of fecha lonjas where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @return the number of matching fecha lonjas
	 */
	public static int countBylonjaId(long lonjaId) {
		return getPersistence().countBylonjaId(lonjaId);
	}

	/**
	 * Caches the fecha lonja in the entity cache if it is enabled.
	 *
	 * @param fechaLonja the fecha lonja
	 */
	public static void cacheResult(FechaLonja fechaLonja) {
		getPersistence().cacheResult(fechaLonja);
	}

	/**
	 * Caches the fecha lonjas in the entity cache if it is enabled.
	 *
	 * @param fechaLonjas the fecha lonjas
	 */
	public static void cacheResult(List<FechaLonja> fechaLonjas) {
		getPersistence().cacheResult(fechaLonjas);
	}

	/**
	 * Creates a new fecha lonja with the primary key. Does not add the fecha lonja to the database.
	 *
	 * @param entityId the primary key for the new fecha lonja
	 * @return the new fecha lonja
	 */
	public static FechaLonja create(long entityId) {
		return getPersistence().create(entityId);
	}

	/**
	 * Removes the fecha lonja with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the fecha lonja
	 * @return the fecha lonja that was removed
	 * @throws NoSuchFechaLonjaException if a fecha lonja with the primary key could not be found
	 */
	public static FechaLonja remove(long entityId)
		throws avanis.lonjas.exception.NoSuchFechaLonjaException {

		return getPersistence().remove(entityId);
	}

	public static FechaLonja updateImpl(FechaLonja fechaLonja) {
		return getPersistence().updateImpl(fechaLonja);
	}

	/**
	 * Returns the fecha lonja with the primary key or throws a <code>NoSuchFechaLonjaException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the fecha lonja
	 * @return the fecha lonja
	 * @throws NoSuchFechaLonjaException if a fecha lonja with the primary key could not be found
	 */
	public static FechaLonja findByPrimaryKey(long entityId)
		throws avanis.lonjas.exception.NoSuchFechaLonjaException {

		return getPersistence().findByPrimaryKey(entityId);
	}

	/**
	 * Returns the fecha lonja with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the fecha lonja
	 * @return the fecha lonja, or <code>null</code> if a fecha lonja with the primary key could not be found
	 */
	public static FechaLonja fetchByPrimaryKey(long entityId) {
		return getPersistence().fetchByPrimaryKey(entityId);
	}

	/**
	 * Returns all the fecha lonjas.
	 *
	 * @return the fecha lonjas
	 */
	public static List<FechaLonja> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the fecha lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FechaLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fecha lonjas
	 * @param end the upper bound of the range of fecha lonjas (not inclusive)
	 * @return the range of fecha lonjas
	 */
	public static List<FechaLonja> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the fecha lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FechaLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fecha lonjas
	 * @param end the upper bound of the range of fecha lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fecha lonjas
	 */
	public static List<FechaLonja> findAll(
		int start, int end, OrderByComparator<FechaLonja> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the fecha lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FechaLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fecha lonjas
	 * @param end the upper bound of the range of fecha lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of fecha lonjas
	 */
	public static List<FechaLonja> findAll(
		int start, int end, OrderByComparator<FechaLonja> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the fecha lonjas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of fecha lonjas.
	 *
	 * @return the number of fecha lonjas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FechaLonjaPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(FechaLonjaPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile FechaLonjaPersistence _persistence;

}