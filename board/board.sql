create table boarddb
(
idx number primary key,
title varchar2(200),
writer varchar2(20),
regdate varchar2(20),
ct number,
content clob

)
create sequence board_sq
select * from boarddb

create table mem(
id varchar2(10) primary key,
password varchar2(10),
name varchar2(20),
age number,
gender char(1),
addr varchar2(100),
mregdate date default sysdate
)
insert into mem values('admin','1234','관리자',100,'m','하늘',default)

insert into mem values('abc040','1234','aa',100,'m','집',default)
insert into mem values('bbc','1234','aa',100,'m','집',default)
insert into mem values('dfbc','1234','aa',100,'m','집',default)
insert into mem values('qweeeeee','1234','aa',100,'m','집',default)
insert into mem values('ff2','1234','aa',100,'m','집',default)
insert into mem values('34','1234','aa',100,'m','집',default)
insert into mem values('hkjhj','1234','aa',100,'m','집',default)
insert into mem values('yuijhl','1234','aa',100,'m','집',default)
insert into mem values('ljkhc','1234','aa',100,'m','집',default)
insert into mem values('piy','1234','aa',100,'m','집',default)
insert into mem values('nl','1234','aa',100,'m','집',default)
insert into mem values('avbc','1234','aa',100,'m','집',default)
insert into mem values('mkmk','1234','aa',100,'m','집',default)
select * from mem
select * from mem order by mregdate


select rownum as rnum,A.id,A.name,A.addr,A.gender,A.age,A.mregdate
from (
select * from mem order by mregdate) A where rownum between 5 and 10

select rownum as rnum,X.id,X.password,X.name,X.addr,X.gender,X.age,X.mregdate 
from (select rownum as rnum,A.id,A.name,A.addr,A.age,A.mregdate,A.gender,A.password 
from (select * 
from mem order by mregdate)A where rownum <=10)X where X.rnum>=5



select count(*) from mem



select X.rnum,X.id,X.name,X.age,X.addr,X.gender,X.password,X.mregdate from(select rownum as rnum,A.id,A.name,A.addr,A.gender,A.age,A.mregdate,A.password from (select * from mem order by mregdate)A where rownum rownum >= 5)X where X.rnum <= 10
