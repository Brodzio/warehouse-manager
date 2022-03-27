package com.pai.finalprojectbackend.configuration;

import com.pai.finalprojectbackend.Employee.Employee;
import com.pai.finalprojectbackend.Employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserAuthenticationDetails implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByLogin(login);
        if (employee != null) {
            List<GrantedAuthority> grupa = new ArrayList<>();
            if(employee.getLogin().equals("admin")) {
                System.out.println("Admin******************************************");
                grupa.add(new SimpleGrantedAuthority("ADMIN"));
            } else {
                System.out.println("NormalUser**********************************");
                grupa.add(new SimpleGrantedAuthority("normalUser"));
            }
            return new
                    org.springframework.security.core.userdetails.User(employee.getLogin(),
                    employee.getPassword(), true,
                    true, true, true, grupa);
        } else {
            throw new UsernameNotFoundException("Zły login lub hasło...");
        }
    }
}
