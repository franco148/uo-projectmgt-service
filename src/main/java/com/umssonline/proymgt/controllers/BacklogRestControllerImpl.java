package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.models.dto.story.CreateUserStoryDto;
import com.umssonline.proymgt.models.entity.Backlog;
import com.umssonline.proymgt.models.entity.UserStory;
import com.umssonline.proymgt.services.impl.BacklogServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/backlogs")
public class BacklogRestControllerImpl implements BacklogRestController {

    //region Properties
    @Autowired
    private BacklogServiceImpl service;

    @Autowired
    private ModelMapper modelMapper;
    //endregion

    //region BacklogRestController Members

    @GetMapping("/{backlog_id}")
    @Override
    public ResponseEntity<Backlog> findById(@PathVariable("backlog_id") final Long backlogId) {
        Backlog foundBacklog = service.findById(backlogId);
        return ResponseEntity.status(HttpStatus.FOUND).body(foundBacklog);
    }

    @PostMapping("/{backlog_id}/user-story")
    @Override
    public ResponseEntity<UserStory> addUserStory(@PathVariable("backlog_id") final Long backlogId,
                                                  @Valid @RequestBody final CreateUserStoryDto userStory) {
        return null;
    }

    @PostMapping("/{backlog_id}/user-story/{user_story_id}/sprint/{sprint_id}")
    @Override
    public ResponseEntity<Boolean> sendUserStoryToSprint(@PathVariable("backlog_id") final Long backlogId,
                                                         @PathVariable("user_story_id") final Long userStoryId,
                                                         @PathVariable("sprint_id") final Long sprintId) {
        return null;
    }

    @DeleteMapping("/{backlog_id}/user-story/{user_story_id}")
    @Override
    public ResponseEntity<Void> deleteUserStoryFromBacklog(@PathVariable("backlog_id") final Long backlogId,
                                                           @PathVariable("user_story_id") final Long userStoryId) {
        return null;
    }

    @GetMapping("/{backlog_id}/user-story")
    @Override
    public ResponseEntity<Backlog> loadUserStoriesFromBacklog(@PathVariable("backlog_id") final Long backlogId) {
        return null;
    }


    //endregion
}
