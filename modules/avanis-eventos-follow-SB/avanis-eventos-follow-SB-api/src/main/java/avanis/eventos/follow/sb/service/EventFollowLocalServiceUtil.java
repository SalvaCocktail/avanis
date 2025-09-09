/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.eventos.follow.sb.service;

import avanis.eventos.follow.sb.model.EventFollow;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for EventFollow. This utility wraps
 * <code>avanis.eventos.follow.sb.service.impl.EventFollowLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EventFollowLocalService
 * @generated
 */
public class EventFollowLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>avanis.eventos.follow.sb.service.impl.EventFollowLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static EventFollow addEventFollow(EventFollow eventFollow) {
		return getService().addEventFollow(eventFollow);
	}

	/**
	 * Creates a new event follow with the primary key. Does not add the event follow to the database.
	 *
	 * @param eventFollowId the primary key for the new event follow
	 * @return the new event follow
	 */
	public static EventFollow createEventFollow(long eventFollowId) {
		return getService().createEventFollow(eventFollowId);
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
	 * Deletes the event follow from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventFollowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventFollow the event follow
	 * @return the event follow that was removed
	 */
	public static EventFollow deleteEventFollow(EventFollow eventFollow) {
		return getService().deleteEventFollow(eventFollow);
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
	public static EventFollow deleteEventFollow(long eventFollowId)
		throws PortalException {

		return getService().deleteEventFollow(eventFollowId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.eventos.follow.sb.model.impl.EventFollowModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.eventos.follow.sb.model.impl.EventFollowModelImpl</code>.
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

	public static EventFollow fetchEventFollow(long eventFollowId) {
		return getService().fetchEventFollow(eventFollowId);
	}

	/**
	 * Returns the event follow matching the UUID and group.
	 *
	 * @param uuid the event follow's UUID
	 * @param groupId the primary key of the group
	 * @return the matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	public static EventFollow fetchEventFollowByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchEventFollowByUuidAndGroupId(uuid, groupId);
	}

	public static Boolean follows(long principalId, long eventId)
		throws PortalException {

		return getService().follows(principalId, eventId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the event follow with the primary key.
	 *
	 * @param eventFollowId the primary key of the event follow
	 * @return the event follow
	 * @throws PortalException if a event follow with the primary key could not be found
	 */
	public static EventFollow getEventFollow(long eventFollowId)
		throws PortalException {

		return getService().getEventFollow(eventFollowId);
	}

	/**
	 * Returns the event follow matching the UUID and group.
	 *
	 * @param uuid the event follow's UUID
	 * @param groupId the primary key of the group
	 * @return the matching event follow
	 * @throws PortalException if a matching event follow could not be found
	 */
	public static EventFollow getEventFollowByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getEventFollowByUuidAndGroupId(uuid, groupId);
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
	public static List<EventFollow> getEventFollows(int start, int end) {
		return getService().getEventFollows(start, end);
	}

	public static List<EventFollow> getEventFollowsByEventId(long eventId) {
		return getService().getEventFollowsByEventId(eventId);
	}

	public static List<EventFollow> getEventFollowsByUserId(long userId) {
		return getService().getEventFollowsByUserId(userId);
	}

	public static EventFollow getEventFollowsByUserIdAndEventFollow(
		long userId, long eventId) {

		return getService().getEventFollowsByUserIdAndEventFollow(
			userId, eventId);
	}

	/**
	 * Returns all the event follows matching the UUID and company.
	 *
	 * @param uuid the UUID of the event follows
	 * @param companyId the primary key of the company
	 * @return the matching event follows, or an empty list if no matches were found
	 */
	public static List<EventFollow> getEventFollowsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getEventFollowsByUuidAndCompanyId(uuid, companyId);
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
	public static List<EventFollow> getEventFollowsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EventFollow> orderByComparator) {

		return getService().getEventFollowsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of event follows.
	 *
	 * @return the number of event follows
	 */
	public static int getEventFollowsCount() {
		return getService().getEventFollowsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
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
	 * Updates the event follow in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventFollowLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventFollow the event follow
	 * @return the event follow that was updated
	 */
	public static EventFollow updateEventFollow(EventFollow eventFollow) {
		return getService().updateEventFollow(eventFollow);
	}

	public static EventFollowLocalService getService() {
		return _service;
	}

	public static void setService(EventFollowLocalService service) {
		_service = service;
	}

	private static volatile EventFollowLocalService _service;

}