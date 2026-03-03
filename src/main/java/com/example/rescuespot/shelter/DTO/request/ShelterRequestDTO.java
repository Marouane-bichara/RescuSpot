package com.example.rescuespot.shelter.DTO.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ShelterRequestDTO {

    private Long accountId;

    private String name;

    private String description;

    private String location;

    private String phone;

    private String address;
}