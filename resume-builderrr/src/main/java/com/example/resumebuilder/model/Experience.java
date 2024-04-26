package com.example.resumebuilder.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Experience {
    @ManyToOne
    private Resume resume;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String jobRole;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Setter method for Resume attribute
    public void setResume(Resume resume) {
        this.resume = resume;
    }

    // Getter method for Resume attribute
    public Resume getResume() {
        return resume;
    }
}
