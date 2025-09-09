/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;AVANIS_CALENDAR_BookingAgenda&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see BookingAgenda
 * @generated
 */
public class BookingAgendaTable extends BaseTable<BookingAgendaTable> {

	public static final BookingAgendaTable INSTANCE = new BookingAgendaTable();

	public final Column<BookingAgendaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BookingAgendaTable, Long> calendarBookingAgendaId =
		createColumn(
			"calendarBookingAgendaId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<BookingAgendaTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BookingAgendaTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BookingAgendaTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BookingAgendaTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BookingAgendaTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BookingAgendaTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BookingAgendaTable, Long> day = createColumn(
		"day", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BookingAgendaTable, Long> startHour = createColumn(
		"startHour", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BookingAgendaTable, Long> endHour = createColumn(
		"endHour", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BookingAgendaTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BookingAgendaTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BookingAgendaTable, Long> calendarBookingId =
		createColumn(
			"calendarBookingId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private BookingAgendaTable() {
		super("AVANIS_CALENDAR_BookingAgenda", BookingAgendaTable::new);
	}

}