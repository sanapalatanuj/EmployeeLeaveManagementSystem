package com.EmployeeLeaveManagement.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name="leave_balance")
@Getter
@Setter
public class LeaveBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long balanceId;

    private Integer totalLeaves;

    private Integer remainingLeaves;

    @OneToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnoreProperties({"leaveRequests", "department", "leaveBalance"})
    private Employee employee;
}