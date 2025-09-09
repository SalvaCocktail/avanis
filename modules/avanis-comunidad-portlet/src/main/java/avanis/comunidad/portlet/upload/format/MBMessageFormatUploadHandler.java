/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.portlet.upload.format;

import avanis.comunidad.portlet.util.MBAttachmentFileEntryReference;

import java.util.List;

/**
 * @author Alejandro Tardín
 */
public interface MBMessageFormatUploadHandler {

	public String replaceImageReferences(
		String body,
		List<MBAttachmentFileEntryReference> mbAttachmentFileEntryReferences);

}
