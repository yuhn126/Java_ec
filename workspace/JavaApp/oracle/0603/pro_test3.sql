create or replace procedure del_ename(delName in varchar2)

is
	-- ���� ����
	total number;
	cnt number;
begin
	-- ����̸� ���� ��(1) ��(0) ��ȸ
	select count(ename) into cnt
	from emp2
	where ename = delName;
	
	if (cnt > 0)
		then /*�����Ѵٸ�*/
			delete from emp2
			where ename =  upper(delName);
			
			commit;
			
			select count(*) into total from emp2;
			dbms_output.put_line('#'||delName||'����� �����Ǿ��� �� ������� '||total||'�� �Դϴ�.');
		else
			select count(*) into total from emp2;
			dbms_output.put_line('#'||delName||'����� �������� �ʰ� �� ������� '||total||'�� �Դϴ�.');
	end if;
	
	/*
	delete from emp2
	where ename = delName;
	
	commit;
	
	--select count(*)cnt from emp;
	select count(*) into total from emp2;
	
	
	dbms_output.put_line('#'||exName||'����� �����Ǿ��� �� ������� '||total||'�� �Դϴ�.');
	*/
end;
/

show errors;