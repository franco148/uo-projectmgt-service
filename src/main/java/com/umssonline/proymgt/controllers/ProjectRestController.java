package com.umssonline.proymgt.controllers;

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
    //endregion
}
