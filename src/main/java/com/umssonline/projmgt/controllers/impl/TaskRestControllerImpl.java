package com.umssonline.projmgt.controllers.impl;

import com.umssonline.projmgt.controllers.TaskRestController;
import com.umssonline.projmgt.models.dto.task.UpdateTaskDto;
import com.umssonline.projmgt.models.entity.Task;
import com.umssonline.projmgt.services.api.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 6000)
@RestController
@RequestMapping("/tasks")
public class TaskRestControllerImpl implements TaskRestController {

    //region Properties
    @Autowired
    private TaskService taskService;

    @Autowired
    private ModelMapper modelMapper;
    //endregion

    //region Methods

    @GetMapping("/{task_id}")
    @Override
    public ResponseEntity<Task> findById(@PathVariable("task_id") final Long taskId) {
        Task foundTask = taskService.findById(taskId);
        return ResponseEntity.ok(foundTask);
    }

    @PutMapping("/{task_id}")
    @Override
    public ResponseEntity<Task> update(@PathVariable("task_id") final Long taskId, @Valid @RequestBody final UpdateTaskDto task) {
        Task converted = modelMapper.map(task, Task.class);
        converted.setId(taskId);
        Task saved = taskService.update(converted);

        return ResponseEntity.ok(saved);
    }

    //endregion
}
