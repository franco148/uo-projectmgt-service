package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.models.dto.project.CreateProjectDto;
import com.umssonline.proymgt.models.dto.project.UpdateProjectDto;
import com.umssonline.proymgt.models.dto.sprint.CreateSprintDto;
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
    public ResponseEntity<Iterable<Project>> findAll() {
        Iterable<Project> projects = service.finAll();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{project_id}")
    public ResponseEntity<Project> findById(@PathVariable("project_id") final Long projectId) {

        Project response = service.findById(projectId);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Project> create(@Valid @RequestBody final CreateProjectDto project) {
        Project converted = modelMapper.map(project, Project.class);
        Project savedProject = service.save(converted);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedProject);
    }

    @PatchMapping("/{project_id}")
    public ResponseEntity<Project> update(@PathVariable("project_id") final Long id, @Valid @RequestBody final UpdateProjectDto project) {

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

    @GetMapping("/{project_id}/sprints")
    public ResponseEntity<Iterable<Sprint>> loadSprints(@PathVariable("project_id") final Long projectId) {
        Iterable<Sprint> projectSprints = service.loadSprints(projectId);

        return ResponseEntity.ok(projectSprints);
    }

    @PostMapping("/{project_id}/sprint")
    public ResponseEntity<Void> addSprint(@PathVariable("project_id") final Long id, @Valid @RequestBody final CreateSprintDto sprint) {

        return null;
    }
    //endregion
}
