package com.ems.employeeservice.service;

import com.ems.employeeservice.dto.EmployeeDto;
import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> getAllEmployees();

    List<EmployeeDto> getEmployeesByDepartment(String department);

    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);

    void deleteEmployee(Long id);

    String generateEmployeeCode();
}
