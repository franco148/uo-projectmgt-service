package com.umssonline.proymgt.common.dto;

import java.time.LocalDate;

public class SprintDto {

    //region Properties

    private Long id;
    private String name;
    private LocalDate startedOn;
    private LocalDate completedOn;
    //endregion

    //region Constructors
    protected SprintDto() {
    }

    public SprintDto(String name) {
        this();
        this.name = name;
    }
    //endregion

    //region Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(LocalDate startedOn) {
        this.startedOn = startedOn;
    }

    public LocalDate getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(LocalDate completedOn) {
        this.completedOn = completedOn;
    }

    //endregion
}
