/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.social.follow.sb.service.persistence.impl;

import avanis.social.follow.sb.exception.NoSuchSocialFollowException;
import avanis.social.follow.sb.model.SocialFollow;
import avanis.social.follow.sb.model.SocialFollowTable;
import avanis.social.follow.sb.model.impl.SocialFollowImpl;
import avanis.social.follow.sb.model.impl.SocialFollowModelImpl;
import avanis.social.follow.sb.service.persistence.SocialFollowPersistence;
import avanis.social.follow.sb.service.persistence.SocialFollowUtil;
import avanis.social.follow.sb.service.persistence.impl.constants.SOCIAL_FOLLOWPersistenceConstants;

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
 * The persistence implementation for the social follow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SocialFollowPersistence.class)
public class SocialFollowPersistenceImpl
	extends BasePersistenceImpl<SocialFollow>
	implements SocialFollowPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SocialFollowUtil</code> to access the social follow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SocialFollowImpl.class.getName();

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
	 * Returns all the social follows where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching social follows
	 */
	@Override
	public List<SocialFollow> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social follows where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @return the range of matching social follows
	 */
	@Override
	public List<SocialFollow> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the social follows where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social follows
	 */
	@Override
	public List<SocialFollow> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SocialFollow> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the social follows where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching social follows
	 */
	@Override
	public List<SocialFollow> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SocialFollow> orderByComparator,
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

		List<SocialFollow> list = null;

		if (useFinderCache) {
			list = (List<SocialFollow>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SocialFollow socialFollow : list) {
					if (!uuid.equals(socialFollow.getUuid())) {
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

			sb.append(_SQL_SELECT_SOCIALFOLLOW_WHERE);

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
				sb.append(SocialFollowModelImpl.ORDER_BY_JPQL);
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

				list = (List<SocialFollow>)QueryUtil.list(
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
	 * Returns the first social follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	@Override
	public SocialFollow findByUuid_First(
			String uuid, OrderByComparator<SocialFollow> orderByComparator)
		throws NoSuchSocialFollowException {

		SocialFollow socialFollow = fetchByUuid_First(uuid, orderByComparator);

		if (socialFollow != null) {
			return socialFollow;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSocialFollowException(sb.toString());
	}

	/**
	 * Returns the first social follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	@Override
	public SocialFollow fetchByUuid_First(
		String uuid, OrderByComparator<SocialFollow> orderByComparator) {

		List<SocialFollow> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	@Override
	public SocialFollow findByUuid_Last(
			String uuid, OrderByComparator<SocialFollow> orderByComparator)
		throws NoSuchSocialFollowException {

		SocialFollow socialFollow = fetchByUuid_Last(uuid, orderByComparator);

		if (socialFollow != null) {
			return socialFollow;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSocialFollowException(sb.toString());
	}

	/**
	 * Returns the last social follow in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	@Override
	public SocialFollow fetchByUuid_Last(
		String uuid, OrderByComparator<SocialFollow> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SocialFollow> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social follows before and after the current social follow in the ordered set where uuid = &#63;.
	 *
	 * @param socialFollowId the primary key of the current social follow
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social follow
	 * @throws NoSuchSocialFollowException if a social follow with the primary key could not be found
	 */
	@Override
	public SocialFollow[] findByUuid_PrevAndNext(
			long socialFollowId, String uuid,
			OrderByComparator<SocialFollow> orderByComparator)
		throws NoSuchSocialFollowException {

		uuid = Objects.toString(uuid, "");

		SocialFollow socialFollow = findByPrimaryKey(socialFollowId);

		Session session = null;

		try {
			session = openSession();

			SocialFollow[] array = new SocialFollowImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, socialFollow, uuid, orderByComparator, true);

			array[1] = socialFollow;

			array[2] = getByUuid_PrevAndNext(
				session, socialFollow, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SocialFollow getByUuid_PrevAndNext(
		Session session, SocialFollow socialFollow, String uuid,
		OrderByComparator<SocialFollow> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SOCIALFOLLOW_WHERE);

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
			sb.append(SocialFollowModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(socialFollow)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SocialFollow> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social follows where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SocialFollow socialFollow :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(socialFollow);
		}
	}

	/**
	 * Returns the number of social follows where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching social follows
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SOCIALFOLLOW_WHERE);

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
		"socialFollow.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(socialFollow.uuid IS NULL OR socialFollow.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the social follow where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSocialFollowException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	@Override
	public SocialFollow findByUUID_G(String uuid, long groupId)
		throws NoSuchSocialFollowException {

		SocialFollow socialFollow = fetchByUUID_G(uuid, groupId);

		if (socialFollow == null) {
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

			throw new NoSuchSocialFollowException(sb.toString());
		}

		return socialFollow;
	}

	/**
	 * Returns the social follow where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	@Override
	public SocialFollow fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the social follow where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	@Override
	public SocialFollow fetchByUUID_G(
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

		if (result instanceof SocialFollow) {
			SocialFollow socialFollow = (SocialFollow)result;

			if (!Objects.equals(uuid, socialFollow.getUuid()) ||
				(groupId != socialFollow.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SOCIALFOLLOW_WHERE);

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

				List<SocialFollow> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					SocialFollow socialFollow = list.get(0);

					result = socialFollow;

					cacheResult(socialFollow);
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
			return (SocialFollow)result;
		}
	}

	/**
	 * Removes the social follow where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the social follow that was removed
	 */
	@Override
	public SocialFollow removeByUUID_G(String uuid, long groupId)
		throws NoSuchSocialFollowException {

		SocialFollow socialFollow = findByUUID_G(uuid, groupId);

		return remove(socialFollow);
	}

	/**
	 * Returns the number of social follows where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching social follows
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SOCIALFOLLOW_WHERE);

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
		"socialFollow.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(socialFollow.uuid IS NULL OR socialFollow.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"socialFollow.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the social follows where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching social follows
	 */
	@Override
	public List<SocialFollow> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social follows where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @return the range of matching social follows
	 */
	@Override
	public List<SocialFollow> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the social follows where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social follows
	 */
	@Override
	public List<SocialFollow> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SocialFollow> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the social follows where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching social follows
	 */
	@Override
	public List<SocialFollow> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SocialFollow> orderByComparator,
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

		List<SocialFollow> list = null;

		if (useFinderCache) {
			list = (List<SocialFollow>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SocialFollow socialFollow : list) {
					if (!uuid.equals(socialFollow.getUuid()) ||
						(companyId != socialFollow.getCompanyId())) {

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

			sb.append(_SQL_SELECT_SOCIALFOLLOW_WHERE);

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
				sb.append(SocialFollowModelImpl.ORDER_BY_JPQL);
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

				list = (List<SocialFollow>)QueryUtil.list(
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
	 * Returns the first social follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	@Override
	public SocialFollow findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SocialFollow> orderByComparator)
		throws NoSuchSocialFollowException {

		SocialFollow socialFollow = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (socialFollow != null) {
			return socialFollow;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSocialFollowException(sb.toString());
	}

	/**
	 * Returns the first social follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	@Override
	public SocialFollow fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SocialFollow> orderByComparator) {

		List<SocialFollow> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	@Override
	public SocialFollow findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SocialFollow> orderByComparator)
		throws NoSuchSocialFollowException {

		SocialFollow socialFollow = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (socialFollow != null) {
			return socialFollow;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSocialFollowException(sb.toString());
	}

	/**
	 * Returns the last social follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	@Override
	public SocialFollow fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SocialFollow> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SocialFollow> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social follows before and after the current social follow in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param socialFollowId the primary key of the current social follow
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social follow
	 * @throws NoSuchSocialFollowException if a social follow with the primary key could not be found
	 */
	@Override
	public SocialFollow[] findByUuid_C_PrevAndNext(
			long socialFollowId, String uuid, long companyId,
			OrderByComparator<SocialFollow> orderByComparator)
		throws NoSuchSocialFollowException {

		uuid = Objects.toString(uuid, "");

		SocialFollow socialFollow = findByPrimaryKey(socialFollowId);

		Session session = null;

		try {
			session = openSession();

			SocialFollow[] array = new SocialFollowImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, socialFollow, uuid, companyId, orderByComparator,
				true);

			array[1] = socialFollow;

			array[2] = getByUuid_C_PrevAndNext(
				session, socialFollow, uuid, companyId, orderByComparator,
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

	protected SocialFollow getByUuid_C_PrevAndNext(
		Session session, SocialFollow socialFollow, String uuid, long companyId,
		OrderByComparator<SocialFollow> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SOCIALFOLLOW_WHERE);

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
			sb.append(SocialFollowModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(socialFollow)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SocialFollow> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social follows where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (SocialFollow socialFollow :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(socialFollow);
		}
	}

	/**
	 * Returns the number of social follows where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching social follows
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SOCIALFOLLOW_WHERE);

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
		"socialFollow.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(socialFollow.uuid IS NULL OR socialFollow.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"socialFollow.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBygetFollowing;
	private FinderPath _finderPathWithoutPaginationFindBygetFollowing;
	private FinderPath _finderPathCountBygetFollowing;

	/**
	 * Returns all the social follows where userId = &#63; and accepted = &#63;.
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @return the matching social follows
	 */
	@Override
	public List<SocialFollow> findBygetFollowing(
		long userId, boolean accepted) {

		return findBygetFollowing(
			userId, accepted, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social follows where userId = &#63; and accepted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @return the range of matching social follows
	 */
	@Override
	public List<SocialFollow> findBygetFollowing(
		long userId, boolean accepted, int start, int end) {

		return findBygetFollowing(userId, accepted, start, end, null);
	}

	/**
	 * Returns an ordered range of all the social follows where userId = &#63; and accepted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social follows
	 */
	@Override
	public List<SocialFollow> findBygetFollowing(
		long userId, boolean accepted, int start, int end,
		OrderByComparator<SocialFollow> orderByComparator) {

		return findBygetFollowing(
			userId, accepted, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the social follows where userId = &#63; and accepted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching social follows
	 */
	@Override
	public List<SocialFollow> findBygetFollowing(
		long userId, boolean accepted, int start, int end,
		OrderByComparator<SocialFollow> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBygetFollowing;
				finderArgs = new Object[] {userId, accepted};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBygetFollowing;
			finderArgs = new Object[] {
				userId, accepted, start, end, orderByComparator
			};
		}

		List<SocialFollow> list = null;

		if (useFinderCache) {
			list = (List<SocialFollow>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SocialFollow socialFollow : list) {
					if ((userId != socialFollow.getUserId()) ||
						(accepted != socialFollow.isAccepted())) {

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

			sb.append(_SQL_SELECT_SOCIALFOLLOW_WHERE);

			sb.append(_FINDER_COLUMN_GETFOLLOWING_USERID_2);

			sb.append(_FINDER_COLUMN_GETFOLLOWING_ACCEPTED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SocialFollowModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(accepted);

				list = (List<SocialFollow>)QueryUtil.list(
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
	 * Returns the first social follow in the ordered set where userId = &#63; and accepted = &#63;.
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	@Override
	public SocialFollow findBygetFollowing_First(
			long userId, boolean accepted,
			OrderByComparator<SocialFollow> orderByComparator)
		throws NoSuchSocialFollowException {

		SocialFollow socialFollow = fetchBygetFollowing_First(
			userId, accepted, orderByComparator);

		if (socialFollow != null) {
			return socialFollow;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", accepted=");
		sb.append(accepted);

		sb.append("}");

		throw new NoSuchSocialFollowException(sb.toString());
	}

	/**
	 * Returns the first social follow in the ordered set where userId = &#63; and accepted = &#63;.
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	@Override
	public SocialFollow fetchBygetFollowing_First(
		long userId, boolean accepted,
		OrderByComparator<SocialFollow> orderByComparator) {

		List<SocialFollow> list = findBygetFollowing(
			userId, accepted, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social follow in the ordered set where userId = &#63; and accepted = &#63;.
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	@Override
	public SocialFollow findBygetFollowing_Last(
			long userId, boolean accepted,
			OrderByComparator<SocialFollow> orderByComparator)
		throws NoSuchSocialFollowException {

		SocialFollow socialFollow = fetchBygetFollowing_Last(
			userId, accepted, orderByComparator);

		if (socialFollow != null) {
			return socialFollow;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", accepted=");
		sb.append(accepted);

		sb.append("}");

		throw new NoSuchSocialFollowException(sb.toString());
	}

	/**
	 * Returns the last social follow in the ordered set where userId = &#63; and accepted = &#63;.
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	@Override
	public SocialFollow fetchBygetFollowing_Last(
		long userId, boolean accepted,
		OrderByComparator<SocialFollow> orderByComparator) {

		int count = countBygetFollowing(userId, accepted);

		if (count == 0) {
			return null;
		}

		List<SocialFollow> list = findBygetFollowing(
			userId, accepted, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social follows before and after the current social follow in the ordered set where userId = &#63; and accepted = &#63;.
	 *
	 * @param socialFollowId the primary key of the current social follow
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social follow
	 * @throws NoSuchSocialFollowException if a social follow with the primary key could not be found
	 */
	@Override
	public SocialFollow[] findBygetFollowing_PrevAndNext(
			long socialFollowId, long userId, boolean accepted,
			OrderByComparator<SocialFollow> orderByComparator)
		throws NoSuchSocialFollowException {

		SocialFollow socialFollow = findByPrimaryKey(socialFollowId);

		Session session = null;

		try {
			session = openSession();

			SocialFollow[] array = new SocialFollowImpl[3];

			array[0] = getBygetFollowing_PrevAndNext(
				session, socialFollow, userId, accepted, orderByComparator,
				true);

			array[1] = socialFollow;

			array[2] = getBygetFollowing_PrevAndNext(
				session, socialFollow, userId, accepted, orderByComparator,
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

	protected SocialFollow getBygetFollowing_PrevAndNext(
		Session session, SocialFollow socialFollow, long userId,
		boolean accepted, OrderByComparator<SocialFollow> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SOCIALFOLLOW_WHERE);

		sb.append(_FINDER_COLUMN_GETFOLLOWING_USERID_2);

		sb.append(_FINDER_COLUMN_GETFOLLOWING_ACCEPTED_2);

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
			sb.append(SocialFollowModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		queryPos.add(accepted);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(socialFollow)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SocialFollow> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social follows where userId = &#63; and accepted = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 */
	@Override
	public void removeBygetFollowing(long userId, boolean accepted) {
		for (SocialFollow socialFollow :
				findBygetFollowing(
					userId, accepted, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(socialFollow);
		}
	}

	/**
	 * Returns the number of social follows where userId = &#63; and accepted = &#63;.
	 *
	 * @param userId the user ID
	 * @param accepted the accepted
	 * @return the number of matching social follows
	 */
	@Override
	public int countBygetFollowing(long userId, boolean accepted) {
		FinderPath finderPath = _finderPathCountBygetFollowing;

		Object[] finderArgs = new Object[] {userId, accepted};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SOCIALFOLLOW_WHERE);

			sb.append(_FINDER_COLUMN_GETFOLLOWING_USERID_2);

			sb.append(_FINDER_COLUMN_GETFOLLOWING_ACCEPTED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(accepted);

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

	private static final String _FINDER_COLUMN_GETFOLLOWING_USERID_2 =
		"socialFollow.userId = ? AND ";

	private static final String _FINDER_COLUMN_GETFOLLOWING_ACCEPTED_2 =
		"socialFollow.accepted = ?";

	private FinderPath _finderPathWithPaginationFindBygetFollowers;
	private FinderPath _finderPathWithoutPaginationFindBygetFollowers;
	private FinderPath _finderPathCountBygetFollowers;

	/**
	 * Returns all the social follows where followsTo = &#63; and accepted = &#63;.
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @return the matching social follows
	 */
	@Override
	public List<SocialFollow> findBygetFollowers(
		long followsTo, boolean accepted) {

		return findBygetFollowers(
			followsTo, accepted, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social follows where followsTo = &#63; and accepted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @return the range of matching social follows
	 */
	@Override
	public List<SocialFollow> findBygetFollowers(
		long followsTo, boolean accepted, int start, int end) {

		return findBygetFollowers(followsTo, accepted, start, end, null);
	}

	/**
	 * Returns an ordered range of all the social follows where followsTo = &#63; and accepted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching social follows
	 */
	@Override
	public List<SocialFollow> findBygetFollowers(
		long followsTo, boolean accepted, int start, int end,
		OrderByComparator<SocialFollow> orderByComparator) {

		return findBygetFollowers(
			followsTo, accepted, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the social follows where followsTo = &#63; and accepted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching social follows
	 */
	@Override
	public List<SocialFollow> findBygetFollowers(
		long followsTo, boolean accepted, int start, int end,
		OrderByComparator<SocialFollow> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBygetFollowers;
				finderArgs = new Object[] {followsTo, accepted};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBygetFollowers;
			finderArgs = new Object[] {
				followsTo, accepted, start, end, orderByComparator
			};
		}

		List<SocialFollow> list = null;

		if (useFinderCache) {
			list = (List<SocialFollow>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SocialFollow socialFollow : list) {
					if ((followsTo != socialFollow.getFollowsTo()) ||
						(accepted != socialFollow.isAccepted())) {

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

			sb.append(_SQL_SELECT_SOCIALFOLLOW_WHERE);

			sb.append(_FINDER_COLUMN_GETFOLLOWERS_FOLLOWSTO_2);

			sb.append(_FINDER_COLUMN_GETFOLLOWERS_ACCEPTED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SocialFollowModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(followsTo);

				queryPos.add(accepted);

				list = (List<SocialFollow>)QueryUtil.list(
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
	 * Returns the first social follow in the ordered set where followsTo = &#63; and accepted = &#63;.
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	@Override
	public SocialFollow findBygetFollowers_First(
			long followsTo, boolean accepted,
			OrderByComparator<SocialFollow> orderByComparator)
		throws NoSuchSocialFollowException {

		SocialFollow socialFollow = fetchBygetFollowers_First(
			followsTo, accepted, orderByComparator);

		if (socialFollow != null) {
			return socialFollow;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("followsTo=");
		sb.append(followsTo);

		sb.append(", accepted=");
		sb.append(accepted);

		sb.append("}");

		throw new NoSuchSocialFollowException(sb.toString());
	}

	/**
	 * Returns the first social follow in the ordered set where followsTo = &#63; and accepted = &#63;.
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	@Override
	public SocialFollow fetchBygetFollowers_First(
		long followsTo, boolean accepted,
		OrderByComparator<SocialFollow> orderByComparator) {

		List<SocialFollow> list = findBygetFollowers(
			followsTo, accepted, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last social follow in the ordered set where followsTo = &#63; and accepted = &#63;.
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	@Override
	public SocialFollow findBygetFollowers_Last(
			long followsTo, boolean accepted,
			OrderByComparator<SocialFollow> orderByComparator)
		throws NoSuchSocialFollowException {

		SocialFollow socialFollow = fetchBygetFollowers_Last(
			followsTo, accepted, orderByComparator);

		if (socialFollow != null) {
			return socialFollow;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("followsTo=");
		sb.append(followsTo);

		sb.append(", accepted=");
		sb.append(accepted);

		sb.append("}");

		throw new NoSuchSocialFollowException(sb.toString());
	}

	/**
	 * Returns the last social follow in the ordered set where followsTo = &#63; and accepted = &#63;.
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	@Override
	public SocialFollow fetchBygetFollowers_Last(
		long followsTo, boolean accepted,
		OrderByComparator<SocialFollow> orderByComparator) {

		int count = countBygetFollowers(followsTo, accepted);

		if (count == 0) {
			return null;
		}

		List<SocialFollow> list = findBygetFollowers(
			followsTo, accepted, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the social follows before and after the current social follow in the ordered set where followsTo = &#63; and accepted = &#63;.
	 *
	 * @param socialFollowId the primary key of the current social follow
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next social follow
	 * @throws NoSuchSocialFollowException if a social follow with the primary key could not be found
	 */
	@Override
	public SocialFollow[] findBygetFollowers_PrevAndNext(
			long socialFollowId, long followsTo, boolean accepted,
			OrderByComparator<SocialFollow> orderByComparator)
		throws NoSuchSocialFollowException {

		SocialFollow socialFollow = findByPrimaryKey(socialFollowId);

		Session session = null;

		try {
			session = openSession();

			SocialFollow[] array = new SocialFollowImpl[3];

			array[0] = getBygetFollowers_PrevAndNext(
				session, socialFollow, followsTo, accepted, orderByComparator,
				true);

			array[1] = socialFollow;

			array[2] = getBygetFollowers_PrevAndNext(
				session, socialFollow, followsTo, accepted, orderByComparator,
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

	protected SocialFollow getBygetFollowers_PrevAndNext(
		Session session, SocialFollow socialFollow, long followsTo,
		boolean accepted, OrderByComparator<SocialFollow> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SOCIALFOLLOW_WHERE);

		sb.append(_FINDER_COLUMN_GETFOLLOWERS_FOLLOWSTO_2);

		sb.append(_FINDER_COLUMN_GETFOLLOWERS_ACCEPTED_2);

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
			sb.append(SocialFollowModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(followsTo);

		queryPos.add(accepted);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(socialFollow)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SocialFollow> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the social follows where followsTo = &#63; and accepted = &#63; from the database.
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 */
	@Override
	public void removeBygetFollowers(long followsTo, boolean accepted) {
		for (SocialFollow socialFollow :
				findBygetFollowers(
					followsTo, accepted, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(socialFollow);
		}
	}

	/**
	 * Returns the number of social follows where followsTo = &#63; and accepted = &#63;.
	 *
	 * @param followsTo the follows to
	 * @param accepted the accepted
	 * @return the number of matching social follows
	 */
	@Override
	public int countBygetFollowers(long followsTo, boolean accepted) {
		FinderPath finderPath = _finderPathCountBygetFollowers;

		Object[] finderArgs = new Object[] {followsTo, accepted};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SOCIALFOLLOW_WHERE);

			sb.append(_FINDER_COLUMN_GETFOLLOWERS_FOLLOWSTO_2);

			sb.append(_FINDER_COLUMN_GETFOLLOWERS_ACCEPTED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(followsTo);

				queryPos.add(accepted);

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

	private static final String _FINDER_COLUMN_GETFOLLOWERS_FOLLOWSTO_2 =
		"socialFollow.followsTo = ? AND ";

	private static final String _FINDER_COLUMN_GETFOLLOWERS_ACCEPTED_2 =
		"socialFollow.accepted = ?";

	private FinderPath _finderPathFetchBygetFollow;
	private FinderPath _finderPathCountBygetFollow;

	/**
	 * Returns the social follow where userId = &#63; and followsTo = &#63; or throws a <code>NoSuchSocialFollowException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param followsTo the follows to
	 * @return the matching social follow
	 * @throws NoSuchSocialFollowException if a matching social follow could not be found
	 */
	@Override
	public SocialFollow findBygetFollow(long userId, long followsTo)
		throws NoSuchSocialFollowException {

		SocialFollow socialFollow = fetchBygetFollow(userId, followsTo);

		if (socialFollow == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append(", followsTo=");
			sb.append(followsTo);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSocialFollowException(sb.toString());
		}

		return socialFollow;
	}

	/**
	 * Returns the social follow where userId = &#63; and followsTo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param followsTo the follows to
	 * @return the matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	@Override
	public SocialFollow fetchBygetFollow(long userId, long followsTo) {
		return fetchBygetFollow(userId, followsTo, true);
	}

	/**
	 * Returns the social follow where userId = &#63; and followsTo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param followsTo the follows to
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching social follow, or <code>null</code> if a matching social follow could not be found
	 */
	@Override
	public SocialFollow fetchBygetFollow(
		long userId, long followsTo, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId, followsTo};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBygetFollow, finderArgs, this);
		}

		if (result instanceof SocialFollow) {
			SocialFollow socialFollow = (SocialFollow)result;

			if ((userId != socialFollow.getUserId()) ||
				(followsTo != socialFollow.getFollowsTo())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SOCIALFOLLOW_WHERE);

			sb.append(_FINDER_COLUMN_GETFOLLOW_USERID_2);

			sb.append(_FINDER_COLUMN_GETFOLLOW_FOLLOWSTO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(followsTo);

				List<SocialFollow> list = query.list();

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
								finderArgs = new Object[] {userId, followsTo};
							}

							_log.warn(
								"SocialFollowPersistenceImpl.fetchBygetFollow(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SocialFollow socialFollow = list.get(0);

					result = socialFollow;

					cacheResult(socialFollow);
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
			return (SocialFollow)result;
		}
	}

	/**
	 * Removes the social follow where userId = &#63; and followsTo = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param followsTo the follows to
	 * @return the social follow that was removed
	 */
	@Override
	public SocialFollow removeBygetFollow(long userId, long followsTo)
		throws NoSuchSocialFollowException {

		SocialFollow socialFollow = findBygetFollow(userId, followsTo);

		return remove(socialFollow);
	}

	/**
	 * Returns the number of social follows where userId = &#63; and followsTo = &#63;.
	 *
	 * @param userId the user ID
	 * @param followsTo the follows to
	 * @return the number of matching social follows
	 */
	@Override
	public int countBygetFollow(long userId, long followsTo) {
		FinderPath finderPath = _finderPathCountBygetFollow;

		Object[] finderArgs = new Object[] {userId, followsTo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SOCIALFOLLOW_WHERE);

			sb.append(_FINDER_COLUMN_GETFOLLOW_USERID_2);

			sb.append(_FINDER_COLUMN_GETFOLLOW_FOLLOWSTO_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(followsTo);

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

	private static final String _FINDER_COLUMN_GETFOLLOW_USERID_2 =
		"socialFollow.userId = ? AND ";

	private static final String _FINDER_COLUMN_GETFOLLOW_FOLLOWSTO_2 =
		"socialFollow.followsTo = ?";

	public SocialFollowPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SocialFollow.class);

		setModelImplClass(SocialFollowImpl.class);
		setModelPKClass(long.class);

		setTable(SocialFollowTable.INSTANCE);
	}

	/**
	 * Caches the social follow in the entity cache if it is enabled.
	 *
	 * @param socialFollow the social follow
	 */
	@Override
	public void cacheResult(SocialFollow socialFollow) {
		entityCache.putResult(
			SocialFollowImpl.class, socialFollow.getPrimaryKey(), socialFollow);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {socialFollow.getUuid(), socialFollow.getGroupId()},
			socialFollow);

		finderCache.putResult(
			_finderPathFetchBygetFollow,
			new Object[] {
				socialFollow.getUserId(), socialFollow.getFollowsTo()
			},
			socialFollow);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the social follows in the entity cache if it is enabled.
	 *
	 * @param socialFollows the social follows
	 */
	@Override
	public void cacheResult(List<SocialFollow> socialFollows) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (socialFollows.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SocialFollow socialFollow : socialFollows) {
			if (entityCache.getResult(
					SocialFollowImpl.class, socialFollow.getPrimaryKey()) ==
						null) {

				cacheResult(socialFollow);
			}
		}
	}

	/**
	 * Clears the cache for all social follows.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SocialFollowImpl.class);

		finderCache.clearCache(SocialFollowImpl.class);
	}

	/**
	 * Clears the cache for the social follow.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SocialFollow socialFollow) {
		entityCache.removeResult(SocialFollowImpl.class, socialFollow);
	}

	@Override
	public void clearCache(List<SocialFollow> socialFollows) {
		for (SocialFollow socialFollow : socialFollows) {
			entityCache.removeResult(SocialFollowImpl.class, socialFollow);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SocialFollowImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SocialFollowImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SocialFollowModelImpl socialFollowModelImpl) {

		Object[] args = new Object[] {
			socialFollowModelImpl.getUuid(), socialFollowModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, socialFollowModelImpl);

		args = new Object[] {
			socialFollowModelImpl.getUserId(),
			socialFollowModelImpl.getFollowsTo()
		};

		finderCache.putResult(
			_finderPathCountBygetFollow, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBygetFollow, args, socialFollowModelImpl);
	}

	/**
	 * Creates a new social follow with the primary key. Does not add the social follow to the database.
	 *
	 * @param socialFollowId the primary key for the new social follow
	 * @return the new social follow
	 */
	@Override
	public SocialFollow create(long socialFollowId) {
		SocialFollow socialFollow = new SocialFollowImpl();

		socialFollow.setNew(true);
		socialFollow.setPrimaryKey(socialFollowId);

		String uuid = PortalUUIDUtil.generate();

		socialFollow.setUuid(uuid);

		socialFollow.setCompanyId(CompanyThreadLocal.getCompanyId());

		return socialFollow;
	}

	/**
	 * Removes the social follow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param socialFollowId the primary key of the social follow
	 * @return the social follow that was removed
	 * @throws NoSuchSocialFollowException if a social follow with the primary key could not be found
	 */
	@Override
	public SocialFollow remove(long socialFollowId)
		throws NoSuchSocialFollowException {

		return remove((Serializable)socialFollowId);
	}

	/**
	 * Removes the social follow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the social follow
	 * @return the social follow that was removed
	 * @throws NoSuchSocialFollowException if a social follow with the primary key could not be found
	 */
	@Override
	public SocialFollow remove(Serializable primaryKey)
		throws NoSuchSocialFollowException {

		Session session = null;

		try {
			session = openSession();

			SocialFollow socialFollow = (SocialFollow)session.get(
				SocialFollowImpl.class, primaryKey);

			if (socialFollow == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSocialFollowException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(socialFollow);
		}
		catch (NoSuchSocialFollowException noSuchEntityException) {
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
	protected SocialFollow removeImpl(SocialFollow socialFollow) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(socialFollow)) {
				socialFollow = (SocialFollow)session.get(
					SocialFollowImpl.class, socialFollow.getPrimaryKeyObj());
			}

			if (socialFollow != null) {
				session.delete(socialFollow);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (socialFollow != null) {
			clearCache(socialFollow);
		}

		return socialFollow;
	}

	@Override
	public SocialFollow updateImpl(SocialFollow socialFollow) {
		boolean isNew = socialFollow.isNew();

		if (!(socialFollow instanceof SocialFollowModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(socialFollow.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					socialFollow);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in socialFollow proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SocialFollow implementation " +
					socialFollow.getClass());
		}

		SocialFollowModelImpl socialFollowModelImpl =
			(SocialFollowModelImpl)socialFollow;

		if (Validator.isNull(socialFollow.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			socialFollow.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (socialFollow.getCreateDate() == null)) {
			if (serviceContext == null) {
				socialFollow.setCreateDate(date);
			}
			else {
				socialFollow.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!socialFollowModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				socialFollow.setModifiedDate(date);
			}
			else {
				socialFollow.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(socialFollow);
			}
			else {
				socialFollow = (SocialFollow)session.merge(socialFollow);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SocialFollowImpl.class, socialFollowModelImpl, false, true);

		cacheUniqueFindersCache(socialFollowModelImpl);

		if (isNew) {
			socialFollow.setNew(false);
		}

		socialFollow.resetOriginalValues();

		return socialFollow;
	}

	/**
	 * Returns the social follow with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the social follow
	 * @return the social follow
	 * @throws NoSuchSocialFollowException if a social follow with the primary key could not be found
	 */
	@Override
	public SocialFollow findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSocialFollowException {

		SocialFollow socialFollow = fetchByPrimaryKey(primaryKey);

		if (socialFollow == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSocialFollowException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return socialFollow;
	}

	/**
	 * Returns the social follow with the primary key or throws a <code>NoSuchSocialFollowException</code> if it could not be found.
	 *
	 * @param socialFollowId the primary key of the social follow
	 * @return the social follow
	 * @throws NoSuchSocialFollowException if a social follow with the primary key could not be found
	 */
	@Override
	public SocialFollow findByPrimaryKey(long socialFollowId)
		throws NoSuchSocialFollowException {

		return findByPrimaryKey((Serializable)socialFollowId);
	}

	/**
	 * Returns the social follow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param socialFollowId the primary key of the social follow
	 * @return the social follow, or <code>null</code> if a social follow with the primary key could not be found
	 */
	@Override
	public SocialFollow fetchByPrimaryKey(long socialFollowId) {
		return fetchByPrimaryKey((Serializable)socialFollowId);
	}

	/**
	 * Returns all the social follows.
	 *
	 * @return the social follows
	 */
	@Override
	public List<SocialFollow> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the social follows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @return the range of social follows
	 */
	@Override
	public List<SocialFollow> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the social follows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of social follows
	 */
	@Override
	public List<SocialFollow> findAll(
		int start, int end, OrderByComparator<SocialFollow> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the social follows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SocialFollowModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of social follows
	 * @param end the upper bound of the range of social follows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of social follows
	 */
	@Override
	public List<SocialFollow> findAll(
		int start, int end, OrderByComparator<SocialFollow> orderByComparator,
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

		List<SocialFollow> list = null;

		if (useFinderCache) {
			list = (List<SocialFollow>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SOCIALFOLLOW);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SOCIALFOLLOW;

				sql = sql.concat(SocialFollowModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SocialFollow>)QueryUtil.list(
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
	 * Removes all the social follows from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SocialFollow socialFollow : findAll()) {
			remove(socialFollow);
		}
	}

	/**
	 * Returns the number of social follows.
	 *
	 * @return the number of social follows
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SOCIALFOLLOW);

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
		return "socialFollowId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SOCIALFOLLOW;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SocialFollowModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the social follow persistence.
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

		_finderPathWithPaginationFindBygetFollowing = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBygetFollowing",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"userId", "accepted"}, true);

		_finderPathWithoutPaginationFindBygetFollowing = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBygetFollowing",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"userId", "accepted"}, true);

		_finderPathCountBygetFollowing = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygetFollowing",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"userId", "accepted"}, false);

		_finderPathWithPaginationFindBygetFollowers = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBygetFollowers",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"followsTo", "accepted"}, true);

		_finderPathWithoutPaginationFindBygetFollowers = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBygetFollowers",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"followsTo", "accepted"}, true);

		_finderPathCountBygetFollowers = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygetFollowers",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"followsTo", "accepted"}, false);

		_finderPathFetchBygetFollow = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBygetFollow",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"userId", "followsTo"}, true);

		_finderPathCountBygetFollow = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygetFollow",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"userId", "followsTo"}, false);

		SocialFollowUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		SocialFollowUtil.setPersistence(null);

		entityCache.removeCache(SocialFollowImpl.class.getName());
	}

	@Override
	@Reference(
		target = SOCIAL_FOLLOWPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = SOCIAL_FOLLOWPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SOCIAL_FOLLOWPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SOCIALFOLLOW =
		"SELECT socialFollow FROM SocialFollow socialFollow";

	private static final String _SQL_SELECT_SOCIALFOLLOW_WHERE =
		"SELECT socialFollow FROM SocialFollow socialFollow WHERE ";

	private static final String _SQL_COUNT_SOCIALFOLLOW =
		"SELECT COUNT(socialFollow) FROM SocialFollow socialFollow";

	private static final String _SQL_COUNT_SOCIALFOLLOW_WHERE =
		"SELECT COUNT(socialFollow) FROM SocialFollow socialFollow WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "socialFollow.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SocialFollow exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SocialFollow exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SocialFollowPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}