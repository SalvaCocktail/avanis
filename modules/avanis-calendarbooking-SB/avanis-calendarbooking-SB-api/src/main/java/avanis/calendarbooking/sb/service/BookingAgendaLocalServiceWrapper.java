/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link BookingAgendaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BookingAgendaLocalService
 * @generated
 */
public class BookingAgendaLocalServiceWrapper
	implements BookingAgendaLocalService,
			   ServiceWrapper<BookingAgendaLocalService> {

	public BookingAgendaLocalServiceWrapper() {
		this(null);
	}

	public BookingAgendaLocalServiceWrapper(
		BookingAgendaLocalService bookingAgendaLocalService) {

		_bookingAgendaLocalService = bookingAgendaLocalService;
	}

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
	@Override
	public avanis.calendarbooking.sb.model.BookingAgenda addBookingAgenda(
		avanis.calendarbooking.sb.model.BookingAgenda bookingAgenda) {

		return _bookingAgendaLocalService.addBookingAgenda(bookingAgenda);
	}

	@Override
	public avanis.calendarbooking.sb.model.BookingAgenda addBookingAgenda(
			long userId, long groupId, long day, long startHour, long endHour,
			String title, String description, long calendarBookingId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookingAgendaLocalService.addBookingAgenda(
			userId, groupId, day, startHour, endHour, title, description,
			calendarBookingId, serviceContext);
	}

	/**
	 * Creates a new booking agenda with the primary key. Does not add the booking agenda to the database.
	 *
	 * @param calendarBookingAgendaId the primary key for the new booking agenda
	 * @return the new booking agenda
	 */
	@Override
	public avanis.calendarbooking.sb.model.BookingAgenda createBookingAgenda(
		long calendarBookingAgendaId) {

		return _bookingAgendaLocalService.createBookingAgenda(
			calendarBookingAgendaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookingAgendaLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public avanis.calendarbooking.sb.model.BookingAgenda deleteBookingAgenda(
		avanis.calendarbooking.sb.model.BookingAgenda bookingAgenda) {

		return _bookingAgendaLocalService.deleteBookingAgenda(bookingAgenda);
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
	@Override
	public avanis.calendarbooking.sb.model.BookingAgenda deleteBookingAgenda(
			long calendarBookingAgendaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookingAgendaLocalService.deleteBookingAgenda(
			calendarBookingAgendaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookingAgendaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _bookingAgendaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _bookingAgendaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bookingAgendaLocalService.dynamicQuery();
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

		return _bookingAgendaLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _bookingAgendaLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _bookingAgendaLocalService.dynamicQuery(
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

		return _bookingAgendaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _bookingAgendaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public avanis.calendarbooking.sb.model.BookingAgenda fetchBookingAgenda(
		long calendarBookingAgendaId) {

		return _bookingAgendaLocalService.fetchBookingAgenda(
			calendarBookingAgendaId);
	}

	/**
	 * Returns the booking agenda matching the UUID and group.
	 *
	 * @param uuid the booking agenda's UUID
	 * @param groupId the primary key of the group
	 * @return the matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	@Override
	public avanis.calendarbooking.sb.model.BookingAgenda
		fetchBookingAgendaByUuidAndGroupId(String uuid, long groupId) {

		return _bookingAgendaLocalService.fetchBookingAgendaByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _bookingAgendaLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the booking agenda with the primary key.
	 *
	 * @param calendarBookingAgendaId the primary key of the booking agenda
	 * @return the booking agenda
	 * @throws PortalException if a booking agenda with the primary key could not be found
	 */
	@Override
	public avanis.calendarbooking.sb.model.BookingAgenda getBookingAgenda(
			long calendarBookingAgendaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookingAgendaLocalService.getBookingAgenda(
			calendarBookingAgendaId);
	}

	/**
	 * Returns the booking agenda matching the UUID and group.
	 *
	 * @param uuid the booking agenda's UUID
	 * @param groupId the primary key of the group
	 * @return the matching booking agenda
	 * @throws PortalException if a matching booking agenda could not be found
	 */
	@Override
	public avanis.calendarbooking.sb.model.BookingAgenda
			getBookingAgendaByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookingAgendaLocalService.getBookingAgendaByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<avanis.calendarbooking.sb.model.BookingAgenda>
		getBookingAgendas(int start, int end) {

		return _bookingAgendaLocalService.getBookingAgendas(start, end);
	}

	@Override
	public java.util.List<avanis.calendarbooking.sb.model.BookingAgenda>
		getBookingAgendasByCalendarBookingId(long calendarBookingId) {

		return _bookingAgendaLocalService.getBookingAgendasByCalendarBookingId(
			calendarBookingId);
	}

	@Override
	public java.util.List<avanis.calendarbooking.sb.model.BookingAgenda>
		getBookingAgendasByUserId(long userId) {

		return _bookingAgendaLocalService.getBookingAgendasByUserId(userId);
	}

	/**
	 * Returns all the booking agendas matching the UUID and company.
	 *
	 * @param uuid the UUID of the booking agendas
	 * @param companyId the primary key of the company
	 * @return the matching booking agendas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<avanis.calendarbooking.sb.model.BookingAgenda>
		getBookingAgendasByUuidAndCompanyId(String uuid, long companyId) {

		return _bookingAgendaLocalService.getBookingAgendasByUuidAndCompanyId(
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
	@Override
	public java.util.List<avanis.calendarbooking.sb.model.BookingAgenda>
		getBookingAgendasByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<avanis.calendarbooking.sb.model.BookingAgenda>
					orderByComparator) {

		return _bookingAgendaLocalService.getBookingAgendasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of booking agendas.
	 *
	 * @return the number of booking agendas
	 */
	@Override
	public int getBookingAgendasCount() {
		return _bookingAgendaLocalService.getBookingAgendasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _bookingAgendaLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _bookingAgendaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bookingAgendaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookingAgendaLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public avanis.calendarbooking.sb.model.BookingAgenda updateBookingAgenda(
		avanis.calendarbooking.sb.model.BookingAgenda bookingAgenda) {

		return _bookingAgendaLocalService.updateBookingAgenda(bookingAgenda);
	}

	@Override
	public avanis.calendarbooking.sb.model.BookingAgenda updateBookingAgenda(
			long bookingAgendaId, long day, long startHour, long endHour,
			String title, String description, long calendarBookingId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookingAgendaLocalService.updateBookingAgenda(
			bookingAgendaId, day, startHour, endHour, title, description,
			calendarBookingId, serviceContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _bookingAgendaLocalService.getBasePersistence();
	}

	@Override
	public BookingAgendaLocalService getWrappedService() {
		return _bookingAgendaLocalService;
	}

	@Override
	public void setWrappedService(
		BookingAgendaLocalService bookingAgendaLocalService) {

		_bookingAgendaLocalService = bookingAgendaLocalService;
	}

	private BookingAgendaLocalService _bookingAgendaLocalService;

}