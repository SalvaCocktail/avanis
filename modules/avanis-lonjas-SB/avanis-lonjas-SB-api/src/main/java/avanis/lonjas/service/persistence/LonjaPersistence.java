/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence;

import avanis.lonjas.exception.NoSuchLonjaException;
import avanis.lonjas.model.Lonja;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the lonja service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LonjaUtil
 * @generated
 */
@ProviderType
public interface LonjaPersistence extends BasePersistence<Lonja> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LonjaUtil} to access the lonja persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the lonjas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching lonjas
	 */
	public java.util.List<Lonja> findByUuid(String uuid);

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
	public java.util.List<Lonja> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Lonja> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lonja>
			orderByComparator);

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
	public java.util.List<Lonja> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lonja>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lonja
	 * @throws NoSuchLonjaException if a matching lonja could not be found
	 */
	public Lonja findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Lonja>
				orderByComparator)
		throws NoSuchLonjaException;

	/**
	 * Returns the first lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lonja, or <code>null</code> if a matching lonja could not be found
	 */
	public Lonja fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Lonja>
			orderByComparator);

	/**
	 * Returns the last lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lonja
	 * @throws NoSuchLonjaException if a matching lonja could not be found
	 */
	public Lonja findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Lonja>
				orderByComparator)
		throws NoSuchLonjaException;

	/**
	 * Returns the last lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lonja, or <code>null</code> if a matching lonja could not be found
	 */
	public Lonja fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Lonja>
			orderByComparator);

	/**
	 * Returns the lonjas before and after the current lonja in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current lonja
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lonja
	 * @throws NoSuchLonjaException if a lonja with the primary key could not be found
	 */
	public Lonja[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Lonja>
				orderByComparator)
		throws NoSuchLonjaException;

	/**
	 * Removes all the lonjas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of lonjas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching lonjas
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the lonjas where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @return the matching lonjas
	 */
	public java.util.List<Lonja> findBylonjaId(long lonjaId);

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
	public java.util.List<Lonja> findBylonjaId(
		long lonjaId, int start, int end);

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
	public java.util.List<Lonja> findBylonjaId(
		long lonjaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lonja>
			orderByComparator);

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
	public java.util.List<Lonja> findBylonjaId(
		long lonjaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lonja>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lonja
	 * @throws NoSuchLonjaException if a matching lonja could not be found
	 */
	public Lonja findBylonjaId_First(
			long lonjaId,
			com.liferay.portal.kernel.util.OrderByComparator<Lonja>
				orderByComparator)
		throws NoSuchLonjaException;

	/**
	 * Returns the first lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lonja, or <code>null</code> if a matching lonja could not be found
	 */
	public Lonja fetchBylonjaId_First(
		long lonjaId,
		com.liferay.portal.kernel.util.OrderByComparator<Lonja>
			orderByComparator);

	/**
	 * Returns the last lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lonja
	 * @throws NoSuchLonjaException if a matching lonja could not be found
	 */
	public Lonja findBylonjaId_Last(
			long lonjaId,
			com.liferay.portal.kernel.util.OrderByComparator<Lonja>
				orderByComparator)
		throws NoSuchLonjaException;

	/**
	 * Returns the last lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lonja, or <code>null</code> if a matching lonja could not be found
	 */
	public Lonja fetchBylonjaId_Last(
		long lonjaId,
		com.liferay.portal.kernel.util.OrderByComparator<Lonja>
			orderByComparator);

	/**
	 * Returns the lonjas before and after the current lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param entityId the primary key of the current lonja
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lonja
	 * @throws NoSuchLonjaException if a lonja with the primary key could not be found
	 */
	public Lonja[] findBylonjaId_PrevAndNext(
			long entityId, long lonjaId,
			com.liferay.portal.kernel.util.OrderByComparator<Lonja>
				orderByComparator)
		throws NoSuchLonjaException;

	/**
	 * Removes all the lonjas where lonjaId = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 */
	public void removeBylonjaId(long lonjaId);

	/**
	 * Returns the number of lonjas where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @return the number of matching lonjas
	 */
	public int countBylonjaId(long lonjaId);

	/**
	 * Returns all the lonjas where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the matching lonjas
	 */
	public java.util.List<Lonja> findBynombre(String nombre);

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
	public java.util.List<Lonja> findBynombre(
		String nombre, int start, int end);

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
	public java.util.List<Lonja> findBynombre(
		String nombre, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lonja>
			orderByComparator);

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
	public java.util.List<Lonja> findBynombre(
		String nombre, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lonja>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first lonja in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lonja
	 * @throws NoSuchLonjaException if a matching lonja could not be found
	 */
	public Lonja findBynombre_First(
			String nombre,
			com.liferay.portal.kernel.util.OrderByComparator<Lonja>
				orderByComparator)
		throws NoSuchLonjaException;

	/**
	 * Returns the first lonja in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lonja, or <code>null</code> if a matching lonja could not be found
	 */
	public Lonja fetchBynombre_First(
		String nombre,
		com.liferay.portal.kernel.util.OrderByComparator<Lonja>
			orderByComparator);

	/**
	 * Returns the last lonja in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lonja
	 * @throws NoSuchLonjaException if a matching lonja could not be found
	 */
	public Lonja findBynombre_Last(
			String nombre,
			com.liferay.portal.kernel.util.OrderByComparator<Lonja>
				orderByComparator)
		throws NoSuchLonjaException;

	/**
	 * Returns the last lonja in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lonja, or <code>null</code> if a matching lonja could not be found
	 */
	public Lonja fetchBynombre_Last(
		String nombre,
		com.liferay.portal.kernel.util.OrderByComparator<Lonja>
			orderByComparator);

	/**
	 * Returns the lonjas before and after the current lonja in the ordered set where nombre = &#63;.
	 *
	 * @param entityId the primary key of the current lonja
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lonja
	 * @throws NoSuchLonjaException if a lonja with the primary key could not be found
	 */
	public Lonja[] findBynombre_PrevAndNext(
			long entityId, String nombre,
			com.liferay.portal.kernel.util.OrderByComparator<Lonja>
				orderByComparator)
		throws NoSuchLonjaException;

	/**
	 * Removes all the lonjas where nombre = &#63; from the database.
	 *
	 * @param nombre the nombre
	 */
	public void removeBynombre(String nombre);

	/**
	 * Returns the number of lonjas where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the number of matching lonjas
	 */
	public int countBynombre(String nombre);

	/**
	 * Caches the lonja in the entity cache if it is enabled.
	 *
	 * @param lonja the lonja
	 */
	public void cacheResult(Lonja lonja);

	/**
	 * Caches the lonjas in the entity cache if it is enabled.
	 *
	 * @param lonjas the lonjas
	 */
	public void cacheResult(java.util.List<Lonja> lonjas);

	/**
	 * Creates a new lonja with the primary key. Does not add the lonja to the database.
	 *
	 * @param entityId the primary key for the new lonja
	 * @return the new lonja
	 */
	public Lonja create(long entityId);

	/**
	 * Removes the lonja with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the lonja
	 * @return the lonja that was removed
	 * @throws NoSuchLonjaException if a lonja with the primary key could not be found
	 */
	public Lonja remove(long entityId) throws NoSuchLonjaException;

	public Lonja updateImpl(Lonja lonja);

	/**
	 * Returns the lonja with the primary key or throws a <code>NoSuchLonjaException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the lonja
	 * @return the lonja
	 * @throws NoSuchLonjaException if a lonja with the primary key could not be found
	 */
	public Lonja findByPrimaryKey(long entityId) throws NoSuchLonjaException;

	/**
	 * Returns the lonja with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the lonja
	 * @return the lonja, or <code>null</code> if a lonja with the primary key could not be found
	 */
	public Lonja fetchByPrimaryKey(long entityId);

	/**
	 * Returns all the lonjas.
	 *
	 * @return the lonjas
	 */
	public java.util.List<Lonja> findAll();

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
	public java.util.List<Lonja> findAll(int start, int end);

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
	public java.util.List<Lonja> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lonja>
			orderByComparator);

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
	public java.util.List<Lonja> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Lonja>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the lonjas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of lonjas.
	 *
	 * @return the number of lonjas
	 */
	public int countAll();

}