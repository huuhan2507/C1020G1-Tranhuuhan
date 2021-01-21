drop database if exists bai_tap;
create database bai_tap;
use bai_tap;

create table student(
id int ,
`name` varchar(30),
age int,
name_subject varchar(20),
money int
);

insert into student
values 
(1,'Hoang',21,'CNTT',400000),
(2,'Viet',19,'DTVT',320000),
(3,'Thanh',18,'KTDN',400000),
(4,'Nhan',19,'CK',450000),
(5,'Huong',20,'TCHH',500000),
(5,'Huong',20,'TCHH',200000);

/*hiển thị các dòng có tên là Huong*/
select *
from student
where student.`name`= 'Huong';

/* hiển thị tổng số tiền của Huong*/
select *,sum(student.money)
from student
where student.`name`='Huong'
group by student.id;

/*hiển thị danh sách tên các học viên không bị trùng lặp*/
select *,sum(student.money)
from student
group by student.id;


