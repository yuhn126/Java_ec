declare

begin
	for i in 1..10	-- i의 값이 1일떄 부터 ~ 10일떄 까지
	loop
		dbms_output.put_line('나는 SQL이 좋아요!!');
	end loop;
	
	dbms_output.put_line('==========================');
	-- 10부터 1까지 화면 출력!
	-- for i in 10..1	반드시 최소값..최대값
	for i in reverse 1..10
	loop
		dbms_output.put_line(i);
	end loop;
	
end;
/