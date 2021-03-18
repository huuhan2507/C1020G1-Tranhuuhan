drop database if exists furama_resort_db;

create database furama_resort_db;

use furama_resort_db;

create table `position` (
position_id int primary key auto_increment,
position_name varchar(45)
); 

create table education_degree(
education_degree_id int primary key auto_increment ,
education_degree_name varchar(45)
);

create table division(
division_id int primary key auto_increment ,
division_name varchar(45)
);

create table `role`(
role_id int primary key auto_increment ,
role_name varchar(255)
);

create table `user`(
username varchar(255) primary key ,
`password` varchar(255)
);

create table user_role(
role_id int auto_increment,
username varchar(255),
foreign key (role_id) references `role`(role_id),
foreign key (username) references `user`(username)
);

create table employee(
employee_id int primary key auto_increment,
employee_name varchar(45) not null,
employee_birthday date not null ,
employee_id_card varchar(45) not null ,
employee_salary double,
employee_phone varchar(45) not null ,
employee_email varchar(45),
employee_address varchar(45),
position_id int,
education_degree_id int ,
division_id int,
username varchar(255),
foreign key (position_id) references `position`(position_id),
foreign key (education_degree_id) references education_degree(education_degree_id),
foreign key (division_id) references division(division_id),
foreign key (username) references `user`(username)
);

create table customer_type(
customer_type_id int primary key auto_increment,
customer_type_name varchar(45)
);

create table customer(
customer_id int primary key auto_increment,
customer_type_id int ,
customer_name varchar(45) not null,
customer_birthday date not null ,
customer_gender varchar(45),
customer_id_card varchar(45) not null,
customer_phone varchar(45) not null ,
customer_email varchar(45),
customer_address varchar(45),
foreign key (customer_type_id) references customer_type(customer_type_id) on update cascade
);

create table service_type (
service_type_id int primary key auto_increment,
service_type_name varchar(45)
);

create table rent_type(
rent_type_id int primary key auto_increment,
rent_type_name varchar(45),
rent_type_cost double
);

create table service(
service_id int primary key auto_increment,
service_name varchar(45) not null ,
service_area int ,
service_cost double,
service_max_people int ,
rent_type_id int,
service_type_id int,
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floors int,
foreign key (rent_type_id) references rent_type(rent_type_id),
foreign key (service_type_id) references service_type(service_type_id)
);

create table contract(
contract_id int primary key auto_increment,
contract_start_date datetime not null ,
contract_end_date datetime not null ,
contract_deposit double not null ,
contract_total_money double ,
employee_id int,
customer_id int,
service_id int ,
foreign key (employee_id) references employee(employee_id) on delete cascade,
foreign key (customer_id) references customer(customer_id) on delete cascade,
foreign key (service_id) references service(service_id)
);

create table attach_service (
attach_service_id int primary key auto_increment,
attach_service_name varchar(45) not null,
attach_service_cost double not null ,
attach_service_unit int not null ,
attach_service_status varchar(45)
);

create table contract_detail (
contract_detail_id int primary key auto_increment ,
contract_id int ,
attach_service_id int ,
quantity int not null ,
foreign key (contract_id) references contract(contract_id) on delete cascade, 
foreign key (attach_service_id) references attach_service(attach_service_id) 
); 

/*------------------------------------- insert into ----------------------------------------------------------------------*/
insert into `position`(position_name)
values 
('Giam Doc'),
('Quan Li'),
('Phuc Vu'),
('Chuyen Vien'),
('Giam Sat'),
('Le Tan');


insert into education_degree (education_degree_name)
values
('Dai Hoc'),
('Cao Dang'),
('Trung Cap'),
('Sau Dai Hoc');

insert into `division`(division_name)
values
('Hanh Chinh'),
('Marketing'),
('Phuc vu'),
('Quan Li');

insert into customer_type(customer_type_name)
values
('Diamond'),
('Platinum'),
('Gold'),
('Silver'),
('Member');

