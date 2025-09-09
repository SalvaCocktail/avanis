/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence.impl;

import avanis.lonjas.exception.NoSuchSubGrupoException;
import avanis.lonjas.model.SubGrupo;
import avanis.lonjas.model.SubGrupoTable;
import avanis.lonjas.model.impl.SubGrupoImpl;
import avanis.lonjas.model.impl.SubGrupoModelImpl;
import avanis.lonjas.service.persistence.SubGrupoPersistence;
import avanis.lonjas.service.persistence.SubGrupoUtil;
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
 * The persistence implementation for the sub grupo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SubGrupoPersistence.class)
public class SubGrupoPersistenceImpl
	extends BasePersistenceImpl<SubGrupo> implements SubGrupoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SubGrupoUtil</code> to access the sub grupo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SubGrupoImpl.class.getName();

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
	 * Returns all the sub grupos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sub grupos
	 */
	@Override
	public List<SubGrupo> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sub grupos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubGrupoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sub grupos
	 * @param end the upper bound of the range of sub grupos (not inclusive)
	 * @return the range of matching sub grupos
	 */
	@Override
	public List<SubGrupo> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sub grupos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubGrupoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sub grupos
	 * @param end the upper bound of the range of sub grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sub grupos
	 */
	@Override
	public List<SubGrupo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SubGrupo> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sub grupos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubGrupoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sub grupos
	 * @param end the upper bound of the range of sub grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sub grupos
	 */
	@Override
	public List<SubGrupo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SubGrupo> orderByComparator, boolean useFinderCache) {

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

		List<SubGrupo> list = null;

		if (useFinderCache) {
			list = (List<SubGrupo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SubGrupo subGrupo : list) {
					if (!uuid.equals(subGrupo.getUuid())) {
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

			sb.append(_SQL_SELECT_SUBGRUPO_WHERE);

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
				sb.append(SubGrupoModelImpl.ORDER_BY_JPQL);
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

				list = (List<SubGrupo>)QueryUtil.list(
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
	 * Returns the first sub grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub grupo
	 * @throws NoSuchSubGrupoException if a matching sub grupo could not be found
	 */
	@Override
	public SubGrupo findByUuid_First(
			String uuid, OrderByComparator<SubGrupo> orderByComparator)
		throws NoSuchSubGrupoException {

		SubGrupo subGrupo = fetchByUuid_First(uuid, orderByComparator);

		if (subGrupo != null) {
			return subGrupo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSubGrupoException(sb.toString());
	}

	/**
	 * Returns the first sub grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub grupo, or <code>null</code> if a matching sub grupo could not be found
	 */
	@Override
	public SubGrupo fetchByUuid_First(
		String uuid, OrderByComparator<SubGrupo> orderByComparator) {

		List<SubGrupo> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sub grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub grupo
	 * @throws NoSuchSubGrupoException if a matching sub grupo could not be found
	 */
	@Override
	public SubGrupo findByUuid_Last(
			String uuid, OrderByComparator<SubGrupo> orderByComparator)
		throws NoSuchSubGrupoException {

		SubGrupo subGrupo = fetchByUuid_Last(uuid, orderByComparator);

		if (subGrupo != null) {
			return subGrupo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSubGrupoException(sb.toString());
	}

	/**
	 * Returns the last sub grupo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub grupo, or <code>null</code> if a matching sub grupo could not be found
	 */
	@Override
	public SubGrupo fetchByUuid_Last(
		String uuid, OrderByComparator<SubGrupo> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SubGrupo> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sub grupos before and after the current sub grupo in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current sub grupo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sub grupo
	 * @throws NoSuchSubGrupoException if a sub grupo with the primary key could not be found
	 */
	@Override
	public SubGrupo[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			OrderByComparator<SubGrupo> orderByComparator)
		throws NoSuchSubGrupoException {

		uuid = Objects.toString(uuid, "");

		SubGrupo subGrupo = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			SubGrupo[] array = new SubGrupoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, subGrupo, uuid, orderByComparator, true);

			array[1] = subGrupo;

			array[2] = getByUuid_PrevAndNext(
				session, subGrupo, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SubGrupo getByUuid_PrevAndNext(
		Session session, SubGrupo subGrupo, String uuid,
		OrderByComparator<SubGrupo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SUBGRUPO_WHERE);

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
			sb.append(SubGrupoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(subGrupo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SubGrupo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sub grupos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SubGrupo subGrupo :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(subGrupo);
		}
	}

	/**
	 * Returns the number of sub grupos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sub grupos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SUBGRUPO_WHERE);

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
		"subGrupo.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(subGrupo.uuid IS NULL OR subGrupo.uuid = '')";

	private FinderPath _finderPathWithPaginationFindBynombre;
	private FinderPath _finderPathWithoutPaginationFindBynombre;
	private FinderPath _finderPathCountBynombre;

	/**
	 * Returns all the sub grupos where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the matching sub grupos
	 */
	@Override
	public List<SubGrupo> findBynombre(String nombre) {
		return findBynombre(nombre, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sub grupos where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubGrupoModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of sub grupos
	 * @param end the upper bound of the range of sub grupos (not inclusive)
	 * @return the range of matching sub grupos
	 */
	@Override
	public List<SubGrupo> findBynombre(String nombre, int start, int end) {
		return findBynombre(nombre, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sub grupos where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubGrupoModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of sub grupos
	 * @param end the upper bound of the range of sub grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sub grupos
	 */
	@Override
	public List<SubGrupo> findBynombre(
		String nombre, int start, int end,
		OrderByComparator<SubGrupo> orderByComparator) {

		return findBynombre(nombre, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sub grupos where nombre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubGrupoModelImpl</code>.
	 * </p>
	 *
	 * @param nombre the nombre
	 * @param start the lower bound of the range of sub grupos
	 * @param end the upper bound of the range of sub grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sub grupos
	 */
	@Override
	public List<SubGrupo> findBynombre(
		String nombre, int start, int end,
		OrderByComparator<SubGrupo> orderByComparator, boolean useFinderCache) {

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

		List<SubGrupo> list = null;

		if (useFinderCache) {
			list = (List<SubGrupo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SubGrupo subGrupo : list) {
					if (!nombre.equals(subGrupo.getNombre())) {
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

			sb.append(_SQL_SELECT_SUBGRUPO_WHERE);

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
				sb.append(SubGrupoModelImpl.ORDER_BY_JPQL);
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

				list = (List<SubGrupo>)QueryUtil.list(
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
	 * Returns the first sub grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub grupo
	 * @throws NoSuchSubGrupoException if a matching sub grupo could not be found
	 */
	@Override
	public SubGrupo findBynombre_First(
			String nombre, OrderByComparator<SubGrupo> orderByComparator)
		throws NoSuchSubGrupoException {

		SubGrupo subGrupo = fetchBynombre_First(nombre, orderByComparator);

		if (subGrupo != null) {
			return subGrupo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nombre=");
		sb.append(nombre);

		sb.append("}");

		throw new NoSuchSubGrupoException(sb.toString());
	}

	/**
	 * Returns the first sub grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sub grupo, or <code>null</code> if a matching sub grupo could not be found
	 */
	@Override
	public SubGrupo fetchBynombre_First(
		String nombre, OrderByComparator<SubGrupo> orderByComparator) {

		List<SubGrupo> list = findBynombre(nombre, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sub grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub grupo
	 * @throws NoSuchSubGrupoException if a matching sub grupo could not be found
	 */
	@Override
	public SubGrupo findBynombre_Last(
			String nombre, OrderByComparator<SubGrupo> orderByComparator)
		throws NoSuchSubGrupoException {

		SubGrupo subGrupo = fetchBynombre_Last(nombre, orderByComparator);

		if (subGrupo != null) {
			return subGrupo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nombre=");
		sb.append(nombre);

		sb.append("}");

		throw new NoSuchSubGrupoException(sb.toString());
	}

	/**
	 * Returns the last sub grupo in the ordered set where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sub grupo, or <code>null</code> if a matching sub grupo could not be found
	 */
	@Override
	public SubGrupo fetchBynombre_Last(
		String nombre, OrderByComparator<SubGrupo> orderByComparator) {

		int count = countBynombre(nombre);

		if (count == 0) {
			return null;
		}

		List<SubGrupo> list = findBynombre(
			nombre, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sub grupos before and after the current sub grupo in the ordered set where nombre = &#63;.
	 *
	 * @param entityId the primary key of the current sub grupo
	 * @param nombre the nombre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sub grupo
	 * @throws NoSuchSubGrupoException if a sub grupo with the primary key could not be found
	 */
	@Override
	public SubGrupo[] findBynombre_PrevAndNext(
			long entityId, String nombre,
			OrderByComparator<SubGrupo> orderByComparator)
		throws NoSuchSubGrupoException {

		nombre = Objects.toString(nombre, "");

		SubGrupo subGrupo = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			SubGrupo[] array = new SubGrupoImpl[3];

			array[0] = getBynombre_PrevAndNext(
				session, subGrupo, nombre, orderByComparator, true);

			array[1] = subGrupo;

			array[2] = getBynombre_PrevAndNext(
				session, subGrupo, nombre, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SubGrupo getBynombre_PrevAndNext(
		Session session, SubGrupo subGrupo, String nombre,
		OrderByComparator<SubGrupo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SUBGRUPO_WHERE);

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
			sb.append(SubGrupoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(subGrupo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SubGrupo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sub grupos where nombre = &#63; from the database.
	 *
	 * @param nombre the nombre
	 */
	@Override
	public void removeBynombre(String nombre) {
		for (SubGrupo subGrupo :
				findBynombre(
					nombre, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(subGrupo);
		}
	}

	/**
	 * Returns the number of sub grupos where nombre = &#63;.
	 *
	 * @param nombre the nombre
	 * @return the number of matching sub grupos
	 */
	@Override
	public int countBynombre(String nombre) {
		nombre = Objects.toString(nombre, "");

		FinderPath finderPath = _finderPathCountBynombre;

		Object[] finderArgs = new Object[] {nombre};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SUBGRUPO_WHERE);

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
		"subGrupo.nombre = ?";

	private static final String _FINDER_COLUMN_NOMBRE_NOMBRE_3 =
		"(subGrupo.nombre IS NULL OR subGrupo.nombre = '')";

	private FinderPath _finderPathFetchBysubGrupoId;
	private FinderPath _finderPathCountBysubGrupoId;

	/**
	 * Returns the sub grupo where subGrupoId = &#63; or throws a <code>NoSuchSubGrupoException</code> if it could not be found.
	 *
	 * @param subGrupoId the sub grupo ID
	 * @return the matching sub grupo
	 * @throws NoSuchSubGrupoException if a matching sub grupo could not be found
	 */
	@Override
	public SubGrupo findBysubGrupoId(long subGrupoId)
		throws NoSuchSubGrupoException {

		SubGrupo subGrupo = fetchBysubGrupoId(subGrupoId);

		if (subGrupo == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("subGrupoId=");
			sb.append(subGrupoId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSubGrupoException(sb.toString());
		}

		return subGrupo;
	}

	/**
	 * Returns the sub grupo where subGrupoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param subGrupoId the sub grupo ID
	 * @return the matching sub grupo, or <code>null</code> if a matching sub grupo could not be found
	 */
	@Override
	public SubGrupo fetchBysubGrupoId(long subGrupoId) {
		return fetchBysubGrupoId(subGrupoId, true);
	}

	/**
	 * Returns the sub grupo where subGrupoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param subGrupoId the sub grupo ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching sub grupo, or <code>null</code> if a matching sub grupo could not be found
	 */
	@Override
	public SubGrupo fetchBysubGrupoId(long subGrupoId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {subGrupoId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBysubGrupoId, finderArgs, this);
		}

		if (result instanceof SubGrupo) {
			SubGrupo subGrupo = (SubGrupo)result;

			if (subGrupoId != subGrupo.getSubGrupoId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_SUBGRUPO_WHERE);

			sb.append(_FINDER_COLUMN_SUBGRUPOID_SUBGRUPOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subGrupoId);

				List<SubGrupo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBysubGrupoId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {subGrupoId};
							}

							_log.warn(
								"SubGrupoPersistenceImpl.fetchBysubGrupoId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SubGrupo subGrupo = list.get(0);

					result = subGrupo;

					cacheResult(subGrupo);
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
			return (SubGrupo)result;
		}
	}

	/**
	 * Removes the sub grupo where subGrupoId = &#63; from the database.
	 *
	 * @param subGrupoId the sub grupo ID
	 * @return the sub grupo that was removed
	 */
	@Override
	public SubGrupo removeBysubGrupoId(long subGrupoId)
		throws NoSuchSubGrupoException {

		SubGrupo subGrupo = findBysubGrupoId(subGrupoId);

		return remove(subGrupo);
	}

	/**
	 * Returns the number of sub grupos where subGrupoId = &#63;.
	 *
	 * @param subGrupoId the sub grupo ID
	 * @return the number of matching sub grupos
	 */
	@Override
	public int countBysubGrupoId(long subGrupoId) {
		FinderPath finderPath = _finderPathCountBysubGrupoId;

		Object[] finderArgs = new Object[] {subGrupoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SUBGRUPO_WHERE);

			sb.append(_FINDER_COLUMN_SUBGRUPOID_SUBGRUPOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subGrupoId);

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

	private static final String _FINDER_COLUMN_SUBGRUPOID_SUBGRUPOID_2 =
		"subGrupo.subGrupoId = ?";

	public SubGrupoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SubGrupo.class);

		setModelImplClass(SubGrupoImpl.class);
		setModelPKClass(long.class);

		setTable(SubGrupoTable.INSTANCE);
	}

	/**
	 * Caches the sub grupo in the entity cache if it is enabled.
	 *
	 * @param subGrupo the sub grupo
	 */
	@Override
	public void cacheResult(SubGrupo subGrupo) {
		entityCache.putResult(
			SubGrupoImpl.class, subGrupo.getPrimaryKey(), subGrupo);

		finderCache.putResult(
			_finderPathFetchBysubGrupoId,
			new Object[] {subGrupo.getSubGrupoId()}, subGrupo);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the sub grupos in the entity cache if it is enabled.
	 *
	 * @param subGrupos the sub grupos
	 */
	@Override
	public void cacheResult(List<SubGrupo> subGrupos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (subGrupos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SubGrupo subGrupo : subGrupos) {
			if (entityCache.getResult(
					SubGrupoImpl.class, subGrupo.getPrimaryKey()) == null) {

				cacheResult(subGrupo);
			}
		}
	}

	/**
	 * Clears the cache for all sub grupos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SubGrupoImpl.class);

		finderCache.clearCache(SubGrupoImpl.class);
	}

	/**
	 * Clears the cache for the sub grupo.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SubGrupo subGrupo) {
		entityCache.removeResult(SubGrupoImpl.class, subGrupo);
	}

	@Override
	public void clearCache(List<SubGrupo> subGrupos) {
		for (SubGrupo subGrupo : subGrupos) {
			entityCache.removeResult(SubGrupoImpl.class, subGrupo);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SubGrupoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SubGrupoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SubGrupoModelImpl subGrupoModelImpl) {

		Object[] args = new Object[] {subGrupoModelImpl.getSubGrupoId()};

		finderCache.putResult(
			_finderPathCountBysubGrupoId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBysubGrupoId, args, subGrupoModelImpl);
	}

	/**
	 * Creates a new sub grupo with the primary key. Does not add the sub grupo to the database.
	 *
	 * @param entityId the primary key for the new sub grupo
	 * @return the new sub grupo
	 */
	@Override
	public SubGrupo create(long entityId) {
		SubGrupo subGrupo = new SubGrupoImpl();

		subGrupo.setNew(true);
		subGrupo.setPrimaryKey(entityId);

		String uuid = PortalUUIDUtil.generate();

		subGrupo.setUuid(uuid);

		return subGrupo;
	}

	/**
	 * Removes the sub grupo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the sub grupo
	 * @return the sub grupo that was removed
	 * @throws NoSuchSubGrupoException if a sub grupo with the primary key could not be found
	 */
	@Override
	public SubGrupo remove(long entityId) throws NoSuchSubGrupoException {
		return remove((Serializable)entityId);
	}

	/**
	 * Removes the sub grupo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sub grupo
	 * @return the sub grupo that was removed
	 * @throws NoSuchSubGrupoException if a sub grupo with the primary key could not be found
	 */
	@Override
	public SubGrupo remove(Serializable primaryKey)
		throws NoSuchSubGrupoException {

		Session session = null;

		try {
			session = openSession();

			SubGrupo subGrupo = (SubGrupo)session.get(
				SubGrupoImpl.class, primaryKey);

			if (subGrupo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubGrupoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(subGrupo);
		}
		catch (NoSuchSubGrupoException noSuchEntityException) {
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
	protected SubGrupo removeImpl(SubGrupo subGrupo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(subGrupo)) {
				subGrupo = (SubGrupo)session.get(
					SubGrupoImpl.class, subGrupo.getPrimaryKeyObj());
			}

			if (subGrupo != null) {
				session.delete(subGrupo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (subGrupo != null) {
			clearCache(subGrupo);
		}

		return subGrupo;
	}

	@Override
	public SubGrupo updateImpl(SubGrupo subGrupo) {
		boolean isNew = subGrupo.isNew();

		if (!(subGrupo instanceof SubGrupoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(subGrupo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(subGrupo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in subGrupo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SubGrupo implementation " +
					subGrupo.getClass());
		}

		SubGrupoModelImpl subGrupoModelImpl = (SubGrupoModelImpl)subGrupo;

		if (Validator.isNull(subGrupo.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			subGrupo.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (subGrupo.getCreateDate() == null)) {
			if (serviceContext == null) {
				subGrupo.setCreateDate(date);
			}
			else {
				subGrupo.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!subGrupoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				subGrupo.setModifiedDate(date);
			}
			else {
				subGrupo.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(subGrupo);
			}
			else {
				subGrupo = (SubGrupo)session.merge(subGrupo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SubGrupoImpl.class, subGrupoModelImpl, false, true);

		cacheUniqueFindersCache(subGrupoModelImpl);

		if (isNew) {
			subGrupo.setNew(false);
		}

		subGrupo.resetOriginalValues();

		return subGrupo;
	}

	/**
	 * Returns the sub grupo with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sub grupo
	 * @return the sub grupo
	 * @throws NoSuchSubGrupoException if a sub grupo with the primary key could not be found
	 */
	@Override
	public SubGrupo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubGrupoException {

		SubGrupo subGrupo = fetchByPrimaryKey(primaryKey);

		if (subGrupo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubGrupoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return subGrupo;
	}

	/**
	 * Returns the sub grupo with the primary key or throws a <code>NoSuchSubGrupoException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the sub grupo
	 * @return the sub grupo
	 * @throws NoSuchSubGrupoException if a sub grupo with the primary key could not be found
	 */
	@Override
	public SubGrupo findByPrimaryKey(long entityId)
		throws NoSuchSubGrupoException {

		return findByPrimaryKey((Serializable)entityId);
	}

	/**
	 * Returns the sub grupo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the sub grupo
	 * @return the sub grupo, or <code>null</code> if a sub grupo with the primary key could not be found
	 */
	@Override
	public SubGrupo fetchByPrimaryKey(long entityId) {
		return fetchByPrimaryKey((Serializable)entityId);
	}

	/**
	 * Returns all the sub grupos.
	 *
	 * @return the sub grupos
	 */
	@Override
	public List<SubGrupo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sub grupos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubGrupoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub grupos
	 * @param end the upper bound of the range of sub grupos (not inclusive)
	 * @return the range of sub grupos
	 */
	@Override
	public List<SubGrupo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sub grupos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubGrupoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub grupos
	 * @param end the upper bound of the range of sub grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sub grupos
	 */
	@Override
	public List<SubGrupo> findAll(
		int start, int end, OrderByComparator<SubGrupo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sub grupos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubGrupoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sub grupos
	 * @param end the upper bound of the range of sub grupos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sub grupos
	 */
	@Override
	public List<SubGrupo> findAll(
		int start, int end, OrderByComparator<SubGrupo> orderByComparator,
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

		List<SubGrupo> list = null;

		if (useFinderCache) {
			list = (List<SubGrupo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SUBGRUPO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SUBGRUPO;

				sql = sql.concat(SubGrupoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SubGrupo>)QueryUtil.list(
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
	 * Removes all the sub grupos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SubGrupo subGrupo : findAll()) {
			remove(subGrupo);
		}
	}

	/**
	 * Returns the number of sub grupos.
	 *
	 * @return the number of sub grupos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SUBGRUPO);

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
		return _SQL_SELECT_SUBGRUPO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SubGrupoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sub grupo persistence.
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

		_finderPathFetchBysubGrupoId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBysubGrupoId",
			new String[] {Long.class.getName()}, new String[] {"subGrupoId"},
			true);

		_finderPathCountBysubGrupoId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysubGrupoId",
			new String[] {Long.class.getName()}, new String[] {"subGrupoId"},
			false);

		SubGrupoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		SubGrupoUtil.setPersistence(null);

		entityCache.removeCache(SubGrupoImpl.class.getName());
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

	private static final String _SQL_SELECT_SUBGRUPO =
		"SELECT subGrupo FROM SubGrupo subGrupo";

	private static final String _SQL_SELECT_SUBGRUPO_WHERE =
		"SELECT subGrupo FROM SubGrupo subGrupo WHERE ";

	private static final String _SQL_COUNT_SUBGRUPO =
		"SELECT COUNT(subGrupo) FROM SubGrupo subGrupo";

	private static final String _SQL_COUNT_SUBGRUPO_WHERE =
		"SELECT COUNT(subGrupo) FROM SubGrupo subGrupo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "subGrupo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SubGrupo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SubGrupo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SubGrupoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}