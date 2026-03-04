package com.example.rescuespot.adoption.mapper;

import com.example.rescuespot.adoption.DTO.request.AdoptionRequestDTO;
import com.example.rescuespot.adoption.DTO.response.AdoptionResponseDTO;
import com.example.rescuespot.adoption.entity.Adoption;
import com.example.rescuespot.animal.mapper.IAnimalMapper;
import com.example.rescuespot.shelter.mapper.IShelterMapper;
import com.example.rescuespot.user.mapper.IUserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {IAnimalMapper.class, IUserMapper.class, IShelterMapper.class})

public interface IAdoptionMapper {

    IAdoptionMapper INSTANCE = Mappers.getMapper(IAdoptionMapper.class);
    @Mapping(source = "animalId", target = "animal.idAnimal")
    @Mapping(source = "userId", target = "user.idUser")
    @Mapping(source = "shelterId", target = "shelter.idShelter")
    Adoption toEntity(AdoptionRequestDTO dto);

    AdoptionResponseDTO toAdoptionResponseDTO(Adoption adoption);


}
