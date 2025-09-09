create index IX_40DF3489 on AVANIS_CALENDAR_BookingAgenda (calendarBookingId);
create index IX_4ACCE977 on AVANIS_CALENDAR_BookingAgenda (userId);
create index IX_5E876AF1 on AVANIS_CALENDAR_BookingAgenda (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_201FF9B3 on AVANIS_CALENDAR_BookingAgenda (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_70653AD0 on AVANIS_CALENDAR_Protagonist (calendarBookingId);
create index IX_96EC0990 on AVANIS_CALENDAR_Protagonist (userId);
create index IX_7093FFCA on AVANIS_CALENDAR_Protagonist (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_E5CDF0CC on AVANIS_CALENDAR_Protagonist (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_597A54D4 on AVANIS_CALENDAR_Sponsor (calendarBookingId);
create index IX_73830A0C on AVANIS_CALENDAR_Sponsor (userId);
create index IX_DB319546 on AVANIS_CALENDAR_Sponsor (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_C8AB548 on AVANIS_CALENDAR_Sponsor (uuid_[$COLUMN_LENGTH:75$], groupId);