package com.example.rescuespot.adoption.repository;

import com.example.rescuespot.adoption.entity.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdoptionRepository extends JpaRepository<Adoption, Long> {
}