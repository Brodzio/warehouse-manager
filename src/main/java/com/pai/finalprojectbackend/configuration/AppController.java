package com.pai.finalprojectbackend.configuration;

import com.pai.finalprojectbackend.Employee.EmployeeRepository;
import com.pai.finalprojectbackend.Employee.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class AppController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new UserDTO());

        return "login";
    }

    @GetMapping("/menu")
    public String menuPage(Model model, Principal principal) {
        model.addAttribute("user", employeeRepository.findByLogin(principal.getName()));

        return "menu";
    }

    @GetMapping("/profile")
    public String profilePage(Model model, Principal principal) {
        model.addAttribute("currentUser", employeeRepository.findByLogin(principal.getName()));

        return "profile";
    }
}
