package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.models.dto.task.UpdateTaskDto;
import com.umssonline.proymgt.models.entity.Task;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

public interface TaskRestController {

    @ApiOperation
    (
        notes = "Find a task with a specified ID.",
        value = "Find task by ID.",
        nickname = "findById",
        code = 302
    )
    ResponseEntity<Task> findById(final Long taskId);


    @ApiOperation
    (
        notes = "Update a Task with a specified ID.",
        value = "Update task with a ID",
        nickname = "update",
        code = 200
    )
    ResponseEntity<Task> update(final Long taskId, final UpdateTaskDto task);
}
