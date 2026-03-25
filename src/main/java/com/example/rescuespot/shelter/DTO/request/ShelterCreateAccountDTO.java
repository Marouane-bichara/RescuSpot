package com.example.rescuespot.shelter.DTO.request;

import com.example.rescuespot.identity.DTO.request.AccountRequestDTO;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ShelterCreateAccountDTO {
    private AccountRequestDTO account;

    private String name;

    private String phone;

}
