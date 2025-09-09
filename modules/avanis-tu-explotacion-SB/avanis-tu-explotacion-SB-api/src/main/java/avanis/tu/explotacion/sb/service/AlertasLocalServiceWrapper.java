/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.tu.explotacion.sb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AlertasLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AlertasLocalService
 * @generated
 */
public class AlertasLocalServiceWrapper
	implements AlertasLocalService, ServiceWrapper<AlertasLocalService> {

	public AlertasLocalServiceWrapper() {
		this(null);
	}

	public AlertasLocalServiceWrapper(AlertasLocalService alertasLocalService) {
		_alertasLocalService = alertasLocalService;
	}

	@Override
	public avanis.tu.explotacion.sb.model.Alertas addAlertas() {
		return _alertasLocalService.addAlertas();
	}

	/**
	 * Adds the alertas to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AlertasLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param alertas the alertas
	 * @return the alertas that was added
	 */
	@Override
	public avanis.tu.explotacion.sb.model.Alertas addAlertas(
		avanis.tu.explotacion.sb.model.Alertas alertas) {

		return _alertasLocalService.addAlertas(alertas);
	}

	@Override
	public avanis.tu.explotacion.sb.model.Alertas createAlerta(
		String externalReferenceCode, String desciption, boolean readed,
		long explotacionId, String phenomenom, long userId, String end,
		String start, String risk, String scope, String probability) {

		return _alertasLocalService.createAlerta(
			externalReferenceCode, desciption, readed, explotacionId,
			phenomenom, userId, end, start, risk, scope, probability);
	}

	/**
	 * Creates a new alertas with the primary key. Does not add the alertas to the database.
	 *
	 * @param alertaId the primary key for the new alertas
	 * @return the new alertas
	 */
	@Override
	public avanis.tu.explotacion.sb.model.Alertas createAlertas(long alertaId) {
		return _alertasLocalService.createAlertas(alertaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _alertasLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public avanis.tu.explotacion.sb.model.Alertas deleteAlerta(
			String externalReferenceCode, String description, boolean readed,
			long explotacionId, String phenomenom, long userId, String end,
			String start, String risk, String scope, String probability)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _alertasLocalService.deleteAlerta(
			externalReferenceCode, description, readed, explotacionId,
			phenomenom, userId, end, start, risk, scope, probability);
	}

	/**
	 * Deletes the alertas from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AlertasLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param alertas the alertas
	 * @return the alertas that was removed
	 */
	@Override
	public avanis.tu.explotacion.sb.model.Alertas deleteAlertas(
		avanis.tu.explotacion.sb.model.Alertas alertas) {

		return _alertasLocalService.deleteAlertas(alertas);
	}

	/**
	 * Deletes the alertas with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AlertasLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param alertaId the primary key of the alertas
	 * @return the alertas that was removed
	 * @throws PortalException if a alertas with the primary key could not be found
	 */
	@Override
	public avanis.tu.explotacion.sb.model.Alertas deleteAlertas(long alertaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _alertasLocalService.deleteAlertas(alertaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _alertasLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _alertasLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _alertasLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _alertasLocalService.dynamicQuery();
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

		return _alertasLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.tu.explotacion.sb.model.impl.AlertasModelImpl</code>.
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

		return _alertasLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.tu.explotacion.sb.model.impl.AlertasModelImpl</code>.
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

		return _alertasLocalService.dynamicQuery(
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

		return _alertasLocalService.dynamicQueryCount(dynamicQuery);
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

		return _alertasLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public avanis.tu.explotacion.sb.model.Alertas fetchAlertas(long alertaId) {
		return _alertasLocalService.fetchAlertas(alertaId);
	}

	@Override
	public java.util.List<avanis.tu.explotacion.sb.model.Alertas> findByUserId(
		long userId) {

		return _alertasLocalService.findByUserId(userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _alertasLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the alertas with the primary key.
	 *
	 * @param alertaId the primary key of the alertas
	 * @return the alertas
	 * @throws PortalException if a alertas with the primary key could not be found
	 */
	@Override
	public avanis.tu.explotacion.sb.model.Alertas getAlertas(long alertaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _alertasLocalService.getAlertas(alertaId);
	}

	/**
	 * Returns a range of all the alertases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.tu.explotacion.sb.model.impl.AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @return the range of alertases
	 */
	@Override
	public java.util.List<avanis.tu.explotacion.sb.model.Alertas> getAlertases(
		int start, int end) {

		return _alertasLocalService.getAlertases(start, end);
	}

	/**
	 * Returns the number of alertases.
	 *
	 * @return the number of alertases
	 */
	@Override
	public int getAlertasesCount() {
		return _alertasLocalService.getAlertasesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _alertasLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _alertasLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _alertasLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the alertas in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AlertasLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param alertas the alertas
	 * @return the alertas that was updated
	 */
	@Override
	public avanis.tu.explotacion.sb.model.Alertas updateAlertas(
		avanis.tu.explotacion.sb.model.Alertas alertas) {

		return _alertasLocalService.updateAlertas(alertas);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _alertasLocalService.getBasePersistence();
	}

	@Override
	public AlertasLocalService getWrappedService() {
		return _alertasLocalService;
	}

	@Override
	public void setWrappedService(AlertasLocalService alertasLocalService) {
		_alertasLocalService = alertasLocalService;
	}

	private AlertasLocalService _alertasLocalService;

}