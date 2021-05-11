-- -----------------------28 Task Case Study Module 3 (Database) ------------------------------

-- -----Task 2------
/* Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.*/
select * from employees where  (employee_name like '% % h%' 
or employee_name like '% % t%'
or employee_name like '% % k%')
and char_length(employee_name)<=15;

-- -- -----Task 3------
/* Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.--*/
select*
from customers
where (datediff(now(),date_of_birth)>6574 
and datediff(now(),date_of_birth)<=18263)
and customers.address in('Đà Nẵng','Quảng Trị');
 
 -- ----Task 4-------
 /* Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
	 Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.*/
select customers.customer_name,count(contract_id)as mount_contract
from customers
left join contracts on customers.customer_id = contracts.customer_id
where customers.type_of_customer_id =1
group by customer_name
order by count(contract_id);

-- ------Task5 ------
/* Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
(Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong * Gia, với SoLuong và Giá là từ bảng DichVuDiKem)
cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).*/
select customers.customer_id,customers.customer_name,type_of_customer_name,contracts.contract_id,services.service_name,
contracts.contract_start_date,contracts.contract_end_date,(services.rental_costs + a.price*a.unit) as total_money
from customers
left join contracts on contracts.customer_id = customers.customer_id
left join type_of_customer on type_of_customer.type_of_customer_id= customers.type_of_customer_id
left join services on services.service_id = contracts.contract_id
left join contract_details c on c.contract_id = contracts.contract_id
left join accompanied_service a on a.accompanied_service_id = c.accompanied_service_id;

-- -------Task 6 -----
/* Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được 
   khách hàng thực hiện đặt từ quý 1 của năm '2019' (Quý 1 là tháng 1, 2, 3).*/
  
select s.service_id, s.service_name, s.area, s.rental_costs,t.type_service_name
from services s
inner join type_service t on t.type_service_id =  s.type_service_id
where  not exists 
(select contracts.contract_id from contracts where( year(contracts.contract_start_date)=2019 and month(contracts.contract_start_date) in (1,2,3))
and contracts.service_id=s.service_id);
  
-- -------Task 7 --------
/* Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ đã từng được
	Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019. */
select s.service_id, s.service_name, s.area, s.rental_costs,t.type_service_name
from services s
left join type_service t on t.type_service_id =  s.type_service_id
    
where exists (select contracts.contract_id from contracts where(year(contracts.contract_start_date) = '2018' )
and contracts.service_id=s.service_id)
    
and not exists (select contracts.contract_id from contracts where(year(contracts.contract_start_date) = '2019' )
and contracts.service_id=s.service_id);
    
-- -----Task 8 ----------
/* Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên */
-- cách 1 :    
select distinct customers.customer_name
from customers ;
-- cách 2:
select customers.customer_name
from customers
group by customer_name ;
-- cách 3:
select customers.customer_name
from customers
union
select customers.customer_name
from customers;

-- ----Task 9 -------
/* Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong 
năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.*/
select month(c.contract_start_date) as month , count(month(c.contract_start_date)) amount_order, sum(total_money)
from contracts c

where year(c.contract_start_date) = 2019
group by month(c.contract_start_date)
order by month(c.contract_start_date);

select * from contracts;

-- ----Task 10 -------
/* Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm.Kết quả hiển thị bao gồm IDHopDong,NgayLamHopDong,
NgayKetThuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet)*/
select c.contract_id, c.contract_start_date, c.contract_end_date ,c.down_payment , count(contract_details_id) as amount_service
from contracts c
left join contract_details d on d.contract_id = c.contract_id
group by c.contract_id;

-- ----Task 11 --------
/* Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có TenLoaiKhachHang là 'Diamond' và 
có địa chỉ là 'Vinh' hoặc 'Quảng Ngãi'. */
select a.accompanied_service_id ,a.accompanied_service_name,a.price,a.unit,a.availability
from accompanied_service a
inner join contract_details d on a.accompanied_service_id = d.accompanied_service_id
inner join contracts o on o.contract_id = d.contract_id
inner join customers c on c.customer_id = o.customer_id
inner join type_of_customer t on t.type_of_customer_id = c.type_of_customer_id
where t.type_of_customer_name = 'Diamond' 
and c.address in ('Vinh','Quảng Nam') 
group by a.accompanied_service_id;
select * from accompanied_service;

-- ---- Task 12 ---------
/*Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDiKem ( được dựa trên tổng hợp đồng chi tiết ),
TienDatCoc của tất cả dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng đặt vào 6 tháng đầu năm 2019 */
select o.contract_id , e.employee_name , c.customer_name, c.phone_number, s.service_name , count(d.accompanied_service_id) as amount_service,sum(o.down_payment)
from contracts o
inner join employees e on e.employee_id = o.employee_id
inner join customers c on c.customer_id = o.customer_id
inner join services s on s.service_id = o.service_id
inner join contract_details d on d.contract_id = o.contract_id
where (date(contract_start_date) between '2019-10-01' and '2019-12-31') and s.service_id not in (
		select service_id
        from contracts
        where date(contract_start_date) between '2019-1-01' and '2019-6-30' )
group by s.service_name;

