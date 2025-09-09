/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.eventos.follow.sb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EventFollowService}.
 *
 * @author Brian Wing Shun Chan
 * @see EventFollowService
 * @generated
 */
public class EventFollowServiceWrapper
	implements EventFollowService, ServiceWrapper<EventFollowService> {

	public EventFollowServiceWrapper() {
		this(null);
	}

	public EventFollowServiceWrapper(EventFollowService eventFollowService) {
		_eventFollowService = eventFollowService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eventFollowService.getOSGiServiceIdentifier();
	}

	@Override
	public EventFollowService getWrappedService() {
		return _eventFollowService;
	}

	@Override
	public void setWrappedService(EventFollowService eventFollowService) {
		_eventFollowService = eventFollowService;
	}

	private EventFollowService _eventFollowService;

}