/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.eventos.follow.sb.service.persistence.impl;

import avanis.eventos.follow.sb.model.EventFollowTable;
import avanis.eventos.follow.sb.model.impl.EventFollowImpl;
import avanis.eventos.follow.sb.model.impl.EventFollowModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from EventFollow.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=avanis.eventos.follow.sb.model.impl.EventFollowImpl",
		"table.name=EVENT_FOLLOW_EventFollow"
	},
	service = ArgumentsResolver.class
)
public class EventFollowModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		EventFollowModelImpl eventFollowModelImpl =
			(EventFollowModelImpl)baseModel;

		long columnBitmask = eventFollowModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(eventFollowModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					eventFollowModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(eventFollowModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return EventFollowImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return EventFollowTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		EventFollowModelImpl eventFollowModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = eventFollowModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = eventFollowModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}