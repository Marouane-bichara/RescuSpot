package com.example.rescuespot.animal.repository;

import com.example.rescuespot.animal.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnimalRepository extends JpaRepository<Animal, Long> {
}
