package com.example.rescuespot.animal.service.Impl;

import com.example.rescuespot.animal.DTO.request.AnimalRequestDTO;
import com.example.rescuespot.animal.DTO.response.AnimalResponseDTO;
import com.example.rescuespot.animal.entity.Animal;
import com.example.rescuespot.animal.mapper.IAnimalMapper;
import com.example.rescuespot.animal.repository.IAnimalRepository;
import com.example.rescuespot.shelter.entity.Shelter;
import com.example.rescuespot.shelter.repository.IShalterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final IAnimalRepository animalRepository;
    private final IShalterRepository shelterRepository;
    private final IAnimalMapper animalMapper;


    public AnimalResponseDTO createAnimal(AnimalRequestDTO request) {

        Animal animal = animalMapper.toEntity(request);

        Shelter shelter = shelterRepository.findById(request.getShelterId())
                .orElseThrow(() -> new RuntimeException("Shelter not found"));

        animal.setShelter(shelter);

        Animal savedAnimal = animalRepository.save(animal);

        return animalMapper.toDTO(savedAnimal);
    }


    public List<AnimalResponseDTO> getAllAnimals() {

        return animalRepository.findAll()
                .stream()
                .map(animalMapper::toDTO)
                .collect(Collectors.toList());
    }


    public AnimalResponseDTO getAnimalById(Long id) {

        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal not found"));

        return animalMapper.toDTO(animal);
    }


    public AnimalResponseDTO updateAnimal(Long id, AnimalRequestDTO request) {

        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal not found"));

        animal.setName(request.getName());
        animal.setSpecies(request.getSpecies());
        animal.setBreed(request.getBreed());
        animal.setGender(request.getGender());
        animal.setAge(request.getAge());
        animal.setDescription(request.getDescription());

        if (request.getShelterId() != null) {

            Shelter shelter = shelterRepository.findById(request.getShelterId())
                    .orElseThrow(() -> new RuntimeException("Shelter not found"));

            animal.setShelter(shelter);
        }

        Animal updatedAnimal = animalRepository.save(animal);

        return animalMapper.toDTO(updatedAnimal);
    }


    public void deleteAnimal(Long id) {

        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal not found"));

        animalRepository.delete(animal);
    }
}