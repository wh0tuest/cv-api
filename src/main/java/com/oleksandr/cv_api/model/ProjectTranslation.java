package com.oleksandr.cv_api.model;

import jakarta.persistence.*;

@Entity 
public class ProjectTranslation {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String language;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    protected ProjectTranslation() {
    }

    public ProjectTranslation(Project project, String language, String title, String description) {
        this.project = project;
        this.language = language;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    
    public Project getProject() {
        return project;
    }

}
