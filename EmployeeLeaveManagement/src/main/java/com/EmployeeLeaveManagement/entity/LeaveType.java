package com.EmployeeLeaveManagement.entity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name="leave_types")
@Getter
@Setter
public class LeaveType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveTypeId;

    private String leaveTypeName;
}