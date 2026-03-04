package com.example.rescuespot.user.DTO.request;


import com.example.rescuespot.identity.DTO.request.AccountRequestDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserRequestDTO {


    private AccountRequestDTO account;
    private String firstName;
    private String lastName;

}
