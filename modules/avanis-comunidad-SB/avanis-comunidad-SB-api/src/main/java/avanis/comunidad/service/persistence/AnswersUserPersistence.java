/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.service.persistence;

import avanis.comunidad.exception.NoSuchAnswersUserException;
import avanis.comunidad.model.AnswersUser;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the answers user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnswersUserUtil
 * @generated
 */
@ProviderType
public interface AnswersUserPersistence extends BasePersistence<AnswersUser> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnswersUserUtil} to access the answers user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the answers users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching answers users
	 */
	public java.util.List<AnswersUser> findByUuid(String uuid);

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
	public java.util.List<AnswersUser> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<AnswersUser> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator);

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
	public java.util.List<AnswersUser> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first answers user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	public AnswersUser findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
				orderByComparator)
		throws NoSuchAnswersUserException;

	/**
	 * Returns the first answers user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	public AnswersUser fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator);

	/**
	 * Returns the last answers user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	public AnswersUser findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
				orderByComparator)
		throws NoSuchAnswersUserException;

	/**
	 * Returns the last answers user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	public AnswersUser fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator);

	/**
	 * Returns the answers users before and after the current answers user in the ordered set where uuid = &#63;.
	 *
	 * @param answerUserId the primary key of the current answers user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answers user
	 * @throws NoSuchAnswersUserException if a answers user with the primary key could not be found
	 */
	public AnswersUser[] findByUuid_PrevAndNext(
			long answerUserId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
				orderByComparator)
		throws NoSuchAnswersUserException;

	/**
	 * Removes all the answers users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of answers users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching answers users
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the answers users where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @return the matching answers users
	 */
	public java.util.List<AnswersUser> findBysurveyId(long surveyId);

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
	public java.util.List<AnswersUser> findBysurveyId(
		long surveyId, int start, int end);

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
	public java.util.List<AnswersUser> findBysurveyId(
		long surveyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator);

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
	public java.util.List<AnswersUser> findBysurveyId(
		long surveyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first answers user in the ordered set where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	public AnswersUser findBysurveyId_First(
			long surveyId,
			com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
				orderByComparator)
		throws NoSuchAnswersUserException;

	/**
	 * Returns the first answers user in the ordered set where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	public AnswersUser fetchBysurveyId_First(
		long surveyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator);

	/**
	 * Returns the last answers user in the ordered set where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	public AnswersUser findBysurveyId_Last(
			long surveyId,
			com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
				orderByComparator)
		throws NoSuchAnswersUserException;

	/**
	 * Returns the last answers user in the ordered set where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	public AnswersUser fetchBysurveyId_Last(
		long surveyId,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator);

	/**
	 * Returns the answers users before and after the current answers user in the ordered set where surveyId = &#63;.
	 *
	 * @param answerUserId the primary key of the current answers user
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answers user
	 * @throws NoSuchAnswersUserException if a answers user with the primary key could not be found
	 */
	public AnswersUser[] findBysurveyId_PrevAndNext(
			long answerUserId, long surveyId,
			com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
				orderByComparator)
		throws NoSuchAnswersUserException;

	/**
	 * Removes all the answers users where surveyId = &#63; from the database.
	 *
	 * @param surveyId the survey ID
	 */
	public void removeBysurveyId(long surveyId);

	/**
	 * Returns the number of answers users where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @return the number of matching answers users
	 */
	public int countBysurveyId(long surveyId);

	/**
	 * Returns all the answers users where surveyId = &#63; and userId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @return the matching answers users
	 */
	public java.util.List<AnswersUser> findBysurveyIdUserId(
		long surveyId, long userId);

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
	public java.util.List<AnswersUser> findBysurveyIdUserId(
		long surveyId, long userId, int start, int end);

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
	public java.util.List<AnswersUser> findBysurveyIdUserId(
		long surveyId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator);

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
	public java.util.List<AnswersUser> findBysurveyIdUserId(
		long surveyId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first answers user in the ordered set where surveyId = &#63; and userId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	public AnswersUser findBysurveyIdUserId_First(
			long surveyId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
				orderByComparator)
		throws NoSuchAnswersUserException;

	/**
	 * Returns the first answers user in the ordered set where surveyId = &#63; and userId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	public AnswersUser fetchBysurveyIdUserId_First(
		long surveyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator);

	/**
	 * Returns the last answers user in the ordered set where surveyId = &#63; and userId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	public AnswersUser findBysurveyIdUserId_Last(
			long surveyId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
				orderByComparator)
		throws NoSuchAnswersUserException;

	/**
	 * Returns the last answers user in the ordered set where surveyId = &#63; and userId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	public AnswersUser fetchBysurveyIdUserId_Last(
		long surveyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator);

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
	public AnswersUser[] findBysurveyIdUserId_PrevAndNext(
			long answerUserId, long surveyId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
				orderByComparator)
		throws NoSuchAnswersUserException;

	/**
	 * Removes all the answers users where surveyId = &#63; and userId = &#63; from the database.
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 */
	public void removeBysurveyIdUserId(long surveyId, long userId);

	/**
	 * Returns the number of answers users where surveyId = &#63; and userId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param userId the user ID
	 * @return the number of matching answers users
	 */
	public int countBysurveyIdUserId(long surveyId, long userId);

	/**
	 * Returns all the answers users where answerId = &#63; and userId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @return the matching answers users
	 */
	public java.util.List<AnswersUser> findByanswerIdUserId(
		long answerId, long userId);

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
	public java.util.List<AnswersUser> findByanswerIdUserId(
		long answerId, long userId, int start, int end);

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
	public java.util.List<AnswersUser> findByanswerIdUserId(
		long answerId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator);

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
	public java.util.List<AnswersUser> findByanswerIdUserId(
		long answerId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first answers user in the ordered set where answerId = &#63; and userId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	public AnswersUser findByanswerIdUserId_First(
			long answerId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
				orderByComparator)
		throws NoSuchAnswersUserException;

	/**
	 * Returns the first answers user in the ordered set where answerId = &#63; and userId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	public AnswersUser fetchByanswerIdUserId_First(
		long answerId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator);

	/**
	 * Returns the last answers user in the ordered set where answerId = &#63; and userId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	public AnswersUser findByanswerIdUserId_Last(
			long answerId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
				orderByComparator)
		throws NoSuchAnswersUserException;

	/**
	 * Returns the last answers user in the ordered set where answerId = &#63; and userId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	public AnswersUser fetchByanswerIdUserId_Last(
		long answerId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator);

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
	public AnswersUser[] findByanswerIdUserId_PrevAndNext(
			long answerUserId, long answerId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
				orderByComparator)
		throws NoSuchAnswersUserException;

	/**
	 * Removes all the answers users where answerId = &#63; and userId = &#63; from the database.
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 */
	public void removeByanswerIdUserId(long answerId, long userId);

	/**
	 * Returns the number of answers users where answerId = &#63; and userId = &#63;.
	 *
	 * @param answerId the answer ID
	 * @param userId the user ID
	 * @return the number of matching answers users
	 */
	public int countByanswerIdUserId(long answerId, long userId);

	/**
	 * Returns all the answers users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching answers users
	 */
	public java.util.List<AnswersUser> findByuserId(long userId);

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
	public java.util.List<AnswersUser> findByuserId(
		long userId, int start, int end);

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
	public java.util.List<AnswersUser> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator);

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
	public java.util.List<AnswersUser> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first answers user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	public AnswersUser findByuserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
				orderByComparator)
		throws NoSuchAnswersUserException;

	/**
	 * Returns the first answers user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	public AnswersUser fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator);

	/**
	 * Returns the last answers user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user
	 * @throws NoSuchAnswersUserException if a matching answers user could not be found
	 */
	public AnswersUser findByuserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
				orderByComparator)
		throws NoSuchAnswersUserException;

	/**
	 * Returns the last answers user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers user, or <code>null</code> if a matching answers user could not be found
	 */
	public AnswersUser fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator);

	/**
	 * Returns the answers users before and after the current answers user in the ordered set where userId = &#63;.
	 *
	 * @param answerUserId the primary key of the current answers user
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answers user
	 * @throws NoSuchAnswersUserException if a answers user with the primary key could not be found
	 */
	public AnswersUser[] findByuserId_PrevAndNext(
			long answerUserId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
				orderByComparator)
		throws NoSuchAnswersUserException;

	/**
	 * Removes all the answers users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByuserId(long userId);

	/**
	 * Returns the number of answers users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching answers users
	 */
	public int countByuserId(long userId);

	/**
	 * Caches the answers user in the entity cache if it is enabled.
	 *
	 * @param answersUser the answers user
	 */
	public void cacheResult(AnswersUser answersUser);

	/**
	 * Caches the answers users in the entity cache if it is enabled.
	 *
	 * @param answersUsers the answers users
	 */
	public void cacheResult(java.util.List<AnswersUser> answersUsers);

	/**
	 * Creates a new answers user with the primary key. Does not add the answers user to the database.
	 *
	 * @param answerUserId the primary key for the new answers user
	 * @return the new answers user
	 */
	public AnswersUser create(long answerUserId);

	/**
	 * Removes the answers user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param answerUserId the primary key of the answers user
	 * @return the answers user that was removed
	 * @throws NoSuchAnswersUserException if a answers user with the primary key could not be found
	 */
	public AnswersUser remove(long answerUserId)
		throws NoSuchAnswersUserException;

	public AnswersUser updateImpl(AnswersUser answersUser);

	/**
	 * Returns the answers user with the primary key or throws a <code>NoSuchAnswersUserException</code> if it could not be found.
	 *
	 * @param answerUserId the primary key of the answers user
	 * @return the answers user
	 * @throws NoSuchAnswersUserException if a answers user with the primary key could not be found
	 */
	public AnswersUser findByPrimaryKey(long answerUserId)
		throws NoSuchAnswersUserException;

	/**
	 * Returns the answers user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param answerUserId the primary key of the answers user
	 * @return the answers user, or <code>null</code> if a answers user with the primary key could not be found
	 */
	public AnswersUser fetchByPrimaryKey(long answerUserId);

	/**
	 * Returns all the answers users.
	 *
	 * @return the answers users
	 */
	public java.util.List<AnswersUser> findAll();

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
	public java.util.List<AnswersUser> findAll(int start, int end);

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
	public java.util.List<AnswersUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator);

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
	public java.util.List<AnswersUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnswersUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the answers users from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of answers users.
	 *
	 * @return the number of answers users
	 */
	public int countAll();

}