/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AreaService}.
 *
 * @author Brian Wing Shun Chan
 * @see AreaService
 * @generated
 */
public class AreaServiceWrapper
	implements AreaService, ServiceWrapper<AreaService> {

	public AreaServiceWrapper() {
		this(null);
	}

	public AreaServiceWrapper(AreaService areaService) {
		_areaService = areaService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _areaService.getOSGiServiceIdentifier();
	}

	@Override
	public AreaService getWrappedService() {
		return _areaService;
	}

	@Override
	public void setWrappedService(AreaService areaService) {
		_areaService = areaService;
	}

	private AreaService _areaService;

}