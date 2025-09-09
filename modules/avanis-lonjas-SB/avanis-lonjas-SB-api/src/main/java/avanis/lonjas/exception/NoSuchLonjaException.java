/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package avanis.lonjas.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchLonjaException extends NoSuchModelException {

	public NoSuchLonjaException() {
	}

	public NoSuchLonjaException(String msg) {
		super(msg);
	}

	public NoSuchLonjaException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchLonjaException(Throwable throwable) {
		super(throwable);
	}

}