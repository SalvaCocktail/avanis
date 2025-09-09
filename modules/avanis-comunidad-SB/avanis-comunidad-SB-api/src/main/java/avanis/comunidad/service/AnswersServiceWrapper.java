/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AnswersService}.
 *
 * @author Brian Wing Shun Chan
 * @see AnswersService
 * @generated
 */
public class AnswersServiceWrapper
	implements AnswersService, ServiceWrapper<AnswersService> {

	public AnswersServiceWrapper() {
		this(null);
	}

	public AnswersServiceWrapper(AnswersService answersService) {
		_answersService = answersService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _answersService.getOSGiServiceIdentifier();
	}

	@Override
	public AnswersService getWrappedService() {
		return _answersService;
	}

	@Override
	public void setWrappedService(AnswersService answersService) {
		_answersService = answersService;
	}

	private AnswersService _answersService;

}