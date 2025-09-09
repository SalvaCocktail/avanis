/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the FechaLonja service. Represents a row in the &quot;AVANIS_LONJAS_FechaLonja&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see FechaLonjaModel
 * @generated
 */
@ImplementationClassName("avanis.lonjas.model.impl.FechaLonjaImpl")
@ProviderType
public interface FechaLonja extends FechaLonjaModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>avanis.lonjas.model.impl.FechaLonjaImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<FechaLonja, Long> ENTITY_ID_ACCESSOR =
		new Accessor<FechaLonja, Long>() {

			@Override
			public Long get(FechaLonja fechaLonja) {
				return fechaLonja.getEntityId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<FechaLonja> getTypeClass() {
				return FechaLonja.class;
			}

		};

}