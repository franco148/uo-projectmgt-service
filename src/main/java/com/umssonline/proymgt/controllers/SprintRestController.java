package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.models.dto.sprint.UpdateSprintDto;
import com.umssonline.proymgt.models.entity.Sprint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

@Api(value = "Sprints", description = "Controller for managing Sprint Entity", basePath = "/sprints")
public interface SprintRestController {

    @ApiOperation
    (
        notes = "Find a sprint with a specified ID.",
        value = "Find sprint by ID.",
        nickname = "findById",
        code = 302
    )
    ResponseEntity<Sprint> findById(final Long sprintId);


    @ApiOperation
    (
        notes = "Update a Sprint with a specified ID.",
        value = "Update sprint with a ID",
        nickname = "update",
        code = 200
    )
    ResponseEntity<Sprint> update(final Long sprintId, final UpdateSprintDto sprint);


    @ApiOperation
    (
        notes = "Move task from a specified Sprint to another.",
        value = "Move task from a sprint to another.",
        nickname = "moveTaskToSprint",
        code = 200
    )
    ResponseEntity<Boolean> moveTaskToSprint(final Long sourceSprint, final Long targetSprint, final Long taskId);


    @ApiOperation
    (
        notes = "Active a specified sprint.",
        value = "Active a specified sprint",
        nickname = "activate",
        code = 200
    )
    ResponseEntity<Boolean> activate(final Long sprintId);


    @ApiOperation
    (
        notes = "Mark as ended a specified sprint.",
        value = "Mark as ended a sprint",
        nickname = "markAsEnded",
        code = 200
    )
    ResponseEntity<Void> markAsEnded(final Long sprintId);


    @ApiOperation
    (
        notes = "Load User Stories from a sprint",
        value = "Load User Story from Sprint.",
        nickname = "loadUserStoriesFromSprint",
        code = 302
    )
    ResponseEntity<Sprint> loadUserStoriesFromSprint(final Long sprintId);

}
