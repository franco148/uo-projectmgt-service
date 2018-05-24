package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.controllers.request.SprintDto;
import com.umssonline.proymgt.models.Sprint;
import com.umssonline.proymgt.services.SprintService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sprints")
public class SprintRestController {

    //region Properties
    @Resource
    private SprintService sprintService;
    //endregion

    //region Methods
    @GetMapping("/{id}")
    public ResponseEntity find(@PathVariable("id") Long id) {

        try {
            Sprint sprintFromDb = sprintService.find(id);

            return ResponseEntity.ok(sprintFromDb);
        } catch (Exception ex) {
            String errorMessage = "Sprint can not be found: " + ex.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Sprint sprint) {
        Sprint savedSprint = sprintService.save(sprint);

        return ResponseEntity.ok(savedSprint);
    }

    @PatchMapping
    public ResponseEntity update(@RequestBody SprintDto editedSprint) {

        try {
            Sprint sprintFromDb = sprintService.edit(editedSprint);

            return ResponseEntity.ok(sprintFromDb);
        } catch (Exception ex) {
            String errorMessage = "Sprint can not be found: " + ex.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {

        try {
            sprintService.delete(id);
            return ResponseEntity.ok().body("Sprint was deleted successfully");
        } catch (Exception ex) {
            String errorMessage = "Sprint can not be deleted because: " + ex.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
    //endregion
}
