package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.models.dto.story.CreateUserStoryDto;
import com.umssonline.proymgt.models.entity.UserStory;
import com.umssonline.proymgt.services.SprintItemService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/userstories")
public class UserStoryRestController {

    //region Properties
    @Resource
    private SprintItemService sprintItemService;

    private static final ModelMapper modelMapper = new ModelMapper();
    //endregion

    //region Methods
    @GetMapping("/{id}")
    public ResponseEntity find(@PathVariable("id") Long id) {

        try {
            UserStory storyFromB = sprintItemService.find(id);
            return ResponseEntity.ok(storyFromB);
        } catch (Exception ex) {
            String errorMessage = "UserStory can not be found: " + ex.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CreateUserStoryDto createUserStoryDto) {

        try {

            UserStory savedStory = sprintItemService.save(modelMapper.map(createUserStoryDto, UserStory.class));
            return ResponseEntity.ok(savedStory);
        } catch (Exception ex) {
            String errorMessage = "UserStory can not be updated because: " + ex.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @PatchMapping
    public ResponseEntity update(@RequestBody UserStory editedUserStory) {

        try {
            UserStory savedStory = sprintItemService.edit(editedUserStory);
            return ResponseEntity.ok(savedStory);
        } catch (Exception ex) {
            String errorMessage = "UserStory can not be updated because: " + ex.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable("id") Long storyId) {

        try {
            sprintItemService.delete(storyId);
            return ResponseEntity.ok().body("UserStory was deleted successfully");
        } catch (Exception ex) {
            String errorMessage = "UserStory can not be deleted because: " + ex.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
    //endregion
}
