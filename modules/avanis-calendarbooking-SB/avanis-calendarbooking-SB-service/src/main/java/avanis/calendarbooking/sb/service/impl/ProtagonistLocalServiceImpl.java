/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service.impl;

import avanis.calendarbooking.sb.model.Protagonist;
import avanis.calendarbooking.sb.service.base.ProtagonistLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=avanis.calendario.sb.model.Protagonist",
        service = AopService.class
)
public class ProtagonistLocalServiceImpl
        extends ProtagonistLocalServiceBaseImpl {

    public Protagonist addProtagonist(
            long userId, long groupId, long calendarBookingId, String name, String lastName,
            String profession, String bio, String portraitUrl,
            ServiceContext serviceContext) throws PortalException {

        long protagonistId = counterLocalService.increment();

        Protagonist protagonist = protagonistPersistence.create(protagonistId);

        User user = userLocalService.getUserById(userId);

        protagonist.setUuid(serviceContext.getUuid());
        protagonist.setUserId(userId);
        protagonist.setCalendarBookingId(calendarBookingId);
        protagonist.setUserName(user.getFullName());
        protagonist.setGroupId(groupId);
        protagonist.setCompanyId(user.getCompanyId());
        protagonist.setCreateDate(serviceContext.getCreateDate(new Date()));
        protagonist.setModifiedDate(serviceContext.getModifiedDate(new Date()));
        protagonist.setName(name);
        protagonist.setLastName(lastName);
        protagonist.setProfession(profession);
        protagonist.setBio(bio);
        protagonist.setPortraitUrl(portraitUrl);

        protagonistPersistence.update(protagonist);

        return protagonist;
    }

    public Protagonist getProtagonist(long protagonistId) throws PortalException {
        return protagonistPersistence.findByPrimaryKey(protagonistId);
    }

    public Protagonist updateProtagonist(
            long protagonistId, String name, String lastName,
            String profession, String bio, long portraitId,
            ServiceContext serviceContext) throws PortalException {

        Protagonist protagonist = protagonistPersistence.findByPrimaryKey(protagonistId);

        protagonist.setModifiedDate(serviceContext.getModifiedDate(new Date()));
        protagonist.setName(name);
        protagonist.setLastName(lastName);
        protagonist.setProfession(profession);
        protagonist.setBio(bio);
        //protagonist.setPortraitId(portraitId);

        protagonistPersistence.update(protagonist);

        return protagonist;
    }

    public Protagonist deleteProtagonist(long protagonistId) throws PortalException {
        Protagonist protagonist = protagonistPersistence.remove(protagonistId);
        return protagonist;
    }

    public List<Protagonist> getProtagonistsByUserId(long userId) {
        return protagonistPersistence.findByuserId(userId);
    }

    @Override
    public List<Protagonist> getProtagonistsByCalendarBookingId(long calendarBookingId) {
        return protagonistPersistence.findBycalendarBookingId(calendarBookingId);
    }

    @Override
    public List<Protagonist> getProtagonistsByCalendarBookingId(long calendarBookingId, int start, int end) {
        return protagonistPersistence.findBycalendarBookingId(calendarBookingId, start, end);
    }

    @Override
    public Integer countProtagonistsByCalendarBookingId(long calendarBookingId) {
        return protagonistPersistence.countBycalendarBookingId(calendarBookingId);
    }
}