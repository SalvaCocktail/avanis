/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.tu.explotacion.sb.service.impl;

import avanis.tu.explotacion.sb.model.Alertas;
import avanis.tu.explotacion.sb.model.Explotacion;
import avanis.tu.explotacion.sb.service.AlertasLocalServiceUtil;
import avanis.tu.explotacion.sb.service.base.AlertasLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import org.osgi.service.component.annotations.Component;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=avanis.tu.explotacion.sb.model.Alertas",
	service = AopService.class
)
public class AlertasLocalServiceImpl extends AlertasLocalServiceBaseImpl {

	private static Log _log = LogFactoryUtil.getLog(ExplotacionLocalServiceImpl.class);

	@Override
	public List<Alertas> findByUserId(long userId) {
		if (alertasPersistence == null) {
			_log.error("alertasPersistence is null");
			return Collections.emptyList(); // O lanzar una excepción si es crítico
		}
		_log.debug("Finding alertas for userId: " + userId);
		return alertasPersistence.findByuserId(userId);
	}

	public Alertas addAlertas() {
		long alertaId = counterLocalService.increment(Alertas.class.getName());
		Alertas alerta = super.createAlertas(alertaId);
		//seteo todos los parametros
		_log.debug(alerta);
		return super.updateAlertas(alerta);
	}

	@Override
	public Alertas createAlerta(String externalReferenceCode, String desciption, boolean readed, long explotacionId,
								String phenomenom, long userId, String end, String start, String risk, String scope,
								String probability) {
		long alertaId = counterLocalService.increment(Alertas.class.getName());
		Alertas alerta = super.createAlertas(alertaId);

		alerta.setExternalCodeReference(externalReferenceCode);
		alerta.setDescription(desciption);
		alerta.setReaded(readed);
		alerta.setExplotacionId(explotacionId);
		alerta.setPhenomenom(phenomenom);
		alerta.setUserId(userId);
		alerta.setEndDate(end);
		alerta.setStartDate(start);
		alerta.setRisk(risk);
		alerta.setScope(scope);
		alerta.setProbability(probability);
		alerta.setModifiedDate(new Date());
		updateAlertas(alerta);

		return alerta;
	}

	@Override
	public Alertas deleteAlerta(String externalReferenceCode, String description, boolean readed, long explotacionId,
								String phenomenom, long userId, String end, String start, String risk, String scope,
								String probability) throws PortalException {
		List<Alertas> userAlerts = AlertasLocalServiceUtil.findByUserId(userId);

		Alertas lastDeletedAlert = null;

		for (Alertas alerta : userAlerts) {
			if (alerta.getDescription().equals(description) &&
					alerta.getReaded() == readed &&
					alerta.getExplotacionId() == explotacionId &&
					alerta.getPhenomenom().equals(phenomenom) &&
					alerta.getEndDate().equals(end) &&
					alerta.getStartDate().equals(start) &&
					alerta.getRisk().equals(risk) &&
					alerta.getScope().equals(scope) &&
					alerta.getProbability().equals(probability)) {

				// Eliminar la alerta
				lastDeletedAlert = super.deleteAlertas(alerta.getAlertaId());
			}
		}

		return lastDeletedAlert;
	}

}