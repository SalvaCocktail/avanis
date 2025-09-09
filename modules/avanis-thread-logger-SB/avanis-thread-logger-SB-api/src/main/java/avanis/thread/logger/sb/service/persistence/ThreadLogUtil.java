/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.thread.logger.sb.service.persistence;

import avanis.thread.logger.sb.model.ThreadLog;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the thread log service. This utility wraps <code>avanis.thread.logger.sb.service.persistence.impl.ThreadLogPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ThreadLogPersistence
 * @generated
 */
public class ThreadLogUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ThreadLog threadLog) {
		getPersistence().clearCache(threadLog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ThreadLog> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ThreadLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ThreadLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ThreadLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ThreadLog> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ThreadLog update(ThreadLog threadLog) {
		return getPersistence().update(threadLog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ThreadLog update(
		ThreadLog threadLog, ServiceContext serviceContext) {

		return getPersistence().update(threadLog, serviceContext);
	}

	/**
	 * Returns all the thread logs where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @return the matching thread logs
	 */
	public static List<ThreadLog> findByCreateDate(Date createDate) {
		return getPersistence().findByCreateDate(createDate);
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
	public static List<ThreadLog> findByCreateDate(
		Date createDate, int start, int end) {

		return getPersistence().findByCreateDate(createDate, start, end);
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
	public static List<ThreadLog> findByCreateDate(
		Date createDate, int start, int end,
		OrderByComparator<ThreadLog> orderByComparator) {

		return getPersistence().findByCreateDate(
			createDate, start, end, orderByComparator);
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
	public static List<ThreadLog> findByCreateDate(
		Date createDate, int start, int end,
		OrderByComparator<ThreadLog> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCreateDate(
			createDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first thread log in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thread log
	 * @throws NoSuchThreadLogException if a matching thread log could not be found
	 */
	public static ThreadLog findByCreateDate_First(
			Date createDate, OrderByComparator<ThreadLog> orderByComparator)
		throws avanis.thread.logger.sb.exception.NoSuchThreadLogException {

		return getPersistence().findByCreateDate_First(
			createDate, orderByComparator);
	}

	/**
	 * Returns the first thread log in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thread log, or <code>null</code> if a matching thread log could not be found
	 */
	public static ThreadLog fetchByCreateDate_First(
		Date createDate, OrderByComparator<ThreadLog> orderByComparator) {

		return getPersistence().fetchByCreateDate_First(
			createDate, orderByComparator);
	}

	/**
	 * Returns the last thread log in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thread log
	 * @throws NoSuchThreadLogException if a matching thread log could not be found
	 */
	public static ThreadLog findByCreateDate_Last(
			Date createDate, OrderByComparator<ThreadLog> orderByComparator)
		throws avanis.thread.logger.sb.exception.NoSuchThreadLogException {

		return getPersistence().findByCreateDate_Last(
			createDate, orderByComparator);
	}

	/**
	 * Returns the last thread log in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thread log, or <code>null</code> if a matching thread log could not be found
	 */
	public static ThreadLog fetchByCreateDate_Last(
		Date createDate, OrderByComparator<ThreadLog> orderByComparator) {

		return getPersistence().fetchByCreateDate_Last(
			createDate, orderByComparator);
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
	public static ThreadLog[] findByCreateDate_PrevAndNext(
			long threadLogId, Date createDate,
			OrderByComparator<ThreadLog> orderByComparator)
		throws avanis.thread.logger.sb.exception.NoSuchThreadLogException {

		return getPersistence().findByCreateDate_PrevAndNext(
			threadLogId, createDate, orderByComparator);
	}

	/**
	 * Removes all the thread logs where createDate = &#63; from the database.
	 *
	 * @param createDate the create date
	 */
	public static void removeByCreateDate(Date createDate) {
		getPersistence().removeByCreateDate(createDate);
	}

	/**
	 * Returns the number of thread logs where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @return the number of matching thread logs
	 */
	public static int countByCreateDate(Date createDate) {
		return getPersistence().countByCreateDate(createDate);
	}

	/**
	 * Caches the thread log in the entity cache if it is enabled.
	 *
	 * @param threadLog the thread log
	 */
	public static void cacheResult(ThreadLog threadLog) {
		getPersistence().cacheResult(threadLog);
	}

	/**
	 * Caches the thread logs in the entity cache if it is enabled.
	 *
	 * @param threadLogs the thread logs
	 */
	public static void cacheResult(List<ThreadLog> threadLogs) {
		getPersistence().cacheResult(threadLogs);
	}

	/**
	 * Creates a new thread log with the primary key. Does not add the thread log to the database.
	 *
	 * @param threadLogId the primary key for the new thread log
	 * @return the new thread log
	 */
	public static ThreadLog create(long threadLogId) {
		return getPersistence().create(threadLogId);
	}

	/**
	 * Removes the thread log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param threadLogId the primary key of the thread log
	 * @return the thread log that was removed
	 * @throws NoSuchThreadLogException if a thread log with the primary key could not be found
	 */
	public static ThreadLog remove(long threadLogId)
		throws avanis.thread.logger.sb.exception.NoSuchThreadLogException {

		return getPersistence().remove(threadLogId);
	}

	public static ThreadLog updateImpl(ThreadLog threadLog) {
		return getPersistence().updateImpl(threadLog);
	}

	/**
	 * Returns the thread log with the primary key or throws a <code>NoSuchThreadLogException</code> if it could not be found.
	 *
	 * @param threadLogId the primary key of the thread log
	 * @return the thread log
	 * @throws NoSuchThreadLogException if a thread log with the primary key could not be found
	 */
	public static ThreadLog findByPrimaryKey(long threadLogId)
		throws avanis.thread.logger.sb.exception.NoSuchThreadLogException {

		return getPersistence().findByPrimaryKey(threadLogId);
	}

	/**
	 * Returns the thread log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param threadLogId the primary key of the thread log
	 * @return the thread log, or <code>null</code> if a thread log with the primary key could not be found
	 */
	public static ThreadLog fetchByPrimaryKey(long threadLogId) {
		return getPersistence().fetchByPrimaryKey(threadLogId);
	}

	/**
	 * Returns all the thread logs.
	 *
	 * @return the thread logs
	 */
	public static List<ThreadLog> findAll() {
		return getPersistence().findAll();
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
	public static List<ThreadLog> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<ThreadLog> findAll(
		int start, int end, OrderByComparator<ThreadLog> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<ThreadLog> findAll(
		int start, int end, OrderByComparator<ThreadLog> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the thread logs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of thread logs.
	 *
	 * @return the number of thread logs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ThreadLogPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ThreadLogPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ThreadLogPersistence _persistence;

}