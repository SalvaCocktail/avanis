/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.eventos.follow.sb.service.persistence.impl;

import avanis.eventos.follow.sb.exception.NoSuchEventFollowException;
import avanis.eventos.follow.sb.model.EventFollow;
import avanis.eventos.follow.sb.model.EventFollowTable;
import avanis.eventos.follow.sb.model.impl.EventFollowImpl;
import avanis.eventos.follow.sb.model.impl.EventFollowModelImpl;
import avanis.eventos.follow.sb.service.persistence.EventFollowPersistence;
import avanis.eventos.follow.sb.service.persistence.EventFollowUtil;
import avanis.eventos.follow.sb.service.persistence.impl.constants.EVENT_FOLLOWPersistenceConstants;

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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the event follow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EventFollowPersistence.class)
public class EventFollowPersistenceImpl
	extends BasePersistenceImpl<EventFollow> implements EventFollowPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EventFollowUtil</code> to access the event follow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EventFollowImpl.class.getName();

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
	 * Returns all the event follows where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching event follows
	 */
	@Override
	public List<EventFollow> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event follows where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @return the range of matching event follows
	 */
	@Override
	public List<EventFollow> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the event follows where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event follows
	 */
	@Override
	public List<EventFollow> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventFollow> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the event follows where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event follows
	 */
	@Override
	public List<EventFollow> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventFollow> orderByComparator,
		boolean useFinderCache) {

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

		List<EventFollow> list = null;

		if (useFinderCache) {
			list = (List<EventFollow>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EventFollow eventFollow : list) {
					if (!uuid.equals(eventFollow.getUuid())) {
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

			sb.append(_SQL_SELECT_EVENTFOLLOW_WHERE);

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
				sb.append(EventFollowModelImpl.ORDER_BY_JPQL);
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

				list = (List<EventFollow>)QueryUtil.list(
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
	 * Returns the first event follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	@Override
	public EventFollow findByUuid_First(
			String uuid, OrderByComparator<EventFollow> orderByComparator)
		throws NoSuchEventFollowException {

		EventFollow eventFollow = fetchByUuid_First(uuid, orderByComparator);

		if (eventFollow != null) {
			return eventFollow;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEventFollowException(sb.toString());
	}

	/**
	 * Returns the first event follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	@Override
	public EventFollow fetchByUuid_First(
		String uuid, OrderByComparator<EventFollow> orderByComparator) {

		List<EventFollow> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	@Override
	public EventFollow findByUuid_Last(
			String uuid, OrderByComparator<EventFollow> orderByComparator)
		throws NoSuchEventFollowException {

		EventFollow eventFollow = fetchByUuid_Last(uuid, orderByComparator);

		if (eventFollow != null) {
			return eventFollow;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEventFollowException(sb.toString());
	}

	/**
	 * Returns the last event follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	@Override
	public EventFollow fetchByUuid_Last(
		String uuid, OrderByComparator<EventFollow> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EventFollow> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the event follows before and after the current event follow in the ordered set where uuid = &#63;.
	 *
	 * @param eventFollowId the primary key of the current event follow
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event follow
	 * @throws NoSuchEventFollowException if a event follow with the primary key could not be found
	 */
	@Override
	public EventFollow[] findByUuid_PrevAndNext(
			long eventFollowId, String uuid,
			OrderByComparator<EventFollow> orderByComparator)
		throws NoSuchEventFollowException {

		uuid = Objects.toString(uuid, "");

		EventFollow eventFollow = findByPrimaryKey(eventFollowId);

		Session session = null;

		try {
			session = openSession();

			EventFollow[] array = new EventFollowImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, eventFollow, uuid, orderByComparator, true);

			array[1] = eventFollow;

			array[2] = getByUuid_PrevAndNext(
				session, eventFollow, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventFollow getByUuid_PrevAndNext(
		Session session, EventFollow eventFollow, String uuid,
		OrderByComparator<EventFollow> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EVENTFOLLOW_WHERE);

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
			sb.append(EventFollowModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(eventFollow)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EventFollow> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the event follows where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EventFollow eventFollow :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(eventFollow);
		}
	}

	/**
	 * Returns the number of event follows where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching event follows
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EVENTFOLLOW_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"eventFollow.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(eventFollow.uuid IS NULL OR eventFollow.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the event follow where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEventFollowException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	@Override
	public EventFollow findByUUID_G(String uuid, long groupId)
		throws NoSuchEventFollowException {

		EventFollow eventFollow = fetchByUUID_G(uuid, groupId);

		if (eventFollow == null) {
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

			throw new NoSuchEventFollowException(sb.toString());
		}

		return eventFollow;
	}

	/**
	 * Returns the event follow where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	@Override
	public EventFollow fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the event follow where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	@Override
	public EventFollow fetchByUUID_G(
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

		if (result instanceof EventFollow) {
			EventFollow eventFollow = (EventFollow)result;

			if (!Objects.equals(uuid, eventFollow.getUuid()) ||
				(groupId != eventFollow.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EVENTFOLLOW_WHERE);

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

				List<EventFollow> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					EventFollow eventFollow = list.get(0);

					result = eventFollow;

					cacheResult(eventFollow);
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
			return (EventFollow)result;
		}
	}

	/**
	 * Removes the event follow where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the event follow that was removed
	 */
	@Override
	public EventFollow removeByUUID_G(String uuid, long groupId)
		throws NoSuchEventFollowException {

		EventFollow eventFollow = findByUUID_G(uuid, groupId);

		return remove(eventFollow);
	}

	/**
	 * Returns the number of event follows where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching event follows
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EVENTFOLLOW_WHERE);

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
		"eventFollow.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(eventFollow.uuid IS NULL OR eventFollow.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"eventFollow.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the event follows where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching event follows
	 */
	@Override
	public List<EventFollow> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event follows where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @return the range of matching event follows
	 */
	@Override
	public List<EventFollow> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the event follows where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event follows
	 */
	@Override
	public List<EventFollow> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EventFollow> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the event follows where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event follows
	 */
	@Override
	public List<EventFollow> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EventFollow> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<EventFollow> list = null;

		if (useFinderCache) {
			list = (List<EventFollow>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EventFollow eventFollow : list) {
					if (!uuid.equals(eventFollow.getUuid()) ||
						(companyId != eventFollow.getCompanyId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_EVENTFOLLOW_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EventFollowModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(companyId);

				list = (List<EventFollow>)QueryUtil.list(
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
	 * Returns the first event follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	@Override
	public EventFollow findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<EventFollow> orderByComparator)
		throws NoSuchEventFollowException {

		EventFollow eventFollow = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (eventFollow != null) {
			return eventFollow;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEventFollowException(sb.toString());
	}

	/**
	 * Returns the first event follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	@Override
	public EventFollow fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<EventFollow> orderByComparator) {

		List<EventFollow> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	@Override
	public EventFollow findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<EventFollow> orderByComparator)
		throws NoSuchEventFollowException {

		EventFollow eventFollow = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (eventFollow != null) {
			return eventFollow;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchEventFollowException(sb.toString());
	}

	/**
	 * Returns the last event follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	@Override
	public EventFollow fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<EventFollow> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EventFollow> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the event follows before and after the current event follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param eventFollowId the primary key of the current event follow
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event follow
	 * @throws NoSuchEventFollowException if a event follow with the primary key could not be found
	 */
	@Override
	public EventFollow[] findByUuid_C_PrevAndNext(
			long eventFollowId, String uuid, long companyId,
			OrderByComparator<EventFollow> orderByComparator)
		throws NoSuchEventFollowException {

		uuid = Objects.toString(uuid, "");

		EventFollow eventFollow = findByPrimaryKey(eventFollowId);

		Session session = null;

		try {
			session = openSession();

			EventFollow[] array = new EventFollowImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, eventFollow, uuid, companyId, orderByComparator, true);

			array[1] = eventFollow;

			array[2] = getByUuid_C_PrevAndNext(
				session, eventFollow, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventFollow getByUuid_C_PrevAndNext(
		Session session, EventFollow eventFollow, String uuid, long companyId,
		OrderByComparator<EventFollow> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_EVENTFOLLOW_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(EventFollowModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(eventFollow)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EventFollow> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the event follows where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EventFollow eventFollow :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(eventFollow);
		}
	}

	/**
	 * Returns the number of event follows where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching event follows
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EVENTFOLLOW_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"eventFollow.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(eventFollow.uuid IS NULL OR eventFollow.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"eventFollow.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBygetEvents;
	private FinderPath _finderPathWithoutPaginationFindBygetEvents;
	private FinderPath _finderPathCountBygetEvents;

	/**
	 * Returns all the event follows where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching event follows
	 */
	@Override
	public List<EventFollow> findBygetEvents(long userId) {
		return findBygetEvents(
			userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event follows where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @return the range of matching event follows
	 */
	@Override
	public List<EventFollow> findBygetEvents(long userId, int start, int end) {
		return findBygetEvents(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the event follows where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event follows
	 */
	@Override
	public List<EventFollow> findBygetEvents(
		long userId, int start, int end,
		OrderByComparator<EventFollow> orderByComparator) {

		return findBygetEvents(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the event follows where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event follows
	 */
	@Override
	public List<EventFollow> findBygetEvents(
		long userId, int start, int end,
		OrderByComparator<EventFollow> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBygetEvents;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBygetEvents;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<EventFollow> list = null;

		if (useFinderCache) {
			list = (List<EventFollow>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EventFollow eventFollow : list) {
					if (userId != eventFollow.getUserId()) {
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

			sb.append(_SQL_SELECT_EVENTFOLLOW_WHERE);

			sb.append(_FINDER_COLUMN_GETEVENTS_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EventFollowModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<EventFollow>)QueryUtil.list(
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
	 * Returns the first event follow in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	@Override
	public EventFollow findBygetEvents_First(
			long userId, OrderByComparator<EventFollow> orderByComparator)
		throws NoSuchEventFollowException {

		EventFollow eventFollow = fetchBygetEvents_First(
			userId, orderByComparator);

		if (eventFollow != null) {
			return eventFollow;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchEventFollowException(sb.toString());
	}

	/**
	 * Returns the first event follow in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	@Override
	public EventFollow fetchBygetEvents_First(
		long userId, OrderByComparator<EventFollow> orderByComparator) {

		List<EventFollow> list = findBygetEvents(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event follow in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	@Override
	public EventFollow findBygetEvents_Last(
			long userId, OrderByComparator<EventFollow> orderByComparator)
		throws NoSuchEventFollowException {

		EventFollow eventFollow = fetchBygetEvents_Last(
			userId, orderByComparator);

		if (eventFollow != null) {
			return eventFollow;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchEventFollowException(sb.toString());
	}

	/**
	 * Returns the last event follow in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	@Override
	public EventFollow fetchBygetEvents_Last(
		long userId, OrderByComparator<EventFollow> orderByComparator) {

		int count = countBygetEvents(userId);

		if (count == 0) {
			return null;
		}

		List<EventFollow> list = findBygetEvents(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the event follows before and after the current event follow in the ordered set where userId = &#63;.
	 *
	 * @param eventFollowId the primary key of the current event follow
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event follow
	 * @throws NoSuchEventFollowException if a event follow with the primary key could not be found
	 */
	@Override
	public EventFollow[] findBygetEvents_PrevAndNext(
			long eventFollowId, long userId,
			OrderByComparator<EventFollow> orderByComparator)
		throws NoSuchEventFollowException {

		EventFollow eventFollow = findByPrimaryKey(eventFollowId);

		Session session = null;

		try {
			session = openSession();

			EventFollow[] array = new EventFollowImpl[3];

			array[0] = getBygetEvents_PrevAndNext(
				session, eventFollow, userId, orderByComparator, true);

			array[1] = eventFollow;

			array[2] = getBygetEvents_PrevAndNext(
				session, eventFollow, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventFollow getBygetEvents_PrevAndNext(
		Session session, EventFollow eventFollow, long userId,
		OrderByComparator<EventFollow> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EVENTFOLLOW_WHERE);

		sb.append(_FINDER_COLUMN_GETEVENTS_USERID_2);

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
			sb.append(EventFollowModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(eventFollow)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EventFollow> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the event follows where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeBygetEvents(long userId) {
		for (EventFollow eventFollow :
				findBygetEvents(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(eventFollow);
		}
	}

	/**
	 * Returns the number of event follows where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching event follows
	 */
	@Override
	public int countBygetEvents(long userId) {
		FinderPath finderPath = _finderPathCountBygetEvents;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EVENTFOLLOW_WHERE);

			sb.append(_FINDER_COLUMN_GETEVENTS_USERID_2);

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

	private static final String _FINDER_COLUMN_GETEVENTS_USERID_2 =
		"eventFollow.userId = ?";

	private FinderPath _finderPathWithPaginationFindBygetUsers;
	private FinderPath _finderPathWithoutPaginationFindBygetUsers;
	private FinderPath _finderPathCountBygetUsers;

	/**
	 * Returns all the event follows where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the matching event follows
	 */
	@Override
	public List<EventFollow> findBygetUsers(long eventId) {
		return findBygetUsers(
			eventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event follows where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @return the range of matching event follows
	 */
	@Override
	public List<EventFollow> findBygetUsers(long eventId, int start, int end) {
		return findBygetUsers(eventId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the event follows where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event follows
	 */
	@Override
	public List<EventFollow> findBygetUsers(
		long eventId, int start, int end,
		OrderByComparator<EventFollow> orderByComparator) {

		return findBygetUsers(eventId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the event follows where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event follows
	 */
	@Override
	public List<EventFollow> findBygetUsers(
		long eventId, int start, int end,
		OrderByComparator<EventFollow> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBygetUsers;
				finderArgs = new Object[] {eventId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBygetUsers;
			finderArgs = new Object[] {eventId, start, end, orderByComparator};
		}

		List<EventFollow> list = null;

		if (useFinderCache) {
			list = (List<EventFollow>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EventFollow eventFollow : list) {
					if (eventId != eventFollow.getEventId()) {
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

			sb.append(_SQL_SELECT_EVENTFOLLOW_WHERE);

			sb.append(_FINDER_COLUMN_GETUSERS_EVENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EventFollowModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(eventId);

				list = (List<EventFollow>)QueryUtil.list(
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
	 * Returns the first event follow in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	@Override
	public EventFollow findBygetUsers_First(
			long eventId, OrderByComparator<EventFollow> orderByComparator)
		throws NoSuchEventFollowException {

		EventFollow eventFollow = fetchBygetUsers_First(
			eventId, orderByComparator);

		if (eventFollow != null) {
			return eventFollow;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("eventId=");
		sb.append(eventId);

		sb.append("}");

		throw new NoSuchEventFollowException(sb.toString());
	}

	/**
	 * Returns the first event follow in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	@Override
	public EventFollow fetchBygetUsers_First(
		long eventId, OrderByComparator<EventFollow> orderByComparator) {

		List<EventFollow> list = findBygetUsers(
			eventId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event follow in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	@Override
	public EventFollow findBygetUsers_Last(
			long eventId, OrderByComparator<EventFollow> orderByComparator)
		throws NoSuchEventFollowException {

		EventFollow eventFollow = fetchBygetUsers_Last(
			eventId, orderByComparator);

		if (eventFollow != null) {
			return eventFollow;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("eventId=");
		sb.append(eventId);

		sb.append("}");

		throw new NoSuchEventFollowException(sb.toString());
	}

	/**
	 * Returns the last event follow in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	@Override
	public EventFollow fetchBygetUsers_Last(
		long eventId, OrderByComparator<EventFollow> orderByComparator) {

		int count = countBygetUsers(eventId);

		if (count == 0) {
			return null;
		}

		List<EventFollow> list = findBygetUsers(
			eventId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the event follows before and after the current event follow in the ordered set where eventId = &#63;.
	 *
	 * @param eventFollowId the primary key of the current event follow
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event follow
	 * @throws NoSuchEventFollowException if a event follow with the primary key could not be found
	 */
	@Override
	public EventFollow[] findBygetUsers_PrevAndNext(
			long eventFollowId, long eventId,
			OrderByComparator<EventFollow> orderByComparator)
		throws NoSuchEventFollowException {

		EventFollow eventFollow = findByPrimaryKey(eventFollowId);

		Session session = null;

		try {
			session = openSession();

			EventFollow[] array = new EventFollowImpl[3];

			array[0] = getBygetUsers_PrevAndNext(
				session, eventFollow, eventId, orderByComparator, true);

			array[1] = eventFollow;

			array[2] = getBygetUsers_PrevAndNext(
				session, eventFollow, eventId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventFollow getBygetUsers_PrevAndNext(
		Session session, EventFollow eventFollow, long eventId,
		OrderByComparator<EventFollow> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EVENTFOLLOW_WHERE);

		sb.append(_FINDER_COLUMN_GETUSERS_EVENTID_2);

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
			sb.append(EventFollowModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(eventId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(eventFollow)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EventFollow> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the event follows where eventId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 */
	@Override
	public void removeBygetUsers(long eventId) {
		for (EventFollow eventFollow :
				findBygetUsers(
					eventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(eventFollow);
		}
	}

	/**
	 * Returns the number of event follows where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the number of matching event follows
	 */
	@Override
	public int countBygetUsers(long eventId) {
		FinderPath finderPath = _finderPathCountBygetUsers;

		Object[] finderArgs = new Object[] {eventId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EVENTFOLLOW_WHERE);

			sb.append(_FINDER_COLUMN_GETUSERS_EVENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(eventId);

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

	private static final String _FINDER_COLUMN_GETUSERS_EVENTID_2 =
		"eventFollow.eventId = ?";

	private FinderPath _finderPathFetchBygetFollow;
	private FinderPath _finderPathCountBygetFollow;

	/**
	 * Returns the event follow where eventId = &#63; and userId = &#63; or throws a <code>NoSuchEventFollowException</code> if it could not be found.
	 *
	 * @param eventId the event ID
	 * @param userId the user ID
	 * @return the matching event follow
	 * @throws NoSuchEventFollowException if a matching event follow could not be found
	 */
	@Override
	public EventFollow findBygetFollow(long eventId, long userId)
		throws NoSuchEventFollowException {

		EventFollow eventFollow = fetchBygetFollow(eventId, userId);

		if (eventFollow == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("eventId=");
			sb.append(eventId);

			sb.append(", userId=");
			sb.append(userId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEventFollowException(sb.toString());
		}

		return eventFollow;
	}

	/**
	 * Returns the event follow where eventId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param eventId the event ID
	 * @param userId the user ID
	 * @return the matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	@Override
	public EventFollow fetchBygetFollow(long eventId, long userId) {
		return fetchBygetFollow(eventId, userId, true);
	}

	/**
	 * Returns the event follow where eventId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param eventId the event ID
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching event follow, or <code>null</code> if a matching event follow could not be found
	 */
	@Override
	public EventFollow fetchBygetFollow(
		long eventId, long userId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {eventId, userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBygetFollow, finderArgs, this);
		}

		if (result instanceof EventFollow) {
			EventFollow eventFollow = (EventFollow)result;

			if ((eventId != eventFollow.getEventId()) ||
				(userId != eventFollow.getUserId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EVENTFOLLOW_WHERE);

			sb.append(_FINDER_COLUMN_GETFOLLOW_EVENTID_2);

			sb.append(_FINDER_COLUMN_GETFOLLOW_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(eventId);

				queryPos.add(userId);

				List<EventFollow> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBygetFollow, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {eventId, userId};
							}

							_log.warn(
								"EventFollowPersistenceImpl.fetchBygetFollow(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EventFollow eventFollow = list.get(0);

					result = eventFollow;

					cacheResult(eventFollow);
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
			return (EventFollow)result;
		}
	}

	/**
	 * Removes the event follow where eventId = &#63; and userId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 * @param userId the user ID
	 * @return the event follow that was removed
	 */
	@Override
	public EventFollow removeBygetFollow(long eventId, long userId)
		throws NoSuchEventFollowException {

		EventFollow eventFollow = findBygetFollow(eventId, userId);

		return remove(eventFollow);
	}

	/**
	 * Returns the number of event follows where eventId = &#63; and userId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param userId the user ID
	 * @return the number of matching event follows
	 */
	@Override
	public int countBygetFollow(long eventId, long userId) {
		FinderPath finderPath = _finderPathCountBygetFollow;

		Object[] finderArgs = new Object[] {eventId, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EVENTFOLLOW_WHERE);

			sb.append(_FINDER_COLUMN_GETFOLLOW_EVENTID_2);

			sb.append(_FINDER_COLUMN_GETFOLLOW_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(eventId);

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

	private static final String _FINDER_COLUMN_GETFOLLOW_EVENTID_2 =
		"eventFollow.eventId = ? AND ";

	private static final String _FINDER_COLUMN_GETFOLLOW_USERID_2 =
		"eventFollow.userId = ?";

	public EventFollowPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EventFollow.class);

		setModelImplClass(EventFollowImpl.class);
		setModelPKClass(long.class);

		setTable(EventFollowTable.INSTANCE);
	}

	/**
	 * Caches the event follow in the entity cache if it is enabled.
	 *
	 * @param eventFollow the event follow
	 */
	@Override
	public void cacheResult(EventFollow eventFollow) {
		entityCache.putResult(
			EventFollowImpl.class, eventFollow.getPrimaryKey(), eventFollow);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {eventFollow.getUuid(), eventFollow.getGroupId()},
			eventFollow);

		finderCache.putResult(
			_finderPathFetchBygetFollow,
			new Object[] {eventFollow.getEventId(), eventFollow.getUserId()},
			eventFollow);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the event follows in the entity cache if it is enabled.
	 *
	 * @param eventFollows the event follows
	 */
	@Override
	public void cacheResult(List<EventFollow> eventFollows) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (eventFollows.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EventFollow eventFollow : eventFollows) {
			if (entityCache.getResult(
					EventFollowImpl.class, eventFollow.getPrimaryKey()) ==
						null) {

				cacheResult(eventFollow);
			}
		}
	}

	/**
	 * Clears the cache for all event follows.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EventFollowImpl.class);

		finderCache.clearCache(EventFollowImpl.class);
	}

	/**
	 * Clears the cache for the event follow.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EventFollow eventFollow) {
		entityCache.removeResult(EventFollowImpl.class, eventFollow);
	}

	@Override
	public void clearCache(List<EventFollow> eventFollows) {
		for (EventFollow eventFollow : eventFollows) {
			entityCache.removeResult(EventFollowImpl.class, eventFollow);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EventFollowImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EventFollowImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EventFollowModelImpl eventFollowModelImpl) {

		Object[] args = new Object[] {
			eventFollowModelImpl.getUuid(), eventFollowModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, eventFollowModelImpl);

		args = new Object[] {
			eventFollowModelImpl.getEventId(), eventFollowModelImpl.getUserId()
		};

		finderCache.putResult(
			_finderPathCountBygetFollow, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBygetFollow, args, eventFollowModelImpl);
	}

	/**
	 * Creates a new event follow with the primary key. Does not add the event follow to the database.
	 *
	 * @param eventFollowId the primary key for the new event follow
	 * @return the new event follow
	 */
	@Override
	public EventFollow create(long eventFollowId) {
		EventFollow eventFollow = new EventFollowImpl();

		eventFollow.setNew(true);
		eventFollow.setPrimaryKey(eventFollowId);

		String uuid = PortalUUIDUtil.generate();

		eventFollow.setUuid(uuid);

		eventFollow.setCompanyId(CompanyThreadLocal.getCompanyId());

		return eventFollow;
	}

	/**
	 * Removes the event follow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventFollowId the primary key of the event follow
	 * @return the event follow that was removed
	 * @throws NoSuchEventFollowException if a event follow with the primary key could not be found
	 */
	@Override
	public EventFollow remove(long eventFollowId)
		throws NoSuchEventFollowException {

		return remove((Serializable)eventFollowId);
	}

	/**
	 * Removes the event follow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the event follow
	 * @return the event follow that was removed
	 * @throws NoSuchEventFollowException if a event follow with the primary key could not be found
	 */
	@Override
	public EventFollow remove(Serializable primaryKey)
		throws NoSuchEventFollowException {

		Session session = null;

		try {
			session = openSession();

			EventFollow eventFollow = (EventFollow)session.get(
				EventFollowImpl.class, primaryKey);

			if (eventFollow == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventFollowException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(eventFollow);
		}
		catch (NoSuchEventFollowException noSuchEntityException) {
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
	protected EventFollow removeImpl(EventFollow eventFollow) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eventFollow)) {
				eventFollow = (EventFollow)session.get(
					EventFollowImpl.class, eventFollow.getPrimaryKeyObj());
			}

			if (eventFollow != null) {
				session.delete(eventFollow);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (eventFollow != null) {
			clearCache(eventFollow);
		}

		return eventFollow;
	}

	@Override
	public EventFollow updateImpl(EventFollow eventFollow) {
		boolean isNew = eventFollow.isNew();

		if (!(eventFollow instanceof EventFollowModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(eventFollow.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(eventFollow);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in eventFollow proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EventFollow implementation " +
					eventFollow.getClass());
		}

		EventFollowModelImpl eventFollowModelImpl =
			(EventFollowModelImpl)eventFollow;

		if (Validator.isNull(eventFollow.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			eventFollow.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (eventFollow.getCreateDate() == null)) {
			if (serviceContext == null) {
				eventFollow.setCreateDate(date);
			}
			else {
				eventFollow.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!eventFollowModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				eventFollow.setModifiedDate(date);
			}
			else {
				eventFollow.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(eventFollow);
			}
			else {
				eventFollow = (EventFollow)session.merge(eventFollow);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EventFollowImpl.class, eventFollowModelImpl, false, true);

		cacheUniqueFindersCache(eventFollowModelImpl);

		if (isNew) {
			eventFollow.setNew(false);
		}

		eventFollow.resetOriginalValues();

		return eventFollow;
	}

	/**
	 * Returns the event follow with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the event follow
	 * @return the event follow
	 * @throws NoSuchEventFollowException if a event follow with the primary key could not be found
	 */
	@Override
	public EventFollow findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventFollowException {

		EventFollow eventFollow = fetchByPrimaryKey(primaryKey);

		if (eventFollow == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventFollowException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return eventFollow;
	}

	/**
	 * Returns the event follow with the primary key or throws a <code>NoSuchEventFollowException</code> if it could not be found.
	 *
	 * @param eventFollowId the primary key of the event follow
	 * @return the event follow
	 * @throws NoSuchEventFollowException if a event follow with the primary key could not be found
	 */
	@Override
	public EventFollow findByPrimaryKey(long eventFollowId)
		throws NoSuchEventFollowException {

		return findByPrimaryKey((Serializable)eventFollowId);
	}

	/**
	 * Returns the event follow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventFollowId the primary key of the event follow
	 * @return the event follow, or <code>null</code> if a event follow with the primary key could not be found
	 */
	@Override
	public EventFollow fetchByPrimaryKey(long eventFollowId) {
		return fetchByPrimaryKey((Serializable)eventFollowId);
	}

	/**
	 * Returns all the event follows.
	 *
	 * @return the event follows
	 */
	@Override
	public List<EventFollow> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event follows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @return the range of event follows
	 */
	@Override
	public List<EventFollow> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the event follows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event follows
	 */
	@Override
	public List<EventFollow> findAll(
		int start, int end, OrderByComparator<EventFollow> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the event follows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventFollowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event follows
	 * @param end the upper bound of the range of event follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of event follows
	 */
	@Override
	public List<EventFollow> findAll(
		int start, int end, OrderByComparator<EventFollow> orderByComparator,
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

		List<EventFollow> list = null;

		if (useFinderCache) {
			list = (List<EventFollow>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EVENTFOLLOW);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EVENTFOLLOW;

				sql = sql.concat(EventFollowModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EventFollow>)QueryUtil.list(
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
	 * Removes all the event follows from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EventFollow eventFollow : findAll()) {
			remove(eventFollow);
		}
	}

	/**
	 * Returns the number of event follows.
	 *
	 * @return the number of event follows
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EVENTFOLLOW);

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
		return "eventFollowId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EVENTFOLLOW;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EventFollowModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the event follow persistence.
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

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindBygetEvents = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBygetEvents",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindBygetEvents = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBygetEvents",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountBygetEvents = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygetEvents",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_finderPathWithPaginationFindBygetUsers = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBygetUsers",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"eventId"}, true);

		_finderPathWithoutPaginationFindBygetUsers = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBygetUsers",
			new String[] {Long.class.getName()}, new String[] {"eventId"},
			true);

		_finderPathCountBygetUsers = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygetUsers",
			new String[] {Long.class.getName()}, new String[] {"eventId"},
			false);

		_finderPathFetchBygetFollow = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBygetFollow",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"eventId", "userId"}, true);

		_finderPathCountBygetFollow = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygetFollow",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"eventId", "userId"}, false);

		EventFollowUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		EventFollowUtil.setPersistence(null);

		entityCache.removeCache(EventFollowImpl.class.getName());
	}

	@Override
	@Reference(
		target = EVENT_FOLLOWPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = EVENT_FOLLOWPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = EVENT_FOLLOWPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_EVENTFOLLOW =
		"SELECT eventFollow FROM EventFollow eventFollow";

	private static final String _SQL_SELECT_EVENTFOLLOW_WHERE =
		"SELECT eventFollow FROM EventFollow eventFollow WHERE ";

	private static final String _SQL_COUNT_EVENTFOLLOW =
		"SELECT COUNT(eventFollow) FROM EventFollow eventFollow";

	private static final String _SQL_COUNT_EVENTFOLLOW_WHERE =
		"SELECT COUNT(eventFollow) FROM EventFollow eventFollow WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "eventFollow.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EventFollow exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EventFollow exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EventFollowPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}