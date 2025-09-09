/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link GrupoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GrupoLocalService
 * @generated
 */
public class GrupoLocalServiceWrapper
	implements GrupoLocalService, ServiceWrapper<GrupoLocalService> {

	public GrupoLocalServiceWrapper() {
		this(null);
	}

	public GrupoLocalServiceWrapper(GrupoLocalService grupoLocalService) {
		_grupoLocalService = grupoLocalService;
	}

	/**
	 * Adds the grupo to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GrupoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param grupo the grupo
	 * @return the grupo that was added
	 */
	@Override
	public avanis.lonjas.model.Grupo addGrupo(avanis.lonjas.model.Grupo grupo) {
		return _grupoLocalService.addGrupo(grupo);
	}

	/**
	 * Creates a new grupo with the primary key. Does not add the grupo to the database.
	 *
	 * @param entityId the primary key for the new grupo
	 * @return the new grupo
	 */
	@Override
	public avanis.lonjas.model.Grupo createGrupo(long entityId) {
		return _grupoLocalService.createGrupo(entityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _grupoLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the grupo from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GrupoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param grupo the grupo
	 * @return the grupo that was removed
	 */
	@Override
	public avanis.lonjas.model.Grupo deleteGrupo(
		avanis.lonjas.model.Grupo grupo) {

		return _grupoLocalService.deleteGrupo(grupo);
	}

	/**
	 * Deletes the grupo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GrupoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param entityId the primary key of the grupo
	 * @return the grupo that was removed
	 * @throws PortalException if a grupo with the primary key could not be found
	 */
	@Override
	public avanis.lonjas.model.Grupo deleteGrupo(long entityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _grupoLocalService.deleteGrupo(entityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _grupoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _grupoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _grupoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _grupoLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _grupoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.GrupoModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _grupoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.GrupoModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _grupoLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _grupoLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _grupoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public avanis.lonjas.model.Grupo fetchGrupo(long entityId) {
		return _grupoLocalService.fetchGrupo(entityId);
	}

	@Override
	public avanis.lonjas.model.Grupo findByGroupId(long groupId) {
		return _grupoLocalService.findByGroupId(groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _grupoLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the grupo with the primary key.
	 *
	 * @param entityId the primary key of the grupo
	 * @return the grupo
	 * @throws PortalException if a grupo with the primary key could not be found
	 */
	@Override
	public avanis.lonjas.model.Grupo getGrupo(long entityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _grupoLocalService.getGrupo(entityId);
	}

	/**
	 * Returns a range of all the grupos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.GrupoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grupos
	 * @param end the upper bound of the range of grupos (not inclusive)
	 * @return the range of grupos
	 */
	@Override
	public java.util.List<avanis.lonjas.model.Grupo> getGrupos(
		int start, int end) {

		return _grupoLocalService.getGrupos(start, end);
	}

	/**
	 * Returns the number of grupos.
	 *
	 * @return the number of grupos
	 */
	@Override
	public int getGruposCount() {
		return _grupoLocalService.getGruposCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _grupoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _grupoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _grupoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the grupo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GrupoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param grupo the grupo
	 * @return the grupo that was updated
	 */
	@Override
	public avanis.lonjas.model.Grupo updateGrupo(
		avanis.lonjas.model.Grupo grupo) {

		return _grupoLocalService.updateGrupo(grupo);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _grupoLocalService.getBasePersistence();
	}

	@Override
	public GrupoLocalService getWrappedService() {
		return _grupoLocalService;
	}

	@Override
	public void setWrappedService(GrupoLocalService grupoLocalService) {
		_grupoLocalService = grupoLocalService;
	}

	private GrupoLocalService _grupoLocalService;

}