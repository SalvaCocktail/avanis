/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AnswersLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AnswersLocalService
 * @generated
 */
public class AnswersLocalServiceWrapper
	implements AnswersLocalService, ServiceWrapper<AnswersLocalService> {

	public AnswersLocalServiceWrapper() {
		this(null);
	}

	public AnswersLocalServiceWrapper(AnswersLocalService answersLocalService) {
		_answersLocalService = answersLocalService;
	}

	/**
	 * Adds the answers to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnswersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param answers the answers
	 * @return the answers that was added
	 */
	@Override
	public avanis.comunidad.model.Answers addAnswers(
		avanis.comunidad.model.Answers answers) {

		return _answersLocalService.addAnswers(answers);
	}

	/**
	 * Creates a new answers with the primary key. Does not add the answers to the database.
	 *
	 * @param answerId the primary key for the new answers
	 * @return the new answers
	 */
	@Override
	public avanis.comunidad.model.Answers createAnswers(long answerId) {
		return _answersLocalService.createAnswers(answerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _answersLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<avanis.comunidad.model.Answers> createUpdate(
		String[] answers, java.util.List<Long> answersIds, long surveyId) {

		return _answersLocalService.createUpdate(answers, answersIds, surveyId);
	}

	/**
	 * Deletes the answers from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnswersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param answers the answers
	 * @return the answers that was removed
	 */
	@Override
	public avanis.comunidad.model.Answers deleteAnswers(
		avanis.comunidad.model.Answers answers) {

		return _answersLocalService.deleteAnswers(answers);
	}

	/**
	 * Deletes the answers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnswersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param answerId the primary key of the answers
	 * @return the answers that was removed
	 * @throws PortalException if a answers with the primary key could not be found
	 */
	@Override
	public avanis.comunidad.model.Answers deleteAnswers(long answerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _answersLocalService.deleteAnswers(answerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _answersLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _answersLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _answersLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _answersLocalService.dynamicQuery();
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

		return _answersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.comunidad.model.impl.AnswersModelImpl</code>.
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

		return _answersLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.comunidad.model.impl.AnswersModelImpl</code>.
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

		return _answersLocalService.dynamicQuery(
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

		return _answersLocalService.dynamicQueryCount(dynamicQuery);
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

		return _answersLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public avanis.comunidad.model.Answers fetchAnswers(long answerId) {
		return _answersLocalService.fetchAnswers(answerId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _answersLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the answers with the primary key.
	 *
	 * @param answerId the primary key of the answers
	 * @return the answers
	 * @throws PortalException if a answers with the primary key could not be found
	 */
	@Override
	public avanis.comunidad.model.Answers getAnswers(long answerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _answersLocalService.getAnswers(answerId);
	}

	@Override
	public java.util.List<avanis.comunidad.model.Answers> getAnswersBySurveyId(
		long surveyId) {

		return _answersLocalService.getAnswersBySurveyId(surveyId);
	}

	/**
	 * Returns a range of all the answerses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>avanis.comunidad.model.impl.AnswersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of answerses
	 * @param end the upper bound of the range of answerses (not inclusive)
	 * @return the range of answerses
	 */
	@Override
	public java.util.List<avanis.comunidad.model.Answers> getAnswerses(
		int start, int end) {

		return _answersLocalService.getAnswerses(start, end);
	}

	/**
	 * Returns the number of answerses.
	 *
	 * @return the number of answerses
	 */
	@Override
	public int getAnswersesCount() {
		return _answersLocalService.getAnswersesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _answersLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _answersLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _answersLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the answers in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AnswersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param answers the answers
	 * @return the answers that was updated
	 */
	@Override
	public avanis.comunidad.model.Answers updateAnswers(
		avanis.comunidad.model.Answers answers) {

		return _answersLocalService.updateAnswers(answers);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _answersLocalService.getBasePersistence();
	}

	@Override
	public AnswersLocalService getWrappedService() {
		return _answersLocalService;
	}

	@Override
	public void setWrappedService(AnswersLocalService answersLocalService) {
		_answersLocalService = answersLocalService;
	}

	private AnswersLocalService _answersLocalService;

}