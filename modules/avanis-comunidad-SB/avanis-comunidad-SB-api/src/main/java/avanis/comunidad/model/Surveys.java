/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Surveys service. Represents a row in the &quot;AVANIS_COMUNIDAD_Surveys&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SurveysModel
 * @generated
 */
@ImplementationClassName("avanis.comunidad.model.impl.SurveysImpl")
@ProviderType
public interface Surveys extends PersistedModel, SurveysModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>avanis.comunidad.model.impl.SurveysImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Surveys, Long> SURVEY_ID_ACCESSOR =
		new Accessor<Surveys, Long>() {

			@Override
			public Long get(Surveys surveys) {
				return surveys.getSurveyId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Surveys> getTypeClass() {
				return Surveys.class;
			}

		};

}