package com.example.rescuespot.user.mapper;

import com.example.rescuespot.report.mapper.IReportMapper;
import com.example.rescuespot.user.DTO.request.UpdateUserRequestDTO;
import com.example.rescuespot.user.DTO.request.UserRequestDTO;
import com.example.rescuespot.user.DTO.response.UserResponseDTO;
import com.example.rescuespot.user.entity.User;
import com.example.rescuespot.identity.mapper.IAccountMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.stream.Collectors;

@Mapper(
        componentModel = "spring",
        uses = {IAccountMapper.class, IReportMapper.class},
        imports = {java.util.stream.Collectors.class}
)
public interface IUserMapper {

    @Mapping(target = "adoptions", expression = "java(user.getAdoptions() != null ? user.getAdoptions().stream().map(a -> new com.example.rescuespot.adoption.DTO.response.AdoptionLightDTO(a.getIdAdoption(), a.getStatus().name())).collect(Collectors.toList()) : null)")
    UserResponseDTO toResponse(User user);

    User toEntity(UserRequestDTO requestDTO);

    User toEntityUpdate(UpdateUserRequestDTO  requestDTO);
}