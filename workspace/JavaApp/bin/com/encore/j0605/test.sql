

--test.sql

drop table dept_copy;

create table dept_copy
as select * from DEPT;

select * from dept_copy;