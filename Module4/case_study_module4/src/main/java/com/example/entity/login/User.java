package com.example.entity.login;

import com.example.entity.employee.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Set;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    private String userName;
    private String passWord;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<UserRole> userRoles;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Employee> employees;

}
