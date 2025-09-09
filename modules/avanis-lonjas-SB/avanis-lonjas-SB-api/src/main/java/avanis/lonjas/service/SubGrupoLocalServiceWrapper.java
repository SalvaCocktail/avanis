/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link SubGrupoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SubGrupoLocalService
 * @generated
 */
public class SubGrupoLocalServiceWrapper
	implements ServiceWrapper<SubGrupoLocalService>, SubGrupoLocalService {

	public SubGrupoLocalServiceWrapper() {
		this(null);
	}

	public SubGrupoLocalServiceWrapper(
		SubGrupoLocalService subGrupoLocalService) {

		_subGrupoLocalService = subGrupoLocalService;
	}

	/**
	 * Adds the sub grupo to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubGrupoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subGrupo the sub grupo
	 * @return the sub grupo that was added
	 */
	@Override
	public avanis.lonjas.model.SubGrupo addSubGrupo(
		avanis.lonjas.model.SubGrupo subGrupo) {

		return _subGrupoLocalService.addSubGrupo(subGrupo);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subGrupoLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sub grupo with the primary key. Does not add the sub grupo to the database.
	 *
	 * @param entityId the primary key for the new sub grupo
	 * @return the new sub grupo
	 */
	@Override
	public avanis.lonjas.model.SubGrupo createSubGrupo(long entityId) {
		return _subGrupoLocalService.createSubGrupo(entityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subGrupoLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sub grupo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubGrupoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param entityId the primary key of the sub grupo
	 * @return the sub grupo that was removed
	 * @throws PortalException if a sub grupo with the primary key could not be found
	 */
	@Override
	public avanis.lonjas.model.SubGrupo deleteSubGrupo(long entityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subGrupoLocalService.deleteSubGrupo(entityId);
	}

	/**
	 * Deletes the sub grupo from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubGrupoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subGrupo the sub grupo
	 * @return the sub grupo that was removed
	 */
	@Override
	public avanis.lonjas.model.SubGrupo deleteSubGrupo(
		avanis.lonjas.model.SubGrupo subGrupo) {

		return _subGrupoLocalService.deleteSubGrupo(subGrupo);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _subGrupoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _subGrupoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _subGrupoLocalService.dynamicQuery();
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

		return _subGrupoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.SubGrupoModelImpl</code>.
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

		return _subGrupoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.SubGrupoModelImpl</code>.
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

		return _subGrupoLocalService.dynamicQuery(
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

		return _subGrupoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _subGrupoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public avanis.lonjas.model.SubGrupo fetchSubGrupo(long entityId) {
		return _subGrupoLocalService.fetchSubGrupo(entityId);
	}

	@Override
	public avanis.lonjas.model.SubGrupo findBySubGroupId(long subGroupId) {
		return _subGrupoLocalService.findBySubGroupId(subGroupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _subGrupoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _subGrupoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _subGrupoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subGrupoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sub grupo with the primary key.
	 *
	 * @param entityId the primary key of the sub grupo
	 * @return the sub grupo
	 * @throws PortalException if a sub grupo with the primary key could not be found
	 */
	@Override
	public avanis.lonjas.model.SubGrupo getSubGrupo(long entityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subGrupoLocalService.getSubGrupo(entityId);
	}

	/**
	 * Returns a range of all the sub grupos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.SubGrupoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub grupos
	 * @param end the upper bound of the range of sub grupos (not inclusive)
	 * @return the range of sub grupos
	 */
	@Override
	public java.util.List<avanis.lonjas.model.SubGrupo> getSubGrupos(
		int start, int end) {

		return _subGrupoLocalService.getSubGrupos(start, end);
	}

	/**
	 * Returns the number of sub grupos.
	 *
	 * @return the number of sub grupos
	 */
	@Override
	public int getSubGruposCount() {
		return _subGrupoLocalService.getSubGruposCount();
	}

	/**
	 * Updates the sub grupo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubGrupoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subGrupo the sub grupo
	 * @return the sub grupo that was updated
	 */
	@Override
	public avanis.lonjas.model.SubGrupo updateSubGrupo(
		avanis.lonjas.model.SubGrupo subGrupo) {

		return _subGrupoLocalService.updateSubGrupo(subGrupo);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _subGrupoLocalService.getBasePersistence();
	}

	@Override
	public SubGrupoLocalService getWrappedService() {
		return _subGrupoLocalService;
	}

	@Override
	public void setWrappedService(SubGrupoLocalService subGrupoLocalService) {
		_subGrupoLocalService = subGrupoLocalService;
	}

	private SubGrupoLocalService _subGrupoLocalService;

}