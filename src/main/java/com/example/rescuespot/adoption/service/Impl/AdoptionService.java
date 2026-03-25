package com.example.rescuespot.adoption.service.Impl;

import com.example.rescuespot.adoption.DTO.request.AdoptionRequestDTO;
import com.example.rescuespot.adoption.DTO.response.AdoptionResponseDTO;
import com.example.rescuespot.adoption.entity.Adoption;
import com.example.rescuespot.adoption.entity.enumAdoption.AdoptionStatus;
import com.example.rescuespot.adoption.mapper.IAdoptionMapper;
import com.example.rescuespot.adoption.repository.IAdoptionRepository;
import com.example.rescuespot.adoption.service.IAdoptionService;
import com.example.rescuespot.animal.entity.Animal;
import com.example.rescuespot.animal.repository.IAnimalRepository;
import com.example.rescuespot.shelter.entity.Shelter;
import com.example.rescuespot.shelter.repository.IShalterRepository;
import com.example.rescuespot.user.entity.User;
import com.example.rescuespot.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdoptionService implements IAdoptionService {

    private final IAdoptionRepository adoptionRepository;

    private final IAnimalRepository animalRepository;
    private final UserRepository userRepository;
    private final IShalterRepository shelterRepository;

    private final IAdoptionMapper adoptionMapper;


    public AdoptionResponseDTO createAdoption(AdoptionRequestDTO request) {

        Animal animal = animalRepository.findById(request.getAnimalId())
                .orElseThrow(() -> new RuntimeException("Animal not found"));

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Shelter shelter = shelterRepository.findById(request.getShelterId())
                .orElseThrow(() -> new RuntimeException("Shelter not found"));

        Adoption adoptionPrev = adoptionRepository.getAdoptionByAnimalAndUser(animal, user);

        if(adoptionPrev != null)
        {
            throw new RuntimeException("Adoption already exists");
        }


        Adoption adoption = adoptionMapper.toEntity(request);

        adoption.setAnimal(animal);
        adoption.setUser(user);
        adoption.setShelter(shelter);

        adoption.setRequestDate(new Date());

        adoption.setStatus(AdoptionStatus.PENDING);

        Adoption savedAdoption = adoptionRepository.save(adoption);

        return adoptionMapper.toAdoptionResponseDTO(savedAdoption);
    }


    public List<AdoptionResponseDTO> getAllAdoptions() {

        return adoptionRepository.findAll()
                .stream()
                .map(adoptionMapper::toAdoptionResponseDTO)
                .collect(Collectors.toList());
    }


    public AdoptionResponseDTO getAdoptionById(Long id) {

        Adoption adoption = adoptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adoption not found"));

        return adoptionMapper.toAdoptionResponseDTO(adoption);
    }




    public void deleteAdoption(Long id) {

        Adoption adoption = adoptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adoption not found"));

        adoptionRepository.delete(adoption);
    }

    public AdoptionResponseDTO reviewAdoption(Long adoptionId, AdoptionStatus status) {

        Adoption adoption = adoptionRepository.findById(adoptionId)
                .orElseThrow(() -> new RuntimeException("Adoption not found"));

        Shelter shelter = shelterRepository.findById(adoption.getShelter().getIdShelter())
                .orElseThrow(() -> new RuntimeException("Shelter not found"));

        if (adoption.getStatus() != AdoptionStatus.PENDING) {
            throw new RuntimeException("Adoption already processed");
        }

        if (status != AdoptionStatus.APPROVED && status != AdoptionStatus.REJECTED) {
            throw new RuntimeException("Invalid status");
        }

        adoption.setStatus(status);

        Adoption updated = adoptionRepository.save(adoption);

        return adoptionMapper.toAdoptionResponseDTO(updated);
    }
}