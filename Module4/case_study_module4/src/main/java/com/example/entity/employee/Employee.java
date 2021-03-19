package com.example.entity.employee;

import com.example.annotation.employee.BirthdayEmployee;
import com.example.annotation.employee.CardIdEmployeeDuplicate;
import com.example.annotation.employee.EmailDuplicateEmployee;
import com.example.entity.contract.Contract;
import com.example.entity.login.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String employeeName;

    @BirthdayEmployee
    @Column(columnDefinition = "DATE")
    private String employeeBirthday;

    @CardIdEmployeeDuplicate
    @Pattern(regexp = "[0-9]{9}|[0-9]{12}", message = "Format card id XXXXXXXXX or XXXXXXXXXXXX where X is a number from 0-9 !")
    private String employeeCardId;

    @NumberFormat()
    @Min( value = 1,message = "Salary must be greater than 0")
    private Double employeeSalary;

    @Pattern(regexp = "(09)(0|1)[0-9]{7}|(84\\+)(09)(0|1)[0-9]{7}", message = "Format phone number is 091xxxxxxx or 090xxxxxxx or (84+) 09xxxxxxx or (84+) 09xxxxxxx !")
    private String employeePhone;

    @EmailDuplicateEmployee
    @Email(message = "Email invalid, The format of the email is abc@abc.abc !")
    private String employeeEmail;

    @NotBlank
    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "positionId", referencedColumnName = "positionId")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "divisionId", referencedColumnName = "divisionId")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "educationDegree", referencedColumnName = "educationDegreeId")
    private EducationDegree educationDegree;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private Set<Contract> contracts;

    @ManyToOne
    @JoinColumn(name = "userName", referencedColumnName = "userName")
    private User user;
}
