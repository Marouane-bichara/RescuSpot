package com.example.rescuespot.report.mapper;


import com.example.rescuespot.report.DTO.request.ReportRequestDTO;
import com.example.rescuespot.report.DTO.response.ReportResponseDTO;
import com.example.rescuespot.report.entity.Report;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IReportMapper {

    ReportResponseDTO toResponse(Report report);

    Report toEntity(ReportRequestDTO dto);
}
