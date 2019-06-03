declare
	
begin
	for dan in 3..5	
	loop
		dbms_output.put_line('<'||dan||'´Ü>');
		for i in 1..9
		loop
			dbms_output.put_line(dan||'*'||i||'='||dan*i);
			insert into gugudan (dan, i, result)
			values(dan, i, dan*i);
		end loop;
	end loop;
			
end;
/