package com.EmployeeLeaveManagement;

import com.EmployeeLeaveManagement.dto.LeaveRequestDTO;
import com.EmployeeLeaveManagement.entity.Employee;
import com.EmployeeLeaveManagement.entity.LeaveRequest;
import com.EmployeeLeaveManagement.entity.LeaveType;
import com.EmployeeLeaveManagement.repository.EmployeeRepository;
import com.EmployeeLeaveManagement.repository.LeaveRequestRepository;
import com.EmployeeLeaveManagement.repository.LeaveTypeRepository;
import com.EmployeeLeaveManagement.service.LeaveRequestService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LeaveRequestServiceTest {

    @Mock
    private LeaveRequestRepository repository;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private LeaveTypeRepository leaveTypeRepository;

    @InjectMocks
    private LeaveRequestService service;

    @Test
    void testApplyLeave() {

        Employee employee = new Employee();
        LeaveType leaveType = new LeaveType();

        LeaveRequestDTO dto = new LeaveRequestDTO();
        dto.setEmployeeId(1L);
        dto.setLeaveTypeId(1L);
        dto.setReason("Fever");
        dto.setStartDate(LocalDate.now());
        dto.setEndDate(LocalDate.now().plusDays(2));

        when(employeeRepository.findById(1L))
                .thenReturn(Optional.of(employee));

        when(leaveTypeRepository.findById(1L))
                .thenReturn(Optional.of(leaveType));

        when(repository.save(any(LeaveRequest.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        LeaveRequest result =
                service.applyLeave(dto);

        assertNotNull(result);
        assertEquals("PENDING", result.getStatus());
    }

    @Test
    void testApproveLeave() {

        LeaveRequest leave = new LeaveRequest();
        leave.setStatus("PENDING");

        when(repository.findById(1L))
                .thenReturn(Optional.of(leave));

        when(repository.save(any(LeaveRequest.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        LeaveRequest result =
                service.approveLeave(1L);

        assertEquals("APPROVED", result.getStatus());
    }
}