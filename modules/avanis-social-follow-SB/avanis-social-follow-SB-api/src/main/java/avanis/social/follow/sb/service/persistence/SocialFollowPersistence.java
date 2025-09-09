/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.social.follow.sb.service.persistence;

import avanis.social.follow.sb.exception.NoSuchSocialFollowException;
import avanis.social.follow.sb.model.SocialFollow;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the social follow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialFollowUtil
 * @generated
 */
@ProviderType
public interface SocialFollowPersistence extends BasePersistence<SocialFollow> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SocialFollowUtil} to access the social follow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the social follows where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching social follows
	 */
	public java.util.List<SocialFollow> findByUuid(String uuid);

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
	public java.util.List<SocialFollow> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<SocialFollow> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
			orderByComparator);

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
	public java.util.List<SocialFollow> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first social follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	public SocialFollow findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
				orderByComparator)
		throws NoSuchSocialFollowException;

	/**
	 * Returns the first social follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public SocialFollow fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
			orderByComparator);

	/**
	 * Returns the last social follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	public SocialFollow findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
				orderByComparator)
		throws NoSuchSocialFollowException;

	/**
	 * Returns the last social follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public SocialFollow fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
			orderByComparator);

	/**
	 * Returns the social follows before and after the current social follow in the ordered set where uuid = &#63;.
	 *
	 * @param socialFollowId the primary key of the current social follow
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social follow
	 * @throws NoSuchSocialFollowException if a social follow with the primary key could not be found
	 */
	public SocialFollow[] findByUuid_PrevAndNext(
			long socialFollowId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
				orderByComparator)
		throws NoSuchSocialFollowException;

	/**
	 * Removes all the social follows where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of social follows where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching social follows
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the social follow where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSocialFollowException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	public SocialFollow findByUUID_G(String uuid, long groupId)
		throws NoSuchSocialFollowException;

	/**
	 * Returns the social follow where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public SocialFollow fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the social follow where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public SocialFollow fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the social follow where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the social follow that was removed
	 */
	public SocialFollow removeByUUID_G(String uuid, long groupId)
		throws NoSuchSocialFollowException;

	/**
	 * Returns the number of social follows where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching social follows
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the social follows where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching social follows
	 */
	public java.util.List<SocialFollow> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<SocialFollow> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<SocialFollow> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
			orderByComparator);

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
	public java.util.List<SocialFollow> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first social follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	public SocialFollow findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
				orderByComparator)
		throws NoSuchSocialFollowException;

	/**
	 * Returns the first social follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public SocialFollow fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
			orderByComparator);

	/**
	 * Returns the last social follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	public SocialFollow findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
				orderByComparator)
		throws NoSuchSocialFollowException;

	/**
	 * Returns the last social follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public SocialFollow fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
			orderByComparator);

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
	public SocialFollow[] findByUuid_C_PrevAndNext(
			long socialFollowId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
				orderByComparator)
		throws NoSuchSocialFollowException;

	/**
	 * Removes all the social follows where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of social follows where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching social follows
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the social follows where userId = &#63; and accepted = &#63;.
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @return the matching social follows
	 */
	public java.util.List<SocialFollow> findBygetFollowing(
		long userId, boolean accepted);

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
	public java.util.List<SocialFollow> findBygetFollowing(
		long userId, boolean accepted, int start, int end);

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
	public java.util.List<SocialFollow> findBygetFollowing(
		long userId, boolean accepted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
			orderByComparator);

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
	public java.util.List<SocialFollow> findBygetFollowing(
		long userId, boolean accepted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first social follow in the ordered set where userId = &#63; and accepted = &#63;.
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	public SocialFollow findBygetFollowing_First(
			long userId, boolean accepted,
			com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
				orderByComparator)
		throws NoSuchSocialFollowException;

	/**
	 * Returns the first social follow in the ordered set where userId = &#63; and accepted = &#63;.
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public SocialFollow fetchBygetFollowing_First(
		long userId, boolean accepted,
		com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
			orderByComparator);

	/**
	 * Returns the last social follow in the ordered set where userId = &#63; and accepted = &#63;.
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	public SocialFollow findBygetFollowing_Last(
			long userId, boolean accepted,
			com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
				orderByComparator)
		throws NoSuchSocialFollowException;

	/**
	 * Returns the last social follow in the ordered set where userId = &#63; and accepted = &#63;.
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public SocialFollow fetchBygetFollowing_Last(
		long userId, boolean accepted,
		com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
			orderByComparator);

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
	public SocialFollow[] findBygetFollowing_PrevAndNext(
			long socialFollowId, long userId, boolean accepted,
			com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
				orderByComparator)
		throws NoSuchSocialFollowException;

	/**
	 * Removes all the social follows where userId = &#63; and accepted = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 */
	public void removeBygetFollowing(long userId, boolean accepted);

	/**
	 * Returns the number of social follows where userId = &#63; and accepted = &#63;.
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @return the number of matching social follows
	 */
	public int countBygetFollowing(long userId, boolean accepted);

	/**
	 * Returns all the social follows where followsTo = &#63; and accepted = &#63;.
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @return the matching social follows
	 */
	public java.util.List<SocialFollow> findBygetFollowers(
		long followsTo, boolean accepted);

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
	public java.util.List<SocialFollow> findBygetFollowers(
		long followsTo, boolean accepted, int start, int end);

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
	public java.util.List<SocialFollow> findBygetFollowers(
		long followsTo, boolean accepted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
			orderByComparator);

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
	public java.util.List<SocialFollow> findBygetFollowers(
		long followsTo, boolean accepted, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first social follow in the ordered set where followsTo = &#63; and accepted = &#63;.
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	public SocialFollow findBygetFollowers_First(
			long followsTo, boolean accepted,
			com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
				orderByComparator)
		throws NoSuchSocialFollowException;

	/**
	 * Returns the first social follow in the ordered set where followsTo = &#63; and accepted = &#63;.
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public SocialFollow fetchBygetFollowers_First(
		long followsTo, boolean accepted,
		com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
			orderByComparator);

	/**
	 * Returns the last social follow in the ordered set where followsTo = &#63; and accepted = &#63;.
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	public SocialFollow findBygetFollowers_Last(
			long followsTo, boolean accepted,
			com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
				orderByComparator)
		throws NoSuchSocialFollowException;

	/**
	 * Returns the last social follow in the ordered set where followsTo = &#63; and accepted = &#63;.
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public SocialFollow fetchBygetFollowers_Last(
		long followsTo, boolean accepted,
		com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
			orderByComparator);

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
	public SocialFollow[] findBygetFollowers_PrevAndNext(
			long socialFollowId, long followsTo, boolean accepted,
			com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
				orderByComparator)
		throws NoSuchSocialFollowException;

	/**
	 * Removes all the social follows where followsTo = &#63; and accepted = &#63; from the database.
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 */
	public void removeBygetFollowers(long followsTo, boolean accepted);

	/**
	 * Returns the number of social follows where followsTo = &#63; and accepted = &#63;.
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @return the number of matching social follows
	 */
	public int countBygetFollowers(long followsTo, boolean accepted);

	/**
	 * Returns the social follow where userId = &#63; and followsTo = &#63; or throws a <code>NoSuchSocialFollowException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param followsTo the follows to
	 * @return the matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	public SocialFollow findBygetFollow(long userId, long followsTo)
		throws NoSuchSocialFollowException;

	/**
	 * Returns the social follow where userId = &#63; and followsTo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param followsTo the follows to
	 * @return the matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public SocialFollow fetchBygetFollow(long userId, long followsTo);

	/**
	 * Returns the social follow where userId = &#63; and followsTo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param followsTo the follows to
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public SocialFollow fetchBygetFollow(
		long userId, long followsTo, boolean useFinderCache);

	/**
	 * Removes the social follow where userId = &#63; and followsTo = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param followsTo the follows to
	 * @return the social follow that was removed
	 */
	public SocialFollow removeBygetFollow(long userId, long followsTo)
		throws NoSuchSocialFollowException;

	/**
	 * Returns the number of social follows where userId = &#63; and followsTo = &#63;.
	 *
	 * @param userId the user ID
	 * @param followsTo the follows to
	 * @return the number of matching social follows
	 */
	public int countBygetFollow(long userId, long followsTo);

	/**
	 * Caches the social follow in the entity cache if it is enabled.
	 *
	 * @param socialFollow the social follow
	 */
	public void cacheResult(SocialFollow socialFollow);

	/**
	 * Caches the social follows in the entity cache if it is enabled.
	 *
	 * @param socialFollows the social follows
	 */
	public void cacheResult(java.util.List<SocialFollow> socialFollows);

	/**
	 * Creates a new social follow with the primary key. Does not add the social follow to the database.
	 *
	 * @param socialFollowId the primary key for the new social follow
	 * @return the new social follow
	 */
	public SocialFollow create(long socialFollowId);

	/**
	 * Removes the social follow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param socialFollowId the primary key of the social follow
	 * @return the social follow that was removed
	 * @throws NoSuchSocialFollowException if a social follow with the primary key could not be found
	 */
	public SocialFollow remove(long socialFollowId)
		throws NoSuchSocialFollowException;

	public SocialFollow updateImpl(SocialFollow socialFollow);

	/**
	 * Returns the social follow with the primary key or throws a <code>NoSuchSocialFollowException</code> if it could not be found.
	 *
	 * @param socialFollowId the primary key of the social follow
	 * @return the social follow
	 * @throws NoSuchSocialFollowException if a social follow with the primary key could not be found
	 */
	public SocialFollow findByPrimaryKey(long socialFollowId)
		throws NoSuchSocialFollowException;

	/**
	 * Returns the social follow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param socialFollowId the primary key of the social follow
	 * @return the social follow, or <code>null</code> if a social follow with the primary key could not be found
	 */
	public SocialFollow fetchByPrimaryKey(long socialFollowId);

	/**
	 * Returns all the social follows.
	 *
	 * @return the social follows
	 */
	public java.util.List<SocialFollow> findAll();

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
	public java.util.List<SocialFollow> findAll(int start, int end);

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
	public java.util.List<SocialFollow> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
			orderByComparator);

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
	public java.util.List<SocialFollow> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SocialFollow>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the social follows from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of social follows.
	 *
	 * @return the number of social follows
	 */
	public int countAll();

}