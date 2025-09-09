/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.tu.explotacion.sb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ExplotacionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ExplotacionLocalService
 * @generated
 */
public class ExplotacionLocalServiceWrapper
	implements ExplotacionLocalService,
			   ServiceWrapper<ExplotacionLocalService> {

	public ExplotacionLocalServiceWrapper() {
		this(null);
	}

	public ExplotacionLocalServiceWrapper(
		ExplotacionLocalService explotacionLocalService) {

		_explotacionLocalService = explotacionLocalService;
	}

	@Override
	public avanis.tu.explotacion.sb.model.Explotacion addExplotacion() {
		return _explotacionLocalService.addExplotacion();
	}

	/**
	 * Adds the explotacion to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExplotacionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param explotacion the explotacion
	 * @return the explotacion that was added
	 */
	@Override
	public avanis.tu.explotacion.sb.model.Explotacion addExplotacion(
		avanis.tu.explotacion.sb.model.Explotacion explotacion) {

		return _explotacionLocalService.addExplotacion(explotacion);
	}

	@Override
	public Integer countByUserId(long userId) {
		return _explotacionLocalService.countByUserId(userId);
	}

	/**
	 * Creates a new explotacion with the primary key. Does not add the explotacion to the database.
	 *
	 * @param explotacionId the primary key for the new explotacion
	 * @return the new explotacion
	 */
	@Override
	public avanis.tu.explotacion.sb.model.Explotacion createExplotacion(
		long explotacionId) {

		return _explotacionLocalService.createExplotacion(explotacionId);
	}

	@Override
	public avanis.tu.explotacion.sb.model.Explotacion createOrUpdate(
			long explotacionId, String externalReferenceCode, String provincia,
			Double longitude, int height, String location, String name,
			Double latitude, String meteoredid, int size, String sizeUnit,
			boolean isMain, boolean allowNotifications,
			com.liferay.portal.kernel.model.User user, long[] categories,
			boolean readed)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _explotacionLocalService.createOrUpdate(
			explotacionId, externalReferenceCode, provincia, longitude, height,
			location, name, latitude, meteoredid, size, sizeUnit, isMain,
			allowNotifications, user, categories, readed);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _explotacionLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the explotacion from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExplotacionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param explotacion the explotacion
	 * @return the explotacion that was removed
	 */
	@Override
	public avanis.tu.explotacion.sb.model.Explotacion deleteExplotacion(
		avanis.tu.explotacion.sb.model.Explotacion explotacion) {

		return _explotacionLocalService.deleteExplotacion(explotacion);
	}

	/**
	 * Deletes the explotacion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExplotacionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param explotacionId the primary key of the explotacion
	 * @return the explotacion that was removed
	 * @throws PortalException if a explotacion with the primary key could not be found
	 */
	@Override
	public avanis.tu.explotacion.sb.model.Explotacion deleteExplotacion(
			long explotacionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _explotacionLocalService.deleteExplotacion(explotacionId);
	}

	@Override
	public void deleteExplotacion(
			long explotacionId, com.liferay.portal.kernel.model.User principal)
		throws com.liferay.portal.kernel.exception.PortalException {

		_explotacionLocalService.deleteExplotacion(explotacionId, principal);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _explotacionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _explotacionLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _explotacionLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _explotacionLocalService.dynamicQuery();
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

		return _explotacionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.tu.explotacion.sb.model.impl.ExplotacionModelImpl</code>.
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

		return _explotacionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.tu.explotacion.sb.model.impl.ExplotacionModelImpl</code>.
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

		return _explotacionLocalService.dynamicQuery(
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

		return _explotacionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _explotacionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public avanis.tu.explotacion.sb.model.Explotacion fetchExplotacion(
		long explotacionId) {

		return _explotacionLocalService.fetchExplotacion(explotacionId);
	}

	@Override
	public avanis.tu.explotacion.sb.model.Explotacion
			findByExternalCodeReferenceAndUser(
				String externalCodeReference, long userId)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return _explotacionLocalService.findByExternalCodeReferenceAndUser(
			externalCodeReference, userId);
	}

	@Override
	public avanis.tu.explotacion.sb.model.Explotacion findByIdAndUserId(
			long explotacionId, long userId)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return _explotacionLocalService.findByIdAndUserId(
			explotacionId, userId);
	}

	@Override
	public java.util.List<avanis.tu.explotacion.sb.model.Explotacion>
		findByUserId(long userId) {

		return _explotacionLocalService.findByUserId(userId);
	}

	@Override
	public java.util.List<avanis.tu.explotacion.sb.model.Explotacion>
		findByUserIdReaded(long userId, boolean readed) {

		return _explotacionLocalService.findByUserIdReaded(userId, readed);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _explotacionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the explotacion with the primary key.
	 *
	 * @param explotacionId the primary key of the explotacion
	 * @return the explotacion
	 * @throws PortalException if a explotacion with the primary key could not be found
	 */
	@Override
	public avanis.tu.explotacion.sb.model.Explotacion getExplotacion(
			long explotacionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _explotacionLocalService.getExplotacion(explotacionId);
	}

	/**
	 * Returns a range of all the explotacions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.tu.explotacion.sb.model.impl.ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @return the range of explotacions
	 */
	@Override
	public java.util.List<avanis.tu.explotacion.sb.model.Explotacion>
		getExplotacions(int start, int end) {

		return _explotacionLocalService.getExplotacions(start, end);
	}

	/**
	 * Returns the number of explotacions.
	 *
	 * @return the number of explotacions
	 */
	@Override
	public int getExplotacionsCount() {
		return _explotacionLocalService.getExplotacionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _explotacionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _explotacionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _explotacionLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void setIsMain(long explotacionId, long userId, boolean isMain) {
		_explotacionLocalService.setIsMain(explotacionId, userId, isMain);
	}

	/**
	 * Updates the explotacion in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExplotacionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param explotacion the explotacion
	 * @return the explotacion that was updated
	 */
	@Override
	public avanis.tu.explotacion.sb.model.Explotacion updateExplotacion(
		avanis.tu.explotacion.sb.model.Explotacion explotacion) {

		return _explotacionLocalService.updateExplotacion(explotacion);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _explotacionLocalService.getBasePersistence();
	}

	@Override
	public ExplotacionLocalService getWrappedService() {
		return _explotacionLocalService;
	}

	@Override
	public void setWrappedService(
		ExplotacionLocalService explotacionLocalService) {

		_explotacionLocalService = explotacionLocalService;
	}

	private ExplotacionLocalService _explotacionLocalService;

}