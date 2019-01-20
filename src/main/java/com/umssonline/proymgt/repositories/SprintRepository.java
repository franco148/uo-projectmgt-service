package com.umssonline.proymgt.repositories;

import com.umssonline.proymgt.models.entity.Sprint;
import com.umssonline.proymgt.models.entity.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {

    @Query("SELECT COUNT(s) FROM Sprint s WHERE s.isActive = ?1")
    Long countActiveSprints(boolean isActive);
}
