/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.thread.logger.sb.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ThreadLog service. Represents a row in the &quot;ThreadLogger_ThreadLog&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ThreadLogModel
 * @generated
 */
@ImplementationClassName("avanis.thread.logger.sb.model.impl.ThreadLogImpl")
@ProviderType
public interface ThreadLog extends PersistedModel, ThreadLogModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>avanis.thread.logger.sb.model.impl.ThreadLogImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ThreadLog, Long> THREAD_LOG_ID_ACCESSOR =
		new Accessor<ThreadLog, Long>() {

			@Override
			public Long get(ThreadLog threadLog) {
				return threadLog.getThreadLogId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ThreadLog> getTypeClass() {
				return ThreadLog.class;
			}

		};

}