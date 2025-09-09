/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.service.persistence.impl;

import avanis.comunidad.exception.NoSuchSurveysException;
import avanis.comunidad.model.Surveys;
import avanis.comunidad.model.SurveysTable;
import avanis.comunidad.model.impl.SurveysImpl;
import avanis.comunidad.model.impl.SurveysModelImpl;
import avanis.comunidad.service.persistence.SurveysPersistence;
import avanis.comunidad.service.persistence.SurveysUtil;
import avanis.comunidad.service.persistence.impl.constants.AVANIS_COMUNIDADPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the surveys service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SurveysPersistence.class)
public class SurveysPersistenceImpl
	extends BasePersistenceImpl<Surveys> implements SurveysPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SurveysUtil</code> to access the surveys persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SurveysImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the surveyses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching surveyses
	 */
	@Override
	public List<Surveys> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Surveys> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Surveys> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Surveys> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Surveys> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Surveys> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Surveys> list = null;

		if (useFinderCache) {
			list = (List<Surveys>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Surveys surveys : list) {
					if (!uuid.equals(surveys.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SURVEYS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SurveysModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Surveys>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first surveys in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching surveys
	 * @throws NoSuchSurveysException if a matching surveys could not be found
	 */
	@Override
	public Surveys findByUuid_First(
			String uuid, OrderByComparator<Surveys> orderByComparator)
		throws NoSuchSurveysException {

		Surveys surveys = fetchByUuid_First(uuid, orderByComparator);

		if (surveys != null) {
			return surveys;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSurveysException(sb.toString());
	}

	/**
	 * Returns the first surveys in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	@Override
	public Surveys fetchByUuid_First(
		String uuid, OrderByComparator<Surveys> orderByComparator) {

		List<Surveys> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last surveys in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching surveys
	 * @throws NoSuchSurveysException if a matching surveys could not be found
	 */
	@Override
	public Surveys findByUuid_Last(
			String uuid, OrderByComparator<Surveys> orderByComparator)
		throws NoSuchSurveysException {

		Surveys surveys = fetchByUuid_Last(uuid, orderByComparator);

		if (surveys != null) {
			return surveys;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSurveysException(sb.toString());
	}

	/**
	 * Returns the last surveys in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	@Override
	public Surveys fetchByUuid_Last(
		String uuid, OrderByComparator<Surveys> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Surveys> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Surveys[] findByUuid_PrevAndNext(
			long surveyId, String uuid,
			OrderByComparator<Surveys> orderByComparator)
		throws NoSuchSurveysException {

		uuid = Objects.toString(uuid, "");

		Surveys surveys = findByPrimaryKey(surveyId);

		Session session = null;

		try {
			session = openSession();

			Surveys[] array = new SurveysImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, surveys, uuid, orderByComparator, true);

			array[1] = surveys;

			array[2] = getByUuid_PrevAndNext(
				session, surveys, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Surveys getByUuid_PrevAndNext(
		Session session, Surveys surveys, String uuid,
		OrderByComparator<Surveys> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SURVEYS_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SurveysModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(surveys)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Surveys> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the surveyses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Surveys surveys :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(surveys);
		}
	}

	/**
	 * Returns the number of surveyses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching surveyses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SURVEYS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "surveys.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(surveys.uuid IS NULL OR surveys.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the surveys where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSurveysException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching surveys
	 * @throws NoSuchSurveysException if a matching surveys could not be found
	 */
	@Override
	public Surveys findByUUID_G(String uuid, long groupId)
		throws NoSuchSurveysException {

		Surveys surveys = fetchByUUID_G(uuid, groupId);

		if (surveys == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSurveysException(sb.toString());
		}

		return surveys;
	}

	/**
	 * Returns the surveys where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	@Override
	public Surveys fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the surveys where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	@Override
	public Surveys fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Surveys) {
			Surveys surveys = (Surveys)result;

			if (!Objects.equals(uuid, surveys.getUuid()) ||
				(groupId != surveys.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SURVEYS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Surveys> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Surveys surveys = list.get(0);

					result = surveys;

					cacheResult(surveys);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Surveys)result;
		}
	}

	/**
	 * Removes the surveys where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the surveys that was removed
	 */
	@Override
	public Surveys removeByUUID_G(String uuid, long groupId)
		throws NoSuchSurveysException {

		Surveys surveys = findByUUID_G(uuid, groupId);

		return remove(surveys);
	}

	/**
	 * Returns the number of surveyses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching surveyses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SURVEYS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"surveys.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(surveys.uuid IS NULL OR surveys.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"surveys.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByassetId;
	private FinderPath _finderPathWithoutPaginationFindByassetId;
	private FinderPath _finderPathCountByassetId;

	/**
	 * Returns all the surveyses where assetId = &#63;.
	 *
	 * @param assetId the asset ID
	 * @return the matching surveyses
	 */
	@Override
	public List<Surveys> findByassetId(long assetId) {
		return findByassetId(
			assetId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Surveys> findByassetId(long assetId, int start, int end) {
		return findByassetId(assetId, start, end, null);
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
	@Override
	public List<Surveys> findByassetId(
		long assetId, int start, int end,
		OrderByComparator<Surveys> orderByComparator) {

		return findByassetId(assetId, start, end, orderByComparator, true);
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
	@Override
	public List<Surveys> findByassetId(
		long assetId, int start, int end,
		OrderByComparator<Surveys> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByassetId;
				finderArgs = new Object[] {assetId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByassetId;
			finderArgs = new Object[] {assetId, start, end, orderByComparator};
		}

		List<Surveys> list = null;

		if (useFinderCache) {
			list = (List<Surveys>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Surveys surveys : list) {
					if (assetId != surveys.getAssetId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SURVEYS_WHERE);

			sb.append(_FINDER_COLUMN_ASSETID_ASSETID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SurveysModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(assetId);

				list = (List<Surveys>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first surveys in the ordered set where assetId = &#63;.
	 *
	 * @param assetId the asset ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching surveys
	 * @throws NoSuchSurveysException if a matching surveys could not be found
	 */
	@Override
	public Surveys findByassetId_First(
			long assetId, OrderByComparator<Surveys> orderByComparator)
		throws NoSuchSurveysException {

		Surveys surveys = fetchByassetId_First(assetId, orderByComparator);

		if (surveys != null) {
			return surveys;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("assetId=");
		sb.append(assetId);

		sb.append("}");

		throw new NoSuchSurveysException(sb.toString());
	}

	/**
	 * Returns the first surveys in the ordered set where assetId = &#63;.
	 *
	 * @param assetId the asset ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	@Override
	public Surveys fetchByassetId_First(
		long assetId, OrderByComparator<Surveys> orderByComparator) {

		List<Surveys> list = findByassetId(assetId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last surveys in the ordered set where assetId = &#63;.
	 *
	 * @param assetId the asset ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching surveys
	 * @throws NoSuchSurveysException if a matching surveys could not be found
	 */
	@Override
	public Surveys findByassetId_Last(
			long assetId, OrderByComparator<Surveys> orderByComparator)
		throws NoSuchSurveysException {

		Surveys surveys = fetchByassetId_Last(assetId, orderByComparator);

		if (surveys != null) {
			return surveys;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("assetId=");
		sb.append(assetId);

		sb.append("}");

		throw new NoSuchSurveysException(sb.toString());
	}

	/**
	 * Returns the last surveys in the ordered set where assetId = &#63;.
	 *
	 * @param assetId the asset ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	@Override
	public Surveys fetchByassetId_Last(
		long assetId, OrderByComparator<Surveys> orderByComparator) {

		int count = countByassetId(assetId);

		if (count == 0) {
			return null;
		}

		List<Surveys> list = findByassetId(
			assetId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Surveys[] findByassetId_PrevAndNext(
			long surveyId, long assetId,
			OrderByComparator<Surveys> orderByComparator)
		throws NoSuchSurveysException {

		Surveys surveys = findByPrimaryKey(surveyId);

		Session session = null;

		try {
			session = openSession();

			Surveys[] array = new SurveysImpl[3];

			array[0] = getByassetId_PrevAndNext(
				session, surveys, assetId, orderByComparator, true);

			array[1] = surveys;

			array[2] = getByassetId_PrevAndNext(
				session, surveys, assetId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Surveys getByassetId_PrevAndNext(
		Session session, Surveys surveys, long assetId,
		OrderByComparator<Surveys> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SURVEYS_WHERE);

		sb.append(_FINDER_COLUMN_ASSETID_ASSETID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SurveysModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(assetId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(surveys)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Surveys> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the surveyses where assetId = &#63; from the database.
	 *
	 * @param assetId the asset ID
	 */
	@Override
	public void removeByassetId(long assetId) {
		for (Surveys surveys :
				findByassetId(
					assetId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(surveys);
		}
	}

	/**
	 * Returns the number of surveyses where assetId = &#63;.
	 *
	 * @param assetId the asset ID
	 * @return the number of matching surveyses
	 */
	@Override
	public int countByassetId(long assetId) {
		FinderPath finderPath = _finderPathCountByassetId;

		Object[] finderArgs = new Object[] {assetId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SURVEYS_WHERE);

			sb.append(_FINDER_COLUMN_ASSETID_ASSETID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(assetId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ASSETID_ASSETID_2 =
		"surveys.assetId = ?";

	private FinderPath _finderPathWithPaginationFindByuserId;
	private FinderPath _finderPathWithoutPaginationFindByuserId;
	private FinderPath _finderPathCountByuserId;

	/**
	 * Returns all the surveyses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching surveyses
	 */
	@Override
	public List<Surveys> findByuserId(long userId) {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Surveys> findByuserId(long userId, int start, int end) {
		return findByuserId(userId, start, end, null);
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
	@Override
	public List<Surveys> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Surveys> orderByComparator) {

		return findByuserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<Surveys> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Surveys> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByuserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByuserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<Surveys> list = null;

		if (useFinderCache) {
			list = (List<Surveys>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Surveys surveys : list) {
					if (userId != surveys.getUserId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SURVEYS_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SurveysModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<Surveys>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first surveys in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching surveys
	 * @throws NoSuchSurveysException if a matching surveys could not be found
	 */
	@Override
	public Surveys findByuserId_First(
			long userId, OrderByComparator<Surveys> orderByComparator)
		throws NoSuchSurveysException {

		Surveys surveys = fetchByuserId_First(userId, orderByComparator);

		if (surveys != null) {
			return surveys;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchSurveysException(sb.toString());
	}

	/**
	 * Returns the first surveys in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	@Override
	public Surveys fetchByuserId_First(
		long userId, OrderByComparator<Surveys> orderByComparator) {

		List<Surveys> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last surveys in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching surveys
	 * @throws NoSuchSurveysException if a matching surveys could not be found
	 */
	@Override
	public Surveys findByuserId_Last(
			long userId, OrderByComparator<Surveys> orderByComparator)
		throws NoSuchSurveysException {

		Surveys surveys = fetchByuserId_Last(userId, orderByComparator);

		if (surveys != null) {
			return surveys;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchSurveysException(sb.toString());
	}

	/**
	 * Returns the last surveys in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching surveys, or <code>null</code> if a matching surveys could not be found
	 */
	@Override
	public Surveys fetchByuserId_Last(
		long userId, OrderByComparator<Surveys> orderByComparator) {

		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<Surveys> list = findByuserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Surveys[] findByuserId_PrevAndNext(
			long surveyId, long userId,
			OrderByComparator<Surveys> orderByComparator)
		throws NoSuchSurveysException {

		Surveys surveys = findByPrimaryKey(surveyId);

		Session session = null;

		try {
			session = openSession();

			Surveys[] array = new SurveysImpl[3];

			array[0] = getByuserId_PrevAndNext(
				session, surveys, userId, orderByComparator, true);

			array[1] = surveys;

			array[2] = getByuserId_PrevAndNext(
				session, surveys, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Surveys getByuserId_PrevAndNext(
		Session session, Surveys surveys, long userId,
		OrderByComparator<Surveys> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SURVEYS_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(SurveysModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(surveys)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Surveys> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the surveyses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByuserId(long userId) {
		for (Surveys surveys :
				findByuserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(surveys);
		}
	}

	/**
	 * Returns the number of surveyses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching surveyses
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = _finderPathCountByuserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SURVEYS_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"surveys.userId = ?";

	public SurveysPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Surveys.class);

		setModelImplClass(SurveysImpl.class);
		setModelPKClass(long.class);

		setTable(SurveysTable.INSTANCE);
	}

	/**
	 * Caches the surveys in the entity cache if it is enabled.
	 *
	 * @param surveys the surveys
	 */
	@Override
	public void cacheResult(Surveys surveys) {
		entityCache.putResult(
			SurveysImpl.class, surveys.getPrimaryKey(), surveys);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {surveys.getUuid(), surveys.getGroupId()}, surveys);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the surveyses in the entity cache if it is enabled.
	 *
	 * @param surveyses the surveyses
	 */
	@Override
	public void cacheResult(List<Surveys> surveyses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (surveyses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Surveys surveys : surveyses) {
			if (entityCache.getResult(
					SurveysImpl.class, surveys.getPrimaryKey()) == null) {

				cacheResult(surveys);
			}
		}
	}

	/**
	 * Clears the cache for all surveyses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SurveysImpl.class);

		finderCache.clearCache(SurveysImpl.class);
	}

	/**
	 * Clears the cache for the surveys.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Surveys surveys) {
		entityCache.removeResult(SurveysImpl.class, surveys);
	}

	@Override
	public void clearCache(List<Surveys> surveyses) {
		for (Surveys surveys : surveyses) {
			entityCache.removeResult(SurveysImpl.class, surveys);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SurveysImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SurveysImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(SurveysModelImpl surveysModelImpl) {
		Object[] args = new Object[] {
			surveysModelImpl.getUuid(), surveysModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByUUID_G, args, surveysModelImpl);
	}

	/**
	 * Creates a new surveys with the primary key. Does not add the surveys to the database.
	 *
	 * @param surveyId the primary key for the new surveys
	 * @return the new surveys
	 */
	@Override
	public Surveys create(long surveyId) {
		Surveys surveys = new SurveysImpl();

		surveys.setNew(true);
		surveys.setPrimaryKey(surveyId);

		String uuid = PortalUUIDUtil.generate();

		surveys.setUuid(uuid);

		return surveys;
	}

	/**
	 * Removes the surveys with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surveyId the primary key of the surveys
	 * @return the surveys that was removed
	 * @throws NoSuchSurveysException if a surveys with the primary key could not be found
	 */
	@Override
	public Surveys remove(long surveyId) throws NoSuchSurveysException {
		return remove((Serializable)surveyId);
	}

	/**
	 * Removes the surveys with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the surveys
	 * @return the surveys that was removed
	 * @throws NoSuchSurveysException if a surveys with the primary key could not be found
	 */
	@Override
	public Surveys remove(Serializable primaryKey)
		throws NoSuchSurveysException {

		Session session = null;

		try {
			session = openSession();

			Surveys surveys = (Surveys)session.get(
				SurveysImpl.class, primaryKey);

			if (surveys == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSurveysException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(surveys);
		}
		catch (NoSuchSurveysException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Surveys removeImpl(Surveys surveys) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(surveys)) {
				surveys = (Surveys)session.get(
					SurveysImpl.class, surveys.getPrimaryKeyObj());
			}

			if (surveys != null) {
				session.delete(surveys);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (surveys != null) {
			clearCache(surveys);
		}

		return surveys;
	}

	@Override
	public Surveys updateImpl(Surveys surveys) {
		boolean isNew = surveys.isNew();

		if (!(surveys instanceof SurveysModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(surveys.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(surveys);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in surveys proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Surveys implementation " +
					surveys.getClass());
		}

		SurveysModelImpl surveysModelImpl = (SurveysModelImpl)surveys;

		if (Validator.isNull(surveys.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			surveys.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (surveys.getCreateDate() == null)) {
			if (serviceContext == null) {
				surveys.setCreateDate(date);
			}
			else {
				surveys.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!surveysModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				surveys.setModifiedDate(date);
			}
			else {
				surveys.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(surveys);
			}
			else {
				surveys = (Surveys)session.merge(surveys);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(SurveysImpl.class, surveysModelImpl, false, true);

		cacheUniqueFindersCache(surveysModelImpl);

		if (isNew) {
			surveys.setNew(false);
		}

		surveys.resetOriginalValues();

		return surveys;
	}

	/**
	 * Returns the surveys with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the surveys
	 * @return the surveys
	 * @throws NoSuchSurveysException if a surveys with the primary key could not be found
	 */
	@Override
	public Surveys findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSurveysException {

		Surveys surveys = fetchByPrimaryKey(primaryKey);

		if (surveys == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSurveysException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return surveys;
	}

	/**
	 * Returns the surveys with the primary key or throws a <code>NoSuchSurveysException</code> if it could not be found.
	 *
	 * @param surveyId the primary key of the surveys
	 * @return the surveys
	 * @throws NoSuchSurveysException if a surveys with the primary key could not be found
	 */
	@Override
	public Surveys findByPrimaryKey(long surveyId)
		throws NoSuchSurveysException {

		return findByPrimaryKey((Serializable)surveyId);
	}

	/**
	 * Returns the surveys with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param surveyId the primary key of the surveys
	 * @return the surveys, or <code>null</code> if a surveys with the primary key could not be found
	 */
	@Override
	public Surveys fetchByPrimaryKey(long surveyId) {
		return fetchByPrimaryKey((Serializable)surveyId);
	}

	/**
	 * Returns all the surveyses.
	 *
	 * @return the surveyses
	 */
	@Override
	public List<Surveys> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Surveys> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Surveys> findAll(
		int start, int end, OrderByComparator<Surveys> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Surveys> findAll(
		int start, int end, OrderByComparator<Surveys> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Surveys> list = null;

		if (useFinderCache) {
			list = (List<Surveys>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SURVEYS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SURVEYS;

				sql = sql.concat(SurveysModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Surveys>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the surveyses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Surveys surveys : findAll()) {
			remove(surveys);
		}
	}

	/**
	 * Returns the number of surveyses.
	 *
	 * @return the number of surveyses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SURVEYS);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "surveyId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SURVEYS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SurveysModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the surveys persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByassetId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByassetId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"assetId"}, true);

		_finderPathWithoutPaginationFindByassetId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByassetId",
			new String[] {Long.class.getName()}, new String[] {"assetId"},
			true);

		_finderPathCountByassetId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByassetId",
			new String[] {Long.class.getName()}, new String[] {"assetId"},
			false);

		_finderPathWithPaginationFindByuserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByuserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByuserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		SurveysUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		SurveysUtil.setPersistence(null);

		entityCache.removeCache(SurveysImpl.class.getName());
	}

	@Override
	@Reference(
		target = AVANIS_COMUNIDADPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = AVANIS_COMUNIDADPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AVANIS_COMUNIDADPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SURVEYS =
		"SELECT surveys FROM Surveys surveys";

	private static final String _SQL_SELECT_SURVEYS_WHERE =
		"SELECT surveys FROM Surveys surveys WHERE ";

	private static final String _SQL_COUNT_SURVEYS =
		"SELECT COUNT(surveys) FROM Surveys surveys";

	private static final String _SQL_COUNT_SURVEYS_WHERE =
		"SELECT COUNT(surveys) FROM Surveys surveys WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "surveys.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Surveys exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Surveys exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SurveysPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}