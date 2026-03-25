package com.example.rescuespot.user.repository;

import com.example.rescuespot.identity.entity.Account;
import com.example.rescuespot.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByAccount(Account account);
}
