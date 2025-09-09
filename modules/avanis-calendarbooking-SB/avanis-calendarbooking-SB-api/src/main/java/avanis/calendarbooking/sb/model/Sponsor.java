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
 * The extended model interface for the Sponsor service. Represents a row in the &quot;AVANIS_CALENDAR_Sponsor&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SponsorModel
 * @generated
 */
@ImplementationClassName("avanis.calendarbooking.sb.model.impl.SponsorImpl")
@ProviderType
public interface Sponsor extends PersistedModel, SponsorModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>avanis.calendarbooking.sb.model.impl.SponsorImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Sponsor, Long> SPONSOR_ID_ACCESSOR =
		new Accessor<Sponsor, Long>() {

			@Override
			public Long get(Sponsor sponsor) {
				return sponsor.getSponsorId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Sponsor> getTypeClass() {
				return Sponsor.class;
			}

		};

}