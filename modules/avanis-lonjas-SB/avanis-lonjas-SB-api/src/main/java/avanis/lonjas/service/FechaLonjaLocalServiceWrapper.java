/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link FechaLonjaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FechaLonjaLocalService
 * @generated
 */
public class FechaLonjaLocalServiceWrapper
	implements FechaLonjaLocalService, ServiceWrapper<FechaLonjaLocalService> {

	public FechaLonjaLocalServiceWrapper() {
		this(null);
	}

	public FechaLonjaLocalServiceWrapper(
		FechaLonjaLocalService fechaLonjaLocalService) {

		_fechaLonjaLocalService = fechaLonjaLocalService;
	}

	/**
	 * Adds the fecha lonja to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FechaLonjaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fechaLonja the fecha lonja
	 * @return the fecha lonja that was added
	 */
	@Override
	public avanis.lonjas.model.FechaLonja addFechaLonja(
		avanis.lonjas.model.FechaLonja fechaLonja) {

		return _fechaLonjaLocalService.addFechaLonja(fechaLonja);
	}

	/**
	 * Creates a new fecha lonja with the primary key. Does not add the fecha lonja to the database.
	 *
	 * @param entityId the primary key for the new fecha lonja
	 * @return the new fecha lonja
	 */
	@Override
	public avanis.lonjas.model.FechaLonja createFechaLonja(long entityId) {
		return _fechaLonjaLocalService.createFechaLonja(entityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fechaLonjaLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the fecha lonja from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FechaLonjaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fechaLonja the fecha lonja
	 * @return the fecha lonja that was removed
	 */
	@Override
	public avanis.lonjas.model.FechaLonja deleteFechaLonja(
		avanis.lonjas.model.FechaLonja fechaLonja) {

		return _fechaLonjaLocalService.deleteFechaLonja(fechaLonja);
	}

	/**
	 * Deletes the fecha lonja with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FechaLonjaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param entityId the primary key of the fecha lonja
	 * @return the fecha lonja that was removed
	 * @throws PortalException if a fecha lonja with the primary key could not be found
	 */
	@Override
	public avanis.lonjas.model.FechaLonja deleteFechaLonja(long entityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fechaLonjaLocalService.deleteFechaLonja(entityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fechaLonjaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _fechaLonjaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _fechaLonjaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fechaLonjaLocalService.dynamicQuery();
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

		return _fechaLonjaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.FechaLonjaModelImpl</code>.
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

		return _fechaLonjaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.FechaLonjaModelImpl</code>.
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

		return _fechaLonjaLocalService.dynamicQuery(
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

		return _fechaLonjaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _fechaLonjaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public avanis.lonjas.model.FechaLonja fetchFechaLonja(long entityId) {
		return _fechaLonjaLocalService.fetchFechaLonja(entityId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _fechaLonjaLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the fecha lonja with the primary key.
	 *
	 * @param entityId the primary key of the fecha lonja
	 * @return the fecha lonja
	 * @throws PortalException if a fecha lonja with the primary key could not be found
	 */
	@Override
	public avanis.lonjas.model.FechaLonja getFechaLonja(long entityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fechaLonjaLocalService.getFechaLonja(entityId);
	}

	@Override
	public java.util.List<avanis.lonjas.model.FechaLonja>
		getFechaLonjaByLonjaId(long lonjaId) {

		return _fechaLonjaLocalService.getFechaLonjaByLonjaId(lonjaId);
	}

	/**
	 * Returns a range of all the fecha lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.FechaLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fecha lonjas
	 * @param end the upper bound of the range of fecha lonjas (not inclusive)
	 * @return the range of fecha lonjas
	 */
	@Override
	public java.util.List<avanis.lonjas.model.FechaLonja> getFechaLonjas(
		int start, int end) {

		return _fechaLonjaLocalService.getFechaLonjas(start, end);
	}

	/**
	 * Returns the number of fecha lonjas.
	 *
	 * @return the number of fecha lonjas
	 */
	@Override
	public int getFechaLonjasCount() {
		return _fechaLonjaLocalService.getFechaLonjasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _fechaLonjaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fechaLonjaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fechaLonjaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the fecha lonja in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FechaLonjaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fechaLonja the fecha lonja
	 * @return the fecha lonja that was updated
	 */
	@Override
	public avanis.lonjas.model.FechaLonja updateFechaLonja(
		avanis.lonjas.model.FechaLonja fechaLonja) {

		return _fechaLonjaLocalService.updateFechaLonja(fechaLonja);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _fechaLonjaLocalService.getBasePersistence();
	}

	@Override
	public FechaLonjaLocalService getWrappedService() {
		return _fechaLonjaLocalService;
	}

	@Override
	public void setWrappedService(
		FechaLonjaLocalService fechaLonjaLocalService) {

		_fechaLonjaLocalService = fechaLonjaLocalService;
	}

	private FechaLonjaLocalService _fechaLonjaLocalService;

}