package com.example.rescuespot.shelter.repository;

import com.example.rescuespot.identity.entity.Account;
import com.example.rescuespot.shelter.entity.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IShalterRepository extends JpaRepository<Shelter , Long> {
    Optional<Shelter> findByAccount(Account account);
}
