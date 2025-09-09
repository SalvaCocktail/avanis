/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link LonjaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LonjaLocalService
 * @generated
 */
public class LonjaLocalServiceWrapper
	implements LonjaLocalService, ServiceWrapper<LonjaLocalService> {

	public LonjaLocalServiceWrapper() {
		this(null);
	}

	public LonjaLocalServiceWrapper(LonjaLocalService lonjaLocalService) {
		_lonjaLocalService = lonjaLocalService;
	}

	/**
	 * Adds the lonja to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LonjaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lonja the lonja
	 * @return the lonja that was added
	 */
	@Override
	public avanis.lonjas.model.Lonja addLonja(avanis.lonjas.model.Lonja lonja) {
		return _lonjaLocalService.addLonja(lonja);
	}

	/**
	 * Creates a new lonja with the primary key. Does not add the lonja to the database.
	 *
	 * @param entityId the primary key for the new lonja
	 * @return the new lonja
	 */
	@Override
	public avanis.lonjas.model.Lonja createLonja(long entityId) {
		return _lonjaLocalService.createLonja(entityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lonjaLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the lonja with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LonjaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param entityId the primary key of the lonja
	 * @return the lonja that was removed
	 * @throws PortalException if a lonja with the primary key could not be found
	 */
	@Override
	public avanis.lonjas.model.Lonja deleteLonja(long entityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lonjaLocalService.deleteLonja(entityId);
	}

	/**
	 * Deletes the lonja from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LonjaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lonja the lonja
	 * @return the lonja that was removed
	 */
	@Override
	public avanis.lonjas.model.Lonja deleteLonja(
		avanis.lonjas.model.Lonja lonja) {

		return _lonjaLocalService.deleteLonja(lonja);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lonjaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _lonjaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _lonjaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _lonjaLocalService.dynamicQuery();
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

		return _lonjaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.LonjaModelImpl</code>.
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

		return _lonjaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.LonjaModelImpl</code>.
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

		return _lonjaLocalService.dynamicQuery(
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

		return _lonjaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _lonjaLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public avanis.lonjas.model.Lonja fetchByLonjaId(long lonjaId) {
		return _lonjaLocalService.fetchByLonjaId(lonjaId);
	}

	@Override
	public avanis.lonjas.model.Lonja fetchLonja(long entityId) {
		return _lonjaLocalService.fetchLonja(entityId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _lonjaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _lonjaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the lonja with the primary key.
	 *
	 * @param entityId the primary key of the lonja
	 * @return the lonja
	 * @throws PortalException if a lonja with the primary key could not be found
	 */
	@Override
	public avanis.lonjas.model.Lonja getLonja(long entityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lonjaLocalService.getLonja(entityId);
	}

	@Override
	public java.util.List<avanis.lonjas.model.Lonja> getLonjaBylonjaId(
		long lonjaId) {

		return _lonjaLocalService.getLonjaBylonjaId(lonjaId);
	}

	@Override
	public java.util.List<avanis.lonjas.model.Lonja> getLonjaBylonjaId(
		long lonjaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {

		return _lonjaLocalService.getLonjaBylonjaId(lonjaId, orderByComparator);
	}

	/**
	 * Returns a range of all the lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @return the range of lonjas
	 */
	@Override
	public java.util.List<avanis.lonjas.model.Lonja> getLonjas(
		int start, int end) {

		return _lonjaLocalService.getLonjas(start, end);
	}

	/**
	 * Returns the number of lonjas.
	 *
	 * @return the number of lonjas
	 */
	@Override
	public int getLonjasCount() {
		return _lonjaLocalService.getLonjasCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _lonjaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lonjaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the lonja in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LonjaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lonja the lonja
	 * @return the lonja that was updated
	 */
	@Override
	public avanis.lonjas.model.Lonja updateLonja(
		avanis.lonjas.model.Lonja lonja) {

		return _lonjaLocalService.updateLonja(lonja);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _lonjaLocalService.getBasePersistence();
	}

	@Override
	public LonjaLocalService getWrappedService() {
		return _lonjaLocalService;
	}

	@Override
	public void setWrappedService(LonjaLocalService lonjaLocalService) {
		_lonjaLocalService = lonjaLocalService;
	}

	private LonjaLocalService _lonjaLocalService;

}