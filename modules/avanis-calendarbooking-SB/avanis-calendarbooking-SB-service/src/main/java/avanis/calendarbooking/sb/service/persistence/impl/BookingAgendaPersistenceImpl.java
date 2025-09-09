/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service.persistence.impl;

import avanis.calendarbooking.sb.exception.NoSuchBookingAgendaException;
import avanis.calendarbooking.sb.model.BookingAgenda;
import avanis.calendarbooking.sb.model.BookingAgendaTable;
import avanis.calendarbooking.sb.model.impl.BookingAgendaImpl;
import avanis.calendarbooking.sb.model.impl.BookingAgendaModelImpl;
import avanis.calendarbooking.sb.service.persistence.BookingAgendaPersistence;
import avanis.calendarbooking.sb.service.persistence.BookingAgendaUtil;
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
 * The persistence implementation for the booking agenda service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BookingAgendaPersistence.class)
public class BookingAgendaPersistenceImpl
	extends BasePersistenceImpl<BookingAgenda>
	implements BookingAgendaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BookingAgendaUtil</code> to access the booking agenda persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BookingAgendaImpl.class.getName();

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
	 * Returns all the booking agendas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching booking agendas
	 */
	@Override
	public List<BookingAgenda> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking agendas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @return the range of matching booking agendas
	 */
	@Override
	public List<BookingAgenda> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking agendas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking agendas
	 */
	@Override
	public List<BookingAgenda> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BookingAgenda> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the booking agendas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching booking agendas
	 */
	@Override
	public List<BookingAgenda> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BookingAgenda> orderByComparator,
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

		List<BookingAgenda> list = null;

		if (useFinderCache) {
			list = (List<BookingAgenda>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BookingAgenda bookingAgenda : list) {
					if (!uuid.equals(bookingAgenda.getUuid())) {
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

			sb.append(_SQL_SELECT_BOOKINGAGENDA_WHERE);

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
				sb.append(BookingAgendaModelImpl.ORDER_BY_JPQL);
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

				list = (List<BookingAgenda>)QueryUtil.list(
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
	 * Returns the first booking agenda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	@Override
	public BookingAgenda findByUuid_First(
			String uuid, OrderByComparator<BookingAgenda> orderByComparator)
		throws NoSuchBookingAgendaException {

		BookingAgenda bookingAgenda = fetchByUuid_First(
			uuid, orderByComparator);

		if (bookingAgenda != null) {
			return bookingAgenda;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBookingAgendaException(sb.toString());
	}

	/**
	 * Returns the first booking agenda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	@Override
	public BookingAgenda fetchByUuid_First(
		String uuid, OrderByComparator<BookingAgenda> orderByComparator) {

		List<BookingAgenda> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last booking agenda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	@Override
	public BookingAgenda findByUuid_Last(
			String uuid, OrderByComparator<BookingAgenda> orderByComparator)
		throws NoSuchBookingAgendaException {

		BookingAgenda bookingAgenda = fetchByUuid_Last(uuid, orderByComparator);

		if (bookingAgenda != null) {
			return bookingAgenda;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBookingAgendaException(sb.toString());
	}

	/**
	 * Returns the last booking agenda in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	@Override
	public BookingAgenda fetchByUuid_Last(
		String uuid, OrderByComparator<BookingAgenda> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<BookingAgenda> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the booking agendas before and after the current booking agenda in the ordered set where uuid = &#63;.
	 *
	 * @param calendarBookingAgendaId the primary key of the current booking agenda
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking agenda
	 * @throws NoSuchBookingAgendaException if a booking agenda with the primary key could not be found
	 */
	@Override
	public BookingAgenda[] findByUuid_PrevAndNext(
			long calendarBookingAgendaId, String uuid,
			OrderByComparator<BookingAgenda> orderByComparator)
		throws NoSuchBookingAgendaException {

		uuid = Objects.toString(uuid, "");

		BookingAgenda bookingAgenda = findByPrimaryKey(calendarBookingAgendaId);

		Session session = null;

		try {
			session = openSession();

			BookingAgenda[] array = new BookingAgendaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, bookingAgenda, uuid, orderByComparator, true);

			array[1] = bookingAgenda;

			array[2] = getByUuid_PrevAndNext(
				session, bookingAgenda, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BookingAgenda getByUuid_PrevAndNext(
		Session session, BookingAgenda bookingAgenda, String uuid,
		OrderByComparator<BookingAgenda> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BOOKINGAGENDA_WHERE);

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
			sb.append(BookingAgendaModelImpl.ORDER_BY_JPQL);
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
						bookingAgenda)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BookingAgenda> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the booking agendas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (BookingAgenda bookingAgenda :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bookingAgenda);
		}
	}

	/**
	 * Returns the number of booking agendas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching booking agendas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOOKINGAGENDA_WHERE);

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
		"bookingAgenda.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(bookingAgenda.uuid IS NULL OR bookingAgenda.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the booking agenda where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBookingAgendaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	@Override
	public BookingAgenda findByUUID_G(String uuid, long groupId)
		throws NoSuchBookingAgendaException {

		BookingAgenda bookingAgenda = fetchByUUID_G(uuid, groupId);

		if (bookingAgenda == null) {
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

			throw new NoSuchBookingAgendaException(sb.toString());
		}

		return bookingAgenda;
	}

	/**
	 * Returns the booking agenda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	@Override
	public BookingAgenda fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the booking agenda where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	@Override
	public BookingAgenda fetchByUUID_G(
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

		if (result instanceof BookingAgenda) {
			BookingAgenda bookingAgenda = (BookingAgenda)result;

			if (!Objects.equals(uuid, bookingAgenda.getUuid()) ||
				(groupId != bookingAgenda.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_BOOKINGAGENDA_WHERE);

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

				List<BookingAgenda> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					BookingAgenda bookingAgenda = list.get(0);

					result = bookingAgenda;

					cacheResult(bookingAgenda);
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
			return (BookingAgenda)result;
		}
	}

	/**
	 * Removes the booking agenda where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the booking agenda that was removed
	 */
	@Override
	public BookingAgenda removeByUUID_G(String uuid, long groupId)
		throws NoSuchBookingAgendaException {

		BookingAgenda bookingAgenda = findByUUID_G(uuid, groupId);

		return remove(bookingAgenda);
	}

	/**
	 * Returns the number of booking agendas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching booking agendas
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BOOKINGAGENDA_WHERE);

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
		"bookingAgenda.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(bookingAgenda.uuid IS NULL OR bookingAgenda.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"bookingAgenda.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the booking agendas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching booking agendas
	 */
	@Override
	public List<BookingAgenda> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking agendas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @return the range of matching booking agendas
	 */
	@Override
	public List<BookingAgenda> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking agendas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking agendas
	 */
	@Override
	public List<BookingAgenda> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BookingAgenda> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the booking agendas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching booking agendas
	 */
	@Override
	public List<BookingAgenda> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BookingAgenda> orderByComparator,
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

		List<BookingAgenda> list = null;

		if (useFinderCache) {
			list = (List<BookingAgenda>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BookingAgenda bookingAgenda : list) {
					if (!uuid.equals(bookingAgenda.getUuid()) ||
						(companyId != bookingAgenda.getCompanyId())) {

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

			sb.append(_SQL_SELECT_BOOKINGAGENDA_WHERE);

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
				sb.append(BookingAgendaModelImpl.ORDER_BY_JPQL);
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

				list = (List<BookingAgenda>)QueryUtil.list(
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
	 * Returns the first booking agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	@Override
	public BookingAgenda findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<BookingAgenda> orderByComparator)
		throws NoSuchBookingAgendaException {

		BookingAgenda bookingAgenda = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (bookingAgenda != null) {
			return bookingAgenda;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBookingAgendaException(sb.toString());
	}

	/**
	 * Returns the first booking agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	@Override
	public BookingAgenda fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<BookingAgenda> orderByComparator) {

		List<BookingAgenda> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last booking agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	@Override
	public BookingAgenda findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<BookingAgenda> orderByComparator)
		throws NoSuchBookingAgendaException {

		BookingAgenda bookingAgenda = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (bookingAgenda != null) {
			return bookingAgenda;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBookingAgendaException(sb.toString());
	}

	/**
	 * Returns the last booking agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	@Override
	public BookingAgenda fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<BookingAgenda> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<BookingAgenda> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the booking agendas before and after the current booking agenda in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param calendarBookingAgendaId the primary key of the current booking agenda
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking agenda
	 * @throws NoSuchBookingAgendaException if a booking agenda with the primary key could not be found
	 */
	@Override
	public BookingAgenda[] findByUuid_C_PrevAndNext(
			long calendarBookingAgendaId, String uuid, long companyId,
			OrderByComparator<BookingAgenda> orderByComparator)
		throws NoSuchBookingAgendaException {

		uuid = Objects.toString(uuid, "");

		BookingAgenda bookingAgenda = findByPrimaryKey(calendarBookingAgendaId);

		Session session = null;

		try {
			session = openSession();

			BookingAgenda[] array = new BookingAgendaImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, bookingAgenda, uuid, companyId, orderByComparator,
				true);

			array[1] = bookingAgenda;

			array[2] = getByUuid_C_PrevAndNext(
				session, bookingAgenda, uuid, companyId, orderByComparator,
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

	protected BookingAgenda getByUuid_C_PrevAndNext(
		Session session, BookingAgenda bookingAgenda, String uuid,
		long companyId, OrderByComparator<BookingAgenda> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_BOOKINGAGENDA_WHERE);

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
			sb.append(BookingAgendaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						bookingAgenda)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BookingAgenda> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the booking agendas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (BookingAgenda bookingAgenda :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(bookingAgenda);
		}
	}

	/**
	 * Returns the number of booking agendas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching booking agendas
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BOOKINGAGENDA_WHERE);

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
		"bookingAgenda.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(bookingAgenda.uuid IS NULL OR bookingAgenda.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"bookingAgenda.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBycalendarBookingId;
	private FinderPath _finderPathWithoutPaginationFindBycalendarBookingId;
	private FinderPath _finderPathCountBycalendarBookingId;

	/**
	 * Returns all the booking agendas where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @return the matching booking agendas
	 */
	@Override
	public List<BookingAgenda> findBycalendarBookingId(long calendarBookingId) {
		return findBycalendarBookingId(
			calendarBookingId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking agendas where calendarBookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @return the range of matching booking agendas
	 */
	@Override
	public List<BookingAgenda> findBycalendarBookingId(
		long calendarBookingId, int start, int end) {

		return findBycalendarBookingId(calendarBookingId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking agendas where calendarBookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking agendas
	 */
	@Override
	public List<BookingAgenda> findBycalendarBookingId(
		long calendarBookingId, int start, int end,
		OrderByComparator<BookingAgenda> orderByComparator) {

		return findBycalendarBookingId(
			calendarBookingId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the booking agendas where calendarBookingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching booking agendas
	 */
	@Override
	public List<BookingAgenda> findBycalendarBookingId(
		long calendarBookingId, int start, int end,
		OrderByComparator<BookingAgenda> orderByComparator,
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

		List<BookingAgenda> list = null;

		if (useFinderCache) {
			list = (List<BookingAgenda>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BookingAgenda bookingAgenda : list) {
					if (calendarBookingId !=
							bookingAgenda.getCalendarBookingId()) {

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

			sb.append(_SQL_SELECT_BOOKINGAGENDA_WHERE);

			sb.append(_FINDER_COLUMN_CALENDARBOOKINGID_CALENDARBOOKINGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BookingAgendaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(calendarBookingId);

				list = (List<BookingAgenda>)QueryUtil.list(
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
	 * Returns the first booking agenda in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	@Override
	public BookingAgenda findBycalendarBookingId_First(
			long calendarBookingId,
			OrderByComparator<BookingAgenda> orderByComparator)
		throws NoSuchBookingAgendaException {

		BookingAgenda bookingAgenda = fetchBycalendarBookingId_First(
			calendarBookingId, orderByComparator);

		if (bookingAgenda != null) {
			return bookingAgenda;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("calendarBookingId=");
		sb.append(calendarBookingId);

		sb.append("}");

		throw new NoSuchBookingAgendaException(sb.toString());
	}

	/**
	 * Returns the first booking agenda in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	@Override
	public BookingAgenda fetchBycalendarBookingId_First(
		long calendarBookingId,
		OrderByComparator<BookingAgenda> orderByComparator) {

		List<BookingAgenda> list = findBycalendarBookingId(
			calendarBookingId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last booking agenda in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	@Override
	public BookingAgenda findBycalendarBookingId_Last(
			long calendarBookingId,
			OrderByComparator<BookingAgenda> orderByComparator)
		throws NoSuchBookingAgendaException {

		BookingAgenda bookingAgenda = fetchBycalendarBookingId_Last(
			calendarBookingId, orderByComparator);

		if (bookingAgenda != null) {
			return bookingAgenda;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("calendarBookingId=");
		sb.append(calendarBookingId);

		sb.append("}");

		throw new NoSuchBookingAgendaException(sb.toString());
	}

	/**
	 * Returns the last booking agenda in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	@Override
	public BookingAgenda fetchBycalendarBookingId_Last(
		long calendarBookingId,
		OrderByComparator<BookingAgenda> orderByComparator) {

		int count = countBycalendarBookingId(calendarBookingId);

		if (count == 0) {
			return null;
		}

		List<BookingAgenda> list = findBycalendarBookingId(
			calendarBookingId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the booking agendas before and after the current booking agenda in the ordered set where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingAgendaId the primary key of the current booking agenda
	 * @param calendarBookingId the calendar booking ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking agenda
	 * @throws NoSuchBookingAgendaException if a booking agenda with the primary key could not be found
	 */
	@Override
	public BookingAgenda[] findBycalendarBookingId_PrevAndNext(
			long calendarBookingAgendaId, long calendarBookingId,
			OrderByComparator<BookingAgenda> orderByComparator)
		throws NoSuchBookingAgendaException {

		BookingAgenda bookingAgenda = findByPrimaryKey(calendarBookingAgendaId);

		Session session = null;

		try {
			session = openSession();

			BookingAgenda[] array = new BookingAgendaImpl[3];

			array[0] = getBycalendarBookingId_PrevAndNext(
				session, bookingAgenda, calendarBookingId, orderByComparator,
				true);

			array[1] = bookingAgenda;

			array[2] = getBycalendarBookingId_PrevAndNext(
				session, bookingAgenda, calendarBookingId, orderByComparator,
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

	protected BookingAgenda getBycalendarBookingId_PrevAndNext(
		Session session, BookingAgenda bookingAgenda, long calendarBookingId,
		OrderByComparator<BookingAgenda> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BOOKINGAGENDA_WHERE);

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
			sb.append(BookingAgendaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(calendarBookingId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						bookingAgenda)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BookingAgenda> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the booking agendas where calendarBookingId = &#63; from the database.
	 *
	 * @param calendarBookingId the calendar booking ID
	 */
	@Override
	public void removeBycalendarBookingId(long calendarBookingId) {
		for (BookingAgenda bookingAgenda :
				findBycalendarBookingId(
					calendarBookingId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(bookingAgenda);
		}
	}

	/**
	 * Returns the number of booking agendas where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @return the number of matching booking agendas
	 */
	@Override
	public int countBycalendarBookingId(long calendarBookingId) {
		FinderPath finderPath = _finderPathCountBycalendarBookingId;

		Object[] finderArgs = new Object[] {calendarBookingId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOOKINGAGENDA_WHERE);

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
			"bookingAgenda.calendarBookingId = ?";

	private FinderPath _finderPathWithPaginationFindByuserId;
	private FinderPath _finderPathWithoutPaginationFindByuserId;
	private FinderPath _finderPathCountByuserId;

	/**
	 * Returns all the booking agendas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching booking agendas
	 */
	@Override
	public List<BookingAgenda> findByuserId(long userId) {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking agendas where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @return the range of matching booking agendas
	 */
	@Override
	public List<BookingAgenda> findByuserId(long userId, int start, int end) {
		return findByuserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking agendas where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching booking agendas
	 */
	@Override
	public List<BookingAgenda> findByuserId(
		long userId, int start, int end,
		OrderByComparator<BookingAgenda> orderByComparator) {

		return findByuserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the booking agendas where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching booking agendas
	 */
	@Override
	public List<BookingAgenda> findByuserId(
		long userId, int start, int end,
		OrderByComparator<BookingAgenda> orderByComparator,
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

		List<BookingAgenda> list = null;

		if (useFinderCache) {
			list = (List<BookingAgenda>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BookingAgenda bookingAgenda : list) {
					if (userId != bookingAgenda.getUserId()) {
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

			sb.append(_SQL_SELECT_BOOKINGAGENDA_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BookingAgendaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<BookingAgenda>)QueryUtil.list(
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
	 * Returns the first booking agenda in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	@Override
	public BookingAgenda findByuserId_First(
			long userId, OrderByComparator<BookingAgenda> orderByComparator)
		throws NoSuchBookingAgendaException {

		BookingAgenda bookingAgenda = fetchByuserId_First(
			userId, orderByComparator);

		if (bookingAgenda != null) {
			return bookingAgenda;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchBookingAgendaException(sb.toString());
	}

	/**
	 * Returns the first booking agenda in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	@Override
	public BookingAgenda fetchByuserId_First(
		long userId, OrderByComparator<BookingAgenda> orderByComparator) {

		List<BookingAgenda> list = findByuserId(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last booking agenda in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda
	 * @throws NoSuchBookingAgendaException if a matching booking agenda could not be found
	 */
	@Override
	public BookingAgenda findByuserId_Last(
			long userId, OrderByComparator<BookingAgenda> orderByComparator)
		throws NoSuchBookingAgendaException {

		BookingAgenda bookingAgenda = fetchByuserId_Last(
			userId, orderByComparator);

		if (bookingAgenda != null) {
			return bookingAgenda;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchBookingAgendaException(sb.toString());
	}

	/**
	 * Returns the last booking agenda in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching booking agenda, or <code>null</code> if a matching booking agenda could not be found
	 */
	@Override
	public BookingAgenda fetchByuserId_Last(
		long userId, OrderByComparator<BookingAgenda> orderByComparator) {

		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<BookingAgenda> list = findByuserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the booking agendas before and after the current booking agenda in the ordered set where userId = &#63;.
	 *
	 * @param calendarBookingAgendaId the primary key of the current booking agenda
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next booking agenda
	 * @throws NoSuchBookingAgendaException if a booking agenda with the primary key could not be found
	 */
	@Override
	public BookingAgenda[] findByuserId_PrevAndNext(
			long calendarBookingAgendaId, long userId,
			OrderByComparator<BookingAgenda> orderByComparator)
		throws NoSuchBookingAgendaException {

		BookingAgenda bookingAgenda = findByPrimaryKey(calendarBookingAgendaId);

		Session session = null;

		try {
			session = openSession();

			BookingAgenda[] array = new BookingAgendaImpl[3];

			array[0] = getByuserId_PrevAndNext(
				session, bookingAgenda, userId, orderByComparator, true);

			array[1] = bookingAgenda;

			array[2] = getByuserId_PrevAndNext(
				session, bookingAgenda, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BookingAgenda getByuserId_PrevAndNext(
		Session session, BookingAgenda bookingAgenda, long userId,
		OrderByComparator<BookingAgenda> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BOOKINGAGENDA_WHERE);

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
			sb.append(BookingAgendaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						bookingAgenda)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BookingAgenda> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the booking agendas where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByuserId(long userId) {
		for (BookingAgenda bookingAgenda :
				findByuserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bookingAgenda);
		}
	}

	/**
	 * Returns the number of booking agendas where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching booking agendas
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = _finderPathCountByuserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOOKINGAGENDA_WHERE);

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
		"bookingAgenda.userId = ?";

	public BookingAgendaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(BookingAgenda.class);

		setModelImplClass(BookingAgendaImpl.class);
		setModelPKClass(long.class);

		setTable(BookingAgendaTable.INSTANCE);
	}

	/**
	 * Caches the booking agenda in the entity cache if it is enabled.
	 *
	 * @param bookingAgenda the booking agenda
	 */
	@Override
	public void cacheResult(BookingAgenda bookingAgenda) {
		entityCache.putResult(
			BookingAgendaImpl.class, bookingAgenda.getPrimaryKey(),
			bookingAgenda);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {bookingAgenda.getUuid(), bookingAgenda.getGroupId()},
			bookingAgenda);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the booking agendas in the entity cache if it is enabled.
	 *
	 * @param bookingAgendas the booking agendas
	 */
	@Override
	public void cacheResult(List<BookingAgenda> bookingAgendas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (bookingAgendas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BookingAgenda bookingAgenda : bookingAgendas) {
			if (entityCache.getResult(
					BookingAgendaImpl.class, bookingAgenda.getPrimaryKey()) ==
						null) {

				cacheResult(bookingAgenda);
			}
		}
	}

	/**
	 * Clears the cache for all booking agendas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BookingAgendaImpl.class);

		finderCache.clearCache(BookingAgendaImpl.class);
	}

	/**
	 * Clears the cache for the booking agenda.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BookingAgenda bookingAgenda) {
		entityCache.removeResult(BookingAgendaImpl.class, bookingAgenda);
	}

	@Override
	public void clearCache(List<BookingAgenda> bookingAgendas) {
		for (BookingAgenda bookingAgenda : bookingAgendas) {
			entityCache.removeResult(BookingAgendaImpl.class, bookingAgenda);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BookingAgendaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BookingAgendaImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		BookingAgendaModelImpl bookingAgendaModelImpl) {

		Object[] args = new Object[] {
			bookingAgendaModelImpl.getUuid(),
			bookingAgendaModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, bookingAgendaModelImpl);
	}

	/**
	 * Creates a new booking agenda with the primary key. Does not add the booking agenda to the database.
	 *
	 * @param calendarBookingAgendaId the primary key for the new booking agenda
	 * @return the new booking agenda
	 */
	@Override
	public BookingAgenda create(long calendarBookingAgendaId) {
		BookingAgenda bookingAgenda = new BookingAgendaImpl();

		bookingAgenda.setNew(true);
		bookingAgenda.setPrimaryKey(calendarBookingAgendaId);

		String uuid = PortalUUIDUtil.generate();

		bookingAgenda.setUuid(uuid);

		bookingAgenda.setCompanyId(CompanyThreadLocal.getCompanyId());

		return bookingAgenda;
	}

	/**
	 * Removes the booking agenda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param calendarBookingAgendaId the primary key of the booking agenda
	 * @return the booking agenda that was removed
	 * @throws NoSuchBookingAgendaException if a booking agenda with the primary key could not be found
	 */
	@Override
	public BookingAgenda remove(long calendarBookingAgendaId)
		throws NoSuchBookingAgendaException {

		return remove((Serializable)calendarBookingAgendaId);
	}

	/**
	 * Removes the booking agenda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the booking agenda
	 * @return the booking agenda that was removed
	 * @throws NoSuchBookingAgendaException if a booking agenda with the primary key could not be found
	 */
	@Override
	public BookingAgenda remove(Serializable primaryKey)
		throws NoSuchBookingAgendaException {

		Session session = null;

		try {
			session = openSession();

			BookingAgenda bookingAgenda = (BookingAgenda)session.get(
				BookingAgendaImpl.class, primaryKey);

			if (bookingAgenda == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBookingAgendaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bookingAgenda);
		}
		catch (NoSuchBookingAgendaException noSuchEntityException) {
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
	protected BookingAgenda removeImpl(BookingAgenda bookingAgenda) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bookingAgenda)) {
				bookingAgenda = (BookingAgenda)session.get(
					BookingAgendaImpl.class, bookingAgenda.getPrimaryKeyObj());
			}

			if (bookingAgenda != null) {
				session.delete(bookingAgenda);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (bookingAgenda != null) {
			clearCache(bookingAgenda);
		}

		return bookingAgenda;
	}

	@Override
	public BookingAgenda updateImpl(BookingAgenda bookingAgenda) {
		boolean isNew = bookingAgenda.isNew();

		if (!(bookingAgenda instanceof BookingAgendaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bookingAgenda.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					bookingAgenda);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bookingAgenda proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BookingAgenda implementation " +
					bookingAgenda.getClass());
		}

		BookingAgendaModelImpl bookingAgendaModelImpl =
			(BookingAgendaModelImpl)bookingAgenda;

		if (Validator.isNull(bookingAgenda.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			bookingAgenda.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (bookingAgenda.getCreateDate() == null)) {
			if (serviceContext == null) {
				bookingAgenda.setCreateDate(date);
			}
			else {
				bookingAgenda.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!bookingAgendaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				bookingAgenda.setModifiedDate(date);
			}
			else {
				bookingAgenda.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(bookingAgenda);
			}
			else {
				bookingAgenda = (BookingAgenda)session.merge(bookingAgenda);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BookingAgendaImpl.class, bookingAgendaModelImpl, false, true);

		cacheUniqueFindersCache(bookingAgendaModelImpl);

		if (isNew) {
			bookingAgenda.setNew(false);
		}

		bookingAgenda.resetOriginalValues();

		return bookingAgenda;
	}

	/**
	 * Returns the booking agenda with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the booking agenda
	 * @return the booking agenda
	 * @throws NoSuchBookingAgendaException if a booking agenda with the primary key could not be found
	 */
	@Override
	public BookingAgenda findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBookingAgendaException {

		BookingAgenda bookingAgenda = fetchByPrimaryKey(primaryKey);

		if (bookingAgenda == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBookingAgendaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bookingAgenda;
	}

	/**
	 * Returns the booking agenda with the primary key or throws a <code>NoSuchBookingAgendaException</code> if it could not be found.
	 *
	 * @param calendarBookingAgendaId the primary key of the booking agenda
	 * @return the booking agenda
	 * @throws NoSuchBookingAgendaException if a booking agenda with the primary key could not be found
	 */
	@Override
	public BookingAgenda findByPrimaryKey(long calendarBookingAgendaId)
		throws NoSuchBookingAgendaException {

		return findByPrimaryKey((Serializable)calendarBookingAgendaId);
	}

	/**
	 * Returns the booking agenda with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param calendarBookingAgendaId the primary key of the booking agenda
	 * @return the booking agenda, or <code>null</code> if a booking agenda with the primary key could not be found
	 */
	@Override
	public BookingAgenda fetchByPrimaryKey(long calendarBookingAgendaId) {
		return fetchByPrimaryKey((Serializable)calendarBookingAgendaId);
	}

	/**
	 * Returns all the booking agendas.
	 *
	 * @return the booking agendas
	 */
	@Override
	public List<BookingAgenda> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking agendas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @return the range of booking agendas
	 */
	@Override
	public List<BookingAgenda> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking agendas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of booking agendas
	 */
	@Override
	public List<BookingAgenda> findAll(
		int start, int end,
		OrderByComparator<BookingAgenda> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the booking agendas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingAgendaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking agendas
	 * @param end the upper bound of the range of booking agendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of booking agendas
	 */
	@Override
	public List<BookingAgenda> findAll(
		int start, int end, OrderByComparator<BookingAgenda> orderByComparator,
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

		List<BookingAgenda> list = null;

		if (useFinderCache) {
			list = (List<BookingAgenda>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BOOKINGAGENDA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BOOKINGAGENDA;

				sql = sql.concat(BookingAgendaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BookingAgenda>)QueryUtil.list(
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
	 * Removes all the booking agendas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BookingAgenda bookingAgenda : findAll()) {
			remove(bookingAgenda);
		}
	}

	/**
	 * Returns the number of booking agendas.
	 *
	 * @return the number of booking agendas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BOOKINGAGENDA);

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
		return "calendarBookingAgendaId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BOOKINGAGENDA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BookingAgendaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the booking agenda persistence.
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

		BookingAgendaUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		BookingAgendaUtil.setPersistence(null);

		entityCache.removeCache(BookingAgendaImpl.class.getName());
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

	private static final String _SQL_SELECT_BOOKINGAGENDA =
		"SELECT bookingAgenda FROM BookingAgenda bookingAgenda";

	private static final String _SQL_SELECT_BOOKINGAGENDA_WHERE =
		"SELECT bookingAgenda FROM BookingAgenda bookingAgenda WHERE ";

	private static final String _SQL_COUNT_BOOKINGAGENDA =
		"SELECT COUNT(bookingAgenda) FROM BookingAgenda bookingAgenda";

	private static final String _SQL_COUNT_BOOKINGAGENDA_WHERE =
		"SELECT COUNT(bookingAgenda) FROM BookingAgenda bookingAgenda WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "bookingAgenda.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BookingAgenda exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BookingAgenda exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BookingAgendaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}