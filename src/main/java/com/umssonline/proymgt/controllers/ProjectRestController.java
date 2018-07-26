package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.models.dto.CreateProjectDto;
import com.umssonline.proymgt.models.dto.UpdateProjectDto;
import com.umssonline.proymgt.models.entity.Backlog;
import com.umssonline.proymgt.models.entity.Project;
import com.umssonline.proymgt.models.entity.Sprint;
import com.umssonline.proymgt.services.ProjectServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/projects")
public class ProjectRestController {

    //region Properties
    @Autowired
    private ProjectServiceImpl service;

    @Autowired
    private ModelMapper modelMapper;
    //endregion

    //region Methods
    @GetMapping
    public ResponseEntity<Iterable<Project>> getAll() {
        Iterable<Project> projects = service.finAll();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{project_id}")
    public ResponseEntity<Project> find(@PathVariable("project_id") final Long projectId) {

        Project response = service.findById(projectId);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Project> save(@Valid @RequestBody final CreateProjectDto project) {
        Project converted = modelMapper.map(project, Project.class);
        Project savedProject = service.save(converted);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedProject);
    }

    @PatchMapping("/{project_id}")
    public ResponseEntity<Project> edit(@PathVariable("project_id") final Long id, @Valid @RequestBody final UpdateProjectDto project) {

        Project converted = modelMapper.map(project, Project.class);
        converted.setId(id);

        Project updatedProject = service.update(converted);

        return ResponseEntity.status(HttpStatus.OK).body(updatedProject);
    }

    @DeleteMapping("/{project_id}")
    public ResponseEntity<Void> delete(@PathVariable("project_id") final Long projectId) {

        service.delete(projectId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{project_id}/backlog")
    public ResponseEntity<Backlog> findBacklogByProjectId(@PathVariable("project_id") final Long projectId) {

        Backlog backlog = service.getBacklog(projectId);

        return ResponseEntity.status(HttpStatus.OK).body(backlog);
    }

    @GetMapping("/{project_id}/sprints")
    public ResponseEntity<Iterable<Sprint>> loadSprintsByProject(@PathVariable("project_id") final Long projectId) {
        Iterable<Sprint> projectSprints = service.loadSprints(projectId);

        return ResponseEntity.ok(projectSprints);
    }
    //endregion
}
