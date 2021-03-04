package com.example.model;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class User {
    //    @Pattern( regexp = "\\w{5}",message = "Tên phải là chữ và từ 5 đến 45 kí tự")
    @Size(min = 5, max = 45)
    private String firstname;
    //    @Pattern( regexp = "\\w{5}",message = "Tên phải là chữ và từ 5 đến 45 kí tự")
    @Size(min = 5, max = 45)

    private String lastname;
    @Pattern(regexp = "(0)[0-9]{9,10}", message = "Số điện thoại phải bắt đầu là 0 và có 10 hoặc 11 kí tự số")
    private String phone;

    @NotNull(message = "Hãy nhập số vào")
    @Min(value = 18, message = "Bạn chưa đủ tuổi để đăng kí")
    @Max(value = 120, message = "Số tuổi của bạn thật thần kì")
    private Integer age;

    @Pattern( regexp = "\\w{5,}(@)\\w{3,}(.)\\w{3,}", message = "Email mà bạn nhập không đúng định dạng ")
    private String email;

}