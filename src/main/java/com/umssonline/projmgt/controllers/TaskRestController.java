package com.umssonline.projmgt.controllers;

import com.umssonline.projmgt.models.dto.task.UpdateTaskDto;
import com.umssonline.projmgt.models.entity.Task;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

public interface TaskRestController {

    @ApiOperation
    (
        notes = "Find a task with a specified ID.",
        value = "Find task by ID.",
        nickname = "findById"
    )
    ResponseEntity<Task> findById(final Long taskId);


    @ApiOperation
    (
        notes = "Update a Task with a specified ID.",
        value = "Update task with a ID",
        nickname = "update"
    )
    ResponseEntity<Task> update(final Long taskId, final UpdateTaskDto task);
}
