/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.tu.explotacion.sb.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Explotacion service. Represents a row in the &quot;AVANIS_EXPLOTACION_Explotacion&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ExplotacionModel
 * @generated
 */
@ImplementationClassName("avanis.tu.explotacion.sb.model.impl.ExplotacionImpl")
@ProviderType
public interface Explotacion extends ExplotacionModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>avanis.tu.explotacion.sb.model.impl.ExplotacionImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Explotacion, Long> EXPLOTACION_ID_ACCESSOR =
		new Accessor<Explotacion, Long>() {

			@Override
			public Long get(Explotacion explotacion) {
				return explotacion.getExplotacionId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Explotacion> getTypeClass() {
				return Explotacion.class;
			}

		};

}