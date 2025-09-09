/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SponsorService}.
 *
 * @author Brian Wing Shun Chan
 * @see SponsorService
 * @generated
 */
public class SponsorServiceWrapper
	implements ServiceWrapper<SponsorService>, SponsorService {

	public SponsorServiceWrapper() {
		this(null);
	}

	public SponsorServiceWrapper(SponsorService sponsorService) {
		_sponsorService = sponsorService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _sponsorService.getOSGiServiceIdentifier();
	}

	@Override
	public SponsorService getWrappedService() {
		return _sponsorService;
	}

	@Override
	public void setWrappedService(SponsorService sponsorService) {
		_sponsorService = sponsorService;
	}

	private SponsorService _sponsorService;

}