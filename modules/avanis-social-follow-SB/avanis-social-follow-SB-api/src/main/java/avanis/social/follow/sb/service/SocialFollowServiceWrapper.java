/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.social.follow.sb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SocialFollowService}.
 *
 * @author Brian Wing Shun Chan
 * @see SocialFollowService
 * @generated
 */
public class SocialFollowServiceWrapper
	implements ServiceWrapper<SocialFollowService>, SocialFollowService {

	public SocialFollowServiceWrapper() {
		this(null);
	}

	public SocialFollowServiceWrapper(SocialFollowService socialFollowService) {
		_socialFollowService = socialFollowService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _socialFollowService.getOSGiServiceIdentifier();
	}

	@Override
	public SocialFollowService getWrappedService() {
		return _socialFollowService;
	}

	@Override
	public void setWrappedService(SocialFollowService socialFollowService) {
		_socialFollowService = socialFollowService;
	}

	private SocialFollowService _socialFollowService;

}