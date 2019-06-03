create or replace function call_bonus(vename emp.ename%type)
return number
is
	--변수 선언
	sal emp.sal%type;
	bonus number;
begin
	select sal into sal
		-- 컬럼명		변수명
	from emp
	where ename = vename;
	-- select문의 ';'끝난 후 컬럼명은 사라지고 변수명은 남는다.
	-- select는 죽어서 변수명을 남긴다!
	
	-- 보너스 계산
	bonus := sal*2;
	
	return bonus;

end;
/

create or replace function call_bonus2(vename emp.ename%type, percent number)
return number
is
	--변수 선언
	sal emp.sal%type;
	bonus number;
begin
	select sal into sal
		-- 컬럼명		변수명
	from emp
	where ename = vename;
	-- select문의 ';'끝난 후 컬럼명은 사라지고 변수명은 남는다.
	-- select는 죽어서 변수명을 남긴다!
	
	-- 보너스 계산
	bonus := sal*(percent/100);
	
	return bonus;

end;
/