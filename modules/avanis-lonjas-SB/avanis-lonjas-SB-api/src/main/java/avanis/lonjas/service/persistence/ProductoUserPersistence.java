/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence;

import avanis.lonjas.exception.NoSuchProductoUserException;
import avanis.lonjas.model.ProductoUser;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the producto user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductoUserUtil
 * @generated
 */
@ProviderType
public interface ProductoUserPersistence extends BasePersistence<ProductoUser> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductoUserUtil} to access the producto user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the producto users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching producto users
	 */
	public java.util.List<ProductoUser> findByUuid(String uuid);

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
	public java.util.List<ProductoUser> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ProductoUser> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductoUser>
			orderByComparator);

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
	public java.util.List<ProductoUser> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductoUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first producto user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto user
	 * @throws NoSuchProductoUserException if a matching producto user could not be found
	 */
	public ProductoUser findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductoUser>
				orderByComparator)
		throws NoSuchProductoUserException;

	/**
	 * Returns the first producto user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto user, or <code>null</code> if a matching producto user could not be found
	 */
	public ProductoUser fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductoUser>
			orderByComparator);

	/**
	 * Returns the last producto user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto user
	 * @throws NoSuchProductoUserException if a matching producto user could not be found
	 */
	public ProductoUser findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductoUser>
				orderByComparator)
		throws NoSuchProductoUserException;

	/**
	 * Returns the last producto user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto user, or <code>null</code> if a matching producto user could not be found
	 */
	public ProductoUser fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductoUser>
			orderByComparator);

	/**
	 * Returns the producto users before and after the current producto user in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current producto user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producto user
	 * @throws NoSuchProductoUserException if a producto user with the primary key could not be found
	 */
	public ProductoUser[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductoUser>
				orderByComparator)
		throws NoSuchProductoUserException;

	/**
	 * Removes all the producto users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of producto users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching producto users
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the producto users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching producto users
	 */
	public java.util.List<ProductoUser> findByuserId(long userId);

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
	public java.util.List<ProductoUser> findByuserId(
		long userId, int start, int end);

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
	public java.util.List<ProductoUser> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductoUser>
			orderByComparator);

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
	public java.util.List<ProductoUser> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductoUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first producto user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto user
	 * @throws NoSuchProductoUserException if a matching producto user could not be found
	 */
	public ProductoUser findByuserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductoUser>
				orderByComparator)
		throws NoSuchProductoUserException;

	/**
	 * Returns the first producto user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto user, or <code>null</code> if a matching producto user could not be found
	 */
	public ProductoUser fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductoUser>
			orderByComparator);

	/**
	 * Returns the last producto user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto user
	 * @throws NoSuchProductoUserException if a matching producto user could not be found
	 */
	public ProductoUser findByuserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductoUser>
				orderByComparator)
		throws NoSuchProductoUserException;

	/**
	 * Returns the last producto user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto user, or <code>null</code> if a matching producto user could not be found
	 */
	public ProductoUser fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductoUser>
			orderByComparator);

	/**
	 * Returns the producto users before and after the current producto user in the ordered set where userId = &#63;.
	 *
	 * @param entityId the primary key of the current producto user
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producto user
	 * @throws NoSuchProductoUserException if a producto user with the primary key could not be found
	 */
	public ProductoUser[] findByuserId_PrevAndNext(
			long entityId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductoUser>
				orderByComparator)
		throws NoSuchProductoUserException;

	/**
	 * Removes all the producto users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByuserId(long userId);

	/**
	 * Returns the number of producto users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching producto users
	 */
	public int countByuserId(long userId);

	/**
	 * Returns the producto user where userId = &#63; and lonjaId = &#63; and productoId = &#63; or throws a <code>NoSuchProductoUserException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @return the matching producto user
	 * @throws NoSuchProductoUserException if a matching producto user could not be found
	 */
	public ProductoUser findByuserIdlonjaIdproductoId(
			long userId, long lonjaId, long productoId)
		throws NoSuchProductoUserException;

	/**
	 * Returns the producto user where userId = &#63; and lonjaId = &#63; and productoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @return the matching producto user, or <code>null</code> if a matching producto user could not be found
	 */
	public ProductoUser fetchByuserIdlonjaIdproductoId(
		long userId, long lonjaId, long productoId);

	/**
	 * Returns the producto user where userId = &#63; and lonjaId = &#63; and productoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching producto user, or <code>null</code> if a matching producto user could not be found
	 */
	public ProductoUser fetchByuserIdlonjaIdproductoId(
		long userId, long lonjaId, long productoId, boolean useFinderCache);

	/**
	 * Removes the producto user where userId = &#63; and lonjaId = &#63; and productoId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @return the producto user that was removed
	 */
	public ProductoUser removeByuserIdlonjaIdproductoId(
			long userId, long lonjaId, long productoId)
		throws NoSuchProductoUserException;

	/**
	 * Returns the number of producto users where userId = &#63; and lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param userId the user ID
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @return the number of matching producto users
	 */
	public int countByuserIdlonjaIdproductoId(
		long userId, long lonjaId, long productoId);

	/**
	 * Caches the producto user in the entity cache if it is enabled.
	 *
	 * @param productoUser the producto user
	 */
	public void cacheResult(ProductoUser productoUser);

	/**
	 * Caches the producto users in the entity cache if it is enabled.
	 *
	 * @param productoUsers the producto users
	 */
	public void cacheResult(java.util.List<ProductoUser> productoUsers);

	/**
	 * Creates a new producto user with the primary key. Does not add the producto user to the database.
	 *
	 * @param entityId the primary key for the new producto user
	 * @return the new producto user
	 */
	public ProductoUser create(long entityId);

	/**
	 * Removes the producto user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the producto user
	 * @return the producto user that was removed
	 * @throws NoSuchProductoUserException if a producto user with the primary key could not be found
	 */
	public ProductoUser remove(long entityId)
		throws NoSuchProductoUserException;

	public ProductoUser updateImpl(ProductoUser productoUser);

	/**
	 * Returns the producto user with the primary key or throws a <code>NoSuchProductoUserException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the producto user
	 * @return the producto user
	 * @throws NoSuchProductoUserException if a producto user with the primary key could not be found
	 */
	public ProductoUser findByPrimaryKey(long entityId)
		throws NoSuchProductoUserException;

	/**
	 * Returns the producto user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the producto user
	 * @return the producto user, or <code>null</code> if a producto user with the primary key could not be found
	 */
	public ProductoUser fetchByPrimaryKey(long entityId);

	/**
	 * Returns all the producto users.
	 *
	 * @return the producto users
	 */
	public java.util.List<ProductoUser> findAll();

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
	public java.util.List<ProductoUser> findAll(int start, int end);

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
	public java.util.List<ProductoUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductoUser>
			orderByComparator);

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
	public java.util.List<ProductoUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductoUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the producto users from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of producto users.
	 *
	 * @return the number of producto users
	 */
	public int countAll();

}