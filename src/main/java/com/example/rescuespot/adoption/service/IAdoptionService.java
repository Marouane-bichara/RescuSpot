package com.example.rescuespot.adoption.service;

import com.example.rescuespot.adoption.DTO.request.AdoptionRequestDTO;
import com.example.rescuespot.adoption.DTO.response.AdoptionResponseDTO;
import com.example.rescuespot.adoption.entity.enumAdoption.AdoptionStatus;

import java.util.List;

public interface IAdoptionService {
    AdoptionResponseDTO createAdoption(AdoptionRequestDTO request);

    List<AdoptionResponseDTO> getAllAdoptions();

    AdoptionResponseDTO getAdoptionById(Long id);


    void deleteAdoption(Long id);

    AdoptionResponseDTO reviewAdoption(Long adoptionId, AdoptionStatus status);
}
