/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence;

import avanis.lonjas.exception.NoSuchFechaLonjaException;
import avanis.lonjas.model.FechaLonja;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the fecha lonja service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FechaLonjaUtil
 * @generated
 */
@ProviderType
public interface FechaLonjaPersistence extends BasePersistence<FechaLonja> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FechaLonjaUtil} to access the fecha lonja persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the fecha lonjas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fecha lonjas
	 */
	public java.util.List<FechaLonja> findByUuid(String uuid);

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
	public java.util.List<FechaLonja> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<FechaLonja> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FechaLonja>
			orderByComparator);

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
	public java.util.List<FechaLonja> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FechaLonja>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first fecha lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fecha lonja
	 * @throws NoSuchFechaLonjaException if a matching fecha lonja could not be found
	 */
	public FechaLonja findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FechaLonja>
				orderByComparator)
		throws NoSuchFechaLonjaException;

	/**
	 * Returns the first fecha lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fecha lonja, or <code>null</code> if a matching fecha lonja could not be found
	 */
	public FechaLonja fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FechaLonja>
			orderByComparator);

	/**
	 * Returns the last fecha lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fecha lonja
	 * @throws NoSuchFechaLonjaException if a matching fecha lonja could not be found
	 */
	public FechaLonja findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FechaLonja>
				orderByComparator)
		throws NoSuchFechaLonjaException;

	/**
	 * Returns the last fecha lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fecha lonja, or <code>null</code> if a matching fecha lonja could not be found
	 */
	public FechaLonja fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<FechaLonja>
			orderByComparator);

	/**
	 * Returns the fecha lonjas before and after the current fecha lonja in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current fecha lonja
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fecha lonja
	 * @throws NoSuchFechaLonjaException if a fecha lonja with the primary key could not be found
	 */
	public FechaLonja[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<FechaLonja>
				orderByComparator)
		throws NoSuchFechaLonjaException;

	/**
	 * Removes all the fecha lonjas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of fecha lonjas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fecha lonjas
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the fecha lonjas where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @return the matching fecha lonjas
	 */
	public java.util.List<FechaLonja> findBylonjaId(long lonjaId);

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
	public java.util.List<FechaLonja> findBylonjaId(
		long lonjaId, int start, int end);

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
	public java.util.List<FechaLonja> findBylonjaId(
		long lonjaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FechaLonja>
			orderByComparator);

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
	public java.util.List<FechaLonja> findBylonjaId(
		long lonjaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FechaLonja>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first fecha lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fecha lonja
	 * @throws NoSuchFechaLonjaException if a matching fecha lonja could not be found
	 */
	public FechaLonja findBylonjaId_First(
			long lonjaId,
			com.liferay.portal.kernel.util.OrderByComparator<FechaLonja>
				orderByComparator)
		throws NoSuchFechaLonjaException;

	/**
	 * Returns the first fecha lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fecha lonja, or <code>null</code> if a matching fecha lonja could not be found
	 */
	public FechaLonja fetchBylonjaId_First(
		long lonjaId,
		com.liferay.portal.kernel.util.OrderByComparator<FechaLonja>
			orderByComparator);

	/**
	 * Returns the last fecha lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fecha lonja
	 * @throws NoSuchFechaLonjaException if a matching fecha lonja could not be found
	 */
	public FechaLonja findBylonjaId_Last(
			long lonjaId,
			com.liferay.portal.kernel.util.OrderByComparator<FechaLonja>
				orderByComparator)
		throws NoSuchFechaLonjaException;

	/**
	 * Returns the last fecha lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fecha lonja, or <code>null</code> if a matching fecha lonja could not be found
	 */
	public FechaLonja fetchBylonjaId_Last(
		long lonjaId,
		com.liferay.portal.kernel.util.OrderByComparator<FechaLonja>
			orderByComparator);

	/**
	 * Returns the fecha lonjas before and after the current fecha lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param entityId the primary key of the current fecha lonja
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fecha lonja
	 * @throws NoSuchFechaLonjaException if a fecha lonja with the primary key could not be found
	 */
	public FechaLonja[] findBylonjaId_PrevAndNext(
			long entityId, long lonjaId,
			com.liferay.portal.kernel.util.OrderByComparator<FechaLonja>
				orderByComparator)
		throws NoSuchFechaLonjaException;

	/**
	 * Removes all the fecha lonjas where lonjaId = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 */
	public void removeBylonjaId(long lonjaId);

	/**
	 * Returns the number of fecha lonjas where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @return the number of matching fecha lonjas
	 */
	public int countBylonjaId(long lonjaId);

	/**
	 * Caches the fecha lonja in the entity cache if it is enabled.
	 *
	 * @param fechaLonja the fecha lonja
	 */
	public void cacheResult(FechaLonja fechaLonja);

	/**
	 * Caches the fecha lonjas in the entity cache if it is enabled.
	 *
	 * @param fechaLonjas the fecha lonjas
	 */
	public void cacheResult(java.util.List<FechaLonja> fechaLonjas);

	/**
	 * Creates a new fecha lonja with the primary key. Does not add the fecha lonja to the database.
	 *
	 * @param entityId the primary key for the new fecha lonja
	 * @return the new fecha lonja
	 */
	public FechaLonja create(long entityId);

	/**
	 * Removes the fecha lonja with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the fecha lonja
	 * @return the fecha lonja that was removed
	 * @throws NoSuchFechaLonjaException if a fecha lonja with the primary key could not be found
	 */
	public FechaLonja remove(long entityId) throws NoSuchFechaLonjaException;

	public FechaLonja updateImpl(FechaLonja fechaLonja);

	/**
	 * Returns the fecha lonja with the primary key or throws a <code>NoSuchFechaLonjaException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the fecha lonja
	 * @return the fecha lonja
	 * @throws NoSuchFechaLonjaException if a fecha lonja with the primary key could not be found
	 */
	public FechaLonja findByPrimaryKey(long entityId)
		throws NoSuchFechaLonjaException;

	/**
	 * Returns the fecha lonja with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the fecha lonja
	 * @return the fecha lonja, or <code>null</code> if a fecha lonja with the primary key could not be found
	 */
	public FechaLonja fetchByPrimaryKey(long entityId);

	/**
	 * Returns all the fecha lonjas.
	 *
	 * @return the fecha lonjas
	 */
	public java.util.List<FechaLonja> findAll();

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
	public java.util.List<FechaLonja> findAll(int start, int end);

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
	public java.util.List<FechaLonja> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FechaLonja>
			orderByComparator);

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
	public java.util.List<FechaLonja> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FechaLonja>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the fecha lonjas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of fecha lonjas.
	 *
	 * @return the number of fecha lonjas
	 */
	public int countAll();

}