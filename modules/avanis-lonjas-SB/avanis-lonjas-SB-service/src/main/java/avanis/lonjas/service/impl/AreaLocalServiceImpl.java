/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.impl;

import avanis.lonjas.model.Area;
import avanis.lonjas.service.base.AreaLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=avanis.lonjas.model.Area",
	service = AopService.class
)
public class AreaLocalServiceImpl extends AreaLocalServiceBaseImpl {

	public Area findByAreaId(long areaId){
		try {
			return areaPersistence.findByareaId(areaId);
		}catch (Exception e){
			return null;
		}
	}

}