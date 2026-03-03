package com.example.rescuespot.admin.DTO.response;


import com.example.rescuespot.identity.DTO.response.AccountResponseDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AdminResponseDTO  {
    private  Long idAdmin;
    private String department;

    private AccountResponseDTO account;
}
