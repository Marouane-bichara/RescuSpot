package com.example.rescuespot.shelter.entity;


import com.example.rescuespot.adoption.entity.Adoption;
import com.example.rescuespot.identity.entity.Account;
import com.example.rescuespot.report.entity.Report;
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
@Table(name = "shelters")
public class Shelter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shelter")
    private Long idShelter;

    @OneToOne
    @JoinColumn(
            name = "id_account",
            referencedColumnName = "id_account",
            nullable = false,
            unique = true
    )
    private Account account;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String location;

    @Column
    private String phone;

    @Column
    private String address;

    @Column
    private boolean verified;


    @OneToMany(mappedBy = "shelter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Adoption> adoptions = new ArrayList<>();

    @OneToMany(mappedBy = "rescuerShelter")
    private List<Report> rescuedReports = new ArrayList<>();
}
