package com.example.rescuespot.adoption.entity;

import com.example.rescuespot.adoption.entity.enumAdoption.AdoptionStatus;
import com.example.rescuespot.animal.entity.Animal;
import com.example.rescuespot.shelter.entity.Shelter;
import com.example.rescuespot.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "adoptions")
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adoption")
    private Long idAdoption;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_animal", nullable = false)
    private Animal animal;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private User user;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_shelter", nullable = false)
    private Shelter shelter;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "request_date")
    private Date requestDate = new Date();


    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AdoptionStatus status = AdoptionStatus.PENDING;


}
