/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.social.follow.sb.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;SOCIAL_FOLLOW_SocialFollow&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see SocialFollow
 * @generated
 */
public class SocialFollowTable extends BaseTable<SocialFollowTable> {

	public static final SocialFollowTable INSTANCE = new SocialFollowTable();

	public final Column<SocialFollowTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SocialFollowTable, Long> socialFollowId = createColumn(
		"socialFollowId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SocialFollowTable, Boolean> accepted = createColumn(
		"accepted", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<SocialFollowTable, Long> followsTo = createColumn(
		"followsTo", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SocialFollowTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SocialFollowTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SocialFollowTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SocialFollowTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SocialFollowTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SocialFollowTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private SocialFollowTable() {
		super("SOCIAL_FOLLOW_SocialFollow", SocialFollowTable::new);
	}

}