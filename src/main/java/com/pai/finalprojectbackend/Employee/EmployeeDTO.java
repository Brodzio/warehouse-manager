package com.pai.finalprojectbackend.Employee;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class EmployeeDTO {

    @NotBlank(message = "Puste pole!")
    @Length(min = 3, max = 32, message = "Zła długość loginu, minimum 3 lub maksimum 32 znaków")
    private String login;

    @NotBlank(message = "Puste pole!")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Minimum 1 cyfra ,1 mala litera, 1 duża litera, 1 znak specjalny i minimum 8 znaków")
    private String password;

    @NotBlank(message = "Puste pole!")
    @Pattern(regexp = "^[A-Za-z]{2,}$", message = "Zbyt krótkie imie, minimum 2 znaki lub podane zostały cyfry")
    private String name;

    @NotBlank(message = "Puste pole!")
    @Pattern(regexp = "^[A-Za-z]{2,}$", message = "Zbyt krótkie nazwisko, minimum 2 znaki lub podane zostały cyfry")
    private String surname;

    @NotBlank(message = "Puste pole!")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Niepoprawny mail")
    private String email;

    @NotBlank(message = "Puste pole!")
    @Pattern(regexp = "^[A-Za-z]{2,}$", message = "Zbyt krótka nazwa stanowiska")
    private String jobTitle;

    @NotBlank(message = "Puste pole!")
    @Pattern(regexp = "^[0-9]{9}$", message = "Numer telefonu powinien składać się z 9 cyfr")
    private String phoneNumber;
}
