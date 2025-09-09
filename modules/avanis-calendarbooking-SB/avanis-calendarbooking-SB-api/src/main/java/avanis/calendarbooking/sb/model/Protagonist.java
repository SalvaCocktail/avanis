/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Protagonist service. Represents a row in the &quot;AVANIS_CALENDAR_Protagonist&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ProtagonistModel
 * @generated
 */
@ImplementationClassName("avanis.calendarbooking.sb.model.impl.ProtagonistImpl")
@ProviderType
public interface Protagonist extends PersistedModel, ProtagonistModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>avanis.calendarbooking.sb.model.impl.ProtagonistImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Protagonist, Long> PROTAGONIST_ID_ACCESSOR =
		new Accessor<Protagonist, Long>() {

			@Override
			public Long get(Protagonist protagonist) {
				return protagonist.getProtagonistId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Protagonist> getTypeClass() {
				return Protagonist.class;
			}

		};

}