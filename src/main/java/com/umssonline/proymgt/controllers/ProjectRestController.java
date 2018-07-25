package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.models.dto.CreateProjectDto;
import com.umssonline.proymgt.models.entity.Backlog;
import com.umssonline.proymgt.models.entity.Project;
import com.umssonline.proymgt.models.entity.Sprint;
import com.umssonline.proymgt.services.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/projects")
public class ProjectRestController {

    //region Properties
    @Autowired
    private ProjectService service;

    @Autowired
    private ModelMapper modelMapper;
    //endregion

    //region Methods
    @GetMapping
    public ResponseEntity<Collection<Project>> getAll() {
        Collection<Project> projects = service.getAll();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> find(@PathVariable("id") Long projectId) {
        Project response;

        try {
            response = service.find(projectId);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Project> save(@RequestBody CreateProjectDto project) {
        Project converted = modelMapper.map(project, Project.class);
        Project savedProject = service.create(converted);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedProject);
    }

    @PatchMapping
    public ResponseEntity<Project> edit(@RequestBody Project project) {

        try {
            Project updatedProject = service.edit(project);
            return ResponseEntity.ok(updatedProject);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long projectId) {

        try {
            service.remove(projectId);
            return ResponseEntity.ok(true);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/backlog")
    public ResponseEntity<Backlog> findBacklogByProjectId(@PathVariable("id") Long projectId) {

        try {
            Backlog backlogFromDb = service.loadBacklog(projectId);
            return ResponseEntity.ok(backlogFromDb);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/sprints")
    public ResponseEntity loadSprintsByProject(@PathVariable("id") Long projectId) {
        Collection<Sprint> projectSprints = service.loadSprints(projectId);

        return ResponseEntity.ok(projectSprints);
    }
    //endregion
}
