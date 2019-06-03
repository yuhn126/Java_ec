declare
	vempno number(4);
	vename varchar2(15);
	vcomm emp.comm%type;

begin
	select empno, ename, comm into vempno, vename, vcomm
	from emp
	where empno = 7844;
	
	if(vcomm>0)
		then
			dbms_output.put_line('사번'||vempno||'은 '||vename||'사원이고 커미션을 '||vcomm||' 받습니다.');
		else
			dbms_output.put_line('사번'||vempno||'은 '||vename||'사원이고 커미션을 받지 않습니다.');
	end if;
	
end;
/