package com.EmployeeLeaveManagement.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DepartmentDTO {
    @NotBlank(message = "Department name is required")
    private String departmentName;
}