/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.thread.logger.sb.service.persistence.impl;

import avanis.thread.logger.sb.exception.NoSuchThreadLogException;
import avanis.thread.logger.sb.model.ThreadLog;
import avanis.thread.logger.sb.model.ThreadLogTable;
import avanis.thread.logger.sb.model.impl.ThreadLogImpl;
import avanis.thread.logger.sb.model.impl.ThreadLogModelImpl;
import avanis.thread.logger.sb.service.persistence.ThreadLogPersistence;
import avanis.thread.logger.sb.service.persistence.ThreadLogUtil;
import avanis.thread.logger.sb.service.persistence.impl.constants.ThreadLoggerPersistenceConstants;

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

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
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
 * The persistence implementation for the thread log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ThreadLogPersistence.class)
public class ThreadLogPersistenceImpl
	extends BasePersistenceImpl<ThreadLog> implements ThreadLogPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ThreadLogUtil</code> to access the thread log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ThreadLogImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCreateDate;
	private FinderPath _finderPathWithoutPaginationFindByCreateDate;
	private FinderPath _finderPathCountByCreateDate;

	/**
	 * Returns all the thread logs where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @return the matching thread logs
	 */
	@Override
	public List<ThreadLog> findByCreateDate(Date createDate) {
		return findByCreateDate(
			createDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the thread logs where createDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThreadLogModelImpl</code>.
	 * </p>
	 *
	 * @param createDate the create date
	 * @param start the lower bound of the range of thread logs
	 * @param end the upper bound of the range of thread logs (not inclusive)
	 * @return the range of matching thread logs
	 */
	@Override
	public List<ThreadLog> findByCreateDate(
		Date createDate, int start, int end) {

		return findByCreateDate(createDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the thread logs where createDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThreadLogModelImpl</code>.
	 * </p>
	 *
	 * @param createDate the create date
	 * @param start the lower bound of the range of thread logs
	 * @param end the upper bound of the range of thread logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching thread logs
	 */
	@Override
	public List<ThreadLog> findByCreateDate(
		Date createDate, int start, int end,
		OrderByComparator<ThreadLog> orderByComparator) {

		return findByCreateDate(
			createDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the thread logs where createDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThreadLogModelImpl</code>.
	 * </p>
	 *
	 * @param createDate the create date
	 * @param start the lower bound of the range of thread logs
	 * @param end the upper bound of the range of thread logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching thread logs
	 */
	@Override
	public List<ThreadLog> findByCreateDate(
		Date createDate, int start, int end,
		OrderByComparator<ThreadLog> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCreateDate;
				finderArgs = new Object[] {_getTime(createDate)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCreateDate;
			finderArgs = new Object[] {
				_getTime(createDate), start, end, orderByComparator
			};
		}

		List<ThreadLog> list = null;

		if (useFinderCache) {
			list = (List<ThreadLog>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ThreadLog threadLog : list) {
					if (!Objects.equals(
							createDate, threadLog.getCreateDate())) {

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

			sb.append(_SQL_SELECT_THREADLOG_WHERE);

			boolean bindCreateDate = false;

			if (createDate == null) {
				sb.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				sb.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ThreadLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCreateDate) {
					queryPos.add(new Timestamp(createDate.getTime()));
				}

				list = (List<ThreadLog>)QueryUtil.list(
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
	 * Returns the first thread log in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thread log
	 * @throws NoSuchThreadLogException if a matching thread log could not be found
	 */
	@Override
	public ThreadLog findByCreateDate_First(
			Date createDate, OrderByComparator<ThreadLog> orderByComparator)
		throws NoSuchThreadLogException {

		ThreadLog threadLog = fetchByCreateDate_First(
			createDate, orderByComparator);

		if (threadLog != null) {
			return threadLog;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("createDate=");
		sb.append(createDate);

		sb.append("}");

		throw new NoSuchThreadLogException(sb.toString());
	}

	/**
	 * Returns the first thread log in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thread log, or <code>null</code> if a matching thread log could not be found
	 */
	@Override
	public ThreadLog fetchByCreateDate_First(
		Date createDate, OrderByComparator<ThreadLog> orderByComparator) {

		List<ThreadLog> list = findByCreateDate(
			createDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last thread log in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thread log
	 * @throws NoSuchThreadLogException if a matching thread log could not be found
	 */
	@Override
	public ThreadLog findByCreateDate_Last(
			Date createDate, OrderByComparator<ThreadLog> orderByComparator)
		throws NoSuchThreadLogException {

		ThreadLog threadLog = fetchByCreateDate_Last(
			createDate, orderByComparator);

		if (threadLog != null) {
			return threadLog;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("createDate=");
		sb.append(createDate);

		sb.append("}");

		throw new NoSuchThreadLogException(sb.toString());
	}

	/**
	 * Returns the last thread log in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thread log, or <code>null</code> if a matching thread log could not be found
	 */
	@Override
	public ThreadLog fetchByCreateDate_Last(
		Date createDate, OrderByComparator<ThreadLog> orderByComparator) {

		int count = countByCreateDate(createDate);

		if (count == 0) {
			return null;
		}

		List<ThreadLog> list = findByCreateDate(
			createDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the thread logs before and after the current thread log in the ordered set where createDate = &#63;.
	 *
	 * @param threadLogId the primary key of the current thread log
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next thread log
	 * @throws NoSuchThreadLogException if a thread log with the primary key could not be found
	 */
	@Override
	public ThreadLog[] findByCreateDate_PrevAndNext(
			long threadLogId, Date createDate,
			OrderByComparator<ThreadLog> orderByComparator)
		throws NoSuchThreadLogException {

		ThreadLog threadLog = findByPrimaryKey(threadLogId);

		Session session = null;

		try {
			session = openSession();

			ThreadLog[] array = new ThreadLogImpl[3];

			array[0] = getByCreateDate_PrevAndNext(
				session, threadLog, createDate, orderByComparator, true);

			array[1] = threadLog;

			array[2] = getByCreateDate_PrevAndNext(
				session, threadLog, createDate, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ThreadLog getByCreateDate_PrevAndNext(
		Session session, ThreadLog threadLog, Date createDate,
		OrderByComparator<ThreadLog> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_THREADLOG_WHERE);

		boolean bindCreateDate = false;

		if (createDate == null) {
			sb.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_1);
		}
		else {
			bindCreateDate = true;

			sb.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_2);
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
			sb.append(ThreadLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCreateDate) {
			queryPos.add(new Timestamp(createDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(threadLog)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ThreadLog> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the thread logs where createDate = &#63; from the database.
	 *
	 * @param createDate the create date
	 */
	@Override
	public void removeByCreateDate(Date createDate) {
		for (ThreadLog threadLog :
				findByCreateDate(
					createDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(threadLog);
		}
	}

	/**
	 * Returns the number of thread logs where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @return the number of matching thread logs
	 */
	@Override
	public int countByCreateDate(Date createDate) {
		FinderPath finderPath = _finderPathCountByCreateDate;

		Object[] finderArgs = new Object[] {_getTime(createDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_THREADLOG_WHERE);

			boolean bindCreateDate = false;

			if (createDate == null) {
				sb.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				sb.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCreateDate) {
					queryPos.add(new Timestamp(createDate.getTime()));
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

	private static final String _FINDER_COLUMN_CREATEDATE_CREATEDATE_1 =
		"threadLog.createDate IS NULL";

	private static final String _FINDER_COLUMN_CREATEDATE_CREATEDATE_2 =
		"threadLog.createDate = ?";

	public ThreadLogPersistenceImpl() {
		setModelClass(ThreadLog.class);

		setModelImplClass(ThreadLogImpl.class);
		setModelPKClass(long.class);

		setTable(ThreadLogTable.INSTANCE);
	}

	/**
	 * Caches the thread log in the entity cache if it is enabled.
	 *
	 * @param threadLog the thread log
	 */
	@Override
	public void cacheResult(ThreadLog threadLog) {
		entityCache.putResult(
			ThreadLogImpl.class, threadLog.getPrimaryKey(), threadLog);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the thread logs in the entity cache if it is enabled.
	 *
	 * @param threadLogs the thread logs
	 */
	@Override
	public void cacheResult(List<ThreadLog> threadLogs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (threadLogs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ThreadLog threadLog : threadLogs) {
			if (entityCache.getResult(
					ThreadLogImpl.class, threadLog.getPrimaryKey()) == null) {

				cacheResult(threadLog);
			}
		}
	}

	/**
	 * Clears the cache for all thread logs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ThreadLogImpl.class);

		finderCache.clearCache(ThreadLogImpl.class);
	}

	/**
	 * Clears the cache for the thread log.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ThreadLog threadLog) {
		entityCache.removeResult(ThreadLogImpl.class, threadLog);
	}

	@Override
	public void clearCache(List<ThreadLog> threadLogs) {
		for (ThreadLog threadLog : threadLogs) {
			entityCache.removeResult(ThreadLogImpl.class, threadLog);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ThreadLogImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ThreadLogImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new thread log with the primary key. Does not add the thread log to the database.
	 *
	 * @param threadLogId the primary key for the new thread log
	 * @return the new thread log
	 */
	@Override
	public ThreadLog create(long threadLogId) {
		ThreadLog threadLog = new ThreadLogImpl();

		threadLog.setNew(true);
		threadLog.setPrimaryKey(threadLogId);

		return threadLog;
	}

	/**
	 * Removes the thread log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param threadLogId the primary key of the thread log
	 * @return the thread log that was removed
	 * @throws NoSuchThreadLogException if a thread log with the primary key could not be found
	 */
	@Override
	public ThreadLog remove(long threadLogId) throws NoSuchThreadLogException {
		return remove((Serializable)threadLogId);
	}

	/**
	 * Removes the thread log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the thread log
	 * @return the thread log that was removed
	 * @throws NoSuchThreadLogException if a thread log with the primary key could not be found
	 */
	@Override
	public ThreadLog remove(Serializable primaryKey)
		throws NoSuchThreadLogException {

		Session session = null;

		try {
			session = openSession();

			ThreadLog threadLog = (ThreadLog)session.get(
				ThreadLogImpl.class, primaryKey);

			if (threadLog == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchThreadLogException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(threadLog);
		}
		catch (NoSuchThreadLogException noSuchEntityException) {
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
	protected ThreadLog removeImpl(ThreadLog threadLog) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(threadLog)) {
				threadLog = (ThreadLog)session.get(
					ThreadLogImpl.class, threadLog.getPrimaryKeyObj());
			}

			if (threadLog != null) {
				session.delete(threadLog);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (threadLog != null) {
			clearCache(threadLog);
		}

		return threadLog;
	}

	@Override
	public ThreadLog updateImpl(ThreadLog threadLog) {
		boolean isNew = threadLog.isNew();

		if (!(threadLog instanceof ThreadLogModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(threadLog.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(threadLog);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in threadLog proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ThreadLog implementation " +
					threadLog.getClass());
		}

		ThreadLogModelImpl threadLogModelImpl = (ThreadLogModelImpl)threadLog;

		if (isNew && (threadLog.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				threadLog.setCreateDate(date);
			}
			else {
				threadLog.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(threadLog);
			}
			else {
				threadLog = (ThreadLog)session.merge(threadLog);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ThreadLogImpl.class, threadLogModelImpl, false, true);

		if (isNew) {
			threadLog.setNew(false);
		}

		threadLog.resetOriginalValues();

		return threadLog;
	}

	/**
	 * Returns the thread log with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the thread log
	 * @return the thread log
	 * @throws NoSuchThreadLogException if a thread log with the primary key could not be found
	 */
	@Override
	public ThreadLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchThreadLogException {

		ThreadLog threadLog = fetchByPrimaryKey(primaryKey);

		if (threadLog == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchThreadLogException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return threadLog;
	}

	/**
	 * Returns the thread log with the primary key or throws a <code>NoSuchThreadLogException</code> if it could not be found.
	 *
	 * @param threadLogId the primary key of the thread log
	 * @return the thread log
	 * @throws NoSuchThreadLogException if a thread log with the primary key could not be found
	 */
	@Override
	public ThreadLog findByPrimaryKey(long threadLogId)
		throws NoSuchThreadLogException {

		return findByPrimaryKey((Serializable)threadLogId);
	}

	/**
	 * Returns the thread log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param threadLogId the primary key of the thread log
	 * @return the thread log, or <code>null</code> if a thread log with the primary key could not be found
	 */
	@Override
	public ThreadLog fetchByPrimaryKey(long threadLogId) {
		return fetchByPrimaryKey((Serializable)threadLogId);
	}

	/**
	 * Returns all the thread logs.
	 *
	 * @return the thread logs
	 */
	@Override
	public List<ThreadLog> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the thread logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThreadLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of thread logs
	 * @param end the upper bound of the range of thread logs (not inclusive)
	 * @return the range of thread logs
	 */
	@Override
	public List<ThreadLog> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the thread logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThreadLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of thread logs
	 * @param end the upper bound of the range of thread logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of thread logs
	 */
	@Override
	public List<ThreadLog> findAll(
		int start, int end, OrderByComparator<ThreadLog> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the thread logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThreadLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of thread logs
	 * @param end the upper bound of the range of thread logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of thread logs
	 */
	@Override
	public List<ThreadLog> findAll(
		int start, int end, OrderByComparator<ThreadLog> orderByComparator,
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

		List<ThreadLog> list = null;

		if (useFinderCache) {
			list = (List<ThreadLog>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_THREADLOG);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_THREADLOG;

				sql = sql.concat(ThreadLogModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ThreadLog>)QueryUtil.list(
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
	 * Removes all the thread logs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ThreadLog threadLog : findAll()) {
			remove(threadLog);
		}
	}

	/**
	 * Returns the number of thread logs.
	 *
	 * @return the number of thread logs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_THREADLOG);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "threadLogId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_THREADLOG;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ThreadLogModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the thread log persistence.
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

		_finderPathWithPaginationFindByCreateDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCreateDate",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"createDate"}, true);

		_finderPathWithoutPaginationFindByCreateDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCreateDate",
			new String[] {Date.class.getName()}, new String[] {"createDate"},
			true);

		_finderPathCountByCreateDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCreateDate",
			new String[] {Date.class.getName()}, new String[] {"createDate"},
			false);

		ThreadLogUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ThreadLogUtil.setPersistence(null);

		entityCache.removeCache(ThreadLogImpl.class.getName());
	}

	@Override
	@Reference(
		target = ThreadLoggerPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = ThreadLoggerPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ThreadLoggerPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_THREADLOG =
		"SELECT threadLog FROM ThreadLog threadLog";

	private static final String _SQL_SELECT_THREADLOG_WHERE =
		"SELECT threadLog FROM ThreadLog threadLog WHERE ";

	private static final String _SQL_COUNT_THREADLOG =
		"SELECT COUNT(threadLog) FROM ThreadLog threadLog";

	private static final String _SQL_COUNT_THREADLOG_WHERE =
		"SELECT COUNT(threadLog) FROM ThreadLog threadLog WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "threadLog.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ThreadLog exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ThreadLog exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ThreadLogPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}