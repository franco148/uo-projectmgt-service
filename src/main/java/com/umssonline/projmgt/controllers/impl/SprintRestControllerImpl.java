package com.umssonline.projmgt.controllers.impl;

import com.umssonline.projmgt.controllers.SprintRestController;
import com.umssonline.projmgt.models.dto.sprint.UpdateSprintDto;
import com.umssonline.projmgt.models.entity.Sprint;
import com.umssonline.projmgt.models.entity.UserStory;
import com.umssonline.projmgt.services.api.SprintService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 6000)
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
        Sprint foundSprint = sprintService.findById(sprintId);
        return ResponseEntity.ok(foundSprint);
    }

    @PutMapping("/{sprint_id}")
    @Override
    public ResponseEntity<Sprint> update(@PathVariable("sprint_id") final Long sprintId,
                                         @Valid @RequestBody final UpdateSprintDto sprint) {
        Sprint converted = modelMapper.map(sprint, Sprint.class);
        converted.setId(sprintId);

        Sprint saved = sprintService.update(converted);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/move-story/{story_id}/from/{source_sprint_id}/to/{target_sprint_id}")
    @Override
    public ResponseEntity<Boolean> moveStoryToAnotherSprint(@PathVariable("source_sprint_id") final Long sourceSprint,
                                                            @PathVariable("target_sprint_id") final Long targetSprint,
                                                            @PathVariable("story_id") final Long storyId) {
        sprintService.moveTaskToAnotherSprint(sourceSprint, targetSprint, storyId);
        return ResponseEntity.ok(true);
    }

    @PatchMapping("/{sprint_id}/start")
    @Override
    public ResponseEntity<Boolean> activate(@PathVariable("sprint_id") final Long sprintId) {
        sprintService.activateSprint(sprintId);
        return ResponseEntity.ok(true);
    }

    @PatchMapping("/{sprint_id}/end")
    @Override
    public ResponseEntity<Void> markAsEnded(@PathVariable("sprint_id") final Long sprintId) {
        sprintService.markAsEnded(sprintId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{sprint_id}/user-story")
    @Override
    public ResponseEntity<Iterable<UserStory>> loadUserStoriesFromSprint(@PathVariable("sprint_id") Long sprintId) {
        Iterable<UserStory> foundStories = sprintService.loadUserStories(sprintId);
        return ResponseEntity.ok(foundStories);
    }


    //endregion
}
