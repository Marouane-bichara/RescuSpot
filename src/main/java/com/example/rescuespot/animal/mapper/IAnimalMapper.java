package com.example.rescuespot.animal.mapper;

import com.example.rescuespot.animal.DTO.request.AnimalRequestDTO;
import com.example.rescuespot.animal.DTO.response.AnimalResponseDTO;
import com.example.rescuespot.animal.entity.Animal;
import com.example.rescuespot.shelter.mapper.IShelterMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = {IShelterMapper.class}
)
public interface IAnimalMapper {

    @Mapping(source = "shelterId", target = "shelter.idShelter")
    Animal toEntity(AnimalRequestDTO dto);

    @Mapping(target = "adoptions", ignore = true)
    AnimalResponseDTO toDTO(Animal animal);
}