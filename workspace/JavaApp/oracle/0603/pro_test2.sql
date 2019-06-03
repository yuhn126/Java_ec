create or replace procedure del_ename(delName in varchar2)

is
	-- 변수 선언
	total number;
	cnt number;
begin
	-- 사원이름 존재 유(1) 무(0) 조회
	select count(ename) into cnt
	from emp2
	where ename = delName;
	
	if (cnt > 0)
		then /*존재한다면*/
			delete from emp2
			where ename =  upper(delName);
			
			commit;
			
			select count(*) into total from emp2;
			dbms_output.put_line('#'||delName||'사원이 삭제되었고 총 사원수는 '||total||'명 입니다.');
		else
			select count(*) into total from emp2;
			dbms_output.put_line('#'||delName||'사원은 존재하지 않고 총 사원수는 '||total||'명 입니다.');
	end if;
	
	/*
	delete from emp2
	where ename = delName;
	
	commit;
	
	--select count(*)cnt from emp;
	select count(*) into total from emp2;
	
	
	dbms_output.put_line('#'||exName||'사원이 삭제되었고 총 사원수는 '||total||'명 입니다.');
	*/
end;
/

show errors;