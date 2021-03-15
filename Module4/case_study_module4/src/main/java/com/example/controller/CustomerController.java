package com.example.controller;


import com.example.entity.customer.Customer;
import com.example.service.CustomerService;
import com.example.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("/customer")
    public String pageCustomer(Model model, @PageableDefault(size = 6) Pageable pageable) {
        model.addAttribute( "customers", customerService.findAll( pageable ) );
        return "/customer/list";
    }

    @GetMapping("/customer/delete/{id}")
    public String delete(@PathVariable Integer id) {
        customerService.delete( id );
        return "redirect:/customer";
    }

    @GetMapping("/customer/create")
    public String create(Model model) {
        model.addAttribute( "customer", new Customer() );
        model.addAttribute( "types", customerTypeService.findAll() );
        return "/customer/create";
    }

    @GetMapping("/customer/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute( "customer", customerService.findById( id ) );
        model.addAttribute( "types", customerTypeService.findAll() );
        return "/customer/edit";
    }

    @GetMapping("/customer/search")
    public String search(@RequestParam String search,@PageableDefault(size = 6) Pageable pageable, Model model){
        model.addAttribute( "customers",customerService.searchByName( search,pageable ) );
        model.addAttribute( "search",search );
        return "customer/list";
    }

    @GetMapping("/customer/view/{id}")
    public String view(@PathVariable Integer id,Model model){
        model.addAttribute( "customer",customerService.findById( id ));
        return "/customer/view";
    }
    @GetMapping("/customer/deleteAll")
    public String deleteAll(){
        customerService.deleteAll();
        return  "redirect:/customer";
    }

    @PostMapping("/customer/save")
    public String save(@ModelAttribute Customer customer) {
        customerService.save( customer );
        return "redirect:/customer";
    }
}
