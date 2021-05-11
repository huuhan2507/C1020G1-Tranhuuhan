drop database if exists bai_tap;
create database bai_tap;
use bai_tap;

create table products(
product_id int primary key,
product_code varchar(15),
product_name varchar(45),
product_price int,
product_amount int,
product_status varchar(30)
);
insert into products
values
(1,'A-0001','LG-3',5000,60,'AAA'),
(2,'A-0002','Iphone-11',5000,60,'AAA'),
(3,'A-0003','Oppo-Reno3',5000,60,'AAA'),
(4,'A-0004','LG-2',5000,60,'AAA'),
(5,'A-0005','Iphone-12',5000,60,'AAA'),
(6,'A-0006','Samsung Note10',5000,60,'AAA'),
(7,'A-0007','Samsung Note9',5000,60,'AAA'),
(8,'A-0008','Oppo-Reno4',5000,60,'AAA'),
(9,'A-0009','Oppo-Reno5',5000,60,'AAA'),
(10,'A-0010','LG-1',5000,60,'AAA');

select *
from products
where product_name = 'Oppo-Reno3';

-- ----Task 1--------
create unique index index_product_code
on products(product_code);

explain select product_code
from products;

create index index_product_name_price
on products(product_name,product_price);

explain select product_name
from products;

explain select product_price
from products;

select *
from products
where product_name = 'Oppo-Reno3';

-- ------Task 2-----------------------
create view view_customer as
select product_code , product_name , product_price, product_status
from products;

select *
from view_customer;

update view_customer 
set product_name = 'Oppo-Reno1'
where product_code ='A-0003';

select *
from view_customer;

drop view view_customer

-- ----- Task 3 -----------------

delimiter //
create procedure select_product()
begin
select*
from products;
end;
// delimiter ;

call select_product();

delimiter //
create procedure add_product(id int,`code` varchar(15),`name` varchar(45),price int,amount int,`status` varchar(30))
begin
insert into products
values (id,`code`,`name`,price,amount,`status`);
end;
// delimiter ;

call add_product(11,'A-0011','Iphone-7',500,65,'AAA');

select*
from products;

delimiter //
create procedure edit_product(id int ,`code` varchar(15), `name` varchar(45), price int , amount int , `status` varchar(30))
begin
update products
set product_code = `code` , product_name = `name`, product_price = price , product_amount = amount , product_status = `status`
where product_id = id ;
end;
// delimiter ;


call edit_product (4,'A-0014','Iphone-6',500,65,'AAA');

select *
from products;

delimiter //
create procedure delete_product (id int)
begin
delete from products
where product_id = id;
end;
// delimiter ;

call delete_product ( 4);

select *
from products;












