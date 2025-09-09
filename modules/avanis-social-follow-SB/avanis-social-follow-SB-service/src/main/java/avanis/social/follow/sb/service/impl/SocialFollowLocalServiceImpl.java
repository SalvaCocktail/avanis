/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package avanis.social.follow.sb.service.impl;

import avanis.social.follow.sb.model.SocialFollow;
import avanis.social.follow.sb.service.base.SocialFollowLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
        property = "model.class.name=avanis.social.follow.sb.model.SocialFollow",
        service = AopService.class
)
public class SocialFollowLocalServiceImpl
        extends SocialFollowLocalServiceBaseImpl {
    private static final String SEARCH_SEPARATOR = " ";

    @Override
    public List<User> getFollowers(long userId, String filterName, int start, int end) {
        DynamicQuery dynamicQuery = null;
        if (filterName == null || filterName.isEmpty()) {
            List<SocialFollow> socialFollows = socialFollowPersistence.findBygetFollowers(userId, true, start, end);
            List<Long> userIds = socialFollows.stream().map(SocialFollow::getUserId).collect(Collectors.toList());

            dynamicQuery = UserLocalServiceUtil.dynamicQuery();
            dynamicQuery.add(RestrictionsFactoryUtil.in("userId", userIds));
        } else {
            List<SocialFollow> socialFollows = socialFollowPersistence.findBygetFollowers(userId, true);
            dynamicQuery = UserLocalServiceUtil.dynamicQuery();
            dynamicQuery.add(RestrictionsFactoryUtil.in("userId", socialFollows.stream().map(SocialFollow::getUserId).collect(Collectors.toList())));
            addFilterToDynamicQuery(dynamicQuery, filterName);

            dynamicQuery.setLimit(start, end);
        }


        return UserLocalServiceUtil.dynamicQuery(dynamicQuery);
    }

    private void addFilterToDynamicQuery(DynamicQuery dynamicQuery, String filterName) {
        if (filterName != null && !filterName.isBlank()) {
            Disjunction disjunction = RestrictionsFactoryUtil.disjunction();

            Disjunction firstNameDisjunction = RestrictionsFactoryUtil.disjunction();
            Disjunction lastNameDisjunction = RestrictionsFactoryUtil.disjunction();

            for (String filter : filterName.split(SEARCH_SEPARATOR)) {
                firstNameDisjunction.add(RestrictionsFactoryUtil.ilike("firstName", "%" + filter + "%"));
            }

            for (String filter : filterName.split(SEARCH_SEPARATOR)) {
                lastNameDisjunction.add(RestrictionsFactoryUtil.ilike("lastName", "%" + filter + "%"));
            }


            Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
            conjunction.add(firstNameDisjunction);
            conjunction.add(lastNameDisjunction);

            disjunction.add(RestrictionsFactoryUtil.ilike("screenName", "%" + filterName + "%"));
            disjunction.add(conjunction);


            dynamicQuery.add(disjunction);
        }
    }

    @Override
    public Integer countFollowers(long userId) {
        return socialFollowPersistence.countBygetFollowers(userId, true);
    }

    @Override
    public Long countFollowers(long userId, String filterName) {
        DynamicQuery dynamicQuery = null;
        List<SocialFollow> socialFollows = socialFollowPersistence.findBygetFollowers(userId, true);


        dynamicQuery = UserLocalServiceUtil.dynamicQuery();
        dynamicQuery.add(RestrictionsFactoryUtil.in("userId", socialFollows.stream().map(SocialFollow::getUserId).collect(Collectors.toList())));
        addFilterToDynamicQuery(dynamicQuery, filterName);
        dynamicQuery.setProjection(ProjectionFactoryUtil.rowCount());

        List<Long> result = UserLocalServiceUtil.dynamicQuery(dynamicQuery);

        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            return 0L;
        }
    }

    @Override
    public Integer countFollowing(long userId) {
        return socialFollowPersistence.countBygetFollowing(userId, true);
    }

    @Override
    public Long countFollowing(long userId, String filterName) {
        DynamicQuery dynamicQuery = null;
        List<SocialFollow> socialFollows = socialFollowPersistence.findBygetFollowing(userId, true);


        dynamicQuery = UserLocalServiceUtil.dynamicQuery();
        dynamicQuery.add(RestrictionsFactoryUtil.in("userId", socialFollows.stream().map(SocialFollow::getFollowsTo).collect(Collectors.toList())));
        addFilterToDynamicQuery(dynamicQuery, filterName);
        dynamicQuery.setProjection(ProjectionFactoryUtil.rowCount());

        List<Long> result = UserLocalServiceUtil.dynamicQuery(dynamicQuery);

        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            return 0L;
        }
    }

    @Override
    public Integer countFollowRequests(long userId) {
        return socialFollowPersistence.countBygetFollowers(userId, false);
    }

    @Override
    public List<User> getFollowings(long userId, String filterName, int start, int end) {
        DynamicQuery dynamicQuery = null;
        if (filterName == null || filterName.isEmpty()) {
            List<SocialFollow> socialFollows = socialFollowPersistence.findBygetFollowing(userId, true, start, end);
            List<Long> userIds = socialFollows.stream().map(SocialFollow::getFollowsTo).collect(Collectors.toList());

            dynamicQuery = UserLocalServiceUtil.dynamicQuery();
            dynamicQuery.add(RestrictionsFactoryUtil.in("userId", userIds));
        } else {
            List<SocialFollow> socialFollows = socialFollowPersistence.findBygetFollowing(userId, true);


            dynamicQuery = UserLocalServiceUtil.dynamicQuery();
            dynamicQuery.add(RestrictionsFactoryUtil.in("userId", socialFollows.stream().map(SocialFollow::getFollowsTo).collect(Collectors.toList())));
            addFilterToDynamicQuery(dynamicQuery, filterName);
            dynamicQuery.setLimit(start, end);
        }

        return UserLocalServiceUtil.dynamicQuery(dynamicQuery);
    }

    @Override
    public List<User> getFollowRequests(long userId, int start, int end) {
        List<SocialFollow> socialFollows = socialFollowPersistence.findBygetFollowers(userId, false, start, end);

        List<Long> userIds = socialFollows.stream().map(SocialFollow::getUserId).collect(Collectors.toList());

        DynamicQuery dynamicQuery = UserLocalServiceUtil.dynamicQuery();
        dynamicQuery.add(RestrictionsFactoryUtil.in("userId", userIds));
        return UserLocalServiceUtil.dynamicQuery(dynamicQuery);
    }

    @Override
    public SocialFollow getFollow(long userId, long followsToUserId) {
        return socialFollowPersistence.fetchBygetFollow(userId, followsToUserId);
    }


    @Override
    public Boolean follows(long principalId, long userId) throws PortalException {
        SocialFollow socialFollow = socialFollowPersistence.fetchBygetFollow(principalId, userId);

        if (socialFollow == null) {
            socialFollow = createSocialFollow(principalId, userId);
            socialFollow = super.updateSocialFollow(socialFollow);
            return socialFollow != null;
        }
        return false;

    }

    @Override
    public SocialFollow acceptFollow(long userId, long principalId) {
        SocialFollow socialFollow = socialFollowPersistence.fetchBygetFollow(userId, principalId);

        if (socialFollow != null && !socialFollow.getAccepted()) {
            socialFollow.setAccepted(true);
            return super.updateSocialFollow(socialFollow);
        } else {
            return null;
        }

    }


    private SocialFollow createSocialFollow(long principalId, long followsToUserId) throws PortalException {
        long id = counterLocalService.increment(SocialFollow.class.getName());
        User user = UserLocalServiceUtil.getUser(followsToUserId);

        SocialFollow socialFollow = super.createSocialFollow(id);
        socialFollow.setFollowsTo(followsToUserId);
        socialFollow.setUserId(principalId);
        socialFollow.setAccepted(false);


        return socialFollow;


    }
}