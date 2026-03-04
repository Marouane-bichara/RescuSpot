package com.example.rescuespot.adoption.DTO.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AdoptionLightDTO {
    private Long idAdoption;
    private String status;
}
