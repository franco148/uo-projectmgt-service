package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.controllers.request.UserStoryDto;
import com.umssonline.proymgt.models.UserStory;
import com.umssonline.proymgt.services.UserStoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/userstories")
public class UserStoryRestController {

    //region Properties
    @Resource
    private UserStoryService userStoryService;
    //endregion

    //region Methods
    @GetMapping("/{id}")
    public ResponseEntity find(@PathVariable("id") Long id) {

        try {
            UserStory storyFromB = userStoryService.find(id);
            return ResponseEntity.ok(storyFromB);
        } catch (Exception ex) {
            String errorMessage = "UserStory can not be found: " + ex.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody UserStoryDto userStoryDto) {

        try {
            UserStory savedStory = userStoryService.save(userStoryDto);
            return ResponseEntity.ok(savedStory);
        } catch (Exception ex) {
            String errorMessage = "UserStory can not be updated because: " + ex.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @PatchMapping
    public ResponseEntity update(@RequestBody UserStory editedUserStory) {

        try {
            UserStory savedStory = userStoryService.edit(editedUserStory);
            return ResponseEntity.ok(savedStory);
        } catch (Exception ex) {
            String errorMessage = "UserStory can not be updated because: " + ex.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable("id") Long storyId) {

        try {
            userStoryService.delete(storyId);
            return ResponseEntity.ok().body("UserStory was deleted successfully");
        } catch (Exception ex) {
            String errorMessage = "UserStory can not be deleted because: " + ex.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
    //endregion
}
