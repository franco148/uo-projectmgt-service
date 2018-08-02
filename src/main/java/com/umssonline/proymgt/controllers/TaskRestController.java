package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.models.dto.task.UpdateTaskDto;
import com.umssonline.proymgt.models.entity.Task;
import com.umssonline.proymgt.services.api.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tasks")
public class TaskRestController {

    //region Properties
    @Autowired
    private TaskService taskService;

    @Autowired
    private ModelMapper modelMapper;
    //endregion

    //region Methods
    @GetMapping
    public ResponseEntity<Task> findAllByUserStory(@RequestParam("story") final Long userStoryId) {
        return null;
    }

    @PutMapping("/{task_id}")
    public ResponseEntity<Task> update(@PathVariable("task_id") final Long taskId, @RequestBody final UpdateTaskDto task) {

        Task converted = modelMapper.map(task, Task.class);
        converted.setId(taskId);
        Task saved = taskService.update(converted);

        return ResponseEntity.ok(saved);
    }

    //endregion
}
