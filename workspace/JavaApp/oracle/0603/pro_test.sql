-- create 
create or replace procedure del_dept(delNo in number, tomorrow out varchar2)
-- ���� ���� variable tom varchar2(15);
-- ���ε� ����(���� ����) ��� ==> :������
-- ȣ��? exec del_dept(40, :tom)
-- Ȯ�� print tom;
is
	-- ����ο��� ����� ���� ����!
begin
	--tomorrow := to_char(sysdate,'dy');
	/*
	  delete from dept3
	  where deptno = 40;
	  dbms_output.put_line('#40�� �μ��� �����Ͽ����ϴ�.');
	*/
	
	delete from dept3
	where deptno = delNo;
	dbms_output.put_line('#'||delNo||'�� �μ��� �����Ͽ����ϴ�.');
	
	commit;
	
	select to_char(sysdate,'day') into tomorrow
	from dual;
	
	
end;
/

show error; -- ������ ������ ���� ������ ������ 