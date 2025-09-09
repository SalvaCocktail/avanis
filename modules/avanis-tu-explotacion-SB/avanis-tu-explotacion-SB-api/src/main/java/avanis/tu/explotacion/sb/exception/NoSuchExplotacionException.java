/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package avanis.tu.explotacion.sb.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchExplotacionException extends NoSuchModelException {

	public NoSuchExplotacionException() {
	}

	public NoSuchExplotacionException(String msg) {
		super(msg);
	}

	public NoSuchExplotacionException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchExplotacionException(Throwable throwable) {
		super(throwable);
	}

}