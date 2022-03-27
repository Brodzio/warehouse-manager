package com.pai.finalprojectbackend.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Employee addEmployee(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public void updateEmployee(Long id, Employee employee) {
        Optional<Employee> employeeToUpdate = employeeRepository.findEmployeeById(id);
        if(employeeToUpdate.isPresent()) {
            employeeRepository.updateEmployee(
                    id,
                    employee.getName(),
                    employee.getSurname(),
                    employee.getEmail(),
                    employee.getJobTitle(),
                    employee.getPhoneNumber()
            );
        }
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteEmployeeById(id);
    }
}
