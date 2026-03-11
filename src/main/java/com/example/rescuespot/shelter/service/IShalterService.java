package com.example.rescuespot.shelter.service;

import com.example.rescuespot.shelter.DTO.request.ShelterRequestDTO;
import com.example.rescuespot.shelter.DTO.response.ShelterResponseDTO;

import java.util.List;

public interface IShalterService {

    ShelterResponseDTO createShelter(ShelterRequestDTO request);

    List<ShelterResponseDTO> getAllShelters();

    ShelterResponseDTO getShelterById(Long id);

    ShelterResponseDTO updateShelter(Long id, ShelterRequestDTO request);

    void deleteShelter(Long id);
}
