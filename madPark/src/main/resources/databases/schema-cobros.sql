DROP TABLE IF EXISTS COBRO;

CREATE TABLE  "COBRO" (
	"EMAIL" VARCHAR2(100) NOT NULL PRIMARY KEY,
	"ID_PARK" VARCHAR2(40) NOT NULL,
	"DATE" DATE,
	"TIME" TIME,
	"COST" FLOAT
    
);