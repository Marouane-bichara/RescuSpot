package com.example.rescuespot.user.DTO.request;

import com.example.rescuespot.identity.DTO.request.AccountRequestDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UpdateUserRequestDTO {
    private AccountRequestDTO account;
    private String location;
    private String firstName;
    private String lastName;
}
