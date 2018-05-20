package com.umssonline.proymgt.repositories;

import com.umssonline.proymgt.models.Backlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BacklogRepository extends JpaRepository<Backlog, Long> {
}
