package com.umssonline.proymgt.models;

import java.time.LocalDate;
import java.util.List;

public class Sprint {

    private Long id;
    private String name;
    private LocalDate startedOn;
    private LocalDate completedOn;
    private List<Task> tasks;
}
