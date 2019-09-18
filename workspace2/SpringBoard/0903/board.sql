

-- board.sql

-- 자식테이블 삭제, 부모테이블 삭제
-- 부모테이블 생성, 자식테이블 생성
-- 부모테이블 제약추가, 자식테이블 제약추가

--//bno,title,content,writer,regdate,updatedate
drop table tbl_board;
create table tbl_board
(
   bno         number,  --글번호
   title      varchar2(200)  not null,--글제목
   content    varchar2(2000) not null,--글내용
   writer     varchar2(50)   not null,--작성자
   regdate      date  default sysdate, --작성일자
   updatedate   date  default sysdate--수정일자
);

alter table tbl_board
add (replycnt number default 0);

update tbl_board set replycnt = (select count(*) from tbl_reply
								  where TBL_REPLY.bno = TBL_BOARD.bno);

alter table tbl_board
add constraint board_pk primary key(bno);

drop sequence tbl_board_seq;

create sequence tbl_board_seq
       start with 1
       increment by 1
       nocycle
       nocache;
       
select * from TBL_BOARD;

insert into tbl_board(bno, title, content, writer, regdate)
select tbl_board_seq.nextval,title, content, writer, sysdate from tbl_board











