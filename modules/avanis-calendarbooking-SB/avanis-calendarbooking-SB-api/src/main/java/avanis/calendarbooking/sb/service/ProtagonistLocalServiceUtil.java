/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service;

import avanis.calendarbooking.sb.model.Protagonist;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Protagonist. This utility wraps
 * <code>avanis.calendarbooking.sb.service.impl.ProtagonistLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProtagonistLocalService
 * @generated
 */
public class ProtagonistLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>avanis.calendarbooking.sb.service.impl.ProtagonistLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Protagonist addProtagonist(
			long userId, long groupId, long calendarBookingId, String name,
			String lastName, String profession, String bio, String portraitUrl,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addProtagonist(
			userId, groupId, calendarBookingId, name, lastName, profession, bio,
			portraitUrl, serviceContext);
	}

	/**
	 * Adds the protagonist to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProtagonistLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param protagonist the protagonist
	 * @return the protagonist that was added
	 */
	public static Protagonist addProtagonist(Protagonist protagonist) {
		return getService().addProtagonist(protagonist);
	}

	public static Integer countProtagonistsByCalendarBookingId(
		long calendarBookingId) {

		return getService().countProtagonistsByCalendarBookingId(
			calendarBookingId);
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
	 * Creates a new protagonist with the primary key. Does not add the protagonist to the database.
	 *
	 * @param protagonistId the primary key for the new protagonist
	 * @return the new protagonist
	 */
	public static Protagonist createProtagonist(long protagonistId) {
		return getService().createProtagonist(protagonistId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the protagonist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProtagonistLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param protagonistId the primary key of the protagonist
	 * @return the protagonist that was removed
	 * @throws PortalException if a protagonist with the primary key could not be found
	 */
	public static Protagonist deleteProtagonist(long protagonistId)
		throws PortalException {

		return getService().deleteProtagonist(protagonistId);
	}

	/**
	 * Deletes the protagonist from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProtagonistLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param protagonist the protagonist
	 * @return the protagonist that was removed
	 */
	public static Protagonist deleteProtagonist(Protagonist protagonist) {
		return getService().deleteProtagonist(protagonist);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.calendarbooking.sb.model.impl.ProtagonistModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.calendarbooking.sb.model.impl.ProtagonistModelImpl</code>.
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

	public static Protagonist fetchProtagonist(long protagonistId) {
		return getService().fetchProtagonist(protagonistId);
	}

	/**
	 * Returns the protagonist matching the UUID and group.
	 *
	 * @param uuid the protagonist's UUID
	 * @param groupId the primary key of the group
	 * @return the matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	public static Protagonist fetchProtagonistByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchProtagonistByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
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
	 * Returns the protagonist with the primary key.
	 *
	 * @param protagonistId the primary key of the protagonist
	 * @return the protagonist
	 * @throws PortalException if a protagonist with the primary key could not be found
	 */
	public static Protagonist getProtagonist(long protagonistId)
		throws PortalException {

		return getService().getProtagonist(protagonistId);
	}

	/**
	 * Returns the protagonist matching the UUID and group.
	 *
	 * @param uuid the protagonist's UUID
	 * @param groupId the primary key of the group
	 * @return the matching protagonist
	 * @throws PortalException if a matching protagonist could not be found
	 */
	public static Protagonist getProtagonistByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getProtagonistByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the protagonists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.calendarbooking.sb.model.impl.ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @return the range of protagonists
	 */
	public static List<Protagonist> getProtagonists(int start, int end) {
		return getService().getProtagonists(start, end);
	}

	public static List<Protagonist> getProtagonistsByCalendarBookingId(
		long calendarBookingId) {

		return getService().getProtagonistsByCalendarBookingId(
			calendarBookingId);
	}

	public static List<Protagonist> getProtagonistsByCalendarBookingId(
		long calendarBookingId, int start, int end) {

		return getService().getProtagonistsByCalendarBookingId(
			calendarBookingId, start, end);
	}

	public static List<Protagonist> getProtagonistsByUserId(long userId) {
		return getService().getProtagonistsByUserId(userId);
	}

	/**
	 * Returns all the protagonists matching the UUID and company.
	 *
	 * @param uuid the UUID of the protagonists
	 * @param companyId the primary key of the company
	 * @return the matching protagonists, or an empty list if no matches were found
	 */
	public static List<Protagonist> getProtagonistsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getProtagonistsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of protagonists matching the UUID and company.
	 *
	 * @param uuid the UUID of the protagonists
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching protagonists, or an empty list if no matches were found
	 */
	public static List<Protagonist> getProtagonistsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Protagonist> orderByComparator) {

		return getService().getProtagonistsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of protagonists.
	 *
	 * @return the number of protagonists
	 */
	public static int getProtagonistsCount() {
		return getService().getProtagonistsCount();
	}

	public static Protagonist updateProtagonist(
			long protagonistId, String name, String lastName, String profession,
			String bio, long portraitId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateProtagonist(
			protagonistId, name, lastName, profession, bio, portraitId,
			serviceContext);
	}

	/**
	 * Updates the protagonist in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProtagonistLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param protagonist the protagonist
	 * @return the protagonist that was updated
	 */
	public static Protagonist updateProtagonist(Protagonist protagonist) {
		return getService().updateProtagonist(protagonist);
	}

	public static ProtagonistLocalService getService() {
		return _service;
	}

	public static void setService(ProtagonistLocalService service) {
		_service = service;
	}

	private static volatile ProtagonistLocalService _service;

}