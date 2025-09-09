/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence.impl;

import avanis.lonjas.model.FechaLonjaTable;
import avanis.lonjas.model.impl.FechaLonjaImpl;
import avanis.lonjas.model.impl.FechaLonjaModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from FechaLonja.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=avanis.lonjas.model.impl.FechaLonjaImpl",
		"table.name=AVANIS_LONJAS_FechaLonja"
	},
	service = ArgumentsResolver.class
)
public class FechaLonjaModelArgumentsResolver implements ArgumentsResolver {

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

		FechaLonjaModelImpl fechaLonjaModelImpl =
			(FechaLonjaModelImpl)baseModel;

		long columnBitmask = fechaLonjaModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(fechaLonjaModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |= fechaLonjaModelImpl.getColumnBitmask(
					columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(FechaLonjaPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(fechaLonjaModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return FechaLonjaImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return FechaLonjaTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		FechaLonjaModelImpl fechaLonjaModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = fechaLonjaModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = fechaLonjaModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

	private static final long _ORDER_BY_COLUMNS_BITMASK;

	static {
		long orderByColumnsBitmask = 0;

		orderByColumnsBitmask |= FechaLonjaModelImpl.getColumnBitmask(
			"lonjaId");
		orderByColumnsBitmask |= FechaLonjaModelImpl.getColumnBitmask("fecha");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}