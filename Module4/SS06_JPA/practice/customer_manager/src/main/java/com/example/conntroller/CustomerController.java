package com.example.conntroller;

import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute( "customer",new Customer() );
        return "save";
    }

    @GetMapping("/edit/{id}")
    public String update(@PathVariable Integer id, Model model){
        model.addAttribute( "customer", customerRepository.findById( id ) );
        return "save";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Integer id){
        customerRepository.deleteById( id );
        return "redirect:/";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Customer customer){
        customerRepository.save( customer );
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Integer id,Model model){
        model.addAttribute( "customer", customerRepository.findById( id ).get() );
        return "view";
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute( "list", customerRepository.findAll() );
        return "index";
    }
}
