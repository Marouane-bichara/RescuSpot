package com.example.rescuespot.adoption.controller;

import com.example.rescuespot.adoption.DTO.request.AdoptionDecisionDTO;
import com.example.rescuespot.adoption.DTO.request.AdoptionRequestDTO;
import com.example.rescuespot.adoption.DTO.response.AdoptionResponseDTO;
import com.example.rescuespot.adoption.service.IAdoptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adoptions")
@RequiredArgsConstructor
public class AdoptionController {

    private final IAdoptionService adoptionService;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<AdoptionResponseDTO> createAdoption(
            @RequestBody AdoptionRequestDTO request
    ) {

        AdoptionResponseDTO adoption = adoptionService.createAdoption(request);

        return ResponseEntity.ok(adoption);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN' , 'SHELTER')")
    public ResponseEntity<List<AdoptionResponseDTO>> getAllAdoptions() {

        return ResponseEntity.ok(adoptionService.getAllAdoptions());
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN' , 'SHELTER')")
    public ResponseEntity<AdoptionResponseDTO> getAdoptionById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(adoptionService.getAdoptionById(id));
    }

    @PatchMapping("/{id}/review")
    @PreAuthorize("hasRole('SHELTER')")
    public ResponseEntity<AdoptionResponseDTO> reviewAdoption(
            @PathVariable Long id,
            @RequestBody AdoptionDecisionDTO decision
    ) {

        AdoptionResponseDTO adoption =
                adoptionService.reviewAdoption(id, decision.getStatus());

        return ResponseEntity.ok(adoption);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> deleteAdoption(
            @PathVariable Long id
    ) {

        adoptionService.deleteAdoption(id);

        return ResponseEntity.ok("Adoption deleted successfully");
    }
}