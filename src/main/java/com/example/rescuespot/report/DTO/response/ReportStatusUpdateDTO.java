package com.example.rescuespot.report.DTO.response;

import com.example.rescuespot.report.entity.enumReport.ReportStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReportStatusUpdateDTO {
    private Long shelterId;
    private ReportStatus newStatus;
}
