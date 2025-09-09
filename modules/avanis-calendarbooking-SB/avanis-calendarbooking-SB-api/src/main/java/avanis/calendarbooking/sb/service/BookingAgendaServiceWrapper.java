/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BookingAgendaService}.
 *
 * @author Brian Wing Shun Chan
 * @see BookingAgendaService
 * @generated
 */
public class BookingAgendaServiceWrapper
	implements BookingAgendaService, ServiceWrapper<BookingAgendaService> {

	public BookingAgendaServiceWrapper() {
		this(null);
	}

	public BookingAgendaServiceWrapper(
		BookingAgendaService bookingAgendaService) {

		_bookingAgendaService = bookingAgendaService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bookingAgendaService.getOSGiServiceIdentifier();
	}

	@Override
	public BookingAgendaService getWrappedService() {
		return _bookingAgendaService;
	}

	@Override
	public void setWrappedService(BookingAgendaService bookingAgendaService) {
		_bookingAgendaService = bookingAgendaService;
	}

	private BookingAgendaService _bookingAgendaService;

}