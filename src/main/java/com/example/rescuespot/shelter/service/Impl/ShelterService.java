package com.example.rescuespot.shelter.service.Impl;

import com.example.rescuespot.identity.entity.Account;
import com.example.rescuespot.identity.entity.roles.Role;
import com.example.rescuespot.identity.mapper.IAccountMapper;
import com.example.rescuespot.identity.repository.IAccountRepository;
import com.example.rescuespot.shelter.DTO.request.ShelterRequestDTO;
import com.example.rescuespot.shelter.DTO.response.ShelterResponseDTO;
import com.example.rescuespot.shelter.entity.Shelter;
import com.example.rescuespot.shelter.mapper.IShelterMapper;
import com.example.rescuespot.shelter.repository.IShalterRepository;
import com.example.rescuespot.shelter.service.IShalterService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShelterService implements IShalterService {

    private final IShalterRepository shelterRepository;
    private final IAccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;


    private final IShelterMapper shelterMapper;
    private final IAccountMapper accountMapper;


    @Transactional
    public ShelterResponseDTO createShelter(ShelterRequestDTO request) {
        Shelter shelter = shelterMapper.toEntity(request);
        Account account = accountMapper.toEntity(request.getAccount());

        if (account.getPassword() == null || account.getPassword().isEmpty()) {
            throw new RuntimeException("Password is required for shelter registration");
        }
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setRole(Role.SHELTER);

        Account savedAccount = accountRepository.save(account);

        shelter.setAccount(savedAccount);
        shelter.setVerified(false);

        Shelter savedShelter = shelterRepository.save(shelter);

        savedAccount.setShelter(savedShelter);
        accountRepository.save(savedAccount);

        return shelterMapper.toResponse(savedShelter);
    }

    public List<ShelterResponseDTO> getAllShelters() {

        return shelterRepository.findAll()
                .stream()
                .map(shelterMapper::toResponse)
                .collect(Collectors.toList());
    }


    public ShelterResponseDTO getShelterById(Long id) {

        Shelter shelter = shelterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shelter not found"));

        return shelterMapper.toResponse(shelter);
    }


    public ShelterResponseDTO updateShelter(Long id, ShelterRequestDTO request) {

        Shelter shelter = shelterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shelter not found"));

        shelter.setName(request.getName());
        shelter.setDescription(request.getDescription());
        shelter.setLocation(request.getLocation());
        shelter.setPhone(request.getPhone());
        shelter.setAddress(request.getAddress());

        Shelter updatedShelter = shelterRepository.save(shelter);

        return shelterMapper.toResponse(updatedShelter);
    }


    public void deleteShelter(Long id) {

        Shelter shelter = shelterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shelter not found"));

        shelterRepository.delete(shelter);
    }

    public int getShelterByAccountId(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        Shelter shelter = shelterRepository.findByAccount(account).orElseThrow(() -> new RuntimeException("Shelter not found"));
        return shelter.getIdShelter().byteValue();
    }

}