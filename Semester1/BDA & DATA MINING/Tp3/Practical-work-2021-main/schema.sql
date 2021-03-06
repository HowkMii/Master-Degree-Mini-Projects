CREATE DATABASE ssb1;

USE ssb1;

DROP TABLE lineorder;
DROP TABLE dates;
DROP TABLE part;
DROP TABLE supplier;
DROP TABLE customer;

CREATE TABLE lineorder (
    lo_orderkey    INTEGER NOT NULL,
    lo_linenumber  INTEGER NOT NULL,
    lo_custkey     INTEGER NOT NULL,
    lo_partkey     INTEGER NOT NULL,
    lo_suppkey     INTEGER NOT NULL,
    lo_orderdate   INTEGER NOT NULL,
    lo_orderpriority  CHAR(15) NOT NULL,
    lo_shippriority   INTEGER NOT NULL,
    lo_quantity    double precision NOT NULL,
    lo_extendedprice  double precision NOT NULL,
    lo_ordtotalprice     double precision NOT NULL,
    lo_discount    double precision NOT NULL,
    lo_revenue INTEGER NOT NULL,
    lo_supplycost INTEGER NOT NULL,
    lo_tax         double precision NOT NULL,
    lo_commitdate  INTEGER NOT NULL,
    lo_shipmode     CHAR(10) NOT NULL,

    PRIMARY KEY    (LO_ORDERKEY, LO_LINENUMBER)
    );

CREATE TABLE dates (
	D_DATEKEY    INTEGER NOT NULL,
	D_DATE       CHAR(18) NOT NULL,
	D_DAYOFWEEK CHAR(8) NOT NULL,
	D_MONTH CHAR(9) NOT NULL, 
	D_YEAR INTEGER NOT NULL,
	D_YEARMONTHNUM INTEGER NOT NULL, 
	D_YEARMONTH CHAR(7) NOT NULL,
	D_DAYNUMINWEEK INTEGER(1) NOT NULL,
	D_DAYNUMINMONTH INTEGER(2) NOT NULL,
	D_DAYNUMINYEAR INTEGER(3) NOT NULL,
	D_MONTHNUMINYEAR INTEGER(2) NOT NULL,
	D_WEEKNUMINYEAR INTEGER(2) NOT NULL,
	D_SELLINGSEASON CHAR(12) NOT NULL,
	D_LASTDAYINWEEKFL BIT(1) NOT NULL,
	D_LASTDAYINMONTHFL BIT(1) NOT NULL,
	D_HOLIDAYFL BIT(1) NOT NULL,
	D_WEEKDAYFL BIT(1) NOT NULL,
	PRIMARY KEY    (D_DATEKEY)
);

CREATE TABLE part (
	P_PARTKEY    INTEGER NOT NULL,
	P_NAME CHAR(18) NOT NULL,
	P_MFGR CHAR(6) NOT NULL,
	P_CATEGORY CHAR(7) NOT NULL,
	P_BRAND1 CHAR(9) NOT NULL,
	P_COLOR CHAR(11) NOT NULL,
	P_TYPE CHAR(25) NOT NULL,
	P_SIZE INTEGER(2) NOT NULL,
	P_CONTAINER CHAR(10),
	PRIMARY KEY (P_PARTKEY)
);

# S_NATION_PREFIX removed.
CREATE TABLE supplier (
    S_SUPPKEY     INTEGER NOT NULL,
    S_NAME        CHAR(25) NOT NULL,
    S_ADDRESS     VARCHAR(25) NOT NULL,
    S_CITY		  VARCHAR(10) NOT NULL,
    S_NATION	  VARCHAR(15) NOT NULL,
    S_REGION	  VARCHAR(12) NOT NULL,
    S_PHONE       CHAR(15) NOT NULL,
    PRIMARY KEY   (S_SUPPKEY)
);

# C_NATION_PREFIX removed.
CREATE TABLE customer (
    C_CUSTKEY     INTEGER NOT NULL,
    C_NAME        VARCHAR(25) NOT NULL,
    C_ADDRESS     VARCHAR(25) NOT NULL,
    C_CITY		  VARCHAR(10) NOT NULL,
    C_NATION	  VARCHAR(15) NOT NULL,
    C_REGION	  VARCHAR(12) NOT NULL,
    C_PHONE       CHAR(15) NOT NULL,
    C_MKTSEGMENT  CHAR(10) NOT NULL,
    PRIMARY KEY   (C_CUSTKEY)
);