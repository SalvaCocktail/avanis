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
 * The table class for the &quot;AVANIS_EXPLOTACION_Explotacion&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Explotacion
 * @generated
 */
public class ExplotacionTable extends BaseTable<ExplotacionTable> {

	public static final ExplotacionTable INSTANCE = new ExplotacionTable();

	public final Column<ExplotacionTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ExplotacionTable, Long> explotacionId = createColumn(
		"explotacionId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ExplotacionTable, String> provincia = createColumn(
		"provincia", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ExplotacionTable, Double> longitude = createColumn(
		"longitude", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<ExplotacionTable, Integer> height = createColumn(
		"height", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ExplotacionTable, String> location = createColumn(
		"location", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ExplotacionTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ExplotacionTable, Double> latitude = createColumn(
		"latitude", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<ExplotacionTable, String> meteoredid = createColumn(
		"meteoredid", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ExplotacionTable, Integer> size = createColumn(
		"size_", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ExplotacionTable, String> sizeUnit = createColumn(
		"sizeUnit", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ExplotacionTable, Boolean> isMain = createColumn(
		"isMain", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ExplotacionTable, Boolean> allowNotifications =
		createColumn(
			"allowNotifications", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<ExplotacionTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ExplotacionTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ExplotacionTable, Boolean> readed = createColumn(
		"readed", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ExplotacionTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ExplotacionTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ExplotacionTable, String> externalCodeReference =
		createColumn(
			"externalCodeReference", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private ExplotacionTable() {
		super("AVANIS_EXPLOTACION_Explotacion", ExplotacionTable::new);
	}

}