/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.tu.explotacion.sb.service;

import avanis.tu.explotacion.sb.model.Explotacion;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Explotacion. This utility wraps
 * <code>avanis.tu.explotacion.sb.service.impl.ExplotacionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ExplotacionLocalService
 * @generated
 */
public class ExplotacionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>avanis.tu.explotacion.sb.service.impl.ExplotacionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Explotacion addExplotacion() {
		return getService().addExplotacion();
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
	public static Explotacion addExplotacion(Explotacion explotacion) {
		return getService().addExplotacion(explotacion);
	}

	public static Integer countByUserId(long userId) {
		return getService().countByUserId(userId);
	}

	/**
	 * Creates a new explotacion with the primary key. Does not add the explotacion to the database.
	 *
	 * @param explotacionId the primary key for the new explotacion
	 * @return the new explotacion
	 */
	public static Explotacion createExplotacion(long explotacionId) {
		return getService().createExplotacion(explotacionId);
	}

	public static Explotacion createOrUpdate(
			long explotacionId, String externalReferenceCode, String provincia,
			Double longitude, int height, String location, String name,
			Double latitude, String meteoredid, int size, String sizeUnit,
			boolean isMain, boolean allowNotifications,
			com.liferay.portal.kernel.model.User user, long[] categories,
			boolean readed)
		throws PortalException {

		return getService().createOrUpdate(
			explotacionId, externalReferenceCode, provincia, longitude, height,
			location, name, latitude, meteoredid, size, sizeUnit, isMain,
			allowNotifications, user, categories, readed);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static Explotacion deleteExplotacion(Explotacion explotacion) {
		return getService().deleteExplotacion(explotacion);
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
	public static Explotacion deleteExplotacion(long explotacionId)
		throws PortalException {

		return getService().deleteExplotacion(explotacionId);
	}

	public static void deleteExplotacion(
			long explotacionId, com.liferay.portal.kernel.model.User principal)
		throws PortalException {

		getService().deleteExplotacion(explotacionId, principal);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.tu.explotacion.sb.model.impl.ExplotacionModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.tu.explotacion.sb.model.impl.ExplotacionModelImpl</code>.
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

	public static Explotacion fetchExplotacion(long explotacionId) {
		return getService().fetchExplotacion(explotacionId);
	}

	public static Explotacion findByExternalCodeReferenceAndUser(
			String externalCodeReference, long userId)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getService().findByExternalCodeReferenceAndUser(
			externalCodeReference, userId);
	}

	public static Explotacion findByIdAndUserId(long explotacionId, long userId)
		throws avanis.tu.explotacion.sb.exception.NoSuchExplotacionException {

		return getService().findByIdAndUserId(explotacionId, userId);
	}

	public static List<Explotacion> findByUserId(long userId) {
		return getService().findByUserId(userId);
	}

	public static List<Explotacion> findByUserIdReaded(
		long userId, boolean readed) {

		return getService().findByUserIdReaded(userId, readed);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the explotacion with the primary key.
	 *
	 * @param explotacionId the primary key of the explotacion
	 * @return the explotacion
	 * @throws PortalException if a explotacion with the primary key could not be found
	 */
	public static Explotacion getExplotacion(long explotacionId)
		throws PortalException {

		return getService().getExplotacion(explotacionId);
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
	public static List<Explotacion> getExplotacions(int start, int end) {
		return getService().getExplotacions(start, end);
	}

	/**
	 * Returns the number of explotacions.
	 *
	 * @return the number of explotacions
	 */
	public static int getExplotacionsCount() {
		return getService().getExplotacionsCount();
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

	public static void setIsMain(
		long explotacionId, long userId, boolean isMain) {

		getService().setIsMain(explotacionId, userId, isMain);
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
	public static Explotacion updateExplotacion(Explotacion explotacion) {
		return getService().updateExplotacion(explotacion);
	}

	public static ExplotacionLocalService getService() {
		return _service;
	}

	public static void setService(ExplotacionLocalService service) {
		_service = service;
	}

	private static volatile ExplotacionLocalService _service;

}