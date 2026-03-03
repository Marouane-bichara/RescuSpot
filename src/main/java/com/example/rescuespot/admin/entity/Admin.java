package com.example.rescuespot.admin.entity;

import com.example.rescuespot.identity.entity.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin")
    private Long idAdmin;

    @OneToOne
    @JoinColumn(
            name = "id_account",
            referencedColumnName = "id_account",
            nullable = false,
            unique = true
    )
    private Account account;


    @Column
    private String department;


}