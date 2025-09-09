/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProtagonistService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProtagonistService
 * @generated
 */
public class ProtagonistServiceWrapper
	implements ProtagonistService, ServiceWrapper<ProtagonistService> {

	public ProtagonistServiceWrapper() {
		this(null);
	}

	public ProtagonistServiceWrapper(ProtagonistService protagonistService) {
		_protagonistService = protagonistService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _protagonistService.getOSGiServiceIdentifier();
	}

	@Override
	public ProtagonistService getWrappedService() {
		return _protagonistService;
	}

	@Override
	public void setWrappedService(ProtagonistService protagonistService) {
		_protagonistService = protagonistService;
	}

	private ProtagonistService _protagonistService;

}