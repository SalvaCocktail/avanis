/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.social.follow.sb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link SocialFollowLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SocialFollowLocalService
 * @generated
 */
public class SocialFollowLocalServiceWrapper
	implements ServiceWrapper<SocialFollowLocalService>,
			   SocialFollowLocalService {

	public SocialFollowLocalServiceWrapper() {
		this(null);
	}

	public SocialFollowLocalServiceWrapper(
		SocialFollowLocalService socialFollowLocalService) {

		_socialFollowLocalService = socialFollowLocalService;
	}

	@Override
	public avanis.social.follow.sb.model.SocialFollow acceptFollow(
		long userId, long principalId) {

		return _socialFollowLocalService.acceptFollow(userId, principalId);
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
	@Override
	public avanis.social.follow.sb.model.SocialFollow addSocialFollow(
		avanis.social.follow.sb.model.SocialFollow socialFollow) {

		return _socialFollowLocalService.addSocialFollow(socialFollow);
	}

	@Override
	public Integer countFollowers(long userId) {
		return _socialFollowLocalService.countFollowers(userId);
	}

	@Override
	public Long countFollowers(long userId, String filterName) {
		return _socialFollowLocalService.countFollowers(userId, filterName);
	}

	@Override
	public Integer countFollowing(long userId) {
		return _socialFollowLocalService.countFollowing(userId);
	}

	@Override
	public Long countFollowing(long userId, String filterName) {
		return _socialFollowLocalService.countFollowing(userId, filterName);
	}

	@Override
	public Integer countFollowRequests(long userId) {
		return _socialFollowLocalService.countFollowRequests(userId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialFollowLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new social follow with the primary key. Does not add the social follow to the database.
	 *
	 * @param socialFollowId the primary key for the new social follow
	 * @return the new social follow
	 */
	@Override
	public avanis.social.follow.sb.model.SocialFollow createSocialFollow(
		long socialFollowId) {

		return _socialFollowLocalService.createSocialFollow(socialFollowId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialFollowLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public avanis.social.follow.sb.model.SocialFollow deleteSocialFollow(
			long socialFollowId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialFollowLocalService.deleteSocialFollow(socialFollowId);
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
	@Override
	public avanis.social.follow.sb.model.SocialFollow deleteSocialFollow(
		avanis.social.follow.sb.model.SocialFollow socialFollow) {

		return _socialFollowLocalService.deleteSocialFollow(socialFollow);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _socialFollowLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _socialFollowLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _socialFollowLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _socialFollowLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _socialFollowLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _socialFollowLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _socialFollowLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _socialFollowLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public avanis.social.follow.sb.model.SocialFollow fetchSocialFollow(
		long socialFollowId) {

		return _socialFollowLocalService.fetchSocialFollow(socialFollowId);
	}

	/**
	 * Returns the social follow matching the UUID and group.
	 *
	 * @param uuid the social follow's UUID
	 * @param groupId the primary key of the group
	 * @return the matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	@Override
	public avanis.social.follow.sb.model.SocialFollow
		fetchSocialFollowByUuidAndGroupId(String uuid, long groupId) {

		return _socialFollowLocalService.fetchSocialFollowByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public Boolean follows(long principalId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialFollowLocalService.follows(principalId, userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _socialFollowLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _socialFollowLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public avanis.social.follow.sb.model.SocialFollow getFollow(
		long userId, long followsToUserId) {

		return _socialFollowLocalService.getFollow(userId, followsToUserId);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.User> getFollowers(
		long userId, String filterName, int start, int end) {

		return _socialFollowLocalService.getFollowers(
			userId, filterName, start, end);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.User> getFollowings(
		long userId, String filterName, int start, int end) {

		return _socialFollowLocalService.getFollowings(
			userId, filterName, start, end);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.User>
		getFollowRequests(long userId, int start, int end) {

		return _socialFollowLocalService.getFollowRequests(userId, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _socialFollowLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _socialFollowLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialFollowLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the social follow with the primary key.
	 *
	 * @param socialFollowId the primary key of the social follow
	 * @return the social follow
	 * @throws PortalException if a social follow with the primary key could not be found
	 */
	@Override
	public avanis.social.follow.sb.model.SocialFollow getSocialFollow(
			long socialFollowId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialFollowLocalService.getSocialFollow(socialFollowId);
	}

	/**
	 * Returns the social follow matching the UUID and group.
	 *
	 * @param uuid the social follow's UUID
	 * @param groupId the primary key of the group
	 * @return the matching social follow
	 * @throws PortalException if a matching social follow could not be found
	 */
	@Override
	public avanis.social.follow.sb.model.SocialFollow
			getSocialFollowByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _socialFollowLocalService.getSocialFollowByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<avanis.social.follow.sb.model.SocialFollow>
		getSocialFollows(int start, int end) {

		return _socialFollowLocalService.getSocialFollows(start, end);
	}

	/**
	 * Returns all the social follows matching the UUID and company.
	 *
	 * @param uuid the UUID of the social follows
	 * @param companyId the primary key of the company
	 * @return the matching social follows, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<avanis.social.follow.sb.model.SocialFollow>
		getSocialFollowsByUuidAndCompanyId(String uuid, long companyId) {

		return _socialFollowLocalService.getSocialFollowsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<avanis.social.follow.sb.model.SocialFollow>
		getSocialFollowsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<avanis.social.follow.sb.model.SocialFollow>
					orderByComparator) {

		return _socialFollowLocalService.getSocialFollowsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of social follows.
	 *
	 * @return the number of social follows
	 */
	@Override
	public int getSocialFollowsCount() {
		return _socialFollowLocalService.getSocialFollowsCount();
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
	@Override
	public avanis.social.follow.sb.model.SocialFollow updateSocialFollow(
		avanis.social.follow.sb.model.SocialFollow socialFollow) {

		return _socialFollowLocalService.updateSocialFollow(socialFollow);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _socialFollowLocalService.getBasePersistence();
	}

	@Override
	public SocialFollowLocalService getWrappedService() {
		return _socialFollowLocalService;
	}

	@Override
	public void setWrappedService(
		SocialFollowLocalService socialFollowLocalService) {

		_socialFollowLocalService = socialFollowLocalService;
	}

	private SocialFollowLocalService _socialFollowLocalService;

}