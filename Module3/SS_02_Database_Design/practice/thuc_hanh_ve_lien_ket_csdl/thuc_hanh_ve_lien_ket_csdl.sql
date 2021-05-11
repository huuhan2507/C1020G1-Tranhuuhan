drop database if exists thuc_hanh;
create database thuc_hanh;

use thuc_hanh;

create table productlines(
product_line int primary key ,
text_description varchar(45),
html_description varchar(45),
image varchar(45)
);

create table products(
product_code int primary key,
product_name varchar(45),
price int,
product_line int,
foreign key (product_line) references productlines(product_line)
);

create table offices(
office_code int primary key,
city varchar(45),
phone varchar(11),
country varchar(45)
);


create table employees(
employee_number int primary key ,
last_name varchar(15),
first_name varchar(15),
email varchar(45),
office_code int,
foreign key (office_code) references offices(office_code)
);

create table customers(
customer_number int primary key,
customer_name varchar(45),
phone varchar(11),
city varchar(45),
country varchar(45),
employee_number int,
foreign key (employee_number) references employees(employee_number)
);

create table orders(
order_number int primary key,
order_date date,
status varchar(45),
customer_number int,
foreign key (customer_number) references customers(customer_number)
);

create table order_details(
order_number int  ,
product_code int,
price_each int,
order_line_number int,
primary key(order_number, product_code),
foreign key (product_code) references products(product_code),
foreign key (order_number) references orders(order_number)
);

create table payments(
customer_number int ,
check_number int,
amount int,
payment_date date,
primary key (customer_number,check_number),
foreign key(customer_number) references customers(customer_number)
);









