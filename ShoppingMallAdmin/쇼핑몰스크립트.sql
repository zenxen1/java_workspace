-- shopping mall DDL

--system ���� �����Ͽ� �۾����� 
create  tablespace  shopping 
datafile 'C:\oraclexe\app\oracle\oradata\shopping.dbf'
size 2m;

--user ���� 
create user  shop
identified by shop
default tablespace shopping
quota unlimited on shopping;

--user�� ���� ���� �ο� 
grant create session,  create table , create sequence 
to shop;

--���⼭ ���ʹ� shop ���� �����ؼ� ����
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
	, detail clob  -- mysql, mariadb ( text �ڷ����� ���)
);
create sequence  seq_product
increment by 1
start with 1;
