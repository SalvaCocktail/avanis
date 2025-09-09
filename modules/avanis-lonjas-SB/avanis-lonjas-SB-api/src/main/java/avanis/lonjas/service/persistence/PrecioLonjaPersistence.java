/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence;

import avanis.lonjas.exception.NoSuchPrecioLonjaException;
import avanis.lonjas.model.PrecioLonja;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the precio lonja service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PrecioLonjaUtil
 * @generated
 */
@ProviderType
public interface PrecioLonjaPersistence extends BasePersistence<PrecioLonja> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PrecioLonjaUtil} to access the precio lonja persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the precio lonjas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching precio lonjas
	 */
	public java.util.List<PrecioLonja> findByUuid(String uuid);

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
	public java.util.List<PrecioLonja> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<PrecioLonja> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

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
	public java.util.List<PrecioLonja> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first precio lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public PrecioLonja findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

	/**
	 * Returns the first precio lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public PrecioLonja fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

	/**
	 * Returns the last precio lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public PrecioLonja findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

	/**
	 * Returns the last precio lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public PrecioLonja fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

	/**
	 * Returns the precio lonjas before and after the current precio lonja in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current precio lonja
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	public PrecioLonja[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

	/**
	 * Removes all the precio lonjas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of precio lonjas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching precio lonjas
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the precio lonjas where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @return the matching precio lonjas
	 */
	public java.util.List<PrecioLonja> findBylonjaId(long lonjaId);

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
	public java.util.List<PrecioLonja> findBylonjaId(
		long lonjaId, int start, int end);

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
	public java.util.List<PrecioLonja> findBylonjaId(
		long lonjaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

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
	public java.util.List<PrecioLonja> findBylonjaId(
		long lonjaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public PrecioLonja findBylonjaId_First(
			long lonjaId,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public PrecioLonja fetchBylonjaId_First(
		long lonjaId,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public PrecioLonja findBylonjaId_Last(
			long lonjaId,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public PrecioLonja fetchBylonjaId_Last(
		long lonjaId,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

	/**
	 * Returns the precio lonjas before and after the current precio lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param entityId the primary key of the current precio lonja
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	public PrecioLonja[] findBylonjaId_PrevAndNext(
			long entityId, long lonjaId,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

	/**
	 * Removes all the precio lonjas where lonjaId = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 */
	public void removeBylonjaId(long lonjaId);

	/**
	 * Returns the number of precio lonjas where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @return the number of matching precio lonjas
	 */
	public int countBylonjaId(long lonjaId);

	/**
	 * Returns all the precio lonjas where productoId = &#63;.
	 *
	 * @param productoId the producto ID
	 * @return the matching precio lonjas
	 */
	public java.util.List<PrecioLonja> findByproductoId(long productoId);

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
	public java.util.List<PrecioLonja> findByproductoId(
		long productoId, int start, int end);

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
	public java.util.List<PrecioLonja> findByproductoId(
		long productoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

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
	public java.util.List<PrecioLonja> findByproductoId(
		long productoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first precio lonja in the ordered set where productoId = &#63;.
	 *
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public PrecioLonja findByproductoId_First(
			long productoId,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

	/**
	 * Returns the first precio lonja in the ordered set where productoId = &#63;.
	 *
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public PrecioLonja fetchByproductoId_First(
		long productoId,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

	/**
	 * Returns the last precio lonja in the ordered set where productoId = &#63;.
	 *
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public PrecioLonja findByproductoId_Last(
			long productoId,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

	/**
	 * Returns the last precio lonja in the ordered set where productoId = &#63;.
	 *
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public PrecioLonja fetchByproductoId_Last(
		long productoId,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

	/**
	 * Returns the precio lonjas before and after the current precio lonja in the ordered set where productoId = &#63;.
	 *
	 * @param entityId the primary key of the current precio lonja
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	public PrecioLonja[] findByproductoId_PrevAndNext(
			long entityId, long productoId,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

	/**
	 * Removes all the precio lonjas where productoId = &#63; from the database.
	 *
	 * @param productoId the producto ID
	 */
	public void removeByproductoId(long productoId);

	/**
	 * Returns the number of precio lonjas where productoId = &#63;.
	 *
	 * @param productoId the producto ID
	 * @return the number of matching precio lonjas
	 */
	public int countByproductoId(long productoId);

	/**
	 * Returns all the precio lonjas where lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @return the matching precio lonjas
	 */
	public java.util.List<PrecioLonja> findBylonjaIdProductoId(
		long lonjaId, long productoId);

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
	public java.util.List<PrecioLonja> findBylonjaIdProductoId(
		long lonjaId, long productoId, int start, int end);

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
	public java.util.List<PrecioLonja> findBylonjaIdProductoId(
		long lonjaId, long productoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

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
	public java.util.List<PrecioLonja> findBylonjaIdProductoId(
		long lonjaId, long productoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public PrecioLonja findBylonjaIdProductoId_First(
			long lonjaId, long productoId,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public PrecioLonja fetchBylonjaIdProductoId_First(
		long lonjaId, long productoId,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public PrecioLonja findBylonjaIdProductoId_Last(
			long lonjaId, long productoId,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public PrecioLonja fetchBylonjaIdProductoId_Last(
		long lonjaId, long productoId,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

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
	public PrecioLonja[] findBylonjaIdProductoId_PrevAndNext(
			long entityId, long lonjaId, long productoId,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

	/**
	 * Removes all the precio lonjas where lonjaId = &#63; and productoId = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 */
	public void removeBylonjaIdProductoId(long lonjaId, long productoId);

	/**
	 * Returns the number of precio lonjas where lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @return the number of matching precio lonjas
	 */
	public int countBylonjaIdProductoId(long lonjaId, long productoId);

	/**
	 * Returns all the precio lonjas where lonjaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @return the matching precio lonjas
	 */
	public java.util.List<PrecioLonja> findBylonjaIdFecha(
		long lonjaId, Date fecha);

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
	public java.util.List<PrecioLonja> findBylonjaIdFecha(
		long lonjaId, Date fecha, int start, int end);

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
	public java.util.List<PrecioLonja> findBylonjaIdFecha(
		long lonjaId, Date fecha, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

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
	public java.util.List<PrecioLonja> findBylonjaIdFecha(
		long lonjaId, Date fecha, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public PrecioLonja findBylonjaIdFecha_First(
			long lonjaId, Date fecha,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public PrecioLonja fetchBylonjaIdFecha_First(
		long lonjaId, Date fecha,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	public PrecioLonja findBylonjaIdFecha_Last(
			long lonjaId, Date fecha,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public PrecioLonja fetchBylonjaIdFecha_Last(
		long lonjaId, Date fecha,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

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
	public PrecioLonja[] findBylonjaIdFecha_PrevAndNext(
			long entityId, long lonjaId, Date fecha,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

	/**
	 * Removes all the precio lonjas where lonjaId = &#63; and fecha = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 */
	public void removeBylonjaIdFecha(long lonjaId, Date fecha);

	/**
	 * Returns the number of precio lonjas where lonjaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @return the number of matching precio lonjas
	 */
	public int countBylonjaIdFecha(long lonjaId, Date fecha);

	/**
	 * Returns all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @return the matching precio lonjas
	 */
	public java.util.List<PrecioLonja> findBylonjaIdGrupoIdFecha(
		long lonjaId, long grupoId, Date fecha);

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
	public java.util.List<PrecioLonja> findBylonjaIdGrupoIdFecha(
		long lonjaId, long grupoId, Date fecha, int start, int end);

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
	public java.util.List<PrecioLonja> findBylonjaIdGrupoIdFecha(
		long lonjaId, long grupoId, Date fecha, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

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
	public java.util.List<PrecioLonja> findBylonjaIdGrupoIdFecha(
		long lonjaId, long grupoId, Date fecha, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator,
		boolean useFinderCache);

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
	public PrecioLonja findBylonjaIdGrupoIdFecha_First(
			long lonjaId, long grupoId, Date fecha,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public PrecioLonja fetchBylonjaIdGrupoIdFecha_First(
		long lonjaId, long grupoId, Date fecha,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

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
	public PrecioLonja findBylonjaIdGrupoIdFecha_Last(
			long lonjaId, long grupoId, Date fecha,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	public PrecioLonja fetchBylonjaIdGrupoIdFecha_Last(
		long lonjaId, long grupoId, Date fecha,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

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
	public PrecioLonja[] findBylonjaIdGrupoIdFecha_PrevAndNext(
			long entityId, long lonjaId, long grupoId, Date fecha,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

	/**
	 * Removes all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and fecha = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 */
	public void removeBylonjaIdGrupoIdFecha(
		long lonjaId, long grupoId, Date fecha);

	/**
	 * Returns the number of precio lonjas where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @return the number of matching precio lonjas
	 */
	public int countBylonjaIdGrupoIdFecha(
		long lonjaId, long grupoId, Date fecha);

	/**
	 * Returns all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @return the matching precio lonjas
	 */
	public java.util.List<PrecioLonja> findBylonjaIdGrupoIdSubGrupoIdFecha(
		long lonjaId, long grupoId, long subGrupoId, Date fecha);

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
	public java.util.List<PrecioLonja> findBylonjaIdGrupoIdSubGrupoIdFecha(
		long lonjaId, long grupoId, long subGrupoId, Date fecha, int start,
		int end);

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
	public java.util.List<PrecioLonja> findBylonjaIdGrupoIdSubGrupoIdFecha(
		long lonjaId, long grupoId, long subGrupoId, Date fecha, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

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
	public java.util.List<PrecioLonja> findBylonjaIdGrupoIdSubGrupoIdFecha(
		long lonjaId, long grupoId, long subGrupoId, Date fecha, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator,
		boolean useFinderCache);

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
	public PrecioLonja findBylonjaIdGrupoIdSubGrupoIdFecha_First(
			long lonjaId, long grupoId, long subGrupoId, Date fecha,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

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
	public PrecioLonja fetchBylonjaIdGrupoIdSubGrupoIdFecha_First(
		long lonjaId, long grupoId, long subGrupoId, Date fecha,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

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
	public PrecioLonja findBylonjaIdGrupoIdSubGrupoIdFecha_Last(
			long lonjaId, long grupoId, long subGrupoId, Date fecha,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

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
	public PrecioLonja fetchBylonjaIdGrupoIdSubGrupoIdFecha_Last(
		long lonjaId, long grupoId, long subGrupoId, Date fecha,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

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
	public PrecioLonja[] findBylonjaIdGrupoIdSubGrupoIdFecha_PrevAndNext(
			long entityId, long lonjaId, long grupoId, long subGrupoId,
			Date fecha,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

	/**
	 * Removes all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 */
	public void removeBylonjaIdGrupoIdSubGrupoIdFecha(
		long lonjaId, long grupoId, long subGrupoId, Date fecha);

	/**
	 * Returns the number of precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @return the number of matching precio lonjas
	 */
	public int countBylonjaIdGrupoIdSubGrupoIdFecha(
		long lonjaId, long grupoId, long subGrupoId, Date fecha);

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
	public java.util.List<PrecioLonja>
		findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
			long lonjaId, long grupoId, long subGrupoId, long areaId,
			Date fecha);

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
	public java.util.List<PrecioLonja>
		findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
			long lonjaId, long grupoId, long subGrupoId, long areaId,
			Date fecha, int start, int end);

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
	public java.util.List<PrecioLonja>
		findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
			long lonjaId, long grupoId, long subGrupoId, long areaId,
			Date fecha, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator);

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
	public java.util.List<PrecioLonja>
		findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
			long lonjaId, long grupoId, long subGrupoId, long areaId,
			Date fecha, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator,
			boolean useFinderCache);

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
	public PrecioLonja findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_First(
			long lonjaId, long grupoId, long subGrupoId, long areaId,
			Date fecha,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

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
	public PrecioLonja fetchBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_First(
		long lonjaId, long grupoId, long subGrupoId, long areaId, Date fecha,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

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
	public PrecioLonja findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_Last(
			long lonjaId, long grupoId, long subGrupoId, long areaId,
			Date fecha,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

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
	public PrecioLonja fetchBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_Last(
		long lonjaId, long grupoId, long subGrupoId, long areaId, Date fecha,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

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
	public PrecioLonja[] findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_PrevAndNext(
			long entityId, long lonjaId, long grupoId, long subGrupoId,
			long areaId, Date fecha,
			com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
				orderByComparator)
		throws NoSuchPrecioLonjaException;

	/**
	 * Removes all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 */
	public void removeBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
		long lonjaId, long grupoId, long subGrupoId, long areaId, Date fecha);

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
	public int countBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
		long lonjaId, long grupoId, long subGrupoId, long areaId, Date fecha);

	/**
	 * Caches the precio lonja in the entity cache if it is enabled.
	 *
	 * @param precioLonja the precio lonja
	 */
	public void cacheResult(PrecioLonja precioLonja);

	/**
	 * Caches the precio lonjas in the entity cache if it is enabled.
	 *
	 * @param precioLonjas the precio lonjas
	 */
	public void cacheResult(java.util.List<PrecioLonja> precioLonjas);

	/**
	 * Creates a new precio lonja with the primary key. Does not add the precio lonja to the database.
	 *
	 * @param entityId the primary key for the new precio lonja
	 * @return the new precio lonja
	 */
	public PrecioLonja create(long entityId);

	/**
	 * Removes the precio lonja with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the precio lonja
	 * @return the precio lonja that was removed
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	public PrecioLonja remove(long entityId) throws NoSuchPrecioLonjaException;

	public PrecioLonja updateImpl(PrecioLonja precioLonja);

	/**
	 * Returns the precio lonja with the primary key or throws a <code>NoSuchPrecioLonjaException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the precio lonja
	 * @return the precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	public PrecioLonja findByPrimaryKey(long entityId)
		throws NoSuchPrecioLonjaException;

	/**
	 * Returns the precio lonja with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the precio lonja
	 * @return the precio lonja, or <code>null</code> if a precio lonja with the primary key could not be found
	 */
	public PrecioLonja fetchByPrimaryKey(long entityId);

	/**
	 * Returns all the precio lonjas.
	 *
	 * @return the precio lonjas
	 */
	public java.util.List<PrecioLonja> findAll();

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
	public java.util.List<PrecioLonja> findAll(int start, int end);

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
	public java.util.List<PrecioLonja> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator);

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
	public java.util.List<PrecioLonja> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PrecioLonja>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the precio lonjas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of precio lonjas.
	 *
	 * @return the number of precio lonjas
	 */
	public int countAll();

}