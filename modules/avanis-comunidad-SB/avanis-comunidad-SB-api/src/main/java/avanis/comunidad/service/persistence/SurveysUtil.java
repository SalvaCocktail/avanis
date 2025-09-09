/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.service.persistence;

import avanis.comunidad.model.Surveys;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the surveys service. This utility wraps <code>avanis.comunidad.service.persistence.impl.SurveysPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SurveysPersistence
 * @generated
 */
public class SurveysUtil {

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
	public static void clearCache(Surveys surveys) {
		getPersistence().clearCache(surveys);
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
	public static Map<Serializable, Surveys> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Surveys> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Surveys> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Surveys> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Surveys> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Surveys update(Surveys surveys) {
		return getPersistence().update(surveys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Surveys update(
		Surveys surveys, ServiceContext serviceContext) {

		return getPersistence().update(surveys, serviceContext);
	}

	/**
	 * Returns all the surveyses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching surveyses
	 */
	public static List<Surveys> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Surveys> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Surveys> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Surveys> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Surveys> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Surveys> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first surveys in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching surveys
	 * @throws NoSuchSurveysException if a matching surveys could not be found
	 */
	public static Surveys findByUuid_First(
			String uuid, OrderByComparator<Surveys> orderByComparator)
		throws avanis.comunidad.exception.NoSuchSurveysException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first surveys in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	public static Surveys fetchByUuid_First(
		String uuid, OrderByComparator<Surveys> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last surveys in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching surveys
	 * @throws NoSuchSurveysException if a matching surveys could not be found
	 */
	public static Surveys findByUuid_Last(
			String uuid, OrderByComparator<Surveys> orderByComparator)
		throws avanis.comunidad.exception.NoSuchSurveysException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last surveys in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	public static Surveys fetchByUuid_Last(
		String uuid, OrderByComparator<Surveys> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the surveyses before and after the current surveys in the ordered set where uuid = &#63;.
	 *
	 * @param surveyId the primary key of the current surveys
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next surveys
	 * @throws NoSuchSurveysException if a surveys with the primary key could not be found
	 */
	public static Surveys[] findByUuid_PrevAndNext(
			long surveyId, String uuid,
			OrderByComparator<Surveys> orderByComparator)
		throws avanis.comunidad.exception.NoSuchSurveysException {

		return getPersistence().findByUuid_PrevAndNext(
			surveyId, uuid, orderByComparator);
	}

	/**
	 * Removes all the surveyses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of surveyses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching surveyses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the surveys where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSurveysException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching surveys
	 * @throws NoSuchSurveysException if a matching surveys could not be found
	 */
	public static Surveys findByUUID_G(String uuid, long groupId)
		throws avanis.comunidad.exception.NoSuchSurveysException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the surveys where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	public static Surveys fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the surveys where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	public static Surveys fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the surveys where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the surveys that was removed
	 */
	public static Surveys removeByUUID_G(String uuid, long groupId)
		throws avanis.comunidad.exception.NoSuchSurveysException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of surveyses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching surveyses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the surveyses where assetId = &#63;.
	 *
	 * @param assetId the asset ID
	 * @return the matching surveyses
	 */
	public static List<Surveys> findByassetId(long assetId) {
		return getPersistence().findByassetId(assetId);
	}

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
	public static List<Surveys> findByassetId(
		long assetId, int start, int end) {

		return getPersistence().findByassetId(assetId, start, end);
	}

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
	public static List<Surveys> findByassetId(
		long assetId, int start, int end,
		OrderByComparator<Surveys> orderByComparator) {

		return getPersistence().findByassetId(
			assetId, start, end, orderByComparator);
	}

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
	public static List<Surveys> findByassetId(
		long assetId, int start, int end,
		OrderByComparator<Surveys> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByassetId(
			assetId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first surveys in the ordered set where assetId = &#63;.
	 *
	 * @param assetId the asset ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching surveys
	 * @throws NoSuchSurveysException if a matching surveys could not be found
	 */
	public static Surveys findByassetId_First(
			long assetId, OrderByComparator<Surveys> orderByComparator)
		throws avanis.comunidad.exception.NoSuchSurveysException {

		return getPersistence().findByassetId_First(assetId, orderByComparator);
	}

	/**
	 * Returns the first surveys in the ordered set where assetId = &#63;.
	 *
	 * @param assetId the asset ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	public static Surveys fetchByassetId_First(
		long assetId, OrderByComparator<Surveys> orderByComparator) {

		return getPersistence().fetchByassetId_First(
			assetId, orderByComparator);
	}

	/**
	 * Returns the last surveys in the ordered set where assetId = &#63;.
	 *
	 * @param assetId the asset ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching surveys
	 * @throws NoSuchSurveysException if a matching surveys could not be found
	 */
	public static Surveys findByassetId_Last(
			long assetId, OrderByComparator<Surveys> orderByComparator)
		throws avanis.comunidad.exception.NoSuchSurveysException {

		return getPersistence().findByassetId_Last(assetId, orderByComparator);
	}

	/**
	 * Returns the last surveys in the ordered set where assetId = &#63;.
	 *
	 * @param assetId the asset ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	public static Surveys fetchByassetId_Last(
		long assetId, OrderByComparator<Surveys> orderByComparator) {

		return getPersistence().fetchByassetId_Last(assetId, orderByComparator);
	}

	/**
	 * Returns the surveyses before and after the current surveys in the ordered set where assetId = &#63;.
	 *
	 * @param surveyId the primary key of the current surveys
	 * @param assetId the asset ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next surveys
	 * @throws NoSuchSurveysException if a surveys with the primary key could not be found
	 */
	public static Surveys[] findByassetId_PrevAndNext(
			long surveyId, long assetId,
			OrderByComparator<Surveys> orderByComparator)
		throws avanis.comunidad.exception.NoSuchSurveysException {

		return getPersistence().findByassetId_PrevAndNext(
			surveyId, assetId, orderByComparator);
	}

	/**
	 * Removes all the surveyses where assetId = &#63; from the database.
	 *
	 * @param assetId the asset ID
	 */
	public static void removeByassetId(long assetId) {
		getPersistence().removeByassetId(assetId);
	}

	/**
	 * Returns the number of surveyses where assetId = &#63;.
	 *
	 * @param assetId the asset ID
	 * @return the number of matching surveyses
	 */
	public static int countByassetId(long assetId) {
		return getPersistence().countByassetId(assetId);
	}

	/**
	 * Returns all the surveyses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching surveyses
	 */
	public static List<Surveys> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

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
	public static List<Surveys> findByuserId(long userId, int start, int end) {
		return getPersistence().findByuserId(userId, start, end);
	}

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
	public static List<Surveys> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Surveys> orderByComparator) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator);
	}

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
	public static List<Surveys> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Surveys> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first surveys in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching surveys
	 * @throws NoSuchSurveysException if a matching surveys could not be found
	 */
	public static Surveys findByuserId_First(
			long userId, OrderByComparator<Surveys> orderByComparator)
		throws avanis.comunidad.exception.NoSuchSurveysException {

		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first surveys in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	public static Surveys fetchByuserId_First(
		long userId, OrderByComparator<Surveys> orderByComparator) {

		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last surveys in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching surveys
	 * @throws NoSuchSurveysException if a matching surveys could not be found
	 */
	public static Surveys findByuserId_Last(
			long userId, OrderByComparator<Surveys> orderByComparator)
		throws avanis.comunidad.exception.NoSuchSurveysException {

		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last surveys in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	public static Surveys fetchByuserId_Last(
		long userId, OrderByComparator<Surveys> orderByComparator) {

		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the surveyses before and after the current surveys in the ordered set where userId = &#63;.
	 *
	 * @param surveyId the primary key of the current surveys
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next surveys
	 * @throws NoSuchSurveysException if a surveys with the primary key could not be found
	 */
	public static Surveys[] findByuserId_PrevAndNext(
			long surveyId, long userId,
			OrderByComparator<Surveys> orderByComparator)
		throws avanis.comunidad.exception.NoSuchSurveysException {

		return getPersistence().findByuserId_PrevAndNext(
			surveyId, userId, orderByComparator);
	}

	/**
	 * Removes all the surveyses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of surveyses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching surveyses
	 */
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Caches the surveys in the entity cache if it is enabled.
	 *
	 * @param surveys the surveys
	 */
	public static void cacheResult(Surveys surveys) {
		getPersistence().cacheResult(surveys);
	}

	/**
	 * Caches the surveyses in the entity cache if it is enabled.
	 *
	 * @param surveyses the surveyses
	 */
	public static void cacheResult(List<Surveys> surveyses) {
		getPersistence().cacheResult(surveyses);
	}

	/**
	 * Creates a new surveys with the primary key. Does not add the surveys to the database.
	 *
	 * @param surveyId the primary key for the new surveys
	 * @return the new surveys
	 */
	public static Surveys create(long surveyId) {
		return getPersistence().create(surveyId);
	}

	/**
	 * Removes the surveys with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surveyId the primary key of the surveys
	 * @return the surveys that was removed
	 * @throws NoSuchSurveysException if a surveys with the primary key could not be found
	 */
	public static Surveys remove(long surveyId)
		throws avanis.comunidad.exception.NoSuchSurveysException {

		return getPersistence().remove(surveyId);
	}

	public static Surveys updateImpl(Surveys surveys) {
		return getPersistence().updateImpl(surveys);
	}

	/**
	 * Returns the surveys with the primary key or throws a <code>NoSuchSurveysException</code> if it could not be found.
	 *
	 * @param surveyId the primary key of the surveys
	 * @return the surveys
	 * @throws NoSuchSurveysException if a surveys with the primary key could not be found
	 */
	public static Surveys findByPrimaryKey(long surveyId)
		throws avanis.comunidad.exception.NoSuchSurveysException {

		return getPersistence().findByPrimaryKey(surveyId);
	}

	/**
	 * Returns the surveys with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param surveyId the primary key of the surveys
	 * @return the surveys, or <code>null</code> if a surveys with the primary key could not be found
	 */
	public static Surveys fetchByPrimaryKey(long surveyId) {
		return getPersistence().fetchByPrimaryKey(surveyId);
	}

	/**
	 * Returns all the surveyses.
	 *
	 * @return the surveyses
	 */
	public static List<Surveys> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Surveys> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Surveys> findAll(
		int start, int end, OrderByComparator<Surveys> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Surveys> findAll(
		int start, int end, OrderByComparator<Surveys> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the surveyses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of surveyses.
	 *
	 * @return the number of surveyses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SurveysPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(SurveysPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile SurveysPersistence _persistence;

}