create index IX_DA5BD128 on SOCIAL_FOLLOW_SocialFollow (followsTo, accepted);
create index IX_9D708175 on SOCIAL_FOLLOW_SocialFollow (userId, accepted);
create index IX_4B0FF013 on SOCIAL_FOLLOW_SocialFollow (userId, followsTo);
create index IX_494FBED4 on SOCIAL_FOLLOW_SocialFollow (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_E3A1EA56 on SOCIAL_FOLLOW_SocialFollow (uuid_[$COLUMN_LENGTH:75$], groupId);