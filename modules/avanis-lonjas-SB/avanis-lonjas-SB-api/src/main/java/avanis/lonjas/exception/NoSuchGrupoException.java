/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package avanis.lonjas.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchGrupoException extends NoSuchModelException {

	public NoSuchGrupoException() {
	}

	public NoSuchGrupoException(String msg) {
		super(msg);
	}

	public NoSuchGrupoException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchGrupoException(Throwable throwable) {
		super(throwable);
	}

}