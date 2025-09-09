/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.tu.explotacion.sb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ExplotacionService}.
 *
 * @author Brian Wing Shun Chan
 * @see ExplotacionService
 * @generated
 */
public class ExplotacionServiceWrapper
	implements ExplotacionService, ServiceWrapper<ExplotacionService> {

	public ExplotacionServiceWrapper() {
		this(null);
	}

	public ExplotacionServiceWrapper(ExplotacionService explotacionService) {
		_explotacionService = explotacionService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _explotacionService.getOSGiServiceIdentifier();
	}

	@Override
	public ExplotacionService getWrappedService() {
		return _explotacionService;
	}

	@Override
	public void setWrappedService(ExplotacionService explotacionService) {
		_explotacionService = explotacionService;
	}

	private ExplotacionService _explotacionService;

}