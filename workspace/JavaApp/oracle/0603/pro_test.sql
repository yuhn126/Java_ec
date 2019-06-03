-- create 
create or replace procedure del_dept(delNo in number, tomorrow out varchar2)
-- 변수 선언 variable tom varchar2(15);
-- 바인드 변수(전달 변수) 사용 ==> :변수명
-- 호출? exec del_dept(40, :tom)
-- 확인 print tom;
is
	-- 실행부에서 사용할 변수 선언!
begin
	--tomorrow := to_char(sysdate,'dy');
	/*
	  delete from dept3
	  where deptno = 40;
	  dbms_output.put_line('#40번 부서를 삭제하였습니다.');
	*/
	
	delete from dept3
	where deptno = delNo;
	dbms_output.put_line('#'||delNo||'번 부서를 삭제하였습니다.');
	
	commit;
	
	select to_char(sysdate,'day') into tomorrow
	from dual;
	
	
end;
/

show error; -- 에러가 있으면 에러 내용을 보여줌 