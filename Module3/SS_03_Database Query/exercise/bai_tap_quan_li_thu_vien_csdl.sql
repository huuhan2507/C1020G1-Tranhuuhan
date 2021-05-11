drop database if exists bai_tap;

create database bai_tap;

use bai_tap;

create table student(
	student_number int primary key,
    student_name varchar(50) not null,
    address varchar(50) not null,
    email varchar(50) not null,
    image varchar(50)
    );

create table category(
	cate_number int not null primary key,
    category_name varchar(50) not null
    );
    
create table book(
	code_book varchar(50) not null primary key,
    book_name varchar(50) not null,
    produccer varchar(50) not null,
    author varchar(50) not null,
    publish_year date,
	number_of_publications int,
    book_price double not null,
    image varchar(50),
    cate_number int not null,
    foreign key (cate_number) references category(cate_number)
    );
    
create table borrow_order(
	student_number int,
    code_book varchar(50) not null,
	borrow_date Date not null,
    returned_date Date,
    foreign key (student_number) references student(student_number),
    foreign key (code_book) references book(code_book)
    );

insert into student values
	(1,'Han','Phu Yen','han@gmail.com',null),
	(2,'Hien','Da Nang','hien@gmail.com',null),
	(3,'Phin','Quang Tri','phin@gmail.com',null),
	(4,'Long','Quang Binh','long@gmail.com',null),
	(5,'Thinh','Nghe An','thinh@gmail.com',null),
	(6,'Son','Quang Tri','son@gmail.com',null),
	(7,'Nhat','Quang Tri','nhat@gmail.com',null),
	(8,'Dung','Da Nang','dung@gmail.com',null);
    
select*
from student;

insert into category values
	(1,'Actions'),
	(2,'Romantic'),
	(3,'Science'),
	(4,'Life Science'),
	(5,'Supernatural'),
	(6,'Horror');

select*
from category;

insert into book values
	('A-01','SPY 007','Marvel','S.Alex','2015-12-11',1,50000,'',1),
	('A-02','Titanit','Sony','F.Thomas','2013-06-04',0,60000,'',2),
	('A-03','Ocean','Lumia','L.David','2018-05-12',2,70000,'',3),
	('A-04','Animal','Samsumg','K.Elena','2016-02-10',3,30000,'',1),
	('A-05','The world','Oppo','H.Agolia','2019-07-13',1,70000,'',3),
	('A-06','Avenger','Banasonic','O.Benki','2001-04-21',2,80000,'',5),
	('A-07','Ghost Ridger','GL','D.Tina','2020-08-12',4,150000,'',6);

select*
from book;

insert into borrow_order values
	(1,'A-01','2020-08-16','2020-09-03'),
	(2,'A-02','2020-08-16','2020-08-19'),
	(3,'A-03','2020-08-15','2020-09-01'),
	(4,'A-01','2020-08-11','2020-08-15'),
	(5,'A-04','2020-08-10','2020-08-14');

select student.student_number,student_name,student.address,student.email,borrow_order.code_book,
borrow_date,returned_date,book_name, produccer,author
from student
inner join borrow_order on student.student_number = borrow_order.student_number
 inner join book on book.code_book = borrow_order.code_book ;
 
 select*
 from student
 left join borrow_order on student.student_number = borrow_order.student_number;