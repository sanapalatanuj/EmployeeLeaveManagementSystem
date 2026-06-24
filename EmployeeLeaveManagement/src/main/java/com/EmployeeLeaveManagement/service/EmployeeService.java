package com.EmployeeLeaveManagement.service;
import com.EmployeeLeaveManagement.dto.EmployeeDTO;
import com.EmployeeLeaveManagement.entity.Department;
import com.EmployeeLeaveManagement.entity.Employee;
import com.EmployeeLeaveManagement.excep.ResourceNotFoundException;
import com.EmployeeLeaveManagement.repository.DepartmentRepository;
import com.EmployeeLeaveManagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository,DepartmentRepository departmentRepository)
    {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public Employee addEmployee(EmployeeDTO dto) {
        Department department =
                departmentRepository.findById(dto.getDepartmentId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Department Not Found"));
        Employee employee = new Employee();
        employee.setEmployeeName(dto.getEmployeeName());
        employee.setEmail(dto.getEmail());
        employee.setDesignation(dto.getDesignation());
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee Not Found"));
    }

    public Employee updateEmployee(Long id,
                                   EmployeeDTO dto) {
        Employee employee = getEmployeeById(id);
        Department department =
                departmentRepository.findById(dto.getDepartmentId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Department Not Found"));
        employee.setEmployeeName(dto.getEmployeeName());
        employee.setEmail(dto.getEmail());
        employee.setDesignation(dto.getDesignation());
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        Employee employee =
                getEmployeeById(id);
        employeeRepository.delete(employee);
    }
}