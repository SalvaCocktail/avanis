create table AVANIS_CALENDAR_BookingAgenda (
	uuid_ VARCHAR(75) null,
	calendarBookingAgendaId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	day LONG,
	startHour LONG,
	endHour LONG,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	calendarBookingId LONG
);


create table AVANIS_CALENDAR_Protagonist (
	uuid_ VARCHAR(75) null,
	protagonistId LONG not null primary key,
	calendarBookingId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	lastName VARCHAR(75) null,
	profession VARCHAR(75) null,
	bio VARCHAR(75) null,
	portraitUrl VARCHAR(500) null
);

create table AVANIS_CALENDAR_Sponsor (
	uuid_ VARCHAR(75) null,
	sponsorId LONG not null primary key,
	calendarBookingId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	iconUrl VARCHAR(500) null
);