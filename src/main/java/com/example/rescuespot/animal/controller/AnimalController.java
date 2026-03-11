package com.example.rescuespot.animal.controller;

import com.example.rescuespot.animal.DTO.request.AnimalRequestDTO;
import com.example.rescuespot.animal.DTO.response.AnimalResponseDTO;
import com.example.rescuespot.animal.service.Impl.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService animalService;

    @PostMapping
    public ResponseEntity<AnimalResponseDTO> createAnimal(
            @RequestBody AnimalRequestDTO request
    ) {

        AnimalResponseDTO animal = animalService.createAnimal(request);

        return ResponseEntity.ok(animal);
    }


    @GetMapping
    public ResponseEntity<List<AnimalResponseDTO>> getAllAnimals() {

        List<AnimalResponseDTO> animals = animalService.getAllAnimals();

        return ResponseEntity.ok(animals);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AnimalResponseDTO> getAnimalById(
            @PathVariable Long id
    ) {

        AnimalResponseDTO animal = animalService.getAnimalById(id);

        return ResponseEntity.ok(animal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalResponseDTO> updateAnimal(
            @PathVariable Long id,
            @RequestBody AnimalRequestDTO request
    ) {

        AnimalResponseDTO updatedAnimal = animalService.updateAnimal(id, request);

        return ResponseEntity.ok(updatedAnimal);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnimal(
            @PathVariable Long id
    ) {

        animalService.deleteAnimal(id);

        return ResponseEntity.ok("Animal deleted successfully");
    }
}
