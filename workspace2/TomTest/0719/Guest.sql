
-- no,writer,email,tel,pass,contents,wdate
-- 글번호, 작성자, 이메일, 전화번호, 비밀번호, 내용, 작성일자

--guest.sql
drop table guest;

create table guest(
    no        number    primary key,
    writer    varchar2(20)  not null,
    email     varchar2(30),
    tel       varchar2(15),
    pass      varchar2(20)  not null,
    contents  varchar2(300) not null,
    wdate     date   default sysdate
);

drop sequence guest_seq;
create sequence guest_seq
       start with 1
       increment by 1
       nocycle
       nocache;

insert into guest values(
   guest_seq.nextval
   ,'siri'
   , 'jinsil@nate.com'
   , '010-8787-5536'
   , 'siri'
   , '안녕하세요. 저는 siri입니다.'
   , sysdate
);

select * from guest;