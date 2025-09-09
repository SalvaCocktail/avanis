/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import java.util.Set;

/**
 * Provides a wrapper for {@link PrecioLonjaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PrecioLonjaLocalService
 * @generated
 */
public class PrecioLonjaLocalServiceWrapper
	implements PrecioLonjaLocalService,
			   ServiceWrapper<PrecioLonjaLocalService> {

	public PrecioLonjaLocalServiceWrapper() {
		this(null);
	}

	public PrecioLonjaLocalServiceWrapper(
		PrecioLonjaLocalService precioLonjaLocalService) {

		_precioLonjaLocalService = precioLonjaLocalService;
	}

	/**
	 * Adds the precio lonja to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PrecioLonjaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param precioLonja the precio lonja
	 * @return the precio lonja that was added
	 */
	@Override
	public avanis.lonjas.model.PrecioLonja addPrecioLonja(
		avanis.lonjas.model.PrecioLonja precioLonja) {

		return _precioLonjaLocalService.addPrecioLonja(precioLonja);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _precioLonjaLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new precio lonja with the primary key. Does not add the precio lonja to the database.
	 *
	 * @param entityId the primary key for the new precio lonja
	 * @return the new precio lonja
	 */
	@Override
	public avanis.lonjas.model.PrecioLonja createPrecioLonja(long entityId) {
		return _precioLonjaLocalService.createPrecioLonja(entityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _precioLonjaLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the precio lonja with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PrecioLonjaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param entityId the primary key of the precio lonja
	 * @return the precio lonja that was removed
	 * @throws PortalException if a precio lonja with the primary key could not be found
	 */
	@Override
	public avanis.lonjas.model.PrecioLonja deletePrecioLonja(long entityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _precioLonjaLocalService.deletePrecioLonja(entityId);
	}

	/**
	 * Deletes the precio lonja from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PrecioLonjaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param precioLonja the precio lonja
	 * @return the precio lonja that was removed
	 */
	@Override
	public avanis.lonjas.model.PrecioLonja deletePrecioLonja(
		avanis.lonjas.model.PrecioLonja precioLonja) {

		return _precioLonjaLocalService.deletePrecioLonja(precioLonja);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _precioLonjaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _precioLonjaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _precioLonjaLocalService.dynamicQuery();
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

		return _precioLonjaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.PrecioLonjaModelImpl</code>.
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

		return _precioLonjaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.PrecioLonjaModelImpl</code>.
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

		return _precioLonjaLocalService.dynamicQuery(
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

		return _precioLonjaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _precioLonjaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public avanis.lonjas.model.PrecioLonja fetchPrecioLonja(long entityId) {
		return _precioLonjaLocalService.fetchPrecioLonja(entityId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _precioLonjaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _precioLonjaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _precioLonjaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _precioLonjaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the precio lonja with the primary key.
	 *
	 * @param entityId the primary key of the precio lonja
	 * @return the precio lonja
	 * @throws PortalException if a precio lonja with the primary key could not be found
	 */
	@Override
	public avanis.lonjas.model.PrecioLonja getPrecioLonja(long entityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _precioLonjaLocalService.getPrecioLonja(entityId);
	}

	@Override
	public java.util.List<avanis.lonjas.model.PrecioLonja>
		getPrecioLonjaByLonjaId(long lonjaId) {

		return _precioLonjaLocalService.getPrecioLonjaByLonjaId(lonjaId);
	}

	@Override
	public java.util.List<avanis.lonjas.model.PrecioLonja>
		getPrecioLonjaByLonjaIdByFecha(long lonjaId, java.util.Date fecha) {

		return _precioLonjaLocalService.getPrecioLonjaByLonjaIdByFecha(
			lonjaId, fecha);
	}

	@Override
	public java.util.List<avanis.lonjas.model.PrecioLonja>
	    getPrecioLonjaByLonjaIdByProductoId(
	            long lonjaId, long productoId,
	            com.liferay.portal.kernel.util.OrderByComparator
	                    <avanis.lonjas.model.PrecioLonja> orderByComparator) {
	
	    return _precioLonjaLocalService.getPrecioLonjaByLonjaIdByProductoId(
	            lonjaId, productoId, orderByComparator);
	}
	
	@Override
	public java.util.List<avanis.lonjas.model.PrecioLonja>
	    getLatestByLonjaIdsAndProductoIds(
	            Set<Long> lonjaIds, Set<Long> productoIds,
	            com.liferay.portal.kernel.util.OrderByComparator
	                    <avanis.lonjas.model.PrecioLonja> orderByComparator) {
	
	    return _precioLonjaLocalService.getLatestByLonjaIdsAndProductoIds(
	            lonjaIds, productoIds, orderByComparator);
	}

	/**
	 * Returns a range of all the precio lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @return the range of precio lonjas
	 */
	@Override
	public java.util.List<avanis.lonjas.model.PrecioLonja> getPrecioLonjas(
		int start, int end) {

		return _precioLonjaLocalService.getPrecioLonjas(start, end);
	}

	/**
	 * Returns the number of precio lonjas.
	 *
	 * @return the number of precio lonjas
	 */
	@Override
	public int getPrecioLonjasCount() {
		return _precioLonjaLocalService.getPrecioLonjasCount();
	}

	/**
	 * Updates the precio lonja in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PrecioLonjaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param precioLonja the precio lonja
	 * @return the precio lonja that was updated
	 */
	@Override
	public avanis.lonjas.model.PrecioLonja updatePrecioLonja(
		avanis.lonjas.model.PrecioLonja precioLonja) {

		return _precioLonjaLocalService.updatePrecioLonja(precioLonja);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _precioLonjaLocalService.getBasePersistence();
	}

	@Override
	public PrecioLonjaLocalService getWrappedService() {
		return _precioLonjaLocalService;
	}

	@Override
	public void setWrappedService(
		PrecioLonjaLocalService precioLonjaLocalService) {

		_precioLonjaLocalService = precioLonjaLocalService;
	}

	private PrecioLonjaLocalService _precioLonjaLocalService;

}