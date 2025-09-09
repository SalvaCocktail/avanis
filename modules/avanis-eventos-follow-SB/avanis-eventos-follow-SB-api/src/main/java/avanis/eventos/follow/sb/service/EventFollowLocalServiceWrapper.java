/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.eventos.follow.sb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EventFollowLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EventFollowLocalService
 * @generated
 */
public class EventFollowLocalServiceWrapper
	implements EventFollowLocalService,
			   ServiceWrapper<EventFollowLocalService> {

	public EventFollowLocalServiceWrapper() {
		this(null);
	}

	public EventFollowLocalServiceWrapper(
		EventFollowLocalService eventFollowLocalService) {

		_eventFollowLocalService = eventFollowLocalService;
	}

	/**
	 * Adds the event follow to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventFollowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventFollow the event follow
	 * @return the event follow that was added
	 */
	@Override
	public avanis.eventos.follow.sb.model.EventFollow addEventFollow(
		avanis.eventos.follow.sb.model.EventFollow eventFollow) {

		return _eventFollowLocalService.addEventFollow(eventFollow);
	}

	/**
	 * Creates a new event follow with the primary key. Does not add the event follow to the database.
	 *
	 * @param eventFollowId the primary key for the new event follow
	 * @return the new event follow
	 */
	@Override
	public avanis.eventos.follow.sb.model.EventFollow createEventFollow(
		long eventFollowId) {

		return _eventFollowLocalService.createEventFollow(eventFollowId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventFollowLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the event follow from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventFollowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventFollow the event follow
	 * @return the event follow that was removed
	 */
	@Override
	public avanis.eventos.follow.sb.model.EventFollow deleteEventFollow(
		avanis.eventos.follow.sb.model.EventFollow eventFollow) {

		return _eventFollowLocalService.deleteEventFollow(eventFollow);
	}

	/**
	 * Deletes the event follow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventFollowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventFollowId the primary key of the event follow
	 * @return the event follow that was removed
	 * @throws PortalException if a event follow with the primary key could not be found
	 */
	@Override
	public avanis.eventos.follow.sb.model.EventFollow deleteEventFollow(
			long eventFollowId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventFollowLocalService.deleteEventFollow(eventFollowId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventFollowLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _eventFollowLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _eventFollowLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eventFollowLocalService.dynamicQuery();
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

		return _eventFollowLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.eventos.follow.sb.model.impl.EventFollowModelImpl</code>.
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

		return _eventFollowLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.eventos.follow.sb.model.impl.EventFollowModelImpl</code>.
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

		return _eventFollowLocalService.dynamicQuery(
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

		return _eventFollowLocalService.dynamicQueryCount(dynamicQuery);
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

		return _eventFollowLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public avanis.eventos.follow.sb.model.EventFollow fetchEventFollow(
		long eventFollowId) {

		return _eventFollowLocalService.fetchEventFollow(eventFollowId);
	}

	/**
	 * Returns the event follow matching the UUID and group.
	 *
	 * @param uuid the event follow's UUID
	 * @param groupId the primary key of the group
	 * @return the matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	@Override
	public avanis.eventos.follow.sb.model.EventFollow
		fetchEventFollowByUuidAndGroupId(String uuid, long groupId) {

		return _eventFollowLocalService.fetchEventFollowByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public Boolean follows(long principalId, long eventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventFollowLocalService.follows(principalId, eventId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _eventFollowLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the event follow with the primary key.
	 *
	 * @param eventFollowId the primary key of the event follow
	 * @return the event follow
	 * @throws PortalException if a event follow with the primary key could not be found
	 */
	@Override
	public avanis.eventos.follow.sb.model.EventFollow getEventFollow(
			long eventFollowId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventFollowLocalService.getEventFollow(eventFollowId);
	}

	/**
	 * Returns the event follow matching the UUID and group.
	 *
	 * @param uuid the event follow's UUID
	 * @param groupId the primary key of the group
	 * @return the matching event follow
	 * @throws PortalException if a matching event follow could not be found
	 */
	@Override
	public avanis.eventos.follow.sb.model.EventFollow
			getEventFollowByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventFollowLocalService.getEventFollowByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the event follows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.eventos.follow.sb.model.impl.EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @return the range of event follows
	 */
	@Override
	public java.util.List<avanis.eventos.follow.sb.model.EventFollow>
		getEventFollows(int start, int end) {

		return _eventFollowLocalService.getEventFollows(start, end);
	}

	@Override
	public java.util.List<avanis.eventos.follow.sb.model.EventFollow>
		getEventFollowsByEventId(long eventId) {

		return _eventFollowLocalService.getEventFollowsByEventId(eventId);
	}

	@Override
	public java.util.List<avanis.eventos.follow.sb.model.EventFollow>
		getEventFollowsByUserId(long userId) {

		return _eventFollowLocalService.getEventFollowsByUserId(userId);
	}

	@Override
	public avanis.eventos.follow.sb.model.EventFollow
		getEventFollowsByUserIdAndEventFollow(long userId, long eventId) {

		return _eventFollowLocalService.getEventFollowsByUserIdAndEventFollow(
			userId, eventId);
	}

	/**
	 * Returns all the event follows matching the UUID and company.
	 *
	 * @param uuid the UUID of the event follows
	 * @param companyId the primary key of the company
	 * @return the matching event follows, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<avanis.eventos.follow.sb.model.EventFollow>
		getEventFollowsByUuidAndCompanyId(String uuid, long companyId) {

		return _eventFollowLocalService.getEventFollowsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of event follows matching the UUID and company.
	 *
	 * @param uuid the UUID of the event follows
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching event follows, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<avanis.eventos.follow.sb.model.EventFollow>
		getEventFollowsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<avanis.eventos.follow.sb.model.EventFollow>
					orderByComparator) {

		return _eventFollowLocalService.getEventFollowsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of event follows.
	 *
	 * @return the number of event follows
	 */
	@Override
	public int getEventFollowsCount() {
		return _eventFollowLocalService.getEventFollowsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _eventFollowLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _eventFollowLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eventFollowLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventFollowLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the event follow in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventFollowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventFollow the event follow
	 * @return the event follow that was updated
	 */
	@Override
	public avanis.eventos.follow.sb.model.EventFollow updateEventFollow(
		avanis.eventos.follow.sb.model.EventFollow eventFollow) {

		return _eventFollowLocalService.updateEventFollow(eventFollow);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _eventFollowLocalService.getBasePersistence();
	}

	@Override
	public EventFollowLocalService getWrappedService() {
		return _eventFollowLocalService;
	}

	@Override
	public void setWrappedService(
		EventFollowLocalService eventFollowLocalService) {

		_eventFollowLocalService = eventFollowLocalService;
	}

	private EventFollowLocalService _eventFollowLocalService;

}