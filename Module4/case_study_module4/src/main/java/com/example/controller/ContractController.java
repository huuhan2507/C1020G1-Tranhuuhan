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
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/edit/{id}")
    public String edit(Model model,@PathVariable Integer id,Pageable pageable){
        model.addAttribute( "contract", contractService.findById( id ) );
        model.addAttribute( "customers",customerService.findAll( pageable ) );
        model.addAttribute( "employees",employeeService.findAll( pageable ) );
        model.addAttribute( "services",serviceService.findAll() );
        return "/contract/editContract";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Contract contract){
        contractService.save( contract );
        return "redirect:/contract/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        contractService.delete( id );
        return "redirect:/contract/";
    }

    @GetMapping("/useService")
    public String pageUseService(Model model,Pageable pageable){
        model.addAttribute( "userService",contractService.CustomerUserService( pageable ) );
        return "/customer_use_service/list";
    }

    @GetMapping("/useService/delete/{id}")
    public String deleteService(@PathVariable Integer id){
        serviceService.deleteById( id );
        return "redirect:/contract/useService";
    }
}
