package com.example.rescuespot.identity.DTO.request;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateAccountRequestDTO {

    private String email;

    private String password;

    private String username;

    private String profilePhoto;

    private String profileBackground;
}
