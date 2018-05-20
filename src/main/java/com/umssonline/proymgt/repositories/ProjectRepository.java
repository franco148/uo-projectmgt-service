package com.umssonline.proymgt.repositories;

import com.umssonline.proymgt.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
