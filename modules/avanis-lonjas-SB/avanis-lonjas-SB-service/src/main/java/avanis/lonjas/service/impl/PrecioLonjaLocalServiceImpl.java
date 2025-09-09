/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.impl;

import avanis.lonjas.model.PrecioLonja;
import avanis.lonjas.service.base.PrecioLonjaLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.util.OrderByComparator;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=avanis.lonjas.model.PrecioLonja",
	service = AopService.class
)
public class PrecioLonjaLocalServiceImpl
	extends PrecioLonjaLocalServiceBaseImpl {

	public List<PrecioLonja> getPrecioLonjaByLonjaId(long lonjaId){
		return precioLonjaPersistence.findBylonjaId(lonjaId);
	}

	public List<PrecioLonja> getPrecioLonjaByLonjaIdByFecha(long lonjaId, Date fecha){
		return precioLonjaPersistence.findBylonjaIdFecha(lonjaId, fecha);
	}

	public List<PrecioLonja> getPrecioLonjaByLonjaIdByProductoId(long lonjaId, long productoId, OrderByComparator<PrecioLonja> orderByComparator){
		return precioLonjaPersistence.findBylonjaIdProductoId(lonjaId, productoId, -1, -1, orderByComparator);
	}
}