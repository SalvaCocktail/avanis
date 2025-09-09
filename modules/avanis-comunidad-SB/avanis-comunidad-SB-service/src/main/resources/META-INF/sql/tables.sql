-- AVANIS_COMUNIDAD_Answers --
create table AVANIS_COMUNIDAD_Answers (
	uuid_ VARCHAR(75) null,
	answerId LONG not null primary key,
	surveyId LONG,
	answer VARCHAR(255) null,
	counterAnswer INTEGER,
	createDate DATE null
);
-- AVANIS_COMUNIDAD_AnswersUser --
create table AVANIS_COMUNIDAD_AnswersUser (
	uuid_ VARCHAR(75) null,
	answerUserId LONG not null primary key,
	answerId LONG,
	userId LONG,
	surveyId LONG,
	createDate DATE null,
	modifiedDate DATE null
);
-- AVANIS_COMUNIDAD_Surveys --
create table AVANIS_COMUNIDAD_Surveys (
	uuid_ VARCHAR(75) null,
	surveyId LONG not null primary key,
	groupId LONG,
	userId LONG,
	assetId LONG,
	question VARCHAR(255) null,
	expireHours INTEGER,
	createDate DATE null,
	modifiedDate DATE null,
	expireDate DATE null,
	notified BOOLEAN
);