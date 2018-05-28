package com.umssonline.proymgt.common.dto;

public class BacklogDto {

    //region Properties
    private Long id;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
