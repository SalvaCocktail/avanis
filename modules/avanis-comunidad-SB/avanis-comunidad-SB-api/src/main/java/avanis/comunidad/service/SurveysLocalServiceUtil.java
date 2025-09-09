/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.service;

import avanis.comunidad.model.Surveys;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Surveys. This utility wraps
 * <code>avanis.comunidad.service.impl.SurveysLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SurveysLocalService
 * @generated
 */
public class SurveysLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>avanis.comunidad.service.impl.SurveysLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the surveys to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SurveysLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param surveys the surveys
	 * @return the surveys that was added
	 */
	public static Surveys addSurveys(Surveys surveys) {
		return getService().addSurveys(surveys);
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
	 * Creates a new surveys with the primary key. Does not add the surveys to the database.
	 *
	 * @param surveyId the primary key for the new surveys
	 * @return the new surveys
	 */
	public static Surveys createSurveys(long surveyId) {
		return getService().createSurveys(surveyId);
	}

	public static Surveys createUpdate(
		long surveyId, long userId, long groupId, String question,
		int expireHours) {

		return getService().createUpdate(
			surveyId, userId, groupId, question, expireHours);
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
	 * Deletes the surveys with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SurveysLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param surveyId the primary key of the surveys
	 * @return the surveys that was removed
	 * @throws PortalException if a surveys with the primary key could not be found
	 */
	public static Surveys deleteSurveys(long surveyId) throws PortalException {
		return getService().deleteSurveys(surveyId);
	}

	/**
	 * Deletes the surveys from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SurveysLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param surveys the surveys
	 * @return the surveys that was removed
	 */
	public static Surveys deleteSurveys(Surveys surveys) {
		return getService().deleteSurveys(surveys);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.comunidad.model.impl.SurveysModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.comunidad.model.impl.SurveysModelImpl</code>.
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

	public static Surveys fetchSurveys(long surveyId) {
		return getService().fetchSurveys(surveyId);
	}

	/**
	 * Returns the surveys matching the UUID and group.
	 *
	 * @param uuid the surveys's UUID
	 * @param groupId the primary key of the group
	 * @return the matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	public static Surveys fetchSurveysByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchSurveysByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the surveys with the primary key.
	 *
	 * @param surveyId the primary key of the surveys
	 * @return the surveys
	 * @throws PortalException if a surveys with the primary key could not be found
	 */
	public static Surveys getSurveys(long surveyId) throws PortalException {
		return getService().getSurveys(surveyId);
	}

	public static List<Surveys> getSurveysByAssetId(long assetId) {
		return getService().getSurveysByAssetId(assetId);
	}

	/**
	 * Returns the surveys matching the UUID and group.
	 *
	 * @param uuid the surveys's UUID
	 * @param groupId the primary key of the group
	 * @return the matching surveys
	 * @throws PortalException if a matching surveys could not be found
	 */
	public static Surveys getSurveysByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getSurveysByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the surveyses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.comunidad.model.impl.SurveysModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of surveyses
	 * @param end the upper bound of the range of surveyses (not inclusive)
	 * @return the range of surveyses
	 */
	public static List<Surveys> getSurveyses(int start, int end) {
		return getService().getSurveyses(start, end);
	}

	/**
	 * Returns the number of surveyses.
	 *
	 * @return the number of surveyses
	 */
	public static int getSurveysesCount() {
		return getService().getSurveysesCount();
	}

	/**
	 * Updates the surveys in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SurveysLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param surveys the surveys
	 * @return the surveys that was updated
	 */
	public static Surveys updateSurveys(Surveys surveys) {
		return getService().updateSurveys(surveys);
	}

	public static SurveysLocalService getService() {
		return _service;
	}

	public static void setService(SurveysLocalService service) {
		_service = service;
	}

	private static volatile SurveysLocalService _service;

}