/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package avanis.lonjas.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchPrecioLonjaException extends NoSuchModelException {

	public NoSuchPrecioLonjaException() {
	}

	public NoSuchPrecioLonjaException(String msg) {
		super(msg);
	}

	public NoSuchPrecioLonjaException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchPrecioLonjaException(Throwable throwable) {
		super(throwable);
	}

}