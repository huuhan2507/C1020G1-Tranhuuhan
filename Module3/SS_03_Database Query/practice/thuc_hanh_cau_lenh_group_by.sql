drop database if exists thuc_hanh;

create database thuc_hanh;

use thuc_hanh;

create table type_of_customer(
type_of_customer_id int primary key ,
type_of_customer_name varchar(15)
);

insert into type_of_customer
values
(1,'Diamond'),
(2,'Platinum'),
(3,'Gold'),
(4,'Silver'),
(5,'Member');

create table customers(
customer_number int primary key,
customer_name varchar(50),
customer_card_id varchar(10),
customer_age int,
customer_gender varchar(10),
type_of_customer_id int,
foreign key (type_of_customer_id) references type_of_customer(type_of_customer_id)
);
insert into customers
values 
(1,'Han', '221523214',18,'male',1),
(2,'Hien','229172312',19,'male',2),
(3,'Phin', '221734249',26,'male',4),
(4,'Long', '221592842',24,'male',3);

create table orders(
order_number int primary key,
order_date date,
`status` varchar(20),
customer_number int,
foreign key (customer_number) references customers(customer_number)
);
insert into orders
values
(1,'2002-5-21','AAA',1),
(2,'1999-7-22','AAB',2),
(3,'2001-9-24','ABB',3),
(4,'2002-5-26','ACC',3);

select customers.customer_name,count(orders.order_number) as amount_order
from customers
left join orders  on customers.customer_number = orders.customer_number
group by customers.customer_name;

