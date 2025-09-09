/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service.impl;

import avanis.calendarbooking.sb.model.BookingAgenda;
import avanis.calendarbooking.sb.service.base.BookingAgendaLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=avanis.calendario.sb.model.BookingAgenda",
	service = AopService.class
)
public class BookingAgendaLocalServiceImpl
	extends BookingAgendaLocalServiceBaseImpl {

	public BookingAgenda addBookingAgenda(
			long userId, long groupId, long day, long startHour, long endHour,
			String title, String description, long calendarBookingId,
			ServiceContext serviceContext) throws PortalException {

		long bookingAgendaId = counterLocalService.increment();

		BookingAgenda bookingAgenda = bookingAgendaPersistence.create(bookingAgendaId);

		User user = userLocalService.getUserById(userId);

		bookingAgenda.setUuid(serviceContext.getUuid());
		bookingAgenda.setUserId(userId);
		bookingAgenda.setUserName(user.getFullName());
		bookingAgenda.setGroupId(groupId);
		bookingAgenda.setCompanyId(user.getCompanyId());
		bookingAgenda.setCreateDate(serviceContext.getCreateDate(new Date()));
		bookingAgenda.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		bookingAgenda.setDay(day);
		bookingAgenda.setStartHour(startHour);
		bookingAgenda.setEndHour(endHour);
		bookingAgenda.setTitle(title);
		bookingAgenda.setDescription(description);
		bookingAgenda.setCalendarBookingId(calendarBookingId);

		bookingAgendaPersistence.update(bookingAgenda);

		return bookingAgenda;
	}

	public BookingAgenda getBookingAgenda(long bookingAgendaId) throws PortalException {
		return bookingAgendaPersistence.findByPrimaryKey(bookingAgendaId);
	}

	public BookingAgenda updateBookingAgenda(
			long bookingAgendaId, long day, long startHour, long endHour,
			String title, String description, long calendarBookingId,
			ServiceContext serviceContext) throws PortalException {

		BookingAgenda bookingAgenda = bookingAgendaPersistence.findByPrimaryKey(bookingAgendaId);

		bookingAgenda.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		bookingAgenda.setDay(day);
		bookingAgenda.setStartHour(startHour);
		bookingAgenda.setEndHour(endHour);
		bookingAgenda.setTitle(title);
		bookingAgenda.setDescription(description);
		bookingAgenda.setCalendarBookingId(calendarBookingId);

		bookingAgendaPersistence.update(bookingAgenda);

		return bookingAgenda;
	}

	public BookingAgenda deleteBookingAgenda(long bookingAgendaId) throws PortalException {
		BookingAgenda bookingAgenda = bookingAgendaPersistence.remove(bookingAgendaId);
		return bookingAgenda;
	}

	public List<BookingAgenda> getBookingAgendasByCalendarBookingId(long calendarBookingId) {
		return bookingAgendaPersistence.findBycalendarBookingId(calendarBookingId);
	}

	public List<BookingAgenda> getBookingAgendasByUserId(long userId) {
		return bookingAgendaPersistence.findByuserId(userId);
	}


}