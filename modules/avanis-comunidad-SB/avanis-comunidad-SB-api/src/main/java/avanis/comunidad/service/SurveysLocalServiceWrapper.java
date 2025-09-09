/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link SurveysLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SurveysLocalService
 * @generated
 */
public class SurveysLocalServiceWrapper
	implements ServiceWrapper<SurveysLocalService>, SurveysLocalService {

	public SurveysLocalServiceWrapper() {
		this(null);
	}

	public SurveysLocalServiceWrapper(SurveysLocalService surveysLocalService) {
		_surveysLocalService = surveysLocalService;
	}

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
	@Override
	public avanis.comunidad.model.Surveys addSurveys(
		avanis.comunidad.model.Surveys surveys) {

		return _surveysLocalService.addSurveys(surveys);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _surveysLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new surveys with the primary key. Does not add the surveys to the database.
	 *
	 * @param surveyId the primary key for the new surveys
	 * @return the new surveys
	 */
	@Override
	public avanis.comunidad.model.Surveys createSurveys(long surveyId) {
		return _surveysLocalService.createSurveys(surveyId);
	}

	@Override
	public avanis.comunidad.model.Surveys createUpdate(
		long surveyId, long userId, long groupId, String question,
		int expireHours) {

		return _surveysLocalService.createUpdate(
			surveyId, userId, groupId, question, expireHours);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _surveysLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public avanis.comunidad.model.Surveys deleteSurveys(long surveyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _surveysLocalService.deleteSurveys(surveyId);
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
	@Override
	public avanis.comunidad.model.Surveys deleteSurveys(
		avanis.comunidad.model.Surveys surveys) {

		return _surveysLocalService.deleteSurveys(surveys);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _surveysLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _surveysLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _surveysLocalService.dynamicQuery();
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

		return _surveysLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _surveysLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _surveysLocalService.dynamicQuery(
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

		return _surveysLocalService.dynamicQueryCount(dynamicQuery);
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

		return _surveysLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public avanis.comunidad.model.Surveys fetchSurveys(long surveyId) {
		return _surveysLocalService.fetchSurveys(surveyId);
	}

	/**
	 * Returns the surveys matching the UUID and group.
	 *
	 * @param uuid the surveys's UUID
	 * @param groupId the primary key of the group
	 * @return the matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	@Override
	public avanis.comunidad.model.Surveys fetchSurveysByUuidAndGroupId(
		String uuid, long groupId) {

		return _surveysLocalService.fetchSurveysByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _surveysLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _surveysLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _surveysLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _surveysLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the surveys with the primary key.
	 *
	 * @param surveyId the primary key of the surveys
	 * @return the surveys
	 * @throws PortalException if a surveys with the primary key could not be found
	 */
	@Override
	public avanis.comunidad.model.Surveys getSurveys(long surveyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _surveysLocalService.getSurveys(surveyId);
	}

	@Override
	public java.util.List<avanis.comunidad.model.Surveys> getSurveysByAssetId(
		long assetId) {

		return _surveysLocalService.getSurveysByAssetId(assetId);
	}

	/**
	 * Returns the surveys matching the UUID and group.
	 *
	 * @param uuid the surveys's UUID
	 * @param groupId the primary key of the group
	 * @return the matching surveys
	 * @throws PortalException if a matching surveys could not be found
	 */
	@Override
	public avanis.comunidad.model.Surveys getSurveysByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _surveysLocalService.getSurveysByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<avanis.comunidad.model.Surveys> getSurveyses(
		int start, int end) {

		return _surveysLocalService.getSurveyses(start, end);
	}

	/**
	 * Returns the number of surveyses.
	 *
	 * @return the number of surveyses
	 */
	@Override
	public int getSurveysesCount() {
		return _surveysLocalService.getSurveysesCount();
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
	@Override
	public avanis.comunidad.model.Surveys updateSurveys(
		avanis.comunidad.model.Surveys surveys) {

		return _surveysLocalService.updateSurveys(surveys);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _surveysLocalService.getBasePersistence();
	}

	@Override
	public SurveysLocalService getWrappedService() {
		return _surveysLocalService;
	}

	@Override
	public void setWrappedService(SurveysLocalService surveysLocalService) {
		_surveysLocalService = surveysLocalService;
	}

	private SurveysLocalService _surveysLocalService;

}