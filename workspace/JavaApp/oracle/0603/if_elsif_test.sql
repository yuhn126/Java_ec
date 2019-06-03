declare
	vempno emp.empno%type;
	vename emp.ename%type;
	vdeptno emp.deptno%type;
	vdname dept.dname%type;
begin
	vempno := 7654;
	
	select ename, deptno into vename, vdeptno
	from emp
	where empno = vempno;
	
	if(vdeptno = 10)
		then vdname := 'ACCOUNTING';
		elsif(vdeptno = 20)
			then vdname := 'RESEARCH';
		elsif(vdeptno = 30)
			then vdname := 'SALES';
		else
			vdname := 'OPERATIONS';
	end if;
			
			
	dbms_output.put_line('사번'||vempno||'은 '||vename||'사원이고 '||vdname||'부서에서 일합니다.');

end;
/