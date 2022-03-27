package com.pai.finalprojectbackend;

import com.pai.finalprojectbackend.Employee.Employee;
import com.pai.finalprojectbackend.Employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class FinalProjectBackendApplication {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectBackendApplication.class, args);
	}

//	@PostConstruct
//	public void init() {
//		employeeRepository.save(new Employee("admin", passwordEncoder.encode("admin"), "admin", "admin", "admin", "admin", "admin"));
//	}

}
