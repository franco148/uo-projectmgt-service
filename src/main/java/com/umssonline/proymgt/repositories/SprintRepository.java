package com.umssonline.proymgt.repositories;

import com.umssonline.proymgt.models.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {

    Collection<Sprint> findByProjectId(Long projectId);
}
