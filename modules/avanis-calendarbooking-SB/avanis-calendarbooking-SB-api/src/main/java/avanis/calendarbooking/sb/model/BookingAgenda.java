/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the BookingAgenda service. Represents a row in the &quot;AVANIS_CALENDAR_BookingAgenda&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see BookingAgendaModel
 * @generated
 */
@ImplementationClassName(
	"avanis.calendarbooking.sb.model.impl.BookingAgendaImpl"
)
@ProviderType
public interface BookingAgenda extends BookingAgendaModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>avanis.calendarbooking.sb.model.impl.BookingAgendaImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<BookingAgenda, Long>
		CALENDAR_BOOKING_AGENDA_ID_ACCESSOR =
			new Accessor<BookingAgenda, Long>() {

				@Override
				public Long get(BookingAgenda bookingAgenda) {
					return bookingAgenda.getCalendarBookingAgendaId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<BookingAgenda> getTypeClass() {
					return BookingAgenda.class;
				}

			};

}