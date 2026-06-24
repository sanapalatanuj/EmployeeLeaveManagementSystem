package com.EmployeeLeaveManagement;

import com.EmployeeLeaveManagement.dto.LeaveTypeDTO;
import com.EmployeeLeaveManagement.entity.LeaveType;
import com.EmployeeLeaveManagement.repository.LeaveTypeRepository;
import com.EmployeeLeaveManagement.service.LeaveTypeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LeaveTypeServiceTest {

    @Mock
    private LeaveTypeRepository repository;

    @InjectMocks
    private LeaveTypeService service;

    @Test
    void testAddLeaveType() {

        LeaveTypeDTO dto = new LeaveTypeDTO();
        dto.setLeaveTypeName("Sick Leave");

        LeaveType leaveType = new LeaveType();
        leaveType.setLeaveTypeName("Sick Leave");

        when(repository.save(any(LeaveType.class)))
                .thenReturn(leaveType);

        LeaveType result =
                service.addLeaveType(dto);

        assertEquals(
                "Sick Leave",
                result.getLeaveTypeName());
    }
}