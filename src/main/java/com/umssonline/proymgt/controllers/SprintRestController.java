package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.models.dto.sprint.CreateSprintDto;
import com.umssonline.proymgt.models.entity.Sprint;
import com.umssonline.proymgt.services.SprintService;
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
    public ResponseEntity<Sprint> find(@PathVariable("sprint_id") final Long id) {

        Sprint sprint = sprintService.findById(id);

        return ResponseEntity.ok(sprint);
    }

    @PostMapping
    public ResponseEntity<Sprint> create(@Valid @RequestBody final CreateSprintDto sprint) {
        Sprint converted = modelMapper.map(sprint, Sprint.class);
        Sprint savedSprint = sprintService.save(converted);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedSprint);
    }

    @PatchMapping("/{sprint_id}")
    public ResponseEntity<Sprint> update(@PathVariable("sprint_id") final Long id, @Valid @RequestBody final CreateSprintDto sprint) {

        Sprint converted = modelMapper.map(sprint, Sprint.class);
        converted.setId(id);

        Sprint savedSprint = sprintService.update(converted);
        return ResponseEntity.ok(savedSprint);
    }

    @DeleteMapping("/{sprint_id}")
    public ResponseEntity<Void> delete(@PathVariable("sprint_id") final Long id) {

        sprintService.delete(id);
        return ResponseEntity.noContent().build();
    }
    //endregion
}
