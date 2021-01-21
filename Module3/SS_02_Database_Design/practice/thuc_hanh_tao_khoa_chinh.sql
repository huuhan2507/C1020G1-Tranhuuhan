drop database if exists thuc_hanh;
create database thuc_hanh;

use thuc_hanh;
-- tạo khóa chính --
create table class(
id int primary key auto_increment ,
student_name varchar(45),
birthday date
);

create table instructor (
id int auto_increment,
instructor_name varchar(45),
birthday date,
primary key (id)
);

-- tạo khóa chính tổ hợp --
create table study(
class_id int not null ,
instructor_id int not null,
primary key (class_id , instructor_id),
foreign key ( class_id) references class(id),
foreign key (instructor) references instructor(id)
);

-- tạo khóa chính bằng cách thay đổi bảng
create table student(
id int auto_increment,
student_name varchar(45),
birthday date
);
alter table student
add primary key(id);