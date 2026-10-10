package com.oleksandr.cv_api.service;


import com.oleksandr.cv_api.dto.ProjectData;
import com.oleksandr.cv_api.model.Project;
import com.oleksandr.cv_api.model.ProjectTranslation;
import com.oleksandr.cv_api.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.oleksandr.cv_api.exception.UnsupportedLanguageException;
import java.util.Set;
import java.util.List;

@Service 
public class ProjectService {

    private final ProjectRepository projectRepository;
    private static final Set<String> SUPPORTED_LANGUAGES = Set.of("en", "pl", "uk");

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Transactional(readOnly = true)
    public List<ProjectData> getProjects(String language){
        if(!SUPPORTED_LANGUAGES.contains(language)) {
            throw new UnsupportedLanguageException(language);
        }
               return projectRepository.findAllByOrderBySortOrderAsc()
                .stream()
                .map(project -> toDto(project, language))
                .toList();
    }

    private ProjectData toDto(Project project, String language) {
        ProjectTranslation translation = project.getTranslations().stream()
                .filter(t -> t.getLanguage().equals(language))
                .findFirst()
                .orElseThrow();
        return new ProjectData(
                project.getId(),
                translation.getTitle(),
                translation.getDescription(),
                project.getGithubUrl(),
                List.copyOf(project.getTechnologies()));
    }
}