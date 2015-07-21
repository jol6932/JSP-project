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
select * from mem

