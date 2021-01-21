drop database  if exists bai_tap;
create database bai_tap;

use bai_tap;

create table customer(
id int,
customer_name varchar(45),
age int 
);

alter table customer
add email varchar(45);

insert into customer 
values 
(1,'Han',18,'han@123.com'),
(2,'Thien',24,'thien12@324.com'),
(3,'Khoa',19,'khoa123@123.com');

select * from customer;

select * from customer where customer_name like ('%a%');