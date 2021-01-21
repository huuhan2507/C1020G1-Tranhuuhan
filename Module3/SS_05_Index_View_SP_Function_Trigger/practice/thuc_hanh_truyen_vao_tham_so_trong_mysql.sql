drop database if exists thuc_hanh;
create database thuc_hanh;
use thuc_hanh;

create table customers(
customer_id int  ,
customer_name varchar(45) not null,
date_of_birth date not null,
card_id varchar(9) not null unique,
phone_number varchar(11) not null,
email varchar(45)  not null unique,
address varchar(45) not null
);
insert into customers
values
(1,'Trần Hữu Hân','1999-07-25','221546281','01669715120','huuhan2507@gmail.com','Đà Nẵng'),
(2,'Trần Hữu Hân','2000-5-24','229328213','0934902134','huuhien1104@gmail.com','Huế'),
(3,'Nguyễn Long Phin','2001-12-12','229456813','0812123591','longphin1212@gmail.com','Đà Nẵng'),
(4,'Trần Hữu Hiên','2003-1-11','229847371','0915319312','huuminh1107@gmail.com','Quảng Trị'),
(5,'Nguyễn Minh Hiếu','1999-7-11','229243154','0983472213','minhhieu1107@gmail.com','Quảng Nam'),
(6,'Lê Xuân Sang','2001-6-11','229834212','0915983214','xuansang16@gmail.com','Vinh'),
(7,'Lê Minh Tân','1997-9-15','228123149','0912369133','minhtan09@gmail.com','Quảng Nam'),
(8,'Nguyễn Cao Bình','1986-4-18','243199123','0915961239','caobinh19@gmail.com','Quảng Trị');

DELIMITER //

create procedure findCustomers(in find_customer varchar(30))
begin
  select * 
  from customers
  where customer_name like (concat('% ','% ','%',find_customer,'%'));
end //
DELIMITER ;

call findCustomers('i');


