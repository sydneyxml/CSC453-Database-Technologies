--Ximan Liu
--CSC 453
--HW1 Q2


drop table Request;
drop table Product;
drop table FullOrder;
drop table Customer;

create table Customer (
CustomerID number(3),
Name varchar(25),
Address varchar(50),
primary key (CustomerID)
);

create table FullOrder (
OrderID number(5),
OrderDate DATE,
CustomerID number(3),

primary key (OrderID),
foreign key (CustomerID) references Customer(CustomerID)
);

create table Product (
ProductID  number(2),
Description varchar(28),
Finish varchar(10),
Price float CHECK (0 <= Price AND Price <= 999.99),
primary key (ProductID)
);

create table Request (
OrderID  number(5),
ProductID  number(2),
Quantity integer CHECK (1 <= Quantity AND Quantity <= 100),
primary key (OrderID, ProductID),
foreign key (OrderID) references FullOrder(OrderID),
foreign key (ProductID) references Product(ProductID)
);


insert into Customer
    values(002, 'CASUAL FURNITURE', 'PLANO, TX');
insert into Customer   
    values(006, 'MOUNTAIN GALLERY', 'BOULDER, CO');

insert into FullOrder
    values(1006, '24-MAR-10', 002);
insert into FullOrder
    values(1007, '25-MAR-10', 006);
insert into FullOrder
    values(1008, '25-MAR-10', 006);
insert into FullOrder
    values(1009, '26-MAR-10', 002);
    
insert into Product
    values(10, 'WRITING DESK', 'OAK', 425);
insert into Product
    values(30, 'DINING TABLE', 'ASH', 600);
insert into Product
    values(40, 'ENTERTAINMENT CENTER', 'MAPLE', 650);
insert into Product
    values(70, 'CHILDREN DRESSER', 'PINE', 300);
    
insert into Request
    values(1006, 10, 4);
insert into Request
    values(1006, 30, 2);
insert into Request
    values(1006, 40, 1);
insert into Request
    values(1007, 40, 3);
insert into Request
    values(1007, 70, 2);
insert into Request
    values(1008, 70, 1);
insert into Request
    values(1009, 10, 2);
insert into Request
    values(1009, 40, 1);
    
SELECT * FROM Customer;
SELECT * FROM FullOrder;
SELECT * FROM Product;
SELECT * FROM Request;

