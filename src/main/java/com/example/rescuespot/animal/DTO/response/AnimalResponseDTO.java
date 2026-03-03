package com.example.rescuespot.animal.DTO.response;


import com.example.rescuespot.animal.entity.enumAnimal.AnimalBreed;
import com.example.rescuespot.animal.entity.enumAnimal.AnimalGender;
import com.example.rescuespot.animal.entity.enumAnimal.AnimalSpecies;
import lombok.*;

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

    private Long shelterId;
    private String shelterName;
}