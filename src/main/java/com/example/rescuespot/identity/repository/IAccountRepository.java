package com.example.rescuespot.identity.repository;

import com.example.rescuespot.identity.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Long> {
}
