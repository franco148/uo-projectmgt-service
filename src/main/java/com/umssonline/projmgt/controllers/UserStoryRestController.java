package com.umssonline.projmgt.controllers;

import com.umssonline.projmgt.models.dto.story.UpdateUserStoryDto;
import com.umssonline.projmgt.models.dto.task.CreateTaskDto;
import com.umssonline.projmgt.models.entity.Task;
import com.umssonline.projmgt.models.entity.UserStory;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

public interface UserStoryRestController {

    @ApiOperation
    (
        notes = "Update a User Story with a specified ID.",
        value = "Update user story with a ID",
        nickname = "update"
    )
    ResponseEntity<UserStory> update(final Long userStoryId, final UpdateUserStoryDto userStory);


    @ApiOperation
    (
        notes = "Find a user story with a specified ID.",
        value = "Find user story by ID.",
        nickname = "findById"
    )
    ResponseEntity<UserStory> findById(final Long userStoryId);


    @ApiOperation
    (
        notes = "Add a new task to a specified user story.",
        value = "Add a task to user story",
        nickname = "addTaskToUserStory",
        code = 201
    )
    ResponseEntity<Task> addTaskToUserStory(final Long userStoryId, final CreateTaskDto task);


    @ApiOperation
    (
        notes = "Delete a task with a specified ID from User Story",
        value = "Delete task from user story",
        nickname = "deleteTaskFromUserStory",
        code = 204
    )
    ResponseEntity<Void> deleteTaskFromUserStory(final Long userStoryId, final Long taskId);


    @ApiOperation
    (
        notes = "Load Tasks from a User Story",
        value = "Load Tasks from User Story.",
        nickname = "loadTasksFromUserStory"
    )
    ResponseEntity<UserStory> loadTasksFromUserStory(final Long userStoryId);
}
