package com.example.rescuespot.identity.entity;

import com.example.rescuespot.follow.entity.Follow;
import com.example.rescuespot.admin.entity.Admin;
import com.example.rescuespot.shelter.entity.Shelter;
import com.example.rescuespot.user.entity.User;
import com.example.rescuespot.identity.entity.roles.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account")
    private Long idAccount;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

    @Column
    private String profilePhoto;

    @Column
    private String profileBackground;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @OneToOne(mappedBy = "account")
    private User user;

    @OneToOne(mappedBy = "account")
    private Admin admin;

    @OneToOne(mappedBy = "account")
    private Shelter shelter;

    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Follow> following;

    @OneToMany(mappedBy = "followed", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Follow> followers;
}
