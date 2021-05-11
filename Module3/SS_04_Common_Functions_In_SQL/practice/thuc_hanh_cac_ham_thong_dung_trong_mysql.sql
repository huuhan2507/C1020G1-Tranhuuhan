drop database if exists thuc_hanh;
create database thuc_hanh;
use thuc_hanh;

-- Hàm lấy ngày trong 1 chuỗi ngày, tháng , năm ----
select day('2021-1-13') as `day`;

-- Hàm lấy tháng trong 1 chuỗi ngày, tháng , năm ----
select month('2021-1-13') as `month`;

-- Hàm lấy năm trong 1 chuỗi ngày, tháng , năm ----
select year('2021-1-13') as `year`;

-- Hàm in ra ngày, tháng ,năm từ 1 chuỗi --
select date('2021-1-13') as `date`;

-- Hàm nối chuỗi với nhau ------
select concat('Hello',' ','World') as `string`;

-- Hàm viết chữ thường thành chữ hoa -----
select ucase('hello world') as uppercase;

-- Hàm viết chữ thường thành chữ hoa -----
select lcase('HELLO WORLD') as lowercase;

