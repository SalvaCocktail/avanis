create table SOCIAL_FOLLOW_SocialFollow (
	uuid_ VARCHAR(75) null,
	socialFollowId LONG not null primary key,
	accepted BOOLEAN,
	followsTo LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);