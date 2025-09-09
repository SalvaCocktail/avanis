/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ProductoUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductoUserLocalService
 * @generated
 */
public class ProductoUserLocalServiceWrapper
	implements ProductoUserLocalService,
			   ServiceWrapper<ProductoUserLocalService> {

	public ProductoUserLocalServiceWrapper() {
		this(null);
	}

	public ProductoUserLocalServiceWrapper(
		ProductoUserLocalService productoUserLocalService) {

		_productoUserLocalService = productoUserLocalService;
	}

	/**
	 * Adds the producto user to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductoUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productoUser the producto user
	 * @return the producto user that was added
	 */
	@Override
	public avanis.lonjas.model.ProductoUser addProductoUser(
		avanis.lonjas.model.ProductoUser productoUser) {

		return _productoUserLocalService.addProductoUser(productoUser);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productoUserLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new producto user with the primary key. Does not add the producto user to the database.
	 *
	 * @param entityId the primary key for the new producto user
	 * @return the new producto user
	 */
	@Override
	public avanis.lonjas.model.ProductoUser createProductoUser(long entityId) {
		return _productoUserLocalService.createProductoUser(entityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productoUserLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the producto user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductoUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param entityId the primary key of the producto user
	 * @return the producto user that was removed
	 * @throws PortalException if a producto user with the primary key could not be found
	 */
	@Override
	public avanis.lonjas.model.ProductoUser deleteProductoUser(long entityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productoUserLocalService.deleteProductoUser(entityId);
	}

	/**
	 * Deletes the producto user from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductoUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productoUser the producto user
	 * @return the producto user that was removed
	 */
	@Override
	public avanis.lonjas.model.ProductoUser deleteProductoUser(
		avanis.lonjas.model.ProductoUser productoUser) {

		return _productoUserLocalService.deleteProductoUser(productoUser);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _productoUserLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _productoUserLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productoUserLocalService.dynamicQuery();
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

		return _productoUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.ProductoUserModelImpl</code>.
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

		return _productoUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.ProductoUserModelImpl</code>.
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

		return _productoUserLocalService.dynamicQuery(
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

		return _productoUserLocalService.dynamicQueryCount(dynamicQuery);
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

		return _productoUserLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public avanis.lonjas.model.ProductoUser fetchProductoUser(long entityId) {
		return _productoUserLocalService.fetchProductoUser(entityId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productoUserLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productoUserLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productoUserLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productoUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the producto user with the primary key.
	 *
	 * @param entityId the primary key of the producto user
	 * @return the producto user
	 * @throws PortalException if a producto user with the primary key could not be found
	 */
	@Override
	public avanis.lonjas.model.ProductoUser getProductoUser(long entityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productoUserLocalService.getProductoUser(entityId);
	}

	@Override
	public java.util.List<avanis.lonjas.model.ProductoUser>
		getProductoUserByUserId(long userId) {

		return _productoUserLocalService.getProductoUserByUserId(userId);
	}

	@Override
	public avanis.lonjas.model.ProductoUser
		getProductoUserByUserIdAndProductoId(
			long userId, long lonjaId, long productoId) {

		return _productoUserLocalService.getProductoUserByUserIdAndProductoId(
			userId, lonjaId, productoId);
	}

	/**
	 * Returns a range of all the producto users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.lonjas.model.impl.ProductoUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of producto users
	 * @param end the upper bound of the range of producto users (not inclusive)
	 * @return the range of producto users
	 */
	@Override
	public java.util.List<avanis.lonjas.model.ProductoUser> getProductoUsers(
		int start, int end) {

		return _productoUserLocalService.getProductoUsers(start, end);
	}

	/**
	 * Returns the number of producto users.
	 *
	 * @return the number of producto users
	 */
	@Override
	public int getProductoUsersCount() {
		return _productoUserLocalService.getProductoUsersCount();
	}

	/**
	 * Updates the producto user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProductoUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param productoUser the producto user
	 * @return the producto user that was updated
	 */
	@Override
	public avanis.lonjas.model.ProductoUser updateProductoUser(
		avanis.lonjas.model.ProductoUser productoUser) {

		return _productoUserLocalService.updateProductoUser(productoUser);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _productoUserLocalService.getBasePersistence();
	}

	@Override
	public ProductoUserLocalService getWrappedService() {
		return _productoUserLocalService;
	}

	@Override
	public void setWrappedService(
		ProductoUserLocalService productoUserLocalService) {

		_productoUserLocalService = productoUserLocalService;
	}

	private ProductoUserLocalService _productoUserLocalService;

}