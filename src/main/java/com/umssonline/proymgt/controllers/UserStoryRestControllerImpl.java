package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.models.dto.story.UpdateUserStoryDto;
import com.umssonline.proymgt.models.dto.task.CreateTaskDto;
import com.umssonline.proymgt.models.entity.Sprint;
import com.umssonline.proymgt.models.entity.Task;
import com.umssonline.proymgt.models.entity.UserStory;
import com.umssonline.proymgt.services.api.UserStoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/user-stories")
public class UserStoryRestControllerImpl implements UserStoryRestController {

    //region Properties
    @Autowired
    private UserStoryService userStoryService;

    @Autowired
    private ModelMapper modelMapper;
    //endregion

    //region UserStoryRestController Members
    @PutMapping("/{story_id}")
    @Override
    public UserStory update(@PathVariable("story_id") final Long userStoryId,
                            @Valid @RequestBody final UpdateUserStoryDto userStory) {
        return null;
    }

    @GetMapping("/{story_id}")
    @Override
    public UserStory findById(@PathVariable("story_id") final Long userStoryId) {
        return null;
    }

    @PostMapping("/{story_id}")
    @Override
    public Task addTaskToUserStory(@PathVariable("story_id") final Long userStoryId,
                                   @Valid @RequestBody final CreateTaskDto task) {
        return null;
    }

    @DeleteMapping("/{story_id}/task/{task_id}")
    @Override
    public void deleteTaskFromUserStory(@PathVariable("story_id") final Long userStoryId,
                                        @PathVariable("task_id") final Long taskId) {

    }

    @Override
    public ResponseEntity<Sprint> loadTasksFromUserStory(Long userStoryId) {
        return null;
    }
    //endregion
}
