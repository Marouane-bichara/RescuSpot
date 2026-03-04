package com.example.rescuespot.shelter.DTO.response;

import com.example.rescuespot.animal.DTO.response.AnimalResponseDTO;
import com.example.rescuespot.identity.DTO.response.AccountResponseDTO;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ShelterResponseDTO {

    private AccountResponseDTO account;

    private Long idShelter;

    private String name;

    private String description;

    private String location;

    private String phone;

    private String address;

    private boolean verified;

    private Long accountId;

    private String email;

    private String username;

    private String profilePhoto;

    private List<AnimalResponseDTO> animals;

}