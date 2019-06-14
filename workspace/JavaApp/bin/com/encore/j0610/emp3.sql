--emp3.sql

drop table emp3;

create table emp3
as select * from emp;

select * from emp3;

create table names(
 	name varchar2(15)
);

select * from names;