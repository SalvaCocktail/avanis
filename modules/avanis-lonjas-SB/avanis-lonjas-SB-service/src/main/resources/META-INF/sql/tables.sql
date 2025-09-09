create table AVANIS_LONJAS_Area (
	uuid_ VARCHAR(75) null,
	entityId LONG not null primary key,
	areaId LONG,
	subGrupoId LONG,
	grupoId LONG,
	nombre VARCHAR(255) null,
	createDate DATE null,
	modifiedDate DATE null
);


create table AVANIS_LONJAS_FechaLonja (
	uuid_ VARCHAR(75) null,
	entityId LONG not null primary key,
	lonjaId LONG,
	fecha DATE null,
	createDate DATE null,
	modifiedDate DATE null
);


create table AVANIS_LONJAS_Grupo (
	uuid_ VARCHAR(75) null,
	entityId LONG not null primary key,
	grupoId LONG,
	nombre VARCHAR(255) null,
	createDate DATE null,
	modifiedDate DATE null
);


create table AVANIS_LONJAS_Lonja (
	uuid_ VARCHAR(75) null,
	entityId LONG not null primary key,
	lonjaId LONG,
	nombre VARCHAR(255) null,
	pais VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);


create table AVANIS_LONJAS_PrecioLonja (
	uuid_ VARCHAR(75) null,
	entityId LONG not null primary key,
	productoId LONG,
	lonjaId LONG,
	grupoId LONG,
	subGrupoId LONG,
	areaId LONG,
	fecha DATE null,
	nombreProducto VARCHAR(75) null,
	precioAnterior VARCHAR(75) null,
	precioUltimo VARCHAR(75) null,
	precioMaximo VARCHAR(75) null,
	precioMedio VARCHAR(75) null,
	precioMinimo VARCHAR(75) null,
	precioOrigen VARCHAR(75) null,
	anteriorEuros VARCHAR(75) null,
	ultimoEuros VARCHAR(75) null,
	unidadMedida VARCHAR(75) null,
	unidadLarga VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);


create table AVANIS_LONJAS_ProductoExplot (
	uuid_ VARCHAR(75) null,
	entityId LONG not null primary key,
	lonjaId LONG,
	productoId LONG,
	precioLonjaId LONG,
	explotacionId LONG,
	orden LONG,
	createDate DATE null,
	modifiedDate DATE null
);


create table AVANIS_LONJAS_ProductoUser (
	uuid_ VARCHAR(75) null,
	entityId LONG not null primary key,
	lonjaId LONG,
	productoId LONG,
	precioLonjaId LONG,
	userId LONG,
	orden LONG,
	createDate DATE null,
	modifiedDate DATE null
);


create table AVANIS_LONJAS_SubGrupo (
	uuid_ VARCHAR(75) null,
	entityId LONG not null primary key,
	subGrupoId LONG,
	grupoId LONG,
	nombre VARCHAR(255) null,
	createDate DATE null,
	modifiedDate DATE null
);