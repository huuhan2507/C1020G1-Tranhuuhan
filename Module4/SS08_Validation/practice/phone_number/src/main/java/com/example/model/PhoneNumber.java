package com.example.model;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class PhoneNumber {
    @Pattern( regexp = "(0)[0-9]{9,10}",message = "Số điện thoại không hợp lệ" )
    private String phoneNumber;

}
