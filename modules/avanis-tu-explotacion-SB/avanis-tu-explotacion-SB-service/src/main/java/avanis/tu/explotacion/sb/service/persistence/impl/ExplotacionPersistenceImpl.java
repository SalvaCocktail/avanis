/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.tu.explotacion.sb.service.persistence.impl;

import avanis.tu.explotacion.sb.exception.NoSuchExplotacionException;
import avanis.tu.explotacion.sb.model.Explotacion;
import avanis.tu.explotacion.sb.model.ExplotacionTable;
import avanis.tu.explotacion.sb.model.impl.ExplotacionImpl;
import avanis.tu.explotacion.sb.model.impl.ExplotacionModelImpl;
import avanis.tu.explotacion.sb.service.persistence.ExplotacionPersistence;
import avanis.tu.explotacion.sb.service.persistence.ExplotacionUtil;
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
 * The persistence implementation for the explotacion service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ExplotacionPersistence.class)
public class ExplotacionPersistenceImpl
	extends BasePersistenceImpl<Explotacion> implements ExplotacionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ExplotacionUtil</code> to access the explotacion persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ExplotacionImpl.class.getName();

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
	 * Returns all the explotacions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching explotacions
	 */
	@Override
	public List<Explotacion> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the explotacions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @return the range of matching explotacions
	 */
	@Override
	public List<Explotacion> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the explotacions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching explotacions
	 */
	@Override
	public List<Explotacion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Explotacion> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the explotacions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching explotacions
	 */
	@Override
	public List<Explotacion> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Explotacion> orderByComparator,
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

		List<Explotacion> list = null;

		if (useFinderCache) {
			list = (List<Explotacion>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Explotacion explotacion : list) {
					if (!uuid.equals(explotacion.getUuid())) {
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

			sb.append(_SQL_SELECT_EXPLOTACION_WHERE);

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
				sb.append(ExplotacionModelImpl.ORDER_BY_JPQL);
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

				list = (List<Explotacion>)QueryUtil.list(
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
	 * Returns the first explotacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	@Override
	public Explotacion findByUuid_First(
			String uuid, OrderByComparator<Explotacion> orderByComparator)
		throws NoSuchExplotacionException {

		Explotacion explotacion = fetchByUuid_First(uuid, orderByComparator);

		if (explotacion != null) {
			return explotacion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchExplotacionException(sb.toString());
	}

	/**
	 * Returns the first explotacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	@Override
	public Explotacion fetchByUuid_First(
		String uuid, OrderByComparator<Explotacion> orderByComparator) {

		List<Explotacion> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last explotacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	@Override
	public Explotacion findByUuid_Last(
			String uuid, OrderByComparator<Explotacion> orderByComparator)
		throws NoSuchExplotacionException {

		Explotacion explotacion = fetchByUuid_Last(uuid, orderByComparator);

		if (explotacion != null) {
			return explotacion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchExplotacionException(sb.toString());
	}

	/**
	 * Returns the last explotacion in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	@Override
	public Explotacion fetchByUuid_Last(
		String uuid, OrderByComparator<Explotacion> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Explotacion> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the explotacions before and after the current explotacion in the ordered set where uuid = &#63;.
	 *
	 * @param explotacionId the primary key of the current explotacion
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next explotacion
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	@Override
	public Explotacion[] findByUuid_PrevAndNext(
			long explotacionId, String uuid,
			OrderByComparator<Explotacion> orderByComparator)
		throws NoSuchExplotacionException {

		uuid = Objects.toString(uuid, "");

		Explotacion explotacion = findByPrimaryKey(explotacionId);

		Session session = null;

		try {
			session = openSession();

			Explotacion[] array = new ExplotacionImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, explotacion, uuid, orderByComparator, true);

			array[1] = explotacion;

			array[2] = getByUuid_PrevAndNext(
				session, explotacion, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Explotacion getByUuid_PrevAndNext(
		Session session, Explotacion explotacion, String uuid,
		OrderByComparator<Explotacion> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EXPLOTACION_WHERE);

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
			sb.append(ExplotacionModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(explotacion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Explotacion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the explotacions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Explotacion explotacion :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(explotacion);
		}
	}

	/**
	 * Returns the number of explotacions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching explotacions
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EXPLOTACION_WHERE);

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
		"explotacion.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(explotacion.uuid IS NULL OR explotacion.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByuserId;
	private FinderPath _finderPathWithoutPaginationFindByuserId;
	private FinderPath _finderPathCountByuserId;

	/**
	 * Returns all the explotacions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching explotacions
	 */
	@Override
	public List<Explotacion> findByuserId(long userId) {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the explotacions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @return the range of matching explotacions
	 */
	@Override
	public List<Explotacion> findByuserId(long userId, int start, int end) {
		return findByuserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the explotacions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching explotacions
	 */
	@Override
	public List<Explotacion> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Explotacion> orderByComparator) {

		return findByuserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the explotacions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching explotacions
	 */
	@Override
	public List<Explotacion> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Explotacion> orderByComparator,
		boolean useFinderCache) {

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

		List<Explotacion> list = null;

		if (useFinderCache) {
			list = (List<Explotacion>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Explotacion explotacion : list) {
					if (userId != explotacion.getUserId()) {
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

			sb.append(_SQL_SELECT_EXPLOTACION_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ExplotacionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<Explotacion>)QueryUtil.list(
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
	 * Returns the first explotacion in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	@Override
	public Explotacion findByuserId_First(
			long userId, OrderByComparator<Explotacion> orderByComparator)
		throws NoSuchExplotacionException {

		Explotacion explotacion = fetchByuserId_First(
			userId, orderByComparator);

		if (explotacion != null) {
			return explotacion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchExplotacionException(sb.toString());
	}

	/**
	 * Returns the first explotacion in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	@Override
	public Explotacion fetchByuserId_First(
		long userId, OrderByComparator<Explotacion> orderByComparator) {

		List<Explotacion> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last explotacion in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	@Override
	public Explotacion findByuserId_Last(
			long userId, OrderByComparator<Explotacion> orderByComparator)
		throws NoSuchExplotacionException {

		Explotacion explotacion = fetchByuserId_Last(userId, orderByComparator);

		if (explotacion != null) {
			return explotacion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchExplotacionException(sb.toString());
	}

	/**
	 * Returns the last explotacion in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	@Override
	public Explotacion fetchByuserId_Last(
		long userId, OrderByComparator<Explotacion> orderByComparator) {

		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<Explotacion> list = findByuserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the explotacions before and after the current explotacion in the ordered set where userId = &#63;.
	 *
	 * @param explotacionId the primary key of the current explotacion
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next explotacion
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	@Override
	public Explotacion[] findByuserId_PrevAndNext(
			long explotacionId, long userId,
			OrderByComparator<Explotacion> orderByComparator)
		throws NoSuchExplotacionException {

		Explotacion explotacion = findByPrimaryKey(explotacionId);

		Session session = null;

		try {
			session = openSession();

			Explotacion[] array = new ExplotacionImpl[3];

			array[0] = getByuserId_PrevAndNext(
				session, explotacion, userId, orderByComparator, true);

			array[1] = explotacion;

			array[2] = getByuserId_PrevAndNext(
				session, explotacion, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Explotacion getByuserId_PrevAndNext(
		Session session, Explotacion explotacion, long userId,
		OrderByComparator<Explotacion> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EXPLOTACION_WHERE);

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
			sb.append(ExplotacionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(explotacion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Explotacion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the explotacions where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByuserId(long userId) {
		for (Explotacion explotacion :
				findByuserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(explotacion);
		}
	}

	/**
	 * Returns the number of explotacions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching explotacions
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = _finderPathCountByuserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EXPLOTACION_WHERE);

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
		"explotacion.userId = ?";

	private FinderPath _finderPathWithPaginationFindByuserIdReaded;
	private FinderPath _finderPathWithoutPaginationFindByuserIdReaded;
	private FinderPath _finderPathCountByuserIdReaded;

	/**
	 * Returns all the explotacions where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @return the matching explotacions
	 */
	@Override
	public List<Explotacion> findByuserIdReaded(long userId, boolean readed) {
		return findByuserIdReaded(
			userId, readed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the explotacions where userId = &#63; and readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @return the range of matching explotacions
	 */
	@Override
	public List<Explotacion> findByuserIdReaded(
		long userId, boolean readed, int start, int end) {

		return findByuserIdReaded(userId, readed, start, end, null);
	}

	/**
	 * Returns an ordered range of all the explotacions where userId = &#63; and readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching explotacions
	 */
	@Override
	public List<Explotacion> findByuserIdReaded(
		long userId, boolean readed, int start, int end,
		OrderByComparator<Explotacion> orderByComparator) {

		return findByuserIdReaded(
			userId, readed, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the explotacions where userId = &#63; and readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching explotacions
	 */
	@Override
	public List<Explotacion> findByuserIdReaded(
		long userId, boolean readed, int start, int end,
		OrderByComparator<Explotacion> orderByComparator,
		boolean useFinderCache) {

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

		List<Explotacion> list = null;

		if (useFinderCache) {
			list = (List<Explotacion>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Explotacion explotacion : list) {
					if ((userId != explotacion.getUserId()) ||
						(readed != explotacion.isReaded())) {

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

			sb.append(_SQL_SELECT_EXPLOTACION_WHERE);

			sb.append(_FINDER_COLUMN_USERIDREADED_USERID_2);

			sb.append(_FINDER_COLUMN_USERIDREADED_READED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ExplotacionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(readed);

				list = (List<Explotacion>)QueryUtil.list(
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
	 * Returns the first explotacion in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	@Override
	public Explotacion findByuserIdReaded_First(
			long userId, boolean readed,
			OrderByComparator<Explotacion> orderByComparator)
		throws NoSuchExplotacionException {

		Explotacion explotacion = fetchByuserIdReaded_First(
			userId, readed, orderByComparator);

		if (explotacion != null) {
			return explotacion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", readed=");
		sb.append(readed);

		sb.append("}");

		throw new NoSuchExplotacionException(sb.toString());
	}

	/**
	 * Returns the first explotacion in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	@Override
	public Explotacion fetchByuserIdReaded_First(
		long userId, boolean readed,
		OrderByComparator<Explotacion> orderByComparator) {

		List<Explotacion> list = findByuserIdReaded(
			userId, readed, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last explotacion in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	@Override
	public Explotacion findByuserIdReaded_Last(
			long userId, boolean readed,
			OrderByComparator<Explotacion> orderByComparator)
		throws NoSuchExplotacionException {

		Explotacion explotacion = fetchByuserIdReaded_Last(
			userId, readed, orderByComparator);

		if (explotacion != null) {
			return explotacion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", readed=");
		sb.append(readed);

		sb.append("}");

		throw new NoSuchExplotacionException(sb.toString());
	}

	/**
	 * Returns the last explotacion in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	@Override
	public Explotacion fetchByuserIdReaded_Last(
		long userId, boolean readed,
		OrderByComparator<Explotacion> orderByComparator) {

		int count = countByuserIdReaded(userId, readed);

		if (count == 0) {
			return null;
		}

		List<Explotacion> list = findByuserIdReaded(
			userId, readed, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the explotacions before and after the current explotacion in the ordered set where userId = &#63; and readed = &#63;.
	 *
	 * @param explotacionId the primary key of the current explotacion
	 * @param userId the user ID
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next explotacion
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	@Override
	public Explotacion[] findByuserIdReaded_PrevAndNext(
			long explotacionId, long userId, boolean readed,
			OrderByComparator<Explotacion> orderByComparator)
		throws NoSuchExplotacionException {

		Explotacion explotacion = findByPrimaryKey(explotacionId);

		Session session = null;

		try {
			session = openSession();

			Explotacion[] array = new ExplotacionImpl[3];

			array[0] = getByuserIdReaded_PrevAndNext(
				session, explotacion, userId, readed, orderByComparator, true);

			array[1] = explotacion;

			array[2] = getByuserIdReaded_PrevAndNext(
				session, explotacion, userId, readed, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Explotacion getByuserIdReaded_PrevAndNext(
		Session session, Explotacion explotacion, long userId, boolean readed,
		OrderByComparator<Explotacion> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_EXPLOTACION_WHERE);

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
			sb.append(ExplotacionModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(explotacion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Explotacion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the explotacions where userId = &#63; and readed = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 */
	@Override
	public void removeByuserIdReaded(long userId, boolean readed) {
		for (Explotacion explotacion :
				findByuserIdReaded(
					userId, readed, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(explotacion);
		}
	}

	/**
	 * Returns the number of explotacions where userId = &#63; and readed = &#63;.
	 *
	 * @param userId the user ID
	 * @param readed the readed
	 * @return the number of matching explotacions
	 */
	@Override
	public int countByuserIdReaded(long userId, boolean readed) {
		FinderPath finderPath = _finderPathCountByuserIdReaded;

		Object[] finderArgs = new Object[] {userId, readed};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EXPLOTACION_WHERE);

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
		"explotacion.userId = ? AND ";

	private static final String _FINDER_COLUMN_USERIDREADED_READED_2 =
		"explotacion.readed = ?";

	private FinderPath _finderPathFetchByexternalCodeReferenceAndUserId;
	private FinderPath _finderPathCountByexternalCodeReferenceAndUserId;

	/**
	 * Returns the explotacion where externalCodeReference = &#63; and userId = &#63; or throws a <code>NoSuchExplotacionException</code> if it could not be found.
	 *
	 * @param externalCodeReference the external code reference
	 * @param userId the user ID
	 * @return the matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	@Override
	public Explotacion findByexternalCodeReferenceAndUserId(
			String externalCodeReference, long userId)
		throws NoSuchExplotacionException {

		Explotacion explotacion = fetchByexternalCodeReferenceAndUserId(
			externalCodeReference, userId);

		if (explotacion == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("externalCodeReference=");
			sb.append(externalCodeReference);

			sb.append(", userId=");
			sb.append(userId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchExplotacionException(sb.toString());
		}

		return explotacion;
	}

	/**
	 * Returns the explotacion where externalCodeReference = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalCodeReference the external code reference
	 * @param userId the user ID
	 * @return the matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	@Override
	public Explotacion fetchByexternalCodeReferenceAndUserId(
		String externalCodeReference, long userId) {

		return fetchByexternalCodeReferenceAndUserId(
			externalCodeReference, userId, true);
	}

	/**
	 * Returns the explotacion where externalCodeReference = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalCodeReference the external code reference
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	@Override
	public Explotacion fetchByexternalCodeReferenceAndUserId(
		String externalCodeReference, long userId, boolean useFinderCache) {

		externalCodeReference = Objects.toString(externalCodeReference, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {externalCodeReference, userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByexternalCodeReferenceAndUserId, finderArgs,
				this);
		}

		if (result instanceof Explotacion) {
			Explotacion explotacion = (Explotacion)result;

			if (!Objects.equals(
					externalCodeReference,
					explotacion.getExternalCodeReference()) ||
				(userId != explotacion.getUserId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EXPLOTACION_WHERE);

			boolean bindExternalCodeReference = false;

			if (externalCodeReference.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_EXTERNALCODEREFERENCEANDUSERID_EXTERNALCODEREFERENCE_3);
			}
			else {
				bindExternalCodeReference = true;

				sb.append(
					_FINDER_COLUMN_EXTERNALCODEREFERENCEANDUSERID_EXTERNALCODEREFERENCE_2);
			}

			sb.append(_FINDER_COLUMN_EXTERNALCODEREFERENCEANDUSERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindExternalCodeReference) {
					queryPos.add(externalCodeReference);
				}

				queryPos.add(userId);

				List<Explotacion> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByexternalCodeReferenceAndUserId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									externalCodeReference, userId
								};
							}

							_log.warn(
								"ExplotacionPersistenceImpl.fetchByexternalCodeReferenceAndUserId(String, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Explotacion explotacion = list.get(0);

					result = explotacion;

					cacheResult(explotacion);
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
			return (Explotacion)result;
		}
	}

	/**
	 * Removes the explotacion where externalCodeReference = &#63; and userId = &#63; from the database.
	 *
	 * @param externalCodeReference the external code reference
	 * @param userId the user ID
	 * @return the explotacion that was removed
	 */
	@Override
	public Explotacion removeByexternalCodeReferenceAndUserId(
			String externalCodeReference, long userId)
		throws NoSuchExplotacionException {

		Explotacion explotacion = findByexternalCodeReferenceAndUserId(
			externalCodeReference, userId);

		return remove(explotacion);
	}

	/**
	 * Returns the number of explotacions where externalCodeReference = &#63; and userId = &#63;.
	 *
	 * @param externalCodeReference the external code reference
	 * @param userId the user ID
	 * @return the number of matching explotacions
	 */
	@Override
	public int countByexternalCodeReferenceAndUserId(
		String externalCodeReference, long userId) {

		externalCodeReference = Objects.toString(externalCodeReference, "");

		FinderPath finderPath =
			_finderPathCountByexternalCodeReferenceAndUserId;

		Object[] finderArgs = new Object[] {externalCodeReference, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EXPLOTACION_WHERE);

			boolean bindExternalCodeReference = false;

			if (externalCodeReference.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_EXTERNALCODEREFERENCEANDUSERID_EXTERNALCODEREFERENCE_3);
			}
			else {
				bindExternalCodeReference = true;

				sb.append(
					_FINDER_COLUMN_EXTERNALCODEREFERENCEANDUSERID_EXTERNALCODEREFERENCE_2);
			}

			sb.append(_FINDER_COLUMN_EXTERNALCODEREFERENCEANDUSERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindExternalCodeReference) {
					queryPos.add(externalCodeReference);
				}

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

	private static final String
		_FINDER_COLUMN_EXTERNALCODEREFERENCEANDUSERID_EXTERNALCODEREFERENCE_2 =
			"explotacion.externalCodeReference = ? AND ";

	private static final String
		_FINDER_COLUMN_EXTERNALCODEREFERENCEANDUSERID_EXTERNALCODEREFERENCE_3 =
			"(explotacion.externalCodeReference IS NULL OR explotacion.externalCodeReference = '') AND ";

	private static final String
		_FINDER_COLUMN_EXTERNALCODEREFERENCEANDUSERID_USERID_2 =
			"explotacion.userId = ?";

	private FinderPath _finderPathWithPaginationFindByisMainAndUser;
	private FinderPath _finderPathWithoutPaginationFindByisMainAndUser;
	private FinderPath _finderPathCountByisMainAndUser;

	/**
	 * Returns all the explotacions where isMain = &#63; and userId = &#63;.
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @return the matching explotacions
	 */
	@Override
	public List<Explotacion> findByisMainAndUser(boolean isMain, long userId) {
		return findByisMainAndUser(
			isMain, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the explotacions where isMain = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @return the range of matching explotacions
	 */
	@Override
	public List<Explotacion> findByisMainAndUser(
		boolean isMain, long userId, int start, int end) {

		return findByisMainAndUser(isMain, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the explotacions where isMain = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching explotacions
	 */
	@Override
	public List<Explotacion> findByisMainAndUser(
		boolean isMain, long userId, int start, int end,
		OrderByComparator<Explotacion> orderByComparator) {

		return findByisMainAndUser(
			isMain, userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the explotacions where isMain = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching explotacions
	 */
	@Override
	public List<Explotacion> findByisMainAndUser(
		boolean isMain, long userId, int start, int end,
		OrderByComparator<Explotacion> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByisMainAndUser;
				finderArgs = new Object[] {isMain, userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByisMainAndUser;
			finderArgs = new Object[] {
				isMain, userId, start, end, orderByComparator
			};
		}

		List<Explotacion> list = null;

		if (useFinderCache) {
			list = (List<Explotacion>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Explotacion explotacion : list) {
					if ((isMain != explotacion.isIsMain()) ||
						(userId != explotacion.getUserId())) {

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

			sb.append(_SQL_SELECT_EXPLOTACION_WHERE);

			sb.append(_FINDER_COLUMN_ISMAINANDUSER_ISMAIN_2);

			sb.append(_FINDER_COLUMN_ISMAINANDUSER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ExplotacionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isMain);

				queryPos.add(userId);

				list = (List<Explotacion>)QueryUtil.list(
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
	 * Returns the first explotacion in the ordered set where isMain = &#63; and userId = &#63;.
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	@Override
	public Explotacion findByisMainAndUser_First(
			boolean isMain, long userId,
			OrderByComparator<Explotacion> orderByComparator)
		throws NoSuchExplotacionException {

		Explotacion explotacion = fetchByisMainAndUser_First(
			isMain, userId, orderByComparator);

		if (explotacion != null) {
			return explotacion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isMain=");
		sb.append(isMain);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchExplotacionException(sb.toString());
	}

	/**
	 * Returns the first explotacion in the ordered set where isMain = &#63; and userId = &#63;.
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	@Override
	public Explotacion fetchByisMainAndUser_First(
		boolean isMain, long userId,
		OrderByComparator<Explotacion> orderByComparator) {

		List<Explotacion> list = findByisMainAndUser(
			isMain, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last explotacion in the ordered set where isMain = &#63; and userId = &#63;.
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	@Override
	public Explotacion findByisMainAndUser_Last(
			boolean isMain, long userId,
			OrderByComparator<Explotacion> orderByComparator)
		throws NoSuchExplotacionException {

		Explotacion explotacion = fetchByisMainAndUser_Last(
			isMain, userId, orderByComparator);

		if (explotacion != null) {
			return explotacion;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isMain=");
		sb.append(isMain);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchExplotacionException(sb.toString());
	}

	/**
	 * Returns the last explotacion in the ordered set where isMain = &#63; and userId = &#63;.
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	@Override
	public Explotacion fetchByisMainAndUser_Last(
		boolean isMain, long userId,
		OrderByComparator<Explotacion> orderByComparator) {

		int count = countByisMainAndUser(isMain, userId);

		if (count == 0) {
			return null;
		}

		List<Explotacion> list = findByisMainAndUser(
			isMain, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the explotacions before and after the current explotacion in the ordered set where isMain = &#63; and userId = &#63;.
	 *
	 * @param explotacionId the primary key of the current explotacion
	 * @param isMain the is main
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next explotacion
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	@Override
	public Explotacion[] findByisMainAndUser_PrevAndNext(
			long explotacionId, boolean isMain, long userId,
			OrderByComparator<Explotacion> orderByComparator)
		throws NoSuchExplotacionException {

		Explotacion explotacion = findByPrimaryKey(explotacionId);

		Session session = null;

		try {
			session = openSession();

			Explotacion[] array = new ExplotacionImpl[3];

			array[0] = getByisMainAndUser_PrevAndNext(
				session, explotacion, isMain, userId, orderByComparator, true);

			array[1] = explotacion;

			array[2] = getByisMainAndUser_PrevAndNext(
				session, explotacion, isMain, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Explotacion getByisMainAndUser_PrevAndNext(
		Session session, Explotacion explotacion, boolean isMain, long userId,
		OrderByComparator<Explotacion> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_EXPLOTACION_WHERE);

		sb.append(_FINDER_COLUMN_ISMAINANDUSER_ISMAIN_2);

		sb.append(_FINDER_COLUMN_ISMAINANDUSER_USERID_2);

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
			sb.append(ExplotacionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isMain);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(explotacion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Explotacion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the explotacions where isMain = &#63; and userId = &#63; from the database.
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 */
	@Override
	public void removeByisMainAndUser(boolean isMain, long userId) {
		for (Explotacion explotacion :
				findByisMainAndUser(
					isMain, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(explotacion);
		}
	}

	/**
	 * Returns the number of explotacions where isMain = &#63; and userId = &#63;.
	 *
	 * @param isMain the is main
	 * @param userId the user ID
	 * @return the number of matching explotacions
	 */
	@Override
	public int countByisMainAndUser(boolean isMain, long userId) {
		FinderPath finderPath = _finderPathCountByisMainAndUser;

		Object[] finderArgs = new Object[] {isMain, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EXPLOTACION_WHERE);

			sb.append(_FINDER_COLUMN_ISMAINANDUSER_ISMAIN_2);

			sb.append(_FINDER_COLUMN_ISMAINANDUSER_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isMain);

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

	private static final String _FINDER_COLUMN_ISMAINANDUSER_ISMAIN_2 =
		"explotacion.isMain = ? AND ";

	private static final String _FINDER_COLUMN_ISMAINANDUSER_USERID_2 =
		"explotacion.userId = ?";

	private FinderPath _finderPathFetchByidAndUserId;
	private FinderPath _finderPathCountByidAndUserId;

	/**
	 * Returns the explotacion where explotacionId = &#63; and userId = &#63; or throws a <code>NoSuchExplotacionException</code> if it could not be found.
	 *
	 * @param explotacionId the explotacion ID
	 * @param userId the user ID
	 * @return the matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	@Override
	public Explotacion findByidAndUserId(long explotacionId, long userId)
		throws NoSuchExplotacionException {

		Explotacion explotacion = fetchByidAndUserId(explotacionId, userId);

		if (explotacion == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("explotacionId=");
			sb.append(explotacionId);

			sb.append(", userId=");
			sb.append(userId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchExplotacionException(sb.toString());
		}

		return explotacion;
	}

	/**
	 * Returns the explotacion where explotacionId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param explotacionId the explotacion ID
	 * @param userId the user ID
	 * @return the matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	@Override
	public Explotacion fetchByidAndUserId(long explotacionId, long userId) {
		return fetchByidAndUserId(explotacionId, userId, true);
	}

	/**
	 * Returns the explotacion where explotacionId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param explotacionId the explotacion ID
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	@Override
	public Explotacion fetchByidAndUserId(
		long explotacionId, long userId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {explotacionId, userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByidAndUserId, finderArgs, this);
		}

		if (result instanceof Explotacion) {
			Explotacion explotacion = (Explotacion)result;

			if ((explotacionId != explotacion.getExplotacionId()) ||
				(userId != explotacion.getUserId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EXPLOTACION_WHERE);

			sb.append(_FINDER_COLUMN_IDANDUSERID_EXPLOTACIONID_2);

			sb.append(_FINDER_COLUMN_IDANDUSERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(explotacionId);

				queryPos.add(userId);

				List<Explotacion> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByidAndUserId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									explotacionId, userId
								};
							}

							_log.warn(
								"ExplotacionPersistenceImpl.fetchByidAndUserId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Explotacion explotacion = list.get(0);

					result = explotacion;

					cacheResult(explotacion);
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
			return (Explotacion)result;
		}
	}

	/**
	 * Removes the explotacion where explotacionId = &#63; and userId = &#63; from the database.
	 *
	 * @param explotacionId the explotacion ID
	 * @param userId the user ID
	 * @return the explotacion that was removed
	 */
	@Override
	public Explotacion removeByidAndUserId(long explotacionId, long userId)
		throws NoSuchExplotacionException {

		Explotacion explotacion = findByidAndUserId(explotacionId, userId);

		return remove(explotacion);
	}

	/**
	 * Returns the number of explotacions where explotacionId = &#63; and userId = &#63;.
	 *
	 * @param explotacionId the explotacion ID
	 * @param userId the user ID
	 * @return the number of matching explotacions
	 */
	@Override
	public int countByidAndUserId(long explotacionId, long userId) {
		FinderPath finderPath = _finderPathCountByidAndUserId;

		Object[] finderArgs = new Object[] {explotacionId, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EXPLOTACION_WHERE);

			sb.append(_FINDER_COLUMN_IDANDUSERID_EXPLOTACIONID_2);

			sb.append(_FINDER_COLUMN_IDANDUSERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(explotacionId);

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

	private static final String _FINDER_COLUMN_IDANDUSERID_EXPLOTACIONID_2 =
		"explotacion.explotacionId = ? AND ";

	private static final String _FINDER_COLUMN_IDANDUSERID_USERID_2 =
		"explotacion.userId = ?";

	private FinderPath _finderPathWithPaginationFindByreaded;
	private FinderPath _finderPathWithoutPaginationFindByreaded;
	private FinderPath _finderPathCountByreaded;

	/**
	 * Returns all the explotacions where readed = &#63;.
	 *
	 * @param readed the readed
	 * @return the matching explotacions
	 */
	@Override
	public List<Explotacion> findByreaded(boolean readed) {
		return findByreaded(readed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the explotacions where readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param readed the readed
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @return the range of matching explotacions
	 */
	@Override
	public List<Explotacion> findByreaded(boolean readed, int start, int end) {
		return findByreaded(readed, start, end, null);
	}

	/**
	 * Returns an ordered range of all the explotacions where readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param readed the readed
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching explotacions
	 */
	@Override
	public List<Explotacion> findByreaded(
		boolean readed, int start, int end,
		OrderByComparator<Explotacion> orderByComparator) {

		return findByreaded(readed, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the explotacions where readed = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param readed the readed
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching explotacions
	 */
	@Override
	public List<Explotacion> findByreaded(
		boolean readed, int start, int end,
		OrderByComparator<Explotacion> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByreaded;
				finderArgs = new Object[] {readed};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByreaded;
			finderArgs = new Object[] {readed, start, end, orderByComparator};
		}

		List<Explotacion> list = null;

		if (useFinderCache) {
			list = (List<Explotacion>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Explotacion explotacion : list) {
					if (readed != explotacion.isReaded()) {
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

			sb.append(_SQL_SELECT_EXPLOTACION_WHERE);

			sb.append(_FINDER_COLUMN_READED_READED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ExplotacionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(readed);

				list = (List<Explotacion>)QueryUtil.list(
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
	 * Returns the first explotacion in the ordered set where readed = &#63;.
	 *
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	@Override
	public Explotacion findByreaded_First(
			boolean readed, OrderByComparator<Explotacion> orderByComparator)
		throws NoSuchExplotacionException {

		Explotacion explotacion = fetchByreaded_First(
			readed, orderByComparator);

		if (explotacion != null) {
			return explotacion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("readed=");
		sb.append(readed);

		sb.append("}");

		throw new NoSuchExplotacionException(sb.toString());
	}

	/**
	 * Returns the first explotacion in the ordered set where readed = &#63;.
	 *
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	@Override
	public Explotacion fetchByreaded_First(
		boolean readed, OrderByComparator<Explotacion> orderByComparator) {

		List<Explotacion> list = findByreaded(readed, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last explotacion in the ordered set where readed = &#63;.
	 *
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion
	 * @throws NoSuchExplotacionException if a matching explotacion could not be found
	 */
	@Override
	public Explotacion findByreaded_Last(
			boolean readed, OrderByComparator<Explotacion> orderByComparator)
		throws NoSuchExplotacionException {

		Explotacion explotacion = fetchByreaded_Last(readed, orderByComparator);

		if (explotacion != null) {
			return explotacion;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("readed=");
		sb.append(readed);

		sb.append("}");

		throw new NoSuchExplotacionException(sb.toString());
	}

	/**
	 * Returns the last explotacion in the ordered set where readed = &#63;.
	 *
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching explotacion, or <code>null</code> if a matching explotacion could not be found
	 */
	@Override
	public Explotacion fetchByreaded_Last(
		boolean readed, OrderByComparator<Explotacion> orderByComparator) {

		int count = countByreaded(readed);

		if (count == 0) {
			return null;
		}

		List<Explotacion> list = findByreaded(
			readed, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the explotacions before and after the current explotacion in the ordered set where readed = &#63;.
	 *
	 * @param explotacionId the primary key of the current explotacion
	 * @param readed the readed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next explotacion
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	@Override
	public Explotacion[] findByreaded_PrevAndNext(
			long explotacionId, boolean readed,
			OrderByComparator<Explotacion> orderByComparator)
		throws NoSuchExplotacionException {

		Explotacion explotacion = findByPrimaryKey(explotacionId);

		Session session = null;

		try {
			session = openSession();

			Explotacion[] array = new ExplotacionImpl[3];

			array[0] = getByreaded_PrevAndNext(
				session, explotacion, readed, orderByComparator, true);

			array[1] = explotacion;

			array[2] = getByreaded_PrevAndNext(
				session, explotacion, readed, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Explotacion getByreaded_PrevAndNext(
		Session session, Explotacion explotacion, boolean readed,
		OrderByComparator<Explotacion> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EXPLOTACION_WHERE);

		sb.append(_FINDER_COLUMN_READED_READED_2);

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
			sb.append(ExplotacionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(readed);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(explotacion)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Explotacion> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the explotacions where readed = &#63; from the database.
	 *
	 * @param readed the readed
	 */
	@Override
	public void removeByreaded(boolean readed) {
		for (Explotacion explotacion :
				findByreaded(
					readed, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(explotacion);
		}
	}

	/**
	 * Returns the number of explotacions where readed = &#63;.
	 *
	 * @param readed the readed
	 * @return the number of matching explotacions
	 */
	@Override
	public int countByreaded(boolean readed) {
		FinderPath finderPath = _finderPathCountByreaded;

		Object[] finderArgs = new Object[] {readed};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EXPLOTACION_WHERE);

			sb.append(_FINDER_COLUMN_READED_READED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_READED_READED_2 =
		"explotacion.readed = ?";

	public ExplotacionPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("size", "size_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Explotacion.class);

		setModelImplClass(ExplotacionImpl.class);
		setModelPKClass(long.class);

		setTable(ExplotacionTable.INSTANCE);
	}

	/**
	 * Caches the explotacion in the entity cache if it is enabled.
	 *
	 * @param explotacion the explotacion
	 */
	@Override
	public void cacheResult(Explotacion explotacion) {
		entityCache.putResult(
			ExplotacionImpl.class, explotacion.getPrimaryKey(), explotacion);

		finderCache.putResult(
			_finderPathFetchByexternalCodeReferenceAndUserId,
			new Object[] {
				explotacion.getExternalCodeReference(), explotacion.getUserId()
			},
			explotacion);

		finderCache.putResult(
			_finderPathFetchByidAndUserId,
			new Object[] {
				explotacion.getExplotacionId(), explotacion.getUserId()
			},
			explotacion);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the explotacions in the entity cache if it is enabled.
	 *
	 * @param explotacions the explotacions
	 */
	@Override
	public void cacheResult(List<Explotacion> explotacions) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (explotacions.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Explotacion explotacion : explotacions) {
			if (entityCache.getResult(
					ExplotacionImpl.class, explotacion.getPrimaryKey()) ==
						null) {

				cacheResult(explotacion);
			}
		}
	}

	/**
	 * Clears the cache for all explotacions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ExplotacionImpl.class);

		finderCache.clearCache(ExplotacionImpl.class);
	}

	/**
	 * Clears the cache for the explotacion.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Explotacion explotacion) {
		entityCache.removeResult(ExplotacionImpl.class, explotacion);
	}

	@Override
	public void clearCache(List<Explotacion> explotacions) {
		for (Explotacion explotacion : explotacions) {
			entityCache.removeResult(ExplotacionImpl.class, explotacion);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ExplotacionImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ExplotacionImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ExplotacionModelImpl explotacionModelImpl) {

		Object[] args = new Object[] {
			explotacionModelImpl.getExternalCodeReference(),
			explotacionModelImpl.getUserId()
		};

		finderCache.putResult(
			_finderPathCountByexternalCodeReferenceAndUserId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByexternalCodeReferenceAndUserId, args,
			explotacionModelImpl);

		args = new Object[] {
			explotacionModelImpl.getExplotacionId(),
			explotacionModelImpl.getUserId()
		};

		finderCache.putResult(
			_finderPathCountByidAndUserId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByidAndUserId, args, explotacionModelImpl);
	}

	/**
	 * Creates a new explotacion with the primary key. Does not add the explotacion to the database.
	 *
	 * @param explotacionId the primary key for the new explotacion
	 * @return the new explotacion
	 */
	@Override
	public Explotacion create(long explotacionId) {
		Explotacion explotacion = new ExplotacionImpl();

		explotacion.setNew(true);
		explotacion.setPrimaryKey(explotacionId);

		String uuid = PortalUUIDUtil.generate();

		explotacion.setUuid(uuid);

		return explotacion;
	}

	/**
	 * Removes the explotacion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param explotacionId the primary key of the explotacion
	 * @return the explotacion that was removed
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	@Override
	public Explotacion remove(long explotacionId)
		throws NoSuchExplotacionException {

		return remove((Serializable)explotacionId);
	}

	/**
	 * Removes the explotacion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the explotacion
	 * @return the explotacion that was removed
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	@Override
	public Explotacion remove(Serializable primaryKey)
		throws NoSuchExplotacionException {

		Session session = null;

		try {
			session = openSession();

			Explotacion explotacion = (Explotacion)session.get(
				ExplotacionImpl.class, primaryKey);

			if (explotacion == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExplotacionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(explotacion);
		}
		catch (NoSuchExplotacionException noSuchEntityException) {
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
	protected Explotacion removeImpl(Explotacion explotacion) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(explotacion)) {
				explotacion = (Explotacion)session.get(
					ExplotacionImpl.class, explotacion.getPrimaryKeyObj());
			}

			if (explotacion != null) {
				session.delete(explotacion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (explotacion != null) {
			clearCache(explotacion);
		}

		return explotacion;
	}

	@Override
	public Explotacion updateImpl(Explotacion explotacion) {
		boolean isNew = explotacion.isNew();

		if (!(explotacion instanceof ExplotacionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(explotacion.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(explotacion);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in explotacion proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Explotacion implementation " +
					explotacion.getClass());
		}

		ExplotacionModelImpl explotacionModelImpl =
			(ExplotacionModelImpl)explotacion;

		if (Validator.isNull(explotacion.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			explotacion.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (explotacion.getCreateDate() == null)) {
			if (serviceContext == null) {
				explotacion.setCreateDate(date);
			}
			else {
				explotacion.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!explotacionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				explotacion.setModifiedDate(date);
			}
			else {
				explotacion.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(explotacion);
			}
			else {
				explotacion = (Explotacion)session.merge(explotacion);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ExplotacionImpl.class, explotacionModelImpl, false, true);

		cacheUniqueFindersCache(explotacionModelImpl);

		if (isNew) {
			explotacion.setNew(false);
		}

		explotacion.resetOriginalValues();

		return explotacion;
	}

	/**
	 * Returns the explotacion with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the explotacion
	 * @return the explotacion
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	@Override
	public Explotacion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExplotacionException {

		Explotacion explotacion = fetchByPrimaryKey(primaryKey);

		if (explotacion == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExplotacionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return explotacion;
	}

	/**
	 * Returns the explotacion with the primary key or throws a <code>NoSuchExplotacionException</code> if it could not be found.
	 *
	 * @param explotacionId the primary key of the explotacion
	 * @return the explotacion
	 * @throws NoSuchExplotacionException if a explotacion with the primary key could not be found
	 */
	@Override
	public Explotacion findByPrimaryKey(long explotacionId)
		throws NoSuchExplotacionException {

		return findByPrimaryKey((Serializable)explotacionId);
	}

	/**
	 * Returns the explotacion with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param explotacionId the primary key of the explotacion
	 * @return the explotacion, or <code>null</code> if a explotacion with the primary key could not be found
	 */
	@Override
	public Explotacion fetchByPrimaryKey(long explotacionId) {
		return fetchByPrimaryKey((Serializable)explotacionId);
	}

	/**
	 * Returns all the explotacions.
	 *
	 * @return the explotacions
	 */
	@Override
	public List<Explotacion> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the explotacions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @return the range of explotacions
	 */
	@Override
	public List<Explotacion> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the explotacions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of explotacions
	 */
	@Override
	public List<Explotacion> findAll(
		int start, int end, OrderByComparator<Explotacion> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the explotacions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExplotacionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of explotacions
	 * @param end the upper bound of the range of explotacions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of explotacions
	 */
	@Override
	public List<Explotacion> findAll(
		int start, int end, OrderByComparator<Explotacion> orderByComparator,
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

		List<Explotacion> list = null;

		if (useFinderCache) {
			list = (List<Explotacion>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EXPLOTACION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EXPLOTACION;

				sql = sql.concat(ExplotacionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Explotacion>)QueryUtil.list(
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
	 * Removes all the explotacions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Explotacion explotacion : findAll()) {
			remove(explotacion);
		}
	}

	/**
	 * Returns the number of explotacions.
	 *
	 * @return the number of explotacions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EXPLOTACION);

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
		return "explotacionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EXPLOTACION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ExplotacionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the explotacion persistence.
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

		_finderPathFetchByexternalCodeReferenceAndUserId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByexternalCodeReferenceAndUserId",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"externalCodeReference", "userId"}, true);

		_finderPathCountByexternalCodeReferenceAndUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByexternalCodeReferenceAndUserId",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"externalCodeReference", "userId"}, false);

		_finderPathWithPaginationFindByisMainAndUser = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByisMainAndUser",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"isMain", "userId"}, true);

		_finderPathWithoutPaginationFindByisMainAndUser = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByisMainAndUser",
			new String[] {Boolean.class.getName(), Long.class.getName()},
			new String[] {"isMain", "userId"}, true);

		_finderPathCountByisMainAndUser = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByisMainAndUser",
			new String[] {Boolean.class.getName(), Long.class.getName()},
			new String[] {"isMain", "userId"}, false);

		_finderPathFetchByidAndUserId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByidAndUserId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"explotacionId", "userId"}, true);

		_finderPathCountByidAndUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByidAndUserId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"explotacionId", "userId"}, false);

		_finderPathWithPaginationFindByreaded = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByreaded",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"readed"}, true);

		_finderPathWithoutPaginationFindByreaded = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByreaded",
			new String[] {Boolean.class.getName()}, new String[] {"readed"},
			true);

		_finderPathCountByreaded = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByreaded",
			new String[] {Boolean.class.getName()}, new String[] {"readed"},
			false);

		ExplotacionUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ExplotacionUtil.setPersistence(null);

		entityCache.removeCache(ExplotacionImpl.class.getName());
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

	private static final String _SQL_SELECT_EXPLOTACION =
		"SELECT explotacion FROM Explotacion explotacion";

	private static final String _SQL_SELECT_EXPLOTACION_WHERE =
		"SELECT explotacion FROM Explotacion explotacion WHERE ";

	private static final String _SQL_COUNT_EXPLOTACION =
		"SELECT COUNT(explotacion) FROM Explotacion explotacion";

	private static final String _SQL_COUNT_EXPLOTACION_WHERE =
		"SELECT COUNT(explotacion) FROM Explotacion explotacion WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "explotacion.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Explotacion exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Explotacion exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ExplotacionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "size"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}