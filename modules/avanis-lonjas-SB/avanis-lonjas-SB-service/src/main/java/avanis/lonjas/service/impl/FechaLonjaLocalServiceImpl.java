/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.impl;

import avanis.lonjas.model.FechaLonja;
import avanis.lonjas.model.Lonja;
import avanis.lonjas.service.base.FechaLonjaLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=avanis.lonjas.model.FechaLonja",
	service = AopService.class
)
public class FechaLonjaLocalServiceImpl extends FechaLonjaLocalServiceBaseImpl {

	public List<FechaLonja> getFechaLonjaByLonjaId(long lonjaId){
		return fechaLonjaPersistence.findBylonjaId(lonjaId);
	}
}