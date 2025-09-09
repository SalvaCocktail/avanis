/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package avanis.comunidad.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchAnswersException extends NoSuchModelException {

	public NoSuchAnswersException() {
	}

	public NoSuchAnswersException(String msg) {
		super(msg);
	}

	public NoSuchAnswersException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchAnswersException(Throwable throwable) {
		super(throwable);
	}

}