/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package avanis.lonjas.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchFechaLonjaException extends NoSuchModelException {

	public NoSuchFechaLonjaException() {
	}

	public NoSuchFechaLonjaException(String msg) {
		super(msg);
	}

	public NoSuchFechaLonjaException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchFechaLonjaException(Throwable throwable) {
		super(throwable);
	}

}