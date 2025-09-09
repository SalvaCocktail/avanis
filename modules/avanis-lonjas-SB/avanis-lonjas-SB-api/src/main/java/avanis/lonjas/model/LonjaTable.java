/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;AVANIS_LONJAS_Lonja&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Lonja
 * @generated
 */
public class LonjaTable extends BaseTable<LonjaTable> {

	public static final LonjaTable INSTANCE = new LonjaTable();

	public final Column<LonjaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LonjaTable, Long> entityId = createColumn(
		"entityId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LonjaTable, Long> lonjaId = createColumn(
		"lonjaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LonjaTable, String> nombre = createColumn(
		"nombre", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LonjaTable, String> pais = createColumn(
		"pais", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LonjaTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LonjaTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private LonjaTable() {
		super("AVANIS_LONJAS_Lonja", LonjaTable::new);
	}

}