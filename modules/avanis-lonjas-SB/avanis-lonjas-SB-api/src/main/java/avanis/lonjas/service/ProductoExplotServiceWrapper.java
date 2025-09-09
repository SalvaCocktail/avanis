/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductoExplotService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductoExplotService
 * @generated
 */
public class ProductoExplotServiceWrapper
	implements ProductoExplotService, ServiceWrapper<ProductoExplotService> {

	public ProductoExplotServiceWrapper() {
		this(null);
	}

	public ProductoExplotServiceWrapper(
		ProductoExplotService productoExplotService) {

		_productoExplotService = productoExplotService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productoExplotService.getOSGiServiceIdentifier();
	}

	@Override
	public ProductoExplotService getWrappedService() {
		return _productoExplotService;
	}

	@Override
	public void setWrappedService(ProductoExplotService productoExplotService) {
		_productoExplotService = productoExplotService;
	}

	private ProductoExplotService _productoExplotService;

}