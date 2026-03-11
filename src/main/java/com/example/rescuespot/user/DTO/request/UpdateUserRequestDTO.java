package com.example.rescuespot.user.DTO.request;

import com.example.rescuespot.identity.DTO.request.AccountRequestDTO;
import com.example.rescuespot.identity.DTO.request.UpdateAccountRequestDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserRequestDTO {

    private UpdateAccountRequestDTO account;

    private String firstName;

    private String lastName;

    private String bio;

    private String linkedin;

    private String instagram;

    private String facebook;

    private String twitter;

    private String location;
}
