/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence;

import avanis.lonjas.exception.NoSuchAreaException;
import avanis.lonjas.model.Area;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the area service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AreaUtil
 * @generated
 */
@ProviderType
public interface AreaPersistence extends BasePersistence<Area> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AreaUtil} to access the area persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the areas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching areas
	 */
	public java.util.List<Area> findByUuid(String uuid);

	/**
	 * Returns a range of all the areas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @return the range of matching areas
	 */
	public java.util.List<Area> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the areas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching areas
	 */
	public java.util.List<Area> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Area>
			orderByComparator);

	/**
	 * Returns an ordered range of all the areas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching areas
	 */
	public java.util.List<Area> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Area>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area
	 * @throws NoSuchAreaException if a matching area could not be found
	 */
	public Area findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Area>
				orderByComparator)
		throws NoSuchAreaException;

	/**
	 * Returns the first area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area, or <code>null</code> if a matching area could not be found
	 */
	public Area fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Area>
			orderByComparator);

	/**
	 * Returns the last area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area
	 * @throws NoSuchAreaException if a matching area could not be found
	 */
	public Area findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Area>
				orderByComparator)
		throws NoSuchAreaException;

	/**
	 * Returns the last area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area, or <code>null</code> if a matching area could not be found
	 */
	public Area fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Area>
			orderByComparator);

	/**
	 * Returns the areas before and after the current area in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current area
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next area
	 * @throws NoSuchAreaException if a area with the primary key could not be found
	 */
	public Area[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Area>
				orderByComparator)
		throws NoSuchAreaException;

	/**
	 * Removes all the areas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of areas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching areas
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the areas where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the matching areas
	 */
	public java.util.List<Area> findBynombre(String nombre);

	/**
	 * Returns a range of all the areas where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @return the range of matching areas
	 */
	public java.util.List<Area> findBynombre(String nombre, int start, int end);

	/**
	 * Returns an ordered range of all the areas where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching areas
	 */
	public java.util.List<Area> findBynombre(
		String nombre, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Area>
			orderByComparator);

	/**
	 * Returns an ordered range of all the areas where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching areas
	 */
	public java.util.List<Area> findBynombre(
		String nombre, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Area>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first area in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area
	 * @throws NoSuchAreaException if a matching area could not be found
	 */
	public Area findBynombre_First(
			String nombre,
			com.liferay.portal.kernel.util.OrderByComparator<Area>
				orderByComparator)
		throws NoSuchAreaException;

	/**
	 * Returns the first area in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area, or <code>null</code> if a matching area could not be found
	 */
	public Area fetchBynombre_First(
		String nombre,
		com.liferay.portal.kernel.util.OrderByComparator<Area>
			orderByComparator);

	/**
	 * Returns the last area in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area
	 * @throws NoSuchAreaException if a matching area could not be found
	 */
	public Area findBynombre_Last(
			String nombre,
			com.liferay.portal.kernel.util.OrderByComparator<Area>
				orderByComparator)
		throws NoSuchAreaException;

	/**
	 * Returns the last area in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area, or <code>null</code> if a matching area could not be found
	 */
	public Area fetchBynombre_Last(
		String nombre,
		com.liferay.portal.kernel.util.OrderByComparator<Area>
			orderByComparator);

	/**
	 * Returns the areas before and after the current area in the ordered set where nombre = &#63;.
	 *
	 * @param entityId the primary key of the current area
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next area
	 * @throws NoSuchAreaException if a area with the primary key could not be found
	 */
	public Area[] findBynombre_PrevAndNext(
			long entityId, String nombre,
			com.liferay.portal.kernel.util.OrderByComparator<Area>
				orderByComparator)
		throws NoSuchAreaException;

	/**
	 * Removes all the areas where nombre = &#63; from the database.
	 *
	 * @param nombre the nombre
	 */
	public void removeBynombre(String nombre);

	/**
	 * Returns the number of areas where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the number of matching areas
	 */
	public int countBynombre(String nombre);

	/**
	 * Returns the area where areaId = &#63; or throws a <code>NoSuchAreaException</code> if it could not be found.
	 *
	 * @param areaId the area ID
	 * @return the matching area
	 * @throws NoSuchAreaException if a matching area could not be found
	 */
	public Area findByareaId(long areaId) throws NoSuchAreaException;

	/**
	 * Returns the area where areaId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param areaId the area ID
	 * @return the matching area, or <code>null</code> if a matching area could not be found
	 */
	public Area fetchByareaId(long areaId);

	/**
	 * Returns the area where areaId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param areaId the area ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching area, or <code>null</code> if a matching area could not be found
	 */
	public Area fetchByareaId(long areaId, boolean useFinderCache);

	/**
	 * Removes the area where areaId = &#63; from the database.
	 *
	 * @param areaId the area ID
	 * @return the area that was removed
	 */
	public Area removeByareaId(long areaId) throws NoSuchAreaException;

	/**
	 * Returns the number of areas where areaId = &#63;.
	 *
	 * @param areaId the area ID
	 * @return the number of matching areas
	 */
	public int countByareaId(long areaId);

	/**
	 * Caches the area in the entity cache if it is enabled.
	 *
	 * @param area the area
	 */
	public void cacheResult(Area area);

	/**
	 * Caches the areas in the entity cache if it is enabled.
	 *
	 * @param areas the areas
	 */
	public void cacheResult(java.util.List<Area> areas);

	/**
	 * Creates a new area with the primary key. Does not add the area to the database.
	 *
	 * @param entityId the primary key for the new area
	 * @return the new area
	 */
	public Area create(long entityId);

	/**
	 * Removes the area with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the area
	 * @return the area that was removed
	 * @throws NoSuchAreaException if a area with the primary key could not be found
	 */
	public Area remove(long entityId) throws NoSuchAreaException;

	public Area updateImpl(Area area);

	/**
	 * Returns the area with the primary key or throws a <code>NoSuchAreaException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the area
	 * @return the area
	 * @throws NoSuchAreaException if a area with the primary key could not be found
	 */
	public Area findByPrimaryKey(long entityId) throws NoSuchAreaException;

	/**
	 * Returns the area with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the area
	 * @return the area, or <code>null</code> if a area with the primary key could not be found
	 */
	public Area fetchByPrimaryKey(long entityId);

	/**
	 * Returns all the areas.
	 *
	 * @return the areas
	 */
	public java.util.List<Area> findAll();

	/**
	 * Returns a range of all the areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @return the range of areas
	 */
	public java.util.List<Area> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of areas
	 */
	public java.util.List<Area> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Area>
			orderByComparator);

	/**
	 * Returns an ordered range of all the areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of areas
	 */
	public java.util.List<Area> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Area>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the areas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of areas.
	 *
	 * @return the number of areas
	 */
	public int countAll();

}