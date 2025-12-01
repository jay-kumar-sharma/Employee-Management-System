package com.ems.employeeservice.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {

        private Long id;

        private String employeeCode;

        @NotBlank(message = "First name is required")
        @Size(max = 50)
        private String firstName;

        @NotBlank(message = "Last name is required")
        private String lastName;

        private LocalDate dob;

        private String gender;

        @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
        private String phone;

        @NotBlank(message = "Email is required")
        @Email(message = "Email should be valid")
        private String email;

        @NotNull(message = "Date of Joining is required")
        private LocalDate dateOfJoining;

        private String department;

        private String designation;

        private String employmentType;

        private String status = "ACTIVE";

        @NotNull(message = "Basic salary is required")
        @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than zero")
        private BigDecimal basicSalary;
}
