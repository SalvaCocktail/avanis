/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.eventos.follow.sb.service.persistence;

import avanis.eventos.follow.sb.model.EventFollow;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the event follow service. This utility wraps <code>avanis.eventos.follow.sb.service.persistence.impl.EventFollowPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventFollowPersistence
 * @generated
 */
public class EventFollowUtil {

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
	public static void clearCache(EventFollow eventFollow) {
		getPersistence().clearCache(eventFollow);
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
	public static Map<Serializable, EventFollow> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EventFollow> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EventFollow> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EventFollow> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EventFollow> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EventFollow update(EventFollow eventFollow) {
		return getPersistence().update(eventFollow);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EventFollow update(
		EventFollow eventFollow, ServiceContext serviceContext) {

		return getPersistence().update(eventFollow, serviceContext);
	}

	/**
	 * Returns all the event follows where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching event follows
	 */
	public static List<EventFollow> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<EventFollow> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<EventFollow> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventFollow> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<EventFollow> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventFollow> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first event follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	public static EventFollow findByUuid_First(
			String uuid, OrderByComparator<EventFollow> orderByComparator)
		throws avanis.eventos.follow.sb.exception.NoSuchEventFollowException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first event follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public static EventFollow fetchByUuid_First(
		String uuid, OrderByComparator<EventFollow> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last event follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	public static EventFollow findByUuid_Last(
			String uuid, OrderByComparator<EventFollow> orderByComparator)
		throws avanis.eventos.follow.sb.exception.NoSuchEventFollowException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last event follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public static EventFollow fetchByUuid_Last(
		String uuid, OrderByComparator<EventFollow> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the event follows before and after the current event follow in the ordered set where uuid = &#63;.
	 *
	 * @param eventFollowId the primary key of the current event follow
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event follow
	 * @throws NoSuchEventFollowException if a event follow with the primary key could not be found
	 */
	public static EventFollow[] findByUuid_PrevAndNext(
			long eventFollowId, String uuid,
			OrderByComparator<EventFollow> orderByComparator)
		throws avanis.eventos.follow.sb.exception.NoSuchEventFollowException {

		return getPersistence().findByUuid_PrevAndNext(
			eventFollowId, uuid, orderByComparator);
	}

	/**
	 * Removes all the event follows where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of event follows where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching event follows
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the event follow where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEventFollowException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	public static EventFollow findByUUID_G(String uuid, long groupId)
		throws avanis.eventos.follow.sb.exception.NoSuchEventFollowException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the event follow where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public static EventFollow fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the event follow where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public static EventFollow fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the event follow where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the event follow that was removed
	 */
	public static EventFollow removeByUUID_G(String uuid, long groupId)
		throws avanis.eventos.follow.sb.exception.NoSuchEventFollowException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of event follows where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching event follows
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the event follows where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching event follows
	 */
	public static List<EventFollow> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<EventFollow> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<EventFollow> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EventFollow> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<EventFollow> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EventFollow> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first event follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	public static EventFollow findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EventFollow> orderByComparator)
		throws avanis.eventos.follow.sb.exception.NoSuchEventFollowException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first event follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public static EventFollow fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EventFollow> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last event follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	public static EventFollow findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EventFollow> orderByComparator)
		throws avanis.eventos.follow.sb.exception.NoSuchEventFollowException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last event follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public static EventFollow fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EventFollow> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static EventFollow[] findByUuid_C_PrevAndNext(
			long eventFollowId, String uuid, long companyId,
			OrderByComparator<EventFollow> orderByComparator)
		throws avanis.eventos.follow.sb.exception.NoSuchEventFollowException {

		return getPersistence().findByUuid_C_PrevAndNext(
			eventFollowId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the event follows where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of event follows where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching event follows
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the event follows where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching event follows
	 */
	public static List<EventFollow> findBygetEvents(long userId) {
		return getPersistence().findBygetEvents(userId);
	}

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
	public static List<EventFollow> findBygetEvents(
		long userId, int start, int end) {

		return getPersistence().findBygetEvents(userId, start, end);
	}

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
	public static List<EventFollow> findBygetEvents(
		long userId, int start, int end,
		OrderByComparator<EventFollow> orderByComparator) {

		return getPersistence().findBygetEvents(
			userId, start, end, orderByComparator);
	}

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
	public static List<EventFollow> findBygetEvents(
		long userId, int start, int end,
		OrderByComparator<EventFollow> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBygetEvents(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first event follow in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	public static EventFollow findBygetEvents_First(
			long userId, OrderByComparator<EventFollow> orderByComparator)
		throws avanis.eventos.follow.sb.exception.NoSuchEventFollowException {

		return getPersistence().findBygetEvents_First(
			userId, orderByComparator);
	}

	/**
	 * Returns the first event follow in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public static EventFollow fetchBygetEvents_First(
		long userId, OrderByComparator<EventFollow> orderByComparator) {

		return getPersistence().fetchBygetEvents_First(
			userId, orderByComparator);
	}

	/**
	 * Returns the last event follow in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	public static EventFollow findBygetEvents_Last(
			long userId, OrderByComparator<EventFollow> orderByComparator)
		throws avanis.eventos.follow.sb.exception.NoSuchEventFollowException {

		return getPersistence().findBygetEvents_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last event follow in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public static EventFollow fetchBygetEvents_Last(
		long userId, OrderByComparator<EventFollow> orderByComparator) {

		return getPersistence().fetchBygetEvents_Last(
			userId, orderByComparator);
	}

	/**
	 * Returns the event follows before and after the current event follow in the ordered set where userId = &#63;.
	 *
	 * @param eventFollowId the primary key of the current event follow
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event follow
	 * @throws NoSuchEventFollowException if a event follow with the primary key could not be found
	 */
	public static EventFollow[] findBygetEvents_PrevAndNext(
			long eventFollowId, long userId,
			OrderByComparator<EventFollow> orderByComparator)
		throws avanis.eventos.follow.sb.exception.NoSuchEventFollowException {

		return getPersistence().findBygetEvents_PrevAndNext(
			eventFollowId, userId, orderByComparator);
	}

	/**
	 * Removes all the event follows where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeBygetEvents(long userId) {
		getPersistence().removeBygetEvents(userId);
	}

	/**
	 * Returns the number of event follows where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching event follows
	 */
	public static int countBygetEvents(long userId) {
		return getPersistence().countBygetEvents(userId);
	}

	/**
	 * Returns all the event follows where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the matching event follows
	 */
	public static List<EventFollow> findBygetUsers(long eventId) {
		return getPersistence().findBygetUsers(eventId);
	}

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
	public static List<EventFollow> findBygetUsers(
		long eventId, int start, int end) {

		return getPersistence().findBygetUsers(eventId, start, end);
	}

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
	public static List<EventFollow> findBygetUsers(
		long eventId, int start, int end,
		OrderByComparator<EventFollow> orderByComparator) {

		return getPersistence().findBygetUsers(
			eventId, start, end, orderByComparator);
	}

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
	public static List<EventFollow> findBygetUsers(
		long eventId, int start, int end,
		OrderByComparator<EventFollow> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBygetUsers(
			eventId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first event follow in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	public static EventFollow findBygetUsers_First(
			long eventId, OrderByComparator<EventFollow> orderByComparator)
		throws avanis.eventos.follow.sb.exception.NoSuchEventFollowException {

		return getPersistence().findBygetUsers_First(
			eventId, orderByComparator);
	}

	/**
	 * Returns the first event follow in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public static EventFollow fetchBygetUsers_First(
		long eventId, OrderByComparator<EventFollow> orderByComparator) {

		return getPersistence().fetchBygetUsers_First(
			eventId, orderByComparator);
	}

	/**
	 * Returns the last event follow in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	public static EventFollow findBygetUsers_Last(
			long eventId, OrderByComparator<EventFollow> orderByComparator)
		throws avanis.eventos.follow.sb.exception.NoSuchEventFollowException {

		return getPersistence().findBygetUsers_Last(eventId, orderByComparator);
	}

	/**
	 * Returns the last event follow in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public static EventFollow fetchBygetUsers_Last(
		long eventId, OrderByComparator<EventFollow> orderByComparator) {

		return getPersistence().fetchBygetUsers_Last(
			eventId, orderByComparator);
	}

	/**
	 * Returns the event follows before and after the current event follow in the ordered set where eventId = &#63;.
	 *
	 * @param eventFollowId the primary key of the current event follow
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event follow
	 * @throws NoSuchEventFollowException if a event follow with the primary key could not be found
	 */
	public static EventFollow[] findBygetUsers_PrevAndNext(
			long eventFollowId, long eventId,
			OrderByComparator<EventFollow> orderByComparator)
		throws avanis.eventos.follow.sb.exception.NoSuchEventFollowException {

		return getPersistence().findBygetUsers_PrevAndNext(
			eventFollowId, eventId, orderByComparator);
	}

	/**
	 * Removes all the event follows where eventId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 */
	public static void removeBygetUsers(long eventId) {
		getPersistence().removeBygetUsers(eventId);
	}

	/**
	 * Returns the number of event follows where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the number of matching event follows
	 */
	public static int countBygetUsers(long eventId) {
		return getPersistence().countBygetUsers(eventId);
	}

	/**
	 * Returns the event follow where eventId = &#63; and userId = &#63; or throws a <code>NoSuchEventFollowException</code> if it could not be found.
	 *
	 * @param eventId the event ID
	 * @param userId the user ID
	 * @return the matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	public static EventFollow findBygetFollow(long eventId, long userId)
		throws avanis.eventos.follow.sb.exception.NoSuchEventFollowException {

		return getPersistence().findBygetFollow(eventId, userId);
	}

	/**
	 * Returns the event follow where eventId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param eventId the event ID
	 * @param userId the user ID
	 * @return the matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public static EventFollow fetchBygetFollow(long eventId, long userId) {
		return getPersistence().fetchBygetFollow(eventId, userId);
	}

	/**
	 * Returns the event follow where eventId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param eventId the event ID
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public static EventFollow fetchBygetFollow(
		long eventId, long userId, boolean useFinderCache) {

		return getPersistence().fetchBygetFollow(
			eventId, userId, useFinderCache);
	}

	/**
	 * Removes the event follow where eventId = &#63; and userId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 * @param userId the user ID
	 * @return the event follow that was removed
	 */
	public static EventFollow removeBygetFollow(long eventId, long userId)
		throws avanis.eventos.follow.sb.exception.NoSuchEventFollowException {

		return getPersistence().removeBygetFollow(eventId, userId);
	}

	/**
	 * Returns the number of event follows where eventId = &#63; and userId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param userId the user ID
	 * @return the number of matching event follows
	 */
	public static int countBygetFollow(long eventId, long userId) {
		return getPersistence().countBygetFollow(eventId, userId);
	}

	/**
	 * Caches the event follow in the entity cache if it is enabled.
	 *
	 * @param eventFollow the event follow
	 */
	public static void cacheResult(EventFollow eventFollow) {
		getPersistence().cacheResult(eventFollow);
	}

	/**
	 * Caches the event follows in the entity cache if it is enabled.
	 *
	 * @param eventFollows the event follows
	 */
	public static void cacheResult(List<EventFollow> eventFollows) {
		getPersistence().cacheResult(eventFollows);
	}

	/**
	 * Creates a new event follow with the primary key. Does not add the event follow to the database.
	 *
	 * @param eventFollowId the primary key for the new event follow
	 * @return the new event follow
	 */
	public static EventFollow create(long eventFollowId) {
		return getPersistence().create(eventFollowId);
	}

	/**
	 * Removes the event follow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventFollowId the primary key of the event follow
	 * @return the event follow that was removed
	 * @throws NoSuchEventFollowException if a event follow with the primary key could not be found
	 */
	public static EventFollow remove(long eventFollowId)
		throws avanis.eventos.follow.sb.exception.NoSuchEventFollowException {

		return getPersistence().remove(eventFollowId);
	}

	public static EventFollow updateImpl(EventFollow eventFollow) {
		return getPersistence().updateImpl(eventFollow);
	}

	/**
	 * Returns the event follow with the primary key or throws a <code>NoSuchEventFollowException</code> if it could not be found.
	 *
	 * @param eventFollowId the primary key of the event follow
	 * @return the event follow
	 * @throws NoSuchEventFollowException if a event follow with the primary key could not be found
	 */
	public static EventFollow findByPrimaryKey(long eventFollowId)
		throws avanis.eventos.follow.sb.exception.NoSuchEventFollowException {

		return getPersistence().findByPrimaryKey(eventFollowId);
	}

	/**
	 * Returns the event follow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventFollowId the primary key of the event follow
	 * @return the event follow, or <code>null</code> if a event follow with the primary key could not be found
	 */
	public static EventFollow fetchByPrimaryKey(long eventFollowId) {
		return getPersistence().fetchByPrimaryKey(eventFollowId);
	}

	/**
	 * Returns all the event follows.
	 *
	 * @return the event follows
	 */
	public static List<EventFollow> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<EventFollow> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<EventFollow> findAll(
		int start, int end, OrderByComparator<EventFollow> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<EventFollow> findAll(
		int start, int end, OrderByComparator<EventFollow> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the event follows from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of event follows.
	 *
	 * @return the number of event follows
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EventFollowPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(EventFollowPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile EventFollowPersistence _persistence;

}