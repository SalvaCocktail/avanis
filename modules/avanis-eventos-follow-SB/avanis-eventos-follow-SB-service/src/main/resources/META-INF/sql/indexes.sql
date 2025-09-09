create index IX_82331F17 on EVENT_FOLLOW_EventFollow (eventId, userId);
create index IX_AB225CA2 on EVENT_FOLLOW_EventFollow (userId);
create index IX_D753245C on EVENT_FOLLOW_EventFollow (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D111DE on EVENT_FOLLOW_EventFollow (uuid_[$COLUMN_LENGTH:75$], groupId);