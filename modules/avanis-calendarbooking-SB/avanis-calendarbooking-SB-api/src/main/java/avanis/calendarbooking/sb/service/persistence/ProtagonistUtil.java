/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service.persistence;

import avanis.calendarbooking.sb.model.Protagonist;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the protagonist service. This utility wraps <code>avanis.calendarbooking.sb.service.persistence.impl.ProtagonistPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProtagonistPersistence
 * @generated
 */
public class ProtagonistUtil {

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
	public static void clearCache(Protagonist protagonist) {
		getPersistence().clearCache(protagonist);
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
	public static Map<Serializable, Protagonist> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Protagonist> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Protagonist> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Protagonist> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Protagonist> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Protagonist update(Protagonist protagonist) {
		return getPersistence().update(protagonist);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Protagonist update(
		Protagonist protagonist, ServiceContext serviceContext) {

		return getPersistence().update(protagonist, serviceContext);
	}

	/**
	 * Returns all the protagonists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching protagonists
	 */
	public static List<Protagonist> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Protagonist> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Protagonist> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Protagonist> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Protagonist> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Protagonist> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first protagonist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	public static Protagonist findByUuid_First(
			String uuid, OrderByComparator<Protagonist> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchProtagonistException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first protagonist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	public static Protagonist fetchByUuid_First(
		String uuid, OrderByComparator<Protagonist> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last protagonist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	public static Protagonist findByUuid_Last(
			String uuid, OrderByComparator<Protagonist> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchProtagonistException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last protagonist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	public static Protagonist fetchByUuid_Last(
		String uuid, OrderByComparator<Protagonist> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the protagonists before and after the current protagonist in the ordered set where uuid = &#63;.
	 *
	 * @param protagonistId the primary key of the current protagonist
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next protagonist
	 * @throws NoSuchProtagonistException if a protagonist with the primary key could not be found
	 */
	public static Protagonist[] findByUuid_PrevAndNext(
			long protagonistId, String uuid,
			OrderByComparator<Protagonist> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchProtagonistException {

		return getPersistence().findByUuid_PrevAndNext(
			protagonistId, uuid, orderByComparator);
	}

	/**
	 * Removes all the protagonists where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of protagonists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching protagonists
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the protagonist where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProtagonistException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	public static Protagonist findByUUID_G(String uuid, long groupId)
		throws avanis.calendarbooking.sb.exception.NoSuchProtagonistException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the protagonist where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	public static Protagonist fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the protagonist where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	public static Protagonist fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the protagonist where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the protagonist that was removed
	 */
	public static Protagonist removeByUUID_G(String uuid, long groupId)
		throws avanis.calendarbooking.sb.exception.NoSuchProtagonistException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of protagonists where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching protagonists
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the protagonists where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching protagonists
	 */
	public static List<Protagonist> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<Protagonist> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<Protagonist> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Protagonist> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<Protagonist> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Protagonist> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first protagonist in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	public static Protagonist findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Protagonist> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchProtagonistException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first protagonist in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	public static Protagonist fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Protagonist> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last protagonist in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	public static Protagonist findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Protagonist> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchProtagonistException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last protagonist in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	public static Protagonist fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Protagonist> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static Protagonist[] findByUuid_C_PrevAndNext(
			long protagonistId, String uuid, long companyId,
			OrderByComparator<Protagonist> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchProtagonistException {

		return getPersistence().findByUuid_C_PrevAndNext(
			protagonistId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the protagonists where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of protagonists where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching protagonists
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the protagonists where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @return the matching protagonists
	 */
	public static List<Protagonist> findBycalendarBookingId(
		long calendarBookingId) {

		return getPersistence().findBycalendarBookingId(calendarBookingId);
	}

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
	public static List<Protagonist> findBycalendarBookingId(
		long calendarBookingId, int start, int end) {

		return getPersistence().findBycalendarBookingId(
			calendarBookingId, start, end);
	}

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
	public static List<Protagonist> findBycalendarBookingId(
		long calendarBookingId, int start, int end,
		OrderByComparator<Protagonist> orderByComparator) {

		return getPersistence().findBycalendarBookingId(
			calendarBookingId, start, end, orderByComparator);
	}

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
	public static List<Protagonist> findBycalendarBookingId(
		long calendarBookingId, int start, int end,
		OrderByComparator<Protagonist> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBycalendarBookingId(
			calendarBookingId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first protagonist in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	public static Protagonist findBycalendarBookingId_First(
			long calendarBookingId,
			OrderByComparator<Protagonist> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchProtagonistException {

		return getPersistence().findBycalendarBookingId_First(
			calendarBookingId, orderByComparator);
	}

	/**
	 * Returns the first protagonist in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	public static Protagonist fetchBycalendarBookingId_First(
		long calendarBookingId,
		OrderByComparator<Protagonist> orderByComparator) {

		return getPersistence().fetchBycalendarBookingId_First(
			calendarBookingId, orderByComparator);
	}

	/**
	 * Returns the last protagonist in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	public static Protagonist findBycalendarBookingId_Last(
			long calendarBookingId,
			OrderByComparator<Protagonist> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchProtagonistException {

		return getPersistence().findBycalendarBookingId_Last(
			calendarBookingId, orderByComparator);
	}

	/**
	 * Returns the last protagonist in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	public static Protagonist fetchBycalendarBookingId_Last(
		long calendarBookingId,
		OrderByComparator<Protagonist> orderByComparator) {

		return getPersistence().fetchBycalendarBookingId_Last(
			calendarBookingId, orderByComparator);
	}

	/**
	 * Returns the protagonists before and after the current protagonist in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param protagonistId the primary key of the current protagonist
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next protagonist
	 * @throws NoSuchProtagonistException if a protagonist with the primary key could not be found
	 */
	public static Protagonist[] findBycalendarBookingId_PrevAndNext(
			long protagonistId, long calendarBookingId,
			OrderByComparator<Protagonist> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchProtagonistException {

		return getPersistence().findBycalendarBookingId_PrevAndNext(
			protagonistId, calendarBookingId, orderByComparator);
	}

	/**
	 * Removes all the protagonists where calendarBookingId = &#63; from the database.
	 *
	 * @param calendarBookingId the calendar booking ID
	 */
	public static void removeBycalendarBookingId(long calendarBookingId) {
		getPersistence().removeBycalendarBookingId(calendarBookingId);
	}

	/**
	 * Returns the number of protagonists where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @return the number of matching protagonists
	 */
	public static int countBycalendarBookingId(long calendarBookingId) {
		return getPersistence().countBycalendarBookingId(calendarBookingId);
	}

	/**
	 * Returns all the protagonists where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching protagonists
	 */
	public static List<Protagonist> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

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
	public static List<Protagonist> findByuserId(
		long userId, int start, int end) {

		return getPersistence().findByuserId(userId, start, end);
	}

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
	public static List<Protagonist> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Protagonist> orderByComparator) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator);
	}

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
	public static List<Protagonist> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Protagonist> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first protagonist in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	public static Protagonist findByuserId_First(
			long userId, OrderByComparator<Protagonist> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchProtagonistException {

		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first protagonist in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	public static Protagonist fetchByuserId_First(
		long userId, OrderByComparator<Protagonist> orderByComparator) {

		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last protagonist in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	public static Protagonist findByuserId_Last(
			long userId, OrderByComparator<Protagonist> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchProtagonistException {

		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last protagonist in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	public static Protagonist fetchByuserId_Last(
		long userId, OrderByComparator<Protagonist> orderByComparator) {

		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the protagonists before and after the current protagonist in the ordered set where userId = &#63;.
	 *
	 * @param protagonistId the primary key of the current protagonist
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next protagonist
	 * @throws NoSuchProtagonistException if a protagonist with the primary key could not be found
	 */
	public static Protagonist[] findByuserId_PrevAndNext(
			long protagonistId, long userId,
			OrderByComparator<Protagonist> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchProtagonistException {

		return getPersistence().findByuserId_PrevAndNext(
			protagonistId, userId, orderByComparator);
	}

	/**
	 * Removes all the protagonists where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of protagonists where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching protagonists
	 */
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Caches the protagonist in the entity cache if it is enabled.
	 *
	 * @param protagonist the protagonist
	 */
	public static void cacheResult(Protagonist protagonist) {
		getPersistence().cacheResult(protagonist);
	}

	/**
	 * Caches the protagonists in the entity cache if it is enabled.
	 *
	 * @param protagonists the protagonists
	 */
	public static void cacheResult(List<Protagonist> protagonists) {
		getPersistence().cacheResult(protagonists);
	}

	/**
	 * Creates a new protagonist with the primary key. Does not add the protagonist to the database.
	 *
	 * @param protagonistId the primary key for the new protagonist
	 * @return the new protagonist
	 */
	public static Protagonist create(long protagonistId) {
		return getPersistence().create(protagonistId);
	}

	/**
	 * Removes the protagonist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param protagonistId the primary key of the protagonist
	 * @return the protagonist that was removed
	 * @throws NoSuchProtagonistException if a protagonist with the primary key could not be found
	 */
	public static Protagonist remove(long protagonistId)
		throws avanis.calendarbooking.sb.exception.NoSuchProtagonistException {

		return getPersistence().remove(protagonistId);
	}

	public static Protagonist updateImpl(Protagonist protagonist) {
		return getPersistence().updateImpl(protagonist);
	}

	/**
	 * Returns the protagonist with the primary key or throws a <code>NoSuchProtagonistException</code> if it could not be found.
	 *
	 * @param protagonistId the primary key of the protagonist
	 * @return the protagonist
	 * @throws NoSuchProtagonistException if a protagonist with the primary key could not be found
	 */
	public static Protagonist findByPrimaryKey(long protagonistId)
		throws avanis.calendarbooking.sb.exception.NoSuchProtagonistException {

		return getPersistence().findByPrimaryKey(protagonistId);
	}

	/**
	 * Returns the protagonist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param protagonistId the primary key of the protagonist
	 * @return the protagonist, or <code>null</code> if a protagonist with the primary key could not be found
	 */
	public static Protagonist fetchByPrimaryKey(long protagonistId) {
		return getPersistence().fetchByPrimaryKey(protagonistId);
	}

	/**
	 * Returns all the protagonists.
	 *
	 * @return the protagonists
	 */
	public static List<Protagonist> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Protagonist> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Protagonist> findAll(
		int start, int end, OrderByComparator<Protagonist> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Protagonist> findAll(
		int start, int end, OrderByComparator<Protagonist> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the protagonists from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of protagonists.
	 *
	 * @return the number of protagonists
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProtagonistPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ProtagonistPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ProtagonistPersistence _persistence;

}