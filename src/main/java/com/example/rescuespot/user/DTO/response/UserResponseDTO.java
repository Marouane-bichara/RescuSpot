package com.example.rescuespot.user.DTO.response;


import com.example.rescuespot.adoption.DTO.response.AdoptionLightDTO;
import com.example.rescuespot.adoption.DTO.response.AdoptionResponseDTO;
import com.example.rescuespot.identity.DTO.response.AccountResponseDTO;
import com.example.rescuespot.report.DTO.response.ReportResponseDTO;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserResponseDTO {

    private Long idUser;

    private AccountResponseDTO account;

    private String firstName;

    private String lastName;

    private String bio;

    private String linkedin;

    private String instagram;

    private String facebook;

    private String twitter;

    private String location;


    private List<ReportResponseDTO> reports;

    private List<AdoptionLightDTO> adoptions;
}
