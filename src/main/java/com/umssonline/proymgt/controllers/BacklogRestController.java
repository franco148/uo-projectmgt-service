package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.controllers.request.BacklogDto;
import com.umssonline.proymgt.models.Backlog;
import com.umssonline.proymgt.models.UserStory;
import com.umssonline.proymgt.services.BacklogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/backlogs")
public class BacklogRestController {

    //region Properties
    @Resource
    private BacklogService service;
    //endregion

    //region Methods
    @GetMapping("/{id}")
    public ResponseEntity<Backlog> find(@PathVariable("id") Long backlogId) {
        return null;
    }

    @GetMapping("/{id}/userstories")
    public ResponseEntity<UserStory> loadUserStories(@PathVariable("id") Long backlogId) {
        return null;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody BacklogDto backlog) {

        try {
            //return service.create(backlog);
            Backlog savedBacklog = service.create(backlog);
            return ResponseEntity.ok(savedBacklog);
        } catch (Exception ex) {
            String errorMessage = "Backlog can not be saved because: " + ex.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @PatchMapping
    public ResponseEntity<Backlog> update(@RequestBody Backlog editedBacklog) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> remove(@PathVariable("id") Long backlogId) {
        return null;
    }

    //endregion
}
