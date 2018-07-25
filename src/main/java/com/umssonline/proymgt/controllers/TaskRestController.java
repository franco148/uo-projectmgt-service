package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.models.dto.CreateSprintItemDto;
import com.umssonline.proymgt.models.dto.UpdateSprintItemDto;
import com.umssonline.proymgt.services.SprintItemService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tasks")
public class TaskRestController {

    //region Properties
    @Resource
    private SprintItemService sprintItemService;

    private static final ModelMapper modelMapper = new ModelMapper();
    //endregion

    //region Methods
    @GetMapping
    public ResponseEntity<?> findAll() {
        return null;
    }

    @GetMapping("/{task_id}")
    public ResponseEntity<?> find(@PathVariable("task_id") Long taskId) {
        return null;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateSprintItemDto sprintItemDto) {
        return null;
    }

    @PatchMapping("/{task_id}")
    public ResponseEntity<?> update(@PathVariable("task_id") Long taskId, UpdateSprintItemDto updateSprintItemDto) {
        return null;
    }

    @DeleteMapping("/{task_id}")
    public ResponseEntity<?> remove(@PathVariable("task_id") Long taskId) {
        return null;
    }
    //endregion
}
