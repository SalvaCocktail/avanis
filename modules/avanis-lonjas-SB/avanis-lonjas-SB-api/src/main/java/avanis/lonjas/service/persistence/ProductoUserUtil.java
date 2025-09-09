/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence;

import avanis.lonjas.model.ProductoUser;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the producto user service. This utility wraps <code>avanis.lonjas.service.persistence.impl.ProductoUserPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductoUserPersistence
 * @generated
 */
public class ProductoUserUtil {

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
	public static void clearCache(ProductoUser productoUser) {
		getPersistence().clearCache(productoUser);
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
	public static Map<Serializable, ProductoUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProductoUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductoUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductoUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProductoUser> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProductoUser update(ProductoUser productoUser) {
		return getPersistence().update(productoUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProductoUser update(
		ProductoUser productoUser, ServiceContext serviceContext) {

		return getPersistence().update(productoUser, serviceContext);
	}

	/**
	 * Returns all the producto users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching producto users
	 */
	public static List<ProductoUser> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the producto users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of producto users
	 * @param end the upper bound of the range of producto users (not inclusive)
	 * @return the range of matching producto users
	 */
	public static List<ProductoUser> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the producto users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of producto users
	 * @param end the upper bound of the range of producto users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producto users
	 */
	public static List<ProductoUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductoUser> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the producto users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of producto users
	 * @param end the upper bound of the range of producto users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producto users
	 */
	public static List<ProductoUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductoUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first producto user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto user
	 * @throws NoSuchProductoUserException if a matching producto user could not be found
	 */
	public static ProductoUser findByUuid_First(
			String uuid, OrderByComparator<ProductoUser> orderByComparator)
		throws avanis.lonjas.exception.NoSuchProductoUserException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first producto user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto user, or <code>null</code> if a matching producto user could not be found
	 */
	public static ProductoUser fetchByUuid_First(
		String uuid, OrderByComparator<ProductoUser> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last producto user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto user
	 * @throws NoSuchProductoUserException if a matching producto user could not be found
	 */
	public static ProductoUser findByUuid_Last(
			String uuid, OrderByComparator<ProductoUser> orderByComparator)
		throws avanis.lonjas.exception.NoSuchProductoUserException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last producto user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto user, or <code>null</code> if a matching producto user could not be found
	 */
	public static ProductoUser fetchByUuid_Last(
		String uuid, OrderByComparator<ProductoUser> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the producto users before and after the current producto user in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current producto user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producto user
	 * @throws NoSuchProductoUserException if a producto user with the primary key could not be found
	 */
	public static ProductoUser[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			OrderByComparator<ProductoUser> orderByComparator)
		throws avanis.lonjas.exception.NoSuchProductoUserException {

		return getPersistence().findByUuid_PrevAndNext(
			entityId, uuid, orderByComparator);
	}

	/**
	 * Removes all the producto users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of producto users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching producto users
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the producto users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching producto users
	 */
	public static List<ProductoUser> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

	/**
	 * Returns a range of all the producto users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of producto users
	 * @param end the upper bound of the range of producto users (not inclusive)
	 * @return the range of matching producto users
	 */
	public static List<ProductoUser> findByuserId(
		long userId, int start, int end) {

		return getPersistence().findByuserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the producto users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of producto users
	 * @param end the upper bound of the range of producto users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producto users
	 */
	public static List<ProductoUser> findByuserId(
		long userId, int start, int end,
		OrderByComparator<ProductoUser> orderByComparator) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the producto users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of producto users
	 * @param end the upper bound of the range of producto users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producto users
	 */
	public static List<ProductoUser> findByuserId(
		long userId, int start, int end,
		OrderByComparator<ProductoUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first producto user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto user
	 * @throws NoSuchProductoUserException if a matching producto user could not be found
	 */
	public static ProductoUser findByuserId_First(
			long userId, OrderByComparator<ProductoUser> orderByComparator)
		throws avanis.lonjas.exception.NoSuchProductoUserException {

		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first producto user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto user, or <code>null</code> if a matching producto user could not be found
	 */
	public static ProductoUser fetchByuserId_First(
		long userId, OrderByComparator<ProductoUser> orderByComparator) {

		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last producto user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto user
	 * @throws NoSuchProductoUserException if a matching producto user could not be found
	 */
	public static ProductoUser findByuserId_Last(
			long userId, OrderByComparator<ProductoUser> orderByComparator)
		throws avanis.lonjas.exception.NoSuchProductoUserException {

		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last producto user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto user, or <code>null</code> if a matching producto user could not be found
	 */
	public static ProductoUser fetchByuserId_Last(
		long userId, OrderByComparator<ProductoUser> orderByComparator) {

		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the producto users before and after the current producto user in the ordered set where userId = &#63;.
	 *
	 * @param entityId the primary key of the current producto user
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producto user
	 * @throws NoSuchProductoUserException if a producto user with the primary key could not be found
	 */
	public static ProductoUser[] findByuserId_PrevAndNext(
			long entityId, long userId,
			OrderByComparator<ProductoUser> orderByComparator)
		throws avanis.lonjas.exception.NoSuchProductoUserException {

		return getPersistence().findByuserId_PrevAndNext(
			entityId, userId, orderByComparator);
	}

	/**
	 * Removes all the producto users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of producto users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching producto users
	 */
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Returns the producto user where userId = &#63; and lonjaId = &#63; and productoId = &#63; or throws a <code>NoSuchProductoUserException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @return the matching producto user
	 * @throws NoSuchProductoUserException if a matching producto user could not be found
	 */
	public static ProductoUser findByuserIdlonjaIdproductoId(
			long userId, long lonjaId, long productoId)
		throws avanis.lonjas.exception.NoSuchProductoUserException {

		return getPersistence().findByuserIdlonjaIdproductoId(
			userId, lonjaId, productoId);
	}

	/**
	 * Returns the producto user where userId = &#63; and lonjaId = &#63; and productoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @return the matching producto user, or <code>null</code> if a matching producto user could not be found
	 */
	public static ProductoUser fetchByuserIdlonjaIdproductoId(
		long userId, long lonjaId, long productoId) {

		return getPersistence().fetchByuserIdlonjaIdproductoId(
			userId, lonjaId, productoId);
	}

	/**
	 * Returns the producto user where userId = &#63; and lonjaId = &#63; and productoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching producto user, or <code>null</code> if a matching producto user could not be found
	 */
	public static ProductoUser fetchByuserIdlonjaIdproductoId(
		long userId, long lonjaId, long productoId, boolean useFinderCache) {

		return getPersistence().fetchByuserIdlonjaIdproductoId(
			userId, lonjaId, productoId, useFinderCache);
	}

	/**
	 * Removes the producto user where userId = &#63; and lonjaId = &#63; and productoId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @return the producto user that was removed
	 */
	public static ProductoUser removeByuserIdlonjaIdproductoId(
			long userId, long lonjaId, long productoId)
		throws avanis.lonjas.exception.NoSuchProductoUserException {

		return getPersistence().removeByuserIdlonjaIdproductoId(
			userId, lonjaId, productoId);
	}

	/**
	 * Returns the number of producto users where userId = &#63; and lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param userId the user ID
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @return the number of matching producto users
	 */
	public static int countByuserIdlonjaIdproductoId(
		long userId, long lonjaId, long productoId) {

		return getPersistence().countByuserIdlonjaIdproductoId(
			userId, lonjaId, productoId);
	}

	/**
	 * Caches the producto user in the entity cache if it is enabled.
	 *
	 * @param productoUser the producto user
	 */
	public static void cacheResult(ProductoUser productoUser) {
		getPersistence().cacheResult(productoUser);
	}

	/**
	 * Caches the producto users in the entity cache if it is enabled.
	 *
	 * @param productoUsers the producto users
	 */
	public static void cacheResult(List<ProductoUser> productoUsers) {
		getPersistence().cacheResult(productoUsers);
	}

	/**
	 * Creates a new producto user with the primary key. Does not add the producto user to the database.
	 *
	 * @param entityId the primary key for the new producto user
	 * @return the new producto user
	 */
	public static ProductoUser create(long entityId) {
		return getPersistence().create(entityId);
	}

	/**
	 * Removes the producto user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the producto user
	 * @return the producto user that was removed
	 * @throws NoSuchProductoUserException if a producto user with the primary key could not be found
	 */
	public static ProductoUser remove(long entityId)
		throws avanis.lonjas.exception.NoSuchProductoUserException {

		return getPersistence().remove(entityId);
	}

	public static ProductoUser updateImpl(ProductoUser productoUser) {
		return getPersistence().updateImpl(productoUser);
	}

	/**
	 * Returns the producto user with the primary key or throws a <code>NoSuchProductoUserException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the producto user
	 * @return the producto user
	 * @throws NoSuchProductoUserException if a producto user with the primary key could not be found
	 */
	public static ProductoUser findByPrimaryKey(long entityId)
		throws avanis.lonjas.exception.NoSuchProductoUserException {

		return getPersistence().findByPrimaryKey(entityId);
	}

	/**
	 * Returns the producto user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the producto user
	 * @return the producto user, or <code>null</code> if a producto user with the primary key could not be found
	 */
	public static ProductoUser fetchByPrimaryKey(long entityId) {
		return getPersistence().fetchByPrimaryKey(entityId);
	}

	/**
	 * Returns all the producto users.
	 *
	 * @return the producto users
	 */
	public static List<ProductoUser> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the producto users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of producto users
	 * @param end the upper bound of the range of producto users (not inclusive)
	 * @return the range of producto users
	 */
	public static List<ProductoUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the producto users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of producto users
	 * @param end the upper bound of the range of producto users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of producto users
	 */
	public static List<ProductoUser> findAll(
		int start, int end, OrderByComparator<ProductoUser> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the producto users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of producto users
	 * @param end the upper bound of the range of producto users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of producto users
	 */
	public static List<ProductoUser> findAll(
		int start, int end, OrderByComparator<ProductoUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the producto users from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of producto users.
	 *
	 * @return the number of producto users
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProductoUserPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ProductoUserPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ProductoUserPersistence _persistence;

}