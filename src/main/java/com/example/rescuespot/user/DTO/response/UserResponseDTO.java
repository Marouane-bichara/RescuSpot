package com.example.rescuespot.user.DTO.response;


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

    private AccountResponseDTO account;
    private Long idUser;
    private String firstName;
    private String lastName;
    private String bio;
    private String Linkedine;
    private String instagram;
    private String facebook;
    private String twitter;
    private String location;
    private int followersCount;
    private int followingCount;

    private List<ReportResponseDTO> reports;
}
