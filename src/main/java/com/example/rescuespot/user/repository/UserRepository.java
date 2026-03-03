package com.example.rescuespot.user.repository;

import com.example.rescuespot.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
