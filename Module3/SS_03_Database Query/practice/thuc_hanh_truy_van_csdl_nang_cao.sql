drop database if exists thuc_hanh;
create database thuc_hanh;

use thuc_hanh;

create table productlines (
    product_line varchar(50) primary key,
    text_description varchar(50),
    html_description varchar(50),
    image varchar(50)
);
insert into productlines
values
('ABC','ABC','ABC','ABC'),
('ABD','ABC','ABC','ABC'),
('ABE','ABC','ABC','ABC'),
('ABF','ABC','ABC','ABC');

create table products (
    product_code int primary key,
    product_name varchar(50),
    product_line varchar(50),
    buy_price int,
    foreign key (product_line)
        references productlines (product_line)
);
insert into products
values
(1,'AAA','ABC',51),
(2,'BBB','ABD',25),
(3,'CCC','ABF',49),
(4,'DDD','ABC',71),
(5,'FFF','ABE',91);

select 
    *
from
    products
where
    buy_price >= 50 and buy_price <= 90;

select 
    *
from
    products
where
    product_name = 'AAA'
        or product_name = 'CCC';
        
select*
from products
inner join productlines
on products.product_line =productlines.product_line
where buy_price <=50;
