/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.tu.explotacion.sb.service.persistence.impl;

import avanis.tu.explotacion.sb.exception.NoSuchAlertasException;
import avanis.tu.explotacion.sb.model.Alertas;
import avanis.tu.explotacion.sb.model.AlertasTable;
import avanis.tu.explotacion.sb.model.impl.AlertasImpl;
import avanis.tu.explotacion.sb.model.impl.AlertasModelImpl;
import avanis.tu.explotacion.sb.service.persistence.AlertasPersistence;
import avanis.tu.explotacion.sb.service.persistence.AlertasUtil;
import avanis.tu.explotacion.sb.service.persistence.impl.constants.AVANIS_EXPLOTACIONPersistenceConstants;

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
 * The persistence implementation for the alertas service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AlertasPersistence.class)
public class AlertasPersistenceImpl
	extends BasePersistenceImpl<Alertas> implements AlertasPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AlertasUtil</code> to access the alertas persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AlertasImpl.class.getName();

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
	 * Returns all the alertases where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching alertases
	 */
	@Override
	public List<Alertas> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the alertases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @return the range of matching alertases
	 */
	@Override
	public List<Alertas> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the alertases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching alertases
	 */
	@Override
	public List<Alertas> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Alertas> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the alertases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching alertases
	 */
	@Override
	public List<Alertas> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Alertas> orderByComparator, boolean useFinderCache) {

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

		List<Alertas> list = null;

		if (useFinderCache) {
			list = (List<Alertas>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Alertas alertas : list) {
					if (!uuid.equals(alertas.getUuid())) {
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

			sb.append(_SQL_SELECT_ALERTAS_WHERE);

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
				sb.append(AlertasModelImpl.ORDER_BY_JPQL);
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

				list = (List<Alertas>)QueryUtil.list(
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
	 * Returns the first alertas in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching alertas
	 * @throws NoSuchAlertasException if a matching alertas could not be found
	 */
	@Override
	public Alertas findByUuid_First(
			String uuid, OrderByComparator<Alertas> orderByComparator)
		throws NoSuchAlertasException {

		Alertas alertas = fetchByUuid_First(uuid, orderByComparator);

		if (alertas != null) {
			return alertas;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAlertasException(sb.toString());
	}

	/**
	 * Returns the first alertas in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching alertas, or <code>null</code> if a matching alertas could not be found
	 */
	@Override
	public Alertas fetchByUuid_First(
		String uuid, OrderByComparator<Alertas> orderByComparator) {

		List<Alertas> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last alertas in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching alertas
	 * @throws NoSuchAlertasException if a matching alertas could not be found
	 */
	@Override
	public Alertas findByUuid_Last(
			String uuid, OrderByComparator<Alertas> orderByComparator)
		throws NoSuchAlertasException {

		Alertas alertas = fetchByUuid_Last(uuid, orderByComparator);

		if (alertas != null) {
			return alertas;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAlertasException(sb.toString());
	}

	/**
	 * Returns the last alertas in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching alertas, or <code>null</code> if a matching alertas could not be found
	 */
	@Override
	public Alertas fetchByUuid_Last(
		String uuid, OrderByComparator<Alertas> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Alertas> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the alertases before and after the current alertas in the ordered set where uuid = &#63;.
	 *
	 * @param alertaId the primary key of the current alertas
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next alertas
	 * @throws NoSuchAlertasException if a alertas with the primary key could not be found
	 */
	@Override
	public Alertas[] findByUuid_PrevAndNext(
			long alertaId, String uuid,
			OrderByComparator<Alertas> orderByComparator)
		throws NoSuchAlertasException {

		uuid = Objects.toString(uuid, "");

		Alertas alertas = findByPrimaryKey(alertaId);

		Session session = null;

		try {
			session = openSession();

			Alertas[] array = new AlertasImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, alertas, uuid, orderByComparator, true);

			array[1] = alertas;

			array[2] = getByUuid_PrevAndNext(
				session, alertas, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Alertas getByUuid_PrevAndNext(
		Session session, Alertas alertas, String uuid,
		OrderByComparator<Alertas> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ALERTAS_WHERE);

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
			sb.append(AlertasModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(alertas)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Alertas> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the alertases where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Alertas alertas :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(alertas);
		}
	}

	/**
	 * Returns the number of alertases where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching alertases
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ALERTAS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "alertas.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(alertas.uuid IS NULL OR alertas.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByuserId;
	private FinderPath _finderPathWithoutPaginationFindByuserId;
	private FinderPath _finderPathCountByuserId;

	/**
	 * Returns all the alertases where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching alertases
	 */
	@Override
	public List<Alertas> findByuserId(long userId) {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the alertases where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @return the range of matching alertases
	 */
	@Override
	public List<Alertas> findByuserId(long userId, int start, int end) {
		return findByuserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the alertases where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching alertases
	 */
	@Override
	public List<Alertas> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Alertas> orderByComparator) {

		return findByuserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the alertases where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching alertases
	 */
	@Override
	public List<Alertas> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Alertas> orderByComparator, boolean useFinderCache) {

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

		List<Alertas> list = null;

		if (useFinderCache) {
			list = (List<Alertas>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Alertas alertas : list) {
					if (userId != alertas.getUserId()) {
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

			sb.append(_SQL_SELECT_ALERTAS_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AlertasModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<Alertas>)QueryUtil.list(
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
	 * Returns the first alertas in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching alertas
	 * @throws NoSuchAlertasException if a matching alertas could not be found
	 */
	@Override
	public Alertas findByuserId_First(
			long userId, OrderByComparator<Alertas> orderByComparator)
		throws NoSuchAlertasException {

		Alertas alertas = fetchByuserId_First(userId, orderByComparator);

		if (alertas != null) {
			return alertas;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchAlertasException(sb.toString());
	}

	/**
	 * Returns the first alertas in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching alertas, or <code>null</code> if a matching alertas could not be found
	 */
	@Override
	public Alertas fetchByuserId_First(
		long userId, OrderByComparator<Alertas> orderByComparator) {

		List<Alertas> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last alertas in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching alertas
	 * @throws NoSuchAlertasException if a matching alertas could not be found
	 */
	@Override
	public Alertas findByuserId_Last(
			long userId, OrderByComparator<Alertas> orderByComparator)
		throws NoSuchAlertasException {

		Alertas alertas = fetchByuserId_Last(userId, orderByComparator);

		if (alertas != null) {
			return alertas;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchAlertasException(sb.toString());
	}

	/**
	 * Returns the last alertas in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching alertas, or <code>null</code> if a matching alertas could not be found
	 */
	@Override
	public Alertas fetchByuserId_Last(
		long userId, OrderByComparator<Alertas> orderByComparator) {

		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<Alertas> list = findByuserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the alertases before and after the current alertas in the ordered set where userId = &#63;.
	 *
	 * @param alertaId the primary key of the current alertas
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next alertas
	 * @throws NoSuchAlertasException if a alertas with the primary key could not be found
	 */
	@Override
	public Alertas[] findByuserId_PrevAndNext(
			long alertaId, long userId,
			OrderByComparator<Alertas> orderByComparator)
		throws NoSuchAlertasException {

		Alertas alertas = findByPrimaryKey(alertaId);

		Session session = null;

		try {
			session = openSession();

			Alertas[] array = new AlertasImpl[3];

			array[0] = getByuserId_PrevAndNext(
				session, alertas, userId, orderByComparator, true);

			array[1] = alertas;

			array[2] = getByuserId_PrevAndNext(
				session, alertas, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Alertas getByuserId_PrevAndNext(
		Session session, Alertas alertas, long userId,
		OrderByComparator<Alertas> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ALERTAS_WHERE);

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
			sb.append(AlertasModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(alertas)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Alertas> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the alertases where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByuserId(long userId) {
		for (Alertas alertas :
				findByuserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(alertas);
		}
	}

	/**
	 * Returns the number of alertases where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching alertases
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = _finderPathCountByuserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ALERTAS_WHERE);

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
		"alertas.userId = ?";

	private FinderPath _finderPathWithPaginationFindByuserIdReaded;
	private FinderPath _finderPathWithoutPaginationFindByuserIdReaded;
	private FinderPath _finderPathCountByuserIdReaded;

	/**
	 * Returns all the alertases where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @return the matching alertases
	 */
	@Override
	public List<Alertas> findByuserIdReaded(long userId, boolean readed) {
		return findByuserIdReaded(
			userId, readed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the alertases where userId = &#63; and readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @return the range of matching alertases
	 */
	@Override
	public List<Alertas> findByuserIdReaded(
		long userId, boolean readed, int start, int end) {

		return findByuserIdReaded(userId, readed, start, end, null);
	}

	/**
	 * Returns an ordered range of all the alertases where userId = &#63; and readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching alertases
	 */
	@Override
	public List<Alertas> findByuserIdReaded(
		long userId, boolean readed, int start, int end,
		OrderByComparator<Alertas> orderByComparator) {

		return findByuserIdReaded(
			userId, readed, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the alertases where userId = &#63; and readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching alertases
	 */
	@Override
	public List<Alertas> findByuserIdReaded(
		long userId, boolean readed, int start, int end,
		OrderByComparator<Alertas> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByuserIdReaded;
				finderArgs = new Object[] {userId, readed};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByuserIdReaded;
			finderArgs = new Object[] {
				userId, readed, start, end, orderByComparator
			};
		}

		List<Alertas> list = null;

		if (useFinderCache) {
			list = (List<Alertas>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Alertas alertas : list) {
					if ((userId != alertas.getUserId()) ||
						(readed != alertas.isReaded())) {

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

			sb.append(_SQL_SELECT_ALERTAS_WHERE);

			sb.append(_FINDER_COLUMN_USERIDREADED_USERID_2);

			sb.append(_FINDER_COLUMN_USERIDREADED_READED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AlertasModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(readed);

				list = (List<Alertas>)QueryUtil.list(
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
	 * Returns the first alertas in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching alertas
	 * @throws NoSuchAlertasException if a matching alertas could not be found
	 */
	@Override
	public Alertas findByuserIdReaded_First(
			long userId, boolean readed,
			OrderByComparator<Alertas> orderByComparator)
		throws NoSuchAlertasException {

		Alertas alertas = fetchByuserIdReaded_First(
			userId, readed, orderByComparator);

		if (alertas != null) {
			return alertas;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", readed=");
		sb.append(readed);

		sb.append("}");

		throw new NoSuchAlertasException(sb.toString());
	}

	/**
	 * Returns the first alertas in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching alertas, or <code>null</code> if a matching alertas could not be found
	 */
	@Override
	public Alertas fetchByuserIdReaded_First(
		long userId, boolean readed,
		OrderByComparator<Alertas> orderByComparator) {

		List<Alertas> list = findByuserIdReaded(
			userId, readed, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last alertas in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching alertas
	 * @throws NoSuchAlertasException if a matching alertas could not be found
	 */
	@Override
	public Alertas findByuserIdReaded_Last(
			long userId, boolean readed,
			OrderByComparator<Alertas> orderByComparator)
		throws NoSuchAlertasException {

		Alertas alertas = fetchByuserIdReaded_Last(
			userId, readed, orderByComparator);

		if (alertas != null) {
			return alertas;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", readed=");
		sb.append(readed);

		sb.append("}");

		throw new NoSuchAlertasException(sb.toString());
	}

	/**
	 * Returns the last alertas in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching alertas, or <code>null</code> if a matching alertas could not be found
	 */
	@Override
	public Alertas fetchByuserIdReaded_Last(
		long userId, boolean readed,
		OrderByComparator<Alertas> orderByComparator) {

		int count = countByuserIdReaded(userId, readed);

		if (count == 0) {
			return null;
		}

		List<Alertas> list = findByuserIdReaded(
			userId, readed, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the alertases before and after the current alertas in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param alertaId the primary key of the current alertas
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next alertas
	 * @throws NoSuchAlertasException if a alertas with the primary key could not be found
	 */
	@Override
	public Alertas[] findByuserIdReaded_PrevAndNext(
			long alertaId, long userId, boolean readed,
			OrderByComparator<Alertas> orderByComparator)
		throws NoSuchAlertasException {

		Alertas alertas = findByPrimaryKey(alertaId);

		Session session = null;

		try {
			session = openSession();

			Alertas[] array = new AlertasImpl[3];

			array[0] = getByuserIdReaded_PrevAndNext(
				session, alertas, userId, readed, orderByComparator, true);

			array[1] = alertas;

			array[2] = getByuserIdReaded_PrevAndNext(
				session, alertas, userId, readed, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Alertas getByuserIdReaded_PrevAndNext(
		Session session, Alertas alertas, long userId, boolean readed,
		OrderByComparator<Alertas> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ALERTAS_WHERE);

		sb.append(_FINDER_COLUMN_USERIDREADED_USERID_2);

		sb.append(_FINDER_COLUMN_USERIDREADED_READED_2);

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
			sb.append(AlertasModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		queryPos.add(readed);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(alertas)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Alertas> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the alertases where userId = &#63; and readed = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 */
	@Override
	public void removeByuserIdReaded(long userId, boolean readed) {
		for (Alertas alertas :
				findByuserIdReaded(
					userId, readed, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(alertas);
		}
	}

	/**
	 * Returns the number of alertases where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @return the number of matching alertases
	 */
	@Override
	public int countByuserIdReaded(long userId, boolean readed) {
		FinderPath finderPath = _finderPathCountByuserIdReaded;

		Object[] finderArgs = new Object[] {userId, readed};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ALERTAS_WHERE);

			sb.append(_FINDER_COLUMN_USERIDREADED_USERID_2);

			sb.append(_FINDER_COLUMN_USERIDREADED_READED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(readed);

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

	private static final String _FINDER_COLUMN_USERIDREADED_USERID_2 =
		"alertas.userId = ? AND ";

	private static final String _FINDER_COLUMN_USERIDREADED_READED_2 =
		"alertas.readed = ?";

	public AlertasPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Alertas.class);

		setModelImplClass(AlertasImpl.class);
		setModelPKClass(long.class);

		setTable(AlertasTable.INSTANCE);
	}

	/**
	 * Caches the alertas in the entity cache if it is enabled.
	 *
	 * @param alertas the alertas
	 */
	@Override
	public void cacheResult(Alertas alertas) {
		entityCache.putResult(
			AlertasImpl.class, alertas.getPrimaryKey(), alertas);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the alertases in the entity cache if it is enabled.
	 *
	 * @param alertases the alertases
	 */
	@Override
	public void cacheResult(List<Alertas> alertases) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (alertases.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Alertas alertas : alertases) {
			if (entityCache.getResult(
					AlertasImpl.class, alertas.getPrimaryKey()) == null) {

				cacheResult(alertas);
			}
		}
	}

	/**
	 * Clears the cache for all alertases.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AlertasImpl.class);

		finderCache.clearCache(AlertasImpl.class);
	}

	/**
	 * Clears the cache for the alertas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Alertas alertas) {
		entityCache.removeResult(AlertasImpl.class, alertas);
	}

	@Override
	public void clearCache(List<Alertas> alertases) {
		for (Alertas alertas : alertases) {
			entityCache.removeResult(AlertasImpl.class, alertas);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AlertasImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AlertasImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new alertas with the primary key. Does not add the alertas to the database.
	 *
	 * @param alertaId the primary key for the new alertas
	 * @return the new alertas
	 */
	@Override
	public Alertas create(long alertaId) {
		Alertas alertas = new AlertasImpl();

		alertas.setNew(true);
		alertas.setPrimaryKey(alertaId);

		String uuid = PortalUUIDUtil.generate();

		alertas.setUuid(uuid);

		return alertas;
	}

	/**
	 * Removes the alertas with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param alertaId the primary key of the alertas
	 * @return the alertas that was removed
	 * @throws NoSuchAlertasException if a alertas with the primary key could not be found
	 */
	@Override
	public Alertas remove(long alertaId) throws NoSuchAlertasException {
		return remove((Serializable)alertaId);
	}

	/**
	 * Removes the alertas with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the alertas
	 * @return the alertas that was removed
	 * @throws NoSuchAlertasException if a alertas with the primary key could not be found
	 */
	@Override
	public Alertas remove(Serializable primaryKey)
		throws NoSuchAlertasException {

		Session session = null;

		try {
			session = openSession();

			Alertas alertas = (Alertas)session.get(
				AlertasImpl.class, primaryKey);

			if (alertas == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAlertasException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(alertas);
		}
		catch (NoSuchAlertasException noSuchEntityException) {
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
	protected Alertas removeImpl(Alertas alertas) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(alertas)) {
				alertas = (Alertas)session.get(
					AlertasImpl.class, alertas.getPrimaryKeyObj());
			}

			if (alertas != null) {
				session.delete(alertas);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (alertas != null) {
			clearCache(alertas);
		}

		return alertas;
	}

	@Override
	public Alertas updateImpl(Alertas alertas) {
		boolean isNew = alertas.isNew();

		if (!(alertas instanceof AlertasModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(alertas.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(alertas);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in alertas proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Alertas implementation " +
					alertas.getClass());
		}

		AlertasModelImpl alertasModelImpl = (AlertasModelImpl)alertas;

		if (Validator.isNull(alertas.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			alertas.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (alertas.getCreateDate() == null)) {
			if (serviceContext == null) {
				alertas.setCreateDate(date);
			}
			else {
				alertas.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!alertasModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				alertas.setModifiedDate(date);
			}
			else {
				alertas.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(alertas);
			}
			else {
				alertas = (Alertas)session.merge(alertas);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(AlertasImpl.class, alertasModelImpl, false, true);

		if (isNew) {
			alertas.setNew(false);
		}

		alertas.resetOriginalValues();

		return alertas;
	}

	/**
	 * Returns the alertas with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the alertas
	 * @return the alertas
	 * @throws NoSuchAlertasException if a alertas with the primary key could not be found
	 */
	@Override
	public Alertas findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAlertasException {

		Alertas alertas = fetchByPrimaryKey(primaryKey);

		if (alertas == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAlertasException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return alertas;
	}

	/**
	 * Returns the alertas with the primary key or throws a <code>NoSuchAlertasException</code> if it could not be found.
	 *
	 * @param alertaId the primary key of the alertas
	 * @return the alertas
	 * @throws NoSuchAlertasException if a alertas with the primary key could not be found
	 */
	@Override
	public Alertas findByPrimaryKey(long alertaId)
		throws NoSuchAlertasException {

		return findByPrimaryKey((Serializable)alertaId);
	}

	/**
	 * Returns the alertas with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param alertaId the primary key of the alertas
	 * @return the alertas, or <code>null</code> if a alertas with the primary key could not be found
	 */
	@Override
	public Alertas fetchByPrimaryKey(long alertaId) {
		return fetchByPrimaryKey((Serializable)alertaId);
	}

	/**
	 * Returns all the alertases.
	 *
	 * @return the alertases
	 */
	@Override
	public List<Alertas> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the alertases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @return the range of alertases
	 */
	@Override
	public List<Alertas> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the alertases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of alertases
	 */
	@Override
	public List<Alertas> findAll(
		int start, int end, OrderByComparator<Alertas> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the alertases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AlertasModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of alertases
	 * @param end the upper bound of the range of alertases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of alertases
	 */
	@Override
	public List<Alertas> findAll(
		int start, int end, OrderByComparator<Alertas> orderByComparator,
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

		List<Alertas> list = null;

		if (useFinderCache) {
			list = (List<Alertas>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ALERTAS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ALERTAS;

				sql = sql.concat(AlertasModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Alertas>)QueryUtil.list(
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
	 * Removes all the alertases from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Alertas alertas : findAll()) {
			remove(alertas);
		}
	}

	/**
	 * Returns the number of alertases.
	 *
	 * @return the number of alertases
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ALERTAS);

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
		return "alertaId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ALERTAS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AlertasModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the alertas persistence.
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

		_finderPathWithPaginationFindByuserIdReaded = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserIdReaded",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"userId", "readed"}, true);

		_finderPathWithoutPaginationFindByuserIdReaded = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserIdReaded",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"userId", "readed"}, true);

		_finderPathCountByuserIdReaded = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserIdReaded",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"userId", "readed"}, false);

		AlertasUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AlertasUtil.setPersistence(null);

		entityCache.removeCache(AlertasImpl.class.getName());
	}

	@Override
	@Reference(
		target = AVANIS_EXPLOTACIONPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = AVANIS_EXPLOTACIONPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AVANIS_EXPLOTACIONPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ALERTAS =
		"SELECT alertas FROM Alertas alertas";

	private static final String _SQL_SELECT_ALERTAS_WHERE =
		"SELECT alertas FROM Alertas alertas WHERE ";

	private static final String _SQL_COUNT_ALERTAS =
		"SELECT COUNT(alertas) FROM Alertas alertas";

	private static final String _SQL_COUNT_ALERTAS_WHERE =
		"SELECT COUNT(alertas) FROM Alertas alertas WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "alertas.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Alertas exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Alertas exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AlertasPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}