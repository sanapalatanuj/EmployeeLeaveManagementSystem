package com.EmployeeLeaveManagement.service;
import com.EmployeeLeaveManagement.dto.DepartmentDTO;
import com.EmployeeLeaveManagement.entity.Department;
import com.EmployeeLeaveManagement.excep.ResourceNotFoundException;
import com.EmployeeLeaveManagement.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DepartmentService {
    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public Department addDepartment(DepartmentDTO dto) {
        Department department = new Department();
        department.setDepartmentName(dto.getDepartmentName());
        return repository.save(department);
    }

    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department Not Found"));
    }

    public Department updateDepartment(Long id,DepartmentDTO dto) {
        Department department = getDepartmentById(id);
        department.setDepartmentName(dto.getDepartmentName());
        return repository.save(department);
    }

    public void deleteDepartment(Long id) {
        Department department =
                getDepartmentById(id);
        repository.delete(department);
    }
}