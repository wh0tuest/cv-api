package com.oleksandr.cv_api.model;


import jakarta.persistence.*;
import jakarta.persistence.Id;
import java.util.List;
import java.util.ArrayList;

@Entity 
public class Project {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;     

    private String githubUrl;
    private int sortOrder;

    @ElementCollection 
    private List<String> technologies = new java.util.ArrayList<>();

    @OneToMany (mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectTranslation> translations = new ArrayList<>();

    protected Project() {
    }

    public Project(String githubUrl, int sortOrder, List<String> technologies) {
        this.githubUrl = githubUrl;
        this.sortOrder = sortOrder;
        this.technologies = technologies;
    }

    public Long getId() {
        return id;
    }
    public String getGithubUrl() {
        return githubUrl;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public void addTranslation(String language, String title, String description) {
        translations.add(new ProjectTranslation(this, language, title, description));
    }

    public List<ProjectTranslation> getTranslations() {
        return translations;
    }

}
