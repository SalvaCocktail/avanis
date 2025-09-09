/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AnswersUserService}.
 *
 * @author Brian Wing Shun Chan
 * @see AnswersUserService
 * @generated
 */
public class AnswersUserServiceWrapper
	implements AnswersUserService, ServiceWrapper<AnswersUserService> {

	public AnswersUserServiceWrapper() {
		this(null);
	}

	public AnswersUserServiceWrapper(AnswersUserService answersUserService) {
		_answersUserService = answersUserService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _answersUserService.getOSGiServiceIdentifier();
	}

	@Override
	public AnswersUserService getWrappedService() {
		return _answersUserService;
	}

	@Override
	public void setWrappedService(AnswersUserService answersUserService) {
		_answersUserService = answersUserService;
	}

	private AnswersUserService _answersUserService;

}