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
 * The table class for the &quot;AVANIS_CALENDAR_Protagonist&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Protagonist
 * @generated
 */
public class ProtagonistTable extends BaseTable<ProtagonistTable> {

	public static final ProtagonistTable INSTANCE = new ProtagonistTable();

	public final Column<ProtagonistTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProtagonistTable, Long> protagonistId = createColumn(
		"protagonistId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProtagonistTable, Long> calendarBookingId =
		createColumn(
			"calendarBookingId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProtagonistTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProtagonistTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProtagonistTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProtagonistTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProtagonistTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProtagonistTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProtagonistTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProtagonistTable, String> lastName = createColumn(
		"lastName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProtagonistTable, String> profession = createColumn(
		"profession", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProtagonistTable, String> bio = createColumn(
		"bio", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProtagonistTable, String> portraitUrl = createColumn(
		"portraitUrl", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ProtagonistTable() {
		super("AVANIS_CALENDAR_Protagonist", ProtagonistTable::new);
	}

}