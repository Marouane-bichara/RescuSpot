package com.example.rescuespot.user.entity;

import com.example.rescuespot.adoption.entity.Adoption;
import com.example.rescuespot.identity.entity.Account;
import com.example.rescuespot.report.entity.Report;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "id_account",
            referencedColumnName = "id_account",
            nullable = false,
            unique = true
    )
    private Account account;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String bio;

    @Column
    private String linkedin;

    @Column
    private String instagram;

    @Column
    private String facebook;

    @Column
    private String twitter;

    @Column
    private String location;

    @Column
    private int followersCount;

    @Column
    private int followingCount;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Report> reports = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Adoption> adoptions = new ArrayList<>();
}
