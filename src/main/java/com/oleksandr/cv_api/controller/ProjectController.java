package com.oleksandr.cv_api.controller;

import com.oleksandr.cv_api.dto.ProjectData;
import com.oleksandr.cv_api.service.ProjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/api/projects")
    public List<ProjectData> getProjects(@RequestParam(name = "lang", defaultValue = "en") String language) {
        return projectService.getProjects(language);
    }
}

