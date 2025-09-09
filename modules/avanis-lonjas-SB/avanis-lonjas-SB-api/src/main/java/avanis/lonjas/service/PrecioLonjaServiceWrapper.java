/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PrecioLonjaService}.
 *
 * @author Brian Wing Shun Chan
 * @see PrecioLonjaService
 * @generated
 */
public class PrecioLonjaServiceWrapper
	implements PrecioLonjaService, ServiceWrapper<PrecioLonjaService> {

	public PrecioLonjaServiceWrapper() {
		this(null);
	}

	public PrecioLonjaServiceWrapper(PrecioLonjaService precioLonjaService) {
		_precioLonjaService = precioLonjaService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _precioLonjaService.getOSGiServiceIdentifier();
	}

	@Override
	public PrecioLonjaService getWrappedService() {
		return _precioLonjaService;
	}

	@Override
	public void setWrappedService(PrecioLonjaService precioLonjaService) {
		_precioLonjaService = precioLonjaService;
	}

	private PrecioLonjaService _precioLonjaService;

}