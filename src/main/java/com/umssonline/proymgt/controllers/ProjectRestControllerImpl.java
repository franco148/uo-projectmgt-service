package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.models.dto.project.CreateProjectDto;
import com.umssonline.proymgt.models.dto.project.UpdateProjectDto;
import com.umssonline.proymgt.models.dto.sprint.CreateSprintDto;
import com.umssonline.proymgt.models.entity.Project;
import com.umssonline.proymgt.models.entity.Sprint;
import com.umssonline.proymgt.services.impl.ProjectServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;

@RestController
@RequestMapping("/projects")
public class ProjectRestControllerImpl implements ProjectRestController {

    //region Properties
    @Autowired
    private ProjectServiceImpl service;

    @Autowired
    private ModelMapper modelMapper;
    //endregion

    //region Methods
//    @GetMapping
//    public ResponseEntity<Iterable<Project>> findAll() {
//        Iterable<Project> projects = service.finAll();
//        return ResponseEntity.ok(projects);
//    }
//
//    @GetMapping("/{project_id}")
//    public ResponseEntity<Project> findById(@PathVariable("project_id") final Long projectId) {
//
//        Project response = service.findById(projectId);
//
//        return ResponseEntity.ok(response);
//    }
//
//    @PostMapping
//    public ResponseEntity<Project> create(@Valid @RequestBody final CreateProjectDto project) {
//        Project converted = modelMapper.map(project, Project.class);
//        Project savedProject = service.save(converted);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedProject);
//    }
//
//    @PatchMapping("/{project_id}")
//    public ResponseEntity<Project> update(@PathVariable("project_id") final Long id, @Valid @RequestBody final UpdateProjectDto project) {
//
//        Project converted = modelMapper.map(project, Project.class);
//        converted.setId(id);
//
//        Project updatedProject = service.update(converted);
//
//        return ResponseEntity.status(HttpStatus.OK).body(updatedProject);
//    }
//
//    @DeleteMapping("/{project_id}")
//    public ResponseEntity<Void> delete(@PathVariable("project_id") final Long projectId) {
//
//        service.delete(projectId);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
//
//    @GetMapping("/{project_id}/sprints")
//    public ResponseEntity<Iterable<Sprint>> loadSprints(@PathVariable("project_id") final Long projectId) {
//        Iterable<Sprint> projectSprints = service.loadSprints(projectId);
//
//        return ResponseEntity.ok(projectSprints);
//    }
//
//    @PostMapping("/{project_id}/sprint")
//    public ResponseEntity<Void> addSprint(@PathVariable("project_id") final Long id, @Valid @RequestBody final CreateSprintDto sprint) {
//
//        return null;
//    }
    //endregion

    //region ProjectRestController Members

    @PostMapping
    @Override
    public ResponseEntity<Project> create(@Valid @RequestBody final CreateProjectDto project) {
        Project converted = modelMapper.map(project, Project.class);
        Project saved = service.save(converted);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    @Override
    public ResponseEntity<Iterable<Project>> findAll() {
        Iterable<Project> projectsCollection = service.finAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(projectsCollection);
    }

    @GetMapping("/{project_id}")
    @Override
    public ResponseEntity<Project> findById(@PathVariable("project_id") final Long projectId) {
        Project foundProject = service.findById(projectId);
        return ResponseEntity.status(HttpStatus.FOUND).body(foundProject);
    }

    @PutMapping("/{project_id}")
    @Override
    public ResponseEntity<Project> update(@PathVariable("project_id") final Long projectId,
                                          @Valid @RequestBody final UpdateProjectDto project) {

        Project converted = modelMapper.map(project, Project.class);
        converted.setId(projectId);

        Project updated = service.update(converted);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{project_id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable("project_id") final Long projectId) {
        service.delete(projectId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{project_id}/sprint")
    @Override
    public ResponseEntity<Sprint> addSprint(@PathVariable("project_id") final Long projectId,
                                            @Valid @RequestBody final CreateSprintDto sprint) {

        Sprint converted = modelMapper.map(sprint, Sprint.class);
        Sprint addedSprint = service.addSprintToProject(projectId, converted);

        return ResponseEntity.status(HttpStatus.CREATED).body(addedSprint);
    }

    @GetMapping("/{project_id}/sprints")
    @Override
    public ResponseEntity<Project> loadSprintsFromProject(@PathVariable("project_id") final Long projectId) {
        return null;
    }

    //@GetMapping("")
    @Override
    public ResponseEntity<Boolean> entityExist(String entityType, Long entityId) {
        return null;
    }


    //endregion
}
