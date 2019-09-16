
create table tbl_reply(
	rno number(10,0),
	bno number(10,0) not null,
	reply varchar2(1000) not null,
	replyer varchar2(50) not null,
	replyDate date default sysdate,
	updateDate date default sysdate
);

create sequence reply_seq
		start with 1
		increment by 1
		nocycle
		nocache;
		
alter table tbl_reply drop constraint reply_pk
alter table tbl_reply add constraint reply_pk2 primary key (rno);
alter table tbl_reply add constraint reply_bno_fk
	  foreign key(bno) reference tbl_board(bno);

	  
select * from TBL_REPLY