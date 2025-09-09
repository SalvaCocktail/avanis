/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.impl;

import avanis.lonjas.model.SubGrupo;
import avanis.lonjas.service.base.SubGrupoLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=avanis.lonjas.model.SubGrupo",
	service = AopService.class
)
public class SubGrupoLocalServiceImpl extends SubGrupoLocalServiceBaseImpl {

	public SubGrupo findBySubGroupId(long subGroupId){
		try {
			return subGrupoPersistence.findBysubGrupoId(subGroupId);
		}catch (Exception e){
			return null;
		}
	}
}