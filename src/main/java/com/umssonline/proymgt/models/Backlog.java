package com.umssonline.proymgt.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Backlog {

    private Long id;
    private String description;
    private Integer amountOfTasks;
    private List<Task> tasks;
    private LocalDate createdOn;
    private LocalDateTime updatedOn;

}
