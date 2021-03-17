package com.example.controller;


import com.example.entity.customer.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String pageCustomer(Model model, @PageableDefault(size = 4) Pageable pageable) {
        model.addAttribute( "customers", customerService.findAll( pageable ) );
        return "/customer/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        customerService.delete( id );
        return "redirect:/customer/";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute( "customer", new Customer() );
        model.addAttribute( "types", customerService.findAllCustomerType());
        return "/customer/create";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute( "customer", customerService.findById( id ) );
        model.addAttribute( "types", customerService.findAllCustomerType() );
        return "/customer/edit";
    }

    @GetMapping("/search")
    public String search(@RequestParam String search,@PageableDefault(size = 4) Pageable pageable, Model model){
        model.addAttribute( "customers",customerService.search( search,pageable ) );
        model.addAttribute( "search",search );
        return "/customer/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Integer id,Model model){
        model.addAttribute( "customer",customerService.findById( id ));
        return "/customer/view";
    }
    @GetMapping("/deleteAll")
    public String deleteAll(){
        customerService.deleteAll();
        return  "redirect:/customer/";
    }

    @PostMapping("/save/create")
    public String save(@Validated @ModelAttribute Customer customer, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute( "customer",customer );
            model.addAttribute( "types", customerService.findAllCustomerType() );
            return "/customer/create";
        }else {
            customerService.save( customer );
            return "redirect:/customer/";
        }
    }
    @PostMapping("/save/edit")
    public String save1(@Validated @ModelAttribute Customer customer, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute( "customer",customer );
            model.addAttribute( "types", customerService.findAllCustomerType() );
            return "/customer/edit";
        }else {
            customerService.save( customer );
            return "redirect:/customer/";
        }
    }

}
