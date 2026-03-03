package com.example.rescuespot.admin.repository;


import com.example.rescuespot.admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long> {
}
