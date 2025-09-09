/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.service.persistence;

import avanis.comunidad.model.Answers;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the answers service. This utility wraps <code>avanis.comunidad.service.persistence.impl.AnswersPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnswersPersistence
 * @generated
 */
public class AnswersUtil {

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
	public static void clearCache(Answers answers) {
		getPersistence().clearCache(answers);
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
	public static Map<Serializable, Answers> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Answers> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Answers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Answers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Answers> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Answers update(Answers answers) {
		return getPersistence().update(answers);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Answers update(
		Answers answers, ServiceContext serviceContext) {

		return getPersistence().update(answers, serviceContext);
	}

	/**
	 * Returns all the answerses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching answerses
	 */
	public static List<Answers> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the answerses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of answerses
	 * @param end the upper bound of the range of answerses (not inclusive)
	 * @return the range of matching answerses
	 */
	public static List<Answers> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the answerses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of answerses
	 * @param end the upper bound of the range of answerses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching answerses
	 */
	public static List<Answers> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Answers> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the answerses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of answerses
	 * @param end the upper bound of the range of answerses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching answerses
	 */
	public static List<Answers> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Answers> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first answers in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers
	 * @throws NoSuchAnswersException if a matching answers could not be found
	 */
	public static Answers findByUuid_First(
			String uuid, OrderByComparator<Answers> orderByComparator)
		throws avanis.comunidad.exception.NoSuchAnswersException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first answers in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers, or <code>null</code> if a matching answers could not be found
	 */
	public static Answers fetchByUuid_First(
		String uuid, OrderByComparator<Answers> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last answers in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers
	 * @throws NoSuchAnswersException if a matching answers could not be found
	 */
	public static Answers findByUuid_Last(
			String uuid, OrderByComparator<Answers> orderByComparator)
		throws avanis.comunidad.exception.NoSuchAnswersException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last answers in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers, or <code>null</code> if a matching answers could not be found
	 */
	public static Answers fetchByUuid_Last(
		String uuid, OrderByComparator<Answers> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the answerses before and after the current answers in the ordered set where uuid = &#63;.
	 *
	 * @param answerId the primary key of the current answers
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answers
	 * @throws NoSuchAnswersException if a answers with the primary key could not be found
	 */
	public static Answers[] findByUuid_PrevAndNext(
			long answerId, String uuid,
			OrderByComparator<Answers> orderByComparator)
		throws avanis.comunidad.exception.NoSuchAnswersException {

		return getPersistence().findByUuid_PrevAndNext(
			answerId, uuid, orderByComparator);
	}

	/**
	 * Removes all the answerses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of answerses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching answerses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the answerses where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @return the matching answerses
	 */
	public static List<Answers> findBysurveyId(long surveyId) {
		return getPersistence().findBysurveyId(surveyId);
	}

	/**
	 * Returns a range of all the answerses where surveyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersModelImpl</code>.
	 * </p>
	 *
	 * @param surveyId the survey ID
	 * @param start the lower bound of the range of answerses
	 * @param end the upper bound of the range of answerses (not inclusive)
	 * @return the range of matching answerses
	 */
	public static List<Answers> findBysurveyId(
		long surveyId, int start, int end) {

		return getPersistence().findBysurveyId(surveyId, start, end);
	}

	/**
	 * Returns an ordered range of all the answerses where surveyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersModelImpl</code>.
	 * </p>
	 *
	 * @param surveyId the survey ID
	 * @param start the lower bound of the range of answerses
	 * @param end the upper bound of the range of answerses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching answerses
	 */
	public static List<Answers> findBysurveyId(
		long surveyId, int start, int end,
		OrderByComparator<Answers> orderByComparator) {

		return getPersistence().findBysurveyId(
			surveyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the answerses where surveyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersModelImpl</code>.
	 * </p>
	 *
	 * @param surveyId the survey ID
	 * @param start the lower bound of the range of answerses
	 * @param end the upper bound of the range of answerses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching answerses
	 */
	public static List<Answers> findBysurveyId(
		long surveyId, int start, int end,
		OrderByComparator<Answers> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBysurveyId(
			surveyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first answers in the ordered set where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers
	 * @throws NoSuchAnswersException if a matching answers could not be found
	 */
	public static Answers findBysurveyId_First(
			long surveyId, OrderByComparator<Answers> orderByComparator)
		throws avanis.comunidad.exception.NoSuchAnswersException {

		return getPersistence().findBysurveyId_First(
			surveyId, orderByComparator);
	}

	/**
	 * Returns the first answers in the ordered set where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers, or <code>null</code> if a matching answers could not be found
	 */
	public static Answers fetchBysurveyId_First(
		long surveyId, OrderByComparator<Answers> orderByComparator) {

		return getPersistence().fetchBysurveyId_First(
			surveyId, orderByComparator);
	}

	/**
	 * Returns the last answers in the ordered set where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers
	 * @throws NoSuchAnswersException if a matching answers could not be found
	 */
	public static Answers findBysurveyId_Last(
			long surveyId, OrderByComparator<Answers> orderByComparator)
		throws avanis.comunidad.exception.NoSuchAnswersException {

		return getPersistence().findBysurveyId_Last(
			surveyId, orderByComparator);
	}

	/**
	 * Returns the last answers in the ordered set where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers, or <code>null</code> if a matching answers could not be found
	 */
	public static Answers fetchBysurveyId_Last(
		long surveyId, OrderByComparator<Answers> orderByComparator) {

		return getPersistence().fetchBysurveyId_Last(
			surveyId, orderByComparator);
	}

	/**
	 * Returns the answerses before and after the current answers in the ordered set where surveyId = &#63;.
	 *
	 * @param answerId the primary key of the current answers
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answers
	 * @throws NoSuchAnswersException if a answers with the primary key could not be found
	 */
	public static Answers[] findBysurveyId_PrevAndNext(
			long answerId, long surveyId,
			OrderByComparator<Answers> orderByComparator)
		throws avanis.comunidad.exception.NoSuchAnswersException {

		return getPersistence().findBysurveyId_PrevAndNext(
			answerId, surveyId, orderByComparator);
	}

	/**
	 * Removes all the answerses where surveyId = &#63; from the database.
	 *
	 * @param surveyId the survey ID
	 */
	public static void removeBysurveyId(long surveyId) {
		getPersistence().removeBysurveyId(surveyId);
	}

	/**
	 * Returns the number of answerses where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @return the number of matching answerses
	 */
	public static int countBysurveyId(long surveyId) {
		return getPersistence().countBysurveyId(surveyId);
	}

	/**
	 * Caches the answers in the entity cache if it is enabled.
	 *
	 * @param answers the answers
	 */
	public static void cacheResult(Answers answers) {
		getPersistence().cacheResult(answers);
	}

	/**
	 * Caches the answerses in the entity cache if it is enabled.
	 *
	 * @param answerses the answerses
	 */
	public static void cacheResult(List<Answers> answerses) {
		getPersistence().cacheResult(answerses);
	}

	/**
	 * Creates a new answers with the primary key. Does not add the answers to the database.
	 *
	 * @param answerId the primary key for the new answers
	 * @return the new answers
	 */
	public static Answers create(long answerId) {
		return getPersistence().create(answerId);
	}

	/**
	 * Removes the answers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param answerId the primary key of the answers
	 * @return the answers that was removed
	 * @throws NoSuchAnswersException if a answers with the primary key could not be found
	 */
	public static Answers remove(long answerId)
		throws avanis.comunidad.exception.NoSuchAnswersException {

		return getPersistence().remove(answerId);
	}

	public static Answers updateImpl(Answers answers) {
		return getPersistence().updateImpl(answers);
	}

	/**
	 * Returns the answers with the primary key or throws a <code>NoSuchAnswersException</code> if it could not be found.
	 *
	 * @param answerId the primary key of the answers
	 * @return the answers
	 * @throws NoSuchAnswersException if a answers with the primary key could not be found
	 */
	public static Answers findByPrimaryKey(long answerId)
		throws avanis.comunidad.exception.NoSuchAnswersException {

		return getPersistence().findByPrimaryKey(answerId);
	}

	/**
	 * Returns the answers with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param answerId the primary key of the answers
	 * @return the answers, or <code>null</code> if a answers with the primary key could not be found
	 */
	public static Answers fetchByPrimaryKey(long answerId) {
		return getPersistence().fetchByPrimaryKey(answerId);
	}

	/**
	 * Returns all the answerses.
	 *
	 * @return the answerses
	 */
	public static List<Answers> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the answerses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of answerses
	 * @param end the upper bound of the range of answerses (not inclusive)
	 * @return the range of answerses
	 */
	public static List<Answers> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the answerses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of answerses
	 * @param end the upper bound of the range of answerses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of answerses
	 */
	public static List<Answers> findAll(
		int start, int end, OrderByComparator<Answers> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the answerses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of answerses
	 * @param end the upper bound of the range of answerses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of answerses
	 */
	public static List<Answers> findAll(
		int start, int end, OrderByComparator<Answers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the answerses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of answerses.
	 *
	 * @return the number of answerses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AnswersPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AnswersPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AnswersPersistence _persistence;

}