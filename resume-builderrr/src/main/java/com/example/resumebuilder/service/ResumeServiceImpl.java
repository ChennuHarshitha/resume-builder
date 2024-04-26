package com.example.resumebuilder.service;

import com.example.resumebuilder.model.Education;
import com.example.resumebuilder.model.Experience;
import com.example.resumebuilder.model.Resume;
import com.example.resumebuilder.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Override
    public void saveResume(Resume resume) {
        resumeRepository.save(resume);
    }

    @Override
    public Resume getResumeById(Long id) {
        return resumeRepository.findById(id).orElse(null);
    }

    // Method to add education to a resume
    @Override
    public void addEducation(Long resumeId, Education education) {
        Resume resume = resumeRepository.findById(resumeId).orElse(null);
        if (resume != null) {
            resume.getEducation().add(education);
            resumeRepository.save(resume);
        }
    }

    // Method to update education in a resume
    @Override
    public void updateEducation(Long resumeId, Education education) {
        Resume resume = resumeRepository.findById(resumeId).orElse(null);
        if (resume != null) {
            // Find and update the existing education entry, if it exists
            for (Education edu : resume.getEducation()) {
                if (edu.getId().equals(education.getId())) {
                    // Update education details
                    // For example:
                    edu.setCourse(education.getCourse());
                    edu.setUniversity(education.getUniversity());
                    edu.setStartDate(education.getStartDate());
                    edu.setEndDate(education.getEndDate());
                    // Update other attributes as needed
                    break;
                }
            }
            resumeRepository.save(resume);
        }
    }

    // Method to delete education from a resume
    @Override
    public void deleteEducation(Long resumeId, Long educationId) {
        Resume resume = resumeRepository.findById(resumeId).orElse(null);
        if (resume != null) {
            // Find and remove the education entry with the given ID
            resume.getEducation().removeIf(education -> education.getId().equals(educationId));
            resumeRepository.save(resume);
        }
    }

    @Override
    public void addExperience(Long resumeId, Experience experience) {
        Resume resume = resumeRepository.findById(resumeId).orElse(null);
        if (resume != null) {
            experience.setResume(resume); // Set the resume for the experience
            resume.getExperience().add(experience); // Add experience to the resume
            resumeRepository.save(resume); // Save the updated resume
        }
    }



    @Override
    public void updateExperience(Long resumeId, Experience experience) {
        Resume resume = resumeRepository.findById(resumeId).orElse(null);
        if (resume != null) {
            // Find the experience to update based on its ID or other criteria
            for (Experience exp : resume.getExperience()) { // Corrected from getExperiences() to getExperience()
                if (exp.getId().equals(experience.getId())) {
                    // Update the experience fields as needed
                    exp.setCompanyName(experience.getCompanyName());
                    exp.setStartDate(experience.getStartDate());
                    exp.setEndDate(experience.getEndDate());
                    exp.setJobRole(experience.getJobRole());
                    exp.setDescription(experience.getDescription());
                    // Save the updated resume
                    resumeRepository.save(resume);
                    break; // Exit the loop once the experience is updated
                }
            }
        }
    }

    @Override
    public void deleteExperience(Long resumeId, Long experienceId) {
        Resume resume = resumeRepository.findById(resumeId).orElse(null);
        if (resume != null) {
            // Find and remove the experience from the list
            resume.getExperience().removeIf(exp -> exp.getId().equals(experienceId)); // Corrected from getExperiences() to getExperience()
            // Save the updated resume
            resumeRepository.save(resume);
        }
    }

}
