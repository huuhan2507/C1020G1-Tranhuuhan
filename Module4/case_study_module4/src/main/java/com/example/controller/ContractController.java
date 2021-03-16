package com.example.controller;

import com.example.entity.contract.Contract;
import com.example.repository.ContractRepository;
import com.example.service.ContractService;
import com.example.service.CustomerService;
import com.example.service.EmployeeService;
import com.example.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ServiceService serviceService;

    @GetMapping("/")
    public String pageContract(@PageableDefault(size = 6) Pageable pageable, Model model) {
        model.addAttribute( "contracts", contractService.findAll( pageable ) );
        return "/contract/listContract";
    }

    @GetMapping("/create")
    public String create(Model model,Pageable pageable){
        model.addAttribute( "customers",customerService.findAll( pageable ) );
        model.addAttribute( "employees",employeeService.findAll( pageable ) );
        model.addAttribute( "services",serviceService.findAll() );
        model.addAttribute( "contract",new Contract() );
        return "/contract/createContract";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Contract contract){
        contractService.save( contract );
        return "redirect:/contract/";
    }
}
