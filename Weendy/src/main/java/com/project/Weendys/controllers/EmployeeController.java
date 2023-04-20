package com.project.Weendys.controllers;

import com.project.Weendys.objects.Employee;
import com.project.Weendys.objects.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    public String getFormEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "form_employee";
    }

    @PostMapping
    public String postViewEmployee(Model model, Employee employee) {
        model.addAttribute("name", employee.getName());
        model.addAttribute("age", employee.getAge());
        model.addAttribute("number", employee.getNumber());
        repository.save(employee);
        return "view_employee";
    }

}
