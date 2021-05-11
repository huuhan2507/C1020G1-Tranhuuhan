drop database if exists furama_resort;
create database furama_resort;

use furama_resort;

-- -- Bảng Quản Lí Vị Trí Nhân Viên------
create table location_employee (
location_id int primary key ,
location_name varchar(45) not null
check (location_name = 'Lễ tân'
or location_name ='Phục vụ'
or location_name ='Chuyên viên'
or location_name ='Giám sát'
or location_name ='Quản Lí'
or location_name ='Giảm đốc')
);

-- ---Bảng Quản Lí Trình Độ Nhân Viên-----
create table level_employee (
level_id int primary key ,
level_name varchar(45) not null,
check ( level_name = 'Sau đại học'
or level_name = 'Đại học'
or level_name = 'Cao đẳng'
or level_name = 'Trung cấp')
);

-- --Bảng Quản Lí Bộ Phận Việc Làm Nhân Viên---- 
create table part_employee (
part_id int primary key ,
part_name varchar(45) not null
check(part_name ='Quản Lí'
or part_name ='Hành chính'
or part_name ='Phục vụ'
or part_name ='Sale Marketing')
);

-- -------Bảng Quản Lí Nhân Viên-------
create table employees (
employee_id int auto_increment primary key,
employee_name varchar(45) not null ,
location_id int not null ,
level_id int not null ,
part_id int not null,
date_of_birth date not null,
card_id varchar(10) unique not null , 
salary int not null,
phone_number varchar(11) not null,
email varchar(45) unique not null ,
address varchar(45) not null ,
foreign key (location_id) references location_employee(location_id),
foreign key (level_id ) references level_employee(level_id),
foreign key (part_id) references part_employee(part_id)
);

-- -------------Bảng Quản Lí Loại Khách Hàng -----------------
create table type_of_customer(
type_of_customer_id int primary key ,
type_of_customer_name varchar(45) not null
check ( type_of_customer_name = 'Diamond'
or type_of_customer_name = 'Platinum'
or type_of_customer_name = 'Gold'
or type_of_customer_name = 'Silver'
or type_of_customer_name = 'Member')
);

-- ---------Bảng Quản Lí Khách Hàng ----------------
create table customers(
customer_id int auto_increment primary key ,
type_of_customer_id int not null,
customer_name varchar(45) not null,
date_of_birth date not null,
card_id varchar(9) not null unique,
phone_number varchar(11) not null,
email varchar(45)  not null unique,
address varchar(45) not null,
foreign key (type_of_customer_id) references type_of_customer(type_of_customer_id)
);

create table rental_type(
rental_type_id int primary key,
rental_type_name varchar(45) not null,
price int not null
);

create table type_service(
type_service_id int primary key,
type_service_name varchar(45) not null
);

create table services(
service_id int primary key,
service_name varchar(45) not null,
area int not null,
number_floor int not null,
amount_people_max int not null,
rental_costs int not null,
rental_type_id int not null,
type_service_id int not null,
service_status varchar(45) not null,
foreign key (rental_type_id) references rental_type(rental_type_id),
foreign key (type_service_id) references type_service(type_service_id)
);

create table contracts(
contract_id int primary key auto_increment,
employee_id int not null,
customer_id int not null,
service_id int not null,
contract_start_date date not null,
contract_end_date date not null,
down_payment int not null,
total_money int not null,
foreign key (employee_id) references employees(employee_id),
foreign key (customer_id) references customers(customer_id),
foreign key (service_id) references services(service_id)
);

create table accompanied_service(
accompanied_service_id int primary key ,
accompanied_service_name varchar(45) ,
price int ,
unit int ,
availability varchar(45)
);

create table contract_details(
contract_details_id int primary key ,
contract_id int not null,
accompanied_service_id int not null,
amount int not null,
foreign key (contract_id) references contracts(contract_id),
foreign key (accompanied_service_id) references accompanied_service(accompanied_service_id)
);

