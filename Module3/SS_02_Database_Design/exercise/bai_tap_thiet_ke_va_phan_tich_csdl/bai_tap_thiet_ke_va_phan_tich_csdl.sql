drop database if exists bai_tap;
create database bai_tap;

use bai_tap;

create table productlines(
product_line int primary key ,
text_description varchar(50) not null,
html_description varchar(45),
image varchar(45)
);

create table products(
product_code varchar(15) primary key,
product_name varchar(70) not null ,
productScale varchar(10) not null,
price int,
product_line int,
foreign key (product_line) references productlines(product_line)
);

create table offices(
office_code int primary key,
city varchar(45) not null,
phone varchar(11) not null,
country varchar(45) not null
);


create table employees(
employee_number int primary key ,
last_name varchar(15) not null,
first_name varchar(15) not null,
email varchar(45) unique not null,
office_code int not null,
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
order_number int,
product_code varchar(15),
price_each int ,
order_line_number int,
primary key(order_number, product_code),
foreign key (product_code) references products(product_code),
foreign key (order_number) references orders(order_number)
);

create table payments(
customer_number int ,
check_number int,
amount int not null,
payment_date date not null,
primary key (customer_number,check_number),
foreign key(customer_number) references customers(customer_number)
);









