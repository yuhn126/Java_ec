
-- book.sql
drop table book;

create table book(
  publisher varchar2(20),
  book_type varchar2(10),
  book_name varchar2(30),
  price     number
);


insert into book values ('���е���', '�Ҽ�', '������ ���̱�', 19000);
insert into book values ('���е���', '�Ҽ�', '���� ������ ���', 29000);
insert into book values ('���е���', '�Ҽ�', '���ݼ���', 25000);
insert into book values ('���е���', '�Ҽ�', '�ٱ��� ����', 17000);
insert into book values ('���е���', '��', '���� ������ ����', 24000);
insert into book values ('���е���', '��', '����� �ִٸ�', 22000);
insert into book values ('���е���', '��', '���� ���Ⱑ �� ��', 20000);
insert into book values ('���е���', '��', '�ּ��� �׷� ���̿���', 28000);
insert into book values ('���е���', '������', '���ʷ� ����', 17000);
insert into book values ('���е���', '������', '��� ������� ���', 22000);
insert into book values ('���е���', '������', '�д�', 23000);
insert into book values ('���е���', '������', '�����ſ���', 19000);
insert into book values ('���ھ����ǻ�', '������', '�ʵ����', 22000);
insert into book values ('���ھ����ǻ�', '������', '�ʵ��', 23000);
insert into book values ('���ھ����ǻ�', '������', '�ʵ��', 21000);
insert into book values ('���ھ����ǻ�', '������', '�ߵ����', 25000);
insert into book values ('���ھ����ǻ�', '������', '�ߵ��', 23000);
insert into book values ('���ھ����ǻ�', '������', '�ߵ��', 26000);
insert into book values ('���ھ����ǻ�', '������', '������', 31000);
insert into book values ('���ھ����ǻ�', '����', '��������', 30000);
insert into book values ('���ھ����ǻ�', '����', '��������', 29000);
insert into book values ('���ھ����ǻ�', '����', '��������', 19000);
insert into book values ('���ھ����ǻ�', '����', '��������', 29000);
insert into book values ('���ھ����ǻ�', '����', 'ȭ������', 28000);

select * from BOOK;


select *
from BOOK, (select rownum 
            from BOOK
            where rownum < 5);


-- rn�� 2�� �������� rn�� 3�� �������� �հ� ���ϱ�      
-- ��ü ������ ���հ�,  ���ǻ纰 �հ�(�Ұ�)      
select decode(rn, 2, '�հ�', 3, publisher||' �Ұ�', publisher) "���ǻ�", sum(price)
from BOOK, (select rownum rn
                 from BOOK
                 where rownum < 5)
group by decode(rn,2,'�հ�',3,publisher||' �Ұ�', publisher)
order by decode(rn,2,'�հ�',3,publisher||' �Ұ�', publisher);

-- å�� ������ �հ�(�Ұ�)
select decode(rn,2,'�հ�',3,publisher||' �Ұ�', publisher) "���ǻ�", 
        decode(rn,1,book_type||' �Ұ�',4, book_type) "����",
        sum(price) "����"
from BOOK, (select rownum rn
            from BOOK
            where rownum < 5)
group by decode(rn,2,'�հ�',3,publisher||' �Ұ�', publisher),
            decode(rn,1,book_type||' �Ұ�',4, book_type)
order by decode(rn,2,'�հ�',3,publisher||' �Ұ�', publisher);


select decode(rn,2,'�հ�',3,publisher||' �Ұ�', publisher) "���ǻ�", 
       decode(rn,1,book_type||' �Ұ�',4, book_type) "����",
       decode(rn,4,book_name)"å��",
    sum(price) "����"
from BOOK, (select rownum rn
            from BOOK
            where rownum < 5)
group by decode(rn,2,'�հ�',3,publisher||' �Ұ�', publisher),
         decode(rn,1,book_type||' �Ұ�',4, book_type),
         decode(rn,4,book_name)
order by decode(rn,2,'�հ�',3,publisher||' �Ұ�', publisher);








