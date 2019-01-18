package com.umssonline.proymgt.controllers.impl;

import com.umssonline.proymgt.controllers.BacklogRestController;
import com.umssonline.proymgt.models.dto.story.CreateUserStoryDto;
import com.umssonline.proymgt.models.dto.story.UserStoryResponseDto;
import com.umssonline.proymgt.models.entity.Backlog;
import com.umssonline.proymgt.models.entity.UserStory;
import com.umssonline.proymgt.services.impl.BacklogServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 6000)
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
        return ResponseEntity.ok(foundBacklog);
    }

    @PostMapping("/{backlog_id}/user-story")
    @Override
    public ResponseEntity<UserStoryResponseDto> addUserStory(@PathVariable("backlog_id") final Long backlogId,
                                                  @Valid @RequestBody final CreateUserStoryDto userStory) {
        UserStory converted = modelMapper.map(userStory, UserStory.class);
        UserStoryResponseDto addedUserStory = service.addUserStory(backlogId, converted);

        return ResponseEntity.status(HttpStatus.CREATED).body(addedUserStory);
    }

    @PostMapping("/{backlog_id}/user-story/{user_story_id}/sprint/{sprint_id}")
    @Override
    public ResponseEntity<Boolean> sendUserStoryToSprint(@PathVariable("backlog_id") final Long backlogId,
                                                         @PathVariable("user_story_id") final Long userStoryId,
                                                         @PathVariable("sprint_id") final Long sprintId) {

        service.sendUserStoryToSprint(backlogId, userStoryId, sprintId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(true);
    }

    @DeleteMapping("/{backlog_id}/user-story/{user_story_id}")
    @Override
    public ResponseEntity<Void> deleteUserStoryFromBacklog(@PathVariable("backlog_id") final Long backlogId,
                                                           @PathVariable("user_story_id") final Long userStoryId) {
        service.deleteUserStory(backlogId, userStoryId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{backlog_id}/user-story")
    @Override
    public ResponseEntity<Iterable<UserStoryResponseDto>> loadUserStoriesFromBacklog(@PathVariable("backlog_id") final Long backlogId) {

        Iterable<UserStoryResponseDto> foundUserStoriesList = service.loadUserStories(backlogId);
        return ResponseEntity.ok(foundUserStoriesList);
    }


    //endregion
}
