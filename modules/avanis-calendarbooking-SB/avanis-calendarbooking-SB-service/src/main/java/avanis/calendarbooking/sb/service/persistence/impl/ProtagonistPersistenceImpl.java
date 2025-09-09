/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service.persistence.impl;

import avanis.calendarbooking.sb.exception.NoSuchProtagonistException;
import avanis.calendarbooking.sb.model.Protagonist;
import avanis.calendarbooking.sb.model.ProtagonistTable;
import avanis.calendarbooking.sb.model.impl.ProtagonistImpl;
import avanis.calendarbooking.sb.model.impl.ProtagonistModelImpl;
import avanis.calendarbooking.sb.service.persistence.ProtagonistPersistence;
import avanis.calendarbooking.sb.service.persistence.ProtagonistUtil;
import avanis.calendarbooking.sb.service.persistence.impl.constants.AVANIS_CALENDARPersistenceConstants;

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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
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
 * The persistence implementation for the protagonist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProtagonistPersistence.class)
public class ProtagonistPersistenceImpl
	extends BasePersistenceImpl<Protagonist> implements ProtagonistPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProtagonistUtil</code> to access the protagonist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProtagonistImpl.class.getName();

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
	 * Returns all the protagonists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching protagonists
	 */
	@Override
	public List<Protagonist> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the protagonists where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @return the range of matching protagonists
	 */
	@Override
	public List<Protagonist> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the protagonists where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching protagonists
	 */
	@Override
	public List<Protagonist> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Protagonist> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the protagonists where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching protagonists
	 */
	@Override
	public List<Protagonist> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Protagonist> orderByComparator,
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

		List<Protagonist> list = null;

		if (useFinderCache) {
			list = (List<Protagonist>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Protagonist protagonist : list) {
					if (!uuid.equals(protagonist.getUuid())) {
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

			sb.append(_SQL_SELECT_PROTAGONIST_WHERE);

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
				sb.append(ProtagonistModelImpl.ORDER_BY_JPQL);
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

				list = (List<Protagonist>)QueryUtil.list(
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
	 * Returns the first protagonist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	@Override
	public Protagonist findByUuid_First(
			String uuid, OrderByComparator<Protagonist> orderByComparator)
		throws NoSuchProtagonistException {

		Protagonist protagonist = fetchByUuid_First(uuid, orderByComparator);

		if (protagonist != null) {
			return protagonist;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProtagonistException(sb.toString());
	}

	/**
	 * Returns the first protagonist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	@Override
	public Protagonist fetchByUuid_First(
		String uuid, OrderByComparator<Protagonist> orderByComparator) {

		List<Protagonist> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last protagonist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	@Override
	public Protagonist findByUuid_Last(
			String uuid, OrderByComparator<Protagonist> orderByComparator)
		throws NoSuchProtagonistException {

		Protagonist protagonist = fetchByUuid_Last(uuid, orderByComparator);

		if (protagonist != null) {
			return protagonist;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProtagonistException(sb.toString());
	}

	/**
	 * Returns the last protagonist in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	@Override
	public Protagonist fetchByUuid_Last(
		String uuid, OrderByComparator<Protagonist> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Protagonist> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the protagonists before and after the current protagonist in the ordered set where uuid = &#63;.
	 *
	 * @param protagonistId the primary key of the current protagonist
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next protagonist
	 * @throws NoSuchProtagonistException if a protagonist with the primary key could not be found
	 */
	@Override
	public Protagonist[] findByUuid_PrevAndNext(
			long protagonistId, String uuid,
			OrderByComparator<Protagonist> orderByComparator)
		throws NoSuchProtagonistException {

		uuid = Objects.toString(uuid, "");

		Protagonist protagonist = findByPrimaryKey(protagonistId);

		Session session = null;

		try {
			session = openSession();

			Protagonist[] array = new ProtagonistImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, protagonist, uuid, orderByComparator, true);

			array[1] = protagonist;

			array[2] = getByUuid_PrevAndNext(
				session, protagonist, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Protagonist getByUuid_PrevAndNext(
		Session session, Protagonist protagonist, String uuid,
		OrderByComparator<Protagonist> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROTAGONIST_WHERE);

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
			sb.append(ProtagonistModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(protagonist)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Protagonist> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the protagonists where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Protagonist protagonist :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(protagonist);
		}
	}

	/**
	 * Returns the number of protagonists where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching protagonists
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROTAGONIST_WHERE);

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
		"protagonist.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(protagonist.uuid IS NULL OR protagonist.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the protagonist where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProtagonistException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	@Override
	public Protagonist findByUUID_G(String uuid, long groupId)
		throws NoSuchProtagonistException {

		Protagonist protagonist = fetchByUUID_G(uuid, groupId);

		if (protagonist == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProtagonistException(sb.toString());
		}

		return protagonist;
	}

	/**
	 * Returns the protagonist where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	@Override
	public Protagonist fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the protagonist where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	@Override
	public Protagonist fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Protagonist) {
			Protagonist protagonist = (Protagonist)result;

			if (!Objects.equals(uuid, protagonist.getUuid()) ||
				(groupId != protagonist.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROTAGONIST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Protagonist> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Protagonist protagonist = list.get(0);

					result = protagonist;

					cacheResult(protagonist);
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
			return (Protagonist)result;
		}
	}

	/**
	 * Removes the protagonist where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the protagonist that was removed
	 */
	@Override
	public Protagonist removeByUUID_G(String uuid, long groupId)
		throws NoSuchProtagonistException {

		Protagonist protagonist = findByUUID_G(uuid, groupId);

		return remove(protagonist);
	}

	/**
	 * Returns the number of protagonists where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching protagonists
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROTAGONIST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"protagonist.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(protagonist.uuid IS NULL OR protagonist.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"protagonist.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the protagonists where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching protagonists
	 */
	@Override
	public List<Protagonist> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the protagonists where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @return the range of matching protagonists
	 */
	@Override
	public List<Protagonist> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the protagonists where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching protagonists
	 */
	@Override
	public List<Protagonist> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Protagonist> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the protagonists where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching protagonists
	 */
	@Override
	public List<Protagonist> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Protagonist> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Protagonist> list = null;

		if (useFinderCache) {
			list = (List<Protagonist>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Protagonist protagonist : list) {
					if (!uuid.equals(protagonist.getUuid()) ||
						(companyId != protagonist.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PROTAGONIST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProtagonistModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(companyId);

				list = (List<Protagonist>)QueryUtil.list(
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
	 * Returns the first protagonist in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	@Override
	public Protagonist findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Protagonist> orderByComparator)
		throws NoSuchProtagonistException {

		Protagonist protagonist = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (protagonist != null) {
			return protagonist;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProtagonistException(sb.toString());
	}

	/**
	 * Returns the first protagonist in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	@Override
	public Protagonist fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Protagonist> orderByComparator) {

		List<Protagonist> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last protagonist in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	@Override
	public Protagonist findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Protagonist> orderByComparator)
		throws NoSuchProtagonistException {

		Protagonist protagonist = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (protagonist != null) {
			return protagonist;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProtagonistException(sb.toString());
	}

	/**
	 * Returns the last protagonist in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	@Override
	public Protagonist fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Protagonist> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Protagonist> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the protagonists before and after the current protagonist in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param protagonistId the primary key of the current protagonist
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next protagonist
	 * @throws NoSuchProtagonistException if a protagonist with the primary key could not be found
	 */
	@Override
	public Protagonist[] findByUuid_C_PrevAndNext(
			long protagonistId, String uuid, long companyId,
			OrderByComparator<Protagonist> orderByComparator)
		throws NoSuchProtagonistException {

		uuid = Objects.toString(uuid, "");

		Protagonist protagonist = findByPrimaryKey(protagonistId);

		Session session = null;

		try {
			session = openSession();

			Protagonist[] array = new ProtagonistImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, protagonist, uuid, companyId, orderByComparator, true);

			array[1] = protagonist;

			array[2] = getByUuid_C_PrevAndNext(
				session, protagonist, uuid, companyId, orderByComparator,
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

	protected Protagonist getByUuid_C_PrevAndNext(
		Session session, Protagonist protagonist, String uuid, long companyId,
		OrderByComparator<Protagonist> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PROTAGONIST_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(ProtagonistModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(protagonist)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Protagonist> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the protagonists where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Protagonist protagonist :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(protagonist);
		}
	}

	/**
	 * Returns the number of protagonists where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching protagonists
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROTAGONIST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"protagonist.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(protagonist.uuid IS NULL OR protagonist.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"protagonist.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBycalendarBookingId;
	private FinderPath _finderPathWithoutPaginationFindBycalendarBookingId;
	private FinderPath _finderPathCountBycalendarBookingId;

	/**
	 * Returns all the protagonists where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @return the matching protagonists
	 */
	@Override
	public List<Protagonist> findBycalendarBookingId(long calendarBookingId) {
		return findBycalendarBookingId(
			calendarBookingId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the protagonists where calendarBookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @return the range of matching protagonists
	 */
	@Override
	public List<Protagonist> findBycalendarBookingId(
		long calendarBookingId, int start, int end) {

		return findBycalendarBookingId(calendarBookingId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the protagonists where calendarBookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching protagonists
	 */
	@Override
	public List<Protagonist> findBycalendarBookingId(
		long calendarBookingId, int start, int end,
		OrderByComparator<Protagonist> orderByComparator) {

		return findBycalendarBookingId(
			calendarBookingId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the protagonists where calendarBookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching protagonists
	 */
	@Override
	public List<Protagonist> findBycalendarBookingId(
		long calendarBookingId, int start, int end,
		OrderByComparator<Protagonist> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBycalendarBookingId;
				finderArgs = new Object[] {calendarBookingId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBycalendarBookingId;
			finderArgs = new Object[] {
				calendarBookingId, start, end, orderByComparator
			};
		}

		List<Protagonist> list = null;

		if (useFinderCache) {
			list = (List<Protagonist>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Protagonist protagonist : list) {
					if (calendarBookingId !=
							protagonist.getCalendarBookingId()) {

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

			sb.append(_SQL_SELECT_PROTAGONIST_WHERE);

			sb.append(_FINDER_COLUMN_CALENDARBOOKINGID_CALENDARBOOKINGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProtagonistModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(calendarBookingId);

				list = (List<Protagonist>)QueryUtil.list(
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
	 * Returns the first protagonist in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	@Override
	public Protagonist findBycalendarBookingId_First(
			long calendarBookingId,
			OrderByComparator<Protagonist> orderByComparator)
		throws NoSuchProtagonistException {

		Protagonist protagonist = fetchBycalendarBookingId_First(
			calendarBookingId, orderByComparator);

		if (protagonist != null) {
			return protagonist;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("calendarBookingId=");
		sb.append(calendarBookingId);

		sb.append("}");

		throw new NoSuchProtagonistException(sb.toString());
	}

	/**
	 * Returns the first protagonist in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	@Override
	public Protagonist fetchBycalendarBookingId_First(
		long calendarBookingId,
		OrderByComparator<Protagonist> orderByComparator) {

		List<Protagonist> list = findBycalendarBookingId(
			calendarBookingId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last protagonist in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	@Override
	public Protagonist findBycalendarBookingId_Last(
			long calendarBookingId,
			OrderByComparator<Protagonist> orderByComparator)
		throws NoSuchProtagonistException {

		Protagonist protagonist = fetchBycalendarBookingId_Last(
			calendarBookingId, orderByComparator);

		if (protagonist != null) {
			return protagonist;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("calendarBookingId=");
		sb.append(calendarBookingId);

		sb.append("}");

		throw new NoSuchProtagonistException(sb.toString());
	}

	/**
	 * Returns the last protagonist in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	@Override
	public Protagonist fetchBycalendarBookingId_Last(
		long calendarBookingId,
		OrderByComparator<Protagonist> orderByComparator) {

		int count = countBycalendarBookingId(calendarBookingId);

		if (count == 0) {
			return null;
		}

		List<Protagonist> list = findBycalendarBookingId(
			calendarBookingId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the protagonists before and after the current protagonist in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param protagonistId the primary key of the current protagonist
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next protagonist
	 * @throws NoSuchProtagonistException if a protagonist with the primary key could not be found
	 */
	@Override
	public Protagonist[] findBycalendarBookingId_PrevAndNext(
			long protagonistId, long calendarBookingId,
			OrderByComparator<Protagonist> orderByComparator)
		throws NoSuchProtagonistException {

		Protagonist protagonist = findByPrimaryKey(protagonistId);

		Session session = null;

		try {
			session = openSession();

			Protagonist[] array = new ProtagonistImpl[3];

			array[0] = getBycalendarBookingId_PrevAndNext(
				session, protagonist, calendarBookingId, orderByComparator,
				true);

			array[1] = protagonist;

			array[2] = getBycalendarBookingId_PrevAndNext(
				session, protagonist, calendarBookingId, orderByComparator,
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

	protected Protagonist getBycalendarBookingId_PrevAndNext(
		Session session, Protagonist protagonist, long calendarBookingId,
		OrderByComparator<Protagonist> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROTAGONIST_WHERE);

		sb.append(_FINDER_COLUMN_CALENDARBOOKINGID_CALENDARBOOKINGID_2);

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
			sb.append(ProtagonistModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(calendarBookingId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(protagonist)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Protagonist> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the protagonists where calendarBookingId = &#63; from the database.
	 *
	 * @param calendarBookingId the calendar booking ID
	 */
	@Override
	public void removeBycalendarBookingId(long calendarBookingId) {
		for (Protagonist protagonist :
				findBycalendarBookingId(
					calendarBookingId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(protagonist);
		}
	}

	/**
	 * Returns the number of protagonists where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @return the number of matching protagonists
	 */
	@Override
	public int countBycalendarBookingId(long calendarBookingId) {
		FinderPath finderPath = _finderPathCountBycalendarBookingId;

		Object[] finderArgs = new Object[] {calendarBookingId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROTAGONIST_WHERE);

			sb.append(_FINDER_COLUMN_CALENDARBOOKINGID_CALENDARBOOKINGID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(calendarBookingId);

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
		_FINDER_COLUMN_CALENDARBOOKINGID_CALENDARBOOKINGID_2 =
			"protagonist.calendarBookingId = ?";

	private FinderPath _finderPathWithPaginationFindByuserId;
	private FinderPath _finderPathWithoutPaginationFindByuserId;
	private FinderPath _finderPathCountByuserId;

	/**
	 * Returns all the protagonists where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching protagonists
	 */
	@Override
	public List<Protagonist> findByuserId(long userId) {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the protagonists where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @return the range of matching protagonists
	 */
	@Override
	public List<Protagonist> findByuserId(long userId, int start, int end) {
		return findByuserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the protagonists where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching protagonists
	 */
	@Override
	public List<Protagonist> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Protagonist> orderByComparator) {

		return findByuserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the protagonists where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching protagonists
	 */
	@Override
	public List<Protagonist> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Protagonist> orderByComparator,
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

		List<Protagonist> list = null;

		if (useFinderCache) {
			list = (List<Protagonist>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Protagonist protagonist : list) {
					if (userId != protagonist.getUserId()) {
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

			sb.append(_SQL_SELECT_PROTAGONIST_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProtagonistModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<Protagonist>)QueryUtil.list(
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
	 * Returns the first protagonist in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	@Override
	public Protagonist findByuserId_First(
			long userId, OrderByComparator<Protagonist> orderByComparator)
		throws NoSuchProtagonistException {

		Protagonist protagonist = fetchByuserId_First(
			userId, orderByComparator);

		if (protagonist != null) {
			return protagonist;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchProtagonistException(sb.toString());
	}

	/**
	 * Returns the first protagonist in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	@Override
	public Protagonist fetchByuserId_First(
		long userId, OrderByComparator<Protagonist> orderByComparator) {

		List<Protagonist> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last protagonist in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist
	 * @throws NoSuchProtagonistException if a matching protagonist could not be found
	 */
	@Override
	public Protagonist findByuserId_Last(
			long userId, OrderByComparator<Protagonist> orderByComparator)
		throws NoSuchProtagonistException {

		Protagonist protagonist = fetchByuserId_Last(userId, orderByComparator);

		if (protagonist != null) {
			return protagonist;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchProtagonistException(sb.toString());
	}

	/**
	 * Returns the last protagonist in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching protagonist, or <code>null</code> if a matching protagonist could not be found
	 */
	@Override
	public Protagonist fetchByuserId_Last(
		long userId, OrderByComparator<Protagonist> orderByComparator) {

		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<Protagonist> list = findByuserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the protagonists before and after the current protagonist in the ordered set where userId = &#63;.
	 *
	 * @param protagonistId the primary key of the current protagonist
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next protagonist
	 * @throws NoSuchProtagonistException if a protagonist with the primary key could not be found
	 */
	@Override
	public Protagonist[] findByuserId_PrevAndNext(
			long protagonistId, long userId,
			OrderByComparator<Protagonist> orderByComparator)
		throws NoSuchProtagonistException {

		Protagonist protagonist = findByPrimaryKey(protagonistId);

		Session session = null;

		try {
			session = openSession();

			Protagonist[] array = new ProtagonistImpl[3];

			array[0] = getByuserId_PrevAndNext(
				session, protagonist, userId, orderByComparator, true);

			array[1] = protagonist;

			array[2] = getByuserId_PrevAndNext(
				session, protagonist, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Protagonist getByuserId_PrevAndNext(
		Session session, Protagonist protagonist, long userId,
		OrderByComparator<Protagonist> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROTAGONIST_WHERE);

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
			sb.append(ProtagonistModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(protagonist)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Protagonist> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the protagonists where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByuserId(long userId) {
		for (Protagonist protagonist :
				findByuserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(protagonist);
		}
	}

	/**
	 * Returns the number of protagonists where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching protagonists
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = _finderPathCountByuserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROTAGONIST_WHERE);

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
		"protagonist.userId = ?";

	public ProtagonistPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Protagonist.class);

		setModelImplClass(ProtagonistImpl.class);
		setModelPKClass(long.class);

		setTable(ProtagonistTable.INSTANCE);
	}

	/**
	 * Caches the protagonist in the entity cache if it is enabled.
	 *
	 * @param protagonist the protagonist
	 */
	@Override
	public void cacheResult(Protagonist protagonist) {
		entityCache.putResult(
			ProtagonistImpl.class, protagonist.getPrimaryKey(), protagonist);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {protagonist.getUuid(), protagonist.getGroupId()},
			protagonist);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the protagonists in the entity cache if it is enabled.
	 *
	 * @param protagonists the protagonists
	 */
	@Override
	public void cacheResult(List<Protagonist> protagonists) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (protagonists.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Protagonist protagonist : protagonists) {
			if (entityCache.getResult(
					ProtagonistImpl.class, protagonist.getPrimaryKey()) ==
						null) {

				cacheResult(protagonist);
			}
		}
	}

	/**
	 * Clears the cache for all protagonists.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProtagonistImpl.class);

		finderCache.clearCache(ProtagonistImpl.class);
	}

	/**
	 * Clears the cache for the protagonist.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Protagonist protagonist) {
		entityCache.removeResult(ProtagonistImpl.class, protagonist);
	}

	@Override
	public void clearCache(List<Protagonist> protagonists) {
		for (Protagonist protagonist : protagonists) {
			entityCache.removeResult(ProtagonistImpl.class, protagonist);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProtagonistImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProtagonistImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProtagonistModelImpl protagonistModelImpl) {

		Object[] args = new Object[] {
			protagonistModelImpl.getUuid(), protagonistModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, protagonistModelImpl);
	}

	/**
	 * Creates a new protagonist with the primary key. Does not add the protagonist to the database.
	 *
	 * @param protagonistId the primary key for the new protagonist
	 * @return the new protagonist
	 */
	@Override
	public Protagonist create(long protagonistId) {
		Protagonist protagonist = new ProtagonistImpl();

		protagonist.setNew(true);
		protagonist.setPrimaryKey(protagonistId);

		String uuid = PortalUUIDUtil.generate();

		protagonist.setUuid(uuid);

		protagonist.setCompanyId(CompanyThreadLocal.getCompanyId());

		return protagonist;
	}

	/**
	 * Removes the protagonist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param protagonistId the primary key of the protagonist
	 * @return the protagonist that was removed
	 * @throws NoSuchProtagonistException if a protagonist with the primary key could not be found
	 */
	@Override
	public Protagonist remove(long protagonistId)
		throws NoSuchProtagonistException {

		return remove((Serializable)protagonistId);
	}

	/**
	 * Removes the protagonist with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the protagonist
	 * @return the protagonist that was removed
	 * @throws NoSuchProtagonistException if a protagonist with the primary key could not be found
	 */
	@Override
	public Protagonist remove(Serializable primaryKey)
		throws NoSuchProtagonistException {

		Session session = null;

		try {
			session = openSession();

			Protagonist protagonist = (Protagonist)session.get(
				ProtagonistImpl.class, primaryKey);

			if (protagonist == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProtagonistException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(protagonist);
		}
		catch (NoSuchProtagonistException noSuchEntityException) {
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
	protected Protagonist removeImpl(Protagonist protagonist) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(protagonist)) {
				protagonist = (Protagonist)session.get(
					ProtagonistImpl.class, protagonist.getPrimaryKeyObj());
			}

			if (protagonist != null) {
				session.delete(protagonist);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (protagonist != null) {
			clearCache(protagonist);
		}

		return protagonist;
	}

	@Override
	public Protagonist updateImpl(Protagonist protagonist) {
		boolean isNew = protagonist.isNew();

		if (!(protagonist instanceof ProtagonistModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(protagonist.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(protagonist);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in protagonist proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Protagonist implementation " +
					protagonist.getClass());
		}

		ProtagonistModelImpl protagonistModelImpl =
			(ProtagonistModelImpl)protagonist;

		if (Validator.isNull(protagonist.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			protagonist.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (protagonist.getCreateDate() == null)) {
			if (serviceContext == null) {
				protagonist.setCreateDate(date);
			}
			else {
				protagonist.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!protagonistModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				protagonist.setModifiedDate(date);
			}
			else {
				protagonist.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(protagonist);
			}
			else {
				protagonist = (Protagonist)session.merge(protagonist);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProtagonistImpl.class, protagonistModelImpl, false, true);

		cacheUniqueFindersCache(protagonistModelImpl);

		if (isNew) {
			protagonist.setNew(false);
		}

		protagonist.resetOriginalValues();

		return protagonist;
	}

	/**
	 * Returns the protagonist with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the protagonist
	 * @return the protagonist
	 * @throws NoSuchProtagonistException if a protagonist with the primary key could not be found
	 */
	@Override
	public Protagonist findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProtagonistException {

		Protagonist protagonist = fetchByPrimaryKey(primaryKey);

		if (protagonist == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProtagonistException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return protagonist;
	}

	/**
	 * Returns the protagonist with the primary key or throws a <code>NoSuchProtagonistException</code> if it could not be found.
	 *
	 * @param protagonistId the primary key of the protagonist
	 * @return the protagonist
	 * @throws NoSuchProtagonistException if a protagonist with the primary key could not be found
	 */
	@Override
	public Protagonist findByPrimaryKey(long protagonistId)
		throws NoSuchProtagonistException {

		return findByPrimaryKey((Serializable)protagonistId);
	}

	/**
	 * Returns the protagonist with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param protagonistId the primary key of the protagonist
	 * @return the protagonist, or <code>null</code> if a protagonist with the primary key could not be found
	 */
	@Override
	public Protagonist fetchByPrimaryKey(long protagonistId) {
		return fetchByPrimaryKey((Serializable)protagonistId);
	}

	/**
	 * Returns all the protagonists.
	 *
	 * @return the protagonists
	 */
	@Override
	public List<Protagonist> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the protagonists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @return the range of protagonists
	 */
	@Override
	public List<Protagonist> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the protagonists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of protagonists
	 */
	@Override
	public List<Protagonist> findAll(
		int start, int end, OrderByComparator<Protagonist> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the protagonists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProtagonistModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of protagonists
	 * @param end the upper bound of the range of protagonists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of protagonists
	 */
	@Override
	public List<Protagonist> findAll(
		int start, int end, OrderByComparator<Protagonist> orderByComparator,
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

		List<Protagonist> list = null;

		if (useFinderCache) {
			list = (List<Protagonist>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROTAGONIST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROTAGONIST;

				sql = sql.concat(ProtagonistModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Protagonist>)QueryUtil.list(
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
	 * Removes all the protagonists from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Protagonist protagonist : findAll()) {
			remove(protagonist);
		}
	}

	/**
	 * Returns the number of protagonists.
	 *
	 * @return the number of protagonists
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PROTAGONIST);

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
		return "protagonistId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROTAGONIST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProtagonistModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the protagonist persistence.
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

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindBycalendarBookingId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycalendarBookingId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"calendarBookingId"}, true);

		_finderPathWithoutPaginationFindBycalendarBookingId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBycalendarBookingId", new String[] {Long.class.getName()},
			new String[] {"calendarBookingId"}, true);

		_finderPathCountBycalendarBookingId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBycalendarBookingId", new String[] {Long.class.getName()},
			new String[] {"calendarBookingId"}, false);

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

		ProtagonistUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ProtagonistUtil.setPersistence(null);

		entityCache.removeCache(ProtagonistImpl.class.getName());
	}

	@Override
	@Reference(
		target = AVANIS_CALENDARPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = AVANIS_CALENDARPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AVANIS_CALENDARPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PROTAGONIST =
		"SELECT protagonist FROM Protagonist protagonist";

	private static final String _SQL_SELECT_PROTAGONIST_WHERE =
		"SELECT protagonist FROM Protagonist protagonist WHERE ";

	private static final String _SQL_COUNT_PROTAGONIST =
		"SELECT COUNT(protagonist) FROM Protagonist protagonist";

	private static final String _SQL_COUNT_PROTAGONIST_WHERE =
		"SELECT COUNT(protagonist) FROM Protagonist protagonist WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "protagonist.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Protagonist exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Protagonist exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProtagonistPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}