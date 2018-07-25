package com.umssonline.proymgt.repositories;

import com.umssonline.proymgt.models.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
