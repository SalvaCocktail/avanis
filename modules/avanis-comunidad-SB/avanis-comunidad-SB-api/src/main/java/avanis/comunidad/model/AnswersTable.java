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
 * The table class for the &quot;AVANIS_COMUNIDAD_Answers&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Answers
 * @generated
 */
public class AnswersTable extends BaseTable<AnswersTable> {

	public static final AnswersTable INSTANCE = new AnswersTable();

	public final Column<AnswersTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AnswersTable, Long> answerId = createColumn(
		"answerId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AnswersTable, Long> surveyId = createColumn(
		"surveyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AnswersTable, String> answer = createColumn(
		"answer", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AnswersTable, Integer> counterAnswer = createColumn(
		"counterAnswer", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AnswersTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private AnswersTable() {
		super("AVANIS_COMUNIDAD_Answers", AnswersTable::new);
	}

}