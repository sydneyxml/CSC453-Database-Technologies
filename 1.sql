--Ximan Liu
--CSC 453
--HW4
--Q1

drop table Restaurant cascade constraints;
drop table Reviewer cascade constraints;
drop table Rating cascade constraints;
drop table Restaurant_Locations cascade constraints;


create table Restaurant(rID int, name varchar2(100), address varchar2(100), cuisine varchar2(100));
create table Reviewer(vID int, name varchar2(100));
create table Rating(rID int, vID int, stars int, ratingDate date);


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


insert into Rating values( 101, 2001,2, to_DATE ('2011-01-22','yyyy-mm-dd'));
insert into Rating values( 101, 2001,4, to_DATE ('2011-01-27');
insert into Rating values( 106, 2002,4, null);
insert into Rating values( 103, 2003,2, to_DATE ('2011-01-20','yyyy-mm-dd'));
insert into Rating values( 108, 2003,4, to_DATE ('2011-01-12','yyyy-mm-dd'));
insert into Rating values( 108, 2003,2, to_DATE ('2011-01-30','yyyy-mm-dd'));
insert into Rating values( 101, 2004,3, to_DATE ('2011-01-09','yyyy-mm-dd'));
insert into Rating values( 103, 2005,3, to_DATE ('2011-01-27','yyyy-mm-dd'));
insert into Rating values( 104, 2005,2, to_DATE ('2011-01-22','yyyy-mm-dd'));
insert into Rating values( 108, 2005,4, null);
insert into Rating values( 107, 2006,3, to_DATE ('2011-01-15','yyyy-mm-dd'));
insert into Rating values( 106, 2006,5, to_DATE ('2011-01-19','yyyy-mm-dd'));
insert into Rating values( 107, 2007,5,to_DATE ('2011-01-20','yyyy-mm-dd'));
insert into Rating values( 104, 2008,3, to_DATE ( '2011-01-02','yyyy-mm-dd'));


select * from Restaurant;
select * from Reviewer;
select * from Rating;


create table Restaurant_Locations(
rID number,
name varchar(100),
street_address varchar(100),
city varchar(100),
state varchar(2),
zipcode number(5),
cusine varchar(100)
);


declare
r Restaurant_Locations.rID%TYPE;
n Restaurant_Locations.name%TYPE;
sa Restaurant_Locations.street_address%TYPE;
ci Restaurant_Locations.city%TYPE;
st Restaurant_Locations.state%TYPE;
z Restaurant_Locations.zipcode%TYPE;
cu Restaurant_Locations.cusine%TYPE;

cursor cursor1 is
    select rID,name,regexp_substr(address,'[0-9]{1,} [A-Z]{1,} [A-Z][a-z]{1,} [A-Z][a-z]{1,}') as street_address,
    regexp_substr(address,'\w+',1,5) as city,
    regexp_substr(address,'\w+',1,6) as state,
    regexp_substr(address,'\w+',1,7) as zip,cuisine
    from Restaurant;
begin
open cursor1;
loop
    fetch cursor1 INTO r, n, sa, ci, st, z, cu;
    exit when cursor1%notfound;
    insert into
    Restaurant_Locations(rID,name,street_Address,city,state,zipcode,cusine)
    values(r, n, sa, ci, st, z, cu);
end loop;
close cursor1;
end;
/

select * from Restaurant_Locations;

