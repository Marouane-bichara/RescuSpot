package com.example.rescuespot.adoption.DTO.request;

import com.example.rescuespot.adoption.entity.enumAdoption.AdoptionStatus;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AdoptionDecisionDTO {

    private AdoptionStatus status;

}