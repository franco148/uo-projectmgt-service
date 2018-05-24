package com.umssonline.proymgt.repositories;

import com.umssonline.proymgt.models.Backlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BacklogRepository extends JpaRepository<Backlog, Long> {

    Optional<Backlog> findByProjectId(Long projectId);
}
