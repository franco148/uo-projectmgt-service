package com.umssonline.proymgt.models.dto.sprint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ApiModel(description = "Sprint Model")
@Getter
@Setter
public class CreateSprintDto {

    @ApiModelProperty
    (
        notes = "Name field should not be null or empty.",
        example = "Sprint 10 - Social Services",
        required = true
    )
    @NotBlank(message = "Name field should not be null or empty.")
    private String name;

    @ApiModelProperty
    (
        notes = "StartedOn field refers when a sprint starts."
    )
    private LocalDate startedOn;

    @ApiModelProperty
    (
        notes = "CompletedOn field refers when a sprint ends."
    )
    private LocalDate completedOn;

    @JsonIgnore
    private LocalDateTime createdAt = LocalDateTime.now();
    @JsonIgnore
    private LocalDateTime updatedAt = LocalDateTime.now();
}
