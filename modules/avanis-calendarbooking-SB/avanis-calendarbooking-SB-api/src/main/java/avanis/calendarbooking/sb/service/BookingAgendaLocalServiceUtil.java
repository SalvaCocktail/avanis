/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service;

import avanis.calendarbooking.sb.model.BookingAgenda;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for BookingAgenda. This utility wraps
 * <code>avanis.calendarbooking.sb.service.impl.BookingAgendaLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BookingAgendaLocalService
 * @generated
 */
public class BookingAgendaLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>avanis.calendarbooking.sb.service.impl.BookingAgendaLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the booking agenda to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookingAgendaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookingAgenda the booking agenda
	 * @return the booking agenda that was added
	 */
	public static BookingAgenda addBookingAgenda(BookingAgenda bookingAgenda) {
		return getService().addBookingAgenda(bookingAgenda);
	}

	public static BookingAgenda addBookingAgenda(
			long userId, long groupId, long day, long startHour, long endHour,
			String title, String description, long calendarBookingId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addBookingAgenda(
			userId, groupId, day, startHour, endHour, title, description,
			calendarBookingId, serviceContext);
	}

	/**
	 * Creates a new booking agenda with the primary key. Does not add the booking agenda to the database.
	 *
	 * @param calendarBookingAgendaId the primary key for the new booking agenda
	 * @return the new booking agenda
	 */
	public static BookingAgenda createBookingAgenda(
		long calendarBookingAgendaId) {

		return getService().createBookingAgenda(calendarBookingAgendaId);
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
	 * Deletes the booking agenda from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookingAgendaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookingAgenda the booking agenda
	 * @return the booking agenda that was removed
	 */
	public static BookingAgenda deleteBookingAgenda(
		BookingAgenda bookingAgenda) {

		return getService().deleteBookingAgenda(bookingAgenda);
	}

	/**
	 * Deletes the booking agenda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookingAgendaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param calendarBookingAgendaId the primary key of the booking agenda
	 * @return the booking agenda that was removed
	 * @throws PortalException if a booking agenda with the primary key could not be found
	 */
	public static BookingAgenda deleteBookingAgenda(
			long calendarBookingAgendaId)
		throws PortalException {

		return getService().deleteBookingAgenda(calendarBookingAgendaId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.calendarbooking.sb.model.impl.BookingAgendaModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.calendarbooking.sb.model.impl.BookingAgendaModelImpl</code>.
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

	public static BookingAgenda fetchBookingAgenda(
		long calendarBookingAgendaId) {

		return getService().fetchBookingAgenda(calendarBookingAgendaId);
	}

	/**
	 * Returns the booking agenda matching the UUID and group.
	 *
	 * @param uuid the booking agenda's UUID
	 * @param groupId the primary key of the group
	 * @return the matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	public static BookingAgenda fetchBookingAgendaByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchBookingAgendaByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the booking agenda with the primary key.
	 *
	 * @param calendarBookingAgendaId the primary key of the booking agenda
	 * @return the booking agenda
	 * @throws PortalException if a booking agenda with the primary key could not be found
	 */
	public static BookingAgenda getBookingAgenda(long calendarBookingAgendaId)
		throws PortalException {

		return getService().getBookingAgenda(calendarBookingAgendaId);
	}

	/**
	 * Returns the booking agenda matching the UUID and group.
	 *
	 * @param uuid the booking agenda's UUID
	 * @param groupId the primary key of the group
	 * @return the matching booking agenda
	 * @throws PortalException if a matching booking agenda could not be found
	 */
	public static BookingAgenda getBookingAgendaByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getBookingAgendaByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the booking agendas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.calendarbooking.sb.model.impl.BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @return the range of booking agendas
	 */
	public static List<BookingAgenda> getBookingAgendas(int start, int end) {
		return getService().getBookingAgendas(start, end);
	}

	public static List<BookingAgenda> getBookingAgendasByCalendarBookingId(
		long calendarBookingId) {

		return getService().getBookingAgendasByCalendarBookingId(
			calendarBookingId);
	}

	public static List<BookingAgenda> getBookingAgendasByUserId(long userId) {
		return getService().getBookingAgendasByUserId(userId);
	}

	/**
	 * Returns all the booking agendas matching the UUID and company.
	 *
	 * @param uuid the UUID of the booking agendas
	 * @param companyId the primary key of the company
	 * @return the matching booking agendas, or an empty list if no matches were found
	 */
	public static List<BookingAgenda> getBookingAgendasByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getBookingAgendasByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of booking agendas matching the UUID and company.
	 *
	 * @param uuid the UUID of the booking agendas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching booking agendas, or an empty list if no matches were found
	 */
	public static List<BookingAgenda> getBookingAgendasByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BookingAgenda> orderByComparator) {

		return getService().getBookingAgendasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of booking agendas.
	 *
	 * @return the number of booking agendas
	 */
	public static int getBookingAgendasCount() {
		return getService().getBookingAgendasCount();
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
	 * Updates the booking agenda in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookingAgendaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookingAgenda the booking agenda
	 * @return the booking agenda that was updated
	 */
	public static BookingAgenda updateBookingAgenda(
		BookingAgenda bookingAgenda) {

		return getService().updateBookingAgenda(bookingAgenda);
	}

	public static BookingAgenda updateBookingAgenda(
			long bookingAgendaId, long day, long startHour, long endHour,
			String title, String description, long calendarBookingId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateBookingAgenda(
			bookingAgendaId, day, startHour, endHour, title, description,
			calendarBookingId, serviceContext);
	}

	public static BookingAgendaLocalService getService() {
		return _service;
	}

	public static void setService(BookingAgendaLocalService service) {
		_service = service;
	}

	private static volatile BookingAgendaLocalService _service;

}