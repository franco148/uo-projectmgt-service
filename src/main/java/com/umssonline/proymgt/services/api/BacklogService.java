package com.umssonline.proymgt.services.api;

import com.umssonline.proymgt.models.entity.Backlog;
import com.umssonline.proymgt.models.entity.UserStory;

public interface BacklogService extends CrudService<Backlog> {

    UserStory addUserStory(Long backlogId, UserStory userStory);

    boolean sendUserStoryToSprint(Long backlogId, Long userStoryId, Long sprintId);

    void deleteUserStory(Long backlogId, Long userStoryId);

    Backlog loadUserStories(Long backlogId);
}
