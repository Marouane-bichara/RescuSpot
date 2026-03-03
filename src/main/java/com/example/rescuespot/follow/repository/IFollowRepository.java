package com.example.rescuespot.follow.repository;

import com.example.rescuespot.follow.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFollowRepository extends JpaRepository<Follow, Long> {
}
