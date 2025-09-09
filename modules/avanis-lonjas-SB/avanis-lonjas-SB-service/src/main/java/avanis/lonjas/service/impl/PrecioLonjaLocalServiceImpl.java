/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.impl;

import avanis.lonjas.model.PrecioLonja;
import avanis.lonjas.service.base.PrecioLonjaLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

	public List<PrecioLonja> getLatestByLonjaIdsAndProductoIds(
	        Set<Long> lonjaIds, Set<Long> productoIds, OrderByComparator<PrecioLonja> orderByComparator) {
	
	        if (lonjaIds == null || lonjaIds.isEmpty() ||
	                productoIds == null || productoIds.isEmpty()) {
	                return new ArrayList<>();
	        }
	
	        DynamicQuery dynamicQuery = dynamicQuery()
	                .add(RestrictionsFactoryUtil.in("lonjaId", lonjaIds))
	                .add(RestrictionsFactoryUtil.in("productoId", productoIds));
	
	        List<PrecioLonja> results = dynamicQuery(dynamicQuery, QueryUtil.ALL_POS, QueryUtil.ALL_POS, orderByComparator);
	
	        Map<String, PrecioLonja> latest = new LinkedHashMap<>();
	
	        for (PrecioLonja precioLonja : results) {
	                String key = precioLonja.getLonjaId() + "_" + precioLonja.getProductoId();
	                latest.putIfAbsent(key, precioLonja);
	        }
	
	        return new ArrayList<>(latest.values());
	}
}