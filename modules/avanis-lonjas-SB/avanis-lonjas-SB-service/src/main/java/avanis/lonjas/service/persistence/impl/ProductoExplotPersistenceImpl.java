/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence.impl;

import avanis.lonjas.exception.NoSuchProductoExplotException;
import avanis.lonjas.model.ProductoExplot;
import avanis.lonjas.model.ProductoExplotTable;
import avanis.lonjas.model.impl.ProductoExplotImpl;
import avanis.lonjas.model.impl.ProductoExplotModelImpl;
import avanis.lonjas.service.persistence.ProductoExplotPersistence;
import avanis.lonjas.service.persistence.ProductoExplotUtil;
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
 * The persistence implementation for the producto explot service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProductoExplotPersistence.class)
public class ProductoExplotPersistenceImpl
	extends BasePersistenceImpl<ProductoExplot>
	implements ProductoExplotPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProductoExplotUtil</code> to access the producto explot persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProductoExplotImpl.class.getName();

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
	 * Returns all the producto explots where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching producto explots
	 */
	@Override
	public List<ProductoExplot> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producto explots where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoExplotModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of producto explots
	 * @param end the upper bound of the range of producto explots (not inclusive)
	 * @return the range of matching producto explots
	 */
	@Override
	public List<ProductoExplot> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the producto explots where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoExplotModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of producto explots
	 * @param end the upper bound of the range of producto explots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producto explots
	 */
	@Override
	public List<ProductoExplot> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductoExplot> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the producto explots where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoExplotModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of producto explots
	 * @param end the upper bound of the range of producto explots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producto explots
	 */
	@Override
	public List<ProductoExplot> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProductoExplot> orderByComparator,
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

		List<ProductoExplot> list = null;

		if (useFinderCache) {
			list = (List<ProductoExplot>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductoExplot productoExplot : list) {
					if (!uuid.equals(productoExplot.getUuid())) {
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

			sb.append(_SQL_SELECT_PRODUCTOEXPLOT_WHERE);

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
				sb.append(ProductoExplotModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProductoExplot>)QueryUtil.list(
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
	 * Returns the first producto explot in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto explot
	 * @throws NoSuchProductoExplotException if a matching producto explot could not be found
	 */
	@Override
	public ProductoExplot findByUuid_First(
			String uuid, OrderByComparator<ProductoExplot> orderByComparator)
		throws NoSuchProductoExplotException {

		ProductoExplot productoExplot = fetchByUuid_First(
			uuid, orderByComparator);

		if (productoExplot != null) {
			return productoExplot;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductoExplotException(sb.toString());
	}

	/**
	 * Returns the first producto explot in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto explot, or <code>null</code> if a matching producto explot could not be found
	 */
	@Override
	public ProductoExplot fetchByUuid_First(
		String uuid, OrderByComparator<ProductoExplot> orderByComparator) {

		List<ProductoExplot> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last producto explot in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto explot
	 * @throws NoSuchProductoExplotException if a matching producto explot could not be found
	 */
	@Override
	public ProductoExplot findByUuid_Last(
			String uuid, OrderByComparator<ProductoExplot> orderByComparator)
		throws NoSuchProductoExplotException {

		ProductoExplot productoExplot = fetchByUuid_Last(
			uuid, orderByComparator);

		if (productoExplot != null) {
			return productoExplot;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProductoExplotException(sb.toString());
	}

	/**
	 * Returns the last producto explot in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto explot, or <code>null</code> if a matching producto explot could not be found
	 */
	@Override
	public ProductoExplot fetchByUuid_Last(
		String uuid, OrderByComparator<ProductoExplot> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProductoExplot> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the producto explots before and after the current producto explot in the ordered set where uuid = &#63;.
	 *
	 * @param entityId the primary key of the current producto explot
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producto explot
	 * @throws NoSuchProductoExplotException if a producto explot with the primary key could not be found
	 */
	@Override
	public ProductoExplot[] findByUuid_PrevAndNext(
			long entityId, String uuid,
			OrderByComparator<ProductoExplot> orderByComparator)
		throws NoSuchProductoExplotException {

		uuid = Objects.toString(uuid, "");

		ProductoExplot productoExplot = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			ProductoExplot[] array = new ProductoExplotImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, productoExplot, uuid, orderByComparator, true);

			array[1] = productoExplot;

			array[2] = getByUuid_PrevAndNext(
				session, productoExplot, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductoExplot getByUuid_PrevAndNext(
		Session session, ProductoExplot productoExplot, String uuid,
		OrderByComparator<ProductoExplot> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PRODUCTOEXPLOT_WHERE);

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
			sb.append(ProductoExplotModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						productoExplot)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductoExplot> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the producto explots where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProductoExplot productoExplot :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(productoExplot);
		}
	}

	/**
	 * Returns the number of producto explots where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching producto explots
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTOEXPLOT_WHERE);

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
		"productoExplot.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(productoExplot.uuid IS NULL OR productoExplot.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByexplotacionId;
	private FinderPath _finderPathWithoutPaginationFindByexplotacionId;
	private FinderPath _finderPathCountByexplotacionId;

	/**
	 * Returns all the producto explots where explotacionId = &#63;.
	 *
	 * @param explotacionId the explotacion ID
	 * @return the matching producto explots
	 */
	@Override
	public List<ProductoExplot> findByexplotacionId(long explotacionId) {
		return findByexplotacionId(
			explotacionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producto explots where explotacionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoExplotModelImpl</code>.
	 * </p>
	 *
	 * @param explotacionId the explotacion ID
	 * @param start the lower bound of the range of producto explots
	 * @param end the upper bound of the range of producto explots (not inclusive)
	 * @return the range of matching producto explots
	 */
	@Override
	public List<ProductoExplot> findByexplotacionId(
		long explotacionId, int start, int end) {

		return findByexplotacionId(explotacionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the producto explots where explotacionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoExplotModelImpl</code>.
	 * </p>
	 *
	 * @param explotacionId the explotacion ID
	 * @param start the lower bound of the range of producto explots
	 * @param end the upper bound of the range of producto explots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producto explots
	 */
	@Override
	public List<ProductoExplot> findByexplotacionId(
		long explotacionId, int start, int end,
		OrderByComparator<ProductoExplot> orderByComparator) {

		return findByexplotacionId(
			explotacionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the producto explots where explotacionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoExplotModelImpl</code>.
	 * </p>
	 *
	 * @param explotacionId the explotacion ID
	 * @param start the lower bound of the range of producto explots
	 * @param end the upper bound of the range of producto explots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producto explots
	 */
	@Override
	public List<ProductoExplot> findByexplotacionId(
		long explotacionId, int start, int end,
		OrderByComparator<ProductoExplot> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByexplotacionId;
				finderArgs = new Object[] {explotacionId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByexplotacionId;
			finderArgs = new Object[] {
				explotacionId, start, end, orderByComparator
			};
		}

		List<ProductoExplot> list = null;

		if (useFinderCache) {
			list = (List<ProductoExplot>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductoExplot productoExplot : list) {
					if (explotacionId != productoExplot.getExplotacionId()) {
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

			sb.append(_SQL_SELECT_PRODUCTOEXPLOT_WHERE);

			sb.append(_FINDER_COLUMN_EXPLOTACIONID_EXPLOTACIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProductoExplotModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(explotacionId);

				list = (List<ProductoExplot>)QueryUtil.list(
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
	 * Returns the first producto explot in the ordered set where explotacionId = &#63;.
	 *
	 * @param explotacionId the explotacion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto explot
	 * @throws NoSuchProductoExplotException if a matching producto explot could not be found
	 */
	@Override
	public ProductoExplot findByexplotacionId_First(
			long explotacionId,
			OrderByComparator<ProductoExplot> orderByComparator)
		throws NoSuchProductoExplotException {

		ProductoExplot productoExplot = fetchByexplotacionId_First(
			explotacionId, orderByComparator);

		if (productoExplot != null) {
			return productoExplot;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("explotacionId=");
		sb.append(explotacionId);

		sb.append("}");

		throw new NoSuchProductoExplotException(sb.toString());
	}

	/**
	 * Returns the first producto explot in the ordered set where explotacionId = &#63;.
	 *
	 * @param explotacionId the explotacion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producto explot, or <code>null</code> if a matching producto explot could not be found
	 */
	@Override
	public ProductoExplot fetchByexplotacionId_First(
		long explotacionId,
		OrderByComparator<ProductoExplot> orderByComparator) {

		List<ProductoExplot> list = findByexplotacionId(
			explotacionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last producto explot in the ordered set where explotacionId = &#63;.
	 *
	 * @param explotacionId the explotacion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto explot
	 * @throws NoSuchProductoExplotException if a matching producto explot could not be found
	 */
	@Override
	public ProductoExplot findByexplotacionId_Last(
			long explotacionId,
			OrderByComparator<ProductoExplot> orderByComparator)
		throws NoSuchProductoExplotException {

		ProductoExplot productoExplot = fetchByexplotacionId_Last(
			explotacionId, orderByComparator);

		if (productoExplot != null) {
			return productoExplot;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("explotacionId=");
		sb.append(explotacionId);

		sb.append("}");

		throw new NoSuchProductoExplotException(sb.toString());
	}

	/**
	 * Returns the last producto explot in the ordered set where explotacionId = &#63;.
	 *
	 * @param explotacionId the explotacion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producto explot, or <code>null</code> if a matching producto explot could not be found
	 */
	@Override
	public ProductoExplot fetchByexplotacionId_Last(
		long explotacionId,
		OrderByComparator<ProductoExplot> orderByComparator) {

		int count = countByexplotacionId(explotacionId);

		if (count == 0) {
			return null;
		}

		List<ProductoExplot> list = findByexplotacionId(
			explotacionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the producto explots before and after the current producto explot in the ordered set where explotacionId = &#63;.
	 *
	 * @param entityId the primary key of the current producto explot
	 * @param explotacionId the explotacion ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producto explot
	 * @throws NoSuchProductoExplotException if a producto explot with the primary key could not be found
	 */
	@Override
	public ProductoExplot[] findByexplotacionId_PrevAndNext(
			long entityId, long explotacionId,
			OrderByComparator<ProductoExplot> orderByComparator)
		throws NoSuchProductoExplotException {

		ProductoExplot productoExplot = findByPrimaryKey(entityId);

		Session session = null;

		try {
			session = openSession();

			ProductoExplot[] array = new ProductoExplotImpl[3];

			array[0] = getByexplotacionId_PrevAndNext(
				session, productoExplot, explotacionId, orderByComparator,
				true);

			array[1] = productoExplot;

			array[2] = getByexplotacionId_PrevAndNext(
				session, productoExplot, explotacionId, orderByComparator,
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

	protected ProductoExplot getByexplotacionId_PrevAndNext(
		Session session, ProductoExplot productoExplot, long explotacionId,
		OrderByComparator<ProductoExplot> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PRODUCTOEXPLOT_WHERE);

		sb.append(_FINDER_COLUMN_EXPLOTACIONID_EXPLOTACIONID_2);

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
			sb.append(ProductoExplotModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(explotacionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						productoExplot)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductoExplot> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the producto explots where explotacionId = &#63; from the database.
	 *
	 * @param explotacionId the explotacion ID
	 */
	@Override
	public void removeByexplotacionId(long explotacionId) {
		for (ProductoExplot productoExplot :
				findByexplotacionId(
					explotacionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(productoExplot);
		}
	}

	/**
	 * Returns the number of producto explots where explotacionId = &#63;.
	 *
	 * @param explotacionId the explotacion ID
	 * @return the number of matching producto explots
	 */
	@Override
	public int countByexplotacionId(long explotacionId) {
		FinderPath finderPath = _finderPathCountByexplotacionId;

		Object[] finderArgs = new Object[] {explotacionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTOEXPLOT_WHERE);

			sb.append(_FINDER_COLUMN_EXPLOTACIONID_EXPLOTACIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(explotacionId);

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

	private static final String _FINDER_COLUMN_EXPLOTACIONID_EXPLOTACIONID_2 =
		"productoExplot.explotacionId = ?";

	public ProductoExplotPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProductoExplot.class);

		setModelImplClass(ProductoExplotImpl.class);
		setModelPKClass(long.class);

		setTable(ProductoExplotTable.INSTANCE);
	}

	/**
	 * Caches the producto explot in the entity cache if it is enabled.
	 *
	 * @param productoExplot the producto explot
	 */
	@Override
	public void cacheResult(ProductoExplot productoExplot) {
		entityCache.putResult(
			ProductoExplotImpl.class, productoExplot.getPrimaryKey(),
			productoExplot);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the producto explots in the entity cache if it is enabled.
	 *
	 * @param productoExplots the producto explots
	 */
	@Override
	public void cacheResult(List<ProductoExplot> productoExplots) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (productoExplots.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProductoExplot productoExplot : productoExplots) {
			if (entityCache.getResult(
					ProductoExplotImpl.class, productoExplot.getPrimaryKey()) ==
						null) {

				cacheResult(productoExplot);
			}
		}
	}

	/**
	 * Clears the cache for all producto explots.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProductoExplotImpl.class);

		finderCache.clearCache(ProductoExplotImpl.class);
	}

	/**
	 * Clears the cache for the producto explot.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductoExplot productoExplot) {
		entityCache.removeResult(ProductoExplotImpl.class, productoExplot);
	}

	@Override
	public void clearCache(List<ProductoExplot> productoExplots) {
		for (ProductoExplot productoExplot : productoExplots) {
			entityCache.removeResult(ProductoExplotImpl.class, productoExplot);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProductoExplotImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProductoExplotImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new producto explot with the primary key. Does not add the producto explot to the database.
	 *
	 * @param entityId the primary key for the new producto explot
	 * @return the new producto explot
	 */
	@Override
	public ProductoExplot create(long entityId) {
		ProductoExplot productoExplot = new ProductoExplotImpl();

		productoExplot.setNew(true);
		productoExplot.setPrimaryKey(entityId);

		String uuid = PortalUUIDUtil.generate();

		productoExplot.setUuid(uuid);

		return productoExplot;
	}

	/**
	 * Removes the producto explot with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entityId the primary key of the producto explot
	 * @return the producto explot that was removed
	 * @throws NoSuchProductoExplotException if a producto explot with the primary key could not be found
	 */
	@Override
	public ProductoExplot remove(long entityId)
		throws NoSuchProductoExplotException {

		return remove((Serializable)entityId);
	}

	/**
	 * Removes the producto explot with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the producto explot
	 * @return the producto explot that was removed
	 * @throws NoSuchProductoExplotException if a producto explot with the primary key could not be found
	 */
	@Override
	public ProductoExplot remove(Serializable primaryKey)
		throws NoSuchProductoExplotException {

		Session session = null;

		try {
			session = openSession();

			ProductoExplot productoExplot = (ProductoExplot)session.get(
				ProductoExplotImpl.class, primaryKey);

			if (productoExplot == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductoExplotException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(productoExplot);
		}
		catch (NoSuchProductoExplotException noSuchEntityException) {
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
	protected ProductoExplot removeImpl(ProductoExplot productoExplot) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productoExplot)) {
				productoExplot = (ProductoExplot)session.get(
					ProductoExplotImpl.class,
					productoExplot.getPrimaryKeyObj());
			}

			if (productoExplot != null) {
				session.delete(productoExplot);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (productoExplot != null) {
			clearCache(productoExplot);
		}

		return productoExplot;
	}

	@Override
	public ProductoExplot updateImpl(ProductoExplot productoExplot) {
		boolean isNew = productoExplot.isNew();

		if (!(productoExplot instanceof ProductoExplotModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(productoExplot.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					productoExplot);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in productoExplot proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProductoExplot implementation " +
					productoExplot.getClass());
		}

		ProductoExplotModelImpl productoExplotModelImpl =
			(ProductoExplotModelImpl)productoExplot;

		if (Validator.isNull(productoExplot.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			productoExplot.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (productoExplot.getCreateDate() == null)) {
			if (serviceContext == null) {
				productoExplot.setCreateDate(date);
			}
			else {
				productoExplot.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!productoExplotModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				productoExplot.setModifiedDate(date);
			}
			else {
				productoExplot.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(productoExplot);
			}
			else {
				productoExplot = (ProductoExplot)session.merge(productoExplot);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProductoExplotImpl.class, productoExplotModelImpl, false, true);

		if (isNew) {
			productoExplot.setNew(false);
		}

		productoExplot.resetOriginalValues();

		return productoExplot;
	}

	/**
	 * Returns the producto explot with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the producto explot
	 * @return the producto explot
	 * @throws NoSuchProductoExplotException if a producto explot with the primary key could not be found
	 */
	@Override
	public ProductoExplot findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductoExplotException {

		ProductoExplot productoExplot = fetchByPrimaryKey(primaryKey);

		if (productoExplot == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductoExplotException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return productoExplot;
	}

	/**
	 * Returns the producto explot with the primary key or throws a <code>NoSuchProductoExplotException</code> if it could not be found.
	 *
	 * @param entityId the primary key of the producto explot
	 * @return the producto explot
	 * @throws NoSuchProductoExplotException if a producto explot with the primary key could not be found
	 */
	@Override
	public ProductoExplot findByPrimaryKey(long entityId)
		throws NoSuchProductoExplotException {

		return findByPrimaryKey((Serializable)entityId);
	}

	/**
	 * Returns the producto explot with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entityId the primary key of the producto explot
	 * @return the producto explot, or <code>null</code> if a producto explot with the primary key could not be found
	 */
	@Override
	public ProductoExplot fetchByPrimaryKey(long entityId) {
		return fetchByPrimaryKey((Serializable)entityId);
	}

	/**
	 * Returns all the producto explots.
	 *
	 * @return the producto explots
	 */
	@Override
	public List<ProductoExplot> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producto explots.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoExplotModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of producto explots
	 * @param end the upper bound of the range of producto explots (not inclusive)
	 * @return the range of producto explots
	 */
	@Override
	public List<ProductoExplot> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the producto explots.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoExplotModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of producto explots
	 * @param end the upper bound of the range of producto explots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of producto explots
	 */
	@Override
	public List<ProductoExplot> findAll(
		int start, int end,
		OrderByComparator<ProductoExplot> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the producto explots.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductoExplotModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of producto explots
	 * @param end the upper bound of the range of producto explots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of producto explots
	 */
	@Override
	public List<ProductoExplot> findAll(
		int start, int end, OrderByComparator<ProductoExplot> orderByComparator,
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

		List<ProductoExplot> list = null;

		if (useFinderCache) {
			list = (List<ProductoExplot>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRODUCTOEXPLOT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTOEXPLOT;

				sql = sql.concat(ProductoExplotModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProductoExplot>)QueryUtil.list(
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
	 * Removes all the producto explots from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProductoExplot productoExplot : findAll()) {
			remove(productoExplot);
		}
	}

	/**
	 * Returns the number of producto explots.
	 *
	 * @return the number of producto explots
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PRODUCTOEXPLOT);

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
		return _SQL_SELECT_PRODUCTOEXPLOT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProductoExplotModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the producto explot persistence.
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

		_finderPathWithPaginationFindByexplotacionId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByexplotacionId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"explotacionId"}, true);

		_finderPathWithoutPaginationFindByexplotacionId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByexplotacionId",
			new String[] {Long.class.getName()}, new String[] {"explotacionId"},
			true);

		_finderPathCountByexplotacionId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByexplotacionId",
			new String[] {Long.class.getName()}, new String[] {"explotacionId"},
			false);

		ProductoExplotUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ProductoExplotUtil.setPersistence(null);

		entityCache.removeCache(ProductoExplotImpl.class.getName());
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

	private static final String _SQL_SELECT_PRODUCTOEXPLOT =
		"SELECT productoExplot FROM ProductoExplot productoExplot";

	private static final String _SQL_SELECT_PRODUCTOEXPLOT_WHERE =
		"SELECT productoExplot FROM ProductoExplot productoExplot WHERE ";

	private static final String _SQL_COUNT_PRODUCTOEXPLOT =
		"SELECT COUNT(productoExplot) FROM ProductoExplot productoExplot";

	private static final String _SQL_COUNT_PRODUCTOEXPLOT_WHERE =
		"SELECT COUNT(productoExplot) FROM ProductoExplot productoExplot WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "productoExplot.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProductoExplot exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProductoExplot exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProductoExplotPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}