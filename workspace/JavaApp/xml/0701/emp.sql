
-- emp.sql

-- iBatis테스트용 테이블 생성
create table empcopy
as select empno, ename, sal, deptno
from emp;