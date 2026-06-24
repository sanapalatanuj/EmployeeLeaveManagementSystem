package com.EmployeeLeaveManagement.service;
import com.EmployeeLeaveManagement.dto.LeaveRequestDTO;
import com.EmployeeLeaveManagement.entity.Employee;
import com.EmployeeLeaveManagement.entity.LeaveRequest;
import com.EmployeeLeaveManagement.entity.LeaveType;
import com.EmployeeLeaveManagement.excep.ResourceNotFoundException;
import com.EmployeeLeaveManagement.repository.EmployeeRepository;
import com.EmployeeLeaveManagement.repository.LeaveRequestRepository;
import com.EmployeeLeaveManagement.repository.LeaveTypeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;
    private final EmployeeRepository employeeRepository;
    private final LeaveTypeRepository leaveTypeRepository;

    public LeaveRequestService(LeaveRequestRepository leaveRequestRepository, EmployeeRepository employeeRepository, LeaveTypeRepository leaveTypeRepository)
    {
        this.leaveRequestRepository = leaveRequestRepository;
        this.employeeRepository = employeeRepository;
        this.leaveTypeRepository = leaveTypeRepository;
    }

    public LeaveRequest applyLeave(LeaveRequestDTO dto)
    {
        Employee employee =
                employeeRepository.findById(dto.getEmployeeId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Employee Not Found"));

        LeaveType leaveType =
                leaveTypeRepository.findById(dto.getLeaveTypeId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Leave Type Not Found"));

        LeaveRequest request = new LeaveRequest();
        request.setStartDate(dto.getStartDate());
        request.setEndDate(dto.getEndDate());
        request.setReason(dto.getReason());
        request.setStatus("PENDING");
        request.setEmployee(employee);
        request.setLeaveType(leaveType);
        return leaveRequestRepository.save(request);
    }

    public List<LeaveRequest> getAllRequests() {
        return leaveRequestRepository.findAll();
    }

    public LeaveRequest getRequestById(Long id) {
        return leaveRequestRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Leave Request Not Found"));
    }

    public LeaveRequest approveLeave(Long id) {
        LeaveRequest request =
                getRequestById(id);
        request.setStatus("APPROVED");
        return leaveRequestRepository.save(request);
    }

    public LeaveRequest rejectLeave(Long id) {
        LeaveRequest request =
                getRequestById(id);
        request.setStatus("REJECTED");
        return leaveRequestRepository.save(request);
    }
    public LeaveRequest updateLeave(
            Long id,
            LeaveRequestDTO dto) {

        LeaveRequest leaveRequest =
                getRequestById(id);

        leaveRequest.setStartDate(dto.getStartDate());
        leaveRequest.setEndDate(dto.getEndDate());
        leaveRequest.setReason(dto.getReason());

        return leaveRequestRepository.save(leaveRequest);
    }

    public void deleteLeave(Long id) {
        LeaveRequest request =
                getRequestById(id);
        leaveRequestRepository.delete(request);
    }
}