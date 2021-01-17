package com.umssonline.projmgt.repositories;

import com.umssonline.projmgt.models.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    void deleteByIdAndUserStoryId(Long taskId, Long userStoryId);
}
