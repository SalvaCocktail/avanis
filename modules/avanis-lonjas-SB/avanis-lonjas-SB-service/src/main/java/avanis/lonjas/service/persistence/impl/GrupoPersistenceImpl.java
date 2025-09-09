/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence.impl;

import avanis.lonjas.exception.NoSuchGrupoException;
import avanis.lonjas.model.Grupo;
import avanis.lonjas.model.GrupoTable;
import avanis.lonjas.model.impl.GrupoImpl;
import avanis.lonjas.model.impl.GrupoModelImpl;
import avanis.lonjas.service.persistence.GrupoPersistence;
import avanis.lonjas.service.persistence.GrupoUtil;
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
 * The persistence implementation for the grupo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = GrupoPersistence.class)
public class GrupoPersistenceImpl
	extends BasePersistenceImpl<Grupo> implements GrupoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GrupoUtil</code> to access the grupo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GrupoImpl.class.getName();

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
	 * Returns all the grupos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching grupos
	 */
	@Override
	public List<Grupo> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the grupos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrupoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of grupos
	 * @param end the upper bound of the range of grupos (not inclusive)
	 * @return the range of matching grupos
	 */
	@Override
	public List<Grupo> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the grupos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrupoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of grupos
	 * @param end the upper bound of the range of grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching grupos
	 */
	@Override
	public List<Grupo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Grupo> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the grupos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrupoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of grupos
	 * @param end the upper bound of the range of grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching grupos
	 */
	@Override
	public List<Grupo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Grupo> orderByComparator, boolean useFinderCache) {

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

		List<Grupo> list = null;

		if (useFinderCache) {
			list = (List<Grupo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Grupo grupo : list) {
					if (!uuid.equals(grupo.getUuid())) {
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

			sb.append(_SQL_SELECT_GRUPO_WHERE);

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
				sb.append(GrupoModelImpl.ORDER_BY_JPQL);
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

				list = (List<Grupo>)QueryUtil.list(
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
	 * Returns the first grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grupo
	 * @throws NoSuchGrupoException if a matching grupo could not be found
	 */
	@Override
	public Grupo findByUuid_First(
			String uuid, OrderByComparator<Grupo> orderByComparator)
		throws NoSuchGrupoException {

		Grupo grupo = fetchByUuid_First(uuid, orderByComparator);

		if (grupo != null) {
			return grupo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchGrupoException(sb.toString());
	}

	/**
	 * Returns the first grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grupo, or <code>null</code> if a matching grupo could not be found
	 */
	@Override
	public Grupo fetchByUuid_First(
		String uuid, OrderByComparator<Grupo> orderByComparator) {

		List<Grupo> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grupo
	 * @throws NoSuchGrupoException if a matching grupo could not be found
	 */
	@Override
	public Grupo findByUuid_Last(
			String uuid, OrderByComparator<Grupo> orderByComparator)
		throws NoSuchGrupoException {

		Grupo grupo = fetchByUuid_Last(uuid, orderByComparator);

		if (grupo != null) {
			return grupo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchGrupoException(sb.toString());
	}

	/**
	 * Returns the last grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grupo, or <code>null</code> if a matching grupo could not be found
	 */
	@Override
	public Grupo fetchByUuid_Last(
		String uuid, OrderByComparator<Grupo> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Grupo> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the grupos before and after the current grupo in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current grupo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next grupo
	 * @throws NoSuchGrupoException if a grupo with the primary key could not be found
	 */
	@Override
	public Grupo[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			OrderByComparator<Grupo> orderByComparator)
		throws NoSuchGrupoException {

		uuid = Objects.toString(uuid, "");

		Grupo grupo = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			Grupo[] array = new GrupoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, grupo, uuid, orderByComparator, true);

			array[1] = grupo;

			array[2] = getByUuid_PrevAndNext(
				session, grupo, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Grupo getByUuid_PrevAndNext(
		Session session, Grupo grupo, String uuid,
		OrderByComparator<Grupo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_GRUPO_WHERE);

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
			sb.append(GrupoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(grupo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Grupo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the grupos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Grupo grupo :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(grupo);
		}
	}

	/**
	 * Returns the number of grupos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching grupos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GRUPO_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "grupo.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(grupo.uuid IS NULL OR grupo.uuid = '')";

	private FinderPath _finderPathWithPaginationFindBynombre;
	private FinderPath _finderPathWithoutPaginationFindBynombre;
	private FinderPath _finderPathCountBynombre;

	/**
	 * Returns all the grupos where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the matching grupos
	 */
	@Override
	public List<Grupo> findBynombre(String nombre) {
		return findBynombre(nombre, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the grupos where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrupoModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of grupos
	 * @param end the upper bound of the range of grupos (not inclusive)
	 * @return the range of matching grupos
	 */
	@Override
	public List<Grupo> findBynombre(String nombre, int start, int end) {
		return findBynombre(nombre, start, end, null);
	}

	/**
	 * Returns an ordered range of all the grupos where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrupoModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of grupos
	 * @param end the upper bound of the range of grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching grupos
	 */
	@Override
	public List<Grupo> findBynombre(
		String nombre, int start, int end,
		OrderByComparator<Grupo> orderByComparator) {

		return findBynombre(nombre, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the grupos where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrupoModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of grupos
	 * @param end the upper bound of the range of grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching grupos
	 */
	@Override
	public List<Grupo> findBynombre(
		String nombre, int start, int end,
		OrderByComparator<Grupo> orderByComparator, boolean useFinderCache) {

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

		List<Grupo> list = null;

		if (useFinderCache) {
			list = (List<Grupo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Grupo grupo : list) {
					if (!nombre.equals(grupo.getNombre())) {
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

			sb.append(_SQL_SELECT_GRUPO_WHERE);

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
				sb.append(GrupoModelImpl.ORDER_BY_JPQL);
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

				list = (List<Grupo>)QueryUtil.list(
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
	 * Returns the first grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grupo
	 * @throws NoSuchGrupoException if a matching grupo could not be found
	 */
	@Override
	public Grupo findBynombre_First(
			String nombre, OrderByComparator<Grupo> orderByComparator)
		throws NoSuchGrupoException {

		Grupo grupo = fetchBynombre_First(nombre, orderByComparator);

		if (grupo != null) {
			return grupo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nombre=");
		sb.append(nombre);

		sb.append("}");

		throw new NoSuchGrupoException(sb.toString());
	}

	/**
	 * Returns the first grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching grupo, or <code>null</code> if a matching grupo could not be found
	 */
	@Override
	public Grupo fetchBynombre_First(
		String nombre, OrderByComparator<Grupo> orderByComparator) {

		List<Grupo> list = findBynombre(nombre, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grupo
	 * @throws NoSuchGrupoException if a matching grupo could not be found
	 */
	@Override
	public Grupo findBynombre_Last(
			String nombre, OrderByComparator<Grupo> orderByComparator)
		throws NoSuchGrupoException {

		Grupo grupo = fetchBynombre_Last(nombre, orderByComparator);

		if (grupo != null) {
			return grupo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nombre=");
		sb.append(nombre);

		sb.append("}");

		throw new NoSuchGrupoException(sb.toString());
	}

	/**
	 * Returns the last grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching grupo, or <code>null</code> if a matching grupo could not be found
	 */
	@Override
	public Grupo fetchBynombre_Last(
		String nombre, OrderByComparator<Grupo> orderByComparator) {

		int count = countBynombre(nombre);

		if (count == 0) {
			return null;
		}

		List<Grupo> list = findBynombre(
			nombre, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the grupos before and after the current grupo in the ordered set where nombre = &#63;.
	 *
	 * @param entityId the primary key of the current grupo
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next grupo
	 * @throws NoSuchGrupoException if a grupo with the primary key could not be found
	 */
	@Override
	public Grupo[] findBynombre_PrevAndNext(
			long entityId, String nombre,
			OrderByComparator<Grupo> orderByComparator)
		throws NoSuchGrupoException {

		nombre = Objects.toString(nombre, "");

		Grupo grupo = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			Grupo[] array = new GrupoImpl[3];

			array[0] = getBynombre_PrevAndNext(
				session, grupo, nombre, orderByComparator, true);

			array[1] = grupo;

			array[2] = getBynombre_PrevAndNext(
				session, grupo, nombre, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Grupo getBynombre_PrevAndNext(
		Session session, Grupo grupo, String nombre,
		OrderByComparator<Grupo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_GRUPO_WHERE);

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
			sb.append(GrupoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(grupo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Grupo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the grupos where nombre = &#63; from the database.
	 *
	 * @param nombre the nombre
	 */
	@Override
	public void removeBynombre(String nombre) {
		for (Grupo grupo :
				findBynombre(
					nombre, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(grupo);
		}
	}

	/**
	 * Returns the number of grupos where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the number of matching grupos
	 */
	@Override
	public int countBynombre(String nombre) {
		nombre = Objects.toString(nombre, "");

		FinderPath finderPath = _finderPathCountBynombre;

		Object[] finderArgs = new Object[] {nombre};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GRUPO_WHERE);

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
		"grupo.nombre = ?";

	private static final String _FINDER_COLUMN_NOMBRE_NOMBRE_3 =
		"(grupo.nombre IS NULL OR grupo.nombre = '')";

	private FinderPath _finderPathFetchBygrupoId;
	private FinderPath _finderPathCountBygrupoId;

	/**
	 * Returns the grupo where grupoId = &#63; or throws a <code>NoSuchGrupoException</code> if it could not be found.
	 *
	 * @param grupoId the grupo ID
	 * @return the matching grupo
	 * @throws NoSuchGrupoException if a matching grupo could not be found
	 */
	@Override
	public Grupo findBygrupoId(long grupoId) throws NoSuchGrupoException {
		Grupo grupo = fetchBygrupoId(grupoId);

		if (grupo == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("grupoId=");
			sb.append(grupoId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchGrupoException(sb.toString());
		}

		return grupo;
	}

	/**
	 * Returns the grupo where grupoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param grupoId the grupo ID
	 * @return the matching grupo, or <code>null</code> if a matching grupo could not be found
	 */
	@Override
	public Grupo fetchBygrupoId(long grupoId) {
		return fetchBygrupoId(grupoId, true);
	}

	/**
	 * Returns the grupo where grupoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param grupoId the grupo ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching grupo, or <code>null</code> if a matching grupo could not be found
	 */
	@Override
	public Grupo fetchBygrupoId(long grupoId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {grupoId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBygrupoId, finderArgs, this);
		}

		if (result instanceof Grupo) {
			Grupo grupo = (Grupo)result;

			if (grupoId != grupo.getGrupoId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_GRUPO_WHERE);

			sb.append(_FINDER_COLUMN_GRUPOID_GRUPOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(grupoId);

				List<Grupo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBygrupoId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {grupoId};
							}

							_log.warn(
								"GrupoPersistenceImpl.fetchBygrupoId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Grupo grupo = list.get(0);

					result = grupo;

					cacheResult(grupo);
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
			return (Grupo)result;
		}
	}

	/**
	 * Removes the grupo where grupoId = &#63; from the database.
	 *
	 * @param grupoId the grupo ID
	 * @return the grupo that was removed
	 */
	@Override
	public Grupo removeBygrupoId(long grupoId) throws NoSuchGrupoException {
		Grupo grupo = findBygrupoId(grupoId);

		return remove(grupo);
	}

	/**
	 * Returns the number of grupos where grupoId = &#63;.
	 *
	 * @param grupoId the grupo ID
	 * @return the number of matching grupos
	 */
	@Override
	public int countBygrupoId(long grupoId) {
		FinderPath finderPath = _finderPathCountBygrupoId;

		Object[] finderArgs = new Object[] {grupoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_GRUPO_WHERE);

			sb.append(_FINDER_COLUMN_GRUPOID_GRUPOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(grupoId);

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

	private static final String _FINDER_COLUMN_GRUPOID_GRUPOID_2 =
		"grupo.grupoId = ?";

	public GrupoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Grupo.class);

		setModelImplClass(GrupoImpl.class);
		setModelPKClass(long.class);

		setTable(GrupoTable.INSTANCE);
	}

	/**
	 * Caches the grupo in the entity cache if it is enabled.
	 *
	 * @param grupo the grupo
	 */
	@Override
	public void cacheResult(Grupo grupo) {
		entityCache.putResult(GrupoImpl.class, grupo.getPrimaryKey(), grupo);

		finderCache.putResult(
			_finderPathFetchBygrupoId, new Object[] {grupo.getGrupoId()},
			grupo);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the grupos in the entity cache if it is enabled.
	 *
	 * @param grupos the grupos
	 */
	@Override
	public void cacheResult(List<Grupo> grupos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (grupos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Grupo grupo : grupos) {
			if (entityCache.getResult(GrupoImpl.class, grupo.getPrimaryKey()) ==
					null) {

				cacheResult(grupo);
			}
		}
	}

	/**
	 * Clears the cache for all grupos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GrupoImpl.class);

		finderCache.clearCache(GrupoImpl.class);
	}

	/**
	 * Clears the cache for the grupo.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Grupo grupo) {
		entityCache.removeResult(GrupoImpl.class, grupo);
	}

	@Override
	public void clearCache(List<Grupo> grupos) {
		for (Grupo grupo : grupos) {
			entityCache.removeResult(GrupoImpl.class, grupo);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(GrupoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(GrupoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(GrupoModelImpl grupoModelImpl) {
		Object[] args = new Object[] {grupoModelImpl.getGrupoId()};

		finderCache.putResult(_finderPathCountBygrupoId, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchBygrupoId, args, grupoModelImpl);
	}

	/**
	 * Creates a new grupo with the primary key. Does not add the grupo to the database.
	 *
	 * @param entityId the primary key for the new grupo
	 * @return the new grupo
	 */
	@Override
	public Grupo create(long entityId) {
		Grupo grupo = new GrupoImpl();

		grupo.setNew(true);
		grupo.setPrimaryKey(entityId);

		String uuid = PortalUUIDUtil.generate();

		grupo.setUuid(uuid);

		return grupo;
	}

	/**
	 * Removes the grupo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the grupo
	 * @return the grupo that was removed
	 * @throws NoSuchGrupoException if a grupo with the primary key could not be found
	 */
	@Override
	public Grupo remove(long entityId) throws NoSuchGrupoException {
		return remove((Serializable)entityId);
	}

	/**
	 * Removes the grupo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the grupo
	 * @return the grupo that was removed
	 * @throws NoSuchGrupoException if a grupo with the primary key could not be found
	 */
	@Override
	public Grupo remove(Serializable primaryKey) throws NoSuchGrupoException {
		Session session = null;

		try {
			session = openSession();

			Grupo grupo = (Grupo)session.get(GrupoImpl.class, primaryKey);

			if (grupo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGrupoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(grupo);
		}
		catch (NoSuchGrupoException noSuchEntityException) {
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
	protected Grupo removeImpl(Grupo grupo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(grupo)) {
				grupo = (Grupo)session.get(
					GrupoImpl.class, grupo.getPrimaryKeyObj());
			}

			if (grupo != null) {
				session.delete(grupo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (grupo != null) {
			clearCache(grupo);
		}

		return grupo;
	}

	@Override
	public Grupo updateImpl(Grupo grupo) {
		boolean isNew = grupo.isNew();

		if (!(grupo instanceof GrupoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(grupo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(grupo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in grupo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Grupo implementation " +
					grupo.getClass());
		}

		GrupoModelImpl grupoModelImpl = (GrupoModelImpl)grupo;

		if (Validator.isNull(grupo.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			grupo.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (grupo.getCreateDate() == null)) {
			if (serviceContext == null) {
				grupo.setCreateDate(date);
			}
			else {
				grupo.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!grupoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				grupo.setModifiedDate(date);
			}
			else {
				grupo.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(grupo);
			}
			else {
				grupo = (Grupo)session.merge(grupo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(GrupoImpl.class, grupoModelImpl, false, true);

		cacheUniqueFindersCache(grupoModelImpl);

		if (isNew) {
			grupo.setNew(false);
		}

		grupo.resetOriginalValues();

		return grupo;
	}

	/**
	 * Returns the grupo with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the grupo
	 * @return the grupo
	 * @throws NoSuchGrupoException if a grupo with the primary key could not be found
	 */
	@Override
	public Grupo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGrupoException {

		Grupo grupo = fetchByPrimaryKey(primaryKey);

		if (grupo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGrupoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return grupo;
	}

	/**
	 * Returns the grupo with the primary key or throws a <code>NoSuchGrupoException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the grupo
	 * @return the grupo
	 * @throws NoSuchGrupoException if a grupo with the primary key could not be found
	 */
	@Override
	public Grupo findByPrimaryKey(long entityId) throws NoSuchGrupoException {
		return findByPrimaryKey((Serializable)entityId);
	}

	/**
	 * Returns the grupo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the grupo
	 * @return the grupo, or <code>null</code> if a grupo with the primary key could not be found
	 */
	@Override
	public Grupo fetchByPrimaryKey(long entityId) {
		return fetchByPrimaryKey((Serializable)entityId);
	}

	/**
	 * Returns all the grupos.
	 *
	 * @return the grupos
	 */
	@Override
	public List<Grupo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the grupos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrupoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grupos
	 * @param end the upper bound of the range of grupos (not inclusive)
	 * @return the range of grupos
	 */
	@Override
	public List<Grupo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the grupos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrupoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grupos
	 * @param end the upper bound of the range of grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of grupos
	 */
	@Override
	public List<Grupo> findAll(
		int start, int end, OrderByComparator<Grupo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the grupos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GrupoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of grupos
	 * @param end the upper bound of the range of grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of grupos
	 */
	@Override
	public List<Grupo> findAll(
		int start, int end, OrderByComparator<Grupo> orderByComparator,
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

		List<Grupo> list = null;

		if (useFinderCache) {
			list = (List<Grupo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_GRUPO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_GRUPO;

				sql = sql.concat(GrupoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Grupo>)QueryUtil.list(
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
	 * Removes all the grupos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Grupo grupo : findAll()) {
			remove(grupo);
		}
	}

	/**
	 * Returns the number of grupos.
	 *
	 * @return the number of grupos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_GRUPO);

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
		return _SQL_SELECT_GRUPO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GrupoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the grupo persistence.
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

		_finderPathFetchBygrupoId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBygrupoId",
			new String[] {Long.class.getName()}, new String[] {"grupoId"},
			true);

		_finderPathCountBygrupoId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygrupoId",
			new String[] {Long.class.getName()}, new String[] {"grupoId"},
			false);

		GrupoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		GrupoUtil.setPersistence(null);

		entityCache.removeCache(GrupoImpl.class.getName());
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

	private static final String _SQL_SELECT_GRUPO =
		"SELECT grupo FROM Grupo grupo";

	private static final String _SQL_SELECT_GRUPO_WHERE =
		"SELECT grupo FROM Grupo grupo WHERE ";

	private static final String _SQL_COUNT_GRUPO =
		"SELECT COUNT(grupo) FROM Grupo grupo";

	private static final String _SQL_COUNT_GRUPO_WHERE =
		"SELECT COUNT(grupo) FROM Grupo grupo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "grupo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Grupo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Grupo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		GrupoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}