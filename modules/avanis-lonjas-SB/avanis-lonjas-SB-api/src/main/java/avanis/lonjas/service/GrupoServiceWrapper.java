/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GrupoService}.
 *
 * @author Brian Wing Shun Chan
 * @see GrupoService
 * @generated
 */
public class GrupoServiceWrapper
	implements GrupoService, ServiceWrapper<GrupoService> {

	public GrupoServiceWrapper() {
		this(null);
	}

	public GrupoServiceWrapper(GrupoService grupoService) {
		_grupoService = grupoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _grupoService.getOSGiServiceIdentifier();
	}

	@Override
	public GrupoService getWrappedService() {
		return _grupoService;
	}

	@Override
	public void setWrappedService(GrupoService grupoService) {
		_grupoService = grupoService;
	}

	private GrupoService _grupoService;

}