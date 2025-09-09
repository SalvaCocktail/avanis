/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.thread.logger.sb.model.impl;

import avanis.thread.logger.sb.model.ThreadLog;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ThreadLog in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ThreadLogCacheModel
	implements CacheModel<ThreadLog>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ThreadLogCacheModel)) {
			return false;
		}

		ThreadLogCacheModel threadLogCacheModel = (ThreadLogCacheModel)object;

		if (threadLogId == threadLogCacheModel.threadLogId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, threadLogId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{threadLogId=");
		sb.append(threadLogId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", threadName=");
		sb.append(threadName);
		sb.append(", stackTrace=");
		sb.append(stackTrace);
		sb.append(", threadState=");
		sb.append(threadState);
		sb.append(", lockName=");
		sb.append(lockName);
		sb.append(", lockOwnerName=");
		sb.append(lockOwnerName);
		sb.append(", lockOwnerId=");
		sb.append(lockOwnerId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ThreadLog toEntityModel() {
		ThreadLogImpl threadLogImpl = new ThreadLogImpl();

		threadLogImpl.setThreadLogId(threadLogId);

		if (createDate == Long.MIN_VALUE) {
			threadLogImpl.setCreateDate(null);
		}
		else {
			threadLogImpl.setCreateDate(new Date(createDate));
		}

		if (threadName == null) {
			threadLogImpl.setThreadName("");
		}
		else {
			threadLogImpl.setThreadName(threadName);
		}

		if (stackTrace == null) {
			threadLogImpl.setStackTrace("");
		}
		else {
			threadLogImpl.setStackTrace(stackTrace);
		}

		if (threadState == null) {
			threadLogImpl.setThreadState("");
		}
		else {
			threadLogImpl.setThreadState(threadState);
		}

		if (lockName == null) {
			threadLogImpl.setLockName("");
		}
		else {
			threadLogImpl.setLockName(lockName);
		}

		if (lockOwnerName == null) {
			threadLogImpl.setLockOwnerName("");
		}
		else {
			threadLogImpl.setLockOwnerName(lockOwnerName);
		}

		threadLogImpl.setLockOwnerId(lockOwnerId);

		threadLogImpl.resetOriginalValues();

		return threadLogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		threadLogId = objectInput.readLong();
		createDate = objectInput.readLong();
		threadName = objectInput.readUTF();
		stackTrace = objectInput.readUTF();
		threadState = objectInput.readUTF();
		lockName = objectInput.readUTF();
		lockOwnerName = objectInput.readUTF();

		lockOwnerId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(threadLogId);
		objectOutput.writeLong(createDate);

		if (threadName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(threadName);
		}

		if (stackTrace == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stackTrace);
		}

		if (threadState == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(threadState);
		}

		if (lockName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lockName);
		}

		if (lockOwnerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lockOwnerName);
		}

		objectOutput.writeLong(lockOwnerId);
	}

	public long threadLogId;
	public long createDate;
	public String threadName;
	public String stackTrace;
	public String threadState;
	public String lockName;
	public String lockOwnerName;
	public long lockOwnerId;

}