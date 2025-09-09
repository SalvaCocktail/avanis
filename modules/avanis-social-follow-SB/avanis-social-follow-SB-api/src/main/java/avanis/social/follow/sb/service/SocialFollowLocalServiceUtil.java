/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.social.follow.sb.service;

import avanis.social.follow.sb.model.SocialFollow;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SocialFollow. This utility wraps
 * <code>avanis.social.follow.sb.service.impl.SocialFollowLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SocialFollowLocalService
 * @generated
 */
public class SocialFollowLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>avanis.social.follow.sb.service.impl.SocialFollowLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static SocialFollow acceptFollow(long userId, long principalId) {
		return getService().acceptFollow(userId, principalId);
	}

	/**
	 * Adds the social follow to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SocialFollowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param socialFollow the social follow
	 * @return the social follow that was added
	 */
	public static SocialFollow addSocialFollow(SocialFollow socialFollow) {
		return getService().addSocialFollow(socialFollow);
	}

	public static Integer countFollowers(long userId) {
		return getService().countFollowers(userId);
	}

	public static Long countFollowers(long userId, String filterName) {
		return getService().countFollowers(userId, filterName);
	}

	public static Integer countFollowing(long userId) {
		return getService().countFollowing(userId);
	}

	public static Long countFollowing(long userId, String filterName) {
		return getService().countFollowing(userId, filterName);
	}

	public static Integer countFollowRequests(long userId) {
		return getService().countFollowRequests(userId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new social follow with the primary key. Does not add the social follow to the database.
	 *
	 * @param socialFollowId the primary key for the new social follow
	 * @return the new social follow
	 */
	public static SocialFollow createSocialFollow(long socialFollowId) {
		return getService().createSocialFollow(socialFollowId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the social follow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SocialFollowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param socialFollowId the primary key of the social follow
	 * @return the social follow that was removed
	 * @throws PortalException if a social follow with the primary key could not be found
	 */
	public static SocialFollow deleteSocialFollow(long socialFollowId)
		throws PortalException {

		return getService().deleteSocialFollow(socialFollowId);
	}

	/**
	 * Deletes the social follow from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SocialFollowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param socialFollow the social follow
	 * @return the social follow that was removed
	 */
	public static SocialFollow deleteSocialFollow(SocialFollow socialFollow) {
		return getService().deleteSocialFollow(socialFollow);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.social.follow.sb.model.impl.SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.social.follow.sb.model.impl.SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static SocialFollow fetchSocialFollow(long socialFollowId) {
		return getService().fetchSocialFollow(socialFollowId);
	}

	/**
	 * Returns the social follow matching the UUID and group.
	 *
	 * @param uuid the social follow's UUID
	 * @param groupId the primary key of the group
	 * @return the matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	public static SocialFollow fetchSocialFollowByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchSocialFollowByUuidAndGroupId(uuid, groupId);
	}

	public static Boolean follows(long principalId, long userId)
		throws PortalException {

		return getService().follows(principalId, userId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static SocialFollow getFollow(long userId, long followsToUserId) {
		return getService().getFollow(userId, followsToUserId);
	}

	public static List<com.liferay.portal.kernel.model.User> getFollowers(
		long userId, String filterName, int start, int end) {

		return getService().getFollowers(userId, filterName, start, end);
	}

	public static List<com.liferay.portal.kernel.model.User> getFollowings(
		long userId, String filterName, int start, int end) {

		return getService().getFollowings(userId, filterName, start, end);
	}

	public static List<com.liferay.portal.kernel.model.User> getFollowRequests(
		long userId, int start, int end) {

		return getService().getFollowRequests(userId, start, end);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the social follow with the primary key.
	 *
	 * @param socialFollowId the primary key of the social follow
	 * @return the social follow
	 * @throws PortalException if a social follow with the primary key could not be found
	 */
	public static SocialFollow getSocialFollow(long socialFollowId)
		throws PortalException {

		return getService().getSocialFollow(socialFollowId);
	}

	/**
	 * Returns the social follow matching the UUID and group.
	 *
	 * @param uuid the social follow's UUID
	 * @param groupId the primary key of the group
	 * @return the matching social follow
	 * @throws PortalException if a matching social follow could not be found
	 */
	public static SocialFollow getSocialFollowByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getSocialFollowByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the social follows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.social.follow.sb.model.impl.SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @return the range of social follows
	 */
	public static List<SocialFollow> getSocialFollows(int start, int end) {
		return getService().getSocialFollows(start, end);
	}

	/**
	 * Returns all the social follows matching the UUID and company.
	 *
	 * @param uuid the UUID of the social follows
	 * @param companyId the primary key of the company
	 * @return the matching social follows, or an empty list if no matches were found
	 */
	public static List<SocialFollow> getSocialFollowsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getSocialFollowsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of social follows matching the UUID and company.
	 *
	 * @param uuid the UUID of the social follows
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching social follows, or an empty list if no matches were found
	 */
	public static List<SocialFollow> getSocialFollowsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SocialFollow> orderByComparator) {

		return getService().getSocialFollowsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of social follows.
	 *
	 * @return the number of social follows
	 */
	public static int getSocialFollowsCount() {
		return getService().getSocialFollowsCount();
	}

	/**
	 * Updates the social follow in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SocialFollowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param socialFollow the social follow
	 * @return the social follow that was updated
	 */
	public static SocialFollow updateSocialFollow(SocialFollow socialFollow) {
		return getService().updateSocialFollow(socialFollow);
	}

	public static SocialFollowLocalService getService() {
		return _service;
	}

	public static void setService(SocialFollowLocalService service) {
		_service = service;
	}

	private static volatile SocialFollowLocalService _service;

}