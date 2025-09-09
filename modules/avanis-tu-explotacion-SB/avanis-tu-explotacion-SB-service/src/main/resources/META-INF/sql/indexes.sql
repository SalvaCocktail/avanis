create index IX_B409CC97 on AVANIS_EXPLOTACION_Alertas (userId, readed);
create index IX_D6C70BC0 on AVANIS_EXPLOTACION_Alertas (uuid_[$COLUMN_LENGTH:75$]);

create index IX_5F0CB67F on AVANIS_EXPLOTACION_Explotacion (explotacionId, userId);
create index IX_DF532905 on AVANIS_EXPLOTACION_Explotacion (externalCodeReference[$COLUMN_LENGTH:75$], userId);
create index IX_DB76BAE9 on AVANIS_EXPLOTACION_Explotacion (isMain, userId);
create index IX_E19F13E1 on AVANIS_EXPLOTACION_Explotacion (readed);
create index IX_86E11A1B on AVANIS_EXPLOTACION_Explotacion (userId, readed);
create index IX_986DB9BC on AVANIS_EXPLOTACION_Explotacion (uuid_[$COLUMN_LENGTH:75$]);