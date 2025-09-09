/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package avanis.calendarbooking.sb.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchSponsorException extends NoSuchModelException {

	public NoSuchSponsorException() {
	}

	public NoSuchSponsorException(String msg) {
		super(msg);
	}

	public NoSuchSponsorException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchSponsorException(Throwable throwable) {
		super(throwable);
	}

}