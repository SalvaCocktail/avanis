/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.thread.logger.sb.service.impl;

import avanis.thread.logger.sb.model.ThreadLog;
import avanis.thread.logger.sb.service.base.ThreadLogLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=avanis.thread.logger.sb.model.ThreadLog",
	service = AopService.class
)
public class ThreadLogLocalServiceImpl extends ThreadLogLocalServiceBaseImpl {

	public List<ThreadLog> findByCreateDate(Date fecha){
		return threadLogPersistence.findByCreateDate(fecha);
	}

	public void deleteAll(){
		threadLogPersistence.removeAll();
	}

}