/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence.impl;

import avanis.lonjas.exception.NoSuchLonjaException;
import avanis.lonjas.model.Lonja;
import avanis.lonjas.model.LonjaTable;
import avanis.lonjas.model.impl.LonjaImpl;
import avanis.lonjas.model.impl.LonjaModelImpl;
import avanis.lonjas.service.persistence.LonjaPersistence;
import avanis.lonjas.service.persistence.LonjaUtil;
import avanis.lonjas.service.persistence.impl.constants.AVANIS_LONJASPersistenceConstants;

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
 * The persistence implementation for the lonja service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LonjaPersistence.class)
public class LonjaPersistenceImpl
	extends BasePersistenceImpl<Lonja> implements LonjaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LonjaUtil</code> to access the lonja persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LonjaImpl.class.getName();

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
	 * Returns all the lonjas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching lonjas
	 */
	@Override
	public List<Lonja> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lonjas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @return the range of matching lonjas
	 */
	@Override
	public List<Lonja> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lonjas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lonjas
	 */
	@Override
	public List<Lonja> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Lonja> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lonjas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lonjas
	 */
	@Override
	public List<Lonja> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Lonja> orderByComparator, boolean useFinderCache) {

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

		List<Lonja> list = null;

		if (useFinderCache) {
			list = (List<Lonja>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lonja lonja : list) {
					if (!uuid.equals(lonja.getUuid())) {
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

			sb.append(_SQL_SELECT_LONJA_WHERE);

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
				sb.append(LonjaModelImpl.ORDER_BY_JPQL);
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

				list = (List<Lonja>)QueryUtil.list(
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
	 * Returns the first lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lonja
	 * @throws NoSuchLonjaException if a matching lonja could not be found
	 */
	@Override
	public Lonja findByUuid_First(
			String uuid, OrderByComparator<Lonja> orderByComparator)
		throws NoSuchLonjaException {

		Lonja lonja = fetchByUuid_First(uuid, orderByComparator);

		if (lonja != null) {
			return lonja;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLonjaException(sb.toString());
	}

	/**
	 * Returns the first lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lonja, or <code>null</code> if a matching lonja could not be found
	 */
	@Override
	public Lonja fetchByUuid_First(
		String uuid, OrderByComparator<Lonja> orderByComparator) {

		List<Lonja> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lonja
	 * @throws NoSuchLonjaException if a matching lonja could not be found
	 */
	@Override
	public Lonja findByUuid_Last(
			String uuid, OrderByComparator<Lonja> orderByComparator)
		throws NoSuchLonjaException {

		Lonja lonja = fetchByUuid_Last(uuid, orderByComparator);

		if (lonja != null) {
			return lonja;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLonjaException(sb.toString());
	}

	/**
	 * Returns the last lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lonja, or <code>null</code> if a matching lonja could not be found
	 */
	@Override
	public Lonja fetchByUuid_Last(
		String uuid, OrderByComparator<Lonja> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Lonja> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lonjas before and after the current lonja in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current lonja
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lonja
	 * @throws NoSuchLonjaException if a lonja with the primary key could not be found
	 */
	@Override
	public Lonja[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			OrderByComparator<Lonja> orderByComparator)
		throws NoSuchLonjaException {

		uuid = Objects.toString(uuid, "");

		Lonja lonja = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			Lonja[] array = new LonjaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, lonja, uuid, orderByComparator, true);

			array[1] = lonja;

			array[2] = getByUuid_PrevAndNext(
				session, lonja, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lonja getByUuid_PrevAndNext(
		Session session, Lonja lonja, String uuid,
		OrderByComparator<Lonja> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LONJA_WHERE);

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
			sb.append(LonjaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(lonja)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Lonja> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lonjas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Lonja lonja :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lonja);
		}
	}

	/**
	 * Returns the number of lonjas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching lonjas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LONJA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "lonja.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(lonja.uuid IS NULL OR lonja.uuid = '')";

	private FinderPath _finderPathWithPaginationFindBylonjaId;
	private FinderPath _finderPathWithoutPaginationFindBylonjaId;
	private FinderPath _finderPathCountBylonjaId;

	/**
	 * Returns all the lonjas where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @return the matching lonjas
	 */
	@Override
	public List<Lonja> findBylonjaId(long lonjaId) {
		return findBylonjaId(
			lonjaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lonjas where lonjaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @return the range of matching lonjas
	 */
	@Override
	public List<Lonja> findBylonjaId(long lonjaId, int start, int end) {
		return findBylonjaId(lonjaId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lonjas where lonjaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lonjas
	 */
	@Override
	public List<Lonja> findBylonjaId(
		long lonjaId, int start, int end,
		OrderByComparator<Lonja> orderByComparator) {

		return findBylonjaId(lonjaId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lonjas where lonjaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lonjas
	 */
	@Override
	public List<Lonja> findBylonjaId(
		long lonjaId, int start, int end,
		OrderByComparator<Lonja> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBylonjaId;
				finderArgs = new Object[] {lonjaId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBylonjaId;
			finderArgs = new Object[] {lonjaId, start, end, orderByComparator};
		}

		List<Lonja> list = null;

		if (useFinderCache) {
			list = (List<Lonja>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lonja lonja : list) {
					if (lonjaId != lonja.getLonjaId()) {
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

			sb.append(_SQL_SELECT_LONJA_WHERE);

			sb.append(_FINDER_COLUMN_LONJAID_LONJAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LonjaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lonjaId);

				list = (List<Lonja>)QueryUtil.list(
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
	 * Returns the first lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lonja
	 * @throws NoSuchLonjaException if a matching lonja could not be found
	 */
	@Override
	public Lonja findBylonjaId_First(
			long lonjaId, OrderByComparator<Lonja> orderByComparator)
		throws NoSuchLonjaException {

		Lonja lonja = fetchBylonjaId_First(lonjaId, orderByComparator);

		if (lonja != null) {
			return lonja;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lonjaId=");
		sb.append(lonjaId);

		sb.append("}");

		throw new NoSuchLonjaException(sb.toString());
	}

	/**
	 * Returns the first lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lonja, or <code>null</code> if a matching lonja could not be found
	 */
	@Override
	public Lonja fetchBylonjaId_First(
		long lonjaId, OrderByComparator<Lonja> orderByComparator) {

		List<Lonja> list = findBylonjaId(lonjaId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lonja
	 * @throws NoSuchLonjaException if a matching lonja could not be found
	 */
	@Override
	public Lonja findBylonjaId_Last(
			long lonjaId, OrderByComparator<Lonja> orderByComparator)
		throws NoSuchLonjaException {

		Lonja lonja = fetchBylonjaId_Last(lonjaId, orderByComparator);

		if (lonja != null) {
			return lonja;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lonjaId=");
		sb.append(lonjaId);

		sb.append("}");

		throw new NoSuchLonjaException(sb.toString());
	}

	/**
	 * Returns the last lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lonja, or <code>null</code> if a matching lonja could not be found
	 */
	@Override
	public Lonja fetchBylonjaId_Last(
		long lonjaId, OrderByComparator<Lonja> orderByComparator) {

		int count = countBylonjaId(lonjaId);

		if (count == 0) {
			return null;
		}

		List<Lonja> list = findBylonjaId(
			lonjaId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lonjas before and after the current lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param entityId the primary key of the current lonja
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lonja
	 * @throws NoSuchLonjaException if a lonja with the primary key could not be found
	 */
	@Override
	public Lonja[] findBylonjaId_PrevAndNext(
			long entityId, long lonjaId,
			OrderByComparator<Lonja> orderByComparator)
		throws NoSuchLonjaException {

		Lonja lonja = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			Lonja[] array = new LonjaImpl[3];

			array[0] = getBylonjaId_PrevAndNext(
				session, lonja, lonjaId, orderByComparator, true);

			array[1] = lonja;

			array[2] = getBylonjaId_PrevAndNext(
				session, lonja, lonjaId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lonja getBylonjaId_PrevAndNext(
		Session session, Lonja lonja, long lonjaId,
		OrderByComparator<Lonja> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LONJA_WHERE);

		sb.append(_FINDER_COLUMN_LONJAID_LONJAID_2);

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
			sb.append(LonjaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(lonjaId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(lonja)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Lonja> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lonjas where lonjaId = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 */
	@Override
	public void removeBylonjaId(long lonjaId) {
		for (Lonja lonja :
				findBylonjaId(
					lonjaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lonja);
		}
	}

	/**
	 * Returns the number of lonjas where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @return the number of matching lonjas
	 */
	@Override
	public int countBylonjaId(long lonjaId) {
		FinderPath finderPath = _finderPathCountBylonjaId;

		Object[] finderArgs = new Object[] {lonjaId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LONJA_WHERE);

			sb.append(_FINDER_COLUMN_LONJAID_LONJAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lonjaId);

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

	private static final String _FINDER_COLUMN_LONJAID_LONJAID_2 =
		"lonja.lonjaId = ?";

	private FinderPath _finderPathWithPaginationFindBynombre;
	private FinderPath _finderPathWithoutPaginationFindBynombre;
	private FinderPath _finderPathCountBynombre;

	/**
	 * Returns all the lonjas where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the matching lonjas
	 */
	@Override
	public List<Lonja> findBynombre(String nombre) {
		return findBynombre(nombre, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lonjas where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @return the range of matching lonjas
	 */
	@Override
	public List<Lonja> findBynombre(String nombre, int start, int end) {
		return findBynombre(nombre, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lonjas where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lonjas
	 */
	@Override
	public List<Lonja> findBynombre(
		String nombre, int start, int end,
		OrderByComparator<Lonja> orderByComparator) {

		return findBynombre(nombre, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lonjas where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lonjas
	 */
	@Override
	public List<Lonja> findBynombre(
		String nombre, int start, int end,
		OrderByComparator<Lonja> orderByComparator, boolean useFinderCache) {

		nombre = Objects.toString(nombre, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBynombre;
				finderArgs = new Object[] {nombre};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBynombre;
			finderArgs = new Object[] {nombre, start, end, orderByComparator};
		}

		List<Lonja> list = null;

		if (useFinderCache) {
			list = (List<Lonja>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lonja lonja : list) {
					if (!nombre.equals(lonja.getNombre())) {
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

			sb.append(_SQL_SELECT_LONJA_WHERE);

			boolean bindNombre = false;

			if (nombre.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOMBRE_NOMBRE_3);
			}
			else {
				bindNombre = true;

				sb.append(_FINDER_COLUMN_NOMBRE_NOMBRE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LonjaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNombre) {
					queryPos.add(nombre);
				}

				list = (List<Lonja>)QueryUtil.list(
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
	 * Returns the first lonja in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lonja
	 * @throws NoSuchLonjaException if a matching lonja could not be found
	 */
	@Override
	public Lonja findBynombre_First(
			String nombre, OrderByComparator<Lonja> orderByComparator)
		throws NoSuchLonjaException {

		Lonja lonja = fetchBynombre_First(nombre, orderByComparator);

		if (lonja != null) {
			return lonja;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nombre=");
		sb.append(nombre);

		sb.append("}");

		throw new NoSuchLonjaException(sb.toString());
	}

	/**
	 * Returns the first lonja in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lonja, or <code>null</code> if a matching lonja could not be found
	 */
	@Override
	public Lonja fetchBynombre_First(
		String nombre, OrderByComparator<Lonja> orderByComparator) {

		List<Lonja> list = findBynombre(nombre, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lonja in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lonja
	 * @throws NoSuchLonjaException if a matching lonja could not be found
	 */
	@Override
	public Lonja findBynombre_Last(
			String nombre, OrderByComparator<Lonja> orderByComparator)
		throws NoSuchLonjaException {

		Lonja lonja = fetchBynombre_Last(nombre, orderByComparator);

		if (lonja != null) {
			return lonja;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nombre=");
		sb.append(nombre);

		sb.append("}");

		throw new NoSuchLonjaException(sb.toString());
	}

	/**
	 * Returns the last lonja in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lonja, or <code>null</code> if a matching lonja could not be found
	 */
	@Override
	public Lonja fetchBynombre_Last(
		String nombre, OrderByComparator<Lonja> orderByComparator) {

		int count = countBynombre(nombre);

		if (count == 0) {
			return null;
		}

		List<Lonja> list = findBynombre(
			nombre, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lonjas before and after the current lonja in the ordered set where nombre = &#63;.
	 *
	 * @param entityId the primary key of the current lonja
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lonja
	 * @throws NoSuchLonjaException if a lonja with the primary key could not be found
	 */
	@Override
	public Lonja[] findBynombre_PrevAndNext(
			long entityId, String nombre,
			OrderByComparator<Lonja> orderByComparator)
		throws NoSuchLonjaException {

		nombre = Objects.toString(nombre, "");

		Lonja lonja = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			Lonja[] array = new LonjaImpl[3];

			array[0] = getBynombre_PrevAndNext(
				session, lonja, nombre, orderByComparator, true);

			array[1] = lonja;

			array[2] = getBynombre_PrevAndNext(
				session, lonja, nombre, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lonja getBynombre_PrevAndNext(
		Session session, Lonja lonja, String nombre,
		OrderByComparator<Lonja> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LONJA_WHERE);

		boolean bindNombre = false;

		if (nombre.isEmpty()) {
			sb.append(_FINDER_COLUMN_NOMBRE_NOMBRE_3);
		}
		else {
			bindNombre = true;

			sb.append(_FINDER_COLUMN_NOMBRE_NOMBRE_2);
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
			sb.append(LonjaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindNombre) {
			queryPos.add(nombre);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(lonja)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Lonja> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lonjas where nombre = &#63; from the database.
	 *
	 * @param nombre the nombre
	 */
	@Override
	public void removeBynombre(String nombre) {
		for (Lonja lonja :
				findBynombre(
					nombre, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lonja);
		}
	}

	/**
	 * Returns the number of lonjas where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the number of matching lonjas
	 */
	@Override
	public int countBynombre(String nombre) {
		nombre = Objects.toString(nombre, "");

		FinderPath finderPath = _finderPathCountBynombre;

		Object[] finderArgs = new Object[] {nombre};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LONJA_WHERE);

			boolean bindNombre = false;

			if (nombre.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOMBRE_NOMBRE_3);
			}
			else {
				bindNombre = true;

				sb.append(_FINDER_COLUMN_NOMBRE_NOMBRE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNombre) {
					queryPos.add(nombre);
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

	private static final String _FINDER_COLUMN_NOMBRE_NOMBRE_2 =
		"lonja.nombre = ?";

	private static final String _FINDER_COLUMN_NOMBRE_NOMBRE_3 =
		"(lonja.nombre IS NULL OR lonja.nombre = '')";

	public LonjaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Lonja.class);

		setModelImplClass(LonjaImpl.class);
		setModelPKClass(long.class);

		setTable(LonjaTable.INSTANCE);
	}

	/**
	 * Caches the lonja in the entity cache if it is enabled.
	 *
	 * @param lonja the lonja
	 */
	@Override
	public void cacheResult(Lonja lonja) {
		entityCache.putResult(LonjaImpl.class, lonja.getPrimaryKey(), lonja);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the lonjas in the entity cache if it is enabled.
	 *
	 * @param lonjas the lonjas
	 */
	@Override
	public void cacheResult(List<Lonja> lonjas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (lonjas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Lonja lonja : lonjas) {
			if (entityCache.getResult(LonjaImpl.class, lonja.getPrimaryKey()) ==
					null) {

				cacheResult(lonja);
			}
		}
	}

	/**
	 * Clears the cache for all lonjas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LonjaImpl.class);

		finderCache.clearCache(LonjaImpl.class);
	}

	/**
	 * Clears the cache for the lonja.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Lonja lonja) {
		entityCache.removeResult(LonjaImpl.class, lonja);
	}

	@Override
	public void clearCache(List<Lonja> lonjas) {
		for (Lonja lonja : lonjas) {
			entityCache.removeResult(LonjaImpl.class, lonja);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LonjaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LonjaImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new lonja with the primary key. Does not add the lonja to the database.
	 *
	 * @param entityId the primary key for the new lonja
	 * @return the new lonja
	 */
	@Override
	public Lonja create(long entityId) {
		Lonja lonja = new LonjaImpl();

		lonja.setNew(true);
		lonja.setPrimaryKey(entityId);

		String uuid = PortalUUIDUtil.generate();

		lonja.setUuid(uuid);

		return lonja;
	}

	/**
	 * Removes the lonja with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the lonja
	 * @return the lonja that was removed
	 * @throws NoSuchLonjaException if a lonja with the primary key could not be found
	 */
	@Override
	public Lonja remove(long entityId) throws NoSuchLonjaException {
		return remove((Serializable)entityId);
	}

	/**
	 * Removes the lonja with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lonja
	 * @return the lonja that was removed
	 * @throws NoSuchLonjaException if a lonja with the primary key could not be found
	 */
	@Override
	public Lonja remove(Serializable primaryKey) throws NoSuchLonjaException {
		Session session = null;

		try {
			session = openSession();

			Lonja lonja = (Lonja)session.get(LonjaImpl.class, primaryKey);

			if (lonja == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLonjaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(lonja);
		}
		catch (NoSuchLonjaException noSuchEntityException) {
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
	protected Lonja removeImpl(Lonja lonja) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lonja)) {
				lonja = (Lonja)session.get(
					LonjaImpl.class, lonja.getPrimaryKeyObj());
			}

			if (lonja != null) {
				session.delete(lonja);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (lonja != null) {
			clearCache(lonja);
		}

		return lonja;
	}

	@Override
	public Lonja updateImpl(Lonja lonja) {
		boolean isNew = lonja.isNew();

		if (!(lonja instanceof LonjaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(lonja.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(lonja);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in lonja proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Lonja implementation " +
					lonja.getClass());
		}

		LonjaModelImpl lonjaModelImpl = (LonjaModelImpl)lonja;

		if (Validator.isNull(lonja.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			lonja.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (lonja.getCreateDate() == null)) {
			if (serviceContext == null) {
				lonja.setCreateDate(date);
			}
			else {
				lonja.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!lonjaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				lonja.setModifiedDate(date);
			}
			else {
				lonja.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(lonja);
			}
			else {
				lonja = (Lonja)session.merge(lonja);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(LonjaImpl.class, lonjaModelImpl, false, true);

		if (isNew) {
			lonja.setNew(false);
		}

		lonja.resetOriginalValues();

		return lonja;
	}

	/**
	 * Returns the lonja with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lonja
	 * @return the lonja
	 * @throws NoSuchLonjaException if a lonja with the primary key could not be found
	 */
	@Override
	public Lonja findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLonjaException {

		Lonja lonja = fetchByPrimaryKey(primaryKey);

		if (lonja == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLonjaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return lonja;
	}

	/**
	 * Returns the lonja with the primary key or throws a <code>NoSuchLonjaException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the lonja
	 * @return the lonja
	 * @throws NoSuchLonjaException if a lonja with the primary key could not be found
	 */
	@Override
	public Lonja findByPrimaryKey(long entityId) throws NoSuchLonjaException {
		return findByPrimaryKey((Serializable)entityId);
	}

	/**
	 * Returns the lonja with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the lonja
	 * @return the lonja, or <code>null</code> if a lonja with the primary key could not be found
	 */
	@Override
	public Lonja fetchByPrimaryKey(long entityId) {
		return fetchByPrimaryKey((Serializable)entityId);
	}

	/**
	 * Returns all the lonjas.
	 *
	 * @return the lonjas
	 */
	@Override
	public List<Lonja> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @return the range of lonjas
	 */
	@Override
	public List<Lonja> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lonjas
	 */
	@Override
	public List<Lonja> findAll(
		int start, int end, OrderByComparator<Lonja> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lonjas
	 * @param end the upper bound of the range of lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lonjas
	 */
	@Override
	public List<Lonja> findAll(
		int start, int end, OrderByComparator<Lonja> orderByComparator,
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

		List<Lonja> list = null;

		if (useFinderCache) {
			list = (List<Lonja>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LONJA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LONJA;

				sql = sql.concat(LonjaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Lonja>)QueryUtil.list(
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
	 * Removes all the lonjas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Lonja lonja : findAll()) {
			remove(lonja);
		}
	}

	/**
	 * Returns the number of lonjas.
	 *
	 * @return the number of lonjas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LONJA);

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
		return "entityId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LONJA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LonjaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lonja persistence.
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

		_finderPathWithPaginationFindBylonjaId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylonjaId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"lonjaId"}, true);

		_finderPathWithoutPaginationFindBylonjaId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylonjaId",
			new String[] {Long.class.getName()}, new String[] {"lonjaId"},
			true);

		_finderPathCountBylonjaId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylonjaId",
			new String[] {Long.class.getName()}, new String[] {"lonjaId"},
			false);

		_finderPathWithPaginationFindBynombre = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBynombre",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"nombre"}, true);

		_finderPathWithoutPaginationFindBynombre = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBynombre",
			new String[] {String.class.getName()}, new String[] {"nombre"},
			true);

		_finderPathCountBynombre = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBynombre",
			new String[] {String.class.getName()}, new String[] {"nombre"},
			false);

		LonjaUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		LonjaUtil.setPersistence(null);

		entityCache.removeCache(LonjaImpl.class.getName());
	}

	@Override
	@Reference(
		target = AVANIS_LONJASPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = AVANIS_LONJASPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AVANIS_LONJASPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_LONJA =
		"SELECT lonja FROM Lonja lonja";

	private static final String _SQL_SELECT_LONJA_WHERE =
		"SELECT lonja FROM Lonja lonja WHERE ";

	private static final String _SQL_COUNT_LONJA =
		"SELECT COUNT(lonja) FROM Lonja lonja";

	private static final String _SQL_COUNT_LONJA_WHERE =
		"SELECT COUNT(lonja) FROM Lonja lonja WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "lonja.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Lonja exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Lonja exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LonjaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}