
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

delete from guest;

insert into guest
select no, writer, email, tel, pass, contents, wdate
from guest;

-- 가장 최근에 입력한 게시글 10개 조회하기(글 번호 33 ~ 24)
select no, writer, tel, wdate, contents
from(select no, writer, tel, wdate, contents
	from guest
	order by no desc)
where rownum between 1 and 10;

/* 가장 최근에 입력한 게시글 10개 조회하기 (글번호 22번~13번)*/
select no, writer, tel, wdate, contents
from  (select no, writer, tel, wdate, contents, rownum rn
       from (select no, writer, tel, wdate, contents
             from guest
             order by no desc
             )
      )
where rn between 11 and 20;

/* 가장 최근에 입력한 게시글 10개 조회하기 (글번호 22번~13번)*/
select no, writer, tel, wdate, contents
from  (select no, writer, tel, wdate, contents, rownum rn
       from (select no, writer, tel, wdate, contents
             from guest
             order by no desc
             )
      )
where rn between 21 and 30;

/* 가장 최근에 입력한 게시글 10개 조회하기 (글번호 2번~1번)*/
select no, writer, tel, wdate, contents
from  (select no, writer, tel, wdate, contents, rownum rn
       from (select no, writer, tel, wdate, contents
             from guest
             order by no desc
             )
      )
where rn between 21 and 30;   

/* 가장 최근에 입력한 게시글 10개 조회하기 (글번호 2번~1번)*/
select no, writer, tel, wdate, contents
from  (select no, writer, tel, wdate, contents, rownum rn
       from (select no, writer, tel, wdate, contents
             from guest
             order by no desc
             )
      )
where rn between 31 and 40;



insert into guest values (guest_seq.nextval, '홍길동1', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동2', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동3', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동4', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동5', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동6', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동7', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동8', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동9', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동10', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동11', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동12', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동13', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동14', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동15', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동16', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동17', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동18', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동19', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동20', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동21', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동22', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동23', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동24', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동25', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동26', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동27', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동28', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동29', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동30', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동31', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동32', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동33', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동34', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동35', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동36', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동37', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동38', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동39', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동40', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동41', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동42', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동43', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동44', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동45', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동46', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동47', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동48', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );
insert into guest values (guest_seq.nextval, '홍길동49', 'gildong@daum.net', '010-1234-5678', '1234', '홍길동입니다.', sysdate );