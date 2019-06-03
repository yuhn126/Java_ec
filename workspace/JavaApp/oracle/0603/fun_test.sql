create or replace function call_bonus(vename emp.ename%type)
return number
is
	--���� ����
	sal emp.sal%type;
	bonus number;
begin
	select sal into sal
		-- �÷���		������
	from emp
	where ename = vename;
	-- select���� ';'���� �� �÷����� ������� �������� ���´�.
	-- select�� �׾ �������� �����!
	
	-- ���ʽ� ���
	bonus := sal*2;
	
	return bonus;

end;
/

create or replace function call_bonus2(vename emp.ename%type, percent number)
return number
is
	--���� ����
	sal emp.sal%type;
	bonus number;
begin
	select sal into sal
		-- �÷���		������
	from emp
	where ename = vename;
	-- select���� ';'���� �� �÷����� ������� �������� ���´�.
	-- select�� �׾ �������� �����!
	
	-- ���ʽ� ���
	bonus := sal*(percent/100);
	
	return bonus;

end;
/