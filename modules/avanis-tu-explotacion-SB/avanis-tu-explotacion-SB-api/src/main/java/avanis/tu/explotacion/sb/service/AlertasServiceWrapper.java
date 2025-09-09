/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.tu.explotacion.sb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AlertasService}.
 *
 * @author Brian Wing Shun Chan
 * @see AlertasService
 * @generated
 */
public class AlertasServiceWrapper
	implements AlertasService, ServiceWrapper<AlertasService> {

	public AlertasServiceWrapper() {
		this(null);
	}

	public AlertasServiceWrapper(AlertasService alertasService) {
		_alertasService = alertasService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _alertasService.getOSGiServiceIdentifier();
	}

	@Override
	public AlertasService getWrappedService() {
		return _alertasService;
	}

	@Override
	public void setWrappedService(AlertasService alertasService) {
		_alertasService = alertasService;
	}

	private AlertasService _alertasService;

}