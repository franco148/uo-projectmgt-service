package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.models.Backlog;
import com.umssonline.proymgt.models.Project;
import com.umssonline.proymgt.services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping("/projects")
public class ProjectRestController {

    //region Properties
    @Resource
    private ProjectService service;
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
    public ResponseEntity<Project> save(@RequestBody Project project) {
        Project savedProject = service.create(project);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedProject);
    }

    @PatchMapping
    public ResponseEntity<Project> edit(@RequestBody Project editedProject) {

        try {
            Project updatedProject = service.edit(editedProject);
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
    //endregion
}
