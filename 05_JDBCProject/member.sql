-- 1)데이터 정의 언어(DDL)스키마  : create,alter,drop
-- 2)데이터 조작 언어(DML)인스턴스: insert,update(행 내에서 일부만 수정),delete(행삭제),select(검색)
-- 3)데이터 제어 언어(DCL) : grant(권한부여),revoke(권한해제)

create table member
(
id 			varchar2(10) primary key,--문자열(가변길이)
password 	varchar2(10),
name 		varchar2(20),
age 		number,
gender 		char(1),
addr 		varchar2(100),
regdate 	date default sysdate--오늘날짜
)
select * from member

insert into member
values('test','1234','야옹이',20,'1','서울시 구로구','2015-04-17')

insert into member(id,password,name,age,gender,addr)
values('test1','1234','야옹이',20,'1','서울시 구로구')

update MEMBER
set addr = '인천'
where id = 'test1'

drop table member

