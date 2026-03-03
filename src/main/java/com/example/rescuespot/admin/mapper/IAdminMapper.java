package com.example.rescuespot.admin.mapper;


import com.example.rescuespot.admin.DTO.request.AdminRequestDTO;
import com.example.rescuespot.admin.DTO.response.AdminResponseDTO;
import com.example.rescuespot.admin.entity.Admin;
import com.example.rescuespot.identity.entity.Account;
import com.example.rescuespot.identity.mapper.AccountMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = AccountMapper.class)
public interface IAdminMapper {
    AdminResponseDTO toResponseDTO(Admin admin);

    Admin toEntity(AdminRequestDTO adminRequestDTO);
}
