/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence.impl;

import avanis.lonjas.exception.NoSuchPrecioLonjaException;
import avanis.lonjas.model.PrecioLonja;
import avanis.lonjas.model.PrecioLonjaTable;
import avanis.lonjas.model.impl.PrecioLonjaImpl;
import avanis.lonjas.model.impl.PrecioLonjaModelImpl;
import avanis.lonjas.service.persistence.PrecioLonjaPersistence;
import avanis.lonjas.service.persistence.PrecioLonjaUtil;
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

import java.sql.Timestamp;

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
 * The persistence implementation for the precio lonja service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PrecioLonjaPersistence.class)
public class PrecioLonjaPersistenceImpl
	extends BasePersistenceImpl<PrecioLonja> implements PrecioLonjaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PrecioLonjaUtil</code> to access the precio lonja persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PrecioLonjaImpl.class.getName();

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
	 * Returns all the precio lonjas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the precio lonjas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @return the range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator,
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

		List<PrecioLonja> list = null;

		if (useFinderCache) {
			list = (List<PrecioLonja>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PrecioLonja precioLonja : list) {
					if (!uuid.equals(precioLonja.getUuid())) {
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

			sb.append(_SQL_SELECT_PRECIOLONJA_WHERE);

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
				sb.append(PrecioLonjaModelImpl.ORDER_BY_JPQL);
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

				list = (List<PrecioLonja>)QueryUtil.list(
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
	 * Returns the first precio lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja findByUuid_First(
			String uuid, OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = fetchByUuid_First(uuid, orderByComparator);

		if (precioLonja != null) {
			return precioLonja;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPrecioLonjaException(sb.toString());
	}

	/**
	 * Returns the first precio lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja fetchByUuid_First(
		String uuid, OrderByComparator<PrecioLonja> orderByComparator) {

		List<PrecioLonja> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last precio lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja findByUuid_Last(
			String uuid, OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = fetchByUuid_Last(uuid, orderByComparator);

		if (precioLonja != null) {
			return precioLonja;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPrecioLonjaException(sb.toString());
	}

	/**
	 * Returns the last precio lonja in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja fetchByUuid_Last(
		String uuid, OrderByComparator<PrecioLonja> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PrecioLonja> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the precio lonjas before and after the current precio lonja in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current precio lonja
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	@Override
	public PrecioLonja[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		uuid = Objects.toString(uuid, "");

		PrecioLonja precioLonja = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			PrecioLonja[] array = new PrecioLonjaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, precioLonja, uuid, orderByComparator, true);

			array[1] = precioLonja;

			array[2] = getByUuid_PrevAndNext(
				session, precioLonja, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PrecioLonja getByUuid_PrevAndNext(
		Session session, PrecioLonja precioLonja, String uuid,
		OrderByComparator<PrecioLonja> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PRECIOLONJA_WHERE);

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
			sb.append(PrecioLonjaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(precioLonja)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PrecioLonja> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the precio lonjas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PrecioLonja precioLonja :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(precioLonja);
		}
	}

	/**
	 * Returns the number of precio lonjas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching precio lonjas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRECIOLONJA_WHERE);

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
		"precioLonja.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(precioLonja.uuid IS NULL OR precioLonja.uuid = '')";

	private FinderPath _finderPathWithPaginationFindBylonjaId;
	private FinderPath _finderPathWithoutPaginationFindBylonjaId;
	private FinderPath _finderPathCountBylonjaId;

	/**
	 * Returns all the precio lonjas where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @return the matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaId(long lonjaId) {
		return findBylonjaId(
			lonjaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the precio lonjas where lonjaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @return the range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaId(long lonjaId, int start, int end) {
		return findBylonjaId(lonjaId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaId(
		long lonjaId, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return findBylonjaId(lonjaId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaId(
		long lonjaId, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator,
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

		List<PrecioLonja> list = null;

		if (useFinderCache) {
			list = (List<PrecioLonja>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PrecioLonja precioLonja : list) {
					if (lonjaId != precioLonja.getLonjaId()) {
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

			sb.append(_SQL_SELECT_PRECIOLONJA_WHERE);

			sb.append(_FINDER_COLUMN_LONJAID_LONJAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PrecioLonjaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lonjaId);

				list = (List<PrecioLonja>)QueryUtil.list(
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
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja findBylonjaId_First(
			long lonjaId, OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = fetchBylonjaId_First(
			lonjaId, orderByComparator);

		if (precioLonja != null) {
			return precioLonja;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lonjaId=");
		sb.append(lonjaId);

		sb.append("}");

		throw new NoSuchPrecioLonjaException(sb.toString());
	}

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja fetchBylonjaId_First(
		long lonjaId, OrderByComparator<PrecioLonja> orderByComparator) {

		List<PrecioLonja> list = findBylonjaId(
			lonjaId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja findBylonjaId_Last(
			long lonjaId, OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = fetchBylonjaId_Last(
			lonjaId, orderByComparator);

		if (precioLonja != null) {
			return precioLonja;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lonjaId=");
		sb.append(lonjaId);

		sb.append("}");

		throw new NoSuchPrecioLonjaException(sb.toString());
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja fetchBylonjaId_Last(
		long lonjaId, OrderByComparator<PrecioLonja> orderByComparator) {

		int count = countBylonjaId(lonjaId);

		if (count == 0) {
			return null;
		}

		List<PrecioLonja> list = findBylonjaId(
			lonjaId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the precio lonjas before and after the current precio lonja in the ordered set where lonjaId = &#63;.
	 *
	 * @param entityId the primary key of the current precio lonja
	 * @param lonjaId the lonja ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	@Override
	public PrecioLonja[] findBylonjaId_PrevAndNext(
			long entityId, long lonjaId,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			PrecioLonja[] array = new PrecioLonjaImpl[3];

			array[0] = getBylonjaId_PrevAndNext(
				session, precioLonja, lonjaId, orderByComparator, true);

			array[1] = precioLonja;

			array[2] = getBylonjaId_PrevAndNext(
				session, precioLonja, lonjaId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PrecioLonja getBylonjaId_PrevAndNext(
		Session session, PrecioLonja precioLonja, long lonjaId,
		OrderByComparator<PrecioLonja> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PRECIOLONJA_WHERE);

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
			sb.append(PrecioLonjaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(lonjaId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(precioLonja)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PrecioLonja> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the precio lonjas where lonjaId = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 */
	@Override
	public void removeBylonjaId(long lonjaId) {
		for (PrecioLonja precioLonja :
				findBylonjaId(
					lonjaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(precioLonja);
		}
	}

	/**
	 * Returns the number of precio lonjas where lonjaId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @return the number of matching precio lonjas
	 */
	@Override
	public int countBylonjaId(long lonjaId) {
		FinderPath finderPath = _finderPathCountBylonjaId;

		Object[] finderArgs = new Object[] {lonjaId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRECIOLONJA_WHERE);

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
		"precioLonja.lonjaId = ?";

	private FinderPath _finderPathWithPaginationFindByproductoId;
	private FinderPath _finderPathWithoutPaginationFindByproductoId;
	private FinderPath _finderPathCountByproductoId;

	/**
	 * Returns all the precio lonjas where productoId = &#63;.
	 *
	 * @param productoId the producto ID
	 * @return the matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findByproductoId(long productoId) {
		return findByproductoId(
			productoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the precio lonjas where productoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param productoId the producto ID
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @return the range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findByproductoId(
		long productoId, int start, int end) {

		return findByproductoId(productoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where productoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param productoId the producto ID
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findByproductoId(
		long productoId, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return findByproductoId(
			productoId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where productoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param productoId the producto ID
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findByproductoId(
		long productoId, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByproductoId;
				finderArgs = new Object[] {productoId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByproductoId;
			finderArgs = new Object[] {
				productoId, start, end, orderByComparator
			};
		}

		List<PrecioLonja> list = null;

		if (useFinderCache) {
			list = (List<PrecioLonja>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PrecioLonja precioLonja : list) {
					if (productoId != precioLonja.getProductoId()) {
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

			sb.append(_SQL_SELECT_PRECIOLONJA_WHERE);

			sb.append(_FINDER_COLUMN_PRODUCTOID_PRODUCTOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PrecioLonjaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(productoId);

				list = (List<PrecioLonja>)QueryUtil.list(
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
	 * Returns the first precio lonja in the ordered set where productoId = &#63;.
	 *
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja findByproductoId_First(
			long productoId, OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = fetchByproductoId_First(
			productoId, orderByComparator);

		if (precioLonja != null) {
			return precioLonja;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("productoId=");
		sb.append(productoId);

		sb.append("}");

		throw new NoSuchPrecioLonjaException(sb.toString());
	}

	/**
	 * Returns the first precio lonja in the ordered set where productoId = &#63;.
	 *
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja fetchByproductoId_First(
		long productoId, OrderByComparator<PrecioLonja> orderByComparator) {

		List<PrecioLonja> list = findByproductoId(
			productoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last precio lonja in the ordered set where productoId = &#63;.
	 *
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja findByproductoId_Last(
			long productoId, OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = fetchByproductoId_Last(
			productoId, orderByComparator);

		if (precioLonja != null) {
			return precioLonja;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("productoId=");
		sb.append(productoId);

		sb.append("}");

		throw new NoSuchPrecioLonjaException(sb.toString());
	}

	/**
	 * Returns the last precio lonja in the ordered set where productoId = &#63;.
	 *
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja fetchByproductoId_Last(
		long productoId, OrderByComparator<PrecioLonja> orderByComparator) {

		int count = countByproductoId(productoId);

		if (count == 0) {
			return null;
		}

		List<PrecioLonja> list = findByproductoId(
			productoId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the precio lonjas before and after the current precio lonja in the ordered set where productoId = &#63;.
	 *
	 * @param entityId the primary key of the current precio lonja
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	@Override
	public PrecioLonja[] findByproductoId_PrevAndNext(
			long entityId, long productoId,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			PrecioLonja[] array = new PrecioLonjaImpl[3];

			array[0] = getByproductoId_PrevAndNext(
				session, precioLonja, productoId, orderByComparator, true);

			array[1] = precioLonja;

			array[2] = getByproductoId_PrevAndNext(
				session, precioLonja, productoId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PrecioLonja getByproductoId_PrevAndNext(
		Session session, PrecioLonja precioLonja, long productoId,
		OrderByComparator<PrecioLonja> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PRECIOLONJA_WHERE);

		sb.append(_FINDER_COLUMN_PRODUCTOID_PRODUCTOID_2);

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
			sb.append(PrecioLonjaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(productoId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(precioLonja)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PrecioLonja> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the precio lonjas where productoId = &#63; from the database.
	 *
	 * @param productoId the producto ID
	 */
	@Override
	public void removeByproductoId(long productoId) {
		for (PrecioLonja precioLonja :
				findByproductoId(
					productoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(precioLonja);
		}
	}

	/**
	 * Returns the number of precio lonjas where productoId = &#63;.
	 *
	 * @param productoId the producto ID
	 * @return the number of matching precio lonjas
	 */
	@Override
	public int countByproductoId(long productoId) {
		FinderPath finderPath = _finderPathCountByproductoId;

		Object[] finderArgs = new Object[] {productoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRECIOLONJA_WHERE);

			sb.append(_FINDER_COLUMN_PRODUCTOID_PRODUCTOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(productoId);

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

	private static final String _FINDER_COLUMN_PRODUCTOID_PRODUCTOID_2 =
		"precioLonja.productoId = ?";

	private FinderPath _finderPathWithPaginationFindBylonjaIdProductoId;
	private FinderPath _finderPathWithoutPaginationFindBylonjaIdProductoId;
	private FinderPath _finderPathCountBylonjaIdProductoId;

	/**
	 * Returns all the precio lonjas where lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @return the matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaIdProductoId(
		long lonjaId, long productoId) {

		return findBylonjaIdProductoId(
			lonjaId, productoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the precio lonjas where lonjaId = &#63; and productoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @return the range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaIdProductoId(
		long lonjaId, long productoId, int start, int end) {

		return findBylonjaIdProductoId(lonjaId, productoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63; and productoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaIdProductoId(
		long lonjaId, long productoId, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return findBylonjaIdProductoId(
			lonjaId, productoId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63; and productoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaIdProductoId(
		long lonjaId, long productoId, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBylonjaIdProductoId;
				finderArgs = new Object[] {lonjaId, productoId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBylonjaIdProductoId;
			finderArgs = new Object[] {
				lonjaId, productoId, start, end, orderByComparator
			};
		}

		List<PrecioLonja> list = null;

		if (useFinderCache) {
			list = (List<PrecioLonja>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PrecioLonja precioLonja : list) {
					if ((lonjaId != precioLonja.getLonjaId()) ||
						(productoId != precioLonja.getProductoId())) {

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

			sb.append(_SQL_SELECT_PRECIOLONJA_WHERE);

			sb.append(_FINDER_COLUMN_LONJAIDPRODUCTOID_LONJAID_2);

			sb.append(_FINDER_COLUMN_LONJAIDPRODUCTOID_PRODUCTOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PrecioLonjaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lonjaId);

				queryPos.add(productoId);

				list = (List<PrecioLonja>)QueryUtil.list(
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
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja findBylonjaIdProductoId_First(
			long lonjaId, long productoId,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = fetchBylonjaIdProductoId_First(
			lonjaId, productoId, orderByComparator);

		if (precioLonja != null) {
			return precioLonja;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lonjaId=");
		sb.append(lonjaId);

		sb.append(", productoId=");
		sb.append(productoId);

		sb.append("}");

		throw new NoSuchPrecioLonjaException(sb.toString());
	}

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja fetchBylonjaIdProductoId_First(
		long lonjaId, long productoId,
		OrderByComparator<PrecioLonja> orderByComparator) {

		List<PrecioLonja> list = findBylonjaIdProductoId(
			lonjaId, productoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja findBylonjaIdProductoId_Last(
			long lonjaId, long productoId,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = fetchBylonjaIdProductoId_Last(
			lonjaId, productoId, orderByComparator);

		if (precioLonja != null) {
			return precioLonja;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lonjaId=");
		sb.append(lonjaId);

		sb.append(", productoId=");
		sb.append(productoId);

		sb.append("}");

		throw new NoSuchPrecioLonjaException(sb.toString());
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja fetchBylonjaIdProductoId_Last(
		long lonjaId, long productoId,
		OrderByComparator<PrecioLonja> orderByComparator) {

		int count = countBylonjaIdProductoId(lonjaId, productoId);

		if (count == 0) {
			return null;
		}

		List<PrecioLonja> list = findBylonjaIdProductoId(
			lonjaId, productoId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the precio lonjas before and after the current precio lonja in the ordered set where lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param entityId the primary key of the current precio lonja
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	@Override
	public PrecioLonja[] findBylonjaIdProductoId_PrevAndNext(
			long entityId, long lonjaId, long productoId,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			PrecioLonja[] array = new PrecioLonjaImpl[3];

			array[0] = getBylonjaIdProductoId_PrevAndNext(
				session, precioLonja, lonjaId, productoId, orderByComparator,
				true);

			array[1] = precioLonja;

			array[2] = getBylonjaIdProductoId_PrevAndNext(
				session, precioLonja, lonjaId, productoId, orderByComparator,
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

	protected PrecioLonja getBylonjaIdProductoId_PrevAndNext(
		Session session, PrecioLonja precioLonja, long lonjaId, long productoId,
		OrderByComparator<PrecioLonja> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PRECIOLONJA_WHERE);

		sb.append(_FINDER_COLUMN_LONJAIDPRODUCTOID_LONJAID_2);

		sb.append(_FINDER_COLUMN_LONJAIDPRODUCTOID_PRODUCTOID_2);

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
			sb.append(PrecioLonjaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(lonjaId);

		queryPos.add(productoId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(precioLonja)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PrecioLonja> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the precio lonjas where lonjaId = &#63; and productoId = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 */
	@Override
	public void removeBylonjaIdProductoId(long lonjaId, long productoId) {
		for (PrecioLonja precioLonja :
				findBylonjaIdProductoId(
					lonjaId, productoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(precioLonja);
		}
	}

	/**
	 * Returns the number of precio lonjas where lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @return the number of matching precio lonjas
	 */
	@Override
	public int countBylonjaIdProductoId(long lonjaId, long productoId) {
		FinderPath finderPath = _finderPathCountBylonjaIdProductoId;

		Object[] finderArgs = new Object[] {lonjaId, productoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRECIOLONJA_WHERE);

			sb.append(_FINDER_COLUMN_LONJAIDPRODUCTOID_LONJAID_2);

			sb.append(_FINDER_COLUMN_LONJAIDPRODUCTOID_PRODUCTOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lonjaId);

				queryPos.add(productoId);

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

	private static final String _FINDER_COLUMN_LONJAIDPRODUCTOID_LONJAID_2 =
		"precioLonja.lonjaId = ? AND ";

	private static final String _FINDER_COLUMN_LONJAIDPRODUCTOID_PRODUCTOID_2 =
		"precioLonja.productoId = ?";

	private FinderPath _finderPathWithPaginationFindBylonjaIdFecha;
	private FinderPath _finderPathWithoutPaginationFindBylonjaIdFecha;
	private FinderPath _finderPathCountBylonjaIdFecha;

	/**
	 * Returns all the precio lonjas where lonjaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @return the matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaIdFecha(long lonjaId, Date fecha) {
		return findBylonjaIdFecha(
			lonjaId, fecha, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the precio lonjas where lonjaId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @return the range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaIdFecha(
		long lonjaId, Date fecha, int start, int end) {

		return findBylonjaIdFecha(lonjaId, fecha, start, end, null);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaIdFecha(
		long lonjaId, Date fecha, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return findBylonjaIdFecha(
			lonjaId, fecha, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaIdFecha(
		long lonjaId, Date fecha, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBylonjaIdFecha;
				finderArgs = new Object[] {lonjaId, _getTime(fecha)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBylonjaIdFecha;
			finderArgs = new Object[] {
				lonjaId, _getTime(fecha), start, end, orderByComparator
			};
		}

		List<PrecioLonja> list = null;

		if (useFinderCache) {
			list = (List<PrecioLonja>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PrecioLonja precioLonja : list) {
					if ((lonjaId != precioLonja.getLonjaId()) ||
						!Objects.equals(fecha, precioLonja.getFecha())) {

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

			sb.append(_SQL_SELECT_PRECIOLONJA_WHERE);

			sb.append(_FINDER_COLUMN_LONJAIDFECHA_LONJAID_2);

			boolean bindFecha = false;

			if (fecha == null) {
				sb.append(_FINDER_COLUMN_LONJAIDFECHA_FECHA_1);
			}
			else {
				bindFecha = true;

				sb.append(_FINDER_COLUMN_LONJAIDFECHA_FECHA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PrecioLonjaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lonjaId);

				if (bindFecha) {
					queryPos.add(new Timestamp(fecha.getTime()));
				}

				list = (List<PrecioLonja>)QueryUtil.list(
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
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja findBylonjaIdFecha_First(
			long lonjaId, Date fecha,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = fetchBylonjaIdFecha_First(
			lonjaId, fecha, orderByComparator);

		if (precioLonja != null) {
			return precioLonja;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lonjaId=");
		sb.append(lonjaId);

		sb.append(", fecha=");
		sb.append(fecha);

		sb.append("}");

		throw new NoSuchPrecioLonjaException(sb.toString());
	}

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja fetchBylonjaIdFecha_First(
		long lonjaId, Date fecha,
		OrderByComparator<PrecioLonja> orderByComparator) {

		List<PrecioLonja> list = findBylonjaIdFecha(
			lonjaId, fecha, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja findBylonjaIdFecha_Last(
			long lonjaId, Date fecha,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = fetchBylonjaIdFecha_Last(
			lonjaId, fecha, orderByComparator);

		if (precioLonja != null) {
			return precioLonja;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lonjaId=");
		sb.append(lonjaId);

		sb.append(", fecha=");
		sb.append(fecha);

		sb.append("}");

		throw new NoSuchPrecioLonjaException(sb.toString());
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja fetchBylonjaIdFecha_Last(
		long lonjaId, Date fecha,
		OrderByComparator<PrecioLonja> orderByComparator) {

		int count = countBylonjaIdFecha(lonjaId, fecha);

		if (count == 0) {
			return null;
		}

		List<PrecioLonja> list = findBylonjaIdFecha(
			lonjaId, fecha, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the precio lonjas before and after the current precio lonja in the ordered set where lonjaId = &#63; and fecha = &#63;.
	 *
	 * @param entityId the primary key of the current precio lonja
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	@Override
	public PrecioLonja[] findBylonjaIdFecha_PrevAndNext(
			long entityId, long lonjaId, Date fecha,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			PrecioLonja[] array = new PrecioLonjaImpl[3];

			array[0] = getBylonjaIdFecha_PrevAndNext(
				session, precioLonja, lonjaId, fecha, orderByComparator, true);

			array[1] = precioLonja;

			array[2] = getBylonjaIdFecha_PrevAndNext(
				session, precioLonja, lonjaId, fecha, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PrecioLonja getBylonjaIdFecha_PrevAndNext(
		Session session, PrecioLonja precioLonja, long lonjaId, Date fecha,
		OrderByComparator<PrecioLonja> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PRECIOLONJA_WHERE);

		sb.append(_FINDER_COLUMN_LONJAIDFECHA_LONJAID_2);

		boolean bindFecha = false;

		if (fecha == null) {
			sb.append(_FINDER_COLUMN_LONJAIDFECHA_FECHA_1);
		}
		else {
			bindFecha = true;

			sb.append(_FINDER_COLUMN_LONJAIDFECHA_FECHA_2);
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
			sb.append(PrecioLonjaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(lonjaId);

		if (bindFecha) {
			queryPos.add(new Timestamp(fecha.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(precioLonja)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PrecioLonja> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the precio lonjas where lonjaId = &#63; and fecha = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 */
	@Override
	public void removeBylonjaIdFecha(long lonjaId, Date fecha) {
		for (PrecioLonja precioLonja :
				findBylonjaIdFecha(
					lonjaId, fecha, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(precioLonja);
		}
	}

	/**
	 * Returns the number of precio lonjas where lonjaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param fecha the fecha
	 * @return the number of matching precio lonjas
	 */
	@Override
	public int countBylonjaIdFecha(long lonjaId, Date fecha) {
		FinderPath finderPath = _finderPathCountBylonjaIdFecha;

		Object[] finderArgs = new Object[] {lonjaId, _getTime(fecha)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRECIOLONJA_WHERE);

			sb.append(_FINDER_COLUMN_LONJAIDFECHA_LONJAID_2);

			boolean bindFecha = false;

			if (fecha == null) {
				sb.append(_FINDER_COLUMN_LONJAIDFECHA_FECHA_1);
			}
			else {
				bindFecha = true;

				sb.append(_FINDER_COLUMN_LONJAIDFECHA_FECHA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lonjaId);

				if (bindFecha) {
					queryPos.add(new Timestamp(fecha.getTime()));
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

	private static final String _FINDER_COLUMN_LONJAIDFECHA_LONJAID_2 =
		"precioLonja.lonjaId = ? AND ";

	private static final String _FINDER_COLUMN_LONJAIDFECHA_FECHA_1 =
		"precioLonja.fecha IS NULL";

	private static final String _FINDER_COLUMN_LONJAIDFECHA_FECHA_2 =
		"precioLonja.fecha = ?";

	private FinderPath _finderPathWithPaginationFindBylonjaIdGrupoIdFecha;
	private FinderPath _finderPathWithoutPaginationFindBylonjaIdGrupoIdFecha;
	private FinderPath _finderPathCountBylonjaIdGrupoIdFecha;

	/**
	 * Returns all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @return the matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaIdGrupoIdFecha(
		long lonjaId, long grupoId, Date fecha) {

		return findBylonjaIdGrupoIdFecha(
			lonjaId, grupoId, fecha, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @return the range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaIdGrupoIdFecha(
		long lonjaId, long grupoId, Date fecha, int start, int end) {

		return findBylonjaIdGrupoIdFecha(
			lonjaId, grupoId, fecha, start, end, null);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaIdGrupoIdFecha(
		long lonjaId, long grupoId, Date fecha, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator) {

		return findBylonjaIdGrupoIdFecha(
			lonjaId, grupoId, fecha, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaIdGrupoIdFecha(
		long lonjaId, long grupoId, Date fecha, int start, int end,
		OrderByComparator<PrecioLonja> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBylonjaIdGrupoIdFecha;
				finderArgs = new Object[] {lonjaId, grupoId, _getTime(fecha)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBylonjaIdGrupoIdFecha;
			finderArgs = new Object[] {
				lonjaId, grupoId, _getTime(fecha), start, end, orderByComparator
			};
		}

		List<PrecioLonja> list = null;

		if (useFinderCache) {
			list = (List<PrecioLonja>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PrecioLonja precioLonja : list) {
					if ((lonjaId != precioLonja.getLonjaId()) ||
						(grupoId != precioLonja.getGrupoId()) ||
						!Objects.equals(fecha, precioLonja.getFecha())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_PRECIOLONJA_WHERE);

			sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDFECHA_LONJAID_2);

			sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDFECHA_GRUPOID_2);

			boolean bindFecha = false;

			if (fecha == null) {
				sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDFECHA_FECHA_1);
			}
			else {
				bindFecha = true;

				sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDFECHA_FECHA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PrecioLonjaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lonjaId);

				queryPos.add(grupoId);

				if (bindFecha) {
					queryPos.add(new Timestamp(fecha.getTime()));
				}

				list = (List<PrecioLonja>)QueryUtil.list(
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
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja findBylonjaIdGrupoIdFecha_First(
			long lonjaId, long grupoId, Date fecha,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = fetchBylonjaIdGrupoIdFecha_First(
			lonjaId, grupoId, fecha, orderByComparator);

		if (precioLonja != null) {
			return precioLonja;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lonjaId=");
		sb.append(lonjaId);

		sb.append(", grupoId=");
		sb.append(grupoId);

		sb.append(", fecha=");
		sb.append(fecha);

		sb.append("}");

		throw new NoSuchPrecioLonjaException(sb.toString());
	}

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja fetchBylonjaIdGrupoIdFecha_First(
		long lonjaId, long grupoId, Date fecha,
		OrderByComparator<PrecioLonja> orderByComparator) {

		List<PrecioLonja> list = findBylonjaIdGrupoIdFecha(
			lonjaId, grupoId, fecha, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja findBylonjaIdGrupoIdFecha_Last(
			long lonjaId, long grupoId, Date fecha,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = fetchBylonjaIdGrupoIdFecha_Last(
			lonjaId, grupoId, fecha, orderByComparator);

		if (precioLonja != null) {
			return precioLonja;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lonjaId=");
		sb.append(lonjaId);

		sb.append(", grupoId=");
		sb.append(grupoId);

		sb.append(", fecha=");
		sb.append(fecha);

		sb.append("}");

		throw new NoSuchPrecioLonjaException(sb.toString());
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja fetchBylonjaIdGrupoIdFecha_Last(
		long lonjaId, long grupoId, Date fecha,
		OrderByComparator<PrecioLonja> orderByComparator) {

		int count = countBylonjaIdGrupoIdFecha(lonjaId, grupoId, fecha);

		if (count == 0) {
			return null;
		}

		List<PrecioLonja> list = findBylonjaIdGrupoIdFecha(
			lonjaId, grupoId, fecha, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the precio lonjas before and after the current precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * @param entityId the primary key of the current precio lonja
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	@Override
	public PrecioLonja[] findBylonjaIdGrupoIdFecha_PrevAndNext(
			long entityId, long lonjaId, long grupoId, Date fecha,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			PrecioLonja[] array = new PrecioLonjaImpl[3];

			array[0] = getBylonjaIdGrupoIdFecha_PrevAndNext(
				session, precioLonja, lonjaId, grupoId, fecha,
				orderByComparator, true);

			array[1] = precioLonja;

			array[2] = getBylonjaIdGrupoIdFecha_PrevAndNext(
				session, precioLonja, lonjaId, grupoId, fecha,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PrecioLonja getBylonjaIdGrupoIdFecha_PrevAndNext(
		Session session, PrecioLonja precioLonja, long lonjaId, long grupoId,
		Date fecha, OrderByComparator<PrecioLonja> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_PRECIOLONJA_WHERE);

		sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDFECHA_LONJAID_2);

		sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDFECHA_GRUPOID_2);

		boolean bindFecha = false;

		if (fecha == null) {
			sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDFECHA_FECHA_1);
		}
		else {
			bindFecha = true;

			sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDFECHA_FECHA_2);
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
			sb.append(PrecioLonjaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(lonjaId);

		queryPos.add(grupoId);

		if (bindFecha) {
			queryPos.add(new Timestamp(fecha.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(precioLonja)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PrecioLonja> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and fecha = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 */
	@Override
	public void removeBylonjaIdGrupoIdFecha(
		long lonjaId, long grupoId, Date fecha) {

		for (PrecioLonja precioLonja :
				findBylonjaIdGrupoIdFecha(
					lonjaId, grupoId, fecha, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(precioLonja);
		}
	}

	/**
	 * Returns the number of precio lonjas where lonjaId = &#63; and grupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param fecha the fecha
	 * @return the number of matching precio lonjas
	 */
	@Override
	public int countBylonjaIdGrupoIdFecha(
		long lonjaId, long grupoId, Date fecha) {

		FinderPath finderPath = _finderPathCountBylonjaIdGrupoIdFecha;

		Object[] finderArgs = new Object[] {lonjaId, grupoId, _getTime(fecha)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_PRECIOLONJA_WHERE);

			sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDFECHA_LONJAID_2);

			sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDFECHA_GRUPOID_2);

			boolean bindFecha = false;

			if (fecha == null) {
				sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDFECHA_FECHA_1);
			}
			else {
				bindFecha = true;

				sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDFECHA_FECHA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lonjaId);

				queryPos.add(grupoId);

				if (bindFecha) {
					queryPos.add(new Timestamp(fecha.getTime()));
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

	private static final String _FINDER_COLUMN_LONJAIDGRUPOIDFECHA_LONJAID_2 =
		"precioLonja.lonjaId = ? AND ";

	private static final String _FINDER_COLUMN_LONJAIDGRUPOIDFECHA_GRUPOID_2 =
		"precioLonja.grupoId = ? AND ";

	private static final String _FINDER_COLUMN_LONJAIDGRUPOIDFECHA_FECHA_1 =
		"precioLonja.fecha IS NULL";

	private static final String _FINDER_COLUMN_LONJAIDGRUPOIDFECHA_FECHA_2 =
		"precioLonja.fecha = ?";

	private FinderPath
		_finderPathWithPaginationFindBylonjaIdGrupoIdSubGrupoIdFecha;
	private FinderPath
		_finderPathWithoutPaginationFindBylonjaIdGrupoIdSubGrupoIdFecha;
	private FinderPath _finderPathCountBylonjaIdGrupoIdSubGrupoIdFecha;

	/**
	 * Returns all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @return the matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaIdGrupoIdSubGrupoIdFecha(
		long lonjaId, long grupoId, long subGrupoId, Date fecha) {

		return findBylonjaIdGrupoIdSubGrupoIdFecha(
			lonjaId, grupoId, subGrupoId, fecha, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @return the range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaIdGrupoIdSubGrupoIdFecha(
		long lonjaId, long grupoId, long subGrupoId, Date fecha, int start,
		int end) {

		return findBylonjaIdGrupoIdSubGrupoIdFecha(
			lonjaId, grupoId, subGrupoId, fecha, start, end, null);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaIdGrupoIdSubGrupoIdFecha(
		long lonjaId, long grupoId, long subGrupoId, Date fecha, int start,
		int end, OrderByComparator<PrecioLonja> orderByComparator) {

		return findBylonjaIdGrupoIdSubGrupoIdFecha(
			lonjaId, grupoId, subGrupoId, fecha, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaIdGrupoIdSubGrupoIdFecha(
		long lonjaId, long grupoId, long subGrupoId, Date fecha, int start,
		int end, OrderByComparator<PrecioLonja> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBylonjaIdGrupoIdSubGrupoIdFecha;
				finderArgs = new Object[] {
					lonjaId, grupoId, subGrupoId, _getTime(fecha)
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBylonjaIdGrupoIdSubGrupoIdFecha;
			finderArgs = new Object[] {
				lonjaId, grupoId, subGrupoId, _getTime(fecha), start, end,
				orderByComparator
			};
		}

		List<PrecioLonja> list = null;

		if (useFinderCache) {
			list = (List<PrecioLonja>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PrecioLonja precioLonja : list) {
					if ((lonjaId != precioLonja.getLonjaId()) ||
						(grupoId != precioLonja.getGrupoId()) ||
						(subGrupoId != precioLonja.getSubGrupoId()) ||
						!Objects.equals(fecha, precioLonja.getFecha())) {

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
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(6);
			}

			sb.append(_SQL_SELECT_PRECIOLONJA_WHERE);

			sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDFECHA_LONJAID_2);

			sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDFECHA_GRUPOID_2);

			sb.append(
				_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDFECHA_SUBGRUPOID_2);

			boolean bindFecha = false;

			if (fecha == null) {
				sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDFECHA_FECHA_1);
			}
			else {
				bindFecha = true;

				sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDFECHA_FECHA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PrecioLonjaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lonjaId);

				queryPos.add(grupoId);

				queryPos.add(subGrupoId);

				if (bindFecha) {
					queryPos.add(new Timestamp(fecha.getTime()));
				}

				list = (List<PrecioLonja>)QueryUtil.list(
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
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja findBylonjaIdGrupoIdSubGrupoIdFecha_First(
			long lonjaId, long grupoId, long subGrupoId, Date fecha,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = fetchBylonjaIdGrupoIdSubGrupoIdFecha_First(
			lonjaId, grupoId, subGrupoId, fecha, orderByComparator);

		if (precioLonja != null) {
			return precioLonja;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lonjaId=");
		sb.append(lonjaId);

		sb.append(", grupoId=");
		sb.append(grupoId);

		sb.append(", subGrupoId=");
		sb.append(subGrupoId);

		sb.append(", fecha=");
		sb.append(fecha);

		sb.append("}");

		throw new NoSuchPrecioLonjaException(sb.toString());
	}

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja fetchBylonjaIdGrupoIdSubGrupoIdFecha_First(
		long lonjaId, long grupoId, long subGrupoId, Date fecha,
		OrderByComparator<PrecioLonja> orderByComparator) {

		List<PrecioLonja> list = findBylonjaIdGrupoIdSubGrupoIdFecha(
			lonjaId, grupoId, subGrupoId, fecha, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja findBylonjaIdGrupoIdSubGrupoIdFecha_Last(
			long lonjaId, long grupoId, long subGrupoId, Date fecha,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = fetchBylonjaIdGrupoIdSubGrupoIdFecha_Last(
			lonjaId, grupoId, subGrupoId, fecha, orderByComparator);

		if (precioLonja != null) {
			return precioLonja;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lonjaId=");
		sb.append(lonjaId);

		sb.append(", grupoId=");
		sb.append(grupoId);

		sb.append(", subGrupoId=");
		sb.append(subGrupoId);

		sb.append(", fecha=");
		sb.append(fecha);

		sb.append("}");

		throw new NoSuchPrecioLonjaException(sb.toString());
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja fetchBylonjaIdGrupoIdSubGrupoIdFecha_Last(
		long lonjaId, long grupoId, long subGrupoId, Date fecha,
		OrderByComparator<PrecioLonja> orderByComparator) {

		int count = countBylonjaIdGrupoIdSubGrupoIdFecha(
			lonjaId, grupoId, subGrupoId, fecha);

		if (count == 0) {
			return null;
		}

		List<PrecioLonja> list = findBylonjaIdGrupoIdSubGrupoIdFecha(
			lonjaId, grupoId, subGrupoId, fecha, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the precio lonjas before and after the current precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * @param entityId the primary key of the current precio lonja
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	@Override
	public PrecioLonja[] findBylonjaIdGrupoIdSubGrupoIdFecha_PrevAndNext(
			long entityId, long lonjaId, long grupoId, long subGrupoId,
			Date fecha, OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			PrecioLonja[] array = new PrecioLonjaImpl[3];

			array[0] = getBylonjaIdGrupoIdSubGrupoIdFecha_PrevAndNext(
				session, precioLonja, lonjaId, grupoId, subGrupoId, fecha,
				orderByComparator, true);

			array[1] = precioLonja;

			array[2] = getBylonjaIdGrupoIdSubGrupoIdFecha_PrevAndNext(
				session, precioLonja, lonjaId, grupoId, subGrupoId, fecha,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PrecioLonja getBylonjaIdGrupoIdSubGrupoIdFecha_PrevAndNext(
		Session session, PrecioLonja precioLonja, long lonjaId, long grupoId,
		long subGrupoId, Date fecha,
		OrderByComparator<PrecioLonja> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_PRECIOLONJA_WHERE);

		sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDFECHA_LONJAID_2);

		sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDFECHA_GRUPOID_2);

		sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDFECHA_SUBGRUPOID_2);

		boolean bindFecha = false;

		if (fecha == null) {
			sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDFECHA_FECHA_1);
		}
		else {
			bindFecha = true;

			sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDFECHA_FECHA_2);
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
			sb.append(PrecioLonjaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(lonjaId);

		queryPos.add(grupoId);

		queryPos.add(subGrupoId);

		if (bindFecha) {
			queryPos.add(new Timestamp(fecha.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(precioLonja)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PrecioLonja> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 */
	@Override
	public void removeBylonjaIdGrupoIdSubGrupoIdFecha(
		long lonjaId, long grupoId, long subGrupoId, Date fecha) {

		for (PrecioLonja precioLonja :
				findBylonjaIdGrupoIdSubGrupoIdFecha(
					lonjaId, grupoId, subGrupoId, fecha, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(precioLonja);
		}
	}

	/**
	 * Returns the number of precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param fecha the fecha
	 * @return the number of matching precio lonjas
	 */
	@Override
	public int countBylonjaIdGrupoIdSubGrupoIdFecha(
		long lonjaId, long grupoId, long subGrupoId, Date fecha) {

		FinderPath finderPath = _finderPathCountBylonjaIdGrupoIdSubGrupoIdFecha;

		Object[] finderArgs = new Object[] {
			lonjaId, grupoId, subGrupoId, _getTime(fecha)
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_PRECIOLONJA_WHERE);

			sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDFECHA_LONJAID_2);

			sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDFECHA_GRUPOID_2);

			sb.append(
				_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDFECHA_SUBGRUPOID_2);

			boolean bindFecha = false;

			if (fecha == null) {
				sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDFECHA_FECHA_1);
			}
			else {
				bindFecha = true;

				sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDFECHA_FECHA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lonjaId);

				queryPos.add(grupoId);

				queryPos.add(subGrupoId);

				if (bindFecha) {
					queryPos.add(new Timestamp(fecha.getTime()));
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

	private static final String
		_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDFECHA_LONJAID_2 =
			"precioLonja.lonjaId = ? AND ";

	private static final String
		_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDFECHA_GRUPOID_2 =
			"precioLonja.grupoId = ? AND ";

	private static final String
		_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDFECHA_SUBGRUPOID_2 =
			"precioLonja.subGrupoId = ? AND ";

	private static final String
		_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDFECHA_FECHA_1 =
			"precioLonja.fecha IS NULL";

	private static final String
		_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDFECHA_FECHA_2 =
			"precioLonja.fecha = ?";

	private FinderPath
		_finderPathWithPaginationFindBylonjaIdGrupoIdSubGrupoIdAreaIdFecha;
	private FinderPath
		_finderPathWithoutPaginationFindBylonjaIdGrupoIdSubGrupoIdAreaIdFecha;
	private FinderPath _finderPathCountBylonjaIdGrupoIdSubGrupoIdAreaIdFecha;

	/**
	 * Returns all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 * @return the matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
		long lonjaId, long grupoId, long subGrupoId, long areaId, Date fecha) {

		return findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
			lonjaId, grupoId, subGrupoId, areaId, fecha, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @return the range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
		long lonjaId, long grupoId, long subGrupoId, long areaId, Date fecha,
		int start, int end) {

		return findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
			lonjaId, grupoId, subGrupoId, areaId, fecha, start, end, null);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
		long lonjaId, long grupoId, long subGrupoId, long areaId, Date fecha,
		int start, int end, OrderByComparator<PrecioLonja> orderByComparator) {

		return findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
			lonjaId, grupoId, subGrupoId, areaId, fecha, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching precio lonjas
	 */
	@Override
	public List<PrecioLonja> findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
		long lonjaId, long grupoId, long subGrupoId, long areaId, Date fecha,
		int start, int end, OrderByComparator<PrecioLonja> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBylonjaIdGrupoIdSubGrupoIdAreaIdFecha;
				finderArgs = new Object[] {
					lonjaId, grupoId, subGrupoId, areaId, _getTime(fecha)
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindBylonjaIdGrupoIdSubGrupoIdAreaIdFecha;
			finderArgs = new Object[] {
				lonjaId, grupoId, subGrupoId, areaId, _getTime(fecha), start,
				end, orderByComparator
			};
		}

		List<PrecioLonja> list = null;

		if (useFinderCache) {
			list = (List<PrecioLonja>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PrecioLonja precioLonja : list) {
					if ((lonjaId != precioLonja.getLonjaId()) ||
						(grupoId != precioLonja.getGrupoId()) ||
						(subGrupoId != precioLonja.getSubGrupoId()) ||
						(areaId != precioLonja.getAreaId()) ||
						!Objects.equals(fecha, precioLonja.getFecha())) {

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
					7 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(7);
			}

			sb.append(_SQL_SELECT_PRECIOLONJA_WHERE);

			sb.append(
				_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_LONJAID_2);

			sb.append(
				_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_GRUPOID_2);

			sb.append(
				_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_SUBGRUPOID_2);

			sb.append(
				_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_AREAID_2);

			boolean bindFecha = false;

			if (fecha == null) {
				sb.append(
					_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_FECHA_1);
			}
			else {
				bindFecha = true;

				sb.append(
					_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_FECHA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PrecioLonjaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lonjaId);

				queryPos.add(grupoId);

				queryPos.add(subGrupoId);

				queryPos.add(areaId);

				if (bindFecha) {
					queryPos.add(new Timestamp(fecha.getTime()));
				}

				list = (List<PrecioLonja>)QueryUtil.list(
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
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_First(
			long lonjaId, long grupoId, long subGrupoId, long areaId,
			Date fecha, OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja =
			fetchBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_First(
				lonjaId, grupoId, subGrupoId, areaId, fecha, orderByComparator);

		if (precioLonja != null) {
			return precioLonja;
		}

		StringBundler sb = new StringBundler(12);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lonjaId=");
		sb.append(lonjaId);

		sb.append(", grupoId=");
		sb.append(grupoId);

		sb.append(", subGrupoId=");
		sb.append(subGrupoId);

		sb.append(", areaId=");
		sb.append(areaId);

		sb.append(", fecha=");
		sb.append(fecha);

		sb.append("}");

		throw new NoSuchPrecioLonjaException(sb.toString());
	}

	/**
	 * Returns the first precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja fetchBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_First(
		long lonjaId, long grupoId, long subGrupoId, long areaId, Date fecha,
		OrderByComparator<PrecioLonja> orderByComparator) {

		List<PrecioLonja> list = findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
			lonjaId, grupoId, subGrupoId, areaId, fecha, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja
	 * @throws NoSuchPrecioLonjaException if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_Last(
			long lonjaId, long grupoId, long subGrupoId, long areaId,
			Date fecha, OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja =
			fetchBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_Last(
				lonjaId, grupoId, subGrupoId, areaId, fecha, orderByComparator);

		if (precioLonja != null) {
			return precioLonja;
		}

		StringBundler sb = new StringBundler(12);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lonjaId=");
		sb.append(lonjaId);

		sb.append(", grupoId=");
		sb.append(grupoId);

		sb.append(", subGrupoId=");
		sb.append(subGrupoId);

		sb.append(", areaId=");
		sb.append(areaId);

		sb.append(", fecha=");
		sb.append(fecha);

		sb.append("}");

		throw new NoSuchPrecioLonjaException(sb.toString());
	}

	/**
	 * Returns the last precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching precio lonja, or <code>null</code> if a matching precio lonja could not be found
	 */
	@Override
	public PrecioLonja fetchBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_Last(
		long lonjaId, long grupoId, long subGrupoId, long areaId, Date fecha,
		OrderByComparator<PrecioLonja> orderByComparator) {

		int count = countBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
			lonjaId, grupoId, subGrupoId, areaId, fecha);

		if (count == 0) {
			return null;
		}

		List<PrecioLonja> list = findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
			lonjaId, grupoId, subGrupoId, areaId, fecha, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the precio lonjas before and after the current precio lonja in the ordered set where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63;.
	 *
	 * @param entityId the primary key of the current precio lonja
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	@Override
	public PrecioLonja[] findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_PrevAndNext(
			long entityId, long lonjaId, long grupoId, long subGrupoId,
			long areaId, Date fecha,
			OrderByComparator<PrecioLonja> orderByComparator)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			PrecioLonja[] array = new PrecioLonjaImpl[3];

			array[0] = getBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_PrevAndNext(
				session, precioLonja, lonjaId, grupoId, subGrupoId, areaId,
				fecha, orderByComparator, true);

			array[1] = precioLonja;

			array[2] = getBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_PrevAndNext(
				session, precioLonja, lonjaId, grupoId, subGrupoId, areaId,
				fecha, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PrecioLonja getBylonjaIdGrupoIdSubGrupoIdAreaIdFecha_PrevAndNext(
		Session session, PrecioLonja precioLonja, long lonjaId, long grupoId,
		long subGrupoId, long areaId, Date fecha,
		OrderByComparator<PrecioLonja> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				8 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(7);
		}

		sb.append(_SQL_SELECT_PRECIOLONJA_WHERE);

		sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_LONJAID_2);

		sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_GRUPOID_2);

		sb.append(
			_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_SUBGRUPOID_2);

		sb.append(_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_AREAID_2);

		boolean bindFecha = false;

		if (fecha == null) {
			sb.append(
				_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_FECHA_1);
		}
		else {
			bindFecha = true;

			sb.append(
				_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_FECHA_2);
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
			sb.append(PrecioLonjaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(lonjaId);

		queryPos.add(grupoId);

		queryPos.add(subGrupoId);

		queryPos.add(areaId);

		if (bindFecha) {
			queryPos.add(new Timestamp(fecha.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(precioLonja)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PrecioLonja> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63; from the database.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 */
	@Override
	public void removeBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
		long lonjaId, long grupoId, long subGrupoId, long areaId, Date fecha) {

		for (PrecioLonja precioLonja :
				findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
					lonjaId, grupoId, subGrupoId, areaId, fecha,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(precioLonja);
		}
	}

	/**
	 * Returns the number of precio lonjas where lonjaId = &#63; and grupoId = &#63; and subGrupoId = &#63; and areaId = &#63; and fecha = &#63;.
	 *
	 * @param lonjaId the lonja ID
	 * @param grupoId the grupo ID
	 * @param subGrupoId the sub grupo ID
	 * @param areaId the area ID
	 * @param fecha the fecha
	 * @return the number of matching precio lonjas
	 */
	@Override
	public int countBylonjaIdGrupoIdSubGrupoIdAreaIdFecha(
		long lonjaId, long grupoId, long subGrupoId, long areaId, Date fecha) {

		FinderPath finderPath =
			_finderPathCountBylonjaIdGrupoIdSubGrupoIdAreaIdFecha;

		Object[] finderArgs = new Object[] {
			lonjaId, grupoId, subGrupoId, areaId, _getTime(fecha)
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_COUNT_PRECIOLONJA_WHERE);

			sb.append(
				_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_LONJAID_2);

			sb.append(
				_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_GRUPOID_2);

			sb.append(
				_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_SUBGRUPOID_2);

			sb.append(
				_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_AREAID_2);

			boolean bindFecha = false;

			if (fecha == null) {
				sb.append(
					_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_FECHA_1);
			}
			else {
				bindFecha = true;

				sb.append(
					_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_FECHA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lonjaId);

				queryPos.add(grupoId);

				queryPos.add(subGrupoId);

				queryPos.add(areaId);

				if (bindFecha) {
					queryPos.add(new Timestamp(fecha.getTime()));
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

	private static final String
		_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_LONJAID_2 =
			"precioLonja.lonjaId = ? AND ";

	private static final String
		_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_GRUPOID_2 =
			"precioLonja.grupoId = ? AND ";

	private static final String
		_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_SUBGRUPOID_2 =
			"precioLonja.subGrupoId = ? AND ";

	private static final String
		_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_AREAID_2 =
			"precioLonja.areaId = ? AND ";

	private static final String
		_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_FECHA_1 =
			"precioLonja.fecha IS NULL";

	private static final String
		_FINDER_COLUMN_LONJAIDGRUPOIDSUBGRUPOIDAREAIDFECHA_FECHA_2 =
			"precioLonja.fecha = ?";

	public PrecioLonjaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PrecioLonja.class);

		setModelImplClass(PrecioLonjaImpl.class);
		setModelPKClass(long.class);

		setTable(PrecioLonjaTable.INSTANCE);
	}

	/**
	 * Caches the precio lonja in the entity cache if it is enabled.
	 *
	 * @param precioLonja the precio lonja
	 */
	@Override
	public void cacheResult(PrecioLonja precioLonja) {
		entityCache.putResult(
			PrecioLonjaImpl.class, precioLonja.getPrimaryKey(), precioLonja);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the precio lonjas in the entity cache if it is enabled.
	 *
	 * @param precioLonjas the precio lonjas
	 */
	@Override
	public void cacheResult(List<PrecioLonja> precioLonjas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (precioLonjas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PrecioLonja precioLonja : precioLonjas) {
			if (entityCache.getResult(
					PrecioLonjaImpl.class, precioLonja.getPrimaryKey()) ==
						null) {

				cacheResult(precioLonja);
			}
		}
	}

	/**
	 * Clears the cache for all precio lonjas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PrecioLonjaImpl.class);

		finderCache.clearCache(PrecioLonjaImpl.class);
	}

	/**
	 * Clears the cache for the precio lonja.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PrecioLonja precioLonja) {
		entityCache.removeResult(PrecioLonjaImpl.class, precioLonja);
	}

	@Override
	public void clearCache(List<PrecioLonja> precioLonjas) {
		for (PrecioLonja precioLonja : precioLonjas) {
			entityCache.removeResult(PrecioLonjaImpl.class, precioLonja);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PrecioLonjaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PrecioLonjaImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new precio lonja with the primary key. Does not add the precio lonja to the database.
	 *
	 * @param entityId the primary key for the new precio lonja
	 * @return the new precio lonja
	 */
	@Override
	public PrecioLonja create(long entityId) {
		PrecioLonja precioLonja = new PrecioLonjaImpl();

		precioLonja.setNew(true);
		precioLonja.setPrimaryKey(entityId);

		String uuid = PortalUUIDUtil.generate();

		precioLonja.setUuid(uuid);

		return precioLonja;
	}

	/**
	 * Removes the precio lonja with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the precio lonja
	 * @return the precio lonja that was removed
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	@Override
	public PrecioLonja remove(long entityId) throws NoSuchPrecioLonjaException {
		return remove((Serializable)entityId);
	}

	/**
	 * Removes the precio lonja with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the precio lonja
	 * @return the precio lonja that was removed
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	@Override
	public PrecioLonja remove(Serializable primaryKey)
		throws NoSuchPrecioLonjaException {

		Session session = null;

		try {
			session = openSession();

			PrecioLonja precioLonja = (PrecioLonja)session.get(
				PrecioLonjaImpl.class, primaryKey);

			if (precioLonja == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPrecioLonjaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(precioLonja);
		}
		catch (NoSuchPrecioLonjaException noSuchEntityException) {
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
	protected PrecioLonja removeImpl(PrecioLonja precioLonja) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(precioLonja)) {
				precioLonja = (PrecioLonja)session.get(
					PrecioLonjaImpl.class, precioLonja.getPrimaryKeyObj());
			}

			if (precioLonja != null) {
				session.delete(precioLonja);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (precioLonja != null) {
			clearCache(precioLonja);
		}

		return precioLonja;
	}

	@Override
	public PrecioLonja updateImpl(PrecioLonja precioLonja) {
		boolean isNew = precioLonja.isNew();

		if (!(precioLonja instanceof PrecioLonjaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(precioLonja.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(precioLonja);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in precioLonja proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PrecioLonja implementation " +
					precioLonja.getClass());
		}

		PrecioLonjaModelImpl precioLonjaModelImpl =
			(PrecioLonjaModelImpl)precioLonja;

		if (Validator.isNull(precioLonja.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			precioLonja.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (precioLonja.getCreateDate() == null)) {
			if (serviceContext == null) {
				precioLonja.setCreateDate(date);
			}
			else {
				precioLonja.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!precioLonjaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				precioLonja.setModifiedDate(date);
			}
			else {
				precioLonja.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(precioLonja);
			}
			else {
				precioLonja = (PrecioLonja)session.merge(precioLonja);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PrecioLonjaImpl.class, precioLonjaModelImpl, false, true);

		if (isNew) {
			precioLonja.setNew(false);
		}

		precioLonja.resetOriginalValues();

		return precioLonja;
	}

	/**
	 * Returns the precio lonja with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the precio lonja
	 * @return the precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	@Override
	public PrecioLonja findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPrecioLonjaException {

		PrecioLonja precioLonja = fetchByPrimaryKey(primaryKey);

		if (precioLonja == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPrecioLonjaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return precioLonja;
	}

	/**
	 * Returns the precio lonja with the primary key or throws a <code>NoSuchPrecioLonjaException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the precio lonja
	 * @return the precio lonja
	 * @throws NoSuchPrecioLonjaException if a precio lonja with the primary key could not be found
	 */
	@Override
	public PrecioLonja findByPrimaryKey(long entityId)
		throws NoSuchPrecioLonjaException {

		return findByPrimaryKey((Serializable)entityId);
	}

	/**
	 * Returns the precio lonja with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the precio lonja
	 * @return the precio lonja, or <code>null</code> if a precio lonja with the primary key could not be found
	 */
	@Override
	public PrecioLonja fetchByPrimaryKey(long entityId) {
		return fetchByPrimaryKey((Serializable)entityId);
	}

	/**
	 * Returns all the precio lonjas.
	 *
	 * @return the precio lonjas
	 */
	@Override
	public List<PrecioLonja> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the precio lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @return the range of precio lonjas
	 */
	@Override
	public List<PrecioLonja> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the precio lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of precio lonjas
	 */
	@Override
	public List<PrecioLonja> findAll(
		int start, int end, OrderByComparator<PrecioLonja> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the precio lonjas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PrecioLonjaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of precio lonjas
	 * @param end the upper bound of the range of precio lonjas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of precio lonjas
	 */
	@Override
	public List<PrecioLonja> findAll(
		int start, int end, OrderByComparator<PrecioLonja> orderByComparator,
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

		List<PrecioLonja> list = null;

		if (useFinderCache) {
			list = (List<PrecioLonja>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRECIOLONJA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRECIOLONJA;

				sql = sql.concat(PrecioLonjaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PrecioLonja>)QueryUtil.list(
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
	 * Removes all the precio lonjas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PrecioLonja precioLonja : findAll()) {
			remove(precioLonja);
		}
	}

	/**
	 * Returns the number of precio lonjas.
	 *
	 * @return the number of precio lonjas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PRECIOLONJA);

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
		return _SQL_SELECT_PRECIOLONJA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PrecioLonjaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the precio lonja persistence.
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

		_finderPathWithPaginationFindByproductoId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByproductoId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"productoId"}, true);

		_finderPathWithoutPaginationFindByproductoId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByproductoId",
			new String[] {Long.class.getName()}, new String[] {"productoId"},
			true);

		_finderPathCountByproductoId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByproductoId",
			new String[] {Long.class.getName()}, new String[] {"productoId"},
			false);

		_finderPathWithPaginationFindBylonjaIdProductoId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylonjaIdProductoId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"lonjaId", "productoId"}, true);

		_finderPathWithoutPaginationFindBylonjaIdProductoId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBylonjaIdProductoId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"lonjaId", "productoId"}, true);

		_finderPathCountBylonjaIdProductoId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBylonjaIdProductoId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"lonjaId", "productoId"}, false);

		_finderPathWithPaginationFindBylonjaIdFecha = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylonjaIdFecha",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"lonjaId", "fecha"}, true);

		_finderPathWithoutPaginationFindBylonjaIdFecha = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylonjaIdFecha",
			new String[] {Long.class.getName(), Date.class.getName()},
			new String[] {"lonjaId", "fecha"}, true);

		_finderPathCountBylonjaIdFecha = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylonjaIdFecha",
			new String[] {Long.class.getName(), Date.class.getName()},
			new String[] {"lonjaId", "fecha"}, false);

		_finderPathWithPaginationFindBylonjaIdGrupoIdFecha = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylonjaIdGrupoIdFecha",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"lonjaId", "grupoId", "fecha"}, true);

		_finderPathWithoutPaginationFindBylonjaIdGrupoIdFecha = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBylonjaIdGrupoIdFecha",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			},
			new String[] {"lonjaId", "grupoId", "fecha"}, true);

		_finderPathCountBylonjaIdGrupoIdFecha = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBylonjaIdGrupoIdFecha",
			new String[] {
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			},
			new String[] {"lonjaId", "grupoId", "fecha"}, false);

		_finderPathWithPaginationFindBylonjaIdGrupoIdSubGrupoIdFecha =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBylonjaIdGrupoIdSubGrupoIdFecha",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName(), Date.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"lonjaId", "grupoId", "subGrupoId", "fecha"},
				true);

		_finderPathWithoutPaginationFindBylonjaIdGrupoIdSubGrupoIdFecha =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBylonjaIdGrupoIdSubGrupoIdFecha",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName(), Date.class.getName()
				},
				new String[] {"lonjaId", "grupoId", "subGrupoId", "fecha"},
				true);

		_finderPathCountBylonjaIdGrupoIdSubGrupoIdFecha = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBylonjaIdGrupoIdSubGrupoIdFecha",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Date.class.getName()
			},
			new String[] {"lonjaId", "grupoId", "subGrupoId", "fecha"}, false);

		_finderPathWithPaginationFindBylonjaIdGrupoIdSubGrupoIdAreaIdFecha =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName(), Long.class.getName(),
					Date.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {
					"lonjaId", "grupoId", "subGrupoId", "areaId", "fecha"
				},
				true);

		_finderPathWithoutPaginationFindBylonjaIdGrupoIdSubGrupoIdAreaIdFecha =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBylonjaIdGrupoIdSubGrupoIdAreaIdFecha",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName(), Long.class.getName(),
					Date.class.getName()
				},
				new String[] {
					"lonjaId", "grupoId", "subGrupoId", "areaId", "fecha"
				},
				true);

		_finderPathCountBylonjaIdGrupoIdSubGrupoIdAreaIdFecha = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBylonjaIdGrupoIdSubGrupoIdAreaIdFecha",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Long.class.getName(), Date.class.getName()
			},
			new String[] {
				"lonjaId", "grupoId", "subGrupoId", "areaId", "fecha"
			},
			false);

		PrecioLonjaUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		PrecioLonjaUtil.setPersistence(null);

		entityCache.removeCache(PrecioLonjaImpl.class.getName());
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

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_PRECIOLONJA =
		"SELECT precioLonja FROM PrecioLonja precioLonja";

	private static final String _SQL_SELECT_PRECIOLONJA_WHERE =
		"SELECT precioLonja FROM PrecioLonja precioLonja WHERE ";

	private static final String _SQL_COUNT_PRECIOLONJA =
		"SELECT COUNT(precioLonja) FROM PrecioLonja precioLonja";

	private static final String _SQL_COUNT_PRECIOLONJA_WHERE =
		"SELECT COUNT(precioLonja) FROM PrecioLonja precioLonja WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "precioLonja.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PrecioLonja exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PrecioLonja exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PrecioLonjaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}