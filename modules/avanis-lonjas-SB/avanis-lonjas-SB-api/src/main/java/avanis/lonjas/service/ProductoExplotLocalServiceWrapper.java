/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ProductoExplotLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductoExplotLocalService
 * @generated
 */
public class ProductoExplotLocalServiceWrapper
	implements ProductoExplotLocalService,
			   ServiceWrapper<ProductoExplotLocalService> {

	public ProductoExplotLocalServiceWrapper() {
		this(null);
	}

	public ProductoExplotLocalServiceWrapper(
		ProductoExplotLocalService productoExplotLocalService) {

		_productoExplotLocalService = productoExplotLocalService;
	}

	/**
	 * Adds the producto explot to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductoExplotLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productoExplot the producto explot
	 * @return the producto explot that was added
	 */
	@Override
	public avanis.lonjas.model.ProductoExplot addProductoExplot(
		avanis.lonjas.model.ProductoExplot productoExplot) {

		return _productoExplotLocalService.addProductoExplot(productoExplot);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productoExplotLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new producto explot with the primary key. Does not add the producto explot to the database.
	 *
	 * @param entityId the primary key for the new producto explot
	 * @return the new producto explot
	 */
	@Override
	public avanis.lonjas.model.ProductoExplot createProductoExplot(
		long entityId) {

		return _productoExplotLocalService.createProductoExplot(entityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productoExplotLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the producto explot with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductoExplotLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param entityId the primary key of the producto explot
	 * @return the producto explot that was removed
	 * @throws PortalException if a producto explot with the primary key could not be found
	 */
	@Override
	public avanis.lonjas.model.ProductoExplot deleteProductoExplot(
			long entityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productoExplotLocalService.deleteProductoExplot(entityId);
	}

	/**
	 * Deletes the producto explot from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductoExplotLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productoExplot the producto explot
	 * @return the producto explot that was removed
	 */
	@Override
	public avanis.lonjas.model.ProductoExplot deleteProductoExplot(
		avanis.lonjas.model.ProductoExplot productoExplot) {

		return _productoExplotLocalService.deleteProductoExplot(productoExplot);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _productoExplotLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _productoExplotLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productoExplotLocalService.dynamicQuery();
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

		return _productoExplotLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.ProductoExplotModelImpl</code>.
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

		return _productoExplotLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.ProductoExplotModelImpl</code>.
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

		return _productoExplotLocalService.dynamicQuery(
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

		return _productoExplotLocalService.dynamicQueryCount(dynamicQuery);
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

		return _productoExplotLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public avanis.lonjas.model.ProductoExplot fetchProductoExplot(
		long entityId) {

		return _productoExplotLocalService.fetchProductoExplot(entityId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productoExplotLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productoExplotLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productoExplotLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productoExplotLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the producto explot with the primary key.
	 *
	 * @param entityId the primary key of the producto explot
	 * @return the producto explot
	 * @throws PortalException if a producto explot with the primary key could not be found
	 */
	@Override
	public avanis.lonjas.model.ProductoExplot getProductoExplot(long entityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productoExplotLocalService.getProductoExplot(entityId);
	}

	@Override
	public java.util.List<avanis.lonjas.model.ProductoExplot>
		getProductoExplotByExplotacionId(long explotacionId) {

		return _productoExplotLocalService.getProductoExplotByExplotacionId(
			explotacionId);
	}

	/**
	 * Returns a range of all the producto explots.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.ProductoExplotModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of producto explots
	 * @param end the upper bound of the range of producto explots (not inclusive)
	 * @return the range of producto explots
	 */
	@Override
	public java.util.List<avanis.lonjas.model.ProductoExplot>
		getProductoExplots(int start, int end) {

		return _productoExplotLocalService.getProductoExplots(start, end);
	}

	/**
	 * Returns the number of producto explots.
	 *
	 * @return the number of producto explots
	 */
	@Override
	public int getProductoExplotsCount() {
		return _productoExplotLocalService.getProductoExplotsCount();
	}

	/**
	 * Updates the producto explot in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductoExplotLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productoExplot the producto explot
	 * @return the producto explot that was updated
	 */
	@Override
	public avanis.lonjas.model.ProductoExplot updateProductoExplot(
		avanis.lonjas.model.ProductoExplot productoExplot) {

		return _productoExplotLocalService.updateProductoExplot(productoExplot);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _productoExplotLocalService.getBasePersistence();
	}

	@Override
	public ProductoExplotLocalService getWrappedService() {
		return _productoExplotLocalService;
	}

	@Override
	public void setWrappedService(
		ProductoExplotLocalService productoExplotLocalService) {

		_productoExplotLocalService = productoExplotLocalService;
	}

	private ProductoExplotLocalService _productoExplotLocalService;

}