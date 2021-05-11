package com.example.entity.customer;

import com.example.annotation.customer.BirthdayCustomer;
import com.example.annotation.customer.CardIdDuplicateCustomer;
import com.example.annotation.customer.CodeCustomer;
import com.example.annotation.customer.EmailDuplicateCustomer;
import com.example.entity.contract.Contract;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @CodeCustomer
    @Pattern(regexp = "(KH-)[0-9]{4}", message = "The format of the customer code is KH-XXXX where X is a number from 0-9 !")
    private String customerCode;

    private String customerName;

    @BirthdayCustomer
    @Column(columnDefinition = "DATE")
    private String customerBirthday;

    private String customerGender;

    @CardIdDuplicateCustomer
    @Pattern(regexp = "[0-9]{9}|[0-9]{12}", message = "Format card id XXXXXXXXX or XXXXXXXXXXXX where X is a number from 0-9 !")
    private String customerCardId;

    @Pattern(regexp = "(09)(0|1)[0-9]{7}|(84\\+)(09)(0|1)[0-9]{7}", message = "Format phone number is 091xxxxxxx or 090xxxxxxx or (84+) 09xxxxxxx or (84+) 09xxxxxxx !")
    private String customerPhone;

    @EmailDuplicateCustomer
    @Email(message = "Email invalid, The format of the email is abc@abc.abc !")
    private String customerEmail;

    @NotBlank(message = "Address not be vacant !")
    private String customerAddress;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "customerTypeId", referencedColumnName = "customerTypeId")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Contract> contracts;

}
