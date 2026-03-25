package com.example.rescuespot.report.service.Impl;

import com.example.rescuespot.report.DTO.request.ReportRequestDTO;
import com.example.rescuespot.report.DTO.response.ReportRescuedDTO;
import com.example.rescuespot.report.DTO.response.ReportResponseDTO;
import com.example.rescuespot.report.DTO.response.ReportStatusUpdateDTO;
import com.example.rescuespot.report.entity.Report;
import com.example.rescuespot.report.entity.enumReport.ReportStatus;
import com.example.rescuespot.report.mapper.IReportMapper;
import com.example.rescuespot.report.repository.IReportRepository;
import com.example.rescuespot.shelter.entity.Shelter;
import com.example.rescuespot.shelter.repository.IShalterRepository;
import com.example.rescuespot.user.entity.User;
import com.example.rescuespot.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final IReportRepository reportRepository;
    private final UserRepository userRepository;
    private final IReportMapper reportMapper;
    private final IShalterRepository shelterRepository;


    public ReportResponseDTO createReport(ReportRequestDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Report report = reportMapper.toEntity(dto);

        report.setUser(user);
        report.setReportedAt(new Date());
        report.setReportStatus(ReportStatus.PENDING);

        Report savedReport = reportRepository.save(report);

        return reportMapper.toResponse(savedReport);
    }

    public List<ReportResponseDTO> getAllReports() {

        return reportRepository.findAll()
                .stream()
                .map(reportMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ReportResponseDTO getReportById(Long id) {

        Report report = reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));

        return reportMapper.toResponse(report);
    }

    public void deleteReport(Long id) {

        Report report = reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found"));

        reportRepository.delete(report);
    }
    public ReportResponseDTO updateReportStatus(Long reportId, ReportStatusUpdateDTO dto) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new RuntimeException("Report not found"));
        System.out.println(dto.getShelterId());
        Shelter shelter = shelterRepository.findById(dto.getShelterId())
                .orElseThrow(() -> new RuntimeException("Shelter not found"));

        System.out.println(dto.getNewStatus());

        report.setRescuerShelter(shelter);

        report.setReportStatus(dto.getNewStatus());

        if (dto.getNewStatus() == ReportStatus.RESOLVED) {
            report.setRescuedAt(new Date());
        }

        Report saved = reportRepository.save(report);

        return reportMapper.toResponse(saved);
    }



}