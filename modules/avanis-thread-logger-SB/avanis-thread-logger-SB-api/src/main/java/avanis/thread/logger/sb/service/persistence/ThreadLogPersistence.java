/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.thread.logger.sb.service.persistence;

import avanis.thread.logger.sb.exception.NoSuchThreadLogException;
import avanis.thread.logger.sb.model.ThreadLog;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the thread log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ThreadLogUtil
 * @generated
 */
@ProviderType
public interface ThreadLogPersistence extends BasePersistence<ThreadLog> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ThreadLogUtil} to access the thread log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the thread logs where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @return the matching thread logs
	 */
	public java.util.List<ThreadLog> findByCreateDate(Date createDate);

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
	public java.util.List<ThreadLog> findByCreateDate(
		Date createDate, int start, int end);

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
	public java.util.List<ThreadLog> findByCreateDate(
		Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThreadLog>
			orderByComparator);

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
	public java.util.List<ThreadLog> findByCreateDate(
		Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThreadLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first thread log in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thread log
	 * @throws NoSuchThreadLogException if a matching thread log could not be found
	 */
	public ThreadLog findByCreateDate_First(
			Date createDate,
			com.liferay.portal.kernel.util.OrderByComparator<ThreadLog>
				orderByComparator)
		throws NoSuchThreadLogException;

	/**
	 * Returns the first thread log in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thread log, or <code>null</code> if a matching thread log could not be found
	 */
	public ThreadLog fetchByCreateDate_First(
		Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<ThreadLog>
			orderByComparator);

	/**
	 * Returns the last thread log in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thread log
	 * @throws NoSuchThreadLogException if a matching thread log could not be found
	 */
	public ThreadLog findByCreateDate_Last(
			Date createDate,
			com.liferay.portal.kernel.util.OrderByComparator<ThreadLog>
				orderByComparator)
		throws NoSuchThreadLogException;

	/**
	 * Returns the last thread log in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thread log, or <code>null</code> if a matching thread log could not be found
	 */
	public ThreadLog fetchByCreateDate_Last(
		Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator<ThreadLog>
			orderByComparator);

	/**
	 * Returns the thread logs before and after the current thread log in the ordered set where createDate = &#63;.
	 *
	 * @param threadLogId the primary key of the current thread log
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next thread log
	 * @throws NoSuchThreadLogException if a thread log with the primary key could not be found
	 */
	public ThreadLog[] findByCreateDate_PrevAndNext(
			long threadLogId, Date createDate,
			com.liferay.portal.kernel.util.OrderByComparator<ThreadLog>
				orderByComparator)
		throws NoSuchThreadLogException;

	/**
	 * Removes all the thread logs where createDate = &#63; from the database.
	 *
	 * @param createDate the create date
	 */
	public void removeByCreateDate(Date createDate);

	/**
	 * Returns the number of thread logs where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @return the number of matching thread logs
	 */
	public int countByCreateDate(Date createDate);

	/**
	 * Caches the thread log in the entity cache if it is enabled.
	 *
	 * @param threadLog the thread log
	 */
	public void cacheResult(ThreadLog threadLog);

	/**
	 * Caches the thread logs in the entity cache if it is enabled.
	 *
	 * @param threadLogs the thread logs
	 */
	public void cacheResult(java.util.List<ThreadLog> threadLogs);

	/**
	 * Creates a new thread log with the primary key. Does not add the thread log to the database.
	 *
	 * @param threadLogId the primary key for the new thread log
	 * @return the new thread log
	 */
	public ThreadLog create(long threadLogId);

	/**
	 * Removes the thread log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param threadLogId the primary key of the thread log
	 * @return the thread log that was removed
	 * @throws NoSuchThreadLogException if a thread log with the primary key could not be found
	 */
	public ThreadLog remove(long threadLogId) throws NoSuchThreadLogException;

	public ThreadLog updateImpl(ThreadLog threadLog);

	/**
	 * Returns the thread log with the primary key or throws a <code>NoSuchThreadLogException</code> if it could not be found.
	 *
	 * @param threadLogId the primary key of the thread log
	 * @return the thread log
	 * @throws NoSuchThreadLogException if a thread log with the primary key could not be found
	 */
	public ThreadLog findByPrimaryKey(long threadLogId)
		throws NoSuchThreadLogException;

	/**
	 * Returns the thread log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param threadLogId the primary key of the thread log
	 * @return the thread log, or <code>null</code> if a thread log with the primary key could not be found
	 */
	public ThreadLog fetchByPrimaryKey(long threadLogId);

	/**
	 * Returns all the thread logs.
	 *
	 * @return the thread logs
	 */
	public java.util.List<ThreadLog> findAll();

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
	public java.util.List<ThreadLog> findAll(int start, int end);

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
	public java.util.List<ThreadLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThreadLog>
			orderByComparator);

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
	public java.util.List<ThreadLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThreadLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the thread logs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of thread logs.
	 *
	 * @return the number of thread logs
	 */
	public int countAll();

}