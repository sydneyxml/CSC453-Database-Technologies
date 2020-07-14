--Ximan Liu
--CSC 453
--HW4
--Q2

drop table zipcode;

create table zipcode(
zip number(5),
city varchar(50),
state varchar(2),
latitude number,
longitude number,
timezone int,
dst number(1)
);

select * from zipcode;

