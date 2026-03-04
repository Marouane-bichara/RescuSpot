package com.example.rescuespot.identity.DTO.request;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AccountRequestDTO {
    private String email;
    private String password;
    private String username;
}
