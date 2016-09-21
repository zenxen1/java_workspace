-- shopping mall DDL

--system 으로 접속하여 작업진행 
create  tablespace  shopping 
datafile 'C:\oraclexe\app\oracle\oradata\shopping.dbf'
size 2m;

--user 생성 
create user  shop
identified by shop
default tablespace shopping
quota unlimited on shopping;

--user에 대한 권한 부여 
grant create session,  create table , create sequence 
to shop;

--여기서 부터는 shop 으로 접속해서 진행
create  table promotion(
   promotion_id number primary key 
 , title varchar2(30)
);
create sequence  seq_promotion
increment by 1
start with 1;

create  table  topcategory(
    topcategory_id number primary key 
  , title varchar2(20)
);
create sequence  seq_topcategory
increment by 1
start with 1;

create table subcategory(
    subcategory_id number primary key 
  , topcategory_id number  -- will be foreign key
  , title varchar2(30)
);
create sequence  seq_subcategory
increment by 1
start with 1;

create table  promotion_product(
    promotion_product_id number primary key 
  , product_id number  -- which product ??  
  , promotion_id number  -- which promotion ??
);
create sequence  seq_promotion_product
increment by 1
start with 1;


create  table  product(
	  product_id number primary key
	, subcategory_id number
	, product_name varchar2(30)			
	, price number default 0	
	, stock number default 0	
	, img varchar2(20)
	, detail clob  -- mysql, mariadb ( text 자료형과 비슷)
);
create sequence  seq_product
increment by 1
start with 1;
