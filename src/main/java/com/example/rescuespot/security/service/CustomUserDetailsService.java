package com.example.rescuespot.security.service;

import com.example.rescuespot.identity.entity.Account;
import com.example.rescuespot.identity.repository.IAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final IAccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return accountRepository.findByEmail(email)
                .map(account -> new org.springframework.security.core.userdetails.User(
                        account.getEmail(),
                        account.getPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + account.getRole().name()))
                ))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    // Helper method to gather claims for the JWT
    public Map<String, Object> getCustomClaims(String email) {
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Account not found"));

        Map<String, Object> claims = new HashMap<>();
        claims.put("accountId", account.getIdAccount());
        claims.put("role", account.getRole());
        claims.put("username", account.getUsername());
        claims.put("profilePhoto", account.getProfilePhoto());

        // Check if it's a User or a Shelter and add the specific ID
        if (account.getUser() != null) {
            claims.put("userId", account.getUser().getIdUser());
            claims.put("firstName", account.getUser().getFirstName());
        } else if (account.getShelter() != null) {
            claims.put("shelterId", account.getShelter().getIdShelter());
            claims.put("shelterName", account.getShelter().getName());
        }

        return claims;
    }
}