package com.umssonline.projmgt.repositories;

import com.umssonline.projmgt.models.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {

    @Query("SELECT COUNT(s) FROM Sprint s WHERE s.isActive = ?1")
    Long countActiveSprints(boolean isActive);
}
