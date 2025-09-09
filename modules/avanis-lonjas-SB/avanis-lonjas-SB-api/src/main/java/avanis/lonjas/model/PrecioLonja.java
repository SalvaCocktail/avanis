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
 * The extended model interface for the PrecioLonja service. Represents a row in the &quot;AVANIS_LONJAS_PrecioLonja&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PrecioLonjaModel
 * @generated
 */
@ImplementationClassName("avanis.lonjas.model.impl.PrecioLonjaImpl")
@ProviderType
public interface PrecioLonja extends PersistedModel, PrecioLonjaModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>avanis.lonjas.model.impl.PrecioLonjaImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PrecioLonja, Long> ENTITY_ID_ACCESSOR =
		new Accessor<PrecioLonja, Long>() {

			@Override
			public Long get(PrecioLonja precioLonja) {
				return precioLonja.getEntityId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<PrecioLonja> getTypeClass() {
				return PrecioLonja.class;
			}

		};

}