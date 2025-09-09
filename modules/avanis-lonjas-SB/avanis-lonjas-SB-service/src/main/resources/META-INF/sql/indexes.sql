create index IX_F994A50A on AVANIS_LONJAS_Area (areaId);
create index IX_AF18BE0B on AVANIS_LONJAS_Area (nombre[$COLUMN_LENGTH:255$]);
create index IX_AB4136E6 on AVANIS_LONJAS_Area (uuid_[$COLUMN_LENGTH:75$]);

create index IX_CAE4ECA7 on AVANIS_LONJAS_FechaLonja (lonjaId);
create index IX_847E2E6E on AVANIS_LONJAS_FechaLonja (uuid_[$COLUMN_LENGTH:75$]);

create index IX_E8F94CC0 on AVANIS_LONJAS_Grupo (grupoId);
create index IX_8423C851 on AVANIS_LONJAS_Grupo (nombre[$COLUMN_LENGTH:255$]);
create index IX_D328CBE0 on AVANIS_LONJAS_Grupo (uuid_[$COLUMN_LENGTH:75$]);

create index IX_43CB56A0 on AVANIS_LONJAS_Lonja (lonjaId);
create index IX_C792AA6A on AVANIS_LONJAS_Lonja (nombre[$COLUMN_LENGTH:255$]);
create index IX_61B8C2A7 on AVANIS_LONJAS_Lonja (uuid_[$COLUMN_LENGTH:75$]);

create index IX_AEA6EA67 on AVANIS_LONJAS_PrecioLonja (lonjaId, fecha);
create index IX_425909F on AVANIS_LONJAS_PrecioLonja (lonjaId, grupoId, fecha);
create index IX_8D53D2AB on AVANIS_LONJAS_PrecioLonja (lonjaId, grupoId, subGrupoId, areaId, fecha);
create index IX_FE15EC27 on AVANIS_LONJAS_PrecioLonja (lonjaId, grupoId, subGrupoId, fecha);
create index IX_70F9F15 on AVANIS_LONJAS_PrecioLonja (lonjaId, productoId);
create index IX_FDB82056 on AVANIS_LONJAS_PrecioLonja (productoId);
create index IX_772E9B4D on AVANIS_LONJAS_PrecioLonja (uuid_[$COLUMN_LENGTH:75$]);

create index IX_D8B1BE08 on AVANIS_LONJAS_ProductoExplot (explotacionId);
create index IX_670B777F on AVANIS_LONJAS_ProductoExplot (uuid_[$COLUMN_LENGTH:75$]);

create index IX_45469B76 on AVANIS_LONJAS_ProductoUser (userId, lonjaId, productoId);
create index IX_3CB906E8 on AVANIS_LONJAS_ProductoUser (uuid_[$COLUMN_LENGTH:75$]);

create index IX_D4829307 on AVANIS_LONJAS_SubGrupo (nombre[$COLUMN_LENGTH:255$]);
create index IX_2763CB82 on AVANIS_LONJAS_SubGrupo (subGrupoId);
create index IX_FF0AD26A on AVANIS_LONJAS_SubGrupo (uuid_[$COLUMN_LENGTH:75$]);