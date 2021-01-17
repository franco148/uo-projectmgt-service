package com.umssonline.projmgt.services.api;

import com.umssonline.projmgt.models.entity.Sprint;
import com.umssonline.projmgt.models.entity.UserStory;

public interface SprintService extends CrudService<Sprint> {

    void moveTaskToAnotherSprint(Long sourceSprint, Long targetSprint, Long userStoryId);
    void activateSprint(Long sprintId);
    void markAsEnded(Long sprintId);
    Iterable<UserStory> loadUserStories(Long sprintId);
}
