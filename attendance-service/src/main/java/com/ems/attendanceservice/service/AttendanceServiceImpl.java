package com.ems.attendanceservice.service;

import com.ems.attendanceservice.dto.AttendanceDto;
import com.ems.attendanceservice.dto.AttendanceSummaryDto;
import com.ems.attendanceservice.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;

    @Override
    public AttendanceDto checkIn(Long employeeId) {
        return null;
    }

    @Override
    public AttendanceDto checkOut(Long employeeId) {
        return null;
    }

    @Override
    public AttendanceDto getTodayAttendance(Long employeeId) {
        return null;
    }

    @Override
    public List<AttendanceDto> getAttendanceHistory(Long employeeId, LocalDate startDate, LocalDate endDate) {
        return List.of();
    }

    @Override
    public AttendanceDto markLeave(Long employeeId, LocalDate date) {
        return null;
    }

    @Override
    public AttendanceSummaryDto getMonthlySummary(Long employeeId, int year, int month) {
        return null;
    }
}
