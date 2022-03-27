package com.pai.finalprojectbackend.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);

    Employee findByLogin(String login);

    @Query("UPDATE Employee set name = :name, surname = :surname, email = :email, jobTitle = :jobTitle, phoneNumber = :phoneNumber where id = :id")
    @Modifying
    void updateEmployee(
            @Param("id") Long id,
            @Param("name") String name,
            @Param("surname") String surname,
            @Param("email") String email,
            @Param("jobTitle") String jobTitle,
            @Param("phoneNumber") String phoneNumber
    );
}
