package com.example.rescuespot.report.controller;

import com.example.rescuespot.report.DTO.request.ReportRequestDTO;
import com.example.rescuespot.report.DTO.response.ReportRescuedDTO;
import com.example.rescuespot.report.DTO.response.ReportResponseDTO;
import com.example.rescuespot.report.DTO.response.ReportStatusUpdateDTO;
import com.example.rescuespot.report.service.Impl.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ReportResponseDTO> createReport(@RequestBody ReportRequestDTO reportRequestDTO) {
        ReportResponseDTO reportResponseDTO = reportService.createReport(reportRequestDTO);
        return ResponseEntity.ok(reportResponseDTO);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('SHELTER' , 'ADMIN' , 'USER')")
    public ResponseEntity<List<ReportResponseDTO>> getAllReports() {
        List<ReportResponseDTO> reports = reportService.getAllReports();
        return ResponseEntity.ok(reports);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SHELTER' , 'USER' , 'ADMIN')")
    public ResponseEntity<ReportResponseDTO> getReportById(@PathVariable Long id) {
        ReportResponseDTO report = reportService.getReportById(id);
        return ResponseEntity.ok(report);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN' , 'USER')")
    public ResponseEntity<String> deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
        return ResponseEntity.ok("Report deleted successfully");
    }

    @PatchMapping("/{id}/status")
    @PreAuthorize("hasRole('SHELTER')")
    public ResponseEntity<ReportResponseDTO> updateStatus(
            @PathVariable Long id,
            @RequestBody ReportStatusUpdateDTO statusDto) {

        ReportResponseDTO updated = reportService.updateReportStatus(id, statusDto);
        return ResponseEntity.ok(updated);
    }
}