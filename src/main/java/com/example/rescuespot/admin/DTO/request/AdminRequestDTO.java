package com.example.rescuespot.admin.DTO.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AdminRequestDTO {

    private Long accountId;

    private String department;
}