-- ----Thêm Bảng Vị Trí Nhân Viên---- --
insert into location_employee
values
(1,'Giám đốc'),
(2,'Quản lí'),
(3,'Giám sát'),
(4,'Chuyên viên'),
(5,'Phục vụ'),
(6,'Lễ tân');

-- ----Thêm Bảng Trình Độ Nhân Viên --------
insert into level_employee
values
(1,'Sau đại học'),
(2,'Đại học'),
(3,'Cao đẳng'),
(4,'Trung cấp');

-- -----Thêm Bảng Bộ Phận Việc Làm Nhân Viên -------
insert into part_employee
values
(1,'Quản Lí'),
(2,'Hành chính'),
(3,'Phục vụ'),
(4,'Sale Marketing');

-- ---- Thêm Bảng Nhân Viên -----
insert into employees
values
(1,'Trần Hữu Hân',1,1,1,'2002-7-25','221546281',30000,'01669715120','huuhan2507@gmail.com','Đà Nẵng'),
(2,'Trần Hữu Minh',4,2,2,'1996-4-11','212324841',7000,'0921631286','huuhien1104@gmail.com','Quảng Nam'),
(3,'Nguyễn Long Thiện',3,3,3,'1999-11-19','284311322',6000,'096971544','thien26521@gmail.com','Quảng Trị'),
(4,'Nguyễn Long Phin',2,2,2,'2001-12-12','213789513',5000,'0942521263','longphin1212@gmail.com','Huế'),
(5,'Nguyễn Văn Khoa',5,2,3,'1994-9-15','261243282',3000,'0912468129','khoanguyen12@gmail.com','Phú Yên'),
(6,'Lê Văn An',3,2,3,'1997-6-15','215454845',3000,'0932719122','lean1112@gmail.com','Vinh'),
(7,'Nguyễn Hữu Nghĩa',6,2,3,'1989-7-15','229515721',3000,'0974312337','huunghia912@gmail.com','Quảng Ngãi'),
(8,'Trần Xuân Lợi',5,2,3,'1998-5-15','291324147',3000,'0961281234','xuanloi512@gmail.com','Hải Châu'),
(9,'Nguyễn Thành Trung',2,3,3,'1999-6-15','297191001',3000,'0961927372','thanhtrung98@gmail.com','Hà Nội'),
(10,'Dương Minh Tân',1,2,2,'2001-6-25','220318319',3000,'09681641413','minhtan4323@gmail.com','Hải Châu'),
(11,'Dương Minh Nhặn',2,2,3,'2002-3-5','241283475',3000,'0971233923','minhnhan123@gmail.com','Vinh'),
(12,'Đào Ngọc Lĩnh',3,2,3,'1995-9-5','261397431',3000,'0951249766','ngoclinh250@gmail.com','Hải Châu');

-- ---Thêm Bảng Loại Khách Hàng ---------
insert into type_of_customer
values 
(1,'Diamond'),
(2,'Platinum'),
(3,'Gold'),
(4,'Silver'),
(5,'Member');

-- ----Thêm Bảng Khách Hàng -------
insert into customers
values
(1,1,'Trần Hữu Hân','1999-07-25','221546281','01669715120','huuhan2507@gmail.com','Đà Nẵng'),
(2,2,'Trần Hữu Hân','2000-5-24','229328213','0934902134','huuhien1104@gmail.com','Huế'),
(3,2,'Nguyễn Long Phin','2001-12-12','229456813','0812123591','longphin1212@gmail.com','Đà Nẵng'),
(4,3,'Trần Hữu Hiên','2003-1-11','229847371','0915319312','huuminh1107@gmail.com','Quảng Trị'),
(5,1,'Nguyễn Minh Hiếu','1999-7-11','229243154','0983472213','minhhieu1107@gmail.com','Quảng Nam'),
(6,1,'Lê Xuân Sang','2001-6-11','229834212','0915983214','xuansang16@gmail.com','Vinh'),
(7,1,'Lê Minh Tân','1997-9-15','228123149','0912369133','minhtan09@gmail.com','Quảng Nam'),
(8,2,'Nguyễn Cao Bình','1986-4-18','243199123','0915961239','caobinh19@gmail.com','Quảng Trị');

