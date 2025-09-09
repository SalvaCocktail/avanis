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
 * The table class for the &quot;AVANIS_LONJAS_Grupo&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Grupo
 * @generated
 */
public class GrupoTable extends BaseTable<GrupoTable> {

	public static final GrupoTable INSTANCE = new GrupoTable();

	public final Column<GrupoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<GrupoTable, Long> entityId = createColumn(
		"entityId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<GrupoTable, Long> grupoId = createColumn(
		"grupoId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<GrupoTable, String> nombre = createColumn(
		"nombre", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<GrupoTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<GrupoTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private GrupoTable() {
		super("AVANIS_LONJAS_Grupo", GrupoTable::new);
	}

}