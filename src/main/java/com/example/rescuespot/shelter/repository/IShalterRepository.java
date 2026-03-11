package com.example.rescuespot.shelter.repository;

import com.example.rescuespot.shelter.entity.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShalterRepository extends JpaRepository<Shelter , Long> {
}
