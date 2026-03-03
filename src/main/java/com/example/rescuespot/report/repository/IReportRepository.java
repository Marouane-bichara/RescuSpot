package com.example.rescuespot.report.repository;


import com.example.rescuespot.report.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReportRepository extends JpaRepository<Report,Long> {
}
