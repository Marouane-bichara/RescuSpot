package com.example.rescuespot.report.service.Impl;

import com.example.rescuespot.report.DTO.request.ReportRequestDTO;
import com.example.rescuespot.report.DTO.response.ReportResponseDTO;
import com.example.rescuespot.report.entity.Report;
import com.example.rescuespot.report.entity.enumReport.ReportStatus;
import com.example.rescuespot.report.mapper.IReportMapper;
import com.example.rescuespot.report.repository.IReportRepository;
import com.example.rescuespot.report.service.Impl.ReportService;
import com.example.rescuespot.user.entity.User;
import com.example.rescuespot.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReportServiceTest {

    @Mock
    private IReportRepository reportRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private IReportMapper reportMapper;

    @InjectMocks
    private ReportService reportService;

    private User mockUser;
    private ReportRequestDTO reportRequest;
    private Report mockReport;

    @BeforeEach
    void setUp() {
        mockUser = new User();
        mockUser.setIdUser(1L);

        reportRequest = new ReportRequestDTO();
        reportRequest.setUserId(1L);

        mockReport = new Report();
        mockReport.setIdReport(100L);
    }

    @Test
    @DisplayName("Should create report successfully when user exists")
    void createReport_Success() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));
        when(reportMapper.toEntity(any(ReportRequestDTO.class))).thenReturn(mockReport);
        when(reportRepository.save(any(Report.class))).thenReturn(mockReport);
        when(reportMapper.toResponse(any(Report.class))).thenReturn(new ReportResponseDTO());

        ReportResponseDTO result = reportService.createReport(reportRequest);

        assertNotNull(result);
        assertEquals(ReportStatus.PENDING, mockReport.getReportStatus());
        assertNotNull(mockReport.getReportedAt());

        verify(userRepository, times(1)).findById(1L);
        verify(reportRepository, times(1)).save(mockReport);
    }

    @Test
    @DisplayName("Should throw exception when creating report for non-existent user")
    void createReport_UserNotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            reportService.createReport(reportRequest);
        });

        assertEquals("User not found", exception.getMessage());
        verify(reportRepository, never()).save(any());
    }

    @Test
    @DisplayName("Should delete report when report exists")
    void deleteReport_Success() {
        Long reportId = 100L;
        when(reportRepository.findById(reportId)).thenReturn(Optional.of(mockReport));

        reportService.deleteReport(reportId);

        verify(reportRepository, times(1)).delete(mockReport);
    }

    @Test
    @DisplayName("Should throw exception when deleting non-existent report")
    void deleteReport_NotFound() {
        when(reportRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> reportService.deleteReport(999L));
        verify(reportRepository, never()).delete(any());
    }
}