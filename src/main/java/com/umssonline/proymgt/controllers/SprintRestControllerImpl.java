package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.models.dto.sprint.CreateSprintDto;
import com.umssonline.proymgt.models.dto.sprint.UpdateSprintDto;
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
public class SprintRestControllerImpl implements SprintRestController {

    //region Properties
    @Autowired
    private SprintService sprintService;

    @Autowired
    private ModelMapper modelMapper;
    //endregion

    //region SprintRestController Members

    @GetMapping("/{sprint_id}")
    @Override
    public ResponseEntity<Sprint> findById(@PathVariable("sprint_id") final Long sprintId) {
        return null;
    }

    @PutMapping("/{sprint_id}")
    @Override
    public ResponseEntity<Sprint> update(@PathVariable("sprint_id") final Long sprintId,
                                         @Valid @RequestBody final UpdateSprintDto sprint) {
        return null;
    }

    @PostMapping("/move-task{task_id}/from/{source_sprint_id}/to/{target_sprint_id}")
    @Override
    public ResponseEntity<Boolean> moveTaskToSprint(@PathVariable("source_sprint_id") final Long sourceSprint,
                                                    @PathVariable("target_sprint_id") final Long targetSprint,
                                                    @PathVariable("task_id") final Long taskId) {
        return null;
    }

    @PatchMapping("/{sprint_id}/start")
    @Override
    public ResponseEntity<Boolean> activate(@PathVariable("sprint_id") final Long sprintId) {
        return null;
    }

    @PatchMapping("/{sprint_id}/end")
    @Override
    public ResponseEntity<Void> markAsEnded(@PathVariable("sprint_id") final Long sprintId) {
        return null;
    }

    @Override
    public ResponseEntity<Sprint> loadUserStoriesFromSprint(Long sprintId) {
        return null;
    }


    //endregion
}
