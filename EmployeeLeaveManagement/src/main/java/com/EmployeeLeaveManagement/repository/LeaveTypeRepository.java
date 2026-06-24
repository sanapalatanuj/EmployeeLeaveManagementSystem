package com.EmployeeLeaveManagement.repository;
import com.EmployeeLeaveManagement.entity.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveTypeRepository extends JpaRepository<LeaveType,Long> {}