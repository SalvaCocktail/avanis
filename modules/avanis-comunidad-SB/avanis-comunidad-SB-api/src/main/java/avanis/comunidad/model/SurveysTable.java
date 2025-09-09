/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;AVANIS_COMUNIDAD_Surveys&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Surveys
 * @generated
 */
public class SurveysTable extends BaseTable<SurveysTable> {

	public static final SurveysTable INSTANCE = new SurveysTable();

	public final Column<SurveysTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SurveysTable, Long> surveyId = createColumn(
		"surveyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SurveysTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SurveysTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SurveysTable, Long> assetId = createColumn(
		"assetId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SurveysTable, String> question = createColumn(
		"question", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SurveysTable, Integer> expireHours = createColumn(
		"expireHours", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<SurveysTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SurveysTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SurveysTable, Date> expireDate = createColumn(
		"expireDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SurveysTable, Boolean> notified = createColumn(
		"notified", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private SurveysTable() {
		super("AVANIS_COMUNIDAD_Surveys", SurveysTable::new);
	}

}