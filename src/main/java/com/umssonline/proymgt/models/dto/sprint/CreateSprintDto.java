package com.umssonline.proymgt.models.dto.sprint;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.umssonline.proymgt.models.dto.BaseCreateDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@ApiModel(description = "Sprint Model")
@Getter
@Setter
public class CreateSprintDto extends BaseCreateDto {

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
        notes = "StartedOn field refers when a sprint starts.",
        example = "dd-MM-yyyy"
    )
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate startedOn;

    @ApiModelProperty
    (
        notes = "CompletedOn field refers when a sprint ends.",
        example = "dd-MM-yyyy"
    )
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate completedOn;

}
