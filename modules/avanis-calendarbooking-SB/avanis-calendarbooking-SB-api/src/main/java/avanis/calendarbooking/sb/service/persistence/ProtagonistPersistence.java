/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service.persistence;

import avanis.calendarbooking.sb.exception.NoSuchProtagonistException;
import avanis.calendarbooking.sb.model.Protagonist;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the protagonist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProtagonistUtil
 * @generated
 */
@ProviderType
public interface ProtagonistPersistence extends BasePersistence<Protagonist> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProtagonistUtil} to access the protagonist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the protagonists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching protagonists
	 */
	public java.util.List<Protagonist> findByUuid(String uuid);

	/**
	 * Returns a range of all the protagonists where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @return the range of matching protagonists
	 */
	public java.util.List<Protagonist> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the protagonists where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching protagonists
	 */
	public java.util.List<Protagonist> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
			orderByComparator);

	/**
	 * Returns an ordered range of all the protagonists where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching protagonists
	 */
	public java.util.List<Protagonist> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first protagonist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	public Protagonist findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
				orderByComparator)
		throws NoSuchProtagonistException;

	/**
	 * Returns the first protagonist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	public Protagonist fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
			orderByComparator);

	/**
	 * Returns the last protagonist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	public Protagonist findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
				orderByComparator)
		throws NoSuchProtagonistException;

	/**
	 * Returns the last protagonist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	public Protagonist fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
			orderByComparator);

	/**
	 * Returns the protagonists before and after the current protagonist in the ordered set where uuid = &#63;.
	 *
	 * @param protagonistId the primary key of the current protagonist
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next protagonist
	 * @throws NoSuchProtagonistException if a protagonist with the primary key could not be found
	 */
	public Protagonist[] findByUuid_PrevAndNext(
			long protagonistId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
				orderByComparator)
		throws NoSuchProtagonistException;

	/**
	 * Removes all the protagonists where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of protagonists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching protagonists
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the protagonist where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProtagonistException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	public Protagonist findByUUID_G(String uuid, long groupId)
		throws NoSuchProtagonistException;

	/**
	 * Returns the protagonist where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	public Protagonist fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the protagonist where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	public Protagonist fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the protagonist where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the protagonist that was removed
	 */
	public Protagonist removeByUUID_G(String uuid, long groupId)
		throws NoSuchProtagonistException;

	/**
	 * Returns the number of protagonists where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching protagonists
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the protagonists where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching protagonists
	 */
	public java.util.List<Protagonist> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the protagonists where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @return the range of matching protagonists
	 */
	public java.util.List<Protagonist> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the protagonists where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching protagonists
	 */
	public java.util.List<Protagonist> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
			orderByComparator);

	/**
	 * Returns an ordered range of all the protagonists where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching protagonists
	 */
	public java.util.List<Protagonist> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first protagonist in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	public Protagonist findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
				orderByComparator)
		throws NoSuchProtagonistException;

	/**
	 * Returns the first protagonist in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	public Protagonist fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
			orderByComparator);

	/**
	 * Returns the last protagonist in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	public Protagonist findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
				orderByComparator)
		throws NoSuchProtagonistException;

	/**
	 * Returns the last protagonist in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	public Protagonist fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
			orderByComparator);

	/**
	 * Returns the protagonists before and after the current protagonist in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param protagonistId the primary key of the current protagonist
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next protagonist
	 * @throws NoSuchProtagonistException if a protagonist with the primary key could not be found
	 */
	public Protagonist[] findByUuid_C_PrevAndNext(
			long protagonistId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
				orderByComparator)
		throws NoSuchProtagonistException;

	/**
	 * Removes all the protagonists where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of protagonists where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching protagonists
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the protagonists where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @return the matching protagonists
	 */
	public java.util.List<Protagonist> findBycalendarBookingId(
		long calendarBookingId);

	/**
	 * Returns a range of all the protagonists where calendarBookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @return the range of matching protagonists
	 */
	public java.util.List<Protagonist> findBycalendarBookingId(
		long calendarBookingId, int start, int end);

	/**
	 * Returns an ordered range of all the protagonists where calendarBookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching protagonists
	 */
	public java.util.List<Protagonist> findBycalendarBookingId(
		long calendarBookingId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
			orderByComparator);

	/**
	 * Returns an ordered range of all the protagonists where calendarBookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching protagonists
	 */
	public java.util.List<Protagonist> findBycalendarBookingId(
		long calendarBookingId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first protagonist in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	public Protagonist findBycalendarBookingId_First(
			long calendarBookingId,
			com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
				orderByComparator)
		throws NoSuchProtagonistException;

	/**
	 * Returns the first protagonist in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	public Protagonist fetchBycalendarBookingId_First(
		long calendarBookingId,
		com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
			orderByComparator);

	/**
	 * Returns the last protagonist in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	public Protagonist findBycalendarBookingId_Last(
			long calendarBookingId,
			com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
				orderByComparator)
		throws NoSuchProtagonistException;

	/**
	 * Returns the last protagonist in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	public Protagonist fetchBycalendarBookingId_Last(
		long calendarBookingId,
		com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
			orderByComparator);

	/**
	 * Returns the protagonists before and after the current protagonist in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param protagonistId the primary key of the current protagonist
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next protagonist
	 * @throws NoSuchProtagonistException if a protagonist with the primary key could not be found
	 */
	public Protagonist[] findBycalendarBookingId_PrevAndNext(
			long protagonistId, long calendarBookingId,
			com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
				orderByComparator)
		throws NoSuchProtagonistException;

	/**
	 * Removes all the protagonists where calendarBookingId = &#63; from the database.
	 *
	 * @param calendarBookingId the calendar booking ID
	 */
	public void removeBycalendarBookingId(long calendarBookingId);

	/**
	 * Returns the number of protagonists where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @return the number of matching protagonists
	 */
	public int countBycalendarBookingId(long calendarBookingId);

	/**
	 * Returns all the protagonists where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching protagonists
	 */
	public java.util.List<Protagonist> findByuserId(long userId);

	/**
	 * Returns a range of all the protagonists where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @return the range of matching protagonists
	 */
	public java.util.List<Protagonist> findByuserId(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the protagonists where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching protagonists
	 */
	public java.util.List<Protagonist> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
			orderByComparator);

	/**
	 * Returns an ordered range of all the protagonists where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching protagonists
	 */
	public java.util.List<Protagonist> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first protagonist in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	public Protagonist findByuserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
				orderByComparator)
		throws NoSuchProtagonistException;

	/**
	 * Returns the first protagonist in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	public Protagonist fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
			orderByComparator);

	/**
	 * Returns the last protagonist in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	public Protagonist findByuserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
				orderByComparator)
		throws NoSuchProtagonistException;

	/**
	 * Returns the last protagonist in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	public Protagonist fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
			orderByComparator);

	/**
	 * Returns the protagonists before and after the current protagonist in the ordered set where userId = &#63;.
	 *
	 * @param protagonistId the primary key of the current protagonist
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next protagonist
	 * @throws NoSuchProtagonistException if a protagonist with the primary key could not be found
	 */
	public Protagonist[] findByuserId_PrevAndNext(
			long protagonistId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
				orderByComparator)
		throws NoSuchProtagonistException;

	/**
	 * Removes all the protagonists where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByuserId(long userId);

	/**
	 * Returns the number of protagonists where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching protagonists
	 */
	public int countByuserId(long userId);

	/**
	 * Caches the protagonist in the entity cache if it is enabled.
	 *
	 * @param protagonist the protagonist
	 */
	public void cacheResult(Protagonist protagonist);

	/**
	 * Caches the protagonists in the entity cache if it is enabled.
	 *
	 * @param protagonists the protagonists
	 */
	public void cacheResult(java.util.List<Protagonist> protagonists);

	/**
	 * Creates a new protagonist with the primary key. Does not add the protagonist to the database.
	 *
	 * @param protagonistId the primary key for the new protagonist
	 * @return the new protagonist
	 */
	public Protagonist create(long protagonistId);

	/**
	 * Removes the protagonist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param protagonistId the primary key of the protagonist
	 * @return the protagonist that was removed
	 * @throws NoSuchProtagonistException if a protagonist with the primary key could not be found
	 */
	public Protagonist remove(long protagonistId)
		throws NoSuchProtagonistException;

	public Protagonist updateImpl(Protagonist protagonist);

	/**
	 * Returns the protagonist with the primary key or throws a <code>NoSuchProtagonistException</code> if it could not be found.
	 *
	 * @param protagonistId the primary key of the protagonist
	 * @return the protagonist
	 * @throws NoSuchProtagonistException if a protagonist with the primary key could not be found
	 */
	public Protagonist findByPrimaryKey(long protagonistId)
		throws NoSuchProtagonistException;

	/**
	 * Returns the protagonist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param protagonistId the primary key of the protagonist
	 * @return the protagonist, or <code>null</code> if a protagonist with the primary key could not be found
	 */
	public Protagonist fetchByPrimaryKey(long protagonistId);

	/**
	 * Returns all the protagonists.
	 *
	 * @return the protagonists
	 */
	public java.util.List<Protagonist> findAll();

	/**
	 * Returns a range of all the protagonists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @return the range of protagonists
	 */
	public java.util.List<Protagonist> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the protagonists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of protagonists
	 */
	public java.util.List<Protagonist> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
			orderByComparator);

	/**
	 * Returns an ordered range of all the protagonists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of protagonists
	 */
	public java.util.List<Protagonist> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Protagonist>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the protagonists from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of protagonists.
	 *
	 * @return the number of protagonists
	 */
	public int countAll();

}