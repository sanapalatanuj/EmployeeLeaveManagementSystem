package com.EmployeeLeaveManagement.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
@Entity
@Table(name="leave_requests")
@Getter
@Setter
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveRequestId;

    private LocalDate startDate;

    private LocalDate endDate;

    private String reason;

    private String status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnoreProperties({"leaveRequests", "leaveBalance", "department"})
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "leave_type_id")
    private LeaveType leaveType;
}