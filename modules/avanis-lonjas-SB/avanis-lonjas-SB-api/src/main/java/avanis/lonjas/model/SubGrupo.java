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
 * The extended model interface for the SubGrupo service. Represents a row in the &quot;AVANIS_LONJAS_SubGrupo&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SubGrupoModel
 * @generated
 */
@ImplementationClassName("avanis.lonjas.model.impl.SubGrupoImpl")
@ProviderType
public interface SubGrupo extends PersistedModel, SubGrupoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>avanis.lonjas.model.impl.SubGrupoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SubGrupo, Long> ENTITY_ID_ACCESSOR =
		new Accessor<SubGrupo, Long>() {

			@Override
			public Long get(SubGrupo subGrupo) {
				return subGrupo.getEntityId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SubGrupo> getTypeClass() {
				return SubGrupo.class;
			}

		};

}