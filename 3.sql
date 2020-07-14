--Ximan Liu
--CSC 453
--HW4
--Q3


drop table Restaurant;
drop table Reviewer;
drop table Rating;


drop table RatingData;
drop table TopFood;


drop trigger t1;
drop trigger t2;


create table Restaurant(RID int, name varchar2(100), address varchar2(100), cuisine varchar2(100));
create table Reviewer(VID int, name varchar2(100));
create table Rating(RID int, VID int, stars int, ratingDate date);


insert into Restaurant values(101, 'India House Restaurant', '59 W Grand Ave Chicago, IL 60654', 'Indian');
insert into Restaurant values(102, 'Bombay Wraps', '122 N Wells St Chicago, IL 60606', 'Indian');
insert into Restaurant values(103, 'Rangoli', '2421 W North Ave Chicago, IL 60647', 'Indian');
insert into Restaurant values(104, 'Cumin', '1414 N Milwaukee Ave Chicago, IL 60622', 'Indian');
insert into Restaurant values(105, 'Shanghai Inn', '4723 N Damen Ave Chicago, IL 60625', 'Chinese');
insert into Restaurant values(106, 'MingHin Cuisine', '333 E Benton Pl Chicago, IL 60601', 'Chinese');
insert into Restaurant values(107, 'Shanghai Terrace', '108 E Superior St Chicago, IL 60611', 'Chinese');
insert into Restaurant values(108, 'Jade Court', '626 S Racine Ave Chicago, IL 60607', 'Chinese');


insert into Reviewer values(2001, 'Sarah M.');
insert into Reviewer values(2002, 'Daniel L.');
insert into Reviewer values(2003, 'B. Harris');
insert into Reviewer values(2004, 'P. Suman');
insert into Reviewer values(2005, 'Suikey S.');
insert into Reviewer values(2006, 'Elizabeth T.');
insert into Reviewer values(2007, 'Cameron J.');
insert into Reviewer values(2008, 'Vivek T.');


insert into Rating values( 101, 2001,2, DATE '2011-01-22');
insert into Rating values( 101, 2001,4, DATE '2011-01-27');
insert into Rating values( 106, 2002,4, null);
insert into Rating values( 103, 2003,2, DATE '2011-01-20');
insert into Rating values( 108, 2003,4, DATE '2011-01-12');
insert into Rating values( 108, 2003,2, DATE '2011-01-30');
insert into Rating values( 101, 2004,3, DATE '2011-01-09');
insert into Rating values( 103, 2005,3, DATE '2011-01-27');
insert into Rating values( 104, 2005,2, DATE '2011-01-22');
insert into Rating values( 108, 2005,4, null);
insert into Rating values( 107, 2006,3, DATE '2011-01-15');
insert into Rating values( 106, 2006,5, DATE '2011-01-19');
insert into Rating values( 107, 2007,5, DATE '2011-01-20');
insert into Rating values( 104, 2008,3, DATE '2011-01-02');

 
create or replace procedure plusreview (vID in number) 
as begin
insert into reviewer VALUES(vID, 'Sarah M.');
end;
/
begin
plusreview(2017);
end; 


create table RatingData(
RestaurantName varchar(50),
UserName varchar(50),
Rating number(1),
RatingDate Date
); 

 
insert into RatingData values ('Jade Court','Sarah M.', 4, DATE '2017-08-17');
insert into RatingData values ('Shanghai Terrace','Cameron J.', 5, DATE '2017-08-17');
insert into RatingData values ('Rangoli','Vivek T.', 3, DATE '2017-09-17');
insert into RatingData values ('Shanghai Inn','Audrey M.',2, DATE '2017-07-08');
insert into RatingData values ('Cumin','Cameron J.', 2, DATE '2017-09-17');


select * from RatingData;


create or replace procedure insertdata(
rname in RatingData.RestaurantName%type,
uname in RatingData.UserName%type,
rate in RatingData.Rating%type,
rdate in RatingData.RatingDate%type)
as
begin
insert into Rating values (
(select rID from Restaurant, RatingData
where Restaurant.name = RatingData.RestaurantName),
(select vID from Reviewer, RatingData
where Reviewer.name = RatingData.UserName), rate, rdate);
end;
/


create table TopFood(rID int);

create or replace package squad is
tier1 int; tier2 int; tier3 int; tier4 int; tier5 int; 
end;
/


set serveroutput on;
create or replace trigger t1
before insert on Rating
for each row
begin
select rID into squad.tier1 from (
select ROW_NUMBER() over(order by stars desc, RatingDate desc) as row#, 
rID, stars, RatingDate
from Rating where RatingDate is not null)
where row# = 1; 
select rID into squad.tier2 from (
select ROW_NUMBER() over(order by stars desc, RatingDate desc) as row#, 
rID, stars, RatingDate
from Rating where RatingDate is not null)
where row# = 2;
select rID into squad.tier3 from (
select ROW_NUMBER() over(order by stars desc, RatingDate desc) as row#, 
rID, stars, RatingDate
from Rating where RatingDate is not null)
where row# = 3;
select rID into squad.tier4 from (
select ROW_NUMBER() over(order by stars desc, RatingDate desc) as row#, 
rID, stars, RatingDate
from Rating where RatingDate is not null)
where row# = 4;
select rID into squad.tier5 from (
select ROW_NUMBER() over(order by stars desc, RatingDate desc) as row#, 
rID, stars, RatingDate
from Rating where RatingDate is not null)
where row# = 5;
end;
/


create or replace trigger t2
before insert on Rating
for each row
begin
insert into TopFood (rID) values (squad.tier1);
insert into TopFood (rID) values (squad.tier2);
insert into TopFood (rID) values (squad.tier3);
insert into TopFood (rID) values (squad.tier4);
insert into TopFood (rID) values (squad.tier5);
end;
/


insert into Rating values (101, 2001, 4, DATE '2017-08-17');
insert into Rating values (107, 2007, 5, DATE '2017-08-17');
insert into Rating values (103, 2008, 3, DATE '2017-09-17');
insert into Rating values (109, 2009, 2, DATE '2017-07-08');
insert into Rating values (104, 2007, 2, DATE '2017-09-17');


select distinct * from TopFood;

