/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FechaLonjaService}.
 *
 * @author Brian Wing Shun Chan
 * @see FechaLonjaService
 * @generated
 */
public class FechaLonjaServiceWrapper
	implements FechaLonjaService, ServiceWrapper<FechaLonjaService> {

	public FechaLonjaServiceWrapper() {
		this(null);
	}

	public FechaLonjaServiceWrapper(FechaLonjaService fechaLonjaService) {
		_fechaLonjaService = fechaLonjaService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fechaLonjaService.getOSGiServiceIdentifier();
	}

	@Override
	public FechaLonjaService getWrappedService() {
		return _fechaLonjaService;
	}

	@Override
	public void setWrappedService(FechaLonjaService fechaLonjaService) {
		_fechaLonjaService = fechaLonjaService;
	}

	private FechaLonjaService _fechaLonjaService;

}