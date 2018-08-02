package com.umssonline.proymgt.models.dto.sprint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ApiModel(description = "Sprint Model")
@Getter
@Setter
public class UpdateSprintDto {


    @ApiModelProperty
    (
        notes = "Id field should not be null.",
        required = true
    )
    @NotNull(message = "Id field should not be null.")
    private Long id;

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
    private LocalDateTime updatedAt = LocalDateTime.now();
}
