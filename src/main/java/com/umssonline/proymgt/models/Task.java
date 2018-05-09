package com.umssonline.proymgt.models;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Task {

    private Long id;
    private String name;
    private String description;
    private Priority priority;
    private User createdBy;
    private User assignedTo;
    private User updatedBy;
    private Integer estimatedTime;
    private LocalDate createdOn;
    private LocalDateTime startedOn;
    private LocalDateTime updatedOn;
    private LocalDateTime completedOn;

    private Task subTask;
}
