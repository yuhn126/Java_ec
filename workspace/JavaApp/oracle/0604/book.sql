
-- book.sql
drop table book;

create table book(
  publisher varchar2(20),
  book_type varchar2(10),
  book_name varchar2(30),
  price     number
);


insert into book values ('문학동네', '소설', '기사단장 죽이기', 19000);
insert into book values ('문학동네', '소설', '내게 무해한 사람', 29000);
insert into book values ('문학동네', '소설', '연금술사', 25000);
insert into book values ('문학동네', '소설', '바깥은 여름', 17000);
insert into book values ('문학동네', '시', '아주 오래된 동네', 24000);
insert into book values ('문학동네', '시', '당신이 있다면', 22000);
insert into book values ('문학동네', '시', '지금 여기가 맨 앞', 20000);
insert into book values ('문학동네', '시', '최선은 그런 것이에요', 28000);
insert into book values ('문학동네', '에세이', '연필로 쓰기', 17000);
insert into book values ('문학동네', '에세이', '장수 고양이의 비밀', 22000);
insert into book values ('문학동네', '에세이', '읽다', 23000);
insert into book values ('문학동네', '에세이', '자전거여행', 19000);
insert into book values ('엔코아출판사', '교과서', '초등수학', 22000);
insert into book values ('엔코아출판사', '교과서', '초등영어', 23000);
insert into book values ('엔코아출판사', '교과서', '초등국어', 21000);
insert into book values ('엔코아출판사', '교과서', '중등수학', 25000);
insert into book values ('엔코아출판사', '교과서', '중등영어', 23000);
insert into book values ('엔코아출판사', '교과서', '중등국어', 26000);
insert into book values ('엔코아출판사', '교과서', '고등수학', 31000);
insert into book values ('엔코아출판사', '참고서', '국어참고', 30000);
insert into book values ('엔코아출판사', '참고서', '영어참고', 29000);
insert into book values ('엔코아출판사', '참고서', '수학참고', 19000);
insert into book values ('엔코아출판사', '참고서', '물리참고', 29000);
insert into book values ('엔코아출판사', '참고서', '화학참고', 28000);

select * from BOOK;


select *
from BOOK, (select rownum 
            from BOOK
            where rownum < 5);


-- rn이 2인 페이지와 rn이 3인 페이지의 합계 구하기      
-- 전체 도서의 총합계,  출판사별 합계(소계)      
select decode(rn, 2, '합계', 3, publisher||' 소계', publisher) "출판사", sum(price)
from BOOK, (select rownum rn
                 from BOOK
                 where rownum < 5)
group by decode(rn,2,'합계',3,publisher||' 소계', publisher)
order by decode(rn,2,'합계',3,publisher||' 소계', publisher);

-- 책의 종류별 합계(소계)
select decode(rn,2,'합계',3,publisher||' 소계', publisher) "출판사", 
        decode(rn,1,book_type||' 소계',4, book_type) "종류",
        sum(price) "가격"
from BOOK, (select rownum rn
            from BOOK
            where rownum < 5)
group by decode(rn,2,'합계',3,publisher||' 소계', publisher),
            decode(rn,1,book_type||' 소계',4, book_type)
order by decode(rn,2,'합계',3,publisher||' 소계', publisher);


select decode(rn,2,'합계',3,publisher||' 소계', publisher) "출판사", 
       decode(rn,1,book_type||' 소계',4, book_type) "종류",
       decode(rn,4,book_name)"책명",
    sum(price) "가격"
from BOOK, (select rownum rn
            from BOOK
            where rownum < 5)
group by decode(rn,2,'합계',3,publisher||' 소계', publisher),
         decode(rn,1,book_type||' 소계',4, book_type),
         decode(rn,4,book_name)
order by decode(rn,2,'합계',3,publisher||' 소계', publisher);








