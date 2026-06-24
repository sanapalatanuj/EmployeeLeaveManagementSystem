package com.EmployeeLeaveManagement;
import com.EmployeeLeaveManagement.dto.EmployeeDTO;
import com.EmployeeLeaveManagement.entity.Department;
import com.EmployeeLeaveManagement.entity.Employee;
import com.EmployeeLeaveManagement.repository.DepartmentRepository;
import com.EmployeeLeaveManagement.repository.EmployeeRepository;
import com.EmployeeLeaveManagement.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void addEmployeeTest() {

        Department department = new Department();
        department.setDepartmentId(1L);

        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmployeeName("Rahul");
        dto.setEmail("rahul@gmail.com");
        dto.setDesignation("Developer");
        dto.setDepartmentId(1L);

        when(departmentRepository.findById(1L))
                .thenReturn(Optional.of(department));

        when(employeeRepository.save(any(Employee.class)))
                .thenAnswer(invocation ->
                        invocation.getArgument(0));

        Employee employee =
                employeeService.addEmployee(dto);

        assertEquals("Rahul",
                employee.getEmployeeName());
    }
}