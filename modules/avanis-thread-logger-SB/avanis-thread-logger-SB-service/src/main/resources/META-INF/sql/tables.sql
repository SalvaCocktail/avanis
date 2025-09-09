create table ThreadLogger_ThreadLog (
	threadLogId LONG not null primary key,
	createDate DATE null,
	threadName VARCHAR(1000) null,
	stackTrace TEXT null,
	threadState VARCHAR(75) null,
	lockName VARCHAR(255) null,
	lockOwnerName VARCHAR(255) null,
	lockOwnerId LONG
);