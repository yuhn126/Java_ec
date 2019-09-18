

-- reply.sql

drop table reply0802;

create table reply0802(
   no       number,
   name     varchar2(20),
   content  varchar2(300)
);

alter table reply0802
add constraint reply_pk primary key(no); 

alter table reply0802
modify name not null;

alter table reply0802
modify content not null;

drop sequence reply0802_seq;
create sequence reply_seq
       start with 1
       increment by 1
       nocycle
       nocache;



select * from reply0802;

insert

delete from reply0802 where no=17;
