package com.umssonline.proymgt.controllers.impl;

import com.umssonline.proymgt.controllers.UserStoryRestController;
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

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 6000)
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
    public ResponseEntity<UserStory> update(@PathVariable("story_id") final Long userStoryId,
                                            @Valid @RequestBody final UpdateUserStoryDto userStory) {
        UserStory converted = modelMapper.map(userStory, UserStory.class);
        UserStory updated = userStoryService.update(converted);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{story_id}")
    @Override
    public ResponseEntity<UserStory> findById(@PathVariable("story_id") final Long userStoryId) {
        UserStory foundUserStory = userStoryService.findById(userStoryId);
        return ResponseEntity.ok(foundUserStory);
    }

    @PostMapping("/{story_id}/task")
    @Override
    public ResponseEntity<Task> addTaskToUserStory(@PathVariable("story_id") final Long userStoryId,
                                                   @Valid @RequestBody final CreateTaskDto task) {
        Task convertedTask = modelMapper.map(task, Task.class);
        Task savedTask = userStoryService.addTask(userStoryId, convertedTask);
        return ResponseEntity.ok(savedTask);
    }

    @DeleteMapping("/{story_id}/task/{task_id}")
    @Override
    public ResponseEntity<Void> deleteTaskFromUserStory(@PathVariable("story_id") final Long userStoryId,
                                                        @PathVariable("task_id") final Long taskId) {
        userStoryService.deleteTask(userStoryId, taskId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UserStory> loadTasksFromUserStory(Long userStoryId) {
        return null;
    }
    //endregion
}
