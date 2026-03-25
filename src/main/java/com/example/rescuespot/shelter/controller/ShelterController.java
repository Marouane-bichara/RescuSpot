package com.example.rescuespot.shelter.controller;

import com.example.rescuespot.shelter.DTO.request.ShelterRequestDTO;
import com.example.rescuespot.shelter.DTO.response.ShelterResponseDTO;
import com.example.rescuespot.shelter.service.IShalterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shelters")
@RequiredArgsConstructor
public class ShelterController {

    private final IShalterService shelterService;


    @PostMapping
    public ResponseEntity<ShelterResponseDTO> createShelter(
            @RequestBody ShelterRequestDTO request
    ) {

        ShelterResponseDTO shelter = shelterService.createShelter(request);

        return ResponseEntity.ok(shelter);
    }


    @GetMapping
    @PreAuthorize("hasAnyRole('SHELTER' , 'USER' , 'ADMIN')")
    public ResponseEntity<List<ShelterResponseDTO>> getAllShelters() {

        List<ShelterResponseDTO> shelters = shelterService.getAllShelters();

        return ResponseEntity.ok(shelters);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SHELTER' , 'USER' , 'ADMIN')")
    public ResponseEntity<ShelterResponseDTO> getShelterById(
            @PathVariable Long id
    ) {

        ShelterResponseDTO shelter = shelterService.getShelterById(id);

        return ResponseEntity.ok(shelter);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SHELTER')")
    public ResponseEntity<ShelterResponseDTO> updateShelter(
            @PathVariable Long id,
            @RequestBody ShelterRequestDTO request
    ) {

        ShelterResponseDTO updatedShelter = shelterService.updateShelter(id, request);

        return ResponseEntity.ok(updatedShelter);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SHELTER' , 'USER')")
    public ResponseEntity<String> deleteShelter(
            @PathVariable Long id
    ) {

        shelterService.deleteShelter(id);

        return ResponseEntity.ok("Shelter deleted successfully");
    }

    @GetMapping("/{id}/getShelterByAccount")

    public ResponseEntity<Integer> getShelterByAccount(
            @PathVariable Long id
    ) {

         int value  = shelterService.getShelterByAccountId(id);

        return ResponseEntity.ok(value);
    }



}