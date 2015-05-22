
create sequence board_seq
create table board
(
num 	number primary key,
name 	varchar2(10),
title 	varchar2(100),
content varchar2(1000),
hits 	number default 0,
wdate 	date default sysdate,
attachment varchar2(50)
)

insert into board
values(board_seq.nextval,'야옹이','배고프다','야아아오오오오옹',default,default,'파일명')
select * from board

