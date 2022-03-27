package com.pai.finalprojectbackend.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    @NotBlank(message = "Puste pole!")
    @Length(min = 3, max = 32, message = "Zła długość loginu, minimum 3 lub maksimum 32 znaków")
    private String login;

    @Column(name = "password")
    @NotBlank(message = "Puste pole!")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Minimum 1 cyfra ,1 mala litera, 1 duża litera, 1 znak specjalny i minimum 8 znaków")
    private String password;

    @Column(name = "name")
    @NotBlank(message = "Puste pole!")
   @Pattern(regexp = "^[A-Za-z]{2,}$", message = "Zbyt krótkie imie, minimum 2 znaki lub podane zostały cyfry")
    private String name;

    @Column(name = "surname")
    @NotBlank(message = "Puste pole!")
    @Pattern(regexp = "^[A-Za-z]{2,}$", message = "Zbyt krótkie nazwisko, minimum 2 znaki lub podane zostały cyfry")
    private String surname;

    @Column(name = "email")
    @NotBlank(message = "Puste pole!")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Niepoprawny mail")
    private String email;

    @Column(name = "job_title")
    @NotBlank(message = "Puste pole!")
    @Pattern(regexp = "^[A-Za-z]{2,}$", message = "Zbyt krótka nazwa stanowiska")
    private String jobTitle;

    @Column(name = "phone_number")
    @NotBlank(message = "Puste pole!")
    @Pattern(regexp = "^[0-9]{9}$", message = "Numer telefonu powinien składać się z 9 cyfr")
    private String phoneNumber;

    public Employee(String login, String password, String name, String surname, String email, String jobTitle, String phoneNumber) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname =surname;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phoneNumber = phoneNumber;
    }

    public Employee() {}
}
