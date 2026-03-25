package com.example.rescuespot.animal.entity;


import com.example.rescuespot.adoption.entity.Adoption;
import com.example.rescuespot.animal.entity.enumAnimal.AnimalBreed;
import com.example.rescuespot.animal.entity.enumAnimal.AnimalGender;
import com.example.rescuespot.animal.entity.enumAnimal.AnimalSpecies;
import com.example.rescuespot.shelter.entity.Shelter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_animal")
    private Long idAnimal;

    @Column(name = "animal_name" ,  nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "species")
    private AnimalSpecies species;

    @Enumerated(EnumType.STRING)
    @Column(name = "breed")
    private AnimalBreed breed;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private AnimalGender gender;

    @Column(name = "picture")
    private String picture;

    @Column(name = "age")
    private Integer age;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_shelter", nullable = false)
    private Shelter shelter;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Adoption> adoptions = new ArrayList<>();


}
