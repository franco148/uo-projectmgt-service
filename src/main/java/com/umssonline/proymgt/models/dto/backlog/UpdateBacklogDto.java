package com.umssonline.proymgt.models.dto.backlog;

import com.umssonline.proymgt.models.dto.BaseCreateDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@ApiModel(description = "Backlog Model")
@Getter
@Setter
public class UpdateBacklogDto extends BaseCreateDto {

    @ApiModelProperty
    (
        notes = "Backlog description",
        example = "Project Backlog"
    )
    private String description;

}
