/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.tu.explotacion.sb.service.impl;

import avanis.tu.explotacion.sb.exception.NoSuchExplotacionException;
import avanis.tu.explotacion.sb.model.Explotacion;
import avanis.tu.explotacion.sb.service.base.ExplotacionLocalServiceBaseImpl;

import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import model.MeteoredLocation;
import services.MeteoredService;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Objects;
import java.util.Date;
import java.util.List;


/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=avanis.tu.explotacion.sb.model.Explotacion",
        service = AopService.class
)
public class ExplotacionLocalServiceImpl
        extends ExplotacionLocalServiceBaseImpl {

    private static Log _log = LogFactoryUtil.getLog(ExplotacionLocalServiceImpl.class);

    private static final DecimalFormat COORD_DECIMAL_FORMAT = new DecimalFormat("#.#######");

    @Reference
    private MeteoredService meteoredService;

    public Explotacion addExplotacion() {
        long explotacionId = counterLocalService.increment(Explotacion.class.getName());
        Explotacion explotacion = super.createExplotacion(explotacionId);
        //seteo todos los parametros
        _log.debug(explotacion);
        return super.updateExplotacion(explotacion);
    }

    private void isAValidExplotacion(Explotacion explotacion) {
        if (explotacion.getName() == null) {
            throw new RuntimeException("error.explotacion.form.name");
        } else if (explotacion.getProvincia() == null) {
            throw new RuntimeException("error.explotacion.form.province");
        } else if (explotacion.getLocation() == null) {
            throw new RuntimeException("error.explotacion.form.province");
        } else if (explotacion.getLongitude() == null) {
            throw new RuntimeException("error.explotacion.form.longitude");
        } else if (explotacion.getLatitude() == null) {
            throw new RuntimeException("error.explotacion.form.latitude");
        } else if (explotacion.getHeight() == null) {
            throw new RuntimeException("error.explotacion.form.height");
        } else if (explotacion.getMeteoredid() == null) {
            throw new RuntimeException("error.explotacion.form.meteoredId");
        }


    }

    private Explotacion createExplotacion(String externalReferenceCode, String provincia, Double longitude, int height, String location, String name, Double latitude, String meteoredid, int size, String sizeUnit, boolean isMain, boolean allowNotifications, User user) {
        long explotacionId = counterLocalService.increment(Explotacion.class.getName());
        Explotacion explotacion = super.createExplotacion(explotacionId);

        explotacion.setExternalCodeReference(externalReferenceCode);
        explotacion.setProvincia(provincia);
        explotacion.setLongitude(longitude);
        explotacion.setHeight(height);
        explotacion.setLocation(location);
        explotacion.setName(name);
        explotacion.setLatitude(latitude);
        explotacion.setSize(size);
        explotacion.setSizeUnit(sizeUnit);
        explotacion.setIsMain(isMain);
        explotacion.setAllowNotifications(allowNotifications);
        explotacion.setUserId(user.getUserId());
        explotacion.setUserName(user.getScreenName());
        explotacion.setUserUuid(user.getUserUuid());
        updateMeteoredId(explotacion, latitude, longitude);
        explotacion.setModifiedDate(new Date());

        if (isMain) {
            this.removePreviousIsMainExplotacion(user.getUserId());
        }

        return explotacion;
    }

    private Explotacion updateExplotacion(Explotacion explotacion, String provincia, Double longitude, int height, String location, String name, Double latitude, String meteoredid, int size, String sizeUnit, boolean isMain, boolean allowNotifications, User user, boolean readed) throws NoSuchExplotacionException {

        explotacion.setProvincia(provincia);
        explotacion.setLongitude(longitude);
        explotacion.setHeight(height);
        explotacion.setLocation(location);
        explotacion.setName(name);
        explotacion.setLatitude(latitude);
        explotacion.setSize(size);
        explotacion.setSizeUnit(sizeUnit);
        this.setIsMain(explotacion, user.getUserId(), isMain);
        explotacion.setAllowNotifications(allowNotifications);
        updateMeteoredId(explotacion, latitude, longitude);
        explotacion.setModifiedDate(new Date());
        explotacion.setReaded(readed);

        return explotacion;
    }

    private void updateMeteoredId(Explotacion explotacion, Double newLatitude, Double newLongitude) {
        if (explotacion.getMeteoredid() == null ||
                !Objects.equals(explotacion.getLatitude(), newLatitude) ||
                !Objects.equals(explotacion.getLatitude(), newLongitude)) {
            List<MeteoredLocation> locations = meteoredService.getLocationsByCoords(formatCoord(newLatitude), formatCoord(newLongitude));

            if (!locations.isEmpty()) {
                explotacion.setMeteoredid(locations.get(0).getHash());
            }

        }
    }

    private String formatCoord(Double coord) {
        return COORD_DECIMAL_FORMAT.format(coord).replace(",", ".");
    }

    @Override
    public Explotacion createOrUpdate(long explotacionId, String externalReferenceCode, String provincia, Double longitude, int height, String location, String name, Double latitude, String meteoredid, int size, String sizeUnit, boolean isMain, boolean allowNotifications, User user, long[] categories, boolean readed) throws PortalException {
        Explotacion explotacion = this.fetchByIdAndUserId(explotacionId, user.getUserId());

        if (Validator.isNotNull(explotacion)) {
            updateExplotacion(explotacion, provincia, longitude, height, location, name, latitude, meteoredid, size, sizeUnit, isMain, allowNotifications, user, readed);
        } else {
            explotacion = createExplotacion(externalReferenceCode, provincia, longitude, height, location, name, latitude, meteoredid, size, sizeUnit, isMain, allowNotifications, user);
        }

        if (categories != null) {
            AssetEntryLocalServiceUtil.updateEntry(user.getUserId(), user.getGroupId(), Explotacion.class.getName(), explotacion.getExplotacionId(), categories, null);
        }

        isAValidExplotacion(explotacion);
        return super.updateExplotacion(explotacion);
    }

    @Override
    public List<Explotacion> findByUserId(long userId) {
        if (explotacionPersistence == null) {
            _log.debug("explotacionPersistence is null");
            return Collections.emptyList(); // O lanzar una excepción si es crítico
        }
        _log.debug("Finding explotaciones for userId: " + userId);
        return explotacionPersistence.findByuserId(userId);
    }

    @Override
    public List<Explotacion> findByUserIdReaded(long userId, boolean readed) {
        if (explotacionPersistence == null) {
            _log.debug("explotacionPersistence is null");
            return Collections.emptyList(); // O lanzar una excepción si es crítico
        }
        _log.debug("Finding explotaciones for readed: " + readed);
        return explotacionPersistence.findByuserIdReaded(userId, readed);
    }

    @Override
    public Integer countByUserId(long userId) {
        if (explotacionPersistence == null) {
            _log.debug("explotacionPersistence is null");
            return 0; // O lanzar una excepción si es crítico
        }
        _log.debug("Counting explotaciones for userId: " + userId);
        return explotacionPersistence.countByuserId(userId);
    }

    @Override
    public void deleteExplotacion(long explotacionId, User principal) throws PortalException {
        Explotacion explotacion = explotacionLocalService.getExplotacion(explotacionId);

        if (explotacion.getUserId() != principal.getUserId()) {
            throw new NoSuchExplotacionException();
        } else {
            explotacionLocalService.deleteExplotacion(explotacionId);
            assetEntryLocalService.deleteEntry(Explotacion.class.getName(), explotacion.getExplotacionId());
        }


    }

    @Override
    public Explotacion findByExternalCodeReferenceAndUser(String externalCodeReference, long userId) throws NoSuchExplotacionException {
        return explotacionPersistence.findByexternalCodeReferenceAndUserId(externalCodeReference, userId);
    }

    @Override
    public Explotacion findByIdAndUserId(long explotacionId, long userId) throws NoSuchExplotacionException {
        return explotacionPersistence.findByidAndUserId(explotacionId, userId);
    }

    private Explotacion fetchByIdAndUserId(long explotacionId, long userId) {
        try {
            return explotacionPersistence.findByidAndUserId(explotacionId, userId);
        } catch (NoSuchExplotacionException e) {
            return null;
        }
    }


    private void setIsMain(Explotacion explotacion, long userId, boolean isMain) {
        boolean isUpdatingIsMain = explotacion.isIsMain() != isMain;

        if (isUpdatingIsMain) {
            explotacion.setIsMain(isMain);

            if (isMain) {
                removePreviousIsMainExplotacion(userId);
            }

            super.updateExplotacion(explotacion);

        }

    }

    @Override
    public void setIsMain(long explotacionId, long userId, boolean isMain) {
        try {
            Explotacion explotacion = this.findByIdAndUserId(explotacionId, userId);

            this.setIsMain(explotacion, userId, isMain);

        } catch (NoSuchExplotacionException e) {
            _log.debug("Explotacion " + explotacionId + " does not exist for user " + userId);
            throw new RuntimeException(e);
        }
    }


    private void removePreviousIsMainExplotacion(long userId) {
        List<Explotacion> explotacions = explotacionPersistence.findByisMainAndUser(true, userId);

        for (Explotacion explotacion : explotacions) {
            explotacion.setIsMain(false);
            super.updateExplotacion(explotacion);
        }

    }

}
