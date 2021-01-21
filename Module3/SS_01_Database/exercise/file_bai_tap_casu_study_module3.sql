create database furama_resort;

use furama_resort;
drop database furama_resort; 

-- -- bảng quản lí vị trí nhân viên------
create table location_employee (
location_id int primary key ,
location_name varchar(45)
check (location_name = 'Lễ tân'
or location_name ='Phục vụ'
or location_name ='Chuyên viên'
or location_name ='Giám sát'
or location_name ='Quản Lí'
or location_name ='Giảm đốc')
);

insert into location_employee
values
(1,'Giám đốc'),
(2,'Quản lí'),
(3,'Giám sát'),
(4,'Chuyên viên'),
(5,'Phục vụ'),
(6,'Lễ tân');

select * from location_employee;

-- ---bảng quản lí trình độ nhân viên-----
create table level_employee (
level_id int primary key ,
level_name varchar(45) ,
check ( level_name = 'Sau đại học'
or level_name = 'Đại học'
or level_name = 'Cao đẳng'
or level_name = 'Trung cấp')
);

insert into level_employee
values
(1,'Sau đại học'),
(2,'Đại học'),
(3,'Cao đẳng'),
(4,'Trung cấp');

select * from level_employee;

-- --bảng quản lí bộ phận việc làm nhân viên---- 
create table part_employee (
part_id int primary key ,
part_name varchar(45) 
check(part_name ='Quản Lí'
or part_name ='Hành chính'
or part_name ='Phục vụ'
or part_name ='Sale Marketing')
);

insert into part_employee
values
(1,'Quản Lí'),
(2,'Hành chính'),
(3,'Phục vụ'),
(4,'Sale Marketing');

select * from part_employee;

-- ----bảng quản lí nhân viên-----
create table employee (
employee_id int primary key,
employee_name varchar(45) ,
location_id int ,
level_id int ,
part_id int ,
date_of_birth date ,
card_id varchar(45) , 
salary int ,
phone_number varchar(45),
email varchar(45) ,
address varchar(45) ,
foreign key (location_id) references location_employee(location_id),
foreign key (level_id ) references level_employee(level_id),
foreign key (part_id) references part_employee(part_id)
);

create table type_of_customer(
type_of_customer_id int primary key ,
type_of_customer_name varchar(45) 
);

create table customer(
customer_id int primary key ,
type_of_customer_id int ,
customer_name varchar(45),
date_of_birth date,
card_id varchar(45),
phone_number varchar(45),
email varchar(45),
address varchar(45),
foreign key (type_of_customer_id) references type_of_customer(type_of_customer_id)
);

create table rental_type(
rental_type_id int primary key,
rental_type_name varchar(45),
price int
);

create table type_service(
type_service_id int primary key,
type_service_name varchar(45)
);

create table service(
service_id int primary key,
service_name varchar(45),
area int,
number_floor int,
amount_people_max int,
rental_costs int,
rental_type_id int,
type_service_id int,
service_status int,
foreign key (rental_type_id) references rental_type(rental_type_id),
foreign key (type_service_id) references type_service(type_service_id)
);

create table contract(
contract_id int primary key,
employee_id int,
customer_id int,
service_id int,
contract_start_date date,
contract_end_date date,
down_payment int,
total_money int,
foreign key (employee_id) references employee(employee_id),
foreign key (customer_id) references customer(customer_id),
foreign key (service_id) references service(service_id)
);

create table accompanied_service(
accompanied_service_id int primary key ,
accompanied_service_name varchar(45) ,
price int,
unit int,
availability varchar(45)
);

create table contract_details(
contract_details_id int primary key ,
contract_id int,
accompanied_service_id int,
amount int not null,
foreign key (contract_id) references contract(contract_id),
foreign key (accompanied_service_id) references accompanied_service(accompanied_service_id)
);
