DROP TABLE IF EXISTS USER ;

CREATE TABLE  "USER" (
	
	"NAME" VARCHAR2(40) NOT NULL,
	"APELLIDOS" VARCHAR2(40),
	"EMAIL" VARCHAR2(100) NOT NULL PRIMARY KEY,
	"PASSWORD" VARCHAR2(100) NOT NULL,
	"NUM_TARJETA" NUMBER,
	"CVV" NUMBER,
	"CADUCIDAD" VARCHAR2(7)
);

DROP TABLE IF EXISTS COBRO;

CREATE TABLE  "COBRO" (
	"EMAIL" VARCHAR2(100) NOT NULL PRIMARY KEY,
	"ID_PARK" VARCHAR2(40) NOT NULL,
	"DATE" VARCHAR2(10),
	"TIME" TIME,
	"COST" FLOAT
    
);

DROP TABLE IF EXISTS MATRICULAS;

CREATE TABLE  "MATRICULAS" (
	"EMAIL" VARCHAR2(100) NOT NULL PRIMARY KEY,
	"MATRICULA1" VARCHAR2(7) NOT NULL,
	"MATRICULA2" VARCHAR2(7),
	"MATRICULA3" VARCHAR2(7),
	"MATRICULA4" VARCHAR2(7),
	"MATRICULA5" VARCHAR2(7)
);

DROP TABLE IF EXISTS HISTORIAL;

CREATE TABLE  "HISTORIAL" (
	"EMAIL" VARCHAR2(100) NOT NULL PRIMARY KEY,
	"ID_PARK" NUMBER,
	"PARKING" VARCHAR2(100) NOT NULL
    
);
