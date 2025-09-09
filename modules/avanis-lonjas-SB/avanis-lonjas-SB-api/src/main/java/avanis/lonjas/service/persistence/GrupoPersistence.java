/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence;

import avanis.lonjas.exception.NoSuchGrupoException;
import avanis.lonjas.model.Grupo;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the grupo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GrupoUtil
 * @generated
 */
@ProviderType
public interface GrupoPersistence extends BasePersistence<Grupo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GrupoUtil} to access the grupo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the grupos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching grupos
	 */
	public java.util.List<Grupo> findByUuid(String uuid);

	/**
	 * Returns a range of all the grupos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrupoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of grupos
	 * @param end the upper bound of the range of grupos (not inclusive)
	 * @return the range of matching grupos
	 */
	public java.util.List<Grupo> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the grupos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrupoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of grupos
	 * @param end the upper bound of the range of grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching grupos
	 */
	public java.util.List<Grupo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Grupo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the grupos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrupoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of grupos
	 * @param end the upper bound of the range of grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching grupos
	 */
	public java.util.List<Grupo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Grupo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grupo
	 * @throws NoSuchGrupoException if a matching grupo could not be found
	 */
	public Grupo findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Grupo>
				orderByComparator)
		throws NoSuchGrupoException;

	/**
	 * Returns the first grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grupo, or <code>null</code> if a matching grupo could not be found
	 */
	public Grupo fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Grupo>
			orderByComparator);

	/**
	 * Returns the last grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grupo
	 * @throws NoSuchGrupoException if a matching grupo could not be found
	 */
	public Grupo findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Grupo>
				orderByComparator)
		throws NoSuchGrupoException;

	/**
	 * Returns the last grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grupo, or <code>null</code> if a matching grupo could not be found
	 */
	public Grupo fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Grupo>
			orderByComparator);

	/**
	 * Returns the grupos before and after the current grupo in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current grupo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next grupo
	 * @throws NoSuchGrupoException if a grupo with the primary key could not be found
	 */
	public Grupo[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Grupo>
				orderByComparator)
		throws NoSuchGrupoException;

	/**
	 * Removes all the grupos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of grupos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching grupos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the grupos where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the matching grupos
	 */
	public java.util.List<Grupo> findBynombre(String nombre);

	/**
	 * Returns a range of all the grupos where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrupoModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of grupos
	 * @param end the upper bound of the range of grupos (not inclusive)
	 * @return the range of matching grupos
	 */
	public java.util.List<Grupo> findBynombre(
		String nombre, int start, int end);

	/**
	 * Returns an ordered range of all the grupos where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrupoModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of grupos
	 * @param end the upper bound of the range of grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching grupos
	 */
	public java.util.List<Grupo> findBynombre(
		String nombre, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Grupo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the grupos where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrupoModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of grupos
	 * @param end the upper bound of the range of grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching grupos
	 */
	public java.util.List<Grupo> findBynombre(
		String nombre, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Grupo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grupo
	 * @throws NoSuchGrupoException if a matching grupo could not be found
	 */
	public Grupo findBynombre_First(
			String nombre,
			com.liferay.portal.kernel.util.OrderByComparator<Grupo>
				orderByComparator)
		throws NoSuchGrupoException;

	/**
	 * Returns the first grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grupo, or <code>null</code> if a matching grupo could not be found
	 */
	public Grupo fetchBynombre_First(
		String nombre,
		com.liferay.portal.kernel.util.OrderByComparator<Grupo>
			orderByComparator);

	/**
	 * Returns the last grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grupo
	 * @throws NoSuchGrupoException if a matching grupo could not be found
	 */
	public Grupo findBynombre_Last(
			String nombre,
			com.liferay.portal.kernel.util.OrderByComparator<Grupo>
				orderByComparator)
		throws NoSuchGrupoException;

	/**
	 * Returns the last grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grupo, or <code>null</code> if a matching grupo could not be found
	 */
	public Grupo fetchBynombre_Last(
		String nombre,
		com.liferay.portal.kernel.util.OrderByComparator<Grupo>
			orderByComparator);

	/**
	 * Returns the grupos before and after the current grupo in the ordered set where nombre = &#63;.
	 *
	 * @param entityId the primary key of the current grupo
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next grupo
	 * @throws NoSuchGrupoException if a grupo with the primary key could not be found
	 */
	public Grupo[] findBynombre_PrevAndNext(
			long entityId, String nombre,
			com.liferay.portal.kernel.util.OrderByComparator<Grupo>
				orderByComparator)
		throws NoSuchGrupoException;

	/**
	 * Removes all the grupos where nombre = &#63; from the database.
	 *
	 * @param nombre the nombre
	 */
	public void removeBynombre(String nombre);

	/**
	 * Returns the number of grupos where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the number of matching grupos
	 */
	public int countBynombre(String nombre);

	/**
	 * Returns the grupo where grupoId = &#63; or throws a <code>NoSuchGrupoException</code> if it could not be found.
	 *
	 * @param grupoId the grupo ID
	 * @return the matching grupo
	 * @throws NoSuchGrupoException if a matching grupo could not be found
	 */
	public Grupo findBygrupoId(long grupoId) throws NoSuchGrupoException;

	/**
	 * Returns the grupo where grupoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param grupoId the grupo ID
	 * @return the matching grupo, or <code>null</code> if a matching grupo could not be found
	 */
	public Grupo fetchBygrupoId(long grupoId);

	/**
	 * Returns the grupo where grupoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param grupoId the grupo ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching grupo, or <code>null</code> if a matching grupo could not be found
	 */
	public Grupo fetchBygrupoId(long grupoId, boolean useFinderCache);

	/**
	 * Removes the grupo where grupoId = &#63; from the database.
	 *
	 * @param grupoId the grupo ID
	 * @return the grupo that was removed
	 */
	public Grupo removeBygrupoId(long grupoId) throws NoSuchGrupoException;

	/**
	 * Returns the number of grupos where grupoId = &#63;.
	 *
	 * @param grupoId the grupo ID
	 * @return the number of matching grupos
	 */
	public int countBygrupoId(long grupoId);

	/**
	 * Caches the grupo in the entity cache if it is enabled.
	 *
	 * @param grupo the grupo
	 */
	public void cacheResult(Grupo grupo);

	/**
	 * Caches the grupos in the entity cache if it is enabled.
	 *
	 * @param grupos the grupos
	 */
	public void cacheResult(java.util.List<Grupo> grupos);

	/**
	 * Creates a new grupo with the primary key. Does not add the grupo to the database.
	 *
	 * @param entityId the primary key for the new grupo
	 * @return the new grupo
	 */
	public Grupo create(long entityId);

	/**
	 * Removes the grupo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the grupo
	 * @return the grupo that was removed
	 * @throws NoSuchGrupoException if a grupo with the primary key could not be found
	 */
	public Grupo remove(long entityId) throws NoSuchGrupoException;

	public Grupo updateImpl(Grupo grupo);

	/**
	 * Returns the grupo with the primary key or throws a <code>NoSuchGrupoException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the grupo
	 * @return the grupo
	 * @throws NoSuchGrupoException if a grupo with the primary key could not be found
	 */
	public Grupo findByPrimaryKey(long entityId) throws NoSuchGrupoException;

	/**
	 * Returns the grupo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the grupo
	 * @return the grupo, or <code>null</code> if a grupo with the primary key could not be found
	 */
	public Grupo fetchByPrimaryKey(long entityId);

	/**
	 * Returns all the grupos.
	 *
	 * @return the grupos
	 */
	public java.util.List<Grupo> findAll();

	/**
	 * Returns a range of all the grupos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrupoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grupos
	 * @param end the upper bound of the range of grupos (not inclusive)
	 * @return the range of grupos
	 */
	public java.util.List<Grupo> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the grupos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrupoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grupos
	 * @param end the upper bound of the range of grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of grupos
	 */
	public java.util.List<Grupo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Grupo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the grupos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrupoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grupos
	 * @param end the upper bound of the range of grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of grupos
	 */
	public java.util.List<Grupo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Grupo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the grupos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of grupos.
	 *
	 * @return the number of grupos
	 */
	public int countAll();

}