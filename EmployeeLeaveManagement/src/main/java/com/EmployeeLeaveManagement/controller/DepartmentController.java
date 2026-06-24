package com.EmployeeLeaveManagement.controller;

import com.EmployeeLeaveManagement.dto.DepartmentDTO;
import com.EmployeeLeaveManagement.entity.Department;
import com.EmployeeLeaveManagement.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PostMapping
    public Department addDepartment(
            @Valid @RequestBody DepartmentDTO dto) {

        return service.addDepartment(dto);
    }

    @GetMapping
    public List<Department> getAll() {
        return service.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getById(
            @PathVariable Long id) {

        return service.getDepartmentById(id);
    }

    @PutMapping("/{id}")
    public Department update(
            @PathVariable Long id,
            @RequestBody DepartmentDTO dto) {

        return service.updateDepartment(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id) {

        service.deleteDepartment(id);
        return "Department Deleted Successfully";
    }
}