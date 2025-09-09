/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.calendarbooking.sb.service.impl;

import avanis.calendarbooking.sb.model.Sponsor;
import avanis.calendarbooking.sb.service.base.SponsorLocalServiceBaseImpl;

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
        property = "model.class.name=avanis.calendario.sb.model.Sponsor",
        service = AopService.class
)
public class SponsorLocalServiceImpl extends SponsorLocalServiceBaseImpl {

    public Sponsor addSponsor(
            long userId, long calendarBookingId, String name, String iconUrl, ServiceContext serviceContext) throws PortalException, PortalException {

        long sponsorId = counterLocalService.increment();

        Sponsor sponsor = sponsorPersistence.create(sponsorId);

        User user = userLocalService.getUserById(userId);

        sponsor.setUuid(serviceContext.getUuid());
        sponsor.setUserId(userId);
        sponsor.setCalendarBookingId(calendarBookingId);
        sponsor.setUserName(user.getFullName());
        sponsor.setGroupId(serviceContext.getScopeGroupId());
        sponsor.setCompanyId(user.getCompanyId());
        sponsor.setCreateDate(serviceContext.getCreateDate(new Date()));
        sponsor.setModifiedDate(serviceContext.getModifiedDate(new Date()));
        sponsor.setName(name);
        sponsor.setIconUrl(iconUrl);

        sponsorPersistence.update(sponsor);

        return sponsor;
    }

    public Sponsor getSponsor(long sponsorId) throws PortalException {
        return sponsorPersistence.findByPrimaryKey(sponsorId);
    }

    public Sponsor deleteSponsor(long sponsorId) throws PortalException {
        Sponsor sponsor = sponsorPersistence.remove(sponsorId);
        return sponsor;
    }

    public List<Sponsor> getSponsorsByCalendarBookingId(long calendarBookingId) {
        return sponsorPersistence.findBycalendarBookingId(calendarBookingId);
    }

    @Override
    public List<Sponsor> getSponsorsByCalendarBookingId(long calendarBookingId, int start, int end) {
        return sponsorPersistence.findBycalendarBookingId(calendarBookingId, start, end);
    }

    @Override
    public Integer countSponsorsByCalendarBookingId(long calendarBookingId) {
        return sponsorPersistence.countBycalendarBookingId(calendarBookingId);
    }

    public List<Sponsor> getSponsorsByUserId(long userId) {
        return sponsorPersistence.findByuserId(userId);
    }

}