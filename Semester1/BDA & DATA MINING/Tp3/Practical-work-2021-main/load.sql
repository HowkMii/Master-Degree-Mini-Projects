load data local infile '/local/users/bka/bibmCVS/ssb/mysql/ssb1/lineorder.tbl' into table lineorder fields terminated by '|' (LO_ORDERKEY, LO_LINENUMBER, LO_CUSTKEY, LO_PARTKEY, LO_SUPPKEY, LO_ORDERDATE, LO_ORDERPRIORITY, LO_SHIPPRIORITY, LO_QUANTITY, LO_EXTENDEDPRICE, LO_ORDTOTALPRICE, LO_DISCOUNT, LO_REVENUE, LO_SUPPLYCOST, LO_TAX, LO_COMMITDATE, LO_SHIPMODE);

load data local infile '/local/users/bka/bibmCVS/ssb/mysql/ssb1/date.tbl' into table dates fields terminated by '|' (D_DATEKEY, D_DATE, D_DAYOFWEEK, D_MONTH, D_YEAR, D_YEARMONTHNUM, D_YEARMONTH, D_DAYNUMINWEEK, D_DAYNUMINMONTH, D_DAYNUMINYEAR, D_MONTHNUMINYEAR, D_WEEKNUMINYEAR, D_SELLINGSEASON, D_LASTDAYINWEEKFL, D_LASTDAYINMONTHFL, D_HOLIDAYFL, D_WEEKDAYFL);

load data local infile '/local/users/bka/bibmCVS/ssb/mysql/ssb1/part.tbl' into table part fields terminated by '|' (P_PARTKEY, P_NAME, P_MFGR, P_CATEGORY, P_BRAND1, P_COLOR, P_TYPE, P_SIZE, P_CONTAINER);

# S_NATION_PREFIX does not exist in the data.
load data local infile '/local/users/bka/bibmCVS/ssb/mysql/ssb1/supplier.tbl' into table supplier fields terminated by '|' (S_SUPPKEY, S_NAME,  S_ADDRESS, S_CITY, S_NATION, S_REGION, S_PHONE);

# S_NATION_PREFIX does not exist in the data.
load data local infile '/local/users/bka/bibmCVS/ssb/mysql/ssb1/customer.tbl' into table customer fields terminated by '|' (C_CUSTKEY, C_NAME, C_ADDRESS, C_CITY, C_NATION, C_REGION, C_PHONE, C_MKTSEGMENT);
