package com.EmployeeLeaveManagement.controller;
import com.EmployeeLeaveManagement.dto.LeaveRequestDTO;
import com.EmployeeLeaveManagement.entity.LeaveRequest;
import com.EmployeeLeaveManagement.service.LeaveRequestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/leave")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService service;

    @PostMapping
    public LeaveRequest applyLeave(@Valid @RequestBody LeaveRequestDTO dto)
    {
        return service.applyLeave(dto);
    }

    @GetMapping
    public List<LeaveRequest> getAll() {
        return service.getAllRequests();
    }

    @GetMapping("/{id}")
    public LeaveRequest getById(@PathVariable Long id)
    {
        return service.getRequestById(id);
    }
    @PutMapping("/{id}")
    public LeaveRequest updateLeave(
            @PathVariable Long id,
            @RequestBody LeaveRequestDTO dto) {
        return service.updateLeave(id, dto);
    }

    @PutMapping("/approve/{id}")
    public LeaveRequest approve(@PathVariable Long id)
    {
        return service.approveLeave(id);
    }

    @PutMapping("/reject/{id}")
    public LeaveRequest reject(@PathVariable Long id)
    {
        return service.rejectLeave(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id)
    {
        service.deleteLeave(id);
        return "Leave Request Deleted Successfully";
    }
}