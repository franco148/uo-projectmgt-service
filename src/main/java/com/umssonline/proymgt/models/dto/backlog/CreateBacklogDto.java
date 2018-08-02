package com.umssonline.proymgt.models.dto.backlog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@ApiModel(description = "Backlog Model")
@Getter
@Setter
public class CreateBacklogDto {

    @ApiModelProperty
    (
        notes = "Backlog description",
        example = "Project Backlog"
    )
    private String description;

    @JsonIgnore
    private Integer amountOfTasks = 0;
    @JsonIgnore
    private LocalDateTime createdAt = LocalDateTime.now();
    @JsonIgnore
    private LocalDateTime updatedAt = LocalDateTime.now();

}
