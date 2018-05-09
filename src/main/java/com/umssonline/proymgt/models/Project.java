package com.umssonline.proymgt.models;

import java.time.LocalDate;
import java.util.List;

public class Project {

    private Long id;
    private String name;
    private LocalDate startedOn;
    private LocalDate completeDateEstimation;

    private List<Sprint> sprints;
}
