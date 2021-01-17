package com.umssonline.projmgt.repositories;

import com.umssonline.projmgt.models.entity.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStoryRepository extends JpaRepository<UserStory, Long> {

    UserStory findByIdAndBacklogId(Long userStoryId, Long backlogId);

    UserStory findByIdAndSprintId(Long userStoryId, Long sprintId);

    Iterable<UserStory> findByBacklogId(Long backlogId);

    Iterable<UserStory> findBySprintId(Long sprintId);
}
