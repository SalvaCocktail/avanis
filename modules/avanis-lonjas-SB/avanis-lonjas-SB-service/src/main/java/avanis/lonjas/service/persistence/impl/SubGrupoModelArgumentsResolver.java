/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.lonjas.service.persistence.impl;

import avanis.lonjas.model.SubGrupoTable;
import avanis.lonjas.model.impl.SubGrupoImpl;
import avanis.lonjas.model.impl.SubGrupoModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from SubGrupo.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=avanis.lonjas.model.impl.SubGrupoImpl",
		"table.name=AVANIS_LONJAS_SubGrupo"
	},
	service = ArgumentsResolver.class
)
public class SubGrupoModelArgumentsResolver implements ArgumentsResolver {

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

		SubGrupoModelImpl subGrupoModelImpl = (SubGrupoModelImpl)baseModel;

		long columnBitmask = subGrupoModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(subGrupoModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |= subGrupoModelImpl.getColumnBitmask(
					columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(SubGrupoPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(subGrupoModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return SubGrupoImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return SubGrupoTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		SubGrupoModelImpl subGrupoModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = subGrupoModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = subGrupoModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

	private static final long _ORDER_BY_COLUMNS_BITMASK;

	static {
		long orderByColumnsBitmask = 0;

		orderByColumnsBitmask |= SubGrupoModelImpl.getColumnBitmask("grupoId");
		orderByColumnsBitmask |= SubGrupoModelImpl.getColumnBitmask(
			"subGrupoId");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}