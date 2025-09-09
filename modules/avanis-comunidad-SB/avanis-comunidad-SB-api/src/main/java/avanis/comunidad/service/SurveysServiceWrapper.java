/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SurveysService}.
 *
 * @author Brian Wing Shun Chan
 * @see SurveysService
 * @generated
 */
public class SurveysServiceWrapper
	implements ServiceWrapper<SurveysService>, SurveysService {

	public SurveysServiceWrapper() {
		this(null);
	}

	public SurveysServiceWrapper(SurveysService surveysService) {
		_surveysService = surveysService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _surveysService.getOSGiServiceIdentifier();
	}

	@Override
	public SurveysService getWrappedService() {
		return _surveysService;
	}

	@Override
	public void setWrappedService(SurveysService surveysService) {
		_surveysService = surveysService;
	}

	private SurveysService _surveysService;

}