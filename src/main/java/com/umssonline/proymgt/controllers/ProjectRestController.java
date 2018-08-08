package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.models.dto.project.CreateProjectDto;
import com.umssonline.proymgt.models.dto.project.UpdateProjectDto;
import com.umssonline.proymgt.models.dto.sprint.CreateSprintDto;
import com.umssonline.proymgt.models.entity.Project;
import com.umssonline.proymgt.models.entity.Sprint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

@Api(value = "Projects", description = "Controller for managing Project Entity", basePath = "/project")
public interface ProjectRestController {

    @ApiOperation
    (
        notes = "Create a project with its related Backlog",
        value = "Create project with a backlog",
        nickname = "createProject",
        code = 201
    )
    ResponseEntity<Project> create(
            @ApiParam
            (
                value = "Project DTO which contains data to be saved.",
                type = "CreateProjectDto",
                required = true
            )
            final CreateProjectDto project);

    ResponseEntity<Iterable<Project>> findAll();

    ResponseEntity<Project> findById(final Long projectId);

    ResponseEntity<Project> update(final Long projectId, final UpdateProjectDto project);

    ResponseEntity<Void> delete(final Long projectId);

    ResponseEntity<Sprint> addSprint(final Long projectId, final CreateSprintDto sprint);

    ResponseEntity<Project> loadSprintsFromProject(final Long projectId);

    ResponseEntity<Boolean> entityExist(final String entityType, final Serializable entityId);
}
