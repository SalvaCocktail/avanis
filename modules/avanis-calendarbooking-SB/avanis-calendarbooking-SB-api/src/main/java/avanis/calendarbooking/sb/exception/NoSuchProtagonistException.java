/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package avanis.calendarbooking.sb.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchProtagonistException extends NoSuchModelException {

	public NoSuchProtagonistException() {
	}

	public NoSuchProtagonistException(String msg) {
		super(msg);
	}

	public NoSuchProtagonistException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchProtagonistException(Throwable throwable) {
		super(throwable);
	}

}