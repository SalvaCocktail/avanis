/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.social.follow.sb.service.persistence;

import avanis.social.follow.sb.model.SocialFollow;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the social follow service. This utility wraps <code>avanis.social.follow.sb.service.persistence.impl.SocialFollowPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialFollowPersistence
 * @generated
 */
public class SocialFollowUtil {

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
	public static void clearCache(SocialFollow socialFollow) {
		getPersistence().clearCache(socialFollow);
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
	public static Map<Serializable, SocialFollow> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SocialFollow> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SocialFollow> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SocialFollow> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SocialFollow> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SocialFollow update(SocialFollow socialFollow) {
		return getPersistence().update(socialFollow);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SocialFollow update(
		SocialFollow socialFollow, ServiceContext serviceContext) {

		return getPersistence().update(socialFollow, serviceContext);
	}

	/**
	 * Returns all the social follows where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching social follows
	 */
	public static List<SocialFollow> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the social follows where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @return the range of matching social follows
	 */
	public static List<SocialFollow> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the social follows where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social follows
	 */
	public static List<SocialFollow> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SocialFollow> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the social follows where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching social follows
	 */
	public static List<SocialFollow> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SocialFollow> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first social follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	public static SocialFollow findByUuid_First(
			String uuid, OrderByComparator<SocialFollow> orderByComparator)
		throws avanis.social.follow.sb.exception.NoSuchSocialFollowException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first social follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public static SocialFollow fetchByUuid_First(
		String uuid, OrderByComparator<SocialFollow> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last social follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	public static SocialFollow findByUuid_Last(
			String uuid, OrderByComparator<SocialFollow> orderByComparator)
		throws avanis.social.follow.sb.exception.NoSuchSocialFollowException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last social follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public static SocialFollow fetchByUuid_Last(
		String uuid, OrderByComparator<SocialFollow> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the social follows before and after the current social follow in the ordered set where uuid = &#63;.
	 *
	 * @param socialFollowId the primary key of the current social follow
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social follow
	 * @throws NoSuchSocialFollowException if a social follow with the primary key could not be found
	 */
	public static SocialFollow[] findByUuid_PrevAndNext(
			long socialFollowId, String uuid,
			OrderByComparator<SocialFollow> orderByComparator)
		throws avanis.social.follow.sb.exception.NoSuchSocialFollowException {

		return getPersistence().findByUuid_PrevAndNext(
			socialFollowId, uuid, orderByComparator);
	}

	/**
	 * Removes all the social follows where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of social follows where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching social follows
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the social follow where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSocialFollowException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	public static SocialFollow findByUUID_G(String uuid, long groupId)
		throws avanis.social.follow.sb.exception.NoSuchSocialFollowException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the social follow where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public static SocialFollow fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the social follow where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public static SocialFollow fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the social follow where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the social follow that was removed
	 */
	public static SocialFollow removeByUUID_G(String uuid, long groupId)
		throws avanis.social.follow.sb.exception.NoSuchSocialFollowException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of social follows where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching social follows
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the social follows where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching social follows
	 */
	public static List<SocialFollow> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the social follows where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @return the range of matching social follows
	 */
	public static List<SocialFollow> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the social follows where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social follows
	 */
	public static List<SocialFollow> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SocialFollow> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the social follows where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching social follows
	 */
	public static List<SocialFollow> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SocialFollow> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first social follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	public static SocialFollow findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SocialFollow> orderByComparator)
		throws avanis.social.follow.sb.exception.NoSuchSocialFollowException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first social follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public static SocialFollow fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SocialFollow> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last social follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	public static SocialFollow findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SocialFollow> orderByComparator)
		throws avanis.social.follow.sb.exception.NoSuchSocialFollowException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last social follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public static SocialFollow fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SocialFollow> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the social follows before and after the current social follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param socialFollowId the primary key of the current social follow
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social follow
	 * @throws NoSuchSocialFollowException if a social follow with the primary key could not be found
	 */
	public static SocialFollow[] findByUuid_C_PrevAndNext(
			long socialFollowId, String uuid, long companyId,
			OrderByComparator<SocialFollow> orderByComparator)
		throws avanis.social.follow.sb.exception.NoSuchSocialFollowException {

		return getPersistence().findByUuid_C_PrevAndNext(
			socialFollowId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the social follows where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of social follows where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching social follows
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the social follows where userId = &#63; and accepted = &#63;.
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @return the matching social follows
	 */
	public static List<SocialFollow> findBygetFollowing(
		long userId, boolean accepted) {

		return getPersistence().findBygetFollowing(userId, accepted);
	}

	/**
	 * Returns a range of all the social follows where userId = &#63; and accepted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @return the range of matching social follows
	 */
	public static List<SocialFollow> findBygetFollowing(
		long userId, boolean accepted, int start, int end) {

		return getPersistence().findBygetFollowing(
			userId, accepted, start, end);
	}

	/**
	 * Returns an ordered range of all the social follows where userId = &#63; and accepted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social follows
	 */
	public static List<SocialFollow> findBygetFollowing(
		long userId, boolean accepted, int start, int end,
		OrderByComparator<SocialFollow> orderByComparator) {

		return getPersistence().findBygetFollowing(
			userId, accepted, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the social follows where userId = &#63; and accepted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching social follows
	 */
	public static List<SocialFollow> findBygetFollowing(
		long userId, boolean accepted, int start, int end,
		OrderByComparator<SocialFollow> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBygetFollowing(
			userId, accepted, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first social follow in the ordered set where userId = &#63; and accepted = &#63;.
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	public static SocialFollow findBygetFollowing_First(
			long userId, boolean accepted,
			OrderByComparator<SocialFollow> orderByComparator)
		throws avanis.social.follow.sb.exception.NoSuchSocialFollowException {

		return getPersistence().findBygetFollowing_First(
			userId, accepted, orderByComparator);
	}

	/**
	 * Returns the first social follow in the ordered set where userId = &#63; and accepted = &#63;.
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public static SocialFollow fetchBygetFollowing_First(
		long userId, boolean accepted,
		OrderByComparator<SocialFollow> orderByComparator) {

		return getPersistence().fetchBygetFollowing_First(
			userId, accepted, orderByComparator);
	}

	/**
	 * Returns the last social follow in the ordered set where userId = &#63; and accepted = &#63;.
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	public static SocialFollow findBygetFollowing_Last(
			long userId, boolean accepted,
			OrderByComparator<SocialFollow> orderByComparator)
		throws avanis.social.follow.sb.exception.NoSuchSocialFollowException {

		return getPersistence().findBygetFollowing_Last(
			userId, accepted, orderByComparator);
	}

	/**
	 * Returns the last social follow in the ordered set where userId = &#63; and accepted = &#63;.
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public static SocialFollow fetchBygetFollowing_Last(
		long userId, boolean accepted,
		OrderByComparator<SocialFollow> orderByComparator) {

		return getPersistence().fetchBygetFollowing_Last(
			userId, accepted, orderByComparator);
	}

	/**
	 * Returns the social follows before and after the current social follow in the ordered set where userId = &#63; and accepted = &#63;.
	 *
	 * @param socialFollowId the primary key of the current social follow
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social follow
	 * @throws NoSuchSocialFollowException if a social follow with the primary key could not be found
	 */
	public static SocialFollow[] findBygetFollowing_PrevAndNext(
			long socialFollowId, long userId, boolean accepted,
			OrderByComparator<SocialFollow> orderByComparator)
		throws avanis.social.follow.sb.exception.NoSuchSocialFollowException {

		return getPersistence().findBygetFollowing_PrevAndNext(
			socialFollowId, userId, accepted, orderByComparator);
	}

	/**
	 * Removes all the social follows where userId = &#63; and accepted = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 */
	public static void removeBygetFollowing(long userId, boolean accepted) {
		getPersistence().removeBygetFollowing(userId, accepted);
	}

	/**
	 * Returns the number of social follows where userId = &#63; and accepted = &#63;.
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @return the number of matching social follows
	 */
	public static int countBygetFollowing(long userId, boolean accepted) {
		return getPersistence().countBygetFollowing(userId, accepted);
	}

	/**
	 * Returns all the social follows where followsTo = &#63; and accepted = &#63;.
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @return the matching social follows
	 */
	public static List<SocialFollow> findBygetFollowers(
		long followsTo, boolean accepted) {

		return getPersistence().findBygetFollowers(followsTo, accepted);
	}

	/**
	 * Returns a range of all the social follows where followsTo = &#63; and accepted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @return the range of matching social follows
	 */
	public static List<SocialFollow> findBygetFollowers(
		long followsTo, boolean accepted, int start, int end) {

		return getPersistence().findBygetFollowers(
			followsTo, accepted, start, end);
	}

	/**
	 * Returns an ordered range of all the social follows where followsTo = &#63; and accepted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social follows
	 */
	public static List<SocialFollow> findBygetFollowers(
		long followsTo, boolean accepted, int start, int end,
		OrderByComparator<SocialFollow> orderByComparator) {

		return getPersistence().findBygetFollowers(
			followsTo, accepted, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the social follows where followsTo = &#63; and accepted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching social follows
	 */
	public static List<SocialFollow> findBygetFollowers(
		long followsTo, boolean accepted, int start, int end,
		OrderByComparator<SocialFollow> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBygetFollowers(
			followsTo, accepted, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first social follow in the ordered set where followsTo = &#63; and accepted = &#63;.
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	public static SocialFollow findBygetFollowers_First(
			long followsTo, boolean accepted,
			OrderByComparator<SocialFollow> orderByComparator)
		throws avanis.social.follow.sb.exception.NoSuchSocialFollowException {

		return getPersistence().findBygetFollowers_First(
			followsTo, accepted, orderByComparator);
	}

	/**
	 * Returns the first social follow in the ordered set where followsTo = &#63; and accepted = &#63;.
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public static SocialFollow fetchBygetFollowers_First(
		long followsTo, boolean accepted,
		OrderByComparator<SocialFollow> orderByComparator) {

		return getPersistence().fetchBygetFollowers_First(
			followsTo, accepted, orderByComparator);
	}

	/**
	 * Returns the last social follow in the ordered set where followsTo = &#63; and accepted = &#63;.
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	public static SocialFollow findBygetFollowers_Last(
			long followsTo, boolean accepted,
			OrderByComparator<SocialFollow> orderByComparator)
		throws avanis.social.follow.sb.exception.NoSuchSocialFollowException {

		return getPersistence().findBygetFollowers_Last(
			followsTo, accepted, orderByComparator);
	}

	/**
	 * Returns the last social follow in the ordered set where followsTo = &#63; and accepted = &#63;.
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public static SocialFollow fetchBygetFollowers_Last(
		long followsTo, boolean accepted,
		OrderByComparator<SocialFollow> orderByComparator) {

		return getPersistence().fetchBygetFollowers_Last(
			followsTo, accepted, orderByComparator);
	}

	/**
	 * Returns the social follows before and after the current social follow in the ordered set where followsTo = &#63; and accepted = &#63;.
	 *
	 * @param socialFollowId the primary key of the current social follow
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social follow
	 * @throws NoSuchSocialFollowException if a social follow with the primary key could not be found
	 */
	public static SocialFollow[] findBygetFollowers_PrevAndNext(
			long socialFollowId, long followsTo, boolean accepted,
			OrderByComparator<SocialFollow> orderByComparator)
		throws avanis.social.follow.sb.exception.NoSuchSocialFollowException {

		return getPersistence().findBygetFollowers_PrevAndNext(
			socialFollowId, followsTo, accepted, orderByComparator);
	}

	/**
	 * Removes all the social follows where followsTo = &#63; and accepted = &#63; from the database.
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 */
	public static void removeBygetFollowers(long followsTo, boolean accepted) {
		getPersistence().removeBygetFollowers(followsTo, accepted);
	}

	/**
	 * Returns the number of social follows where followsTo = &#63; and accepted = &#63;.
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @return the number of matching social follows
	 */
	public static int countBygetFollowers(long followsTo, boolean accepted) {
		return getPersistence().countBygetFollowers(followsTo, accepted);
	}

	/**
	 * Returns the social follow where userId = &#63; and followsTo = &#63; or throws a <code>NoSuchSocialFollowException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param followsTo the follows to
	 * @return the matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	public static SocialFollow findBygetFollow(long userId, long followsTo)
		throws avanis.social.follow.sb.exception.NoSuchSocialFollowException {

		return getPersistence().findBygetFollow(userId, followsTo);
	}

	/**
	 * Returns the social follow where userId = &#63; and followsTo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param followsTo the follows to
	 * @return the matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public static SocialFollow fetchBygetFollow(long userId, long followsTo) {
		return getPersistence().fetchBygetFollow(userId, followsTo);
	}

	/**
	 * Returns the social follow where userId = &#63; and followsTo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param followsTo the follows to
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public static SocialFollow fetchBygetFollow(
		long userId, long followsTo, boolean useFinderCache) {

		return getPersistence().fetchBygetFollow(
			userId, followsTo, useFinderCache);
	}

	/**
	 * Removes the social follow where userId = &#63; and followsTo = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param followsTo the follows to
	 * @return the social follow that was removed
	 */
	public static SocialFollow removeBygetFollow(long userId, long followsTo)
		throws avanis.social.follow.sb.exception.NoSuchSocialFollowException {

		return getPersistence().removeBygetFollow(userId, followsTo);
	}

	/**
	 * Returns the number of social follows where userId = &#63; and followsTo = &#63;.
	 *
	 * @param userId the user ID
	 * @param followsTo the follows to
	 * @return the number of matching social follows
	 */
	public static int countBygetFollow(long userId, long followsTo) {
		return getPersistence().countBygetFollow(userId, followsTo);
	}

	/**
	 * Caches the social follow in the entity cache if it is enabled.
	 *
	 * @param socialFollow the social follow
	 */
	public static void cacheResult(SocialFollow socialFollow) {
		getPersistence().cacheResult(socialFollow);
	}

	/**
	 * Caches the social follows in the entity cache if it is enabled.
	 *
	 * @param socialFollows the social follows
	 */
	public static void cacheResult(List<SocialFollow> socialFollows) {
		getPersistence().cacheResult(socialFollows);
	}

	/**
	 * Creates a new social follow with the primary key. Does not add the social follow to the database.
	 *
	 * @param socialFollowId the primary key for the new social follow
	 * @return the new social follow
	 */
	public static SocialFollow create(long socialFollowId) {
		return getPersistence().create(socialFollowId);
	}

	/**
	 * Removes the social follow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param socialFollowId the primary key of the social follow
	 * @return the social follow that was removed
	 * @throws NoSuchSocialFollowException if a social follow with the primary key could not be found
	 */
	public static SocialFollow remove(long socialFollowId)
		throws avanis.social.follow.sb.exception.NoSuchSocialFollowException {

		return getPersistence().remove(socialFollowId);
	}

	public static SocialFollow updateImpl(SocialFollow socialFollow) {
		return getPersistence().updateImpl(socialFollow);
	}

	/**
	 * Returns the social follow with the primary key or throws a <code>NoSuchSocialFollowException</code> if it could not be found.
	 *
	 * @param socialFollowId the primary key of the social follow
	 * @return the social follow
	 * @throws NoSuchSocialFollowException if a social follow with the primary key could not be found
	 */
	public static SocialFollow findByPrimaryKey(long socialFollowId)
		throws avanis.social.follow.sb.exception.NoSuchSocialFollowException {

		return getPersistence().findByPrimaryKey(socialFollowId);
	}

	/**
	 * Returns the social follow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param socialFollowId the primary key of the social follow
	 * @return the social follow, or <code>null</code> if a social follow with the primary key could not be found
	 */
	public static SocialFollow fetchByPrimaryKey(long socialFollowId) {
		return getPersistence().fetchByPrimaryKey(socialFollowId);
	}

	/**
	 * Returns all the social follows.
	 *
	 * @return the social follows
	 */
	public static List<SocialFollow> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the social follows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @return the range of social follows
	 */
	public static List<SocialFollow> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the social follows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of social follows
	 */
	public static List<SocialFollow> findAll(
		int start, int end, OrderByComparator<SocialFollow> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the social follows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of social follows
	 */
	public static List<SocialFollow> findAll(
		int start, int end, OrderByComparator<SocialFollow> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the social follows from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of social follows.
	 *
	 * @return the number of social follows
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SocialFollowPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(SocialFollowPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile SocialFollowPersistence _persistence;

}