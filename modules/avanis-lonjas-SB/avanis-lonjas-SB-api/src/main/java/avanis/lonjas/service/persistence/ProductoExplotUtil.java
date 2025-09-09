/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence;

import avanis.lonjas.model.ProductoExplot;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the producto explot service. This utility wraps <code>avanis.lonjas.service.persistence.impl.ProductoExplotPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductoExplotPersistence
 * @generated
 */
public class ProductoExplotUtil {

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
	public static void clearCache(ProductoExplot productoExplot) {
		getPersistence().clearCache(productoExplot);
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
	public static Map<Serializable, ProductoExplot> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProductoExplot> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductoExplot> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductoExplot> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProductoExplot> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProductoExplot update(ProductoExplot productoExplot) {
		return getPersistence().update(productoExplot);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProductoExplot update(
		ProductoExplot productoExplot, ServiceContext serviceContext) {

		return getPersistence().update(productoExplot, serviceContext);
	}

	/**
	 * Returns all the producto explots where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching producto explots
	 */
	public static List<ProductoExplot> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the producto explots where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoExplotModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of producto explots
	 * @param end the upper bound of the range of producto explots (not inclusive)
	 * @return the range of matching producto explots
	 */
	public static List<ProductoExplot> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the producto explots where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoExplotModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of producto explots
	 * @param end the upper bound of the range of producto explots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producto explots
	 */
	public static List<ProductoExplot> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductoExplot> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the producto explots where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoExplotModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of producto explots
	 * @param end the upper bound of the range of producto explots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producto explots
	 */
	public static List<ProductoExplot> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductoExplot> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first producto explot in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto explot
	 * @throws NoSuchProductoExplotException if a matching producto explot could not be found
	 */
	public static ProductoExplot findByUuid_First(
			String uuid, OrderByComparator<ProductoExplot> orderByComparator)
		throws avanis.lonjas.exception.NoSuchProductoExplotException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first producto explot in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto explot, or <code>null</code> if a matching producto explot could not be found
	 */
	public static ProductoExplot fetchByUuid_First(
		String uuid, OrderByComparator<ProductoExplot> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last producto explot in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto explot
	 * @throws NoSuchProductoExplotException if a matching producto explot could not be found
	 */
	public static ProductoExplot findByUuid_Last(
			String uuid, OrderByComparator<ProductoExplot> orderByComparator)
		throws avanis.lonjas.exception.NoSuchProductoExplotException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last producto explot in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto explot, or <code>null</code> if a matching producto explot could not be found
	 */
	public static ProductoExplot fetchByUuid_Last(
		String uuid, OrderByComparator<ProductoExplot> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the producto explots before and after the current producto explot in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current producto explot
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producto explot
	 * @throws NoSuchProductoExplotException if a producto explot with the primary key could not be found
	 */
	public static ProductoExplot[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			OrderByComparator<ProductoExplot> orderByComparator)
		throws avanis.lonjas.exception.NoSuchProductoExplotException {

		return getPersistence().findByUuid_PrevAndNext(
			entityId, uuid, orderByComparator);
	}

	/**
	 * Removes all the producto explots where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of producto explots where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching producto explots
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the producto explots where explotacionId = &#63;.
	 *
	 * @param explotacionId the explotacion ID
	 * @return the matching producto explots
	 */
	public static List<ProductoExplot> findByexplotacionId(long explotacionId) {
		return getPersistence().findByexplotacionId(explotacionId);
	}

	/**
	 * Returns a range of all the producto explots where explotacionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoExplotModelImpl</code>.
	 * </p>
	 *
	 * @param explotacionId the explotacion ID
	 * @param start the lower bound of the range of producto explots
	 * @param end the upper bound of the range of producto explots (not inclusive)
	 * @return the range of matching producto explots
	 */
	public static List<ProductoExplot> findByexplotacionId(
		long explotacionId, int start, int end) {

		return getPersistence().findByexplotacionId(explotacionId, start, end);
	}

	/**
	 * Returns an ordered range of all the producto explots where explotacionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoExplotModelImpl</code>.
	 * </p>
	 *
	 * @param explotacionId the explotacion ID
	 * @param start the lower bound of the range of producto explots
	 * @param end the upper bound of the range of producto explots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producto explots
	 */
	public static List<ProductoExplot> findByexplotacionId(
		long explotacionId, int start, int end,
		OrderByComparator<ProductoExplot> orderByComparator) {

		return getPersistence().findByexplotacionId(
			explotacionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the producto explots where explotacionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoExplotModelImpl</code>.
	 * </p>
	 *
	 * @param explotacionId the explotacion ID
	 * @param start the lower bound of the range of producto explots
	 * @param end the upper bound of the range of producto explots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producto explots
	 */
	public static List<ProductoExplot> findByexplotacionId(
		long explotacionId, int start, int end,
		OrderByComparator<ProductoExplot> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByexplotacionId(
			explotacionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first producto explot in the ordered set where explotacionId = &#63;.
	 *
	 * @param explotacionId the explotacion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto explot
	 * @throws NoSuchProductoExplotException if a matching producto explot could not be found
	 */
	public static ProductoExplot findByexplotacionId_First(
			long explotacionId,
			OrderByComparator<ProductoExplot> orderByComparator)
		throws avanis.lonjas.exception.NoSuchProductoExplotException {

		return getPersistence().findByexplotacionId_First(
			explotacionId, orderByComparator);
	}

	/**
	 * Returns the first producto explot in the ordered set where explotacionId = &#63;.
	 *
	 * @param explotacionId the explotacion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto explot, or <code>null</code> if a matching producto explot could not be found
	 */
	public static ProductoExplot fetchByexplotacionId_First(
		long explotacionId,
		OrderByComparator<ProductoExplot> orderByComparator) {

		return getPersistence().fetchByexplotacionId_First(
			explotacionId, orderByComparator);
	}

	/**
	 * Returns the last producto explot in the ordered set where explotacionId = &#63;.
	 *
	 * @param explotacionId the explotacion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto explot
	 * @throws NoSuchProductoExplotException if a matching producto explot could not be found
	 */
	public static ProductoExplot findByexplotacionId_Last(
			long explotacionId,
			OrderByComparator<ProductoExplot> orderByComparator)
		throws avanis.lonjas.exception.NoSuchProductoExplotException {

		return getPersistence().findByexplotacionId_Last(
			explotacionId, orderByComparator);
	}

	/**
	 * Returns the last producto explot in the ordered set where explotacionId = &#63;.
	 *
	 * @param explotacionId the explotacion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto explot, or <code>null</code> if a matching producto explot could not be found
	 */
	public static ProductoExplot fetchByexplotacionId_Last(
		long explotacionId,
		OrderByComparator<ProductoExplot> orderByComparator) {

		return getPersistence().fetchByexplotacionId_Last(
			explotacionId, orderByComparator);
	}

	/**
	 * Returns the producto explots before and after the current producto explot in the ordered set where explotacionId = &#63;.
	 *
	 * @param entityId the primary key of the current producto explot
	 * @param explotacionId the explotacion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producto explot
	 * @throws NoSuchProductoExplotException if a producto explot with the primary key could not be found
	 */
	public static ProductoExplot[] findByexplotacionId_PrevAndNext(
			long entityId, long explotacionId,
			OrderByComparator<ProductoExplot> orderByComparator)
		throws avanis.lonjas.exception.NoSuchProductoExplotException {

		return getPersistence().findByexplotacionId_PrevAndNext(
			entityId, explotacionId, orderByComparator);
	}

	/**
	 * Removes all the producto explots where explotacionId = &#63; from the database.
	 *
	 * @param explotacionId the explotacion ID
	 */
	public static void removeByexplotacionId(long explotacionId) {
		getPersistence().removeByexplotacionId(explotacionId);
	}

	/**
	 * Returns the number of producto explots where explotacionId = &#63;.
	 *
	 * @param explotacionId the explotacion ID
	 * @return the number of matching producto explots
	 */
	public static int countByexplotacionId(long explotacionId) {
		return getPersistence().countByexplotacionId(explotacionId);
	}

	/**
	 * Caches the producto explot in the entity cache if it is enabled.
	 *
	 * @param productoExplot the producto explot
	 */
	public static void cacheResult(ProductoExplot productoExplot) {
		getPersistence().cacheResult(productoExplot);
	}

	/**
	 * Caches the producto explots in the entity cache if it is enabled.
	 *
	 * @param productoExplots the producto explots
	 */
	public static void cacheResult(List<ProductoExplot> productoExplots) {
		getPersistence().cacheResult(productoExplots);
	}

	/**
	 * Creates a new producto explot with the primary key. Does not add the producto explot to the database.
	 *
	 * @param entityId the primary key for the new producto explot
	 * @return the new producto explot
	 */
	public static ProductoExplot create(long entityId) {
		return getPersistence().create(entityId);
	}

	/**
	 * Removes the producto explot with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the producto explot
	 * @return the producto explot that was removed
	 * @throws NoSuchProductoExplotException if a producto explot with the primary key could not be found
	 */
	public static ProductoExplot remove(long entityId)
		throws avanis.lonjas.exception.NoSuchProductoExplotException {

		return getPersistence().remove(entityId);
	}

	public static ProductoExplot updateImpl(ProductoExplot productoExplot) {
		return getPersistence().updateImpl(productoExplot);
	}

	/**
	 * Returns the producto explot with the primary key or throws a <code>NoSuchProductoExplotException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the producto explot
	 * @return the producto explot
	 * @throws NoSuchProductoExplotException if a producto explot with the primary key could not be found
	 */
	public static ProductoExplot findByPrimaryKey(long entityId)
		throws avanis.lonjas.exception.NoSuchProductoExplotException {

		return getPersistence().findByPrimaryKey(entityId);
	}

	/**
	 * Returns the producto explot with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the producto explot
	 * @return the producto explot, or <code>null</code> if a producto explot with the primary key could not be found
	 */
	public static ProductoExplot fetchByPrimaryKey(long entityId) {
		return getPersistence().fetchByPrimaryKey(entityId);
	}

	/**
	 * Returns all the producto explots.
	 *
	 * @return the producto explots
	 */
	public static List<ProductoExplot> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the producto explots.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoExplotModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of producto explots
	 * @param end the upper bound of the range of producto explots (not inclusive)
	 * @return the range of producto explots
	 */
	public static List<ProductoExplot> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the producto explots.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoExplotModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of producto explots
	 * @param end the upper bound of the range of producto explots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of producto explots
	 */
	public static List<ProductoExplot> findAll(
		int start, int end,
		OrderByComparator<ProductoExplot> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the producto explots.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoExplotModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of producto explots
	 * @param end the upper bound of the range of producto explots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of producto explots
	 */
	public static List<ProductoExplot> findAll(
		int start, int end, OrderByComparator<ProductoExplot> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the producto explots from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of producto explots.
	 *
	 * @return the number of producto explots
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProductoExplotPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ProductoExplotPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ProductoExplotPersistence _persistence;

}