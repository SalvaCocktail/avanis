/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence;

import avanis.lonjas.model.PrecioLonja;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the precio lonja service. This utility wraps <code>avanis.lonjas.service.persistence.impl.PrecioLonjaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PrecioLonjaPersistence
 * @generated
 */
public class PrecioLonjaUtil {

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
	public static void clearCache(PrecioLonja precioLonja) {
		getPersistence().clearCache(precioLonja);
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
	public static Map<Serializable, PrecioLonja> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PrecioLonja> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PrecioLonja> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PrecioLonja> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PrecioLonja update(PrecioLonja precioLonja) {
		return getPersistence().update(precioLonja);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PrecioLonja update(
		PrecioLonja precioLonja, ServiceContext serviceContext) {

		return getPersistence().update(precioLonja, serviceContext);
	}

	/**
	 * Returns all the precio lonjas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching precio lonjas
	 */
	public static List<PrecioLonja> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the precio lonjas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @return the range of matching precio lonjas
	 */
	public static List<PrecioLonja> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching precio lonjas
	 */
	public static List<PrecioLonja> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching precio lonjas
	 */
	public static List<PrecioLonja> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first precio lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public static PrecioLonja findByUuid_First(
			String uuid, OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first precio lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public static PrecioLonja fetchByUuid_First(
		String uuid, OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last precio lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public static PrecioLonja findByUuid_Last(
			String uuid, OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last precio lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public static PrecioLonja fetchByUuid_Last(
		String uuid, OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the precio lonjas before and after the current precio lonja in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current precio lonja
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	public static PrecioLonja[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findByUuid_PrevAndNext(
			entityId, uuid, orderByComparator);
	}

	/**
	 * Removes all the precio lonjas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of precio lonjas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching precio lonjas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the precio lonjas where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @return the matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaId(long lonjaId) {
		return getPersistence().findBylonjaId(lonjaId);
	}

	/**
	 * Returns a range of all the precio lonjas where lonjaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @return the range of matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaId(
		long lonjaId, int start, int end) {

		return getPersistence().findBylonjaId(lonjaId, start, end);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaId(
		long lonjaId, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().findBylonjaId(
			lonjaId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaId(
		long lonjaId, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBylonjaId(
			lonjaId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public static PrecioLonja findBylonjaId_First(
			long lonjaId, OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findBylonjaId_First(lonjaId, orderByComparator);
	}

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public static PrecioLonja fetchBylonjaId_First(
		long lonjaId, OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().fetchBylonjaId_First(
			lonjaId, orderByComparator);
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public static PrecioLonja findBylonjaId_Last(
			long lonjaId, OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findBylonjaId_Last(lonjaId, orderByComparator);
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public static PrecioLonja fetchBylonjaId_Last(
		long lonjaId, OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().fetchBylonjaId_Last(lonjaId, orderByComparator);
	}

	/**
	 * Returns the precio lonjas before and after the current precio lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param entityId the primary key of the current precio lonja
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	public static PrecioLonja[] findBylonjaId_PrevAndNext(
			long entityId, long lonjaId,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findBylonjaId_PrevAndNext(
			entityId, lonjaId, orderByComparator);
	}

	/**
	 * Removes all the precio lonjas where lonjaId = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 */
	public static void removeBylonjaId(long lonjaId) {
		getPersistence().removeBylonjaId(lonjaId);
	}

	/**
	 * Returns the number of precio lonjas where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @return the number of matching precio lonjas
	 */
	public static int countBylonjaId(long lonjaId) {
		return getPersistence().countBylonjaId(lonjaId);
	}

	/**
	 * Returns all the precio lonjas where productoId = &#63;.
	 *
	 * @param productoId the producto ID
	 * @return the matching precio lonjas
	 */
	public static List<PrecioLonja> findByproductoId(long productoId) {
		return getPersistence().findByproductoId(productoId);
	}

	/**
	 * Returns a range of all the precio lonjas where productoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param productoId the producto ID
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @return the range of matching precio lonjas
	 */
	public static List<PrecioLonja> findByproductoId(
		long productoId, int start, int end) {

		return getPersistence().findByproductoId(productoId, start, end);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where productoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param productoId the producto ID
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching precio lonjas
	 */
	public static List<PrecioLonja> findByproductoId(
		long productoId, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().findByproductoId(
			productoId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where productoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param productoId the producto ID
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching precio lonjas
	 */
	public static List<PrecioLonja> findByproductoId(
		long productoId, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByproductoId(
			productoId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first precio lonja in the ordered set where productoId = &#63;.
	 *
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public static PrecioLonja findByproductoId_First(
			long productoId, OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findByproductoId_First(
			productoId, orderByComparator);
	}

	/**
	 * Returns the first precio lonja in the ordered set where productoId = &#63;.
	 *
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public static PrecioLonja fetchByproductoId_First(
		long productoId, OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().fetchByproductoId_First(
			productoId, orderByComparator);
	}

	/**
	 * Returns the last precio lonja in the ordered set where productoId = &#63;.
	 *
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public static PrecioLonja findByproductoId_Last(
			long productoId, OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findByproductoId_Last(
			productoId, orderByComparator);
	}

	/**
	 * Returns the last precio lonja in the ordered set where productoId = &#63;.
	 *
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public static PrecioLonja fetchByproductoId_Last(
		long productoId, OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().fetchByproductoId_Last(
			productoId, orderByComparator);
	}

	/**
	 * Returns the precio lonjas before and after the current precio lonja in the ordered set where productoId = &#63;.
	 *
	 * @param entityId the primary key of the current precio lonja
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	public static PrecioLonja[] findByproductoId_PrevAndNext(
			long entityId, long productoId,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findByproductoId_PrevAndNext(
			entityId, productoId, orderByComparator);
	}

	/**
	 * Removes all the precio lonjas where productoId = &#63; from the database.
	 *
	 * @param productoId the producto ID
	 */
	public static void removeByproductoId(long productoId) {
		getPersistence().removeByproductoId(productoId);
	}

	/**
	 * Returns the number of precio lonjas where productoId = &#63;.
	 *
	 * @param productoId the producto ID
	 * @return the number of matching precio lonjas
	 */
	public static int countByproductoId(long productoId) {
		return getPersistence().countByproductoId(productoId);
	}

	/**
	 * Returns all the precio lonjas where lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @return the matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaIdProductoId(
		long lonjaId, long productoId) {

		return getPersistence().findBylonjaIdProductoId(lonjaId, productoId);
	}

	/**
	 * Returns a range of all the precio lonjas where lonjaId = &#63; and productoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @return the range of matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaIdProductoId(
		long lonjaId, long productoId, int start, int end) {

		return getPersistence().findBylonjaIdProductoId(
			lonjaId, productoId, start, end);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63; and productoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaIdProductoId(
		long lonjaId, long productoId, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().findBylonjaIdProductoId(
			lonjaId, productoId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63; and productoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaIdProductoId(
		long lonjaId, long productoId, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBylonjaIdProductoId(
			lonjaId, productoId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public static PrecioLonja findBylonjaIdProductoId_First(
			long lonjaId, long productoId,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findBylonjaIdProductoId_First(
			lonjaId, productoId, orderByComparator);
	}

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public static PrecioLonja fetchBylonjaIdProductoId_First(
		long lonjaId, long productoId,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().fetchBylonjaIdProductoId_First(
			lonjaId, productoId, orderByComparator);
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public static PrecioLonja findBylonjaIdProductoId_Last(
			long lonjaId, long productoId,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findBylonjaIdProductoId_Last(
			lonjaId, productoId, orderByComparator);
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public static PrecioLonja fetchBylonjaIdProductoId_Last(
		long lonjaId, long productoId,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().fetchBylonjaIdProductoId_Last(
			lonjaId, productoId, orderByComparator);
	}

	/**
	 * Returns the precio lonjas before and after the current precio lonja in the ordered set where lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param entityId the primary key of the current precio lonja
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	public static PrecioLonja[] findBylonjaIdProductoId_PrevAndNext(
			long entityId, long lonjaId, long productoId,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findBylonjaIdProductoId_PrevAndNext(
			entityId, lonjaId, productoId, orderByComparator);
	}

	/**
	 * Removes all the precio lonjas where lonjaId = &#63; and productoId = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 */
	public static void removeBylonjaIdProductoId(
		long lonjaId, long productoId) {

		getPersistence().removeBylonjaIdProductoId(lonjaId, productoId);
	}

	/**
	 * Returns the number of precio lonjas where lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @return the number of matching precio lonjas
	 */
	public static int countBylonjaIdProductoId(long lonjaId, long productoId) {
		return getPersistence().countBylonjaIdProductoId(lonjaId, productoId);
	}

	/**
	 * Returns all the precio lonjas where lonjaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @return the matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaIdFecha(
		long lonjaId, Date fecha) {

		return getPersistence().findBylonjaIdFecha(lonjaId, fecha);
	}

	/**
	 * Returns a range of all the precio lonjas where lonjaId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @return the range of matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaIdFecha(
		long lonjaId, Date fecha, int start, int end) {

		return getPersistence().findBylonjaIdFecha(lonjaId, fecha, start, end);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaIdFecha(
		long lonjaId, Date fecha, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().findBylonjaIdFecha(
			lonjaId, fecha, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaIdFecha(
		long lonjaId, Date fecha, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBylonjaIdFecha(
			lonjaId, fecha, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public static PrecioLonja findBylonjaIdFecha_First(
			long lonjaId, Date fecha,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findBylonjaIdFecha_First(
			lonjaId, fecha, orderByComparator);
	}

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public static PrecioLonja fetchBylonjaIdFecha_First(
		long lonjaId, Date fecha,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().fetchBylonjaIdFecha_First(
			lonjaId, fecha, orderByComparator);
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public static PrecioLonja findBylonjaIdFecha_Last(
			long lonjaId, Date fecha,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findBylonjaIdFecha_Last(
			lonjaId, fecha, orderByComparator);
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public static PrecioLonja fetchBylonjaIdFecha_Last(
		long lonjaId, Date fecha,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().fetchBylonjaIdFecha_Last(
			lonjaId, fecha, orderByComparator);
	}

	/**
	 * Returns the precio lonjas before and after the current precio lonja in the ordered set where lonjaId = &#63; and fecha = &#63;.
	 *
	 * @param entityId the primary key of the current precio lonja
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	public static PrecioLonja[] findBylonjaIdFecha_PrevAndNext(
			long entityId, long lonjaId, Date fecha,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findBylonjaIdFecha_PrevAndNext(
			entityId, lonjaId, fecha, orderByComparator);
	}

	/**
	 * Removes all the precio lonjas where lonjaId = &#63; and fecha = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 */
	public static void removeBylonjaIdFecha(long lonjaId, Date fecha) {
		getPersistence().removeBylonjaIdFecha(lonjaId, fecha);
	}

	/**
	 * Returns the number of precio lonjas where lonjaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @return the number of matching precio lonjas
	 */
	public static int countBylonjaIdFecha(long lonjaId, Date fecha) {
		return getPersistence().countBylonjaIdFecha(lonjaId, fecha);
	}

	/**
	 * Returns all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @return the matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaIdGrupoIdFecha(
		long lonjaId, long grupoId, Date fecha) {

		return getPersistence().findBylonjaIdGrupoIdFecha(
			lonjaId, grupoId, fecha);
	}

	/**
	 * Returns a range of all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @return the range of matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaIdGrupoIdFecha(
		long lonjaId, long grupoId, Date fecha, int start, int end) {

		return getPersistence().findBylonjaIdGrupoIdFecha(
			lonjaId, grupoId, fecha, start, end);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaIdGrupoIdFecha(
		long lonjaId, long grupoId, Date fecha, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().findBylonjaIdGrupoIdFecha(
			lonjaId, grupoId, fecha, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaIdGrupoIdFecha(
		long lonjaId, long grupoId, Date fecha, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBylonjaIdGrupoIdFecha(
			lonjaId, grupoId, fecha, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public static PrecioLonja findBylonjaIdGrupoIdFecha_First(
			long lonjaId, long grupoId, Date fecha,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findBylonjaIdGrupoIdFecha_First(
			lonjaId, grupoId, fecha, orderByComparator);
	}

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public static PrecioLonja fetchBylonjaIdGrupoIdFecha_First(
		long lonjaId, long grupoId, Date fecha,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().fetchBylonjaIdGrupoIdFecha_First(
			lonjaId, grupoId, fecha, orderByComparator);
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public static PrecioLonja findBylonjaIdGrupoIdFecha_Last(
			long lonjaId, long grupoId, Date fecha,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findBylonjaIdGrupoIdFecha_Last(
			lonjaId, grupoId, fecha, orderByComparator);
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public static PrecioLonja fetchBylonjaIdGrupoIdFecha_Last(
		long lonjaId, long grupoId, Date fecha,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().fetchBylonjaIdGrupoIdFecha_Last(
			lonjaId, grupoId, fecha, orderByComparator);
	}

	/**
	 * Returns the precio lonjas before and after the current precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * @param entityId the primary key of the current precio lonja
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	public static PrecioLonja[] findBylonjaIdGrupoIdFecha_PrevAndNext(
			long entityId, long lonjaId, long grupoId, Date fecha,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findBylonjaIdGrupoIdFecha_PrevAndNext(
			entityId, lonjaId, grupoId, fecha, orderByComparator);
	}

	/**
	 * Removes all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and fecha = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 */
	public static void removeBylonjaIdGrupoIdFecha(
		long lonjaId, long grupoId, Date fecha) {

		getPersistence().removeBylonjaIdGrupoIdFecha(lonjaId, grupoId, fecha);
	}

	/**
	 * Returns the number of precio lonjas where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @return the number of matching precio lonjas
	 */
	public static int countBylonjaIdGrupoIdFecha(
		long lonjaId, long grupoId, Date fecha) {

		return getPersistence().countBylonjaIdGrupoIdFecha(
			lonjaId, grupoId, fecha);
	}

	/**
	 * Returns all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @return the matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaIdGrupoIdSubGrupoIdFecha(
		long lonjaId, long grupoId, long subGrupoId, Date fecha) {

		return getPersistence().findBylonjaIdGrupoIdSubGrupoIdFecha(
			lonjaId, grupoId, subGrupoId, fecha);
	}

	/**
	 * Returns a range of all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @return the range of matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaIdGrupoIdSubGrupoIdFecha(
		long lonjaId, long grupoId, long subGrupoId, Date fecha, int start,
		int end) {

		return getPersistence().findBylonjaIdGrupoIdSubGrupoIdFecha(
			lonjaId, grupoId, subGrupoId, fecha, start, end);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaIdGrupoIdSubGrupoIdFecha(
		long lonjaId, long grupoId, long subGrupoId, Date fecha, int start,
		int end, OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().findBylonjaIdGrupoIdSubGrupoIdFecha(
			lonjaId, grupoId, subGrupoId, fecha, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaIdGrupoIdSubGrupoIdFecha(
		long lonjaId, long grupoId, long subGrupoId, Date fecha, int start,
		int end, OrderByComparator<PrecioLonja> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBylonjaIdGrupoIdSubGrupoIdFecha(
			lonjaId, grupoId, subGrupoId, fecha, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public static PrecioLonja findBylonjaIdGrupoIdSubGrupoIdFecha_First(
			long lonjaId, long grupoId, long subGrupoId, Date fecha,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findBylonjaIdGrupoIdSubGrupoIdFecha_First(
			lonjaId, grupoId, subGrupoId, fecha, orderByComparator);
	}

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public static PrecioLonja fetchBylonjaIdGrupoIdSubGrupoIdFecha_First(
		long lonjaId, long grupoId, long subGrupoId, Date fecha,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().fetchBylonjaIdGrupoIdSubGrupoIdFecha_First(
			lonjaId, grupoId, subGrupoId, fecha, orderByComparator);
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public static PrecioLonja findBylonjaIdGrupoIdSubGrupoIdFecha_Last(
			long lonjaId, long grupoId, long subGrupoId, Date fecha,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findBylonjaIdGrupoIdSubGrupoIdFecha_Last(
			lonjaId, grupoId, subGrupoId, fecha, orderByComparator);
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public static PrecioLonja fetchBylonjaIdGrupoIdSubGrupoIdFecha_Last(
		long lonjaId, long grupoId, long subGrupoId, Date fecha,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().fetchBylonjaIdGrupoIdSubGrupoIdFecha_Last(
			lonjaId, grupoId, subGrupoId, fecha, orderByComparator);
	}

	/**
	 * Returns the precio lonjas before and after the current precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * @param entityId the primary key of the current precio lonja
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	public static PrecioLonja[] findBylonjaIdGrupoIdSubGrupoIdFecha_PrevAndNext(
			long entityId, long lonjaId, long grupoId, long subGrupoId,
			Date fecha, OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findBylonjaIdGrupoIdSubGrupoIdFecha_PrevAndNext(
			entityId, lonjaId, grupoId, subGrupoId, fecha, orderByComparator);
	}

	/**
	 * Removes all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 */
	public static void removeBylonjaIdGrupoIdSubGrupoIdFecha(
		long lonjaId, long grupoId, long subGrupoId, Date fecha) {

		getPersistence().removeBylonjaIdGrupoIdSubGrupoIdFecha(
			lonjaId, grupoId, subGrupoId, fecha);
	}

	/**
	 * Returns the number of precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @return the number of matching precio lonjas
	 */
	public static int countBylonjaIdGrupoIdSubGrupoIdFecha(
		long lonjaId, long grupoId, long subGrupoId, Date fecha) {

		return getPersistence().countBylonjaIdGrupoIdSubGrupoIdFecha(
			lonjaId, grupoId, subGrupoId, fecha);
	}

	/**
	 * Returns all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 * @return the matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
		long lonjaId, long grupoId, long subGrupoId, long areaId, Date fecha) {

		return getPersistence().findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
			lonjaId, grupoId, subGrupoId, areaId, fecha);
	}

	/**
	 * Returns a range of all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @return the range of matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
		long lonjaId, long grupoId, long subGrupoId, long areaId, Date fecha,
		int start, int end) {

		return getPersistence().findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
			lonjaId, grupoId, subGrupoId, areaId, fecha, start, end);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
		long lonjaId, long grupoId, long subGrupoId, long areaId, Date fecha,
		int start, int end, OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
			lonjaId, grupoId, subGrupoId, areaId, fecha, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching precio lonjas
	 */
	public static List<PrecioLonja> findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
		long lonjaId, long grupoId, long subGrupoId, long areaId, Date fecha,
		int start, int end, OrderByComparator<PrecioLonja> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
			lonjaId, grupoId, subGrupoId, areaId, fecha, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public static PrecioLonja findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_First(
			long lonjaId, long grupoId, long subGrupoId, long areaId,
			Date fecha, OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_First(
			lonjaId, grupoId, subGrupoId, areaId, fecha, orderByComparator);
	}

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public static PrecioLonja fetchBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_First(
		long lonjaId, long grupoId, long subGrupoId, long areaId, Date fecha,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().
			fetchBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_First(
				lonjaId, grupoId, subGrupoId, areaId, fecha, orderByComparator);
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public static PrecioLonja findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_Last(
			long lonjaId, long grupoId, long subGrupoId, long areaId,
			Date fecha, OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_Last(
			lonjaId, grupoId, subGrupoId, areaId, fecha, orderByComparator);
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public static PrecioLonja fetchBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_Last(
		long lonjaId, long grupoId, long subGrupoId, long areaId, Date fecha,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().fetchBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_Last(
			lonjaId, grupoId, subGrupoId, areaId, fecha, orderByComparator);
	}

	/**
	 * Returns the precio lonjas before and after the current precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63;.
	 *
	 * @param entityId the primary key of the current precio lonja
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	public static PrecioLonja[]
			findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_PrevAndNext(
				long entityId, long lonjaId, long grupoId, long subGrupoId,
				long areaId, Date fecha,
				OrderByComparator<PrecioLonja> orderByComparator)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().
			findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_PrevAndNext(
				entityId, lonjaId, grupoId, subGrupoId, areaId, fecha,
				orderByComparator);
	}

	/**
	 * Removes all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 */
	public static void removeBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
		long lonjaId, long grupoId, long subGrupoId, long areaId, Date fecha) {

		getPersistence().removeBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
			lonjaId, grupoId, subGrupoId, areaId, fecha);
	}

	/**
	 * Returns the number of precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 * @return the number of matching precio lonjas
	 */
	public static int countBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
		long lonjaId, long grupoId, long subGrupoId, long areaId, Date fecha) {

		return getPersistence().countBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
			lonjaId, grupoId, subGrupoId, areaId, fecha);
	}

	/**
	 * Caches the precio lonja in the entity cache if it is enabled.
	 *
	 * @param precioLonja the precio lonja
	 */
	public static void cacheResult(PrecioLonja precioLonja) {
		getPersistence().cacheResult(precioLonja);
	}

	/**
	 * Caches the precio lonjas in the entity cache if it is enabled.
	 *
	 * @param precioLonjas the precio lonjas
	 */
	public static void cacheResult(List<PrecioLonja> precioLonjas) {
		getPersistence().cacheResult(precioLonjas);
	}

	/**
	 * Creates a new precio lonja with the primary key. Does not add the precio lonja to the database.
	 *
	 * @param entityId the primary key for the new precio lonja
	 * @return the new precio lonja
	 */
	public static PrecioLonja create(long entityId) {
		return getPersistence().create(entityId);
	}

	/**
	 * Removes the precio lonja with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the precio lonja
	 * @return the precio lonja that was removed
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	public static PrecioLonja remove(long entityId)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().remove(entityId);
	}

	public static PrecioLonja updateImpl(PrecioLonja precioLonja) {
		return getPersistence().updateImpl(precioLonja);
	}

	/**
	 * Returns the precio lonja with the primary key or throws a <code>NoSuchPrecioLonjaException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the precio lonja
	 * @return the precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	public static PrecioLonja findByPrimaryKey(long entityId)
		throws avanis.lonjas.exception.NoSuchPrecioLonjaException {

		return getPersistence().findByPrimaryKey(entityId);
	}

	/**
	 * Returns the precio lonja with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the precio lonja
	 * @return the precio lonja, or <code>null</code> if a precio lonja with the primary key could not be found
	 */
	public static PrecioLonja fetchByPrimaryKey(long entityId) {
		return getPersistence().fetchByPrimaryKey(entityId);
	}

	/**
	 * Returns all the precio lonjas.
	 *
	 * @return the precio lonjas
	 */
	public static List<PrecioLonja> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the precio lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @return the range of precio lonjas
	 */
	public static List<PrecioLonja> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the precio lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of precio lonjas
	 */
	public static List<PrecioLonja> findAll(
		int start, int end, OrderByComparator<PrecioLonja> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the precio lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of precio lonjas
	 */
	public static List<PrecioLonja> findAll(
		int start, int end, OrderByComparator<PrecioLonja> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the precio lonjas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of precio lonjas.
	 *
	 * @return the number of precio lonjas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PrecioLonjaPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(PrecioLonjaPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile PrecioLonjaPersistence _persistence;

}