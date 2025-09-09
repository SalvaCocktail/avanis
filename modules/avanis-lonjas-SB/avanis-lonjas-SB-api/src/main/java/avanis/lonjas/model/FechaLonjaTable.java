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
 * The table class for the &quot;AVANIS_LONJAS_FechaLonja&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FechaLonja
 * @generated
 */
public class FechaLonjaTable extends BaseTable<FechaLonjaTable> {

	public static final FechaLonjaTable INSTANCE = new FechaLonjaTable();

	public final Column<FechaLonjaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FechaLonjaTable, Long> entityId = createColumn(
		"entityId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FechaLonjaTable, Long> lonjaId = createColumn(
		"lonjaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FechaLonjaTable, Date> fecha = createColumn(
		"fecha", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FechaLonjaTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FechaLonjaTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private FechaLonjaTable() {
		super("AVANIS_LONJAS_FechaLonja", FechaLonjaTable::new);
	}

}