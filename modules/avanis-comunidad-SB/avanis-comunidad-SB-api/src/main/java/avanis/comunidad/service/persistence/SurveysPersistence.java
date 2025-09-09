/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.service.persistence;

import avanis.comunidad.exception.NoSuchSurveysException;
import avanis.comunidad.model.Surveys;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the surveys service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SurveysUtil
 * @generated
 */
@ProviderType
public interface SurveysPersistence extends BasePersistence<Surveys> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SurveysUtil} to access the surveys persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the surveyses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching surveyses
	 */
	public java.util.List<Surveys> findByUuid(String uuid);

	/**
	 * Returns a range of all the surveyses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SurveysModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of surveyses
	 * @param end the upper bound of the range of surveyses (not inclusive)
	 * @return the range of matching surveyses
	 */
	public java.util.List<Surveys> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the surveyses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SurveysModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of surveyses
	 * @param end the upper bound of the range of surveyses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching surveyses
	 */
	public java.util.List<Surveys> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Surveys>
			orderByComparator);

	/**
	 * Returns an ordered range of all the surveyses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SurveysModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of surveyses
	 * @param end the upper bound of the range of surveyses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching surveyses
	 */
	public java.util.List<Surveys> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Surveys>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first surveys in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching surveys
	 * @throws NoSuchSurveysException if a matching surveys could not be found
	 */
	public Surveys findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Surveys>
				orderByComparator)
		throws NoSuchSurveysException;

	/**
	 * Returns the first surveys in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	public Surveys fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Surveys>
			orderByComparator);

	/**
	 * Returns the last surveys in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching surveys
	 * @throws NoSuchSurveysException if a matching surveys could not be found
	 */
	public Surveys findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Surveys>
				orderByComparator)
		throws NoSuchSurveysException;

	/**
	 * Returns the last surveys in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	public Surveys fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Surveys>
			orderByComparator);

	/**
	 * Returns the surveyses before and after the current surveys in the ordered set where uuid = &#63;.
	 *
	 * @param surveyId the primary key of the current surveys
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next surveys
	 * @throws NoSuchSurveysException if a surveys with the primary key could not be found
	 */
	public Surveys[] findByUuid_PrevAndNext(
			long surveyId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Surveys>
				orderByComparator)
		throws NoSuchSurveysException;

	/**
	 * Removes all the surveyses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of surveyses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching surveyses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the surveys where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSurveysException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching surveys
	 * @throws NoSuchSurveysException if a matching surveys could not be found
	 */
	public Surveys findByUUID_G(String uuid, long groupId)
		throws NoSuchSurveysException;

	/**
	 * Returns the surveys where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	public Surveys fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the surveys where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	public Surveys fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the surveys where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the surveys that was removed
	 */
	public Surveys removeByUUID_G(String uuid, long groupId)
		throws NoSuchSurveysException;

	/**
	 * Returns the number of surveyses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching surveyses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the surveyses where assetId = &#63;.
	 *
	 * @param assetId the asset ID
	 * @return the matching surveyses
	 */
	public java.util.List<Surveys> findByassetId(long assetId);

	/**
	 * Returns a range of all the surveyses where assetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SurveysModelImpl</code>.
	 * </p>
	 *
	 * @param assetId the asset ID
	 * @param start the lower bound of the range of surveyses
	 * @param end the upper bound of the range of surveyses (not inclusive)
	 * @return the range of matching surveyses
	 */
	public java.util.List<Surveys> findByassetId(
		long assetId, int start, int end);

	/**
	 * Returns an ordered range of all the surveyses where assetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SurveysModelImpl</code>.
	 * </p>
	 *
	 * @param assetId the asset ID
	 * @param start the lower bound of the range of surveyses
	 * @param end the upper bound of the range of surveyses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching surveyses
	 */
	public java.util.List<Surveys> findByassetId(
		long assetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Surveys>
			orderByComparator);

	/**
	 * Returns an ordered range of all the surveyses where assetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SurveysModelImpl</code>.
	 * </p>
	 *
	 * @param assetId the asset ID
	 * @param start the lower bound of the range of surveyses
	 * @param end the upper bound of the range of surveyses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching surveyses
	 */
	public java.util.List<Surveys> findByassetId(
		long assetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Surveys>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first surveys in the ordered set where assetId = &#63;.
	 *
	 * @param assetId the asset ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching surveys
	 * @throws NoSuchSurveysException if a matching surveys could not be found
	 */
	public Surveys findByassetId_First(
			long assetId,
			com.liferay.portal.kernel.util.OrderByComparator<Surveys>
				orderByComparator)
		throws NoSuchSurveysException;

	/**
	 * Returns the first surveys in the ordered set where assetId = &#63;.
	 *
	 * @param assetId the asset ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	public Surveys fetchByassetId_First(
		long assetId,
		com.liferay.portal.kernel.util.OrderByComparator<Surveys>
			orderByComparator);

	/**
	 * Returns the last surveys in the ordered set where assetId = &#63;.
	 *
	 * @param assetId the asset ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching surveys
	 * @throws NoSuchSurveysException if a matching surveys could not be found
	 */
	public Surveys findByassetId_Last(
			long assetId,
			com.liferay.portal.kernel.util.OrderByComparator<Surveys>
				orderByComparator)
		throws NoSuchSurveysException;

	/**
	 * Returns the last surveys in the ordered set where assetId = &#63;.
	 *
	 * @param assetId the asset ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	public Surveys fetchByassetId_Last(
		long assetId,
		com.liferay.portal.kernel.util.OrderByComparator<Surveys>
			orderByComparator);

	/**
	 * Returns the surveyses before and after the current surveys in the ordered set where assetId = &#63;.
	 *
	 * @param surveyId the primary key of the current surveys
	 * @param assetId the asset ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next surveys
	 * @throws NoSuchSurveysException if a surveys with the primary key could not be found
	 */
	public Surveys[] findByassetId_PrevAndNext(
			long surveyId, long assetId,
			com.liferay.portal.kernel.util.OrderByComparator<Surveys>
				orderByComparator)
		throws NoSuchSurveysException;

	/**
	 * Removes all the surveyses where assetId = &#63; from the database.
	 *
	 * @param assetId the asset ID
	 */
	public void removeByassetId(long assetId);

	/**
	 * Returns the number of surveyses where assetId = &#63;.
	 *
	 * @param assetId the asset ID
	 * @return the number of matching surveyses
	 */
	public int countByassetId(long assetId);

	/**
	 * Returns all the surveyses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching surveyses
	 */
	public java.util.List<Surveys> findByuserId(long userId);

	/**
	 * Returns a range of all the surveyses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SurveysModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of surveyses
	 * @param end the upper bound of the range of surveyses (not inclusive)
	 * @return the range of matching surveyses
	 */
	public java.util.List<Surveys> findByuserId(
		long userId, int start, int end);

	/**
	 * Returns an ordered range of all the surveyses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SurveysModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of surveyses
	 * @param end the upper bound of the range of surveyses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching surveyses
	 */
	public java.util.List<Surveys> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Surveys>
			orderByComparator);

	/**
	 * Returns an ordered range of all the surveyses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SurveysModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of surveyses
	 * @param end the upper bound of the range of surveyses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching surveyses
	 */
	public java.util.List<Surveys> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Surveys>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first surveys in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching surveys
	 * @throws NoSuchSurveysException if a matching surveys could not be found
	 */
	public Surveys findByuserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Surveys>
				orderByComparator)
		throws NoSuchSurveysException;

	/**
	 * Returns the first surveys in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	public Surveys fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Surveys>
			orderByComparator);

	/**
	 * Returns the last surveys in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching surveys
	 * @throws NoSuchSurveysException if a matching surveys could not be found
	 */
	public Surveys findByuserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Surveys>
				orderByComparator)
		throws NoSuchSurveysException;

	/**
	 * Returns the last surveys in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	public Surveys fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Surveys>
			orderByComparator);

	/**
	 * Returns the surveyses before and after the current surveys in the ordered set where userId = &#63;.
	 *
	 * @param surveyId the primary key of the current surveys
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next surveys
	 * @throws NoSuchSurveysException if a surveys with the primary key could not be found
	 */
	public Surveys[] findByuserId_PrevAndNext(
			long surveyId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Surveys>
				orderByComparator)
		throws NoSuchSurveysException;

	/**
	 * Removes all the surveyses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByuserId(long userId);

	/**
	 * Returns the number of surveyses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching surveyses
	 */
	public int countByuserId(long userId);

	/**
	 * Caches the surveys in the entity cache if it is enabled.
	 *
	 * @param surveys the surveys
	 */
	public void cacheResult(Surveys surveys);

	/**
	 * Caches the surveyses in the entity cache if it is enabled.
	 *
	 * @param surveyses the surveyses
	 */
	public void cacheResult(java.util.List<Surveys> surveyses);

	/**
	 * Creates a new surveys with the primary key. Does not add the surveys to the database.
	 *
	 * @param surveyId the primary key for the new surveys
	 * @return the new surveys
	 */
	public Surveys create(long surveyId);

	/**
	 * Removes the surveys with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surveyId the primary key of the surveys
	 * @return the surveys that was removed
	 * @throws NoSuchSurveysException if a surveys with the primary key could not be found
	 */
	public Surveys remove(long surveyId) throws NoSuchSurveysException;

	public Surveys updateImpl(Surveys surveys);

	/**
	 * Returns the surveys with the primary key or throws a <code>NoSuchSurveysException</code> if it could not be found.
	 *
	 * @param surveyId the primary key of the surveys
	 * @return the surveys
	 * @throws NoSuchSurveysException if a surveys with the primary key could not be found
	 */
	public Surveys findByPrimaryKey(long surveyId)
		throws NoSuchSurveysException;

	/**
	 * Returns the surveys with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param surveyId the primary key of the surveys
	 * @return the surveys, or <code>null</code> if a surveys with the primary key could not be found
	 */
	public Surveys fetchByPrimaryKey(long surveyId);

	/**
	 * Returns all the surveyses.
	 *
	 * @return the surveyses
	 */
	public java.util.List<Surveys> findAll();

	/**
	 * Returns a range of all the surveyses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SurveysModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of surveyses
	 * @param end the upper bound of the range of surveyses (not inclusive)
	 * @return the range of surveyses
	 */
	public java.util.List<Surveys> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the surveyses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SurveysModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of surveyses
	 * @param end the upper bound of the range of surveyses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of surveyses
	 */
	public java.util.List<Surveys> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Surveys>
			orderByComparator);

	/**
	 * Returns an ordered range of all the surveyses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SurveysModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of surveyses
	 * @param end the upper bound of the range of surveyses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of surveyses
	 */
	public java.util.List<Surveys> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Surveys>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the surveyses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of surveyses.
	 *
	 * @return the number of surveyses
	 */
	public int countAll();

}