/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service.persistence;

import avanis.calendarbooking.sb.model.BookingAgenda;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the booking agenda service. This utility wraps <code>avanis.calendarbooking.sb.service.persistence.impl.BookingAgendaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookingAgendaPersistence
 * @generated
 */
public class BookingAgendaUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(BookingAgenda bookingAgenda) {
		getPersistence().clearCache(bookingAgenda);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, BookingAgenda> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BookingAgenda> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BookingAgenda> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BookingAgenda> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BookingAgenda> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BookingAgenda update(BookingAgenda bookingAgenda) {
		return getPersistence().update(bookingAgenda);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BookingAgenda update(
		BookingAgenda bookingAgenda, ServiceContext serviceContext) {

		return getPersistence().update(bookingAgenda, serviceContext);
	}

	/**
	 * Returns all the booking agendas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching booking agendas
	 */
	public static List<BookingAgenda> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the booking agendas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @return the range of matching booking agendas
	 */
	public static List<BookingAgenda> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the booking agendas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking agendas
	 */
	public static List<BookingAgenda> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BookingAgenda> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the booking agendas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching booking agendas
	 */
	public static List<BookingAgenda> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BookingAgenda> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first booking agenda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	public static BookingAgenda findByUuid_First(
			String uuid, OrderByComparator<BookingAgenda> orderByComparator)
		throws avanis.calendarbooking.sb.exception.
			NoSuchBookingAgendaException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first booking agenda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	public static BookingAgenda fetchByUuid_First(
		String uuid, OrderByComparator<BookingAgenda> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last booking agenda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	public static BookingAgenda findByUuid_Last(
			String uuid, OrderByComparator<BookingAgenda> orderByComparator)
		throws avanis.calendarbooking.sb.exception.
			NoSuchBookingAgendaException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last booking agenda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	public static BookingAgenda fetchByUuid_Last(
		String uuid, OrderByComparator<BookingAgenda> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the booking agendas before and after the current booking agenda in the ordered set where uuid = &#63;.
	 *
	 * @param calendarBookingAgendaId the primary key of the current booking agenda
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking agenda
	 * @throws NoSuchBookingAgendaException if a booking agenda with the primary key could not be found
	 */
	public static BookingAgenda[] findByUuid_PrevAndNext(
			long calendarBookingAgendaId, String uuid,
			OrderByComparator<BookingAgenda> orderByComparator)
		throws avanis.calendarbooking.sb.exception.
			NoSuchBookingAgendaException {

		return getPersistence().findByUuid_PrevAndNext(
			calendarBookingAgendaId, uuid, orderByComparator);
	}

	/**
	 * Removes all the booking agendas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of booking agendas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching booking agendas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the booking agenda where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBookingAgendaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	public static BookingAgenda findByUUID_G(String uuid, long groupId)
		throws avanis.calendarbooking.sb.exception.
			NoSuchBookingAgendaException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the booking agenda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	public static BookingAgenda fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the booking agenda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	public static BookingAgenda fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the booking agenda where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the booking agenda that was removed
	 */
	public static BookingAgenda removeByUUID_G(String uuid, long groupId)
		throws avanis.calendarbooking.sb.exception.
			NoSuchBookingAgendaException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of booking agendas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching booking agendas
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the booking agendas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching booking agendas
	 */
	public static List<BookingAgenda> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the booking agendas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @return the range of matching booking agendas
	 */
	public static List<BookingAgenda> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the booking agendas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking agendas
	 */
	public static List<BookingAgenda> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BookingAgenda> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the booking agendas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching booking agendas
	 */
	public static List<BookingAgenda> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BookingAgenda> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first booking agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	public static BookingAgenda findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<BookingAgenda> orderByComparator)
		throws avanis.calendarbooking.sb.exception.
			NoSuchBookingAgendaException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first booking agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	public static BookingAgenda fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<BookingAgenda> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last booking agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	public static BookingAgenda findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<BookingAgenda> orderByComparator)
		throws avanis.calendarbooking.sb.exception.
			NoSuchBookingAgendaException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last booking agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	public static BookingAgenda fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<BookingAgenda> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the booking agendas before and after the current booking agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param calendarBookingAgendaId the primary key of the current booking agenda
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking agenda
	 * @throws NoSuchBookingAgendaException if a booking agenda with the primary key could not be found
	 */
	public static BookingAgenda[] findByUuid_C_PrevAndNext(
			long calendarBookingAgendaId, String uuid, long companyId,
			OrderByComparator<BookingAgenda> orderByComparator)
		throws avanis.calendarbooking.sb.exception.
			NoSuchBookingAgendaException {

		return getPersistence().findByUuid_C_PrevAndNext(
			calendarBookingAgendaId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the booking agendas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of booking agendas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching booking agendas
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the booking agendas where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @return the matching booking agendas
	 */
	public static List<BookingAgenda> findBycalendarBookingId(
		long calendarBookingId) {

		return getPersistence().findBycalendarBookingId(calendarBookingId);
	}

	/**
	 * Returns a range of all the booking agendas where calendarBookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @return the range of matching booking agendas
	 */
	public static List<BookingAgenda> findBycalendarBookingId(
		long calendarBookingId, int start, int end) {

		return getPersistence().findBycalendarBookingId(
			calendarBookingId, start, end);
	}

	/**
	 * Returns an ordered range of all the booking agendas where calendarBookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking agendas
	 */
	public static List<BookingAgenda> findBycalendarBookingId(
		long calendarBookingId, int start, int end,
		OrderByComparator<BookingAgenda> orderByComparator) {

		return getPersistence().findBycalendarBookingId(
			calendarBookingId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the booking agendas where calendarBookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching booking agendas
	 */
	public static List<BookingAgenda> findBycalendarBookingId(
		long calendarBookingId, int start, int end,
		OrderByComparator<BookingAgenda> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBycalendarBookingId(
			calendarBookingId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first booking agenda in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	public static BookingAgenda findBycalendarBookingId_First(
			long calendarBookingId,
			OrderByComparator<BookingAgenda> orderByComparator)
		throws avanis.calendarbooking.sb.exception.
			NoSuchBookingAgendaException {

		return getPersistence().findBycalendarBookingId_First(
			calendarBookingId, orderByComparator);
	}

	/**
	 * Returns the first booking agenda in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	public static BookingAgenda fetchBycalendarBookingId_First(
		long calendarBookingId,
		OrderByComparator<BookingAgenda> orderByComparator) {

		return getPersistence().fetchBycalendarBookingId_First(
			calendarBookingId, orderByComparator);
	}

	/**
	 * Returns the last booking agenda in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	public static BookingAgenda findBycalendarBookingId_Last(
			long calendarBookingId,
			OrderByComparator<BookingAgenda> orderByComparator)
		throws avanis.calendarbooking.sb.exception.
			NoSuchBookingAgendaException {

		return getPersistence().findBycalendarBookingId_Last(
			calendarBookingId, orderByComparator);
	}

	/**
	 * Returns the last booking agenda in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	public static BookingAgenda fetchBycalendarBookingId_Last(
		long calendarBookingId,
		OrderByComparator<BookingAgenda> orderByComparator) {

		return getPersistence().fetchBycalendarBookingId_Last(
			calendarBookingId, orderByComparator);
	}

	/**
	 * Returns the booking agendas before and after the current booking agenda in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingAgendaId the primary key of the current booking agenda
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking agenda
	 * @throws NoSuchBookingAgendaException if a booking agenda with the primary key could not be found
	 */
	public static BookingAgenda[] findBycalendarBookingId_PrevAndNext(
			long calendarBookingAgendaId, long calendarBookingId,
			OrderByComparator<BookingAgenda> orderByComparator)
		throws avanis.calendarbooking.sb.exception.
			NoSuchBookingAgendaException {

		return getPersistence().findBycalendarBookingId_PrevAndNext(
			calendarBookingAgendaId, calendarBookingId, orderByComparator);
	}

	/**
	 * Removes all the booking agendas where calendarBookingId = &#63; from the database.
	 *
	 * @param calendarBookingId the calendar booking ID
	 */
	public static void removeBycalendarBookingId(long calendarBookingId) {
		getPersistence().removeBycalendarBookingId(calendarBookingId);
	}

	/**
	 * Returns the number of booking agendas where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @return the number of matching booking agendas
	 */
	public static int countBycalendarBookingId(long calendarBookingId) {
		return getPersistence().countBycalendarBookingId(calendarBookingId);
	}

	/**
	 * Returns all the booking agendas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching booking agendas
	 */
	public static List<BookingAgenda> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

	/**
	 * Returns a range of all the booking agendas where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @return the range of matching booking agendas
	 */
	public static List<BookingAgenda> findByuserId(
		long userId, int start, int end) {

		return getPersistence().findByuserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the booking agendas where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking agendas
	 */
	public static List<BookingAgenda> findByuserId(
		long userId, int start, int end,
		OrderByComparator<BookingAgenda> orderByComparator) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the booking agendas where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching booking agendas
	 */
	public static List<BookingAgenda> findByuserId(
		long userId, int start, int end,
		OrderByComparator<BookingAgenda> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first booking agenda in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	public static BookingAgenda findByuserId_First(
			long userId, OrderByComparator<BookingAgenda> orderByComparator)
		throws avanis.calendarbooking.sb.exception.
			NoSuchBookingAgendaException {

		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first booking agenda in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	public static BookingAgenda fetchByuserId_First(
		long userId, OrderByComparator<BookingAgenda> orderByComparator) {

		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last booking agenda in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	public static BookingAgenda findByuserId_Last(
			long userId, OrderByComparator<BookingAgenda> orderByComparator)
		throws avanis.calendarbooking.sb.exception.
			NoSuchBookingAgendaException {

		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last booking agenda in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	public static BookingAgenda fetchByuserId_Last(
		long userId, OrderByComparator<BookingAgenda> orderByComparator) {

		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the booking agendas before and after the current booking agenda in the ordered set where userId = &#63;.
	 *
	 * @param calendarBookingAgendaId the primary key of the current booking agenda
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking agenda
	 * @throws NoSuchBookingAgendaException if a booking agenda with the primary key could not be found
	 */
	public static BookingAgenda[] findByuserId_PrevAndNext(
			long calendarBookingAgendaId, long userId,
			OrderByComparator<BookingAgenda> orderByComparator)
		throws avanis.calendarbooking.sb.exception.
			NoSuchBookingAgendaException {

		return getPersistence().findByuserId_PrevAndNext(
			calendarBookingAgendaId, userId, orderByComparator);
	}

	/**
	 * Removes all the booking agendas where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of booking agendas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching booking agendas
	 */
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Caches the booking agenda in the entity cache if it is enabled.
	 *
	 * @param bookingAgenda the booking agenda
	 */
	public static void cacheResult(BookingAgenda bookingAgenda) {
		getPersistence().cacheResult(bookingAgenda);
	}

	/**
	 * Caches the booking agendas in the entity cache if it is enabled.
	 *
	 * @param bookingAgendas the booking agendas
	 */
	public static void cacheResult(List<BookingAgenda> bookingAgendas) {
		getPersistence().cacheResult(bookingAgendas);
	}

	/**
	 * Creates a new booking agenda with the primary key. Does not add the booking agenda to the database.
	 *
	 * @param calendarBookingAgendaId the primary key for the new booking agenda
	 * @return the new booking agenda
	 */
	public static BookingAgenda create(long calendarBookingAgendaId) {
		return getPersistence().create(calendarBookingAgendaId);
	}

	/**
	 * Removes the booking agenda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param calendarBookingAgendaId the primary key of the booking agenda
	 * @return the booking agenda that was removed
	 * @throws NoSuchBookingAgendaException if a booking agenda with the primary key could not be found
	 */
	public static BookingAgenda remove(long calendarBookingAgendaId)
		throws avanis.calendarbooking.sb.exception.
			NoSuchBookingAgendaException {

		return getPersistence().remove(calendarBookingAgendaId);
	}

	public static BookingAgenda updateImpl(BookingAgenda bookingAgenda) {
		return getPersistence().updateImpl(bookingAgenda);
	}

	/**
	 * Returns the booking agenda with the primary key or throws a <code>NoSuchBookingAgendaException</code> if it could not be found.
	 *
	 * @param calendarBookingAgendaId the primary key of the booking agenda
	 * @return the booking agenda
	 * @throws NoSuchBookingAgendaException if a booking agenda with the primary key could not be found
	 */
	public static BookingAgenda findByPrimaryKey(long calendarBookingAgendaId)
		throws avanis.calendarbooking.sb.exception.
			NoSuchBookingAgendaException {

		return getPersistence().findByPrimaryKey(calendarBookingAgendaId);
	}

	/**
	 * Returns the booking agenda with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param calendarBookingAgendaId the primary key of the booking agenda
	 * @return the booking agenda, or <code>null</code> if a booking agenda with the primary key could not be found
	 */
	public static BookingAgenda fetchByPrimaryKey(
		long calendarBookingAgendaId) {

		return getPersistence().fetchByPrimaryKey(calendarBookingAgendaId);
	}

	/**
	 * Returns all the booking agendas.
	 *
	 * @return the booking agendas
	 */
	public static List<BookingAgenda> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the booking agendas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @return the range of booking agendas
	 */
	public static List<BookingAgenda> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the booking agendas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of booking agendas
	 */
	public static List<BookingAgenda> findAll(
		int start, int end,
		OrderByComparator<BookingAgenda> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the booking agendas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of booking agendas
	 */
	public static List<BookingAgenda> findAll(
		int start, int end, OrderByComparator<BookingAgenda> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the booking agendas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of booking agendas.
	 *
	 * @return the number of booking agendas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BookingAgendaPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(BookingAgendaPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile BookingAgendaPersistence _persistence;

}