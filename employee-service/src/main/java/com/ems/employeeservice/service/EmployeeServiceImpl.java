package com.ems.employeeservice.service;

import com.ems.employeeservice.dto.EmployeeDto;
import com.ems.employeeservice.entity.Employee;
import com.ems.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements  EmployeeService{

    private  final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        if(employeeRepository.existsByEmail(employeeDto.getEmail())){
            throw  new RuntimeException("Email already exists");
        }
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employee.setEmployeeCode(generateEmployeeCode());
        Employee saved = employeeRepository.save(employee);
        return modelMapper.map(saved,EmployeeDto.class);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee Not found With id" + id));
        return modelMapper.map(employee,EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findByStatus("ACTIVE")
                .stream()
                .map(emp -> modelMapper.map(emp, EmployeeDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public List<EmployeeDto> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartmentAndStatus(department, "ACTIVE")
                .stream()
                .map(emp -> modelMapper.map(emp, EmployeeDto.class))
                .collect(Collectors.toList());
    }



    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {

        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with id " + id));

        if (!existing.getEmail().equals(employeeDto.getEmail())
                && employeeRepository.existsByEmail(employeeDto.getEmail())) {

            throw new RuntimeException("Email already used by another employee");
        }

        modelMapper.map(employeeDto, existing);

        existing.setId(id);
        existing.setEmployeeCode(existing.getEmployeeCode());
        Employee updated = employeeRepository.save(existing);
        return modelMapper.map(updated, EmployeeDto.class);
    }



    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with id: " + id));

        employee.setStatus("INACTIVE"); // soft delete
        employeeRepository.save(employee);
    }


    @Override
    public String generateEmployeeCode() {

        long nextId = employeeRepository.getMaxEmployeeId() + 1;
        return String.format("EMP-%04d", nextId);

    }
}
