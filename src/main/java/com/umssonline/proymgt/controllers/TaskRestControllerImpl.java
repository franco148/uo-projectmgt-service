package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.models.dto.task.UpdateTaskDto;
import com.umssonline.proymgt.models.entity.Task;
import com.umssonline.proymgt.services.api.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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
        return ResponseEntity.status(HttpStatus.FOUND).body(foundTask);
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
