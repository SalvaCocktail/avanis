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
 * The table class for the &quot;AVANIS_COMUNIDAD_AnswersUser&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AnswersUser
 * @generated
 */
public class AnswersUserTable extends BaseTable<AnswersUserTable> {

	public static final AnswersUserTable INSTANCE = new AnswersUserTable();

	public final Column<AnswersUserTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AnswersUserTable, Long> answerUserId = createColumn(
		"answerUserId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AnswersUserTable, Long> answerId = createColumn(
		"answerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AnswersUserTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AnswersUserTable, Long> surveyId = createColumn(
		"surveyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AnswersUserTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AnswersUserTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private AnswersUserTable() {
		super("AVANIS_COMUNIDAD_AnswersUser", AnswersUserTable::new);
	}

}