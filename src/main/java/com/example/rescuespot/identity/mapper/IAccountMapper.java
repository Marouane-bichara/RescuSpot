package com.example.rescuespot.identity.mapper;


import com.example.rescuespot.identity.DTO.request.AccountRequestDTO;
import com.example.rescuespot.identity.DTO.response.AccountResponseDTO;
import com.example.rescuespot.identity.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAccountMapper {

    AccountResponseDTO toResponse(Account account);
    Account toEntity(AccountRequestDTO dto);
}
