package com.example.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Tên không hợp lệ")
    @Size(min = 2 , max = 30,message = "Độ dài tên phải lớn hơn 2 kí tự và bé hơn 30 kí tự")
    private String name;

    @Min(value = 18,message = "Tuổi nhập không hợp lệ")
    @Max( value = 120, message = "Tuổi nhập không hợp lệ")
    private int age;

}
