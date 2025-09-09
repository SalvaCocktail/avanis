/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package avanis.tu.explotacion.sb.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchAlertasException extends NoSuchModelException {

	public NoSuchAlertasException() {
	}

	public NoSuchAlertasException(String msg) {
		super(msg);
	}

	public NoSuchAlertasException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchAlertasException(Throwable throwable) {
		super(throwable);
	}

}