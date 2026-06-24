package com.EmployeeLeaveManagement.controller;

import com.EmployeeLeaveManagement.dto.LeaveBalanceDTO;
import com.EmployeeLeaveManagement.entity.LeaveBalance;
import com.EmployeeLeaveManagement.service.LeaveBalanceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave-balance")
public class LeaveBalanceController {

    @Autowired
    private LeaveBalanceService service;

    @PostMapping
    public LeaveBalance addBalance(
            @Valid @RequestBody LeaveBalanceDTO dto) {

        return service.addLeaveBalance(dto);
    }

    @GetMapping
    public List<LeaveBalance> getAll() {

        return service.getAllBalances();
    }

    @GetMapping("/{id}")
    public LeaveBalance getById(
            @PathVariable Long id) {

        return service.getBalanceById(id);
    }

    @PutMapping("/{id}")
    public LeaveBalance update(
            @PathVariable Long id,
            @RequestBody LeaveBalanceDTO dto) {

        return service.updateBalance(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id) {

        service.deleteBalance(id);
        return "Leave Balance Deleted Successfully";
    }
}