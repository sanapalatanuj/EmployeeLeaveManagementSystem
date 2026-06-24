package com.EmployeeLeaveManagement;

import com.EmployeeLeaveManagement.dto.DepartmentDTO;
import com.EmployeeLeaveManagement.entity.Department;
import com.EmployeeLeaveManagement.repository.DepartmentRepository;
import com.EmployeeLeaveManagement.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private DepartmentRepository repository;

    @InjectMocks
    private DepartmentService service;

    @Test
    void testAddDepartment() {

        DepartmentDTO dto = new DepartmentDTO();
        dto.setDepartmentName("IT");

        Department department = new Department();
        department.setDepartmentName("IT");

        when(repository.save(any(Department.class)))
                .thenReturn(department);

        Department result =
                service.addDepartment(dto);

        assertEquals(
                "IT",
                result.getDepartmentName());
    }

    @Test
    void testGetAllDepartments() {

        Department department = new Department();
        department.setDepartmentName("IT");

        when(repository.findAll())
                .thenReturn(List.of(department));

        assertFalse(
                service.getAllDepartments().isEmpty());
    }
}