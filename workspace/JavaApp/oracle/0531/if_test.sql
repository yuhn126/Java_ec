declare
	su1 number;
	su2 number := 10;
begin
	su1 := 13;
	-- ':=' PL/SQL������ ���Կ�����

	if(su1<su2)
		then dbms_output.put_line(su1||'�� '||su2||'���� �۴�!');
	end if;
	
	if su1 >= su2
		then dbms_output.put_line(su1||'�� '||su2||'���� ũ�ų� ����!');
	end if;
	
end;
/
