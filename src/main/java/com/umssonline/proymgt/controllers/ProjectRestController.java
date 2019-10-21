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


    @ApiOperation
    (
        notes = "Find all projects of the system.",
        value = "Find all projects",
        nickname = "findAll"
    )
    ResponseEntity<Iterable<Project>> findAll();


    @ApiOperation
    (
        notes = "Find all projects of the system by user ID.",
        value = "Find all projects by user",
        nickname = "findAllByUser"
    )
    ResponseEntity<Iterable<Project>> findAllByUser(
            @ApiParam
            (
                value = "UserId of the project that needs to be fetched.",
                type = "Number",
                required = true
            )
            Long userId);


    @ApiOperation
    (
        notes = "Find a project with a specified ID",
        value = "Find Project by ID",
        nickname = "findById"
    )
    ResponseEntity<Project> findById(
            @ApiParam
            (
                value = "ProjectId that needs to be fetched.",
                type = "Number",
                required = true
            )
            final Long projectId);


    @ApiOperation
    (
            notes = "Update a Project with a specified ID",
            value = "Update Project by ID",
            nickname = "update"
    )
    ResponseEntity<Project> update(
            @ApiParam
            (
                value = "ProjectId which is going to be updated.",
                type = "Number",
                required = true
            )
            final Long projectId,
            @ApiParam
            (
                value = "Project object which contains updated data.",
                type = "UpdateProjectDto",
                required = true
            )
            final UpdateProjectDto project);


    @ApiOperation
    (
        notes = "Delete a project with a specified ID",
        value = "Delete Project by ID",
        nickname = "delete",
        code = 204
    )
    ResponseEntity<Void> delete(
            @ApiParam
            (
                value = "ProjectId which is going to be deleted.",
                type = "Number",
                required = true
            )
            final Long projectId);


    @ApiOperation
    (
        notes = "Create a new Sprint in project with a specified ID",
        value = "Add new sprint to project",
        nickname = "addSprint",
        code = 201
    )
    ResponseEntity<Sprint> addSprint(
            @ApiParam
            (
                value = "ProjectId in which a new sprint is going to be created.",
                type = "Number",
                required = true
            )
            final Long projectId,
            @ApiParam
            (
                value = "ProjectId which is going to be deleted.",
                type = "CreateSprintDto",
                required = true
            )
            final CreateSprintDto sprint);


    @ApiOperation
    (
        notes = "Get Sprints from a project with a specified ID",
        value = "Get Sprints from Project",
        nickname = "loadSprintsFromProject"
    )
    ResponseEntity<Project> loadSprintsFromProject(
            @ApiParam
            (
                value = "ProjectId from which sprints will going to be load.",
                type = "Number",
                required = true
            )
            final Long projectId);


    @ApiOperation
    (
        notes = "Verify if a entity with a specified ID exists.",
        value = "Does entity exist",
        nickname = "entityExist",
        code = 302
    )
    ResponseEntity<Boolean> entityExist(
            @ApiParam
            (
                value = "Entity type that needs to be verified.",
                type = "String",
                required = true
            )
            final String entityType,
            @ApiParam
            (
                value = "Entity ID that needs to be verified.",
                type = "Number",
                required = true
            )
            final Long entityId);
}