insert into attach_service(attach_service_name,attach_service_cost,attach_service_unit,attach_service_status)
values
('Massage',500,3,'AAA'),
('Food',500,3,'AAA'),
('Drink',500,3,'AAA'),
('Karaoke',700,3,'AAA'),
('Car',1000,5,'AAA');

insert into rent_type(rent_type_name)
values
('House'),
('Day'),
('Month'),
('Year');

insert into service_type ( service_type_name)
values
('Villa'),
('House'),
('Room');

insert into `user`
values
('longphin1212','12122001'),
('huuhan2507','25072002');

insert into `role`(role_name)
values
('Admin'),
('Member');

insert into user_role 
values
(1,'longphin1212'),
(1,'huuhan2507');

insert into employee
values
(1,'Nguyen Long Phin','2001-12-12','214013284',2000,0893294328,'longphin1212@gmail.com','Da Nang',5,1,1,'longphin1212'),
(2,'Tran Huu Han','2002-07-25','211532719',3000,08312329754,'huuhan2507@gmail.com','Da Nang',1,1,4,'longphin1212');

insert into customer
values
(1,1,'Tran Huu Kien','1991-06-22','male','291312554','0923697134','huukien421@gmail.com','Nghe An'),
(2,1,'Nguyen Minh Tan','1999-08-27','male','263294347','0962314492','minhtan241@gmail.com','Phu Yen');

insert into service
values
(1,'Villan',500,7000,12,2,1,'Vip','AAA',200,3),
(2,'Housen',300,10000,8,3,2,'Vip','AAA',100,2),
(3,'Rooming',700,6000,6,1,3,'Vip','AAA',200,1);

insert into contract
values
(1,'2020-12-09','2020/12/12',3000,15000,1,1,1),
(2,'2020-11-09','2020-11-15',3000,15000,2,2,2);

insert into contract_detail
values
(1,1,1,2),
(2,2,3,4);
delimiter //
create procedure create_employee(`name`varchar(45),birthday date,card_id varchar(45),salary double,
phone varchar(45),email varchar(45),address varchar(45),po_id int,edu_id int,divi_id int , user_name varchar(45))
begin
SET FOREIGN_KEY_CHECKS=0;
insert into employee (employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,
            employee_email,employee_address,position_id,education_degree_id,division_id,username)
            values(`name`,birthday,card_id,salary,phone,email,address,po_id,edu_id,divi_id,user_name);
end;
// delimiter ;


delimiter //
create procedure update_employee(id int,`name`varchar(45),birthday date,card_id varchar(45),salary double,
phone varchar(45),email varchar(45),address varchar(45),po_id int,edu_id int,divi_id int , user_name varchar(45))
begin
update employee
set employee_name=`name`,employee_birthday=birthday,employee_id_card=card_id,employee_salary=salary,
employee_phone=phone, employee_email=email,employee_address=address,position_id=po_id,education_degree_id=edu_id,
division_id=divi_id,username=user_name
where employee_id = id;
end;
// delimiter ;

delimiter //
create procedure create_customer(`type` int,`name`varchar(45),birthday date,gender varchar(45), card_id varchar(45),
phone varchar(45),email varchar(45),address varchar(45))
begin
SET FOREIGN_KEY_CHECKS=0;
insert into customer (customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address)
values(`type`,`name`,birthday,gender, card_id ,
phone ,email ,address);
end;
// delimiter ;

delimiter //
create procedure update_customer(id int,`type` int,`name`varchar(45),birthday date,gender varchar(45), card_id varchar(45),
phone varchar(45),email varchar(45),address varchar(45))
begin
update customer
set customer_type_id = `type`,customer_name=`name`,customer_birthday= birthday ,customer_gender=gender
,customer_id_card = card_id,customer_phone=phone,customer_email=email,customer_address=address;
end;
// delimiter ;


		

























