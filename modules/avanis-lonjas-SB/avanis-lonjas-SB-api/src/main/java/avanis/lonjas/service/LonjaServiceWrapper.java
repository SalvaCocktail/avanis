/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LonjaService}.
 *
 * @author Brian Wing Shun Chan
 * @see LonjaService
 * @generated
 */
public class LonjaServiceWrapper
	implements LonjaService, ServiceWrapper<LonjaService> {

	public LonjaServiceWrapper() {
		this(null);
	}

	public LonjaServiceWrapper(LonjaService lonjaService) {
		_lonjaService = lonjaService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _lonjaService.getOSGiServiceIdentifier();
	}

	@Override
	public LonjaService getWrappedService() {
		return _lonjaService;
	}

	@Override
	public void setWrappedService(LonjaService lonjaService) {
		_lonjaService = lonjaService;
	}

	private LonjaService _lonjaService;

}