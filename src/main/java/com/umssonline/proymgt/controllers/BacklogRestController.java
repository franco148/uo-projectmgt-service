package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.models.dto.story.CreateUserStoryDto;
import com.umssonline.proymgt.models.entity.Backlog;
import com.umssonline.proymgt.models.entity.UserStory;
import com.umssonline.proymgt.services.impl.BacklogServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/backlogs")
public class BacklogRestController {

    //region Properties
    @Autowired
    private BacklogServiceImpl service;

    @Autowired
    private ModelMapper modelMapper;
    //endregion

    //region Methods
    @GetMapping("/{backlog_id}")
    public ResponseEntity<Backlog> findById(@PathVariable("backlog_id") final Long backlogId) {

        Backlog backlogFound = service.findById(backlogId);
        return ResponseEntity.ok(backlogFound);
    }

    @GetMapping("/{backlog_id}/user-stories")
    public ResponseEntity<Iterable<UserStory>> loadUserStories(@PathVariable("backlog_id") final Long backlogId) {

        Iterable<UserStory> userStories = service.loadUserStories(backlogId);
        return ResponseEntity.ok(userStories);
    }

    @PostMapping("/{backlog_id}/user-story")
    public ResponseEntity<UserStory> addUserStory(@PathVariable("backlog_id") final Long id, @Valid @RequestBody final CreateUserStoryDto userStory) {
        return null;
    }

    @PostMapping("/move-user-story/{us_id}/sprint/{sprint_id}")
    public ResponseEntity<Void> moveUserStoryToSprint(@PathVariable("us_id") final Long userStoryId, @PathVariable("sprint_id") final Long sprintId) {
        return null;
    }

    @DeleteMapping("/{backlog_id}/user-story/{user_story_id}")
    public ResponseEntity<Void> deleteUserStory(@PathVariable("backlog_id") final Long backlogId, @PathVariable("user_story_id") final Long userStoryId) {
        return null;
    }

    //endregion
}
