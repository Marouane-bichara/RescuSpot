package com.example.rescuespot.report.entity;


import com.example.rescuespot.report.entity.enumReport.HealthAnimalStatus;
import com.example.rescuespot.report.entity.enumReport.ReportStatus;
import com.example.rescuespot.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_report")
    private Long idReport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column
    private String location;

    @ElementCollection
    @CollectionTable(name = "report_photos",
            joinColumns = @JoinColumn(name = "report_id"))
    @Column(name = "photo_url")
    private List<String> photos = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "health_status")
    private HealthAnimalStatus healthStatus;

    @Column
    private String description;

    @Column
    private Date reportedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "report_status")
    private ReportStatus reportStatus =  ReportStatus.PENDING;
}
