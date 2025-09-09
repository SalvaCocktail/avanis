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
 * The table class for the &quot;AVANIS_LONJAS_Area&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Area
 * @generated
 */
public class AreaTable extends BaseTable<AreaTable> {

	public static final AreaTable INSTANCE = new AreaTable();

	public final Column<AreaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AreaTable, Long> entityId = createColumn(
		"entityId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AreaTable, Long> areaId = createColumn(
		"areaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AreaTable, Long> subGrupoId = createColumn(
		"subGrupoId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AreaTable, Long> grupoId = createColumn(
		"grupoId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AreaTable, String> nombre = createColumn(
		"nombre", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AreaTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AreaTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private AreaTable() {
		super("AVANIS_LONJAS_Area", AreaTable::new);
	}

}