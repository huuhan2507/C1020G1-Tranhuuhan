drop database if exists bai_tap;
create database bai_tap;

use bai_tap;

create table accounts(
account_number int primary key ,
accont_type varchar(45),
date_account  date,
balance int
);

create table customer (
customer_number int primary key,
fullname varchar(45),
address varchar(45),
email varchar(45) unique,
phone_number varchar(45) unique,
account_number int,
foreign key (account_number) references accounts(account_number)
);

create table transactions(
tran_number int primary key ,
account_number int,
tran_date date,
amounts int,
descriptions varchar(45),
foreign key (account_number) references accounts(account_number)
);
