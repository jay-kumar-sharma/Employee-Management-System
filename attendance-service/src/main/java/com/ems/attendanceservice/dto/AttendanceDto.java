package com.ems.attendanceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDto {

    private Long id;
    private Long employeeId;
    private String employeeName;
    private String department;
    private LocalDate attendanceDate;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private Boolean lateCheckIn;
    private Boolean earlyCheckOut;
    private String status;
    private BigDecimal workingHours;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
