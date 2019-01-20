package com.umssonline.proymgt.services.api;

import com.umssonline.proymgt.models.entity.Sprint;
import com.umssonline.proymgt.models.entity.UserStory;

public interface SprintService extends CrudService<Sprint> {

    void moveTaskToAnotherSprint(Long sourceSprint, Long targetSprint, Long userStoryId);
    void activateSprint(Long sprintId);
    void markAsEnded(Long sprintId);
    Iterable<UserStory> loadUserStories(Long sprintId);
}
