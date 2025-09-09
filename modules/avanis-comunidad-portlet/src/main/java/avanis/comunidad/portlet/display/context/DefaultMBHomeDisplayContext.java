/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.comunidad.portlet.display.context;

import avanis.comunidad.portlet.display.context.helper.MBRequestHelper;
import com.liferay.message.boards.display.context.MBHomeDisplayContext;
import com.liferay.message.boards.model.MBCategory;
import com.liferay.portal.kernel.language.LanguageUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author Iván Zaera
 */
public class DefaultMBHomeDisplayContext implements MBHomeDisplayContext {

	public DefaultMBHomeDisplayContext(
		HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) {

		_mbRequestHelper = new MBRequestHelper(httpServletRequest);
	}

	@Override
	public String getTitle() {
		MBCategory category = _mbRequestHelper.getCategory();

		if (category == null) {
			return "add-category";
		}

		return LanguageUtil.format(
			_mbRequestHelper.getRequest(), "edit-x", category.getName(), false);
	}

	@Override
	public UUID getUuid() {
		return _UUID;
	}

	private static final UUID _UUID = UUID.fromString(
		"478C53D5-EB19-4387-A95F-4475746D3E17");

	private final MBRequestHelper _mbRequestHelper;

}
