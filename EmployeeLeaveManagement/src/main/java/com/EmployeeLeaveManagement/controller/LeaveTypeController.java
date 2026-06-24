package com.EmployeeLeaveManagement.controller;
import com.EmployeeLeaveManagement.dto.LeaveTypeDTO;
import com.EmployeeLeaveManagement.entity.LeaveType;
import com.EmployeeLeaveManagement.service.LeaveTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/leave-types")
public class LeaveTypeController {

    @Autowired
    private LeaveTypeService service;

    @PostMapping
    public LeaveType addLeaveType(@Valid @RequestBody LeaveTypeDTO dto)
    {
        return service.addLeaveType(dto);
    }

    @GetMapping
    public List<LeaveType> getAll() {
        return service.getAllLeaveTypes();
    }

    @GetMapping("/{id}")
    public LeaveType getById(@PathVariable Long id)
    {
        return service.getLeaveTypeById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id)
    {
        service.deleteLeaveType(id);
        return "Leave Type Deleted Successfully";
    }
}