package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.models.Sprint;
import com.umssonline.proymgt.services.SprintService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    //endregion
}
