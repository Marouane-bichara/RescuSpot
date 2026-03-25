package com.example.rescuespot.shelter.mapper;


import com.example.rescuespot.animal.mapper.IAnimalMapper;
import com.example.rescuespot.identity.mapper.IAccountMapper;
import com.example.rescuespot.shelter.DTO.request.ShelterCreateAccountDTO;
import com.example.rescuespot.shelter.DTO.request.ShelterRequestDTO;
import com.example.rescuespot.shelter.DTO.response.ShelterResponseDTO;
import com.example.rescuespot.shelter.entity.Shelter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {IAccountMapper.class , IAnimalMapper.class} )
public interface IShelterMapper {
    ShelterResponseDTO toResponse(Shelter shelter);
    Shelter toEntity(ShelterRequestDTO dto);
    Shelter toCreateShelterResponseDTO(ShelterCreateAccountDTO shelter);
}
