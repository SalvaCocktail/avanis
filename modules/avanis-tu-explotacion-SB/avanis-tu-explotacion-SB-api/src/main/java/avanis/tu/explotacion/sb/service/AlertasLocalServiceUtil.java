/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.tu.explotacion.sb.service;

import avanis.tu.explotacion.sb.model.Alertas;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Alertas. This utility wraps
 * <code>avanis.tu.explotacion.sb.service.impl.AlertasLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AlertasLocalService
 * @generated
 */
public class AlertasLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>avanis.tu.explotacion.sb.service.impl.AlertasLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Alertas addAlertas() {
		return getService().addAlertas();
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
	public static Alertas addAlertas(Alertas alertas) {
		return getService().addAlertas(alertas);
	}

	public static Alertas createAlerta(
		String externalReferenceCode, String desciption, boolean readed,
		long explotacionId, String phenomenom, long userId, String end,
		String start, String risk, String scope, String probability) {

		return getService().createAlerta(
			externalReferenceCode, desciption, readed, explotacionId,
			phenomenom, userId, end, start, risk, scope, probability);
	}

	/**
	 * Creates a new alertas with the primary key. Does not add the alertas to the database.
	 *
	 * @param alertaId the primary key for the new alertas
	 * @return the new alertas
	 */
	public static Alertas createAlertas(long alertaId) {
		return getService().createAlertas(alertaId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static Alertas deleteAlerta(
			String externalReferenceCode, String description, boolean readed,
			long explotacionId, String phenomenom, long userId, String end,
			String start, String risk, String scope, String probability)
		throws PortalException {

		return getService().deleteAlerta(
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
	public static Alertas deleteAlertas(Alertas alertas) {
		return getService().deleteAlertas(alertas);
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
	public static Alertas deleteAlertas(long alertaId) throws PortalException {
		return getService().deleteAlertas(alertaId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Alertas fetchAlertas(long alertaId) {
		return getService().fetchAlertas(alertaId);
	}

	public static List<Alertas> findByUserId(long userId) {
		return getService().findByUserId(userId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the alertas with the primary key.
	 *
	 * @param alertaId the primary key of the alertas
	 * @return the alertas
	 * @throws PortalException if a alertas with the primary key could not be found
	 */
	public static Alertas getAlertas(long alertaId) throws PortalException {
		return getService().getAlertas(alertaId);
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
	public static List<Alertas> getAlertases(int start, int end) {
		return getService().getAlertases(start, end);
	}

	/**
	 * Returns the number of alertases.
	 *
	 * @return the number of alertases
	 */
	public static int getAlertasesCount() {
		return getService().getAlertasesCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static Alertas updateAlertas(Alertas alertas) {
		return getService().updateAlertas(alertas);
	}

	public static AlertasLocalService getService() {
		return _service;
	}

	public static void setService(AlertasLocalService service) {
		_service = service;
	}

	private static volatile AlertasLocalService _service;

}