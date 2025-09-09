create table EVENT_FOLLOW_EventFollow (
	uuid_ VARCHAR(75) null,
	eventFollowId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	eventId LONG
);