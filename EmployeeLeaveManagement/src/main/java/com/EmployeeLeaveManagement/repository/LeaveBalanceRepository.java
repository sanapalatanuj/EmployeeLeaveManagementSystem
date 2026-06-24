package com.EmployeeLeaveManagement.repository;
import com.EmployeeLeaveManagement.entity.LeaveBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance,Long> {}