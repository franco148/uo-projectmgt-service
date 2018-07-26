package com.umssonline.proymgt.models.dto.backlog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@ApiModel(description = "Backlog Model")
@Getter
@Setter
public class UpdateBacklogDto {

    @ApiModelProperty
    (
        notes = "Id field should not be null.",
        required = true
    )
    @NotNull(message = "Id field should not be null.")
    private Long id;
    @ApiModelProperty
    (
        notes = "Backlog description",
        example = "Project Backlog"
    )
    private String description;

    @JsonIgnore
    private LocalDateTime updatedAt = LocalDateTime.now();
}
