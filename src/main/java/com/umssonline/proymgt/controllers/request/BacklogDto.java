package com.umssonline.proymgt.controllers.request;

public class BacklogDto {

    //region Properties
    private String description;
    private Long projectId;
    //endregion

    //region Constructors
    protected BacklogDto() {
    }

    public BacklogDto(String description) {
        this();
        this.description = description;
    }
    //endregion

    //region Getters & Setters

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProject(Long projectId) {
        this.projectId = projectId;
    }

    //endregion
}
