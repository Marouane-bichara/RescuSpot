package com.example.rescuespot.identity.mapper;


import com.example.rescuespot.identity.DTO.response.AccountResponseDTO;
import com.example.rescuespot.identity.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountResponseDTO toResponse(Account account);
    Account toEntity(AccountResponseDTO accountDTO);
}
