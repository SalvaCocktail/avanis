/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence.impl;

import avanis.lonjas.exception.NoSuchFechaLonjaException;
import avanis.lonjas.model.FechaLonja;
import avanis.lonjas.model.FechaLonjaTable;
import avanis.lonjas.model.impl.FechaLonjaImpl;
import avanis.lonjas.model.impl.FechaLonjaModelImpl;
import avanis.lonjas.service.persistence.FechaLonjaPersistence;
import avanis.lonjas.service.persistence.FechaLonjaUtil;
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
 * The persistence implementation for the fecha lonja service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FechaLonjaPersistence.class)
public class FechaLonjaPersistenceImpl
	extends BasePersistenceImpl<FechaLonja> implements FechaLonjaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FechaLonjaUtil</code> to access the fecha lonja persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FechaLonjaImpl.class.getName();

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
	 * Returns all the fecha lonjas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fecha lonjas
	 */
	@Override
	public List<FechaLonja> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fecha lonjas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FechaLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fecha lonjas
	 * @param end the upper bound of the range of fecha lonjas (not inclusive)
	 * @return the range of matching fecha lonjas
	 */
	@Override
	public List<FechaLonja> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fecha lonjas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FechaLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fecha lonjas
	 * @param end the upper bound of the range of fecha lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fecha lonjas
	 */
	@Override
	public List<FechaLonja> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FechaLonja> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fecha lonjas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FechaLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fecha lonjas
	 * @param end the upper bound of the range of fecha lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching fecha lonjas
	 */
	@Override
	public List<FechaLonja> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FechaLonja> orderByComparator,
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

		List<FechaLonja> list = null;

		if (useFinderCache) {
			list = (List<FechaLonja>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FechaLonja fechaLonja : list) {
					if (!uuid.equals(fechaLonja.getUuid())) {
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

			sb.append(_SQL_SELECT_FECHALONJA_WHERE);

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
				sb.append(FechaLonjaModelImpl.ORDER_BY_JPQL);
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

				list = (List<FechaLonja>)QueryUtil.list(
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
	 * Returns the first fecha lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fecha lonja
	 * @throws NoSuchFechaLonjaException if a matching fecha lonja could not be found
	 */
	@Override
	public FechaLonja findByUuid_First(
			String uuid, OrderByComparator<FechaLonja> orderByComparator)
		throws NoSuchFechaLonjaException {

		FechaLonja fechaLonja = fetchByUuid_First(uuid, orderByComparator);

		if (fechaLonja != null) {
			return fechaLonja;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFechaLonjaException(sb.toString());
	}

	/**
	 * Returns the first fecha lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fecha lonja, or <code>null</code> if a matching fecha lonja could not be found
	 */
	@Override
	public FechaLonja fetchByUuid_First(
		String uuid, OrderByComparator<FechaLonja> orderByComparator) {

		List<FechaLonja> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fecha lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fecha lonja
	 * @throws NoSuchFechaLonjaException if a matching fecha lonja could not be found
	 */
	@Override
	public FechaLonja findByUuid_Last(
			String uuid, OrderByComparator<FechaLonja> orderByComparator)
		throws NoSuchFechaLonjaException {

		FechaLonja fechaLonja = fetchByUuid_Last(uuid, orderByComparator);

		if (fechaLonja != null) {
			return fechaLonja;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFechaLonjaException(sb.toString());
	}

	/**
	 * Returns the last fecha lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fecha lonja, or <code>null</code> if a matching fecha lonja could not be found
	 */
	@Override
	public FechaLonja fetchByUuid_Last(
		String uuid, OrderByComparator<FechaLonja> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FechaLonja> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fecha lonjas before and after the current fecha lonja in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current fecha lonja
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fecha lonja
	 * @throws NoSuchFechaLonjaException if a fecha lonja with the primary key could not be found
	 */
	@Override
	public FechaLonja[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			OrderByComparator<FechaLonja> orderByComparator)
		throws NoSuchFechaLonjaException {

		uuid = Objects.toString(uuid, "");

		FechaLonja fechaLonja = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			FechaLonja[] array = new FechaLonjaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, fechaLonja, uuid, orderByComparator, true);

			array[1] = fechaLonja;

			array[2] = getByUuid_PrevAndNext(
				session, fechaLonja, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FechaLonja getByUuid_PrevAndNext(
		Session session, FechaLonja fechaLonja, String uuid,
		OrderByComparator<FechaLonja> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FECHALONJA_WHERE);

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
			sb.append(FechaLonjaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(fechaLonja)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FechaLonja> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fecha lonjas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FechaLonja fechaLonja :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(fechaLonja);
		}
	}

	/**
	 * Returns the number of fecha lonjas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fecha lonjas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FECHALONJA_WHERE);

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
		"fechaLonja.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(fechaLonja.uuid IS NULL OR fechaLonja.uuid = '')";

	private FinderPath _finderPathWithPaginationFindBylonjaId;
	private FinderPath _finderPathWithoutPaginationFindBylonjaId;
	private FinderPath _finderPathCountBylonjaId;

	/**
	 * Returns all the fecha lonjas where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @return the matching fecha lonjas
	 */
	@Override
	public List<FechaLonja> findBylonjaId(long lonjaId) {
		return findBylonjaId(
			lonjaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fecha lonjas where lonjaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FechaLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param start the lower bound of the range of fecha lonjas
	 * @param end the upper bound of the range of fecha lonjas (not inclusive)
	 * @return the range of matching fecha lonjas
	 */
	@Override
	public List<FechaLonja> findBylonjaId(long lonjaId, int start, int end) {
		return findBylonjaId(lonjaId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fecha lonjas where lonjaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FechaLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param start the lower bound of the range of fecha lonjas
	 * @param end the upper bound of the range of fecha lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fecha lonjas
	 */
	@Override
	public List<FechaLonja> findBylonjaId(
		long lonjaId, int start, int end,
		OrderByComparator<FechaLonja> orderByComparator) {

		return findBylonjaId(lonjaId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fecha lonjas where lonjaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FechaLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param start the lower bound of the range of fecha lonjas
	 * @param end the upper bound of the range of fecha lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching fecha lonjas
	 */
	@Override
	public List<FechaLonja> findBylonjaId(
		long lonjaId, int start, int end,
		OrderByComparator<FechaLonja> orderByComparator,
		boolean useFinderCache) {

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

		List<FechaLonja> list = null;

		if (useFinderCache) {
			list = (List<FechaLonja>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FechaLonja fechaLonja : list) {
					if (lonjaId != fechaLonja.getLonjaId()) {
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

			sb.append(_SQL_SELECT_FECHALONJA_WHERE);

			sb.append(_FINDER_COLUMN_LONJAID_LONJAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FechaLonjaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lonjaId);

				list = (List<FechaLonja>)QueryUtil.list(
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
	 * Returns the first fecha lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fecha lonja
	 * @throws NoSuchFechaLonjaException if a matching fecha lonja could not be found
	 */
	@Override
	public FechaLonja findBylonjaId_First(
			long lonjaId, OrderByComparator<FechaLonja> orderByComparator)
		throws NoSuchFechaLonjaException {

		FechaLonja fechaLonja = fetchBylonjaId_First(
			lonjaId, orderByComparator);

		if (fechaLonja != null) {
			return fechaLonja;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lonjaId=");
		sb.append(lonjaId);

		sb.append("}");

		throw new NoSuchFechaLonjaException(sb.toString());
	}

	/**
	 * Returns the first fecha lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fecha lonja, or <code>null</code> if a matching fecha lonja could not be found
	 */
	@Override
	public FechaLonja fetchBylonjaId_First(
		long lonjaId, OrderByComparator<FechaLonja> orderByComparator) {

		List<FechaLonja> list = findBylonjaId(lonjaId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fecha lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fecha lonja
	 * @throws NoSuchFechaLonjaException if a matching fecha lonja could not be found
	 */
	@Override
	public FechaLonja findBylonjaId_Last(
			long lonjaId, OrderByComparator<FechaLonja> orderByComparator)
		throws NoSuchFechaLonjaException {

		FechaLonja fechaLonja = fetchBylonjaId_Last(lonjaId, orderByComparator);

		if (fechaLonja != null) {
			return fechaLonja;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lonjaId=");
		sb.append(lonjaId);

		sb.append("}");

		throw new NoSuchFechaLonjaException(sb.toString());
	}

	/**
	 * Returns the last fecha lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fecha lonja, or <code>null</code> if a matching fecha lonja could not be found
	 */
	@Override
	public FechaLonja fetchBylonjaId_Last(
		long lonjaId, OrderByComparator<FechaLonja> orderByComparator) {

		int count = countBylonjaId(lonjaId);

		if (count == 0) {
			return null;
		}

		List<FechaLonja> list = findBylonjaId(
			lonjaId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fecha lonjas before and after the current fecha lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param entityId the primary key of the current fecha lonja
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fecha lonja
	 * @throws NoSuchFechaLonjaException if a fecha lonja with the primary key could not be found
	 */
	@Override
	public FechaLonja[] findBylonjaId_PrevAndNext(
			long entityId, long lonjaId,
			OrderByComparator<FechaLonja> orderByComparator)
		throws NoSuchFechaLonjaException {

		FechaLonja fechaLonja = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			FechaLonja[] array = new FechaLonjaImpl[3];

			array[0] = getBylonjaId_PrevAndNext(
				session, fechaLonja, lonjaId, orderByComparator, true);

			array[1] = fechaLonja;

			array[2] = getBylonjaId_PrevAndNext(
				session, fechaLonja, lonjaId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FechaLonja getBylonjaId_PrevAndNext(
		Session session, FechaLonja fechaLonja, long lonjaId,
		OrderByComparator<FechaLonja> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FECHALONJA_WHERE);

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
			sb.append(FechaLonjaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(lonjaId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(fechaLonja)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FechaLonja> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fecha lonjas where lonjaId = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 */
	@Override
	public void removeBylonjaId(long lonjaId) {
		for (FechaLonja fechaLonja :
				findBylonjaId(
					lonjaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(fechaLonja);
		}
	}

	/**
	 * Returns the number of fecha lonjas where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @return the number of matching fecha lonjas
	 */
	@Override
	public int countBylonjaId(long lonjaId) {
		FinderPath finderPath = _finderPathCountBylonjaId;

		Object[] finderArgs = new Object[] {lonjaId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FECHALONJA_WHERE);

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
		"fechaLonja.lonjaId = ?";

	public FechaLonjaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FechaLonja.class);

		setModelImplClass(FechaLonjaImpl.class);
		setModelPKClass(long.class);

		setTable(FechaLonjaTable.INSTANCE);
	}

	/**
	 * Caches the fecha lonja in the entity cache if it is enabled.
	 *
	 * @param fechaLonja the fecha lonja
	 */
	@Override
	public void cacheResult(FechaLonja fechaLonja) {
		entityCache.putResult(
			FechaLonjaImpl.class, fechaLonja.getPrimaryKey(), fechaLonja);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the fecha lonjas in the entity cache if it is enabled.
	 *
	 * @param fechaLonjas the fecha lonjas
	 */
	@Override
	public void cacheResult(List<FechaLonja> fechaLonjas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (fechaLonjas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FechaLonja fechaLonja : fechaLonjas) {
			if (entityCache.getResult(
					FechaLonjaImpl.class, fechaLonja.getPrimaryKey()) == null) {

				cacheResult(fechaLonja);
			}
		}
	}

	/**
	 * Clears the cache for all fecha lonjas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FechaLonjaImpl.class);

		finderCache.clearCache(FechaLonjaImpl.class);
	}

	/**
	 * Clears the cache for the fecha lonja.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FechaLonja fechaLonja) {
		entityCache.removeResult(FechaLonjaImpl.class, fechaLonja);
	}

	@Override
	public void clearCache(List<FechaLonja> fechaLonjas) {
		for (FechaLonja fechaLonja : fechaLonjas) {
			entityCache.removeResult(FechaLonjaImpl.class, fechaLonja);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FechaLonjaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FechaLonjaImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new fecha lonja with the primary key. Does not add the fecha lonja to the database.
	 *
	 * @param entityId the primary key for the new fecha lonja
	 * @return the new fecha lonja
	 */
	@Override
	public FechaLonja create(long entityId) {
		FechaLonja fechaLonja = new FechaLonjaImpl();

		fechaLonja.setNew(true);
		fechaLonja.setPrimaryKey(entityId);

		String uuid = PortalUUIDUtil.generate();

		fechaLonja.setUuid(uuid);

		return fechaLonja;
	}

	/**
	 * Removes the fecha lonja with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the fecha lonja
	 * @return the fecha lonja that was removed
	 * @throws NoSuchFechaLonjaException if a fecha lonja with the primary key could not be found
	 */
	@Override
	public FechaLonja remove(long entityId) throws NoSuchFechaLonjaException {
		return remove((Serializable)entityId);
	}

	/**
	 * Removes the fecha lonja with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fecha lonja
	 * @return the fecha lonja that was removed
	 * @throws NoSuchFechaLonjaException if a fecha lonja with the primary key could not be found
	 */
	@Override
	public FechaLonja remove(Serializable primaryKey)
		throws NoSuchFechaLonjaException {

		Session session = null;

		try {
			session = openSession();

			FechaLonja fechaLonja = (FechaLonja)session.get(
				FechaLonjaImpl.class, primaryKey);

			if (fechaLonja == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFechaLonjaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(fechaLonja);
		}
		catch (NoSuchFechaLonjaException noSuchEntityException) {
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
	protected FechaLonja removeImpl(FechaLonja fechaLonja) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fechaLonja)) {
				fechaLonja = (FechaLonja)session.get(
					FechaLonjaImpl.class, fechaLonja.getPrimaryKeyObj());
			}

			if (fechaLonja != null) {
				session.delete(fechaLonja);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (fechaLonja != null) {
			clearCache(fechaLonja);
		}

		return fechaLonja;
	}

	@Override
	public FechaLonja updateImpl(FechaLonja fechaLonja) {
		boolean isNew = fechaLonja.isNew();

		if (!(fechaLonja instanceof FechaLonjaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(fechaLonja.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(fechaLonja);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in fechaLonja proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FechaLonja implementation " +
					fechaLonja.getClass());
		}

		FechaLonjaModelImpl fechaLonjaModelImpl =
			(FechaLonjaModelImpl)fechaLonja;

		if (Validator.isNull(fechaLonja.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			fechaLonja.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (fechaLonja.getCreateDate() == null)) {
			if (serviceContext == null) {
				fechaLonja.setCreateDate(date);
			}
			else {
				fechaLonja.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!fechaLonjaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				fechaLonja.setModifiedDate(date);
			}
			else {
				fechaLonja.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(fechaLonja);
			}
			else {
				fechaLonja = (FechaLonja)session.merge(fechaLonja);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FechaLonjaImpl.class, fechaLonjaModelImpl, false, true);

		if (isNew) {
			fechaLonja.setNew(false);
		}

		fechaLonja.resetOriginalValues();

		return fechaLonja;
	}

	/**
	 * Returns the fecha lonja with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fecha lonja
	 * @return the fecha lonja
	 * @throws NoSuchFechaLonjaException if a fecha lonja with the primary key could not be found
	 */
	@Override
	public FechaLonja findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFechaLonjaException {

		FechaLonja fechaLonja = fetchByPrimaryKey(primaryKey);

		if (fechaLonja == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFechaLonjaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return fechaLonja;
	}

	/**
	 * Returns the fecha lonja with the primary key or throws a <code>NoSuchFechaLonjaException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the fecha lonja
	 * @return the fecha lonja
	 * @throws NoSuchFechaLonjaException if a fecha lonja with the primary key could not be found
	 */
	@Override
	public FechaLonja findByPrimaryKey(long entityId)
		throws NoSuchFechaLonjaException {

		return findByPrimaryKey((Serializable)entityId);
	}

	/**
	 * Returns the fecha lonja with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the fecha lonja
	 * @return the fecha lonja, or <code>null</code> if a fecha lonja with the primary key could not be found
	 */
	@Override
	public FechaLonja fetchByPrimaryKey(long entityId) {
		return fetchByPrimaryKey((Serializable)entityId);
	}

	/**
	 * Returns all the fecha lonjas.
	 *
	 * @return the fecha lonjas
	 */
	@Override
	public List<FechaLonja> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fecha lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FechaLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fecha lonjas
	 * @param end the upper bound of the range of fecha lonjas (not inclusive)
	 * @return the range of fecha lonjas
	 */
	@Override
	public List<FechaLonja> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fecha lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FechaLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fecha lonjas
	 * @param end the upper bound of the range of fecha lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fecha lonjas
	 */
	@Override
	public List<FechaLonja> findAll(
		int start, int end, OrderByComparator<FechaLonja> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fecha lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FechaLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fecha lonjas
	 * @param end the upper bound of the range of fecha lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of fecha lonjas
	 */
	@Override
	public List<FechaLonja> findAll(
		int start, int end, OrderByComparator<FechaLonja> orderByComparator,
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

		List<FechaLonja> list = null;

		if (useFinderCache) {
			list = (List<FechaLonja>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FECHALONJA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FECHALONJA;

				sql = sql.concat(FechaLonjaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FechaLonja>)QueryUtil.list(
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
	 * Removes all the fecha lonjas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FechaLonja fechaLonja : findAll()) {
			remove(fechaLonja);
		}
	}

	/**
	 * Returns the number of fecha lonjas.
	 *
	 * @return the number of fecha lonjas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FECHALONJA);

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
		return _SQL_SELECT_FECHALONJA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FechaLonjaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the fecha lonja persistence.
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

		FechaLonjaUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		FechaLonjaUtil.setPersistence(null);

		entityCache.removeCache(FechaLonjaImpl.class.getName());
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

	private static final String _SQL_SELECT_FECHALONJA =
		"SELECT fechaLonja FROM FechaLonja fechaLonja";

	private static final String _SQL_SELECT_FECHALONJA_WHERE =
		"SELECT fechaLonja FROM FechaLonja fechaLonja WHERE ";

	private static final String _SQL_COUNT_FECHALONJA =
		"SELECT COUNT(fechaLonja) FROM FechaLonja fechaLonja";

	private static final String _SQL_COUNT_FECHALONJA_WHERE =
		"SELECT COUNT(fechaLonja) FROM FechaLonja fechaLonja WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "fechaLonja.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FechaLonja exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FechaLonja exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FechaLonjaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}