/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence;

import avanis.lonjas.model.Grupo;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the grupo service. This utility wraps <code>avanis.lonjas.service.persistence.impl.GrupoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GrupoPersistence
 * @generated
 */
public class GrupoUtil {

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
	public static void clearCache(Grupo grupo) {
		getPersistence().clearCache(grupo);
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
	public static Map<Serializable, Grupo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Grupo> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Grupo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Grupo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Grupo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Grupo update(Grupo grupo) {
		return getPersistence().update(grupo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Grupo update(Grupo grupo, ServiceContext serviceContext) {
		return getPersistence().update(grupo, serviceContext);
	}

	/**
	 * Returns all the grupos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching grupos
	 */
	public static List<Grupo> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Grupo> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Grupo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Grupo> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Grupo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Grupo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grupo
	 * @throws NoSuchGrupoException if a matching grupo could not be found
	 */
	public static Grupo findByUuid_First(
			String uuid, OrderByComparator<Grupo> orderByComparator)
		throws avanis.lonjas.exception.NoSuchGrupoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grupo, or <code>null</code> if a matching grupo could not be found
	 */
	public static Grupo fetchByUuid_First(
		String uuid, OrderByComparator<Grupo> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grupo
	 * @throws NoSuchGrupoException if a matching grupo could not be found
	 */
	public static Grupo findByUuid_Last(
			String uuid, OrderByComparator<Grupo> orderByComparator)
		throws avanis.lonjas.exception.NoSuchGrupoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grupo, or <code>null</code> if a matching grupo could not be found
	 */
	public static Grupo fetchByUuid_Last(
		String uuid, OrderByComparator<Grupo> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the grupos before and after the current grupo in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current grupo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next grupo
	 * @throws NoSuchGrupoException if a grupo with the primary key could not be found
	 */
	public static Grupo[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			OrderByComparator<Grupo> orderByComparator)
		throws avanis.lonjas.exception.NoSuchGrupoException {

		return getPersistence().findByUuid_PrevAndNext(
			entityId, uuid, orderByComparator);
	}

	/**
	 * Removes all the grupos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of grupos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching grupos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the grupos where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the matching grupos
	 */
	public static List<Grupo> findBynombre(String nombre) {
		return getPersistence().findBynombre(nombre);
	}

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
	public static List<Grupo> findBynombre(String nombre, int start, int end) {
		return getPersistence().findBynombre(nombre, start, end);
	}

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
	public static List<Grupo> findBynombre(
		String nombre, int start, int end,
		OrderByComparator<Grupo> orderByComparator) {

		return getPersistence().findBynombre(
			nombre, start, end, orderByComparator);
	}

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
	public static List<Grupo> findBynombre(
		String nombre, int start, int end,
		OrderByComparator<Grupo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBynombre(
			nombre, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grupo
	 * @throws NoSuchGrupoException if a matching grupo could not be found
	 */
	public static Grupo findBynombre_First(
			String nombre, OrderByComparator<Grupo> orderByComparator)
		throws avanis.lonjas.exception.NoSuchGrupoException {

		return getPersistence().findBynombre_First(nombre, orderByComparator);
	}

	/**
	 * Returns the first grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grupo, or <code>null</code> if a matching grupo could not be found
	 */
	public static Grupo fetchBynombre_First(
		String nombre, OrderByComparator<Grupo> orderByComparator) {

		return getPersistence().fetchBynombre_First(nombre, orderByComparator);
	}

	/**
	 * Returns the last grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grupo
	 * @throws NoSuchGrupoException if a matching grupo could not be found
	 */
	public static Grupo findBynombre_Last(
			String nombre, OrderByComparator<Grupo> orderByComparator)
		throws avanis.lonjas.exception.NoSuchGrupoException {

		return getPersistence().findBynombre_Last(nombre, orderByComparator);
	}

	/**
	 * Returns the last grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grupo, or <code>null</code> if a matching grupo could not be found
	 */
	public static Grupo fetchBynombre_Last(
		String nombre, OrderByComparator<Grupo> orderByComparator) {

		return getPersistence().fetchBynombre_Last(nombre, orderByComparator);
	}

	/**
	 * Returns the grupos before and after the current grupo in the ordered set where nombre = &#63;.
	 *
	 * @param entityId the primary key of the current grupo
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next grupo
	 * @throws NoSuchGrupoException if a grupo with the primary key could not be found
	 */
	public static Grupo[] findBynombre_PrevAndNext(
			long entityId, String nombre,
			OrderByComparator<Grupo> orderByComparator)
		throws avanis.lonjas.exception.NoSuchGrupoException {

		return getPersistence().findBynombre_PrevAndNext(
			entityId, nombre, orderByComparator);
	}

	/**
	 * Removes all the grupos where nombre = &#63; from the database.
	 *
	 * @param nombre the nombre
	 */
	public static void removeBynombre(String nombre) {
		getPersistence().removeBynombre(nombre);
	}

	/**
	 * Returns the number of grupos where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the number of matching grupos
	 */
	public static int countBynombre(String nombre) {
		return getPersistence().countBynombre(nombre);
	}

	/**
	 * Returns the grupo where grupoId = &#63; or throws a <code>NoSuchGrupoException</code> if it could not be found.
	 *
	 * @param grupoId the grupo ID
	 * @return the matching grupo
	 * @throws NoSuchGrupoException if a matching grupo could not be found
	 */
	public static Grupo findBygrupoId(long grupoId)
		throws avanis.lonjas.exception.NoSuchGrupoException {

		return getPersistence().findBygrupoId(grupoId);
	}

	/**
	 * Returns the grupo where grupoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param grupoId the grupo ID
	 * @return the matching grupo, or <code>null</code> if a matching grupo could not be found
	 */
	public static Grupo fetchBygrupoId(long grupoId) {
		return getPersistence().fetchBygrupoId(grupoId);
	}

	/**
	 * Returns the grupo where grupoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param grupoId the grupo ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching grupo, or <code>null</code> if a matching grupo could not be found
	 */
	public static Grupo fetchBygrupoId(long grupoId, boolean useFinderCache) {
		return getPersistence().fetchBygrupoId(grupoId, useFinderCache);
	}

	/**
	 * Removes the grupo where grupoId = &#63; from the database.
	 *
	 * @param grupoId the grupo ID
	 * @return the grupo that was removed
	 */
	public static Grupo removeBygrupoId(long grupoId)
		throws avanis.lonjas.exception.NoSuchGrupoException {

		return getPersistence().removeBygrupoId(grupoId);
	}

	/**
	 * Returns the number of grupos where grupoId = &#63;.
	 *
	 * @param grupoId the grupo ID
	 * @return the number of matching grupos
	 */
	public static int countBygrupoId(long grupoId) {
		return getPersistence().countBygrupoId(grupoId);
	}

	/**
	 * Caches the grupo in the entity cache if it is enabled.
	 *
	 * @param grupo the grupo
	 */
	public static void cacheResult(Grupo grupo) {
		getPersistence().cacheResult(grupo);
	}

	/**
	 * Caches the grupos in the entity cache if it is enabled.
	 *
	 * @param grupos the grupos
	 */
	public static void cacheResult(List<Grupo> grupos) {
		getPersistence().cacheResult(grupos);
	}

	/**
	 * Creates a new grupo with the primary key. Does not add the grupo to the database.
	 *
	 * @param entityId the primary key for the new grupo
	 * @return the new grupo
	 */
	public static Grupo create(long entityId) {
		return getPersistence().create(entityId);
	}

	/**
	 * Removes the grupo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the grupo
	 * @return the grupo that was removed
	 * @throws NoSuchGrupoException if a grupo with the primary key could not be found
	 */
	public static Grupo remove(long entityId)
		throws avanis.lonjas.exception.NoSuchGrupoException {

		return getPersistence().remove(entityId);
	}

	public static Grupo updateImpl(Grupo grupo) {
		return getPersistence().updateImpl(grupo);
	}

	/**
	 * Returns the grupo with the primary key or throws a <code>NoSuchGrupoException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the grupo
	 * @return the grupo
	 * @throws NoSuchGrupoException if a grupo with the primary key could not be found
	 */
	public static Grupo findByPrimaryKey(long entityId)
		throws avanis.lonjas.exception.NoSuchGrupoException {

		return getPersistence().findByPrimaryKey(entityId);
	}

	/**
	 * Returns the grupo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the grupo
	 * @return the grupo, or <code>null</code> if a grupo with the primary key could not be found
	 */
	public static Grupo fetchByPrimaryKey(long entityId) {
		return getPersistence().fetchByPrimaryKey(entityId);
	}

	/**
	 * Returns all the grupos.
	 *
	 * @return the grupos
	 */
	public static List<Grupo> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Grupo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Grupo> findAll(
		int start, int end, OrderByComparator<Grupo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Grupo> findAll(
		int start, int end, OrderByComparator<Grupo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the grupos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of grupos.
	 *
	 * @return the number of grupos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GrupoPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(GrupoPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile GrupoPersistence _persistence;

}