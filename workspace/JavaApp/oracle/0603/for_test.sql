declare

begin
	for i in 1..10	-- i�� ���� 1�ϋ� ���� ~ 10�ϋ� ����
	loop
		dbms_output.put_line('���� SQL�� ���ƿ�!!');
	end loop;
	
	dbms_output.put_line('==========================');
	-- 10���� 1���� ȭ�� ���!
	-- for i in 10..1	�ݵ�� �ּҰ�..�ִ밪
	for i in reverse 1..10
	loop
		dbms_output.put_line(i);
	end loop;
	
end;
/