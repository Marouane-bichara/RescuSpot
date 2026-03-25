package com.example.rescuespot.adoption.repository;

import com.example.rescuespot.adoption.entity.Adoption;
import com.example.rescuespot.animal.entity.Animal;
import com.example.rescuespot.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdoptionRepository extends JpaRepository<Adoption, Long> {
    Adoption getAdoptionByAnimal(Animal animal);

    Adoption getAdoptionByAnimalAndUser(Animal animal, User user);
}