package com.umssonline.projmgt.repositories;

import com.umssonline.projmgt.models.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Iterable<Project> findByCreatedById(Long userId);
}
