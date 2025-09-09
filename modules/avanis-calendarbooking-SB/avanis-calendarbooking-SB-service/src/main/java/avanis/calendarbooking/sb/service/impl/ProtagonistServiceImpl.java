/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service.impl;

import avanis.calendarbooking.sb.service.base.ProtagonistServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=avanis_calendar",
		"json.web.service.context.path=Protagonist"
	},
	service = AopService.class
)
public class ProtagonistServiceImpl extends ProtagonistServiceBaseImpl {
}