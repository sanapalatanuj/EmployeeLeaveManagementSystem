package com.EmployeeLeaveManagement.controller;
import com.EmployeeLeaveManagement.dto.EmployeeDTO;
import com.EmployeeLeaveManagement.entity.Employee;
import com.EmployeeLeaveManagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee addEmployee(@Valid @RequestBody EmployeeDTO dto)
    {
        return service.addEmployee(dto);
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id)
    {
        return service.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO dto)
    {
        return service.updateEmployee(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Employee Deleted Successfully";
    }
}