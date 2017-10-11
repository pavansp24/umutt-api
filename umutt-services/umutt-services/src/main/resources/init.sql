
CREATE TABLE UMUTT_HEALTH (NAME varchar(20) primary key , VERSION varchar(10));

insert into UMUTT_HEALTH values ('Uttaradi Mutt Micro Services' , '1.0');

CREATE TABLE UMUTT_USER (USER_ID varchar(20) primary key,PASSWORD varchar(20), 	FNAME varchar(30) , ,LNAME varchar(30) , ,ROLE number ,EMAIL varchar(30),PHONE varchar(20));

insert into UMUTT_USER values ('pavansp' , 'umutt' , 'Pavan' , 'Puranik' ,'99','puranik01@gmail.com','8970484997');


CREATE TABLE UMUTT_REGISTRATION (REG_ID NUMBER(*,0) primary key , EVENT varchar(20) ,FULL_NM varchar(60),ADDRESS varchar(60),LOCALITY varchar(60), CITY varchar(60) ,STATE varchar(20)
,EMAIL varchar(30),PHONE varchar(20),FAMILY_MEM_COUNT number , CRT_BY  varchar(20), UPD_BY varchar(20), CRT_DT timestamp , UPD_DT timestamp,ENABLED NUMBER(1,0) DEFAULT 1 );

