package com.example.rescuespot.report.mapper;


import com.example.rescuespot.report.DTO.request.ReportRequestDTO;
import com.example.rescuespot.report.DTO.response.ReportRescuedDTO;
import com.example.rescuespot.report.DTO.response.ReportResponseDTO;
import com.example.rescuespot.report.entity.Report;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IReportMapper {
    @Mapping(source = "user.idUser", target = "userId")
    @Mapping(source = "user.firstName", target = "userFirstName")
    @Mapping(source = "user.lastName", target = "userLastName")
    ReportResponseDTO toResponse(Report report);

    ReportRescuedDTO toRescuedDTO(Report report);

    Report toEntity(ReportRequestDTO dto);


}
