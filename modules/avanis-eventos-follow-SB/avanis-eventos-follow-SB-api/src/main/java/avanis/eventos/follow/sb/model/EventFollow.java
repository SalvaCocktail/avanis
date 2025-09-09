/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.eventos.follow.sb.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the EventFollow service. Represents a row in the &quot;EVENT_FOLLOW_EventFollow&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see EventFollowModel
 * @generated
 */
@ImplementationClassName("avanis.eventos.follow.sb.model.impl.EventFollowImpl")
@ProviderType
public interface EventFollow extends EventFollowModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>avanis.eventos.follow.sb.model.impl.EventFollowImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<EventFollow, Long> EVENT_FOLLOW_ID_ACCESSOR =
		new Accessor<EventFollow, Long>() {

			@Override
			public Long get(EventFollow eventFollow) {
				return eventFollow.getEventFollowId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<EventFollow> getTypeClass() {
				return EventFollow.class;
			}

		};

}