package com.example.rescuespot.adoption.DTO.response;


import com.example.rescuespot.adoption.entity.enumAdoption.AdoptionStatus;
import com.example.rescuespot.animal.DTO.response.AnimalResponseDTO;
import com.example.rescuespot.shelter.DTO.response.ShelterResponseDTO;
import com.example.rescuespot.user.DTO.response.UserResponseDTO;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AdoptionResponseDTO {
    private Long idAdoption;

    private AnimalResponseDTO animal;

    private UserResponseDTO user;

    private ShelterResponseDTO shelter;

    private Date requestDate;

    private AdoptionStatus status;
}
