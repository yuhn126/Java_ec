

-- reply.sql

drop table reply;

create table reply(
   no       number,
   name     varchar2(20),
   content  varchar2(300)
);

alter table reply
add constraint reply_pk primary key(no); 

alter table reply
modify name not null;

alter table reply
modify content not null;

drop sequence reply_seq;
create sequence reply_seq
       start with 1
       increment by 1
       nocycle
       nocache;



select * from REPLY;


delete from REPLY where no=17;
