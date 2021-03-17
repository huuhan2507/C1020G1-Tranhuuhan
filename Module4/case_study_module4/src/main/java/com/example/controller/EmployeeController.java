package com.example.controller;

import com.example.entity.employee.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String pageEmployee(Model model, @PageableDefault(size = 4) Pageable pageable) {
        model.addAttribute( "employees", employeeService.findAll( pageable ) );
        return "/employee/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute( "employee", new Employee() );
        model.addAttribute( "positions", employeeService.findAllPosition() );
        model.addAttribute( "educations", employeeService.findAllEducation() );
        model.addAttribute( "divisions", employeeService.findAllDivision() );
        return "/employee/create";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute( "employee", employeeService.findById( id ) );
        model.addAttribute( "positions", employeeService.findAllPosition() );
        model.addAttribute( "educations", employeeService.findAllEducation() );
        model.addAttribute( "divisions", employeeService.findAllDivision() );
        return "/employee/edit";
    }

    @GetMapping("/deleteAll")
    public String deleteAll(){
        employeeService.deleteAll();
        return "redirect:/employee/";
    }

    @GetMapping("/delete/{id}")
    public String deleteId(@PathVariable Integer id){
        employeeService.deleteById( id );
        return "redirect:/employee/";
    }

    @GetMapping("/search")
    public String search(@RequestParam String search,Model model,@PageableDefault(size = 4) Pageable pageable){
        model.addAttribute( "employees", employeeService.search( search,pageable ) );
        model.addAttribute( "search",search );
        return "/employee/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Employee employee,@RequestParam String password) {
        employeeService.save( employee,password );
        return "redirect:/employee/";
    }
}
