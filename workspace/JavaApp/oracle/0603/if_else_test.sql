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
			dbms_output.put_line('���'||vempno||'�� '||vename||'����̰� Ŀ�̼��� '||vcomm||' �޽��ϴ�.');
		else
			dbms_output.put_line('���'||vempno||'�� '||vename||'����̰� Ŀ�̼��� ���� �ʽ��ϴ�.');
	end if;
	
end;
/