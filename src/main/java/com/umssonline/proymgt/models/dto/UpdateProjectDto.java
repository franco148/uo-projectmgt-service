package com.umssonline.proymgt.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@ApiModel(description = "Backlog")
@Getter
@Setter
public class UpdateProjectDto {

    @ApiModelProperty
    (
        notes = "Id field should not be null.",
        required = true
    )
    @NotNull(message = "Id field should not be null.")
    private Long Id;

    @ApiModelProperty
    (
        notes = "Name field should not be null or empty.",
        required = true,
        example = "Google Maps REST Api"
    )
    @NotBlank(message = "Name field should not be null or empty.")
    private String name;

    @ApiModelProperty
    (
        notes = "Completed Date Estimation field can should not be null, and It should be future date.",
        required = true
    )
    @NotNull(message = "Completed Date Estimation field can should not be null.")
    @Future(message = "Completed Date Estimation should be a future date.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate completedDateEstimation;

    @ApiModelProperty
    (
        notes = "Backlog should not be null.",
        required = true
    )
    @NotNull(message = "Backlog should not be null.")
    private CreateBacklogDto backlog;

}
