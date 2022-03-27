package com.pai.finalprojectbackend.Employee;

import com.pai.finalprojectbackend.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/all")
    public String getAllEmployees (Model model) {
        List<Employee> employees = employeeService.findAllEmployees();

        model.addAttribute("employeeList", employees);


        return "employeesPage";
    }

//    @GetMapping("/find/{id}")
//    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id) {
//        Employee employee = employeeService.findEmployeeById(id);
//        return new ResponseEntity<>(employee, HttpStatus.OK);
//    }

    @GetMapping("/add")
    public String addEmployeePage(Model model) {
        model.addAttribute("employeeToAdd", new Employee());

        return "addEmployeePage";
    }

    @PostMapping("/add")
    public String addEmployee(@Valid @ModelAttribute(value = "employeeToAdd") Employee employee, BindingResult binding) {
        if(binding.hasErrors()) {
            System.out.println(binding);
            System.out.println(employee);
            return "addEmployeePage";
        }
        employeeService.addEmployee(employee);

        return "redirect:/employee/all";
    }

    @PostMapping("/update")
    public String showUpdateEmployeeForm(@ModelAttribute(value = "employeeToEdit") Employee employee, Model model) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));

        model.addAttribute("employeeToUpdate", employee);

        return "updateEmployeeForm";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") Long id, @Valid @ModelAttribute("employeeToUpdate") Employee employee, BindingResult binding) {
        if(binding.hasErrors()) {
            System.out.println(binding);
            System.out.println(employee);

            return "updateEmployeeForm";
        }
        employeeService.updateEmployee(id, employee);

        return "redirect:/employee/all";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);

        return "redirect:/employee/all";
    }
}
