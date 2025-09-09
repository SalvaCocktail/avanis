/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.impl;

import avanis.lonjas.exception.NoSuchProductoUserException;
import avanis.lonjas.model.ProductoExplot;
import avanis.lonjas.model.ProductoUser;
import avanis.lonjas.service.base.ProductoUserLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
		property = "model.class.name=avanis.lonjas.model.ProductoUser",
		service = AopService.class
)
public class ProductoUserLocalServiceImpl
		extends ProductoUserLocalServiceBaseImpl {

	private static final Log _log = LogFactoryUtil.getLog(ProductoUserLocalServiceImpl.class);

	public List<ProductoUser> getProductoUserByUserId(long userId){
		return productoUserPersistence.findByuserId(userId);
	}

	public ProductoUser getProductoUserByUserIdAndProductoId(long userId, long lonjaId, long productoId){
		return productoUserPersistence.fetchByuserIdlonjaIdproductoId(userId, lonjaId, productoId);
	}

}