package com.EmployeeLeaveManagement.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LeaveTypeDTO {

    @NotBlank(message = "Leave Type is required")
    private String leaveTypeName;
}