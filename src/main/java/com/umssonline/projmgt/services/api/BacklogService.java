package com.umssonline.projmgt.services.api;

import com.umssonline.projmgt.models.dto.story.UserStoryResponseDto;
import com.umssonline.projmgt.models.entity.Backlog;
import com.umssonline.projmgt.models.entity.UserStory;

public interface BacklogService extends CrudService<Backlog> {

    UserStoryResponseDto addUserStory(Long backlogId, UserStory userStory);

    void sendUserStoryToSprint(Long backlogId, Long userStoryId, Long sprintId);

    void deleteUserStory(Long backlogId, Long userStoryId);

    Iterable<UserStoryResponseDto> loadUserStories(Long backlogId);
}
