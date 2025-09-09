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
 * The table class for the &quot;AVANIS_CALENDAR_Sponsor&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Sponsor
 * @generated
 */
public class SponsorTable extends BaseTable<SponsorTable> {

	public static final SponsorTable INSTANCE = new SponsorTable();

	public final Column<SponsorTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SponsorTable, Long> sponsorId = createColumn(
		"sponsorId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SponsorTable, Long> calendarBookingId = createColumn(
		"calendarBookingId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SponsorTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SponsorTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SponsorTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SponsorTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SponsorTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SponsorTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SponsorTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SponsorTable, String> iconUrl = createColumn(
		"iconUrl", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private SponsorTable() {
		super("AVANIS_CALENDAR_Sponsor", SponsorTable::new);
	}

}