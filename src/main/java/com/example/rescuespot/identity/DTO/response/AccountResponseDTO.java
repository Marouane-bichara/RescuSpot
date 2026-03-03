package com.example.rescuespot.identity.DTO.response;


import com.example.rescuespot.identity.entity.roles.Role;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AccountResponseDTO {
    private Long idAccount;
    private String email;
    private String password;
    private String username;
    private String profilePhoto;
    private Role role;
    private Date creationDate;
}
