/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service.persistence;

import avanis.calendarbooking.sb.model.Sponsor;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the sponsor service. This utility wraps <code>avanis.calendarbooking.sb.service.persistence.impl.SponsorPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SponsorPersistence
 * @generated
 */
public class SponsorUtil {

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
	public static void clearCache(Sponsor sponsor) {
		getPersistence().clearCache(sponsor);
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
	public static Map<Serializable, Sponsor> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Sponsor> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Sponsor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Sponsor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Sponsor> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Sponsor update(Sponsor sponsor) {
		return getPersistence().update(sponsor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Sponsor update(
		Sponsor sponsor, ServiceContext serviceContext) {

		return getPersistence().update(sponsor, serviceContext);
	}

	/**
	 * Returns all the sponsors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sponsors
	 */
	public static List<Sponsor> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Sponsor> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Sponsor> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Sponsor> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Sponsor> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Sponsor> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sponsor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sponsor
	 * @throws NoSuchSponsorException if a matching sponsor could not be found
	 */
	public static Sponsor findByUuid_First(
			String uuid, OrderByComparator<Sponsor> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchSponsorException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first sponsor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	public static Sponsor fetchByUuid_First(
		String uuid, OrderByComparator<Sponsor> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last sponsor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sponsor
	 * @throws NoSuchSponsorException if a matching sponsor could not be found
	 */
	public static Sponsor findByUuid_Last(
			String uuid, OrderByComparator<Sponsor> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchSponsorException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last sponsor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	public static Sponsor fetchByUuid_Last(
		String uuid, OrderByComparator<Sponsor> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the sponsors before and after the current sponsor in the ordered set where uuid = &#63;.
	 *
	 * @param sponsorId the primary key of the current sponsor
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sponsor
	 * @throws NoSuchSponsorException if a sponsor with the primary key could not be found
	 */
	public static Sponsor[] findByUuid_PrevAndNext(
			long sponsorId, String uuid,
			OrderByComparator<Sponsor> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchSponsorException {

		return getPersistence().findByUuid_PrevAndNext(
			sponsorId, uuid, orderByComparator);
	}

	/**
	 * Removes all the sponsors where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of sponsors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sponsors
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the sponsor where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSponsorException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sponsor
	 * @throws NoSuchSponsorException if a matching sponsor could not be found
	 */
	public static Sponsor findByUUID_G(String uuid, long groupId)
		throws avanis.calendarbooking.sb.exception.NoSuchSponsorException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the sponsor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	public static Sponsor fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the sponsor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	public static Sponsor fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the sponsor where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the sponsor that was removed
	 */
	public static Sponsor removeByUUID_G(String uuid, long groupId)
		throws avanis.calendarbooking.sb.exception.NoSuchSponsorException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of sponsors where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching sponsors
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the sponsors where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching sponsors
	 */
	public static List<Sponsor> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<Sponsor> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<Sponsor> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Sponsor> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<Sponsor> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Sponsor> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sponsor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sponsor
	 * @throws NoSuchSponsorException if a matching sponsor could not be found
	 */
	public static Sponsor findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Sponsor> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchSponsorException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first sponsor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	public static Sponsor fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Sponsor> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last sponsor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sponsor
	 * @throws NoSuchSponsorException if a matching sponsor could not be found
	 */
	public static Sponsor findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Sponsor> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchSponsorException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last sponsor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	public static Sponsor fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Sponsor> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static Sponsor[] findByUuid_C_PrevAndNext(
			long sponsorId, String uuid, long companyId,
			OrderByComparator<Sponsor> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchSponsorException {

		return getPersistence().findByUuid_C_PrevAndNext(
			sponsorId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the sponsors where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of sponsors where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching sponsors
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the sponsors where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching sponsors
	 */
	public static List<Sponsor> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

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
	public static List<Sponsor> findByuserId(long userId, int start, int end) {
		return getPersistence().findByuserId(userId, start, end);
	}

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
	public static List<Sponsor> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Sponsor> orderByComparator) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator);
	}

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
	public static List<Sponsor> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Sponsor> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sponsor in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sponsor
	 * @throws NoSuchSponsorException if a matching sponsor could not be found
	 */
	public static Sponsor findByuserId_First(
			long userId, OrderByComparator<Sponsor> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchSponsorException {

		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first sponsor in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	public static Sponsor fetchByuserId_First(
		long userId, OrderByComparator<Sponsor> orderByComparator) {

		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last sponsor in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sponsor
	 * @throws NoSuchSponsorException if a matching sponsor could not be found
	 */
	public static Sponsor findByuserId_Last(
			long userId, OrderByComparator<Sponsor> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchSponsorException {

		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last sponsor in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	public static Sponsor fetchByuserId_Last(
		long userId, OrderByComparator<Sponsor> orderByComparator) {

		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the sponsors before and after the current sponsor in the ordered set where userId = &#63;.
	 *
	 * @param sponsorId the primary key of the current sponsor
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sponsor
	 * @throws NoSuchSponsorException if a sponsor with the primary key could not be found
	 */
	public static Sponsor[] findByuserId_PrevAndNext(
			long sponsorId, long userId,
			OrderByComparator<Sponsor> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchSponsorException {

		return getPersistence().findByuserId_PrevAndNext(
			sponsorId, userId, orderByComparator);
	}

	/**
	 * Removes all the sponsors where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of sponsors where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching sponsors
	 */
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Returns all the sponsors where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @return the matching sponsors
	 */
	public static List<Sponsor> findBycalendarBookingId(
		long calendarBookingId) {

		return getPersistence().findBycalendarBookingId(calendarBookingId);
	}

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
	public static List<Sponsor> findBycalendarBookingId(
		long calendarBookingId, int start, int end) {

		return getPersistence().findBycalendarBookingId(
			calendarBookingId, start, end);
	}

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
	public static List<Sponsor> findBycalendarBookingId(
		long calendarBookingId, int start, int end,
		OrderByComparator<Sponsor> orderByComparator) {

		return getPersistence().findBycalendarBookingId(
			calendarBookingId, start, end, orderByComparator);
	}

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
	public static List<Sponsor> findBycalendarBookingId(
		long calendarBookingId, int start, int end,
		OrderByComparator<Sponsor> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBycalendarBookingId(
			calendarBookingId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sponsor in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sponsor
	 * @throws NoSuchSponsorException if a matching sponsor could not be found
	 */
	public static Sponsor findBycalendarBookingId_First(
			long calendarBookingId,
			OrderByComparator<Sponsor> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchSponsorException {

		return getPersistence().findBycalendarBookingId_First(
			calendarBookingId, orderByComparator);
	}

	/**
	 * Returns the first sponsor in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	public static Sponsor fetchBycalendarBookingId_First(
		long calendarBookingId, OrderByComparator<Sponsor> orderByComparator) {

		return getPersistence().fetchBycalendarBookingId_First(
			calendarBookingId, orderByComparator);
	}

	/**
	 * Returns the last sponsor in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sponsor
	 * @throws NoSuchSponsorException if a matching sponsor could not be found
	 */
	public static Sponsor findBycalendarBookingId_Last(
			long calendarBookingId,
			OrderByComparator<Sponsor> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchSponsorException {

		return getPersistence().findBycalendarBookingId_Last(
			calendarBookingId, orderByComparator);
	}

	/**
	 * Returns the last sponsor in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sponsor, or <code>null</code> if a matching sponsor could not be found
	 */
	public static Sponsor fetchBycalendarBookingId_Last(
		long calendarBookingId, OrderByComparator<Sponsor> orderByComparator) {

		return getPersistence().fetchBycalendarBookingId_Last(
			calendarBookingId, orderByComparator);
	}

	/**
	 * Returns the sponsors before and after the current sponsor in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param sponsorId the primary key of the current sponsor
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sponsor
	 * @throws NoSuchSponsorException if a sponsor with the primary key could not be found
	 */
	public static Sponsor[] findBycalendarBookingId_PrevAndNext(
			long sponsorId, long calendarBookingId,
			OrderByComparator<Sponsor> orderByComparator)
		throws avanis.calendarbooking.sb.exception.NoSuchSponsorException {

		return getPersistence().findBycalendarBookingId_PrevAndNext(
			sponsorId, calendarBookingId, orderByComparator);
	}

	/**
	 * Removes all the sponsors where calendarBookingId = &#63; from the database.
	 *
	 * @param calendarBookingId the calendar booking ID
	 */
	public static void removeBycalendarBookingId(long calendarBookingId) {
		getPersistence().removeBycalendarBookingId(calendarBookingId);
	}

	/**
	 * Returns the number of sponsors where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @return the number of matching sponsors
	 */
	public static int countBycalendarBookingId(long calendarBookingId) {
		return getPersistence().countBycalendarBookingId(calendarBookingId);
	}

	/**
	 * Caches the sponsor in the entity cache if it is enabled.
	 *
	 * @param sponsor the sponsor
	 */
	public static void cacheResult(Sponsor sponsor) {
		getPersistence().cacheResult(sponsor);
	}

	/**
	 * Caches the sponsors in the entity cache if it is enabled.
	 *
	 * @param sponsors the sponsors
	 */
	public static void cacheResult(List<Sponsor> sponsors) {
		getPersistence().cacheResult(sponsors);
	}

	/**
	 * Creates a new sponsor with the primary key. Does not add the sponsor to the database.
	 *
	 * @param sponsorId the primary key for the new sponsor
	 * @return the new sponsor
	 */
	public static Sponsor create(long sponsorId) {
		return getPersistence().create(sponsorId);
	}

	/**
	 * Removes the sponsor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sponsorId the primary key of the sponsor
	 * @return the sponsor that was removed
	 * @throws NoSuchSponsorException if a sponsor with the primary key could not be found
	 */
	public static Sponsor remove(long sponsorId)
		throws avanis.calendarbooking.sb.exception.NoSuchSponsorException {

		return getPersistence().remove(sponsorId);
	}

	public static Sponsor updateImpl(Sponsor sponsor) {
		return getPersistence().updateImpl(sponsor);
	}

	/**
	 * Returns the sponsor with the primary key or throws a <code>NoSuchSponsorException</code> if it could not be found.
	 *
	 * @param sponsorId the primary key of the sponsor
	 * @return the sponsor
	 * @throws NoSuchSponsorException if a sponsor with the primary key could not be found
	 */
	public static Sponsor findByPrimaryKey(long sponsorId)
		throws avanis.calendarbooking.sb.exception.NoSuchSponsorException {

		return getPersistence().findByPrimaryKey(sponsorId);
	}

	/**
	 * Returns the sponsor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sponsorId the primary key of the sponsor
	 * @return the sponsor, or <code>null</code> if a sponsor with the primary key could not be found
	 */
	public static Sponsor fetchByPrimaryKey(long sponsorId) {
		return getPersistence().fetchByPrimaryKey(sponsorId);
	}

	/**
	 * Returns all the sponsors.
	 *
	 * @return the sponsors
	 */
	public static List<Sponsor> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Sponsor> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Sponsor> findAll(
		int start, int end, OrderByComparator<Sponsor> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Sponsor> findAll(
		int start, int end, OrderByComparator<Sponsor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sponsors from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sponsors.
	 *
	 * @return the number of sponsors
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SponsorPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(SponsorPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile SponsorPersistence _persistence;

}