package com.oleksandr.cv_api.repository;
import com.oleksandr.cv_api.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    
}
