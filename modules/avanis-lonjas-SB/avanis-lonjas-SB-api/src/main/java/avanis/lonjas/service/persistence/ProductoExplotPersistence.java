/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence;

import avanis.lonjas.exception.NoSuchProductoExplotException;
import avanis.lonjas.model.ProductoExplot;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the producto explot service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductoExplotUtil
 * @generated
 */
@ProviderType
public interface ProductoExplotPersistence
	extends BasePersistence<ProductoExplot> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductoExplotUtil} to access the producto explot persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the producto explots where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching producto explots
	 */
	public java.util.List<ProductoExplot> findByUuid(String uuid);

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
	public java.util.List<ProductoExplot> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ProductoExplot> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductoExplot>
			orderByComparator);

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
	public java.util.List<ProductoExplot> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductoExplot>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first producto explot in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto explot
	 * @throws NoSuchProductoExplotException if a matching producto explot could not be found
	 */
	public ProductoExplot findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductoExplot>
				orderByComparator)
		throws NoSuchProductoExplotException;

	/**
	 * Returns the first producto explot in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto explot, or <code>null</code> if a matching producto explot could not be found
	 */
	public ProductoExplot fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductoExplot>
			orderByComparator);

	/**
	 * Returns the last producto explot in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto explot
	 * @throws NoSuchProductoExplotException if a matching producto explot could not be found
	 */
	public ProductoExplot findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductoExplot>
				orderByComparator)
		throws NoSuchProductoExplotException;

	/**
	 * Returns the last producto explot in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto explot, or <code>null</code> if a matching producto explot could not be found
	 */
	public ProductoExplot fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProductoExplot>
			orderByComparator);

	/**
	 * Returns the producto explots before and after the current producto explot in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current producto explot
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producto explot
	 * @throws NoSuchProductoExplotException if a producto explot with the primary key could not be found
	 */
	public ProductoExplot[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProductoExplot>
				orderByComparator)
		throws NoSuchProductoExplotException;

	/**
	 * Removes all the producto explots where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of producto explots where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching producto explots
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the producto explots where explotacionId = &#63;.
	 *
	 * @param explotacionId the explotacion ID
	 * @return the matching producto explots
	 */
	public java.util.List<ProductoExplot> findByexplotacionId(
		long explotacionId);

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
	public java.util.List<ProductoExplot> findByexplotacionId(
		long explotacionId, int start, int end);

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
	public java.util.List<ProductoExplot> findByexplotacionId(
		long explotacionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductoExplot>
			orderByComparator);

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
	public java.util.List<ProductoExplot> findByexplotacionId(
		long explotacionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductoExplot>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first producto explot in the ordered set where explotacionId = &#63;.
	 *
	 * @param explotacionId the explotacion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto explot
	 * @throws NoSuchProductoExplotException if a matching producto explot could not be found
	 */
	public ProductoExplot findByexplotacionId_First(
			long explotacionId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductoExplot>
				orderByComparator)
		throws NoSuchProductoExplotException;

	/**
	 * Returns the first producto explot in the ordered set where explotacionId = &#63;.
	 *
	 * @param explotacionId the explotacion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto explot, or <code>null</code> if a matching producto explot could not be found
	 */
	public ProductoExplot fetchByexplotacionId_First(
		long explotacionId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductoExplot>
			orderByComparator);

	/**
	 * Returns the last producto explot in the ordered set where explotacionId = &#63;.
	 *
	 * @param explotacionId the explotacion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto explot
	 * @throws NoSuchProductoExplotException if a matching producto explot could not be found
	 */
	public ProductoExplot findByexplotacionId_Last(
			long explotacionId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductoExplot>
				orderByComparator)
		throws NoSuchProductoExplotException;

	/**
	 * Returns the last producto explot in the ordered set where explotacionId = &#63;.
	 *
	 * @param explotacionId the explotacion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto explot, or <code>null</code> if a matching producto explot could not be found
	 */
	public ProductoExplot fetchByexplotacionId_Last(
		long explotacionId,
		com.liferay.portal.kernel.util.OrderByComparator<ProductoExplot>
			orderByComparator);

	/**
	 * Returns the producto explots before and after the current producto explot in the ordered set where explotacionId = &#63;.
	 *
	 * @param entityId the primary key of the current producto explot
	 * @param explotacionId the explotacion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producto explot
	 * @throws NoSuchProductoExplotException if a producto explot with the primary key could not be found
	 */
	public ProductoExplot[] findByexplotacionId_PrevAndNext(
			long entityId, long explotacionId,
			com.liferay.portal.kernel.util.OrderByComparator<ProductoExplot>
				orderByComparator)
		throws NoSuchProductoExplotException;

	/**
	 * Removes all the producto explots where explotacionId = &#63; from the database.
	 *
	 * @param explotacionId the explotacion ID
	 */
	public void removeByexplotacionId(long explotacionId);

	/**
	 * Returns the number of producto explots where explotacionId = &#63;.
	 *
	 * @param explotacionId the explotacion ID
	 * @return the number of matching producto explots
	 */
	public int countByexplotacionId(long explotacionId);

	/**
	 * Caches the producto explot in the entity cache if it is enabled.
	 *
	 * @param productoExplot the producto explot
	 */
	public void cacheResult(ProductoExplot productoExplot);

	/**
	 * Caches the producto explots in the entity cache if it is enabled.
	 *
	 * @param productoExplots the producto explots
	 */
	public void cacheResult(java.util.List<ProductoExplot> productoExplots);

	/**
	 * Creates a new producto explot with the primary key. Does not add the producto explot to the database.
	 *
	 * @param entityId the primary key for the new producto explot
	 * @return the new producto explot
	 */
	public ProductoExplot create(long entityId);

	/**
	 * Removes the producto explot with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the producto explot
	 * @return the producto explot that was removed
	 * @throws NoSuchProductoExplotException if a producto explot with the primary key could not be found
	 */
	public ProductoExplot remove(long entityId)
		throws NoSuchProductoExplotException;

	public ProductoExplot updateImpl(ProductoExplot productoExplot);

	/**
	 * Returns the producto explot with the primary key or throws a <code>NoSuchProductoExplotException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the producto explot
	 * @return the producto explot
	 * @throws NoSuchProductoExplotException if a producto explot with the primary key could not be found
	 */
	public ProductoExplot findByPrimaryKey(long entityId)
		throws NoSuchProductoExplotException;

	/**
	 * Returns the producto explot with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the producto explot
	 * @return the producto explot, or <code>null</code> if a producto explot with the primary key could not be found
	 */
	public ProductoExplot fetchByPrimaryKey(long entityId);

	/**
	 * Returns all the producto explots.
	 *
	 * @return the producto explots
	 */
	public java.util.List<ProductoExplot> findAll();

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
	public java.util.List<ProductoExplot> findAll(int start, int end);

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
	public java.util.List<ProductoExplot> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductoExplot>
			orderByComparator);

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
	public java.util.List<ProductoExplot> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductoExplot>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the producto explots from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of producto explots.
	 *
	 * @return the number of producto explots
	 */
	public int countAll();

}