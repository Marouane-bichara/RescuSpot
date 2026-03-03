package com.example.rescuespot.user.mapper;


import com.example.rescuespot.report.mapper.IReportMapper;
import com.example.rescuespot.user.DTO.request.UpdateUserRequestDTO;
import com.example.rescuespot.user.DTO.request.UserRequestDTO;
import com.example.rescuespot.user.DTO.response.UserResponseDTO;
import com.example.rescuespot.user.entity.User;
import com.example.rescuespot.identity.mapper.AccountMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {AccountMapper.class , IReportMapper.class })
public interface IUserMapper {

    UserResponseDTO toResponse(User user);
    User toEntity(UserRequestDTO requestDTO);
}
