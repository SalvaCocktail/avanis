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
 * The table class for the &quot;AVANIS_LONJAS_PrecioLonja&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see PrecioLonja
 * @generated
 */
public class PrecioLonjaTable extends BaseTable<PrecioLonjaTable> {

	public static final PrecioLonjaTable INSTANCE = new PrecioLonjaTable();

	public final Column<PrecioLonjaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PrecioLonjaTable, Long> entityId = createColumn(
		"entityId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PrecioLonjaTable, Long> productoId = createColumn(
		"productoId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PrecioLonjaTable, Long> lonjaId = createColumn(
		"lonjaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PrecioLonjaTable, Long> grupoId = createColumn(
		"grupoId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PrecioLonjaTable, Long> subGrupoId = createColumn(
		"subGrupoId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PrecioLonjaTable, Long> areaId = createColumn(
		"areaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PrecioLonjaTable, Date> fecha = createColumn(
		"fecha", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PrecioLonjaTable, String> nombreProducto = createColumn(
		"nombreProducto", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PrecioLonjaTable, String> precioAnterior = createColumn(
		"precioAnterior", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PrecioLonjaTable, String> precioUltimo = createColumn(
		"precioUltimo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PrecioLonjaTable, String> precioMaximo = createColumn(
		"precioMaximo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PrecioLonjaTable, String> precioMedio = createColumn(
		"precioMedio", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PrecioLonjaTable, String> precioMinimo = createColumn(
		"precioMinimo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PrecioLonjaTable, String> precioOrigen = createColumn(
		"precioOrigen", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PrecioLonjaTable, String> anteriorEuros = createColumn(
		"anteriorEuros", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PrecioLonjaTable, String> ultimoEuros = createColumn(
		"ultimoEuros", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PrecioLonjaTable, String> unidadMedida = createColumn(
		"unidadMedida", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PrecioLonjaTable, String> unidadLarga = createColumn(
		"unidadLarga", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PrecioLonjaTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PrecioLonjaTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private PrecioLonjaTable() {
		super("AVANIS_LONJAS_PrecioLonja", PrecioLonjaTable::new);
	}

}