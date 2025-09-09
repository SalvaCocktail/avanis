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
 * The extended model interface for the Answers service. Represents a row in the &quot;AVANIS_COMUNIDAD_Answers&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AnswersModel
 * @generated
 */
@ImplementationClassName("avanis.comunidad.model.impl.AnswersImpl")
@ProviderType
public interface Answers extends AnswersModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>avanis.comunidad.model.impl.AnswersImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Answers, Long> ANSWER_ID_ACCESSOR =
		new Accessor<Answers, Long>() {

			@Override
			public Long get(Answers answers) {
				return answers.getAnswerId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Answers> getTypeClass() {
				return Answers.class;
			}

		};

}