/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductoUserService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductoUserService
 * @generated
 */
public class ProductoUserServiceWrapper
	implements ProductoUserService, ServiceWrapper<ProductoUserService> {

	public ProductoUserServiceWrapper() {
		this(null);
	}

	public ProductoUserServiceWrapper(ProductoUserService productoUserService) {
		_productoUserService = productoUserService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productoUserService.getOSGiServiceIdentifier();
	}

	@Override
	public ProductoUserService getWrappedService() {
		return _productoUserService;
	}

	@Override
	public void setWrappedService(ProductoUserService productoUserService) {
		_productoUserService = productoUserService;
	}

	private ProductoUserService _productoUserService;

}