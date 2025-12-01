package com.ems.attendanceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceSummaryDto {
    private Long employeeId;
    private int year;
    private int month;
    private int totalWorkingDays;
    private int presentDays;
    private int absentDays;
    private int leaveDays;
}
