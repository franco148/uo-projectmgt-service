package com.umssonline.proymgt.services.api;

import com.umssonline.proymgt.models.entity.Sprint;

public interface SprintService extends CrudService<Sprint> {

    void moveTaskToAnotherSprint(Long sourceSprint, Long targetSprint, Long userStoryId);
    void activateSprint(Long sprintId);
    void markAsEnded(Long sprintId);
    //Sprint loadUserStories(Long sprintId);
}
