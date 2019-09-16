select count()

select count(*) from reply 
where memberNum=(select memberNum from article where articleNum=1)
group by productNum;