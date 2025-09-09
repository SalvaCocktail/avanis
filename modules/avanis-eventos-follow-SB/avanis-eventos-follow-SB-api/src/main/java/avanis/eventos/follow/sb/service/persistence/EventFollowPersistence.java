/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.eventos.follow.sb.service.persistence;

import avanis.eventos.follow.sb.exception.NoSuchEventFollowException;
import avanis.eventos.follow.sb.model.EventFollow;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the event follow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventFollowUtil
 * @generated
 */
@ProviderType
public interface EventFollowPersistence extends BasePersistence<EventFollow> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventFollowUtil} to access the event follow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the event follows where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching event follows
	 */
	public java.util.List<EventFollow> findByUuid(String uuid);

	/**
	 * Returns a range of all the event follows where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @return the range of matching event follows
	 */
	public java.util.List<EventFollow> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the event follows where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event follows
	 */
	public java.util.List<EventFollow> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
			orderByComparator);

	/**
	 * Returns an ordered range of all the event follows where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event follows
	 */
	public java.util.List<EventFollow> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first event follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	public EventFollow findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
				orderByComparator)
		throws NoSuchEventFollowException;

	/**
	 * Returns the first event follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public EventFollow fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
			orderByComparator);

	/**
	 * Returns the last event follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	public EventFollow findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
				orderByComparator)
		throws NoSuchEventFollowException;

	/**
	 * Returns the last event follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public EventFollow fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
			orderByComparator);

	/**
	 * Returns the event follows before and after the current event follow in the ordered set where uuid = &#63;.
	 *
	 * @param eventFollowId the primary key of the current event follow
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event follow
	 * @throws NoSuchEventFollowException if a event follow with the primary key could not be found
	 */
	public EventFollow[] findByUuid_PrevAndNext(
			long eventFollowId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
				orderByComparator)
		throws NoSuchEventFollowException;

	/**
	 * Removes all the event follows where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of event follows where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching event follows
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the event follow where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEventFollowException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	public EventFollow findByUUID_G(String uuid, long groupId)
		throws NoSuchEventFollowException;

	/**
	 * Returns the event follow where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public EventFollow fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the event follow where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public EventFollow fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the event follow where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the event follow that was removed
	 */
	public EventFollow removeByUUID_G(String uuid, long groupId)
		throws NoSuchEventFollowException;

	/**
	 * Returns the number of event follows where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching event follows
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the event follows where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching event follows
	 */
	public java.util.List<EventFollow> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the event follows where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @return the range of matching event follows
	 */
	public java.util.List<EventFollow> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the event follows where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event follows
	 */
	public java.util.List<EventFollow> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
			orderByComparator);

	/**
	 * Returns an ordered range of all the event follows where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event follows
	 */
	public java.util.List<EventFollow> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first event follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	public EventFollow findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
				orderByComparator)
		throws NoSuchEventFollowException;

	/**
	 * Returns the first event follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public EventFollow fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
			orderByComparator);

	/**
	 * Returns the last event follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	public EventFollow findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
				orderByComparator)
		throws NoSuchEventFollowException;

	/**
	 * Returns the last event follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public EventFollow fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
			orderByComparator);

	/**
	 * Returns the event follows before and after the current event follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param eventFollowId the primary key of the current event follow
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event follow
	 * @throws NoSuchEventFollowException if a event follow with the primary key could not be found
	 */
	public EventFollow[] findByUuid_C_PrevAndNext(
			long eventFollowId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
				orderByComparator)
		throws NoSuchEventFollowException;

	/**
	 * Removes all the event follows where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of event follows where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching event follows
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the event follows where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching event follows
	 */
	public java.util.List<EventFollow> findBygetEvents(long userId);

	/**
	 * Returns a range of all the event follows where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @return the range of matching event follows
	 */
	public java.util.List<EventFollow> findBygetEvents(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the event follows where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event follows
	 */
	public java.util.List<EventFollow> findBygetEvents(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
			orderByComparator);

	/**
	 * Returns an ordered range of all the event follows where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event follows
	 */
	public java.util.List<EventFollow> findBygetEvents(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first event follow in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	public EventFollow findBygetEvents_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
				orderByComparator)
		throws NoSuchEventFollowException;

	/**
	 * Returns the first event follow in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public EventFollow fetchBygetEvents_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
			orderByComparator);

	/**
	 * Returns the last event follow in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	public EventFollow findBygetEvents_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
				orderByComparator)
		throws NoSuchEventFollowException;

	/**
	 * Returns the last event follow in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public EventFollow fetchBygetEvents_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
			orderByComparator);

	/**
	 * Returns the event follows before and after the current event follow in the ordered set where userId = &#63;.
	 *
	 * @param eventFollowId the primary key of the current event follow
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event follow
	 * @throws NoSuchEventFollowException if a event follow with the primary key could not be found
	 */
	public EventFollow[] findBygetEvents_PrevAndNext(
			long eventFollowId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
				orderByComparator)
		throws NoSuchEventFollowException;

	/**
	 * Removes all the event follows where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeBygetEvents(long userId);

	/**
	 * Returns the number of event follows where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching event follows
	 */
	public int countBygetEvents(long userId);

	/**
	 * Returns all the event follows where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the matching event follows
	 */
	public java.util.List<EventFollow> findBygetUsers(long eventId);

	/**
	 * Returns a range of all the event follows where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @return the range of matching event follows
	 */
	public java.util.List<EventFollow> findBygetUsers(
		long eventId, int start, int end);

	/**
	 * Returns an ordered range of all the event follows where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event follows
	 */
	public java.util.List<EventFollow> findBygetUsers(
		long eventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
			orderByComparator);

	/**
	 * Returns an ordered range of all the event follows where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event follows
	 */
	public java.util.List<EventFollow> findBygetUsers(
		long eventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first event follow in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	public EventFollow findBygetUsers_First(
			long eventId,
			com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
				orderByComparator)
		throws NoSuchEventFollowException;

	/**
	 * Returns the first event follow in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public EventFollow fetchBygetUsers_First(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
			orderByComparator);

	/**
	 * Returns the last event follow in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	public EventFollow findBygetUsers_Last(
			long eventId,
			com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
				orderByComparator)
		throws NoSuchEventFollowException;

	/**
	 * Returns the last event follow in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public EventFollow fetchBygetUsers_Last(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
			orderByComparator);

	/**
	 * Returns the event follows before and after the current event follow in the ordered set where eventId = &#63;.
	 *
	 * @param eventFollowId the primary key of the current event follow
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event follow
	 * @throws NoSuchEventFollowException if a event follow with the primary key could not be found
	 */
	public EventFollow[] findBygetUsers_PrevAndNext(
			long eventFollowId, long eventId,
			com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
				orderByComparator)
		throws NoSuchEventFollowException;

	/**
	 * Removes all the event follows where eventId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 */
	public void removeBygetUsers(long eventId);

	/**
	 * Returns the number of event follows where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the number of matching event follows
	 */
	public int countBygetUsers(long eventId);

	/**
	 * Returns the event follow where eventId = &#63; and userId = &#63; or throws a <code>NoSuchEventFollowException</code> if it could not be found.
	 *
	 * @param eventId the event ID
	 * @param userId the user ID
	 * @return the matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	public EventFollow findBygetFollow(long eventId, long userId)
		throws NoSuchEventFollowException;

	/**
	 * Returns the event follow where eventId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param eventId the event ID
	 * @param userId the user ID
	 * @return the matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public EventFollow fetchBygetFollow(long eventId, long userId);

	/**
	 * Returns the event follow where eventId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param eventId the event ID
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public EventFollow fetchBygetFollow(
		long eventId, long userId, boolean useFinderCache);

	/**
	 * Removes the event follow where eventId = &#63; and userId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 * @param userId the user ID
	 * @return the event follow that was removed
	 */
	public EventFollow removeBygetFollow(long eventId, long userId)
		throws NoSuchEventFollowException;

	/**
	 * Returns the number of event follows where eventId = &#63; and userId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param userId the user ID
	 * @return the number of matching event follows
	 */
	public int countBygetFollow(long eventId, long userId);

	/**
	 * Caches the event follow in the entity cache if it is enabled.
	 *
	 * @param eventFollow the event follow
	 */
	public void cacheResult(EventFollow eventFollow);

	/**
	 * Caches the event follows in the entity cache if it is enabled.
	 *
	 * @param eventFollows the event follows
	 */
	public void cacheResult(java.util.List<EventFollow> eventFollows);

	/**
	 * Creates a new event follow with the primary key. Does not add the event follow to the database.
	 *
	 * @param eventFollowId the primary key for the new event follow
	 * @return the new event follow
	 */
	public EventFollow create(long eventFollowId);

	/**
	 * Removes the event follow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventFollowId the primary key of the event follow
	 * @return the event follow that was removed
	 * @throws NoSuchEventFollowException if a event follow with the primary key could not be found
	 */
	public EventFollow remove(long eventFollowId)
		throws NoSuchEventFollowException;

	public EventFollow updateImpl(EventFollow eventFollow);

	/**
	 * Returns the event follow with the primary key or throws a <code>NoSuchEventFollowException</code> if it could not be found.
	 *
	 * @param eventFollowId the primary key of the event follow
	 * @return the event follow
	 * @throws NoSuchEventFollowException if a event follow with the primary key could not be found
	 */
	public EventFollow findByPrimaryKey(long eventFollowId)
		throws NoSuchEventFollowException;

	/**
	 * Returns the event follow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventFollowId the primary key of the event follow
	 * @return the event follow, or <code>null</code> if a event follow with the primary key could not be found
	 */
	public EventFollow fetchByPrimaryKey(long eventFollowId);

	/**
	 * Returns all the event follows.
	 *
	 * @return the event follows
	 */
	public java.util.List<EventFollow> findAll();

	/**
	 * Returns a range of all the event follows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @return the range of event follows
	 */
	public java.util.List<EventFollow> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the event follows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event follows
	 */
	public java.util.List<EventFollow> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
			orderByComparator);

	/**
	 * Returns an ordered range of all the event follows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of event follows
	 */
	public java.util.List<EventFollow> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventFollow>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the event follows from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of event follows.
	 *
	 * @return the number of event follows
	 */
	public int countAll();

}