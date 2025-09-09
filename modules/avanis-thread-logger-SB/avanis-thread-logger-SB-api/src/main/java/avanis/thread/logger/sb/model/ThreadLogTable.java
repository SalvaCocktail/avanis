/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.thread.logger.sb.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;ThreadLogger_ThreadLog&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ThreadLog
 * @generated
 */
public class ThreadLogTable extends BaseTable<ThreadLogTable> {

	public static final ThreadLogTable INSTANCE = new ThreadLogTable();

	public final Column<ThreadLogTable, Long> threadLogId = createColumn(
		"threadLogId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ThreadLogTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ThreadLogTable, String> threadName = createColumn(
		"threadName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThreadLogTable, String> stackTrace = createColumn(
		"stackTrace", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThreadLogTable, String> threadState = createColumn(
		"threadState", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThreadLogTable, String> lockName = createColumn(
		"lockName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThreadLogTable, String> lockOwnerName = createColumn(
		"lockOwnerName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThreadLogTable, Long> lockOwnerId = createColumn(
		"lockOwnerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ThreadLogTable() {
		super("ThreadLogger_ThreadLog", ThreadLogTable::new);
	}

}