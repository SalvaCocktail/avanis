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
 * The table class for the &quot;AVANIS_LONJAS_ProductoUser&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProductoUser
 * @generated
 */
public class ProductoUserTable extends BaseTable<ProductoUserTable> {

	public static final ProductoUserTable INSTANCE = new ProductoUserTable();

	public final Column<ProductoUserTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductoUserTable, Long> entityId = createColumn(
		"entityId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProductoUserTable, Long> lonjaId = createColumn(
		"lonjaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductoUserTable, Long> productoId = createColumn(
		"productoId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductoUserTable, Long> precioLonjaId = createColumn(
		"precioLonjaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductoUserTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductoUserTable, Long> orden = createColumn(
		"orden", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductoUserTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductoUserTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private ProductoUserTable() {
		super("AVANIS_LONJAS_ProductoUser", ProductoUserTable::new);
	}

}