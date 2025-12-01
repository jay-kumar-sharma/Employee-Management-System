package com.ems.attendanceservice.service;

import com.ems.attendanceservice.dto.AttendanceDto;
import com.ems.attendanceservice.dto.AttendanceSummaryDto;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceService {

    AttendanceDto checkIn(Long employeeId);

    AttendanceDto checkOut(Long employeeId);

    AttendanceDto getTodayAttendance(Long employeeId);

    List<AttendanceDto> getAttendanceHistory(Long employeeId, LocalDate startDate, LocalDate endDate);

    AttendanceDto markLeave(Long employeeId, LocalDate date);

    AttendanceSummaryDto getMonthlySummary(Long employeeId, int year, int month);
}
