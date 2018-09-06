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

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 6000)
@RestController
@RequestMapping("/projects")
public class ProjectRestControllerImpl implements ProjectRestController {

    //region Properties
    @Autowired
    private ProjectServiceImpl service;

    @Autowired
    private ModelMapper modelMapper;
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
        return ResponseEntity.ok(projectsCollection);
    }

    @GetMapping("/{project_id}")
    @Override
    public ResponseEntity<Project> findById(@PathVariable("project_id") final Long projectId) {
        Project foundProject = service.findById(projectId);
        return ResponseEntity.ok(foundProject);
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

        Sprint convertedSprint = modelMapper.map(sprint, Sprint.class);
        Sprint addedSprint = service.addSprint(projectId, convertedSprint);

        return ResponseEntity.status(HttpStatus.CREATED).body(addedSprint);
    }

    @GetMapping("/{project_id}/sprints")
    @Override
    public ResponseEntity<Project> loadSprintsFromProject(@PathVariable("project_id") final Long projectId) {
        Project projectWithSprints = service.loadProjectSprints(projectId);
        return ResponseEntity.ok(projectWithSprints);
    }

    @GetMapping("/find")
    @Override
    public ResponseEntity<Boolean> entityExist(@RequestParam("entity") final String entityType,
                                               @RequestParam("id") final Long entityId) {
        boolean entityExist = service.findEntityByTypeAndId(entityType, entityId) > 0;
        return ResponseEntity.ok(entityExist);
    }


    //endregion
}
