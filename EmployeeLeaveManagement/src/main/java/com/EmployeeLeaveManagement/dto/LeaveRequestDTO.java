package com.EmployeeLeaveManagement.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDate;

@Data
public class LeaveRequestDTO {

    private LocalDate startDate;
    private LocalDate endDate;

    @NotBlank(message = "Mention the Reason")
    private String reason;

    private Long employeeId;
    private Long leaveTypeId;
}