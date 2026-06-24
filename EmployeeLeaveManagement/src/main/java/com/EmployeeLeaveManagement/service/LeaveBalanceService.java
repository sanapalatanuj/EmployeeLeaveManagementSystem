package com.EmployeeLeaveManagement.service;
import com.EmployeeLeaveManagement.dto.LeaveBalanceDTO;
import com.EmployeeLeaveManagement.entity.Employee;
import com.EmployeeLeaveManagement.entity.LeaveBalance;
import com.EmployeeLeaveManagement.excep.ResourceNotFoundException;
import com.EmployeeLeaveManagement.repository.EmployeeRepository;
import com.EmployeeLeaveManagement.repository.LeaveBalanceRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LeaveBalanceService {

    private final LeaveBalanceRepository leaveBalanceRepository;
    private final EmployeeRepository employeeRepository;

    public LeaveBalanceService(LeaveBalanceRepository leaveBalanceRepository, EmployeeRepository employeeRepository)
    {

        this.leaveBalanceRepository = leaveBalanceRepository;
        this.employeeRepository = employeeRepository;
    }

    public LeaveBalance addLeaveBalance(
            LeaveBalanceDTO dto) {

        Employee employee =
                employeeRepository.findById(dto.getEmployeeId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Employee Not Found"));

        LeaveBalance balance =
                new LeaveBalance();

        balance.setTotalLeaves(dto.getTotalLeaves());
        balance.setRemainingLeaves(dto.getRemainingLeaves());
        balance.setEmployee(employee);

        return leaveBalanceRepository.save(balance);
    }

    public List<LeaveBalance> getAllBalances() {
        return leaveBalanceRepository.findAll();
    }

    public LeaveBalance getBalanceById(Long id) {

        return leaveBalanceRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Leave Balance Not Found"));
    }

    public LeaveBalance updateBalance(
            Long id,
            LeaveBalanceDTO dto) {

        LeaveBalance balance =
                getBalanceById(id);

        balance.setTotalLeaves(dto.getTotalLeaves());
        balance.setRemainingLeaves(dto.getRemainingLeaves());

        return leaveBalanceRepository.save(balance);
    }

    public void deleteBalance(Long id) {

        LeaveBalance balance =
                getBalanceById(id);

        leaveBalanceRepository.delete(balance);
    }
}