create index IX_18E6922A on AVANIS_COMUNIDAD_Answers (surveyId);
create index IX_91CE46F3 on AVANIS_COMUNIDAD_Answers (uuid_[$COLUMN_LENGTH:75$]);

create index IX_792279B3 on AVANIS_COMUNIDAD_AnswersUser (answerId, userId);
create index IX_CA31574F on AVANIS_COMUNIDAD_AnswersUser (surveyId, userId);
create index IX_F75CB386 on AVANIS_COMUNIDAD_AnswersUser (userId);
create index IX_C98634E8 on AVANIS_COMUNIDAD_AnswersUser (uuid_[$COLUMN_LENGTH:75$]);

create index IX_57366FB6 on AVANIS_COMUNIDAD_Surveys (assetId);
create index IX_927E1BF on AVANIS_COMUNIDAD_Surveys (userId);
create unique index IX_E34229FB on AVANIS_COMUNIDAD_Surveys (uuid_[$COLUMN_LENGTH:75$], groupId);