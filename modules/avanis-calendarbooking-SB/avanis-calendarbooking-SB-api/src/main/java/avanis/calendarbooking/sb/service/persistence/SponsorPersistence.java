/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service.persistence;

import avanis.calendarbooking.sb.exception.NoSuchSponsorException;
import avanis.calendarbooking.sb.model.Sponsor;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sponsor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SponsorUtil
 * @generated
 */
@ProviderType
public interface SponsorPersistence extends BasePersistence<Sponsor> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SponsorUtil} to access the sponsor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the sponsors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sponsors
	 */
	public java.util.List<Sponsor> findByUuid(String uuid);

	/**
	 * Returns a range of all the sponsors where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SponsorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sponsors
	 * @param end the upper bound of the range of sponsors (not inclusive)
	 * @return the range of matching sponsors
	 */
	public java.util.List<Sponsor> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the sponsors where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SponsorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sponsors
	 * @param end the upper bound of the range of sponsors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sponsors
	 */
	public java.util.List<Sponsor> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sponsors where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SponsorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sponsors
	 * @param end the upper bound of the range of sponsors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sponsors
	 */
	public java.util.List<Sponsor> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sponsor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sponsor
	 * @throws NoSuchSponsorException if a matching sponsor could not be found
	 */
	public Sponsor findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
				orderByComparator)
		throws NoSuchSponsorException;

	/**
	 * Returns the first sponsor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	public Sponsor fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
			orderByComparator);

	/**
	 * Returns the last sponsor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sponsor
	 * @throws NoSuchSponsorException if a matching sponsor could not be found
	 */
	public Sponsor findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
				orderByComparator)
		throws NoSuchSponsorException;

	/**
	 * Returns the last sponsor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	public Sponsor fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
			orderByComparator);

	/**
	 * Returns the sponsors before and after the current sponsor in the ordered set where uuid = &#63;.
	 *
	 * @param sponsorId the primary key of the current sponsor
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sponsor
	 * @throws NoSuchSponsorException if a sponsor with the primary key could not be found
	 */
	public Sponsor[] findByUuid_PrevAndNext(
			long sponsorId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
				orderByComparator)
		throws NoSuchSponsorException;

	/**
	 * Removes all the sponsors where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of sponsors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sponsors
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the sponsor where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSponsorException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sponsor
	 * @throws NoSuchSponsorException if a matching sponsor could not be found
	 */
	public Sponsor findByUUID_G(String uuid, long groupId)
		throws NoSuchSponsorException;

	/**
	 * Returns the sponsor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	public Sponsor fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the sponsor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	public Sponsor fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the sponsor where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sponsor that was removed
	 */
	public Sponsor removeByUUID_G(String uuid, long groupId)
		throws NoSuchSponsorException;

	/**
	 * Returns the number of sponsors where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sponsors
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the sponsors where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sponsors
	 */
	public java.util.List<Sponsor> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the sponsors where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SponsorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sponsors
	 * @param end the upper bound of the range of sponsors (not inclusive)
	 * @return the range of matching sponsors
	 */
	public java.util.List<Sponsor> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the sponsors where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SponsorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sponsors
	 * @param end the upper bound of the range of sponsors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sponsors
	 */
	public java.util.List<Sponsor> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sponsors where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SponsorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of sponsors
	 * @param end the upper bound of the range of sponsors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sponsors
	 */
	public java.util.List<Sponsor> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sponsor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sponsor
	 * @throws NoSuchSponsorException if a matching sponsor could not be found
	 */
	public Sponsor findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
				orderByComparator)
		throws NoSuchSponsorException;

	/**
	 * Returns the first sponsor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	public Sponsor fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
			orderByComparator);

	/**
	 * Returns the last sponsor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sponsor
	 * @throws NoSuchSponsorException if a matching sponsor could not be found
	 */
	public Sponsor findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
				orderByComparator)
		throws NoSuchSponsorException;

	/**
	 * Returns the last sponsor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	public Sponsor fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
			orderByComparator);

	/**
	 * Returns the sponsors before and after the current sponsor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param sponsorId the primary key of the current sponsor
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sponsor
	 * @throws NoSuchSponsorException if a sponsor with the primary key could not be found
	 */
	public Sponsor[] findByUuid_C_PrevAndNext(
			long sponsorId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
				orderByComparator)
		throws NoSuchSponsorException;

	/**
	 * Removes all the sponsors where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of sponsors where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sponsors
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the sponsors where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching sponsors
	 */
	public java.util.List<Sponsor> findByuserId(long userId);

	/**
	 * Returns a range of all the sponsors where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SponsorModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of sponsors
	 * @param end the upper bound of the range of sponsors (not inclusive)
	 * @return the range of matching sponsors
	 */
	public java.util.List<Sponsor> findByuserId(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the sponsors where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SponsorModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of sponsors
	 * @param end the upper bound of the range of sponsors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sponsors
	 */
	public java.util.List<Sponsor> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sponsors where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SponsorModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of sponsors
	 * @param end the upper bound of the range of sponsors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sponsors
	 */
	public java.util.List<Sponsor> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sponsor in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sponsor
	 * @throws NoSuchSponsorException if a matching sponsor could not be found
	 */
	public Sponsor findByuserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
				orderByComparator)
		throws NoSuchSponsorException;

	/**
	 * Returns the first sponsor in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	public Sponsor fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
			orderByComparator);

	/**
	 * Returns the last sponsor in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sponsor
	 * @throws NoSuchSponsorException if a matching sponsor could not be found
	 */
	public Sponsor findByuserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
				orderByComparator)
		throws NoSuchSponsorException;

	/**
	 * Returns the last sponsor in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	public Sponsor fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
			orderByComparator);

	/**
	 * Returns the sponsors before and after the current sponsor in the ordered set where userId = &#63;.
	 *
	 * @param sponsorId the primary key of the current sponsor
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sponsor
	 * @throws NoSuchSponsorException if a sponsor with the primary key could not be found
	 */
	public Sponsor[] findByuserId_PrevAndNext(
			long sponsorId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
				orderByComparator)
		throws NoSuchSponsorException;

	/**
	 * Removes all the sponsors where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByuserId(long userId);

	/**
	 * Returns the number of sponsors where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching sponsors
	 */
	public int countByuserId(long userId);

	/**
	 * Returns all the sponsors where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @return the matching sponsors
	 */
	public java.util.List<Sponsor> findBycalendarBookingId(
		long calendarBookingId);

	/**
	 * Returns a range of all the sponsors where calendarBookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SponsorModelImpl</code>.
	 * </p>
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param start the lower bound of the range of sponsors
	 * @param end the upper bound of the range of sponsors (not inclusive)
	 * @return the range of matching sponsors
	 */
	public java.util.List<Sponsor> findBycalendarBookingId(
		long calendarBookingId, int start, int end);

	/**
	 * Returns an ordered range of all the sponsors where calendarBookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SponsorModelImpl</code>.
	 * </p>
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param start the lower bound of the range of sponsors
	 * @param end the upper bound of the range of sponsors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sponsors
	 */
	public java.util.List<Sponsor> findBycalendarBookingId(
		long calendarBookingId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sponsors where calendarBookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SponsorModelImpl</code>.
	 * </p>
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param start the lower bound of the range of sponsors
	 * @param end the upper bound of the range of sponsors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sponsors
	 */
	public java.util.List<Sponsor> findBycalendarBookingId(
		long calendarBookingId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first sponsor in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sponsor
	 * @throws NoSuchSponsorException if a matching sponsor could not be found
	 */
	public Sponsor findBycalendarBookingId_First(
			long calendarBookingId,
			com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
				orderByComparator)
		throws NoSuchSponsorException;

	/**
	 * Returns the first sponsor in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	public Sponsor fetchBycalendarBookingId_First(
		long calendarBookingId,
		com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
			orderByComparator);

	/**
	 * Returns the last sponsor in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sponsor
	 * @throws NoSuchSponsorException if a matching sponsor could not be found
	 */
	public Sponsor findBycalendarBookingId_Last(
			long calendarBookingId,
			com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
				orderByComparator)
		throws NoSuchSponsorException;

	/**
	 * Returns the last sponsor in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	public Sponsor fetchBycalendarBookingId_Last(
		long calendarBookingId,
		com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
			orderByComparator);

	/**
	 * Returns the sponsors before and after the current sponsor in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param sponsorId the primary key of the current sponsor
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sponsor
	 * @throws NoSuchSponsorException if a sponsor with the primary key could not be found
	 */
	public Sponsor[] findBycalendarBookingId_PrevAndNext(
			long sponsorId, long calendarBookingId,
			com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
				orderByComparator)
		throws NoSuchSponsorException;

	/**
	 * Removes all the sponsors where calendarBookingId = &#63; from the database.
	 *
	 * @param calendarBookingId the calendar booking ID
	 */
	public void removeBycalendarBookingId(long calendarBookingId);

	/**
	 * Returns the number of sponsors where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @return the number of matching sponsors
	 */
	public int countBycalendarBookingId(long calendarBookingId);

	/**
	 * Caches the sponsor in the entity cache if it is enabled.
	 *
	 * @param sponsor the sponsor
	 */
	public void cacheResult(Sponsor sponsor);

	/**
	 * Caches the sponsors in the entity cache if it is enabled.
	 *
	 * @param sponsors the sponsors
	 */
	public void cacheResult(java.util.List<Sponsor> sponsors);

	/**
	 * Creates a new sponsor with the primary key. Does not add the sponsor to the database.
	 *
	 * @param sponsorId the primary key for the new sponsor
	 * @return the new sponsor
	 */
	public Sponsor create(long sponsorId);

	/**
	 * Removes the sponsor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sponsorId the primary key of the sponsor
	 * @return the sponsor that was removed
	 * @throws NoSuchSponsorException if a sponsor with the primary key could not be found
	 */
	public Sponsor remove(long sponsorId) throws NoSuchSponsorException;

	public Sponsor updateImpl(Sponsor sponsor);

	/**
	 * Returns the sponsor with the primary key or throws a <code>NoSuchSponsorException</code> if it could not be found.
	 *
	 * @param sponsorId the primary key of the sponsor
	 * @return the sponsor
	 * @throws NoSuchSponsorException if a sponsor with the primary key could not be found
	 */
	public Sponsor findByPrimaryKey(long sponsorId)
		throws NoSuchSponsorException;

	/**
	 * Returns the sponsor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sponsorId the primary key of the sponsor
	 * @return the sponsor, or <code>null</code> if a sponsor with the primary key could not be found
	 */
	public Sponsor fetchByPrimaryKey(long sponsorId);

	/**
	 * Returns all the sponsors.
	 *
	 * @return the sponsors
	 */
	public java.util.List<Sponsor> findAll();

	/**
	 * Returns a range of all the sponsors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SponsorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sponsors
	 * @param end the upper bound of the range of sponsors (not inclusive)
	 * @return the range of sponsors
	 */
	public java.util.List<Sponsor> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the sponsors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SponsorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sponsors
	 * @param end the upper bound of the range of sponsors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sponsors
	 */
	public java.util.List<Sponsor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
			orderByComparator);

	/**
	 * Returns an ordered range of all the sponsors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SponsorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sponsors
	 * @param end the upper bound of the range of sponsors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sponsors
	 */
	public java.util.List<Sponsor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Sponsor>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the sponsors from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of sponsors.
	 *
	 * @return the number of sponsors
	 */
	public int countAll();

}