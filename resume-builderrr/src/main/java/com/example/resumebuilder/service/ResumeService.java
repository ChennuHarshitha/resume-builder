// ResumeService.java
package com.example.resumebuilder.service;

import com.example.resumebuilder.model.Education;
import com.example.resumebuilder.model.Experience;
import com.example.resumebuilder.model.Resume;

public interface ResumeService {
    void saveResume(Resume resume);
    Resume getResumeById(Long id);

    // Methods for handling educational experiences
    void addEducation(Long resumeId, Education education);
    void updateEducation(Long resumeId, Education education);
    void deleteEducation(Long resumeId, Long educationId);

    // Methods for handling work experiences
    void addExperience(Long resumeId, Experience experience);
    void updateExperience(Long resumeId, Experience experience);
    void deleteExperience(Long resumeId, Long experienceId);

    // Other methods as needed
}
