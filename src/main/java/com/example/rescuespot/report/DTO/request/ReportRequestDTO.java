package com.example.rescuespot.report.DTO.request;


import com.example.rescuespot.report.entity.enumReport.HealthAnimalStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportRequestDTO {

    private String location;

    private List<String> photos;

    private HealthAnimalStatus healthStatus;

    private String description;
}

