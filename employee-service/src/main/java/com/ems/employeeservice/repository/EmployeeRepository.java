package com.ems.employeeservice.repository;

import com.ems.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    boolean existsByEmail(String email);
    Optional<Employee> findByEmail(String email);
    Optional<Employee> findByEmployeeCode(String employeeCode);
    List<Employee> findByDepartment(String department);
    List<Employee> findByStatus(String status);
    List<Employee> findByDepartmentAndStatus(String department, String status);
    @Query("SELECT COALESCE(MAX(e.id), 0) FROM Employee e")
    long getMaxEmployeeId();




}
