declare
	su1 number;
	su2 number := 10;
begin
	su1 := 13;
	-- ':=' PL/SQL내에서 대입연산자

	if(su1<su2)
		then dbms_output.put_line(su1||'은 '||su2||'보다 작다!');
	end if;
	
	if su1 >= su2
		then dbms_output.put_line(su1||'은 '||su2||'보다 크거나 같다!');
	end if;
	
end;
/
