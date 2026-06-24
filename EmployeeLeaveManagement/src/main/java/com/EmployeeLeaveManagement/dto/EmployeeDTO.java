package com.EmployeeLeaveManagement.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmployeeDTO {

    @NotBlank(message = "Employee name is required")
    private String employeeName;

    @Email(message = "Email is required")
    private String email;

    @NotBlank
    private String designation;

    private Long departmentId;
}