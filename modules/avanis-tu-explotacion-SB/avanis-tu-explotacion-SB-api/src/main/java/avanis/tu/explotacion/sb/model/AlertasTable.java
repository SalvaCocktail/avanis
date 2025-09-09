/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.tu.explotacion.sb.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;AVANIS_EXPLOTACION_Alertas&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Alertas
 * @generated
 */
public class AlertasTable extends BaseTable<AlertasTable> {

	public static final AlertasTable INSTANCE = new AlertasTable();

	public final Column<AlertasTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AlertasTable, Long> alertaId = createColumn(
		"alertaId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AlertasTable, Long> explotacionId = createColumn(
		"explotacionId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AlertasTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AlertasTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AlertasTable, String> endDate = createColumn(
		"endDate", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AlertasTable, String> startDate = createColumn(
		"startDate", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AlertasTable, String> risk = createColumn(
		"risk", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AlertasTable, String> phenomenom = createColumn(
		"phenomenom", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AlertasTable, String> scope = createColumn(
		"scope", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AlertasTable, String> probability = createColumn(
		"probability", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AlertasTable, String> type = createColumn(
		"type_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AlertasTable, Boolean> readed = createColumn(
		"readed", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<AlertasTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AlertasTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AlertasTable, String> externalCodeReference =
		createColumn(
			"externalCodeReference", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private AlertasTable() {
		super("AVANIS_EXPLOTACION_Alertas", AlertasTable::new);
	}

}