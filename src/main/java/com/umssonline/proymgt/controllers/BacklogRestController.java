package com.umssonline.proymgt.controllers;

import com.umssonline.proymgt.models.dto.CreateBacklogDto;
import com.umssonline.proymgt.models.dto.UpdateBacklogDto;
import com.umssonline.proymgt.models.entity.Backlog;
import com.umssonline.proymgt.models.entity.UserStory;
import com.umssonline.proymgt.services.BacklogServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/backlogs")
public class BacklogRestController {

    //region Properties
    @Autowired
    private BacklogServiceImpl service;

    @Autowired
    private ModelMapper modelMapper;
    //endregion

    //region Methods
    @GetMapping("/{backlog_id}")
    public ResponseEntity<Backlog> find(@PathVariable("backlog_id") final Long backlogId) {

        Backlog backlogFound = service.findById(backlogId);
        return ResponseEntity.ok(backlogFound);
    }

    @GetMapping("/{backlog_id}/userstories")
    public ResponseEntity<Iterable<UserStory>> loadUserStories(@PathVariable("backlog_id") final Long backlogId) {

        Iterable<UserStory> userStories = service.loadUserStories(backlogId);
        return ResponseEntity.ok(userStories);
    }

    @PostMapping
    public ResponseEntity<Backlog> create(@Valid @RequestBody final CreateBacklogDto backlog) {

        Backlog converted = modelMapper.map(backlog, Backlog.class);
        Backlog savedBacklog = service.save(converted);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedBacklog);
    }

    @PatchMapping("/{backlog_id}")
    public ResponseEntity<Backlog> update(@PathVariable("backlog_id") final Long backlogId, @Valid @RequestBody UpdateBacklogDto backlog) {

        Backlog converted = modelMapper.map(backlog, Backlog.class);
        converted.setId(backlogId);
        Backlog updatedBacklog = service.update(converted);

        return ResponseEntity.ok(updatedBacklog);
    }

    @DeleteMapping("/{backlog_id}")
    public ResponseEntity<Void> remove(@PathVariable("backlog_id") final Long backlogId) {

        service.delete(backlogId);
        return ResponseEntity.noContent().build();
    }

    //endregion
}
