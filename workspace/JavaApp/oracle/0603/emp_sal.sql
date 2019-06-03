declare
	vempno emp.empno%type;
	vename emp.ename%type;
	vsal emp.sal%type;
	vcomm emp.comm%type;
	annsal number(10);
	
begin
	select empno, ename, sal, comm into vempno, vename, vsal, vcomm
	from emp
	where empno = 7499;
	
	-- annsal := vsal*12+vcomm;
	-- scott사원 경우   : 3000*12+null	--> null
	-- martin사원 경우 : 3000*12+1400	--> 16400
	
	if(vcomm is null)
		then
			annsal := vsal*12+0;
		else
			annsal := vsal*12+vcomm;
	end if;
	
	dbms_output.put_line('사번 '||vempno||'은 '||vename||'사원이고 연봉은 '||annsal||'입니다.');
end;
/