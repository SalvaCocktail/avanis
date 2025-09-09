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
 * The extended model interface for the Grupo service. Represents a row in the &quot;AVANIS_LONJAS_Grupo&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see GrupoModel
 * @generated
 */
@ImplementationClassName("avanis.lonjas.model.impl.GrupoImpl")
@ProviderType
public interface Grupo extends GrupoModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>avanis.lonjas.model.impl.GrupoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Grupo, Long> ENTITY_ID_ACCESSOR =
		new Accessor<Grupo, Long>() {

			@Override
			public Long get(Grupo grupo) {
				return grupo.getEntityId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Grupo> getTypeClass() {
				return Grupo.class;
			}

		};

}