/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package avanis.thread.logger.sb.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchThreadLogException extends NoSuchModelException {

	public NoSuchThreadLogException() {
	}

	public NoSuchThreadLogException(String msg) {
		super(msg);
	}

	public NoSuchThreadLogException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchThreadLogException(Throwable throwable) {
		super(throwable);
	}

}