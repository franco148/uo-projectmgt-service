package com.umssonline.projmgt.models.dto.backlog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.umssonline.projmgt.models.dto.BaseCreateDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "Backlog Model")
@Getter
@Setter
public class CreateBacklogDto extends BaseCreateDto {

    @ApiModelProperty
    (
        notes = "Backlog description",
        example = "Project Backlog"
    )
    private String description;

    @JsonIgnore
    private Integer amountOfUserStories = 0;

}
