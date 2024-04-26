package com.example.resumebuilder.controller;

import com.example.resumebuilder.model.Education;
import com.example.resumebuilder.model.Experience;
import com.example.resumebuilder.model.Resume;
import com.example.resumebuilder.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @GetMapping("/form")
    public String showResumeForm(Model model) {
        model.addAttribute("resume", new Resume());
        return "resumeForm";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute("resume") Resume resume) {
        resumeService.saveResume(resume);
        return "redirect:/resume/view/" + resume.getId();
    }

    @GetMapping("/view/{id}")
    public String viewResume(@PathVariable Long id, Model model) {
        Resume resume = resumeService.getResumeById(id);
        model.addAttribute("resume", resume);
        return "viewResume";
    }

    // Method to add education to a resume
    @PostMapping("/addEducation/{id}")
    public String addEducation(@PathVariable Long id, @ModelAttribute("education") Education education) {
        resumeService.addEducation(id, education);
        return "redirect:/resume/view/" + id;
    }

    // Method to update education in a resume
    @PostMapping("/updateEducation/{resumeId}/{educationId}")
    public String updateEducation(@PathVariable Long resumeId, @PathVariable Long educationId, @ModelAttribute("education") Education education) {
        resumeService.updateEducation(resumeId, education);
        return "redirect:/resume/view/" + resumeId;
    }

    // Method to delete education from a resume
    @PostMapping("/deleteEducation/{resumeId}/{educationId}")
    public String deleteEducation(@PathVariable Long resumeId, @PathVariable Long educationId) {
        resumeService.deleteEducation(resumeId, educationId);
        return "redirect:/resume/view/" + resumeId;
    }

    // Method to add experience to a resume
    @PostMapping("/addExperience/{id}")
    public String addExperience(@PathVariable Long id, @ModelAttribute("experience") Experience experience) {
        resumeService.addExperience(id, experience);
        return "redirect:/resume/view/" + id;
    }

    // Method to update experience in a resume
    @PostMapping("/updateExperience/{resumeId}/{experienceId}")
    public String updateExperience(@PathVariable Long resumeId, @PathVariable Long experienceId, @ModelAttribute("experience") Experience experience) {
        resumeService.updateExperience(resumeId, experience);
        return "redirect:/resume/view/" + resumeId;
    }

    // Method to delete experience from a resume
    @PostMapping("/deleteExperience/{resumeId}/{experienceId}")
    public String deleteExperience(@PathVariable Long resumeId, @PathVariable Long experienceId) {
        resumeService.deleteExperience(resumeId, experienceId);
        return "redirect:/resume/view/" + resumeId;
    }
}