package com.EmployeeLeaveManagement.service;
import com.EmployeeLeaveManagement.dto.LeaveTypeDTO;
import com.EmployeeLeaveManagement.entity.LeaveType;
import com.EmployeeLeaveManagement.excep.ResourceNotFoundException;
import com.EmployeeLeaveManagement.repository.LeaveTypeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LeaveTypeService {
    private final LeaveTypeRepository repository;
    public LeaveTypeService(LeaveTypeRepository repository)
    {
        this.repository = repository;
    }

    public LeaveType addLeaveType(LeaveTypeDTO dto)
    {
        LeaveType leaveType = new LeaveType();
        leaveType.setLeaveTypeName(
                dto.getLeaveTypeName());
        return repository.save(leaveType);
    }

    public List<LeaveType> getAllLeaveTypes() {
        return repository.findAll();
    }

    public LeaveType getLeaveTypeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Leave Type Not Found"));
    }
    public void deleteLeaveType(Long id) {
        LeaveType leaveType =
                getLeaveTypeById(id);
        repository.delete(leaveType);
    }
}