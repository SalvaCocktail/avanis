-- AVANIS_EXPLOTACION_Alertas --
create table AVANIS_EXPLOTACION_Alertas (
	uuid_ VARCHAR(75) null,
	alertaId LONG not null primary key,
	explotacionId LONG,
	userId LONG,
	description VARCHAR(255) null,
	endDate VARCHAR(75) null,
	startDate VARCHAR(75) null,
	risk VARCHAR(75) null,
	phenomenom VARCHAR(255) null,
	scope VARCHAR(75) null,
	probability VARCHAR(75) null,
	type_ VARCHAR(75) null,
	readed BOOLEAN,
	createDate DATE null,
	modifiedDate DATE null,
	externalCodeReference VARCHAR(75) null
);
-- AVANIS_EXPLOTACION_Explotacion --
create table AVANIS_EXPLOTACION_Explotacion (
	uuid_ VARCHAR(75) null,
	explotacionId LONG not null primary key,
	provincia VARCHAR(75) null,
	longitude DOUBLE,
	height INTEGER,
	location VARCHAR(75) null,
	name VARCHAR(75) null,
	latitude DOUBLE,
	meteoredid VARCHAR(75) null,
	size_ INTEGER,
	sizeUnit VARCHAR(75) null,
	isMain BOOLEAN,
	allowNotifications BOOLEAN,
	userId LONG,
	userName VARCHAR(75) null,
	readed BOOLEAN,
	createDate DATE null,
	modifiedDate DATE null,
	externalCodeReference VARCHAR(75) null
);