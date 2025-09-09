/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.thread.logger.sb.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ThreadLog}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ThreadLog
 * @generated
 */
public class ThreadLogWrapper
	extends BaseModelWrapper<ThreadLog>
	implements ModelWrapper<ThreadLog>, ThreadLog {

	public ThreadLogWrapper(ThreadLog threadLog) {
		super(threadLog);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("threadLogId", getThreadLogId());
		attributes.put("createDate", getCreateDate());
		attributes.put("threadName", getThreadName());
		attributes.put("stackTrace", getStackTrace());
		attributes.put("threadState", getThreadState());
		attributes.put("lockName", getLockName());
		attributes.put("lockOwnerName", getLockOwnerName());
		attributes.put("lockOwnerId", getLockOwnerId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long threadLogId = (Long)attributes.get("threadLogId");

		if (threadLogId != null) {
			setThreadLogId(threadLogId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String threadName = (String)attributes.get("threadName");

		if (threadName != null) {
			setThreadName(threadName);
		}

		String stackTrace = (String)attributes.get("stackTrace");

		if (stackTrace != null) {
			setStackTrace(stackTrace);
		}

		String threadState = (String)attributes.get("threadState");

		if (threadState != null) {
			setThreadState(threadState);
		}

		String lockName = (String)attributes.get("lockName");

		if (lockName != null) {
			setLockName(lockName);
		}

		String lockOwnerName = (String)attributes.get("lockOwnerName");

		if (lockOwnerName != null) {
			setLockOwnerName(lockOwnerName);
		}

		Long lockOwnerId = (Long)attributes.get("lockOwnerId");

		if (lockOwnerId != null) {
			setLockOwnerId(lockOwnerId);
		}
	}

	@Override
	public ThreadLog cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the create date of this thread log.
	 *
	 * @return the create date of this thread log
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the lock name of this thread log.
	 *
	 * @return the lock name of this thread log
	 */
	@Override
	public String getLockName() {
		return model.getLockName();
	}

	/**
	 * Returns the lock owner ID of this thread log.
	 *
	 * @return the lock owner ID of this thread log
	 */
	@Override
	public long getLockOwnerId() {
		return model.getLockOwnerId();
	}

	/**
	 * Returns the lock owner name of this thread log.
	 *
	 * @return the lock owner name of this thread log
	 */
	@Override
	public String getLockOwnerName() {
		return model.getLockOwnerName();
	}

	/**
	 * Returns the primary key of this thread log.
	 *
	 * @return the primary key of this thread log
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the stack trace of this thread log.
	 *
	 * @return the stack trace of this thread log
	 */
	@Override
	public String getStackTrace() {
		return model.getStackTrace();
	}

	/**
	 * Returns the thread log ID of this thread log.
	 *
	 * @return the thread log ID of this thread log
	 */
	@Override
	public long getThreadLogId() {
		return model.getThreadLogId();
	}

	/**
	 * Returns the thread name of this thread log.
	 *
	 * @return the thread name of this thread log
	 */
	@Override
	public String getThreadName() {
		return model.getThreadName();
	}

	/**
	 * Returns the thread state of this thread log.
	 *
	 * @return the thread state of this thread log
	 */
	@Override
	public String getThreadState() {
		return model.getThreadState();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this thread log.
	 *
	 * @param createDate the create date of this thread log
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the lock name of this thread log.
	 *
	 * @param lockName the lock name of this thread log
	 */
	@Override
	public void setLockName(String lockName) {
		model.setLockName(lockName);
	}

	/**
	 * Sets the lock owner ID of this thread log.
	 *
	 * @param lockOwnerId the lock owner ID of this thread log
	 */
	@Override
	public void setLockOwnerId(long lockOwnerId) {
		model.setLockOwnerId(lockOwnerId);
	}

	/**
	 * Sets the lock owner name of this thread log.
	 *
	 * @param lockOwnerName the lock owner name of this thread log
	 */
	@Override
	public void setLockOwnerName(String lockOwnerName) {
		model.setLockOwnerName(lockOwnerName);
	}

	/**
	 * Sets the primary key of this thread log.
	 *
	 * @param primaryKey the primary key of this thread log
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the stack trace of this thread log.
	 *
	 * @param stackTrace the stack trace of this thread log
	 */
	@Override
	public void setStackTrace(String stackTrace) {
		model.setStackTrace(stackTrace);
	}

	/**
	 * Sets the thread log ID of this thread log.
	 *
	 * @param threadLogId the thread log ID of this thread log
	 */
	@Override
	public void setThreadLogId(long threadLogId) {
		model.setThreadLogId(threadLogId);
	}

	/**
	 * Sets the thread name of this thread log.
	 *
	 * @param threadName the thread name of this thread log
	 */
	@Override
	public void setThreadName(String threadName) {
		model.setThreadName(threadName);
	}

	/**
	 * Sets the thread state of this thread log.
	 *
	 * @param threadState the thread state of this thread log
	 */
	@Override
	public void setThreadState(String threadState) {
		model.setThreadState(threadState);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ThreadLogWrapper wrap(ThreadLog threadLog) {
		return new ThreadLogWrapper(threadLog);
	}

}