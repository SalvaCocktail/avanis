/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.service.persistence;

import avanis.comunidad.exception.NoSuchAnswersException;
import avanis.comunidad.model.Answers;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the answers service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnswersUtil
 * @generated
 */
@ProviderType
public interface AnswersPersistence extends BasePersistence<Answers> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnswersUtil} to access the answers persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the answerses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching answerses
	 */
	public java.util.List<Answers> findByUuid(String uuid);

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
	public java.util.List<Answers> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Answers> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Answers>
			orderByComparator);

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
	public java.util.List<Answers> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Answers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first answers in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers
	 * @throws NoSuchAnswersException if a matching answers could not be found
	 */
	public Answers findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Answers>
				orderByComparator)
		throws NoSuchAnswersException;

	/**
	 * Returns the first answers in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers, or <code>null</code> if a matching answers could not be found
	 */
	public Answers fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Answers>
			orderByComparator);

	/**
	 * Returns the last answers in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers
	 * @throws NoSuchAnswersException if a matching answers could not be found
	 */
	public Answers findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Answers>
				orderByComparator)
		throws NoSuchAnswersException;

	/**
	 * Returns the last answers in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers, or <code>null</code> if a matching answers could not be found
	 */
	public Answers fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Answers>
			orderByComparator);

	/**
	 * Returns the answerses before and after the current answers in the ordered set where uuid = &#63;.
	 *
	 * @param answerId the primary key of the current answers
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answers
	 * @throws NoSuchAnswersException if a answers with the primary key could not be found
	 */
	public Answers[] findByUuid_PrevAndNext(
			long answerId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Answers>
				orderByComparator)
		throws NoSuchAnswersException;

	/**
	 * Removes all the answerses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of answerses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching answerses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the answerses where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @return the matching answerses
	 */
	public java.util.List<Answers> findBysurveyId(long surveyId);

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
	public java.util.List<Answers> findBysurveyId(
		long surveyId, int start, int end);

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
	public java.util.List<Answers> findBysurveyId(
		long surveyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Answers>
			orderByComparator);

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
	public java.util.List<Answers> findBysurveyId(
		long surveyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Answers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first answers in the ordered set where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers
	 * @throws NoSuchAnswersException if a matching answers could not be found
	 */
	public Answers findBysurveyId_First(
			long surveyId,
			com.liferay.portal.kernel.util.OrderByComparator<Answers>
				orderByComparator)
		throws NoSuchAnswersException;

	/**
	 * Returns the first answers in the ordered set where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching answers, or <code>null</code> if a matching answers could not be found
	 */
	public Answers fetchBysurveyId_First(
		long surveyId,
		com.liferay.portal.kernel.util.OrderByComparator<Answers>
			orderByComparator);

	/**
	 * Returns the last answers in the ordered set where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers
	 * @throws NoSuchAnswersException if a matching answers could not be found
	 */
	public Answers findBysurveyId_Last(
			long surveyId,
			com.liferay.portal.kernel.util.OrderByComparator<Answers>
				orderByComparator)
		throws NoSuchAnswersException;

	/**
	 * Returns the last answers in the ordered set where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching answers, or <code>null</code> if a matching answers could not be found
	 */
	public Answers fetchBysurveyId_Last(
		long surveyId,
		com.liferay.portal.kernel.util.OrderByComparator<Answers>
			orderByComparator);

	/**
	 * Returns the answerses before and after the current answers in the ordered set where surveyId = &#63;.
	 *
	 * @param answerId the primary key of the current answers
	 * @param surveyId the survey ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next answers
	 * @throws NoSuchAnswersException if a answers with the primary key could not be found
	 */
	public Answers[] findBysurveyId_PrevAndNext(
			long answerId, long surveyId,
			com.liferay.portal.kernel.util.OrderByComparator<Answers>
				orderByComparator)
		throws NoSuchAnswersException;

	/**
	 * Removes all the answerses where surveyId = &#63; from the database.
	 *
	 * @param surveyId the survey ID
	 */
	public void removeBysurveyId(long surveyId);

	/**
	 * Returns the number of answerses where surveyId = &#63;.
	 *
	 * @param surveyId the survey ID
	 * @return the number of matching answerses
	 */
	public int countBysurveyId(long surveyId);

	/**
	 * Caches the answers in the entity cache if it is enabled.
	 *
	 * @param answers the answers
	 */
	public void cacheResult(Answers answers);

	/**
	 * Caches the answerses in the entity cache if it is enabled.
	 *
	 * @param answerses the answerses
	 */
	public void cacheResult(java.util.List<Answers> answerses);

	/**
	 * Creates a new answers with the primary key. Does not add the answers to the database.
	 *
	 * @param answerId the primary key for the new answers
	 * @return the new answers
	 */
	public Answers create(long answerId);

	/**
	 * Removes the answers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param answerId the primary key of the answers
	 * @return the answers that was removed
	 * @throws NoSuchAnswersException if a answers with the primary key could not be found
	 */
	public Answers remove(long answerId) throws NoSuchAnswersException;

	public Answers updateImpl(Answers answers);

	/**
	 * Returns the answers with the primary key or throws a <code>NoSuchAnswersException</code> if it could not be found.
	 *
	 * @param answerId the primary key of the answers
	 * @return the answers
	 * @throws NoSuchAnswersException if a answers with the primary key could not be found
	 */
	public Answers findByPrimaryKey(long answerId)
		throws NoSuchAnswersException;

	/**
	 * Returns the answers with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param answerId the primary key of the answers
	 * @return the answers, or <code>null</code> if a answers with the primary key could not be found
	 */
	public Answers fetchByPrimaryKey(long answerId);

	/**
	 * Returns all the answerses.
	 *
	 * @return the answerses
	 */
	public java.util.List<Answers> findAll();

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
	public java.util.List<Answers> findAll(int start, int end);

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
	public java.util.List<Answers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Answers>
			orderByComparator);

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
	public java.util.List<Answers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Answers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the answerses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of answerses.
	 *
	 * @return the number of answerses
	 */
	public int countAll();

}