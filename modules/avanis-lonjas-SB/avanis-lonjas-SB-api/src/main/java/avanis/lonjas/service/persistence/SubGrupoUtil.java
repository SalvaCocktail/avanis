/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence;

import avanis.lonjas.model.SubGrupo;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the sub grupo service. This utility wraps <code>avanis.lonjas.service.persistence.impl.SubGrupoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubGrupoPersistence
 * @generated
 */
public class SubGrupoUtil {

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
	public static void clearCache(SubGrupo subGrupo) {
		getPersistence().clearCache(subGrupo);
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
	public static Map<Serializable, SubGrupo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SubGrupo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SubGrupo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SubGrupo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SubGrupo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SubGrupo update(SubGrupo subGrupo) {
		return getPersistence().update(subGrupo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SubGrupo update(
		SubGrupo subGrupo, ServiceContext serviceContext) {

		return getPersistence().update(subGrupo, serviceContext);
	}

	/**
	 * Returns all the sub grupos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sub grupos
	 */
	public static List<SubGrupo> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<SubGrupo> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<SubGrupo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SubGrupo> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<SubGrupo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SubGrupo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sub grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub grupo
	 * @throws NoSuchSubGrupoException if a matching sub grupo could not be found
	 */
	public static SubGrupo findByUuid_First(
			String uuid, OrderByComparator<SubGrupo> orderByComparator)
		throws avanis.lonjas.exception.NoSuchSubGrupoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first sub grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub grupo, or <code>null</code> if a matching sub grupo could not be found
	 */
	public static SubGrupo fetchByUuid_First(
		String uuid, OrderByComparator<SubGrupo> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last sub grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub grupo
	 * @throws NoSuchSubGrupoException if a matching sub grupo could not be found
	 */
	public static SubGrupo findByUuid_Last(
			String uuid, OrderByComparator<SubGrupo> orderByComparator)
		throws avanis.lonjas.exception.NoSuchSubGrupoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last sub grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub grupo, or <code>null</code> if a matching sub grupo could not be found
	 */
	public static SubGrupo fetchByUuid_Last(
		String uuid, OrderByComparator<SubGrupo> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the sub grupos before and after the current sub grupo in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current sub grupo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sub grupo
	 * @throws NoSuchSubGrupoException if a sub grupo with the primary key could not be found
	 */
	public static SubGrupo[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			OrderByComparator<SubGrupo> orderByComparator)
		throws avanis.lonjas.exception.NoSuchSubGrupoException {

		return getPersistence().findByUuid_PrevAndNext(
			entityId, uuid, orderByComparator);
	}

	/**
	 * Removes all the sub grupos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of sub grupos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sub grupos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the sub grupos where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the matching sub grupos
	 */
	public static List<SubGrupo> findBynombre(String nombre) {
		return getPersistence().findBynombre(nombre);
	}

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
	public static List<SubGrupo> findBynombre(
		String nombre, int start, int end) {

		return getPersistence().findBynombre(nombre, start, end);
	}

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
	public static List<SubGrupo> findBynombre(
		String nombre, int start, int end,
		OrderByComparator<SubGrupo> orderByComparator) {

		return getPersistence().findBynombre(
			nombre, start, end, orderByComparator);
	}

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
	public static List<SubGrupo> findBynombre(
		String nombre, int start, int end,
		OrderByComparator<SubGrupo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBynombre(
			nombre, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sub grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub grupo
	 * @throws NoSuchSubGrupoException if a matching sub grupo could not be found
	 */
	public static SubGrupo findBynombre_First(
			String nombre, OrderByComparator<SubGrupo> orderByComparator)
		throws avanis.lonjas.exception.NoSuchSubGrupoException {

		return getPersistence().findBynombre_First(nombre, orderByComparator);
	}

	/**
	 * Returns the first sub grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub grupo, or <code>null</code> if a matching sub grupo could not be found
	 */
	public static SubGrupo fetchBynombre_First(
		String nombre, OrderByComparator<SubGrupo> orderByComparator) {

		return getPersistence().fetchBynombre_First(nombre, orderByComparator);
	}

	/**
	 * Returns the last sub grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub grupo
	 * @throws NoSuchSubGrupoException if a matching sub grupo could not be found
	 */
	public static SubGrupo findBynombre_Last(
			String nombre, OrderByComparator<SubGrupo> orderByComparator)
		throws avanis.lonjas.exception.NoSuchSubGrupoException {

		return getPersistence().findBynombre_Last(nombre, orderByComparator);
	}

	/**
	 * Returns the last sub grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub grupo, or <code>null</code> if a matching sub grupo could not be found
	 */
	public static SubGrupo fetchBynombre_Last(
		String nombre, OrderByComparator<SubGrupo> orderByComparator) {

		return getPersistence().fetchBynombre_Last(nombre, orderByComparator);
	}

	/**
	 * Returns the sub grupos before and after the current sub grupo in the ordered set where nombre = &#63;.
	 *
	 * @param entityId the primary key of the current sub grupo
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sub grupo
	 * @throws NoSuchSubGrupoException if a sub grupo with the primary key could not be found
	 */
	public static SubGrupo[] findBynombre_PrevAndNext(
			long entityId, String nombre,
			OrderByComparator<SubGrupo> orderByComparator)
		throws avanis.lonjas.exception.NoSuchSubGrupoException {

		return getPersistence().findBynombre_PrevAndNext(
			entityId, nombre, orderByComparator);
	}

	/**
	 * Removes all the sub grupos where nombre = &#63; from the database.
	 *
	 * @param nombre the nombre
	 */
	public static void removeBynombre(String nombre) {
		getPersistence().removeBynombre(nombre);
	}

	/**
	 * Returns the number of sub grupos where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the number of matching sub grupos
	 */
	public static int countBynombre(String nombre) {
		return getPersistence().countBynombre(nombre);
	}

	/**
	 * Returns the sub grupo where subGrupoId = &#63; or throws a <code>NoSuchSubGrupoException</code> if it could not be found.
	 *
	 * @param subGrupoId the sub grupo ID
	 * @return the matching sub grupo
	 * @throws NoSuchSubGrupoException if a matching sub grupo could not be found
	 */
	public static SubGrupo findBysubGrupoId(long subGrupoId)
		throws avanis.lonjas.exception.NoSuchSubGrupoException {

		return getPersistence().findBysubGrupoId(subGrupoId);
	}

	/**
	 * Returns the sub grupo where subGrupoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param subGrupoId the sub grupo ID
	 * @return the matching sub grupo, or <code>null</code> if a matching sub grupo could not be found
	 */
	public static SubGrupo fetchBysubGrupoId(long subGrupoId) {
		return getPersistence().fetchBysubGrupoId(subGrupoId);
	}

	/**
	 * Returns the sub grupo where subGrupoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param subGrupoId the sub grupo ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sub grupo, or <code>null</code> if a matching sub grupo could not be found
	 */
	public static SubGrupo fetchBysubGrupoId(
		long subGrupoId, boolean useFinderCache) {

		return getPersistence().fetchBysubGrupoId(subGrupoId, useFinderCache);
	}

	/**
	 * Removes the sub grupo where subGrupoId = &#63; from the database.
	 *
	 * @param subGrupoId the sub grupo ID
	 * @return the sub grupo that was removed
	 */
	public static SubGrupo removeBysubGrupoId(long subGrupoId)
		throws avanis.lonjas.exception.NoSuchSubGrupoException {

		return getPersistence().removeBysubGrupoId(subGrupoId);
	}

	/**
	 * Returns the number of sub grupos where subGrupoId = &#63;.
	 *
	 * @param subGrupoId the sub grupo ID
	 * @return the number of matching sub grupos
	 */
	public static int countBysubGrupoId(long subGrupoId) {
		return getPersistence().countBysubGrupoId(subGrupoId);
	}

	/**
	 * Caches the sub grupo in the entity cache if it is enabled.
	 *
	 * @param subGrupo the sub grupo
	 */
	public static void cacheResult(SubGrupo subGrupo) {
		getPersistence().cacheResult(subGrupo);
	}

	/**
	 * Caches the sub grupos in the entity cache if it is enabled.
	 *
	 * @param subGrupos the sub grupos
	 */
	public static void cacheResult(List<SubGrupo> subGrupos) {
		getPersistence().cacheResult(subGrupos);
	}

	/**
	 * Creates a new sub grupo with the primary key. Does not add the sub grupo to the database.
	 *
	 * @param entityId the primary key for the new sub grupo
	 * @return the new sub grupo
	 */
	public static SubGrupo create(long entityId) {
		return getPersistence().create(entityId);
	}

	/**
	 * Removes the sub grupo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the sub grupo
	 * @return the sub grupo that was removed
	 * @throws NoSuchSubGrupoException if a sub grupo with the primary key could not be found
	 */
	public static SubGrupo remove(long entityId)
		throws avanis.lonjas.exception.NoSuchSubGrupoException {

		return getPersistence().remove(entityId);
	}

	public static SubGrupo updateImpl(SubGrupo subGrupo) {
		return getPersistence().updateImpl(subGrupo);
	}

	/**
	 * Returns the sub grupo with the primary key or throws a <code>NoSuchSubGrupoException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the sub grupo
	 * @return the sub grupo
	 * @throws NoSuchSubGrupoException if a sub grupo with the primary key could not be found
	 */
	public static SubGrupo findByPrimaryKey(long entityId)
		throws avanis.lonjas.exception.NoSuchSubGrupoException {

		return getPersistence().findByPrimaryKey(entityId);
	}

	/**
	 * Returns the sub grupo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the sub grupo
	 * @return the sub grupo, or <code>null</code> if a sub grupo with the primary key could not be found
	 */
	public static SubGrupo fetchByPrimaryKey(long entityId) {
		return getPersistence().fetchByPrimaryKey(entityId);
	}

	/**
	 * Returns all the sub grupos.
	 *
	 * @return the sub grupos
	 */
	public static List<SubGrupo> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<SubGrupo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<SubGrupo> findAll(
		int start, int end, OrderByComparator<SubGrupo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<SubGrupo> findAll(
		int start, int end, OrderByComparator<SubGrupo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sub grupos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sub grupos.
	 *
	 * @return the number of sub grupos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SubGrupoPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(SubGrupoPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile SubGrupoPersistence _persistence;

}