-- ----Thêm Dịch Vụ Đi Kèm --------
insert into accompanied_service
values
(1,'Message',300,1,'ABCDEF'),
(2,'Food',300,5,'ABCDEF'),
(3,'Drink',300,5,'ABCDEF'),
(4,'Rent-Car',300,3,'ABCDEF'),
(5,'Karaoke',700,1,'ABCDEF'),
(6, 'ABC',500,4,'ABCDEF');

-- ----Thêm Loại Dịch Vụ---------
insert into type_service
values
(1,'Villa'),
(2,'House'),
(3,'Room');

-- ---- Thêm Loại Kiểu Thuê ------
insert into rental_type
values
(1,'Day',500),
(2,'Week',3000),
(3,'Month',12500);

-- ----Thêm Dịch Vụ-----
insert into services
values
(1,'Villa-A',500,3,12,5000,2,1,'Còn Cho Thuê'),
(2,'Villa-B',500,3,12,5000,2,1,'Còn Cho Thuê'),
(3,'House-B',400,3,12,4000,3,2,'Còn Cho Thuê'),
(4,'House-A',400,3,12,3000,3,2,'Còn Cho Thuê'),
(5,'Room-A',300,3,12,2000,1,3,'Còn Cho Thuê'),
(6,'Room-B',300,3,12,2000,1,3,'Còn Cho Thuê');

-- ----Thêm Hợp Đồng -----
insert into contracts
values 
(1,1,1,1,'2020-2-3',adddate('2020-2-3',7),1000,15000),
(2,2,2,3,'2019-12-03',adddate('2019-12-03',3),1000,6000),
(3,1,1,1,'2018-8-01',adddate('2018-8-01',14),2000,30000),
(4,5,3,5,'2019-11-06',adddate('2019-11-06',30),5000,30000),
(5,3,5,4,'2018-7-24',adddate('2018-7-24',60),7000,60000),
(6,4,6,6,'2018-3-08',adddate('2018-3-08',14),5000,29000),
(7,2,2,2,'2019-2-24',adddate('2019-5-24',30),2000,30000),
(8,4,2,2,'2018-3-07',adddate('2018-3-07',30),1500,60000),
(9,4,1,4,'2018-3-07',adddate('2018-3-07',6),2000,8000),
(10,2,2,5,'2018-6-09',adddate('2018-6-09',5),500,7000),
(11,2,1,6,'2018-9-17',adddate('2018-9-17',12),500,5000),
(12,4,1,2,'2018-12-27',adddate('2018-12-27',9),3000,6000),
(13,1,5,1,'2019-3-14',adddate('2019-5-14',10),1000,15000),
(14,2,7,3,'2015-7-24',adddate('2016-7-24',11),2000,14000),
(15,5,8,4,'2015-5-14',adddate('2016-5-14',12),3000,15000),
(16,6,1,1,'2015-8-23',adddate('2016-8-23',13),1000,17000),
(17,10,6,2,'2019-12-12',adddate('2016-8-23',9),1000,17000),
(18,12,2,5,'2019-12-12',adddate('2016-8-23',15),1000,17000),
(19,10,4,6,'2019-12-12',adddate('2016-8-23',20),2000,27000);

-- ---Thêm Hợp Đồng Chi Tiết ------
insert into contract_details
values
(1,1,3,5),
(2,2,4,7),
(3,3,1,2),
(4,4,2,5),
(5,6,1,6),
(6,5,4,6),
(7,2,2,3),
(8,3,5,3),
(9,7,1,3),
(10,5,2,6);
