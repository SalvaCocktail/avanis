/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.impl;

import avanis.lonjas.model.Lonja;
import avanis.lonjas.service.base.LonjaLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.util.OrderByComparator;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=avanis.lonjas.model.Lonja",
	service = AopService.class
)
public class LonjaLocalServiceImpl extends LonjaLocalServiceBaseImpl {

    public List<Lonja> getLonjaBylonjaId(long lonjaId) {
        return getLonjaBylonjaId(lonjaId, null);
    }

    public List<Lonja> getLonjaBylonjaId(long lonjaId, OrderByComparator orderByComparator){
		return lonjaPersistence.findBylonjaId(lonjaId, -1, -1, orderByComparator);
	}

    public Lonja fetchByLonjaId(long lonjaId) {
        return lonjaPersistence.findBylonjaId(lonjaId).get(0);
    }

}