package com.EmployeeLeaveManagement.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LeaveBalanceDTO {

    @NotNull(message = "Total leaves is required")
    @Min(value = 0, message = "Total leaves cannot be negative")
    private Integer totalLeaves;

    @NotNull(message = "Remaining leaves is required")
    @Min(value = 0, message = "Remaining leaves cannot be negative")
    private Integer remainingLeaves;

    @NotNull(message = "Employee ID is required")
    private Long employeeId;
}