package com.umssonline.proymgt.services.api;

import com.umssonline.proymgt.models.dto.story.UserStoryResponseDto;
import com.umssonline.proymgt.models.entity.Backlog;
import com.umssonline.proymgt.models.entity.UserStory;

public interface BacklogService extends CrudService<Backlog> {

    UserStoryResponseDto addUserStory(Long backlogId, UserStory userStory);

    void sendUserStoryToSprint(Long backlogId, Long userStoryId, Long sprintId);

    void deleteUserStory(Long backlogId, Long userStoryId);

    Iterable<UserStoryResponseDto> loadUserStories(Long backlogId);
}
