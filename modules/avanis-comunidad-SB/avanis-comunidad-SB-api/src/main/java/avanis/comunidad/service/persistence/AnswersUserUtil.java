/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.service.persistence;

import avanis.comunidad.model.AnswersUser;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the answers user service. This utility wraps <code>avanis.comunidad.service.persistence.impl.AnswersUserPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnswersUserPersistence
 * @generated
 */
public class AnswersUserUtil {

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
	public static void clearCache(AnswersUser answersUser) {
		getPersistence().clearCache(answersUser);
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
	public static Map<Serializable, AnswersUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AnswersUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AnswersUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AnswersUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AnswersUser> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AnswersUser update(AnswersUser answersUser) {
		return getPersistence().update(answersUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AnswersUser update(
		AnswersUser answersUser, ServiceContext serviceContext) {

		return getPersistence().update(answersUser, serviceContext);
	}

	/**
	 * Returns all the answers users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching answers users
	 */
	public static List<AnswersUser> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the answers users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @return the range of matching answers users
	 */
	public static List<AnswersUser> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the answers users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching answers users
	 */
	public static List<AnswersUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AnswersUser> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the answers users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching answers users
	 */
	public static List<AnswersUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AnswersUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first answers user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	public static AnswersUser findByUuid_First(
			String uuid, OrderByComparator<AnswersUser> orderByComparator)
		throws avanis.comunidad.exception.NoSuchAnswersUserException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first answers user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	public static AnswersUser fetchByUuid_First(
		String uuid, OrderByComparator<AnswersUser> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last answers user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	public static AnswersUser findByUuid_Last(
			String uuid, OrderByComparator<AnswersUser> orderByComparator)
		throws avanis.comunidad.exception.NoSuchAnswersUserException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last answers user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	public static AnswersUser fetchByUuid_Last(
		String uuid, OrderByComparator<AnswersUser> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the answers users before and after the current answers user in the ordered set where uuid = &#63;.
	 *
	 * @param answerUserId the primary key of the current answers user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answers user
	 * @throws NoSuchAnswersUserException if a answers user with the primary key could not be found
	 */
	public static AnswersUser[] findByUuid_PrevAndNext(
			long answerUserId, String uuid,
			OrderByComparator<AnswersUser> orderByComparator)
		throws avanis.comunidad.exception.NoSuchAnswersUserException {

		return getPersistence().findByUuid_PrevAndNext(
			answerUserId, uuid, orderByComparator);
	}

	/**
	 * Removes all the answers users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of answers users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching answers users
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the answers users where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @return the matching answers users
	 */
	public static List<AnswersUser> findBysurveyId(long surveyId) {
		return getPersistence().findBysurveyId(surveyId);
	}

	/**
	 * Returns a range of all the answers users where surveyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param surveyId the survey ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @return the range of matching answers users
	 */
	public static List<AnswersUser> findBysurveyId(
		long surveyId, int start, int end) {

		return getPersistence().findBysurveyId(surveyId, start, end);
	}

	/**
	 * Returns an ordered range of all the answers users where surveyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param surveyId the survey ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching answers users
	 */
	public static List<AnswersUser> findBysurveyId(
		long surveyId, int start, int end,
		OrderByComparator<AnswersUser> orderByComparator) {

		return getPersistence().findBysurveyId(
			surveyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the answers users where surveyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param surveyId the survey ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching answers users
	 */
	public static List<AnswersUser> findBysurveyId(
		long surveyId, int start, int end,
		OrderByComparator<AnswersUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysurveyId(
			surveyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first answers user in the ordered set where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	public static AnswersUser findBysurveyId_First(
			long surveyId, OrderByComparator<AnswersUser> orderByComparator)
		throws avanis.comunidad.exception.NoSuchAnswersUserException {

		return getPersistence().findBysurveyId_First(
			surveyId, orderByComparator);
	}

	/**
	 * Returns the first answers user in the ordered set where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	public static AnswersUser fetchBysurveyId_First(
		long surveyId, OrderByComparator<AnswersUser> orderByComparator) {

		return getPersistence().fetchBysurveyId_First(
			surveyId, orderByComparator);
	}

	/**
	 * Returns the last answers user in the ordered set where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	public static AnswersUser findBysurveyId_Last(
			long surveyId, OrderByComparator<AnswersUser> orderByComparator)
		throws avanis.comunidad.exception.NoSuchAnswersUserException {

		return getPersistence().findBysurveyId_Last(
			surveyId, orderByComparator);
	}

	/**
	 * Returns the last answers user in the ordered set where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	public static AnswersUser fetchBysurveyId_Last(
		long surveyId, OrderByComparator<AnswersUser> orderByComparator) {

		return getPersistence().fetchBysurveyId_Last(
			surveyId, orderByComparator);
	}

	/**
	 * Returns the answers users before and after the current answers user in the ordered set where surveyId = &#63;.
	 *
	 * @param answerUserId the primary key of the current answers user
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answers user
	 * @throws NoSuchAnswersUserException if a answers user with the primary key could not be found
	 */
	public static AnswersUser[] findBysurveyId_PrevAndNext(
			long answerUserId, long surveyId,
			OrderByComparator<AnswersUser> orderByComparator)
		throws avanis.comunidad.exception.NoSuchAnswersUserException {

		return getPersistence().findBysurveyId_PrevAndNext(
			answerUserId, surveyId, orderByComparator);
	}

	/**
	 * Removes all the answers users where surveyId = &#63; from the database.
	 *
	 * @param surveyId the survey ID
	 */
	public static void removeBysurveyId(long surveyId) {
		getPersistence().removeBysurveyId(surveyId);
	}

	/**
	 * Returns the number of answers users where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @return the number of matching answers users
	 */
	public static int countBysurveyId(long surveyId) {
		return getPersistence().countBysurveyId(surveyId);
	}

	/**
	 * Returns all the answers users where surveyId = &#63; and userId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @return the matching answers users
	 */
	public static List<AnswersUser> findBysurveyIdUserId(
		long surveyId, long userId) {

		return getPersistence().findBysurveyIdUserId(surveyId, userId);
	}

	/**
	 * Returns a range of all the answers users where surveyId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @return the range of matching answers users
	 */
	public static List<AnswersUser> findBysurveyIdUserId(
		long surveyId, long userId, int start, int end) {

		return getPersistence().findBysurveyIdUserId(
			surveyId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the answers users where surveyId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching answers users
	 */
	public static List<AnswersUser> findBysurveyIdUserId(
		long surveyId, long userId, int start, int end,
		OrderByComparator<AnswersUser> orderByComparator) {

		return getPersistence().findBysurveyIdUserId(
			surveyId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the answers users where surveyId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching answers users
	 */
	public static List<AnswersUser> findBysurveyIdUserId(
		long surveyId, long userId, int start, int end,
		OrderByComparator<AnswersUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysurveyIdUserId(
			surveyId, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first answers user in the ordered set where surveyId = &#63; and userId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	public static AnswersUser findBysurveyIdUserId_First(
			long surveyId, long userId,
			OrderByComparator<AnswersUser> orderByComparator)
		throws avanis.comunidad.exception.NoSuchAnswersUserException {

		return getPersistence().findBysurveyIdUserId_First(
			surveyId, userId, orderByComparator);
	}

	/**
	 * Returns the first answers user in the ordered set where surveyId = &#63; and userId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	public static AnswersUser fetchBysurveyIdUserId_First(
		long surveyId, long userId,
		OrderByComparator<AnswersUser> orderByComparator) {

		return getPersistence().fetchBysurveyIdUserId_First(
			surveyId, userId, orderByComparator);
	}

	/**
	 * Returns the last answers user in the ordered set where surveyId = &#63; and userId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	public static AnswersUser findBysurveyIdUserId_Last(
			long surveyId, long userId,
			OrderByComparator<AnswersUser> orderByComparator)
		throws avanis.comunidad.exception.NoSuchAnswersUserException {

		return getPersistence().findBysurveyIdUserId_Last(
			surveyId, userId, orderByComparator);
	}

	/**
	 * Returns the last answers user in the ordered set where surveyId = &#63; and userId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	public static AnswersUser fetchBysurveyIdUserId_Last(
		long surveyId, long userId,
		OrderByComparator<AnswersUser> orderByComparator) {

		return getPersistence().fetchBysurveyIdUserId_Last(
			surveyId, userId, orderByComparator);
	}

	/**
	 * Returns the answers users before and after the current answers user in the ordered set where surveyId = &#63; and userId = &#63;.
	 *
	 * @param answerUserId the primary key of the current answers user
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answers user
	 * @throws NoSuchAnswersUserException if a answers user with the primary key could not be found
	 */
	public static AnswersUser[] findBysurveyIdUserId_PrevAndNext(
			long answerUserId, long surveyId, long userId,
			OrderByComparator<AnswersUser> orderByComparator)
		throws avanis.comunidad.exception.NoSuchAnswersUserException {

		return getPersistence().findBysurveyIdUserId_PrevAndNext(
			answerUserId, surveyId, userId, orderByComparator);
	}

	/**
	 * Removes all the answers users where surveyId = &#63; and userId = &#63; from the database.
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 */
	public static void removeBysurveyIdUserId(long surveyId, long userId) {
		getPersistence().removeBysurveyIdUserId(surveyId, userId);
	}

	/**
	 * Returns the number of answers users where surveyId = &#63; and userId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @return the number of matching answers users
	 */
	public static int countBysurveyIdUserId(long surveyId, long userId) {
		return getPersistence().countBysurveyIdUserId(surveyId, userId);
	}

	/**
	 * Returns all the answers users where answerId = &#63; and userId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @return the matching answers users
	 */
	public static List<AnswersUser> findByanswerIdUserId(
		long answerId, long userId) {

		return getPersistence().findByanswerIdUserId(answerId, userId);
	}

	/**
	 * Returns a range of all the answers users where answerId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @return the range of matching answers users
	 */
	public static List<AnswersUser> findByanswerIdUserId(
		long answerId, long userId, int start, int end) {

		return getPersistence().findByanswerIdUserId(
			answerId, userId, start, end);
	}

	/**
	 * Returns an ordered range of all the answers users where answerId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching answers users
	 */
	public static List<AnswersUser> findByanswerIdUserId(
		long answerId, long userId, int start, int end,
		OrderByComparator<AnswersUser> orderByComparator) {

		return getPersistence().findByanswerIdUserId(
			answerId, userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the answers users where answerId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching answers users
	 */
	public static List<AnswersUser> findByanswerIdUserId(
		long answerId, long userId, int start, int end,
		OrderByComparator<AnswersUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByanswerIdUserId(
			answerId, userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first answers user in the ordered set where answerId = &#63; and userId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	public static AnswersUser findByanswerIdUserId_First(
			long answerId, long userId,
			OrderByComparator<AnswersUser> orderByComparator)
		throws avanis.comunidad.exception.NoSuchAnswersUserException {

		return getPersistence().findByanswerIdUserId_First(
			answerId, userId, orderByComparator);
	}

	/**
	 * Returns the first answers user in the ordered set where answerId = &#63; and userId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	public static AnswersUser fetchByanswerIdUserId_First(
		long answerId, long userId,
		OrderByComparator<AnswersUser> orderByComparator) {

		return getPersistence().fetchByanswerIdUserId_First(
			answerId, userId, orderByComparator);
	}

	/**
	 * Returns the last answers user in the ordered set where answerId = &#63; and userId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	public static AnswersUser findByanswerIdUserId_Last(
			long answerId, long userId,
			OrderByComparator<AnswersUser> orderByComparator)
		throws avanis.comunidad.exception.NoSuchAnswersUserException {

		return getPersistence().findByanswerIdUserId_Last(
			answerId, userId, orderByComparator);
	}

	/**
	 * Returns the last answers user in the ordered set where answerId = &#63; and userId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	public static AnswersUser fetchByanswerIdUserId_Last(
		long answerId, long userId,
		OrderByComparator<AnswersUser> orderByComparator) {

		return getPersistence().fetchByanswerIdUserId_Last(
			answerId, userId, orderByComparator);
	}

	/**
	 * Returns the answers users before and after the current answers user in the ordered set where answerId = &#63; and userId = &#63;.
	 *
	 * @param answerUserId the primary key of the current answers user
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answers user
	 * @throws NoSuchAnswersUserException if a answers user with the primary key could not be found
	 */
	public static AnswersUser[] findByanswerIdUserId_PrevAndNext(
			long answerUserId, long answerId, long userId,
			OrderByComparator<AnswersUser> orderByComparator)
		throws avanis.comunidad.exception.NoSuchAnswersUserException {

		return getPersistence().findByanswerIdUserId_PrevAndNext(
			answerUserId, answerId, userId, orderByComparator);
	}

	/**
	 * Removes all the answers users where answerId = &#63; and userId = &#63; from the database.
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 */
	public static void removeByanswerIdUserId(long answerId, long userId) {
		getPersistence().removeByanswerIdUserId(answerId, userId);
	}

	/**
	 * Returns the number of answers users where answerId = &#63; and userId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @return the number of matching answers users
	 */
	public static int countByanswerIdUserId(long answerId, long userId) {
		return getPersistence().countByanswerIdUserId(answerId, userId);
	}

	/**
	 * Returns all the answers users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching answers users
	 */
	public static List<AnswersUser> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

	/**
	 * Returns a range of all the answers users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @return the range of matching answers users
	 */
	public static List<AnswersUser> findByuserId(
		long userId, int start, int end) {

		return getPersistence().findByuserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the answers users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching answers users
	 */
	public static List<AnswersUser> findByuserId(
		long userId, int start, int end,
		OrderByComparator<AnswersUser> orderByComparator) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the answers users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching answers users
	 */
	public static List<AnswersUser> findByuserId(
		long userId, int start, int end,
		OrderByComparator<AnswersUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first answers user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	public static AnswersUser findByuserId_First(
			long userId, OrderByComparator<AnswersUser> orderByComparator)
		throws avanis.comunidad.exception.NoSuchAnswersUserException {

		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first answers user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	public static AnswersUser fetchByuserId_First(
		long userId, OrderByComparator<AnswersUser> orderByComparator) {

		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last answers user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	public static AnswersUser findByuserId_Last(
			long userId, OrderByComparator<AnswersUser> orderByComparator)
		throws avanis.comunidad.exception.NoSuchAnswersUserException {

		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last answers user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	public static AnswersUser fetchByuserId_Last(
		long userId, OrderByComparator<AnswersUser> orderByComparator) {

		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the answers users before and after the current answers user in the ordered set where userId = &#63;.
	 *
	 * @param answerUserId the primary key of the current answers user
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answers user
	 * @throws NoSuchAnswersUserException if a answers user with the primary key could not be found
	 */
	public static AnswersUser[] findByuserId_PrevAndNext(
			long answerUserId, long userId,
			OrderByComparator<AnswersUser> orderByComparator)
		throws avanis.comunidad.exception.NoSuchAnswersUserException {

		return getPersistence().findByuserId_PrevAndNext(
			answerUserId, userId, orderByComparator);
	}

	/**
	 * Removes all the answers users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of answers users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching answers users
	 */
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Caches the answers user in the entity cache if it is enabled.
	 *
	 * @param answersUser the answers user
	 */
	public static void cacheResult(AnswersUser answersUser) {
		getPersistence().cacheResult(answersUser);
	}

	/**
	 * Caches the answers users in the entity cache if it is enabled.
	 *
	 * @param answersUsers the answers users
	 */
	public static void cacheResult(List<AnswersUser> answersUsers) {
		getPersistence().cacheResult(answersUsers);
	}

	/**
	 * Creates a new answers user with the primary key. Does not add the answers user to the database.
	 *
	 * @param answerUserId the primary key for the new answers user
	 * @return the new answers user
	 */
	public static AnswersUser create(long answerUserId) {
		return getPersistence().create(answerUserId);
	}

	/**
	 * Removes the answers user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param answerUserId the primary key of the answers user
	 * @return the answers user that was removed
	 * @throws NoSuchAnswersUserException if a answers user with the primary key could not be found
	 */
	public static AnswersUser remove(long answerUserId)
		throws avanis.comunidad.exception.NoSuchAnswersUserException {

		return getPersistence().remove(answerUserId);
	}

	public static AnswersUser updateImpl(AnswersUser answersUser) {
		return getPersistence().updateImpl(answersUser);
	}

	/**
	 * Returns the answers user with the primary key or throws a <code>NoSuchAnswersUserException</code> if it could not be found.
	 *
	 * @param answerUserId the primary key of the answers user
	 * @return the answers user
	 * @throws NoSuchAnswersUserException if a answers user with the primary key could not be found
	 */
	public static AnswersUser findByPrimaryKey(long answerUserId)
		throws avanis.comunidad.exception.NoSuchAnswersUserException {

		return getPersistence().findByPrimaryKey(answerUserId);
	}

	/**
	 * Returns the answers user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param answerUserId the primary key of the answers user
	 * @return the answers user, or <code>null</code> if a answers user with the primary key could not be found
	 */
	public static AnswersUser fetchByPrimaryKey(long answerUserId) {
		return getPersistence().fetchByPrimaryKey(answerUserId);
	}

	/**
	 * Returns all the answers users.
	 *
	 * @return the answers users
	 */
	public static List<AnswersUser> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the answers users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @return the range of answers users
	 */
	public static List<AnswersUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the answers users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of answers users
	 */
	public static List<AnswersUser> findAll(
		int start, int end, OrderByComparator<AnswersUser> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the answers users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnswersUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of answers users
	 * @param end the upper bound of the range of answers users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of answers users
	 */
	public static List<AnswersUser> findAll(
		int start, int end, OrderByComparator<AnswersUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the answers users from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of answers users.
	 *
	 * @return the number of answers users
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AnswersUserPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AnswersUserPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AnswersUserPersistence _persistence;

}