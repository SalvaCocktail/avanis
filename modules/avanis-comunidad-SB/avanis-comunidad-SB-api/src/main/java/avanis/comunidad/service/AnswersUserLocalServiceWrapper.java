/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AnswersUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AnswersUserLocalService
 * @generated
 */
public class AnswersUserLocalServiceWrapper
	implements AnswersUserLocalService,
			   ServiceWrapper<AnswersUserLocalService> {

	public AnswersUserLocalServiceWrapper() {
		this(null);
	}

	public AnswersUserLocalServiceWrapper(
		AnswersUserLocalService answersUserLocalService) {

		_answersUserLocalService = answersUserLocalService;
	}

	/**
	 * Adds the answers user to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnswersUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param answersUser the answers user
	 * @return the answers user that was added
	 */
	@Override
	public avanis.comunidad.model.AnswersUser addAnswersUser(
		avanis.comunidad.model.AnswersUser answersUser) {

		return _answersUserLocalService.addAnswersUser(answersUser);
	}

	/**
	 * Creates a new answers user with the primary key. Does not add the answers user to the database.
	 *
	 * @param answerUserId the primary key for the new answers user
	 * @return the new answers user
	 */
	@Override
	public avanis.comunidad.model.AnswersUser createAnswersUser(
		long answerUserId) {

		return _answersUserLocalService.createAnswersUser(answerUserId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _answersUserLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the answers user from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnswersUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param answersUser the answers user
	 * @return the answers user that was removed
	 */
	@Override
	public avanis.comunidad.model.AnswersUser deleteAnswersUser(
		avanis.comunidad.model.AnswersUser answersUser) {

		return _answersUserLocalService.deleteAnswersUser(answersUser);
	}

	/**
	 * Deletes the answers user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnswersUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param answerUserId the primary key of the answers user
	 * @return the answers user that was removed
	 * @throws PortalException if a answers user with the primary key could not be found
	 */
	@Override
	public avanis.comunidad.model.AnswersUser deleteAnswersUser(
			long answerUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _answersUserLocalService.deleteAnswersUser(answerUserId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _answersUserLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _answersUserLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _answersUserLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _answersUserLocalService.dynamicQuery();
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

		return _answersUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.comunidad.model.impl.AnswersUserModelImpl</code>.
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

		return _answersUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.comunidad.model.impl.AnswersUserModelImpl</code>.
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

		return _answersUserLocalService.dynamicQuery(
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

		return _answersUserLocalService.dynamicQueryCount(dynamicQuery);
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

		return _answersUserLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public avanis.comunidad.model.AnswersUser fetchAnswersUser(
		long answerUserId) {

		return _answersUserLocalService.fetchAnswersUser(answerUserId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _answersUserLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the answers user with the primary key.
	 *
	 * @param answerUserId the primary key of the answers user
	 * @return the answers user
	 * @throws PortalException if a answers user with the primary key could not be found
	 */
	@Override
	public avanis.comunidad.model.AnswersUser getAnswersUser(long answerUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _answersUserLocalService.getAnswersUser(answerUserId);
	}

	@Override
	public java.util.List<avanis.comunidad.model.AnswersUser>
		getAnswersUserByAnswerIdSUserId(long answerId, long userId) {

		return _answersUserLocalService.getAnswersUserByAnswerIdSUserId(
			answerId, userId);
	}

	@Override
	public java.util.List<avanis.comunidad.model.AnswersUser>
		getAnswersUserBySurveyId(long surveyId) {

		return _answersUserLocalService.getAnswersUserBySurveyId(surveyId);
	}

	@Override
	public java.util.List<avanis.comunidad.model.AnswersUser>
		getAnswersUserBySurveyIdUserId(long surveyId, long userId) {

		return _answersUserLocalService.getAnswersUserBySurveyIdUserId(
			surveyId, userId);
	}

	@Override
	public java.util.List<avanis.comunidad.model.AnswersUser>
		getAnswersUserByUserId(long userId) {

		return _answersUserLocalService.getAnswersUserByUserId(userId);
	}

	/**
	 * Returns a range of all the answers users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.comunidad.model.impl.AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @return the range of answers users
	 */
	@Override
	public java.util.List<avanis.comunidad.model.AnswersUser> getAnswersUsers(
		int start, int end) {

		return _answersUserLocalService.getAnswersUsers(start, end);
	}

	/**
	 * Returns the number of answers users.
	 *
	 * @return the number of answers users
	 */
	@Override
	public int getAnswersUsersCount() {
		return _answersUserLocalService.getAnswersUsersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _answersUserLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _answersUserLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _answersUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the answers user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnswersUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param answersUser the answers user
	 * @return the answers user that was updated
	 */
	@Override
	public avanis.comunidad.model.AnswersUser updateAnswersUser(
		avanis.comunidad.model.AnswersUser answersUser) {

		return _answersUserLocalService.updateAnswersUser(answersUser);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _answersUserLocalService.getBasePersistence();
	}

	@Override
	public AnswersUserLocalService getWrappedService() {
		return _answersUserLocalService;
	}

	@Override
	public void setWrappedService(
		AnswersUserLocalService answersUserLocalService) {

		_answersUserLocalService = answersUserLocalService;
	}

	private AnswersUserLocalService _answersUserLocalService;

}