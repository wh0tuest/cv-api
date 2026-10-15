package com.oleksandr.cv_api.service;

import com.oleksandr.cv_api.dto.ProjectData;
import com.oleksandr.cv_api.exception.UnsupportedLanguageException;
import com.oleksandr.cv_api.model.Project;
import com.oleksandr.cv_api.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;  

    @Test
    void returnsProjectInRequestedLanguage() {
        Project project = new Project("https://github.com/test", 1, List.of("Java"));
        project.addTranslation("en", "English title", "English description");
        project.addTranslation("pl", "Polski tytuł", "Polski opis");
        when(projectRepository.findAllByOrderBySortOrderAsc()).thenReturn(List.of(project));

        List<ProjectData> result = projectService.getProjects("pl");

        assertThat(result).hasSize(1);
        assertThat(result.get(0).title()).isEqualTo("Polski tytuł");
        assertThat(result.get(0).description()).isEqualTo("Polski opis");
    }

    @Test
    void throwsExceptionForUnsupportedLanguage() {
        assertThatThrownBy(() -> projectService.getProjects("de"))
                .isInstanceOf(UnsupportedLanguageException.class)
                .hasMessageContaining("de");

        verifyNoInteractions(projectRepository);
    }

	@Test 
	void returnsTechnologiesAndGithubUrl() {
		Project project = new Project("https://github.com/test", 1, List.of("Java", "Spring Boot"));
		project.addTranslation("en", "English title", "English description");
		when(projectRepository.findAllByOrderBySortOrderAsc()).thenReturn(List.of(project));

		List<ProjectData> result = projectService.getProjects("en");
		
		ProjectData dto = result.get(0);
		assertThat(dto.githubUrl()).isEqualTo("https://github.com/test");
		assertThat(dto.technologies()).containsExactly("Java", "Spring Boot");
	}
}
