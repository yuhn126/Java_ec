/* MOVIE */
DROP TABLE Movie 
	CASCADE CONSTRAINTS;

/* MOVIE */
CREATE TABLE Movie (
	movieCode NUMBER NOT NULL, /* 영화코드 */
	movieTitle VARCHAR2(100) NOT NULL, /* 영화제목 */
	director VARCHAR2(100) NOT NULL, /* 감독 */
	actors VARCHAR2(30) NOT NULL, /* 출연자 */
	ganre VARCHAR2(100) NOT NULL, /* 장르 */
	filmRate NUMBER DEFAULT 0 NOT NULL, /* 등급 */
	openingDate DATE, /* 개봉일 */
	runningTime NUMBER, /* 상영시간 */
	stock NUMBER NOT NULL, /* 재고 */
	image VARCHAR2(25) /* 영화이미지 */
);

ALTER TABLE Movie
	ADD
		CONSTRAINT PK_Movie
		PRIMARY KEY (
			movieCode
		);
		

		
/* MEMBERSHIP */
DROP TABLE Membership 
	CASCADE CONSTRAINTS;

/* MEMBERSHIP */
CREATE TABLE Membership (
	memberCode NUMBER NOT NULL, /* 회원번호 */
	memberId VARCHAR2(20) NOT NULL, /* 회원아이디 */
	memberPass VARCHAR2(20) NOT NULL, /* 비밀번호 */
	memberName VARCHAR(10) NOT NULL, /* 회원이름 */
	birth DATE NOT NULL, /* 생년월일 */
	telNum VARCHAR2(15) NOT NULL, /* 연락처 */
	rentalNum NUMBER NOT NULL /* 대여가능횟수 */
);

ALTER TABLE Membership
	ADD
		CONSTRAINT PK_Membership
		PRIMARY KEY (
			memberCode
		);

		
		
		
/* RENTAL */
DROP TABLE Rental 
	CASCADE CONSTRAINTS;

/* RENTAL */
CREATE TABLE Rental (
	rentalCode NUMBER NOT NULL, /* 대여번호 */
	movieCode NUMBER NOT NULL, /* 영화코드 */
	memberCode NUMBER NOT NULL, /* 회원번호 */
	rentalDate DATE NOT NULL, /* 대여일 */
	COL DATE /* 반납일 */
);

ALTER TABLE Rental
	ADD
		CONSTRAINT PK_Rental
		PRIMARY KEY (
			rentalCode
		);

ALTER TABLE Rental
	ADD
		CONSTRAINT FK_Movie_TO_Rental
		FOREIGN KEY (
			movieCode
		)
		REFERENCES Movie (
			movieCode
		);

ALTER TABLE Rental
	ADD
		CONSTRAINT FK_Membership_TO_Rental
		FOREIGN KEY (
			memberCode
		)
		REFERENCES Membership (
			memberCode
		);
		
drop sequence rental_seq;
create sequence rental_seq
       start with 1001
       increment by 1
       nocycle
       nocache;
       
 -- 시퀀스 쓸 때 : rental_seq.nextval
       
       
SELECT * FROM ALL_TRIGGERS
WHERE TRIGGER_NAME = 'minus_renNum';
       
drop trigger minus_renNum;
drop trigger plus_renNum;
drop trigger minus_stock;
drop trigger plus_stock;
       
-- 트리거 (대여시 회원 대여 가능횟수 +-)
--(대여)
create or replace trigger minus_renNum
after insert on Rental
for each row
begin
	update Membership set rentalNum=rentalNum-1
	where memberCode = :new.memberCode;
end;
/

--(반납)
create or replace trigger plus_renNum
after update on Rental
for each row --행트리거
begin
	update Membership set rentalNum=rentalNum+1
	where memberCode = :old.memberCode;
end;
/     


-- 트리거(대여시 dvd 재고+-) 
--(대여)
create or replace trigger minus_stock
after insert on Rental
for each row --행트리거
begin
	update Movie set stock=stock-1
	where movieCode = :new.movieCode;
end;
/

--(반납)
create or replace trigger plus_stock
after update on Rental
for each row --행트리거
begin
	update Movie set stock=stock+1
	where movieCode = :old.movieCode;
end;
/

delete from MOVIE;
delete from Membership;
delete from RENTAL;

select * from movie;

insert into MOVIE (movieCode,movieTitle,director,actors,ganre,filmRate,openingDate,runningTime,stock,image)
values (19980231,'트루먼쇼(the truman Show)','피터 위어','시리언니','드라마/로맨스',12,'1992-11-11',125, 5, null);

insert into MOVIE (movieCode,movieTitle,director,actors,ganre,filmRate,openingDate,runningTime,stock,image)
values (20184621,'엑시트(EXIT)','이상근','조정석,윤아','드라마/로맨스',12,'1992-11-11',125, 5, null);

insert into Membership (memberCode, memberId, memberPass, memberName, birth, telNum, rentalNum)
values (1234, 'gildong', 'a1234', '홍길동', '1992-11-11', '010-1111-1111', 3);

insert into RENTAL (rentalCode, movieCode, memberCode, rentalDate, returnDate)
values (rental_seq.nextval, 19980231, 1234, sysdate, sysdate+7);