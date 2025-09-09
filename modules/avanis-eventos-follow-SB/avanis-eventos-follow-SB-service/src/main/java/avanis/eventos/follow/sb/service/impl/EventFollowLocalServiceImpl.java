/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.eventos.follow.sb.service.impl;

import avanis.eventos.follow.sb.model.EventFollow;
import avanis.eventos.follow.sb.service.base.EventFollowLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=avanis.eventos.follow.sb.model.EventFollow",
        service = AopService.class
)
public class EventFollowLocalServiceImpl
        extends EventFollowLocalServiceBaseImpl {
    @Override
    public List<EventFollow> getEventFollowsByUserId(long userId) {
        return eventFollowPersistence.findBygetEvents(userId);
    }

    @Override
    public EventFollow getEventFollowsByUserIdAndEventFollow(long userId, long eventId) {
        return eventFollowPersistence.fetchBygetFollow(eventId, userId);
    }

    @Override
    public Boolean follows(long principalId, long eventId) throws PortalException {
        EventFollow eventFollow = eventFollowPersistence.fetchBygetFollow(eventId, principalId);

        if (eventFollow == null) {
            eventFollow = createEventFollow(principalId, eventId);
            eventFollow = super.updateEventFollow(eventFollow);
            return eventFollow != null;
        }
        return false;
    }

    @Override
    public List<EventFollow> getEventFollowsByEventId(long eventId) {
        return eventFollowPersistence.findBygetUsers(eventId);
    }

    private EventFollow createEventFollow(long principalId, long eventId) throws PortalException {
        long id = counterLocalService.increment(EventFollow.class.getName());

        EventFollow eventFollow = super.createEventFollow(id);
        eventFollow.setUserId(principalId);
        eventFollow.setEventId(eventId);


        return eventFollow;


    }

}