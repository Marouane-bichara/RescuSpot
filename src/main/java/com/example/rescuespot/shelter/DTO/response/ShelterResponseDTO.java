package com.example.rescuespot.shelter.DTO.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ShelterResponseDTO {

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

//    private List<AnimalResponseDTO> animals;

}