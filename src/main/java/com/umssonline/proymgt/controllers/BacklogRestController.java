package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.models.dto.story.CreateUserStoryDto;
import com.umssonline.proymgt.models.dto.story.UserStoryResponseDto;
import com.umssonline.proymgt.models.entity.Backlog;
import com.umssonline.proymgt.models.entity.UserStory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

@Api(value = "Backlogs", description = "Controller for managing Backlog Entity", basePath = "/backlogs")
public interface BacklogRestController {

    @ApiOperation
    (
        notes = "Find a Backlog with the specified ID",
        value = "Find a backlog",
        nickname = "findById"
    )
    ResponseEntity<Backlog> findById(final Long backlogId);


    @ApiOperation
    (
        notes = "Add a User Story to a specific Backlog",
        value = "Add a User Story",
        nickname = "createProject",
        code = 201
    )
    ResponseEntity<UserStoryResponseDto> addUserStory(final Long backlogId, final CreateUserStoryDto userStory);


    @ApiOperation
    (
        notes = "Send a User Story from a backlog to a specified Sprint",
        value = "Send User Story to a Sprint",
        nickname = "sendUserStoryToSprint"
    )
    ResponseEntity<Boolean> sendUserStoryToSprint(final Long backlogId, final Long userStoryId, final Long sprintId);


    @ApiOperation
    (
        notes = "Delete a specified User Story from a Backlog",
        value = "Delete User Story from Backlog",
        nickname = "deleteUserStoryFromBacklog",
        code = 204
    )
    ResponseEntity<Void> deleteUserStoryFromBacklog(final Long backlogId, final Long userStoryId);


    @ApiOperation
    (
        notes = "Load User Stories from a backlog",
        value = "Load User Story from Backlog.",
        nickname = "loadUserStoriesFromBacklog"
    )
    ResponseEntity<Iterable<UserStoryResponseDto>> loadUserStoriesFromBacklog(final Long backlogId);
}
