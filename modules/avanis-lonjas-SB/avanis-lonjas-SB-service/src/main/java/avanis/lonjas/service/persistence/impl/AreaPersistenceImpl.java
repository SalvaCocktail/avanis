/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence.impl;

import avanis.lonjas.exception.NoSuchAreaException;
import avanis.lonjas.model.Area;
import avanis.lonjas.model.AreaTable;
import avanis.lonjas.model.impl.AreaImpl;
import avanis.lonjas.model.impl.AreaModelImpl;
import avanis.lonjas.service.persistence.AreaPersistence;
import avanis.lonjas.service.persistence.AreaUtil;
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
 * The persistence implementation for the area service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AreaPersistence.class)
public class AreaPersistenceImpl
	extends BasePersistenceImpl<Area> implements AreaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AreaUtil</code> to access the area persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AreaImpl.class.getName();

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
	 * Returns all the areas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching areas
	 */
	@Override
	public List<Area> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the areas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @return the range of matching areas
	 */
	@Override
	public List<Area> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the areas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching areas
	 */
	@Override
	public List<Area> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Area> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the areas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching areas
	 */
	@Override
	public List<Area> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Area> orderByComparator, boolean useFinderCache) {

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

		List<Area> list = null;

		if (useFinderCache) {
			list = (List<Area>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Area area : list) {
					if (!uuid.equals(area.getUuid())) {
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

			sb.append(_SQL_SELECT_AREA_WHERE);

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
				sb.append(AreaModelImpl.ORDER_BY_JPQL);
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

				list = (List<Area>)QueryUtil.list(
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
	 * Returns the first area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area
	 * @throws NoSuchAreaException if a matching area could not be found
	 */
	@Override
	public Area findByUuid_First(
			String uuid, OrderByComparator<Area> orderByComparator)
		throws NoSuchAreaException {

		Area area = fetchByUuid_First(uuid, orderByComparator);

		if (area != null) {
			return area;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAreaException(sb.toString());
	}

	/**
	 * Returns the first area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area, or <code>null</code> if a matching area could not be found
	 */
	@Override
	public Area fetchByUuid_First(
		String uuid, OrderByComparator<Area> orderByComparator) {

		List<Area> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area
	 * @throws NoSuchAreaException if a matching area could not be found
	 */
	@Override
	public Area findByUuid_Last(
			String uuid, OrderByComparator<Area> orderByComparator)
		throws NoSuchAreaException {

		Area area = fetchByUuid_Last(uuid, orderByComparator);

		if (area != null) {
			return area;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAreaException(sb.toString());
	}

	/**
	 * Returns the last area in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area, or <code>null</code> if a matching area could not be found
	 */
	@Override
	public Area fetchByUuid_Last(
		String uuid, OrderByComparator<Area> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Area> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the areas before and after the current area in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current area
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next area
	 * @throws NoSuchAreaException if a area with the primary key could not be found
	 */
	@Override
	public Area[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			OrderByComparator<Area> orderByComparator)
		throws NoSuchAreaException {

		uuid = Objects.toString(uuid, "");

		Area area = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			Area[] array = new AreaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, area, uuid, orderByComparator, true);

			array[1] = area;

			array[2] = getByUuid_PrevAndNext(
				session, area, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Area getByUuid_PrevAndNext(
		Session session, Area area, String uuid,
		OrderByComparator<Area> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AREA_WHERE);

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
			sb.append(AreaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(area)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Area> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the areas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Area area :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(area);
		}
	}

	/**
	 * Returns the number of areas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching areas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AREA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "area.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(area.uuid IS NULL OR area.uuid = '')";

	private FinderPath _finderPathWithPaginationFindBynombre;
	private FinderPath _finderPathWithoutPaginationFindBynombre;
	private FinderPath _finderPathCountBynombre;

	/**
	 * Returns all the areas where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the matching areas
	 */
	@Override
	public List<Area> findBynombre(String nombre) {
		return findBynombre(nombre, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the areas where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @return the range of matching areas
	 */
	@Override
	public List<Area> findBynombre(String nombre, int start, int end) {
		return findBynombre(nombre, start, end, null);
	}

	/**
	 * Returns an ordered range of all the areas where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching areas
	 */
	@Override
	public List<Area> findBynombre(
		String nombre, int start, int end,
		OrderByComparator<Area> orderByComparator) {

		return findBynombre(nombre, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the areas where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching areas
	 */
	@Override
	public List<Area> findBynombre(
		String nombre, int start, int end,
		OrderByComparator<Area> orderByComparator, boolean useFinderCache) {

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

		List<Area> list = null;

		if (useFinderCache) {
			list = (List<Area>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Area area : list) {
					if (!nombre.equals(area.getNombre())) {
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

			sb.append(_SQL_SELECT_AREA_WHERE);

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
				sb.append(AreaModelImpl.ORDER_BY_JPQL);
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

				list = (List<Area>)QueryUtil.list(
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
	 * Returns the first area in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area
	 * @throws NoSuchAreaException if a matching area could not be found
	 */
	@Override
	public Area findBynombre_First(
			String nombre, OrderByComparator<Area> orderByComparator)
		throws NoSuchAreaException {

		Area area = fetchBynombre_First(nombre, orderByComparator);

		if (area != null) {
			return area;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nombre=");
		sb.append(nombre);

		sb.append("}");

		throw new NoSuchAreaException(sb.toString());
	}

	/**
	 * Returns the first area in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching area, or <code>null</code> if a matching area could not be found
	 */
	@Override
	public Area fetchBynombre_First(
		String nombre, OrderByComparator<Area> orderByComparator) {

		List<Area> list = findBynombre(nombre, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last area in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area
	 * @throws NoSuchAreaException if a matching area could not be found
	 */
	@Override
	public Area findBynombre_Last(
			String nombre, OrderByComparator<Area> orderByComparator)
		throws NoSuchAreaException {

		Area area = fetchBynombre_Last(nombre, orderByComparator);

		if (area != null) {
			return area;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nombre=");
		sb.append(nombre);

		sb.append("}");

		throw new NoSuchAreaException(sb.toString());
	}

	/**
	 * Returns the last area in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching area, or <code>null</code> if a matching area could not be found
	 */
	@Override
	public Area fetchBynombre_Last(
		String nombre, OrderByComparator<Area> orderByComparator) {

		int count = countBynombre(nombre);

		if (count == 0) {
			return null;
		}

		List<Area> list = findBynombre(
			nombre, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the areas before and after the current area in the ordered set where nombre = &#63;.
	 *
	 * @param entityId the primary key of the current area
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next area
	 * @throws NoSuchAreaException if a area with the primary key could not be found
	 */
	@Override
	public Area[] findBynombre_PrevAndNext(
			long entityId, String nombre,
			OrderByComparator<Area> orderByComparator)
		throws NoSuchAreaException {

		nombre = Objects.toString(nombre, "");

		Area area = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			Area[] array = new AreaImpl[3];

			array[0] = getBynombre_PrevAndNext(
				session, area, nombre, orderByComparator, true);

			array[1] = area;

			array[2] = getBynombre_PrevAndNext(
				session, area, nombre, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Area getBynombre_PrevAndNext(
		Session session, Area area, String nombre,
		OrderByComparator<Area> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AREA_WHERE);

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
			sb.append(AreaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(area)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Area> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the areas where nombre = &#63; from the database.
	 *
	 * @param nombre the nombre
	 */
	@Override
	public void removeBynombre(String nombre) {
		for (Area area :
				findBynombre(
					nombre, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(area);
		}
	}

	/**
	 * Returns the number of areas where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the number of matching areas
	 */
	@Override
	public int countBynombre(String nombre) {
		nombre = Objects.toString(nombre, "");

		FinderPath finderPath = _finderPathCountBynombre;

		Object[] finderArgs = new Object[] {nombre};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AREA_WHERE);

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
		"area.nombre = ?";

	private static final String _FINDER_COLUMN_NOMBRE_NOMBRE_3 =
		"(area.nombre IS NULL OR area.nombre = '')";

	private FinderPath _finderPathFetchByareaId;
	private FinderPath _finderPathCountByareaId;

	/**
	 * Returns the area where areaId = &#63; or throws a <code>NoSuchAreaException</code> if it could not be found.
	 *
	 * @param areaId the area ID
	 * @return the matching area
	 * @throws NoSuchAreaException if a matching area could not be found
	 */
	@Override
	public Area findByareaId(long areaId) throws NoSuchAreaException {
		Area area = fetchByareaId(areaId);

		if (area == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("areaId=");
			sb.append(areaId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAreaException(sb.toString());
		}

		return area;
	}

	/**
	 * Returns the area where areaId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param areaId the area ID
	 * @return the matching area, or <code>null</code> if a matching area could not be found
	 */
	@Override
	public Area fetchByareaId(long areaId) {
		return fetchByareaId(areaId, true);
	}

	/**
	 * Returns the area where areaId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param areaId the area ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching area, or <code>null</code> if a matching area could not be found
	 */
	@Override
	public Area fetchByareaId(long areaId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {areaId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByareaId, finderArgs, this);
		}

		if (result instanceof Area) {
			Area area = (Area)result;

			if (areaId != area.getAreaId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_AREA_WHERE);

			sb.append(_FINDER_COLUMN_AREAID_AREAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(areaId);

				List<Area> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByareaId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {areaId};
							}

							_log.warn(
								"AreaPersistenceImpl.fetchByareaId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Area area = list.get(0);

					result = area;

					cacheResult(area);
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
			return (Area)result;
		}
	}

	/**
	 * Removes the area where areaId = &#63; from the database.
	 *
	 * @param areaId the area ID
	 * @return the area that was removed
	 */
	@Override
	public Area removeByareaId(long areaId) throws NoSuchAreaException {
		Area area = findByareaId(areaId);

		return remove(area);
	}

	/**
	 * Returns the number of areas where areaId = &#63;.
	 *
	 * @param areaId the area ID
	 * @return the number of matching areas
	 */
	@Override
	public int countByareaId(long areaId) {
		FinderPath finderPath = _finderPathCountByareaId;

		Object[] finderArgs = new Object[] {areaId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AREA_WHERE);

			sb.append(_FINDER_COLUMN_AREAID_AREAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(areaId);

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

	private static final String _FINDER_COLUMN_AREAID_AREAID_2 =
		"area.areaId = ?";

	public AreaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Area.class);

		setModelImplClass(AreaImpl.class);
		setModelPKClass(long.class);

		setTable(AreaTable.INSTANCE);
	}

	/**
	 * Caches the area in the entity cache if it is enabled.
	 *
	 * @param area the area
	 */
	@Override
	public void cacheResult(Area area) {
		entityCache.putResult(AreaImpl.class, area.getPrimaryKey(), area);

		finderCache.putResult(
			_finderPathFetchByareaId, new Object[] {area.getAreaId()}, area);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the areas in the entity cache if it is enabled.
	 *
	 * @param areas the areas
	 */
	@Override
	public void cacheResult(List<Area> areas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (areas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Area area : areas) {
			if (entityCache.getResult(AreaImpl.class, area.getPrimaryKey()) ==
					null) {

				cacheResult(area);
			}
		}
	}

	/**
	 * Clears the cache for all areas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AreaImpl.class);

		finderCache.clearCache(AreaImpl.class);
	}

	/**
	 * Clears the cache for the area.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Area area) {
		entityCache.removeResult(AreaImpl.class, area);
	}

	@Override
	public void clearCache(List<Area> areas) {
		for (Area area : areas) {
			entityCache.removeResult(AreaImpl.class, area);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AreaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AreaImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(AreaModelImpl areaModelImpl) {
		Object[] args = new Object[] {areaModelImpl.getAreaId()};

		finderCache.putResult(_finderPathCountByareaId, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByareaId, args, areaModelImpl);
	}

	/**
	 * Creates a new area with the primary key. Does not add the area to the database.
	 *
	 * @param entityId the primary key for the new area
	 * @return the new area
	 */
	@Override
	public Area create(long entityId) {
		Area area = new AreaImpl();

		area.setNew(true);
		area.setPrimaryKey(entityId);

		String uuid = PortalUUIDUtil.generate();

		area.setUuid(uuid);

		return area;
	}

	/**
	 * Removes the area with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the area
	 * @return the area that was removed
	 * @throws NoSuchAreaException if a area with the primary key could not be found
	 */
	@Override
	public Area remove(long entityId) throws NoSuchAreaException {
		return remove((Serializable)entityId);
	}

	/**
	 * Removes the area with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the area
	 * @return the area that was removed
	 * @throws NoSuchAreaException if a area with the primary key could not be found
	 */
	@Override
	public Area remove(Serializable primaryKey) throws NoSuchAreaException {
		Session session = null;

		try {
			session = openSession();

			Area area = (Area)session.get(AreaImpl.class, primaryKey);

			if (area == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAreaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(area);
		}
		catch (NoSuchAreaException noSuchEntityException) {
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
	protected Area removeImpl(Area area) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(area)) {
				area = (Area)session.get(
					AreaImpl.class, area.getPrimaryKeyObj());
			}

			if (area != null) {
				session.delete(area);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (area != null) {
			clearCache(area);
		}

		return area;
	}

	@Override
	public Area updateImpl(Area area) {
		boolean isNew = area.isNew();

		if (!(area instanceof AreaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(area.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(area);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in area proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Area implementation " +
					area.getClass());
		}

		AreaModelImpl areaModelImpl = (AreaModelImpl)area;

		if (Validator.isNull(area.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			area.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (area.getCreateDate() == null)) {
			if (serviceContext == null) {
				area.setCreateDate(date);
			}
			else {
				area.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!areaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				area.setModifiedDate(date);
			}
			else {
				area.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(area);
			}
			else {
				area = (Area)session.merge(area);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(AreaImpl.class, areaModelImpl, false, true);

		cacheUniqueFindersCache(areaModelImpl);

		if (isNew) {
			area.setNew(false);
		}

		area.resetOriginalValues();

		return area;
	}

	/**
	 * Returns the area with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the area
	 * @return the area
	 * @throws NoSuchAreaException if a area with the primary key could not be found
	 */
	@Override
	public Area findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAreaException {

		Area area = fetchByPrimaryKey(primaryKey);

		if (area == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAreaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return area;
	}

	/**
	 * Returns the area with the primary key or throws a <code>NoSuchAreaException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the area
	 * @return the area
	 * @throws NoSuchAreaException if a area with the primary key could not be found
	 */
	@Override
	public Area findByPrimaryKey(long entityId) throws NoSuchAreaException {
		return findByPrimaryKey((Serializable)entityId);
	}

	/**
	 * Returns the area with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the area
	 * @return the area, or <code>null</code> if a area with the primary key could not be found
	 */
	@Override
	public Area fetchByPrimaryKey(long entityId) {
		return fetchByPrimaryKey((Serializable)entityId);
	}

	/**
	 * Returns all the areas.
	 *
	 * @return the areas
	 */
	@Override
	public List<Area> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @return the range of areas
	 */
	@Override
	public List<Area> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of areas
	 */
	@Override
	public List<Area> findAll(
		int start, int end, OrderByComparator<Area> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AreaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of areas
	 * @param end the upper bound of the range of areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of areas
	 */
	@Override
	public List<Area> findAll(
		int start, int end, OrderByComparator<Area> orderByComparator,
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

		List<Area> list = null;

		if (useFinderCache) {
			list = (List<Area>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AREA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AREA;

				sql = sql.concat(AreaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Area>)QueryUtil.list(
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
	 * Removes all the areas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Area area : findAll()) {
			remove(area);
		}
	}

	/**
	 * Returns the number of areas.
	 *
	 * @return the number of areas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AREA);

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
		return _SQL_SELECT_AREA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AreaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the area persistence.
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

		_finderPathFetchByareaId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByareaId",
			new String[] {Long.class.getName()}, new String[] {"areaId"}, true);

		_finderPathCountByareaId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByareaId",
			new String[] {Long.class.getName()}, new String[] {"areaId"},
			false);

		AreaUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AreaUtil.setPersistence(null);

		entityCache.removeCache(AreaImpl.class.getName());
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

	private static final String _SQL_SELECT_AREA = "SELECT area FROM Area area";

	private static final String _SQL_SELECT_AREA_WHERE =
		"SELECT area FROM Area area WHERE ";

	private static final String _SQL_COUNT_AREA =
		"SELECT COUNT(area) FROM Area area";

	private static final String _SQL_COUNT_AREA_WHERE =
		"SELECT COUNT(area) FROM Area area WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "area.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Area exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Area exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AreaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}