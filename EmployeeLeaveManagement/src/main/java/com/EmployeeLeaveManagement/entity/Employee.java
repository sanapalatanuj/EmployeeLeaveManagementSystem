package com.EmployeeLeaveManagement.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.List;
@Entity
@Table(name="employees")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @NotBlank
    private String employeeName;

    @Email
    @Column(unique = true)
    private String email;

    private String designation;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnoreProperties({"employees"})
    private Department department;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<LeaveRequest> leaveRequests;

    @OneToOne(mappedBy = "employee")
    private LeaveBalance leaveBalance;
}