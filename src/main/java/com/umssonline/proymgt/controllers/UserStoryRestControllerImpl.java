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

    //region Methods
    //Need to build queries by everything
//    public ResponseEntity<UserStory> findAllBy() {
//        return null;
//    }
//
//    @GetMapping("/{us_id}")
//    public ResponseEntity findById(@PathVariable("us_id") final Long id) {
//
//        UserStory userStory = userStoryService.findById(id);
//
//        return ResponseEntity.ok(userStory);
//    }
//
//    @PutMapping("/{us_id}")
//    public ResponseEntity<UserStory> update(@PathVariable("us_id") final Long id, @RequestBody final UpdateUserStoryDto userStory) {
//
//        UserStory converted = modelMapper.map(userStory, UserStory.class);
//        converted.setId(id);
//        UserStory saved = userStoryService.update(converted);
//
//        return ResponseEntity.ok(saved);
//    }
//
//    @PostMapping("/{us_id}/task")
//    public ResponseEntity<Void> addTask(@PathVariable("us_id") final Long userStoryId, @RequestBody final UpdateUserStoryDto userStory) {
//        return null;
//    }
//
//    @DeleteMapping("/{us_id}/task/{task_id}")
//    public ResponseEntity<Void> deleteTask(@PathVariable("us_id") final Long userStoryId, @PathVariable("task_id") final Long taskId) {
//        return null;
//    }
//
//    @GetMapping("/{us_id}/tasks")
//    public ResponseEntity<Iterable<Task>> loadTasks(@PathVariable("us_id") final Long userStoryId) {
//        return null;
//    }

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