-- ------------ Task 13 ------------
/* Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
(Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).*/
select a.accompanied_service_id , a.accompanied_service_name , a.price , a.unit , a.availability , count(a.accompanied_service_id) as amount_booking
from accompanied_service a
inner join contract_details c on c.accompanied_service_id = a.accompanied_service_id
group by a.accompanied_service_id
order by amount_booking desc;


 -- ------------Task 14 -------------
 /*Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
 Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.*/
select a.accompanied_service_id , a.accompanied_service_name , a.price , a.unit , a.availability , count(a.accompanied_service_id) as amount_booking
 from accompanied_service a
 inner join contract_details c on c.accompanied_service_id = a.accompanied_service_id
 group by a.accompanied_service_id
 having amount_booking = 1;
 
 -- -------------Task 15 -------------
 /*Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan,
 SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.*/
 select e.employee_id , e.employee_name , l.location_name,p.part_name, e.phone_number, e.address
 from employees e
 inner join location_employee l on l.location_id = e.location_id
 inner join part_employee p on p.part_id = e.part_id
 inner join contracts c on c.employee_id = e.employee_id
 where contract_start_date in (select contract_start_date from contracts where (contracts.contract_start_date between '2018-1-1' and '2019-12-31') 
 and contracts.employee_id = e.employee_id)
 group by e.employee_id
 having count(e.employee_id) <= 3;

 -- ------------ Task 16 ---------------
 /*Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.*/
set SQL_SAFE_UPDATES = 0; 
delete from employees
where employee_id not in (
		select c.employee_id
		from contracts c
		where year(contract_start_date) in (2017,2018,2019)
        group by c.employee_id );
set SQL_SAFE_UPDATES = 1; 
select*from employees;

-- -----------------Task 17-------------------
/* Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond,chỉ cập nhật
 những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ*/ 
create view view_customer as
select c.customer_id 
from customers c
inner join contracts o on o.customer_id = c.customer_id
inner join contract_details d on d.contract_id = o.contract_id
where o.total_money >= 20000
group by c.customer_id ;
set SQL_SAFE_UPDATES = 0; 
update customers
set type_of_customer_id = 1
where customer_id in (
select * from view_customer
);
set SQL_SAFE_UPDATES = 1; 
select*
from customers;

-- ------------------Task 18 --------------------
/*Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng)*/
set SQL_SAFE_UPDATES = 0; 
delete from customers
where customer_id in (
		select c.customer_id
		from contracts c
		where year(contract_start_date) < 2016
        group by c.customer_id );
set SQL_SAFE_UPDATES = 1;
select * 
from customers;

-- -----------------Task 19 ---------------------
 /*Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.*/
create view view_accompanied_service as
select a.accompanied_service_id 
from accompanied_service a
inner join contract_details d on d.accompanied_service_id = a.accompanied_service_id
group by a.accompanied_service_id
having sum(d.amount) >10;

set SQL_SAFE_UPDATES = 0; 
update accompanied_service 
set price = price*2
where accompanied_service_id in (
select * from view_accompanied_service
 );
set SQL_SAFE_UPDATES = 1; 

select *
from accompanied_service ;

-- ---------------Task 20 ---------------------
/*Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống,thông tin hiển thị bao gồm
 ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi. */
select employee_id as id , employee_name as `name` , email , phone_number ,date_of_birth ,address
from employees 
union all
select customer_id , customer_name , email , phone_number , date_of_birth , address
from customers ;
 
 -- --------------Task 21 ---------------------
 /*Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” 
 và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019” */
drop view if exists v_nhanvien;
create view v_nhanvien as
select e.employee_id , e.employee_name ,e.date_of_birth , e.card_id , e.salary , e.email , e.address
from employees e
inner join contracts c on c.employee_id = e.employee_id 
where e.address = 'Hải Châu' and c.contract_start_date = '2019-12-12'
group by e.employee_id;

select* 
from v_nhanvien;

-- -----------------Task 22 -------------------
/*Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” 
đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này. */
update employees
set employees.address = 'Liên Chiểu'
where employees.employee_id in (
select employee_id from v_nhanvien
 );
 
select * from employees;

-- --------- Task 23 ------------------
/*Tạo Store procedure sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với
 Id Khách hàng được truyền vào như là 1 tham số của sp_1 */
delimiter //
create procedure sp_1(id int)
begin
delete from customers 
where customer_id = id;
end;
// delimiter ;

select*from customers;

-- ------------Task 24 ---------------
/*Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 phải 
thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa 
chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan. */
delimiter // 
create procedure sp_2 (employee_id_new int , customer_id_new int ,service_id_new int  , start_date date , end_date date ,down_payment_new int , total_money_new int )
begin
if employee_id_new not in (select employee_id from employees ) then
select "Id employee invalid";

elseif customer_id_new not in (select customer_id from customers ) then
select "Id customer invalid";

elseif service_id_new not in ( select service_id from services ) then
select "Id service invalid";

elseif start_date > end_date then
select "Date invalid";
else
insert into contracts (employee_id , customer_id , service_id , contract_start_date , contract_end_date, down_payment , total_money)
value
(employee_id_new,customer_id_new , service_id_new , start_date , end_date , down_payment_new, total_money_new );

end if;
end;
// delimiter ; 

-- ----------- Task 25 ----------------





 

 
 
 
 
 



 
 
 
 
 
 