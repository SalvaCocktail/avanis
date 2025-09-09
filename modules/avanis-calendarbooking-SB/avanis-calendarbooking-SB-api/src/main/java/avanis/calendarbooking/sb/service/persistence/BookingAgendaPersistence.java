/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service.persistence;

import avanis.calendarbooking.sb.exception.NoSuchBookingAgendaException;
import avanis.calendarbooking.sb.model.BookingAgenda;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the booking agenda service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookingAgendaUtil
 * @generated
 */
@ProviderType
public interface BookingAgendaPersistence
	extends BasePersistence<BookingAgenda> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BookingAgendaUtil} to access the booking agenda persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the booking agendas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching booking agendas
	 */
	public java.util.List<BookingAgenda> findByUuid(String uuid);

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
	public java.util.List<BookingAgenda> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<BookingAgenda> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
			orderByComparator);

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
	public java.util.List<BookingAgenda> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first booking agenda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	public BookingAgenda findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
				orderByComparator)
		throws NoSuchBookingAgendaException;

	/**
	 * Returns the first booking agenda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	public BookingAgenda fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
			orderByComparator);

	/**
	 * Returns the last booking agenda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	public BookingAgenda findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
				orderByComparator)
		throws NoSuchBookingAgendaException;

	/**
	 * Returns the last booking agenda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	public BookingAgenda fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
			orderByComparator);

	/**
	 * Returns the booking agendas before and after the current booking agenda in the ordered set where uuid = &#63;.
	 *
	 * @param calendarBookingAgendaId the primary key of the current booking agenda
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking agenda
	 * @throws NoSuchBookingAgendaException if a booking agenda with the primary key could not be found
	 */
	public BookingAgenda[] findByUuid_PrevAndNext(
			long calendarBookingAgendaId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
				orderByComparator)
		throws NoSuchBookingAgendaException;

	/**
	 * Removes all the booking agendas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of booking agendas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching booking agendas
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the booking agenda where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBookingAgendaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	public BookingAgenda findByUUID_G(String uuid, long groupId)
		throws NoSuchBookingAgendaException;

	/**
	 * Returns the booking agenda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	public BookingAgenda fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the booking agenda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	public BookingAgenda fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the booking agenda where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the booking agenda that was removed
	 */
	public BookingAgenda removeByUUID_G(String uuid, long groupId)
		throws NoSuchBookingAgendaException;

	/**
	 * Returns the number of booking agendas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching booking agendas
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the booking agendas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching booking agendas
	 */
	public java.util.List<BookingAgenda> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<BookingAgenda> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<BookingAgenda> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
			orderByComparator);

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
	public java.util.List<BookingAgenda> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first booking agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	public BookingAgenda findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
				orderByComparator)
		throws NoSuchBookingAgendaException;

	/**
	 * Returns the first booking agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	public BookingAgenda fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
			orderByComparator);

	/**
	 * Returns the last booking agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	public BookingAgenda findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
				orderByComparator)
		throws NoSuchBookingAgendaException;

	/**
	 * Returns the last booking agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	public BookingAgenda fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
			orderByComparator);

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
	public BookingAgenda[] findByUuid_C_PrevAndNext(
			long calendarBookingAgendaId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
				orderByComparator)
		throws NoSuchBookingAgendaException;

	/**
	 * Removes all the booking agendas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of booking agendas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching booking agendas
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the booking agendas where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @return the matching booking agendas
	 */
	public java.util.List<BookingAgenda> findBycalendarBookingId(
		long calendarBookingId);

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
	public java.util.List<BookingAgenda> findBycalendarBookingId(
		long calendarBookingId, int start, int end);

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
	public java.util.List<BookingAgenda> findBycalendarBookingId(
		long calendarBookingId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
			orderByComparator);

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
	public java.util.List<BookingAgenda> findBycalendarBookingId(
		long calendarBookingId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first booking agenda in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	public BookingAgenda findBycalendarBookingId_First(
			long calendarBookingId,
			com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
				orderByComparator)
		throws NoSuchBookingAgendaException;

	/**
	 * Returns the first booking agenda in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	public BookingAgenda fetchBycalendarBookingId_First(
		long calendarBookingId,
		com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
			orderByComparator);

	/**
	 * Returns the last booking agenda in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	public BookingAgenda findBycalendarBookingId_Last(
			long calendarBookingId,
			com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
				orderByComparator)
		throws NoSuchBookingAgendaException;

	/**
	 * Returns the last booking agenda in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	public BookingAgenda fetchBycalendarBookingId_Last(
		long calendarBookingId,
		com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
			orderByComparator);

	/**
	 * Returns the booking agendas before and after the current booking agenda in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingAgendaId the primary key of the current booking agenda
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking agenda
	 * @throws NoSuchBookingAgendaException if a booking agenda with the primary key could not be found
	 */
	public BookingAgenda[] findBycalendarBookingId_PrevAndNext(
			long calendarBookingAgendaId, long calendarBookingId,
			com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
				orderByComparator)
		throws NoSuchBookingAgendaException;

	/**
	 * Removes all the booking agendas where calendarBookingId = &#63; from the database.
	 *
	 * @param calendarBookingId the calendar booking ID
	 */
	public void removeBycalendarBookingId(long calendarBookingId);

	/**
	 * Returns the number of booking agendas where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @return the number of matching booking agendas
	 */
	public int countBycalendarBookingId(long calendarBookingId);

	/**
	 * Returns all the booking agendas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching booking agendas
	 */
	public java.util.List<BookingAgenda> findByuserId(long userId);

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
	public java.util.List<BookingAgenda> findByuserId(
		long userId, int start, int end);

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
	public java.util.List<BookingAgenda> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
			orderByComparator);

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
	public java.util.List<BookingAgenda> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first booking agenda in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	public BookingAgenda findByuserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
				orderByComparator)
		throws NoSuchBookingAgendaException;

	/**
	 * Returns the first booking agenda in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	public BookingAgenda fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
			orderByComparator);

	/**
	 * Returns the last booking agenda in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	public BookingAgenda findByuserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
				orderByComparator)
		throws NoSuchBookingAgendaException;

	/**
	 * Returns the last booking agenda in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	public BookingAgenda fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
			orderByComparator);

	/**
	 * Returns the booking agendas before and after the current booking agenda in the ordered set where userId = &#63;.
	 *
	 * @param calendarBookingAgendaId the primary key of the current booking agenda
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking agenda
	 * @throws NoSuchBookingAgendaException if a booking agenda with the primary key could not be found
	 */
	public BookingAgenda[] findByuserId_PrevAndNext(
			long calendarBookingAgendaId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
				orderByComparator)
		throws NoSuchBookingAgendaException;

	/**
	 * Removes all the booking agendas where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByuserId(long userId);

	/**
	 * Returns the number of booking agendas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching booking agendas
	 */
	public int countByuserId(long userId);

	/**
	 * Caches the booking agenda in the entity cache if it is enabled.
	 *
	 * @param bookingAgenda the booking agenda
	 */
	public void cacheResult(BookingAgenda bookingAgenda);

	/**
	 * Caches the booking agendas in the entity cache if it is enabled.
	 *
	 * @param bookingAgendas the booking agendas
	 */
	public void cacheResult(java.util.List<BookingAgenda> bookingAgendas);

	/**
	 * Creates a new booking agenda with the primary key. Does not add the booking agenda to the database.
	 *
	 * @param calendarBookingAgendaId the primary key for the new booking agenda
	 * @return the new booking agenda
	 */
	public BookingAgenda create(long calendarBookingAgendaId);

	/**
	 * Removes the booking agenda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param calendarBookingAgendaId the primary key of the booking agenda
	 * @return the booking agenda that was removed
	 * @throws NoSuchBookingAgendaException if a booking agenda with the primary key could not be found
	 */
	public BookingAgenda remove(long calendarBookingAgendaId)
		throws NoSuchBookingAgendaException;

	public BookingAgenda updateImpl(BookingAgenda bookingAgenda);

	/**
	 * Returns the booking agenda with the primary key or throws a <code>NoSuchBookingAgendaException</code> if it could not be found.
	 *
	 * @param calendarBookingAgendaId the primary key of the booking agenda
	 * @return the booking agenda
	 * @throws NoSuchBookingAgendaException if a booking agenda with the primary key could not be found
	 */
	public BookingAgenda findByPrimaryKey(long calendarBookingAgendaId)
		throws NoSuchBookingAgendaException;

	/**
	 * Returns the booking agenda with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param calendarBookingAgendaId the primary key of the booking agenda
	 * @return the booking agenda, or <code>null</code> if a booking agenda with the primary key could not be found
	 */
	public BookingAgenda fetchByPrimaryKey(long calendarBookingAgendaId);

	/**
	 * Returns all the booking agendas.
	 *
	 * @return the booking agendas
	 */
	public java.util.List<BookingAgenda> findAll();

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
	public java.util.List<BookingAgenda> findAll(int start, int end);

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
	public java.util.List<BookingAgenda> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
			orderByComparator);

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
	public java.util.List<BookingAgenda> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookingAgenda>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the booking agendas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of booking agendas.
	 *
	 * @return the number of booking agendas
	 */
	public int countAll();

}