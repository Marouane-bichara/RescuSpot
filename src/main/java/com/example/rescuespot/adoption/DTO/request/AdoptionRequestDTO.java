package com.example.rescuespot.adoption.DTO.request;

import com.example.rescuespot.adoption.entity.enumAdoption.AdoptionStatus;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AdoptionRequestDTO {

    private Long animalId;
    private Long userId;
    private Long shelterId;
    private Date requestDate;
    private AdoptionStatus status;
}
