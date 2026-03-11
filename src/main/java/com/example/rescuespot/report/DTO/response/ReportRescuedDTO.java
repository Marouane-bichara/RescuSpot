package com.example.rescuespot.report.DTO.response;

import com.example.rescuespot.report.entity.enumReport.HealthAnimalStatus;
import com.example.rescuespot.report.entity.enumReport.ReportStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportRescuedDTO {

    private Long idReport;
    private String location;
    private List<String> photos;
    private HealthAnimalStatus healthStatus;
    private String description;
    private Date reportedAt;
    private ReportStatus reportStatus;

    private Long userId;
    private String userFirstName;
    private String userLastName;

    private String shalterName;
}
