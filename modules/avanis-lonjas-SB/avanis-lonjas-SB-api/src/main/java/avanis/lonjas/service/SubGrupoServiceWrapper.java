/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SubGrupoService}.
 *
 * @author Brian Wing Shun Chan
 * @see SubGrupoService
 * @generated
 */
public class SubGrupoServiceWrapper
	implements ServiceWrapper<SubGrupoService>, SubGrupoService {

	public SubGrupoServiceWrapper() {
		this(null);
	}

	public SubGrupoServiceWrapper(SubGrupoService subGrupoService) {
		_subGrupoService = subGrupoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _subGrupoService.getOSGiServiceIdentifier();
	}

	@Override
	public SubGrupoService getWrappedService() {
		return _subGrupoService;
	}

	@Override
	public void setWrappedService(SubGrupoService subGrupoService) {
		_subGrupoService = subGrupoService;
	}

	private SubGrupoService _subGrupoService;

}