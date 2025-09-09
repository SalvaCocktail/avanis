/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence.impl;

import avanis.lonjas.exception.NoSuchProductoUserException;
import avanis.lonjas.model.ProductoUser;
import avanis.lonjas.model.ProductoUserTable;
import avanis.lonjas.model.impl.ProductoUserImpl;
import avanis.lonjas.model.impl.ProductoUserModelImpl;
import avanis.lonjas.service.persistence.ProductoUserPersistence;
import avanis.lonjas.service.persistence.ProductoUserUtil;
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
 * The persistence implementation for the producto user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProductoUserPersistence.class)
public class ProductoUserPersistenceImpl
	extends BasePersistenceImpl<ProductoUser>
	implements ProductoUserPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProductoUserUtil</code> to access the producto user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProductoUserImpl.class.getName();

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
	 * Returns all the producto users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching producto users
	 */
	@Override
	public List<ProductoUser> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producto users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of producto users
	 * @param end the upper bound of the range of producto users (not inclusive)
	 * @return the range of matching producto users
	 */
	@Override
	public List<ProductoUser> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the producto users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of producto users
	 * @param end the upper bound of the range of producto users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producto users
	 */
	@Override
	public List<ProductoUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductoUser> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the producto users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of producto users
	 * @param end the upper bound of the range of producto users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producto users
	 */
	@Override
	public List<ProductoUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductoUser> orderByComparator,
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

		List<ProductoUser> list = null;

		if (useFinderCache) {
			list = (List<ProductoUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductoUser productoUser : list) {
					if (!uuid.equals(productoUser.getUuid())) {
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

			sb.append(_SQL_SELECT_PRODUCTOUSER_WHERE);

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
				sb.append(ProductoUserModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProductoUser>)QueryUtil.list(
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
	 * Returns the first producto user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto user
	 * @throws NoSuchProductoUserException if a matching producto user could not be found
	 */
	@Override
	public ProductoUser findByUuid_First(
			String uuid, OrderByComparator<ProductoUser> orderByComparator)
		throws NoSuchProductoUserException {

		ProductoUser productoUser = fetchByUuid_First(uuid, orderByComparator);

		if (productoUser != null) {
			return productoUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductoUserException(sb.toString());
	}

	/**
	 * Returns the first producto user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto user, or <code>null</code> if a matching producto user could not be found
	 */
	@Override
	public ProductoUser fetchByUuid_First(
		String uuid, OrderByComparator<ProductoUser> orderByComparator) {

		List<ProductoUser> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last producto user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto user
	 * @throws NoSuchProductoUserException if a matching producto user could not be found
	 */
	@Override
	public ProductoUser findByUuid_Last(
			String uuid, OrderByComparator<ProductoUser> orderByComparator)
		throws NoSuchProductoUserException {

		ProductoUser productoUser = fetchByUuid_Last(uuid, orderByComparator);

		if (productoUser != null) {
			return productoUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductoUserException(sb.toString());
	}

	/**
	 * Returns the last producto user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto user, or <code>null</code> if a matching producto user could not be found
	 */
	@Override
	public ProductoUser fetchByUuid_Last(
		String uuid, OrderByComparator<ProductoUser> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProductoUser> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the producto users before and after the current producto user in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current producto user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producto user
	 * @throws NoSuchProductoUserException if a producto user with the primary key could not be found
	 */
	@Override
	public ProductoUser[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			OrderByComparator<ProductoUser> orderByComparator)
		throws NoSuchProductoUserException {

		uuid = Objects.toString(uuid, "");

		ProductoUser productoUser = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			ProductoUser[] array = new ProductoUserImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, productoUser, uuid, orderByComparator, true);

			array[1] = productoUser;

			array[2] = getByUuid_PrevAndNext(
				session, productoUser, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductoUser getByUuid_PrevAndNext(
		Session session, ProductoUser productoUser, String uuid,
		OrderByComparator<ProductoUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PRODUCTOUSER_WHERE);

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
			sb.append(ProductoUserModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(productoUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductoUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the producto users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProductoUser productoUser :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(productoUser);
		}
	}

	/**
	 * Returns the number of producto users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching producto users
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTOUSER_WHERE);

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
		"productoUser.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(productoUser.uuid IS NULL OR productoUser.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByuserId;
	private FinderPath _finderPathWithoutPaginationFindByuserId;
	private FinderPath _finderPathCountByuserId;

	/**
	 * Returns all the producto users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching producto users
	 */
	@Override
	public List<ProductoUser> findByuserId(long userId) {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producto users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of producto users
	 * @param end the upper bound of the range of producto users (not inclusive)
	 * @return the range of matching producto users
	 */
	@Override
	public List<ProductoUser> findByuserId(long userId, int start, int end) {
		return findByuserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the producto users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of producto users
	 * @param end the upper bound of the range of producto users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producto users
	 */
	@Override
	public List<ProductoUser> findByuserId(
		long userId, int start, int end,
		OrderByComparator<ProductoUser> orderByComparator) {

		return findByuserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the producto users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of producto users
	 * @param end the upper bound of the range of producto users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producto users
	 */
	@Override
	public List<ProductoUser> findByuserId(
		long userId, int start, int end,
		OrderByComparator<ProductoUser> orderByComparator,
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

		List<ProductoUser> list = null;

		if (useFinderCache) {
			list = (List<ProductoUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductoUser productoUser : list) {
					if (userId != productoUser.getUserId()) {
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

			sb.append(_SQL_SELECT_PRODUCTOUSER_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProductoUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<ProductoUser>)QueryUtil.list(
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
	 * Returns the first producto user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto user
	 * @throws NoSuchProductoUserException if a matching producto user could not be found
	 */
	@Override
	public ProductoUser findByuserId_First(
			long userId, OrderByComparator<ProductoUser> orderByComparator)
		throws NoSuchProductoUserException {

		ProductoUser productoUser = fetchByuserId_First(
			userId, orderByComparator);

		if (productoUser != null) {
			return productoUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchProductoUserException(sb.toString());
	}

	/**
	 * Returns the first producto user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto user, or <code>null</code> if a matching producto user could not be found
	 */
	@Override
	public ProductoUser fetchByuserId_First(
		long userId, OrderByComparator<ProductoUser> orderByComparator) {

		List<ProductoUser> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last producto user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto user
	 * @throws NoSuchProductoUserException if a matching producto user could not be found
	 */
	@Override
	public ProductoUser findByuserId_Last(
			long userId, OrderByComparator<ProductoUser> orderByComparator)
		throws NoSuchProductoUserException {

		ProductoUser productoUser = fetchByuserId_Last(
			userId, orderByComparator);

		if (productoUser != null) {
			return productoUser;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchProductoUserException(sb.toString());
	}

	/**
	 * Returns the last producto user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto user, or <code>null</code> if a matching producto user could not be found
	 */
	@Override
	public ProductoUser fetchByuserId_Last(
		long userId, OrderByComparator<ProductoUser> orderByComparator) {

		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<ProductoUser> list = findByuserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the producto users before and after the current producto user in the ordered set where userId = &#63;.
	 *
	 * @param entityId the primary key of the current producto user
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producto user
	 * @throws NoSuchProductoUserException if a producto user with the primary key could not be found
	 */
	@Override
	public ProductoUser[] findByuserId_PrevAndNext(
			long entityId, long userId,
			OrderByComparator<ProductoUser> orderByComparator)
		throws NoSuchProductoUserException {

		ProductoUser productoUser = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			ProductoUser[] array = new ProductoUserImpl[3];

			array[0] = getByuserId_PrevAndNext(
				session, productoUser, userId, orderByComparator, true);

			array[1] = productoUser;

			array[2] = getByuserId_PrevAndNext(
				session, productoUser, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductoUser getByuserId_PrevAndNext(
		Session session, ProductoUser productoUser, long userId,
		OrderByComparator<ProductoUser> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PRODUCTOUSER_WHERE);

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
			sb.append(ProductoUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(productoUser)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductoUser> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the producto users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByuserId(long userId) {
		for (ProductoUser productoUser :
				findByuserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(productoUser);
		}
	}

	/**
	 * Returns the number of producto users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching producto users
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = _finderPathCountByuserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTOUSER_WHERE);

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
		"productoUser.userId = ?";

	private FinderPath _finderPathFetchByuserIdlonjaIdproductoId;
	private FinderPath _finderPathCountByuserIdlonjaIdproductoId;

	/**
	 * Returns the producto user where userId = &#63; and lonjaId = &#63; and productoId = &#63; or throws a <code>NoSuchProductoUserException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @return the matching producto user
	 * @throws NoSuchProductoUserException if a matching producto user could not be found
	 */
	@Override
	public ProductoUser findByuserIdlonjaIdproductoId(
			long userId, long lonjaId, long productoId)
		throws NoSuchProductoUserException {

		ProductoUser productoUser = fetchByuserIdlonjaIdproductoId(
			userId, lonjaId, productoId);

		if (productoUser == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append(", lonjaId=");
			sb.append(lonjaId);

			sb.append(", productoId=");
			sb.append(productoId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProductoUserException(sb.toString());
		}

		return productoUser;
	}

	/**
	 * Returns the producto user where userId = &#63; and lonjaId = &#63; and productoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @return the matching producto user, or <code>null</code> if a matching producto user could not be found
	 */
	@Override
	public ProductoUser fetchByuserIdlonjaIdproductoId(
		long userId, long lonjaId, long productoId) {

		return fetchByuserIdlonjaIdproductoId(
			userId, lonjaId, productoId, true);
	}

	/**
	 * Returns the producto user where userId = &#63; and lonjaId = &#63; and productoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching producto user, or <code>null</code> if a matching producto user could not be found
	 */
	@Override
	public ProductoUser fetchByuserIdlonjaIdproductoId(
		long userId, long lonjaId, long productoId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId, lonjaId, productoId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByuserIdlonjaIdproductoId, finderArgs, this);
		}

		if (result instanceof ProductoUser) {
			ProductoUser productoUser = (ProductoUser)result;

			if ((userId != productoUser.getUserId()) ||
				(lonjaId != productoUser.getLonjaId()) ||
				(productoId != productoUser.getProductoId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_PRODUCTOUSER_WHERE);

			sb.append(_FINDER_COLUMN_USERIDLONJAIDPRODUCTOID_USERID_2);

			sb.append(_FINDER_COLUMN_USERIDLONJAIDPRODUCTOID_LONJAID_2);

			sb.append(_FINDER_COLUMN_USERIDLONJAIDPRODUCTOID_PRODUCTOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				queryPos.add(lonjaId);

				queryPos.add(productoId);

				List<ProductoUser> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByuserIdlonjaIdproductoId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									userId, lonjaId, productoId
								};
							}

							_log.warn(
								"ProductoUserPersistenceImpl.fetchByuserIdlonjaIdproductoId(long, long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProductoUser productoUser = list.get(0);

					result = productoUser;

					cacheResult(productoUser);
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
			return (ProductoUser)result;
		}
	}

	/**
	 * Removes the producto user where userId = &#63; and lonjaId = &#63; and productoId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @return the producto user that was removed
	 */
	@Override
	public ProductoUser removeByuserIdlonjaIdproductoId(
			long userId, long lonjaId, long productoId)
		throws NoSuchProductoUserException {

		ProductoUser productoUser = findByuserIdlonjaIdproductoId(
			userId, lonjaId, productoId);

		return remove(productoUser);
	}

	/**
	 * Returns the number of producto users where userId = &#63; and lonjaId = &#63; and productoId = &#63;.
	 *
	 * @param userId the user ID
	 * @param lonjaId the lonja ID
	 * @param productoId the producto ID
	 * @return the number of matching producto users
	 */
	@Override
	public int countByuserIdlonjaIdproductoId(
		long userId, long lonjaId, long productoId) {

		FinderPath finderPath = _finderPathCountByuserIdlonjaIdproductoId;

		Object[] finderArgs = new Object[] {userId, lonjaId, productoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_PRODUCTOUSER_WHERE);

			sb.append(_FINDER_COLUMN_USERIDLONJAIDPRODUCTOID_USERID_2);

			sb.append(_FINDER_COLUMN_USERIDLONJAIDPRODUCTOID_LONJAID_2);

			sb.append(_FINDER_COLUMN_USERIDLONJAIDPRODUCTOID_PRODUCTOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String
		_FINDER_COLUMN_USERIDLONJAIDPRODUCTOID_USERID_2 =
			"productoUser.userId = ? AND ";

	private static final String
		_FINDER_COLUMN_USERIDLONJAIDPRODUCTOID_LONJAID_2 =
			"productoUser.lonjaId = ? AND ";

	private static final String
		_FINDER_COLUMN_USERIDLONJAIDPRODUCTOID_PRODUCTOID_2 =
			"productoUser.productoId = ?";

	public ProductoUserPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProductoUser.class);

		setModelImplClass(ProductoUserImpl.class);
		setModelPKClass(long.class);

		setTable(ProductoUserTable.INSTANCE);
	}

	/**
	 * Caches the producto user in the entity cache if it is enabled.
	 *
	 * @param productoUser the producto user
	 */
	@Override
	public void cacheResult(ProductoUser productoUser) {
		entityCache.putResult(
			ProductoUserImpl.class, productoUser.getPrimaryKey(), productoUser);

		finderCache.putResult(
			_finderPathFetchByuserIdlonjaIdproductoId,
			new Object[] {
				productoUser.getUserId(), productoUser.getLonjaId(),
				productoUser.getProductoId()
			},
			productoUser);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the producto users in the entity cache if it is enabled.
	 *
	 * @param productoUsers the producto users
	 */
	@Override
	public void cacheResult(List<ProductoUser> productoUsers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (productoUsers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProductoUser productoUser : productoUsers) {
			if (entityCache.getResult(
					ProductoUserImpl.class, productoUser.getPrimaryKey()) ==
						null) {

				cacheResult(productoUser);
			}
		}
	}

	/**
	 * Clears the cache for all producto users.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProductoUserImpl.class);

		finderCache.clearCache(ProductoUserImpl.class);
	}

	/**
	 * Clears the cache for the producto user.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductoUser productoUser) {
		entityCache.removeResult(ProductoUserImpl.class, productoUser);
	}

	@Override
	public void clearCache(List<ProductoUser> productoUsers) {
		for (ProductoUser productoUser : productoUsers) {
			entityCache.removeResult(ProductoUserImpl.class, productoUser);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProductoUserImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProductoUserImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProductoUserModelImpl productoUserModelImpl) {

		Object[] args = new Object[] {
			productoUserModelImpl.getUserId(),
			productoUserModelImpl.getLonjaId(),
			productoUserModelImpl.getProductoId()
		};

		finderCache.putResult(
			_finderPathCountByuserIdlonjaIdproductoId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByuserIdlonjaIdproductoId, args,
			productoUserModelImpl);
	}

	/**
	 * Creates a new producto user with the primary key. Does not add the producto user to the database.
	 *
	 * @param entityId the primary key for the new producto user
	 * @return the new producto user
	 */
	@Override
	public ProductoUser create(long entityId) {
		ProductoUser productoUser = new ProductoUserImpl();

		productoUser.setNew(true);
		productoUser.setPrimaryKey(entityId);

		String uuid = PortalUUIDUtil.generate();

		productoUser.setUuid(uuid);

		return productoUser;
	}

	/**
	 * Removes the producto user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the producto user
	 * @return the producto user that was removed
	 * @throws NoSuchProductoUserException if a producto user with the primary key could not be found
	 */
	@Override
	public ProductoUser remove(long entityId)
		throws NoSuchProductoUserException {

		return remove((Serializable)entityId);
	}

	/**
	 * Removes the producto user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the producto user
	 * @return the producto user that was removed
	 * @throws NoSuchProductoUserException if a producto user with the primary key could not be found
	 */
	@Override
	public ProductoUser remove(Serializable primaryKey)
		throws NoSuchProductoUserException {

		Session session = null;

		try {
			session = openSession();

			ProductoUser productoUser = (ProductoUser)session.get(
				ProductoUserImpl.class, primaryKey);

			if (productoUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductoUserException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(productoUser);
		}
		catch (NoSuchProductoUserException noSuchEntityException) {
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
	protected ProductoUser removeImpl(ProductoUser productoUser) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productoUser)) {
				productoUser = (ProductoUser)session.get(
					ProductoUserImpl.class, productoUser.getPrimaryKeyObj());
			}

			if (productoUser != null) {
				session.delete(productoUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (productoUser != null) {
			clearCache(productoUser);
		}

		return productoUser;
	}

	@Override
	public ProductoUser updateImpl(ProductoUser productoUser) {
		boolean isNew = productoUser.isNew();

		if (!(productoUser instanceof ProductoUserModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(productoUser.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					productoUser);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in productoUser proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProductoUser implementation " +
					productoUser.getClass());
		}

		ProductoUserModelImpl productoUserModelImpl =
			(ProductoUserModelImpl)productoUser;

		if (Validator.isNull(productoUser.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			productoUser.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (productoUser.getCreateDate() == null)) {
			if (serviceContext == null) {
				productoUser.setCreateDate(date);
			}
			else {
				productoUser.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!productoUserModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				productoUser.setModifiedDate(date);
			}
			else {
				productoUser.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(productoUser);
			}
			else {
				productoUser = (ProductoUser)session.merge(productoUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProductoUserImpl.class, productoUserModelImpl, false, true);

		cacheUniqueFindersCache(productoUserModelImpl);

		if (isNew) {
			productoUser.setNew(false);
		}

		productoUser.resetOriginalValues();

		return productoUser;
	}

	/**
	 * Returns the producto user with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the producto user
	 * @return the producto user
	 * @throws NoSuchProductoUserException if a producto user with the primary key could not be found
	 */
	@Override
	public ProductoUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductoUserException {

		ProductoUser productoUser = fetchByPrimaryKey(primaryKey);

		if (productoUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductoUserException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return productoUser;
	}

	/**
	 * Returns the producto user with the primary key or throws a <code>NoSuchProductoUserException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the producto user
	 * @return the producto user
	 * @throws NoSuchProductoUserException if a producto user with the primary key could not be found
	 */
	@Override
	public ProductoUser findByPrimaryKey(long entityId)
		throws NoSuchProductoUserException {

		return findByPrimaryKey((Serializable)entityId);
	}

	/**
	 * Returns the producto user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the producto user
	 * @return the producto user, or <code>null</code> if a producto user with the primary key could not be found
	 */
	@Override
	public ProductoUser fetchByPrimaryKey(long entityId) {
		return fetchByPrimaryKey((Serializable)entityId);
	}

	/**
	 * Returns all the producto users.
	 *
	 * @return the producto users
	 */
	@Override
	public List<ProductoUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producto users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of producto users
	 * @param end the upper bound of the range of producto users (not inclusive)
	 * @return the range of producto users
	 */
	@Override
	public List<ProductoUser> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the producto users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of producto users
	 * @param end the upper bound of the range of producto users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of producto users
	 */
	@Override
	public List<ProductoUser> findAll(
		int start, int end, OrderByComparator<ProductoUser> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the producto users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of producto users
	 * @param end the upper bound of the range of producto users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of producto users
	 */
	@Override
	public List<ProductoUser> findAll(
		int start, int end, OrderByComparator<ProductoUser> orderByComparator,
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

		List<ProductoUser> list = null;

		if (useFinderCache) {
			list = (List<ProductoUser>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRODUCTOUSER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTOUSER;

				sql = sql.concat(ProductoUserModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProductoUser>)QueryUtil.list(
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
	 * Removes all the producto users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProductoUser productoUser : findAll()) {
			remove(productoUser);
		}
	}

	/**
	 * Returns the number of producto users.
	 *
	 * @return the number of producto users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PRODUCTOUSER);

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
		return _SQL_SELECT_PRODUCTOUSER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProductoUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the producto user persistence.
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

		_finderPathFetchByuserIdlonjaIdproductoId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByuserIdlonjaIdproductoId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			new String[] {"userId", "lonjaId", "productoId"}, true);

		_finderPathCountByuserIdlonjaIdproductoId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByuserIdlonjaIdproductoId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			new String[] {"userId", "lonjaId", "productoId"}, false);

		ProductoUserUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ProductoUserUtil.setPersistence(null);

		entityCache.removeCache(ProductoUserImpl.class.getName());
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

	private static final String _SQL_SELECT_PRODUCTOUSER =
		"SELECT productoUser FROM ProductoUser productoUser";

	private static final String _SQL_SELECT_PRODUCTOUSER_WHERE =
		"SELECT productoUser FROM ProductoUser productoUser WHERE ";

	private static final String _SQL_COUNT_PRODUCTOUSER =
		"SELECT COUNT(productoUser) FROM ProductoUser productoUser";

	private static final String _SQL_COUNT_PRODUCTOUSER_WHERE =
		"SELECT COUNT(productoUser) FROM ProductoUser productoUser WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "productoUser.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProductoUser exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProductoUser exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProductoUserPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}