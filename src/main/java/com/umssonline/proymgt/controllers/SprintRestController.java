package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.models.dto.sprint.CreateSprintDto;
import com.umssonline.proymgt.models.entity.Sprint;
import com.umssonline.proymgt.services.api.SprintService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/sprints")
public class SprintRestController {

    //region Properties
    @Autowired
    private SprintService sprintService;

    @Autowired
    private ModelMapper modelMapper;
    //endregion

    //region Methods
    @GetMapping("/{sprint_id}")
    public ResponseEntity<Sprint> findById(@PathVariable("sprint_id") final Long id) {

        Sprint sprint = sprintService.findById(id);

        return ResponseEntity.ok(sprint);
    }

    //By many parameters ?????
    @GetMapping
    public ResponseEntity<Iterable<Sprint>> findAllByProjectId(@RequestParam("projectId") final Long projectId) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Sprint> create(@Valid @RequestBody final CreateSprintDto sprint) {
        Sprint converted = modelMapper.map(sprint, Sprint.class);
        Sprint savedSprint = sprintService.save(converted);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedSprint);
    }

    @PutMapping("/{sprint_id}")
    public ResponseEntity<Sprint> update(@PathVariable("sprint_id") final Long id, @Valid @RequestBody final CreateSprintDto sprint) {

        Sprint converted = modelMapper.map(sprint, Sprint.class);
        converted.setId(id);

        Sprint savedSprint = sprintService.update(converted);
        return ResponseEntity.ok(savedSprint);
    }

    @PostMapping("/move-task{task_id}/from/{source_sprint_id}/to/{target_sprint_id}")
    public ResponseEntity<Void> moveTaskToOtherSprint(@PathVariable("task_id") final Long taskId,
                                                      @PathVariable("source_sprint_id") final Long sourceSprintId,
                                                      @PathVariable("target_sprint_id") final Long targetSprintId) {
        return null;
    }

    @PatchMapping("/{sprint_id}/start")
    public ResponseEntity<Void> startSprint(@PathVariable("sprint_id") final Long id) {
        return null;
    }

    @PatchMapping("/{sprint_id}/end")
    public ResponseEntity<Void> endSprint(@PathVariable("sprint_id") final Long id) {
        return null;
    }

    //endregion
}
