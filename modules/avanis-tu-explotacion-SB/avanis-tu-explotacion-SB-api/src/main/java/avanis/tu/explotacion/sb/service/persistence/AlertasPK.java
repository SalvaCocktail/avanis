/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.tu.explotacion.sb.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AlertasPK implements Comparable<AlertasPK>, Serializable {

	public long alertaId;
	public long explotacionId;

	public AlertasPK() {
	}

	public AlertasPK(long alertaId, long explotacionId) {
		this.alertaId = alertaId;
		this.explotacionId = explotacionId;
	}

	public long getAlertaId() {
		return alertaId;
	}

	public void setAlertaId(long alertaId) {
		this.alertaId = alertaId;
	}

	public long getExplotacionId() {
		return explotacionId;
	}

	public void setExplotacionId(long explotacionId) {
		this.explotacionId = explotacionId;
	}

	@Override
	public int compareTo(AlertasPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (alertaId < pk.alertaId) {
			value = -1;
		}
		else if (alertaId > pk.alertaId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (explotacionId < pk.explotacionId) {
			value = -1;
		}
		else if (explotacionId > pk.explotacionId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AlertasPK)) {
			return false;
		}

		AlertasPK pk = (AlertasPK)object;

		if ((alertaId == pk.alertaId) && (explotacionId == pk.explotacionId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, alertaId);
		hashCode = HashUtil.hash(hashCode, explotacionId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("alertaId=");

		sb.append(alertaId);
		sb.append(", explotacionId=");

		sb.append(explotacionId);

		sb.append("}");

		return sb.toString();
	}

}