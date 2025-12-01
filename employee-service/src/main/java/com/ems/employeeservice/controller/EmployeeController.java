package com.ems.employeeservice.controller;


import com.ems.employeeservice.dto.EmployeeDto;
import com.ems.employeeservice.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    // CREATE
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        EmployeeDto response = employeeService.createEmployee(employeeDto);
        return ResponseEntity.status(201).body(response);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        EmployeeDto response = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(response);
    }

    // GET ALL ACTIVE
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // GET BY DEPARTMENT + ACTIVE
    @GetMapping("/department/{department}")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByDepartment(@PathVariable String department) {
        return ResponseEntity.ok(employeeService.getEmployeesByDepartment(department));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeDto employeeDto) {

        EmployeeDto updated = employeeService.updateEmployee(id, employeeDto);
        return ResponseEntity.ok(updated);
    }

    // SOFT DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee with ID " + id + " is now INACTIVE.");
    }
}
