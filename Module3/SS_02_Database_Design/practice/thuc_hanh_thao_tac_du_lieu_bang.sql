drop database if exists thuc_hanh;

create database thuc_hanh;

use thuc_hanh;

-- tạo bảng --
create table contacts(
id int not null auto_increment primary key,
last_name varchar(45) not null,
first_name varchar(45) not null,
birthday date
);

-- xóa bảng --
drop table contacts;

-- thêm thuộc tính cho bảng --
alter table contacts
add phone_number varchar(45);

-- xóa thuộc tính cho bảng --
alter table contacts
drop column phone_number;

-- thêm dữ liệu cho bảng --
insert into contacts
values 
(1,'han','tran','2002/7/25'),
(2,'hien','tran','1996/4/11');


-- sửa dữ liệu cho bảng --
update contacts
set last_name = 'khoa', first_name = 'nguyen'
where id = 1;

-- xem truy xuất thông tin bảng --
select * from contacts;




