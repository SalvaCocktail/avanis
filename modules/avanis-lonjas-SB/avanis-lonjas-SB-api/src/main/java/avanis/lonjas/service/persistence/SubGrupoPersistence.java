/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence;

import avanis.lonjas.exception.NoSuchSubGrupoException;
import avanis.lonjas.model.SubGrupo;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sub grupo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubGrupoUtil
 * @generated
 */
@ProviderType
public interface SubGrupoPersistence extends BasePersistence<SubGrupo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubGrupoUtil} to access the sub grupo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the sub grupos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sub grupos
	 */
	public java.util.List<SubGrupo> findByUuid(String uuid);

	/**
	 * Returns a range of all the sub grupos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubGrupoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sub grupos
	 * @param end the upper bound of the range of sub grupos (not inclusive)
	 * @return the range of matching sub grupos
	 */
	public java.util.List<SubGrupo> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the sub grupos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubGrupoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sub grupos
	 * @param end the upper bound of the range of sub grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sub grupos
	 */
	public java.util.List<SubGrupo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubGrupo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sub grupos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubGrupoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sub grupos
	 * @param end the upper bound of the range of sub grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sub grupos
	 */
	public java.util.List<SubGrupo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubGrupo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sub grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub grupo
	 * @throws NoSuchSubGrupoException if a matching sub grupo could not be found
	 */
	public SubGrupo findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SubGrupo>
				orderByComparator)
		throws NoSuchSubGrupoException;

	/**
	 * Returns the first sub grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub grupo, or <code>null</code> if a matching sub grupo could not be found
	 */
	public SubGrupo fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SubGrupo>
			orderByComparator);

	/**
	 * Returns the last sub grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub grupo
	 * @throws NoSuchSubGrupoException if a matching sub grupo could not be found
	 */
	public SubGrupo findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SubGrupo>
				orderByComparator)
		throws NoSuchSubGrupoException;

	/**
	 * Returns the last sub grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub grupo, or <code>null</code> if a matching sub grupo could not be found
	 */
	public SubGrupo fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SubGrupo>
			orderByComparator);

	/**
	 * Returns the sub grupos before and after the current sub grupo in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current sub grupo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sub grupo
	 * @throws NoSuchSubGrupoException if a sub grupo with the primary key could not be found
	 */
	public SubGrupo[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SubGrupo>
				orderByComparator)
		throws NoSuchSubGrupoException;

	/**
	 * Removes all the sub grupos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of sub grupos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sub grupos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the sub grupos where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the matching sub grupos
	 */
	public java.util.List<SubGrupo> findBynombre(String nombre);

	/**
	 * Returns a range of all the sub grupos where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubGrupoModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of sub grupos
	 * @param end the upper bound of the range of sub grupos (not inclusive)
	 * @return the range of matching sub grupos
	 */
	public java.util.List<SubGrupo> findBynombre(
		String nombre, int start, int end);

	/**
	 * Returns an ordered range of all the sub grupos where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubGrupoModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of sub grupos
	 * @param end the upper bound of the range of sub grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sub grupos
	 */
	public java.util.List<SubGrupo> findBynombre(
		String nombre, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubGrupo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sub grupos where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubGrupoModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of sub grupos
	 * @param end the upper bound of the range of sub grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sub grupos
	 */
	public java.util.List<SubGrupo> findBynombre(
		String nombre, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubGrupo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sub grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub grupo
	 * @throws NoSuchSubGrupoException if a matching sub grupo could not be found
	 */
	public SubGrupo findBynombre_First(
			String nombre,
			com.liferay.portal.kernel.util.OrderByComparator<SubGrupo>
				orderByComparator)
		throws NoSuchSubGrupoException;

	/**
	 * Returns the first sub grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub grupo, or <code>null</code> if a matching sub grupo could not be found
	 */
	public SubGrupo fetchBynombre_First(
		String nombre,
		com.liferay.portal.kernel.util.OrderByComparator<SubGrupo>
			orderByComparator);

	/**
	 * Returns the last sub grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub grupo
	 * @throws NoSuchSubGrupoException if a matching sub grupo could not be found
	 */
	public SubGrupo findBynombre_Last(
			String nombre,
			com.liferay.portal.kernel.util.OrderByComparator<SubGrupo>
				orderByComparator)
		throws NoSuchSubGrupoException;

	/**
	 * Returns the last sub grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub grupo, or <code>null</code> if a matching sub grupo could not be found
	 */
	public SubGrupo fetchBynombre_Last(
		String nombre,
		com.liferay.portal.kernel.util.OrderByComparator<SubGrupo>
			orderByComparator);

	/**
	 * Returns the sub grupos before and after the current sub grupo in the ordered set where nombre = &#63;.
	 *
	 * @param entityId the primary key of the current sub grupo
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sub grupo
	 * @throws NoSuchSubGrupoException if a sub grupo with the primary key could not be found
	 */
	public SubGrupo[] findBynombre_PrevAndNext(
			long entityId, String nombre,
			com.liferay.portal.kernel.util.OrderByComparator<SubGrupo>
				orderByComparator)
		throws NoSuchSubGrupoException;

	/**
	 * Removes all the sub grupos where nombre = &#63; from the database.
	 *
	 * @param nombre the nombre
	 */
	public void removeBynombre(String nombre);

	/**
	 * Returns the number of sub grupos where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the number of matching sub grupos
	 */
	public int countBynombre(String nombre);

	/**
	 * Returns the sub grupo where subGrupoId = &#63; or throws a <code>NoSuchSubGrupoException</code> if it could not be found.
	 *
	 * @param subGrupoId the sub grupo ID
	 * @return the matching sub grupo
	 * @throws NoSuchSubGrupoException if a matching sub grupo could not be found
	 */
	public SubGrupo findBysubGrupoId(long subGrupoId)
		throws NoSuchSubGrupoException;

	/**
	 * Returns the sub grupo where subGrupoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param subGrupoId the sub grupo ID
	 * @return the matching sub grupo, or <code>null</code> if a matching sub grupo could not be found
	 */
	public SubGrupo fetchBysubGrupoId(long subGrupoId);

	/**
	 * Returns the sub grupo where subGrupoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param subGrupoId the sub grupo ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sub grupo, or <code>null</code> if a matching sub grupo could not be found
	 */
	public SubGrupo fetchBysubGrupoId(long subGrupoId, boolean useFinderCache);

	/**
	 * Removes the sub grupo where subGrupoId = &#63; from the database.
	 *
	 * @param subGrupoId the sub grupo ID
	 * @return the sub grupo that was removed
	 */
	public SubGrupo removeBysubGrupoId(long subGrupoId)
		throws NoSuchSubGrupoException;

	/**
	 * Returns the number of sub grupos where subGrupoId = &#63;.
	 *
	 * @param subGrupoId the sub grupo ID
	 * @return the number of matching sub grupos
	 */
	public int countBysubGrupoId(long subGrupoId);

	/**
	 * Caches the sub grupo in the entity cache if it is enabled.
	 *
	 * @param subGrupo the sub grupo
	 */
	public void cacheResult(SubGrupo subGrupo);

	/**
	 * Caches the sub grupos in the entity cache if it is enabled.
	 *
	 * @param subGrupos the sub grupos
	 */
	public void cacheResult(java.util.List<SubGrupo> subGrupos);

	/**
	 * Creates a new sub grupo with the primary key. Does not add the sub grupo to the database.
	 *
	 * @param entityId the primary key for the new sub grupo
	 * @return the new sub grupo
	 */
	public SubGrupo create(long entityId);

	/**
	 * Removes the sub grupo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the sub grupo
	 * @return the sub grupo that was removed
	 * @throws NoSuchSubGrupoException if a sub grupo with the primary key could not be found
	 */
	public SubGrupo remove(long entityId) throws NoSuchSubGrupoException;

	public SubGrupo updateImpl(SubGrupo subGrupo);

	/**
	 * Returns the sub grupo with the primary key or throws a <code>NoSuchSubGrupoException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the sub grupo
	 * @return the sub grupo
	 * @throws NoSuchSubGrupoException if a sub grupo with the primary key could not be found
	 */
	public SubGrupo findByPrimaryKey(long entityId)
		throws NoSuchSubGrupoException;

	/**
	 * Returns the sub grupo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the sub grupo
	 * @return the sub grupo, or <code>null</code> if a sub grupo with the primary key could not be found
	 */
	public SubGrupo fetchByPrimaryKey(long entityId);

	/**
	 * Returns all the sub grupos.
	 *
	 * @return the sub grupos
	 */
	public java.util.List<SubGrupo> findAll();

	/**
	 * Returns a range of all the sub grupos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubGrupoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub grupos
	 * @param end the upper bound of the range of sub grupos (not inclusive)
	 * @return the range of sub grupos
	 */
	public java.util.List<SubGrupo> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the sub grupos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubGrupoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub grupos
	 * @param end the upper bound of the range of sub grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sub grupos
	 */
	public java.util.List<SubGrupo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubGrupo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sub grupos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubGrupoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub grupos
	 * @param end the upper bound of the range of sub grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sub grupos
	 */
	public java.util.List<SubGrupo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SubGrupo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sub grupos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sub grupos.
	 *
	 * @return the number of sub grupos
	 */
	public int countAll();

}