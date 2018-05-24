package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.controllers.request.BacklogDto;
import com.umssonline.proymgt.models.Backlog;
import com.umssonline.proymgt.models.UserStory;
import com.umssonline.proymgt.services.BacklogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping("/backlogs")
public class BacklogRestController {

    //region Properties
    @Resource
    private BacklogService service;
    //endregion

    //region Methods
    @GetMapping("/{id}")
    public ResponseEntity find(@PathVariable("id") Long backlogId) {

        try {
            Backlog backlogFromDb = service.find(backlogId);
            return ResponseEntity.ok(backlogFromDb);
        } catch (Exception ex) {
            String errorMessage = "Backlog can not be found: " + ex.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @GetMapping("/{id}/userstories")
    public ResponseEntity loadUserStories(@PathVariable("id") Long backlogId) {

        try {
            Collection<UserStory> userStories = service.loadUserStories(backlogId);
            return ResponseEntity.ok(userStories);
        } catch (Exception ex) {
            String errorMessage = "User Stories for backlog can not be loaded: " + ex.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
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
    public ResponseEntity update(@RequestBody Backlog editedBacklog) {

        try {
            Backlog savedBacklog = service.edit(editedBacklog);
            return ResponseEntity.ok(savedBacklog);
        } catch (Exception ex) {
            String errorMessage = "Backlog can not be updated because: " + ex.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable("id") Long backlogId) {

        try {
            service.remove(backlogId);
            return ResponseEntity.ok().body("Backlog was deleted successfully");
        } catch (Exception ex) {
            String errorMessage = "Backlog can not be deleted because: " + ex.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    //endregion
}
