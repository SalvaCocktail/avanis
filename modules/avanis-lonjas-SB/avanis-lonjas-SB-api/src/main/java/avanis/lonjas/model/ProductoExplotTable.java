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
 * The table class for the &quot;AVANIS_LONJAS_ProductoExplot&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProductoExplot
 * @generated
 */
public class ProductoExplotTable extends BaseTable<ProductoExplotTable> {

	public static final ProductoExplotTable INSTANCE =
		new ProductoExplotTable();

	public final Column<ProductoExplotTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProductoExplotTable, Long> entityId = createColumn(
		"entityId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProductoExplotTable, Long> lonjaId = createColumn(
		"lonjaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductoExplotTable, Long> productoId = createColumn(
		"productoId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductoExplotTable, Long> precioLonjaId = createColumn(
		"precioLonjaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductoExplotTable, Long> explotacionId = createColumn(
		"explotacionId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductoExplotTable, Long> orden = createColumn(
		"orden", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProductoExplotTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProductoExplotTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private ProductoExplotTable() {
		super("AVANIS_LONJAS_ProductoExplot", ProductoExplotTable::new);
	}

}