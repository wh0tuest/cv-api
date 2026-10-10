package com.oleksandr.cv_api.repository;
import com.oleksandr.cv_api.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
 
    List<Project> findAllByOrderBySortOrderAsc();
}
