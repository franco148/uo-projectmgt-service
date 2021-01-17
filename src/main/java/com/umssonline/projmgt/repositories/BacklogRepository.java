package com.umssonline.projmgt.repositories;

import com.umssonline.projmgt.models.entity.Backlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends JpaRepository<Backlog, Long> {

    //Optional<Backlog> findByProjectId(Long projectId);
}
