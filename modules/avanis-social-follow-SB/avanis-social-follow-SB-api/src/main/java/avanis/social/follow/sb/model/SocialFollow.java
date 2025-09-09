/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.social.follow.sb.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the SocialFollow service. Represents a row in the &quot;SOCIAL_FOLLOW_SocialFollow&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SocialFollowModel
 * @generated
 */
@ImplementationClassName("avanis.social.follow.sb.model.impl.SocialFollowImpl")
@ProviderType
public interface SocialFollow extends PersistedModel, SocialFollowModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>avanis.social.follow.sb.model.impl.SocialFollowImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SocialFollow, Long> SOCIAL_FOLLOW_ID_ACCESSOR =
		new Accessor<SocialFollow, Long>() {

			@Override
			public Long get(SocialFollow socialFollow) {
				return socialFollow.getSocialFollowId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SocialFollow> getTypeClass() {
				return SocialFollow.class;
			}

		};

}