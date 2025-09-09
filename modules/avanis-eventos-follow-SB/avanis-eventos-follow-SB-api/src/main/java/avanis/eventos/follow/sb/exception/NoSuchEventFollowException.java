/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package avanis.eventos.follow.sb.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchEventFollowException extends NoSuchModelException {

	public NoSuchEventFollowException() {
	}

	public NoSuchEventFollowException(String msg) {
		super(msg);
	}

	public NoSuchEventFollowException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchEventFollowException(Throwable throwable) {
		super(throwable);
	}

}