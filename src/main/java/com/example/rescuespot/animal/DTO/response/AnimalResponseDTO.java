package com.example.rescuespot.animal.DTO.response;


import com.example.rescuespot.adoption.DTO.response.AdoptionResponseDTO;
import com.example.rescuespot.animal.entity.enumAnimal.AnimalBreed;
import com.example.rescuespot.animal.entity.enumAnimal.AnimalGender;
import com.example.rescuespot.animal.entity.enumAnimal.AnimalSpecies;
import com.example.rescuespot.shelter.DTO.response.ShelterResponseDTO;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AnimalResponseDTO {

    private Long idAnimal;

    private String name;

    private AnimalSpecies species;

    private AnimalBreed breed;

    private AnimalGender gender;

    private Integer age;

    private String description;

    private ShelterResponseDTO shelter;

    private List<AdoptionResponseDTO> adoptions;
}