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
 * The extended model interface for the AnswersUser service. Represents a row in the &quot;AVANIS_COMUNIDAD_AnswersUser&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AnswersUserModel
 * @generated
 */
@ImplementationClassName("avanis.comunidad.model.impl.AnswersUserImpl")
@ProviderType
public interface AnswersUser extends AnswersUserModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>avanis.comunidad.model.impl.AnswersUserImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AnswersUser, Long> ANSWER_USER_ID_ACCESSOR =
		new Accessor<AnswersUser, Long>() {

			@Override
			public Long get(AnswersUser answersUser) {
				return answersUser.getAnswerUserId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AnswersUser> getTypeClass() {
				return AnswersUser.class;
			}

		};

}