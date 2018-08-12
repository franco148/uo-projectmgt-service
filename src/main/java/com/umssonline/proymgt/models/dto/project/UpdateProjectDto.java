package com.umssonline.proymgt.models.dto.project;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.umssonline.proymgt.models.dto.BaseUpdateDto;
import com.umssonline.proymgt.models.dto.backlog.CreateBacklogDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ApiModel(description = "Project Model")
@Getter
@Setter
public class UpdateProjectDto extends BaseUpdateDto {

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
        required = true,
        example = "dd-MM-yyyy"
    )
    @NotNull(message = "Completed Date Estimation field can should not be null.")
    @Future(message = "Completed Date Estimation should be a future date.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate completedDateEstimation;

    @ApiModelProperty
    (
        notes = "BacklogId field should not be less than zero.",
        required = true
    )
    @NotNull(message = "BacklogId field should not be null.")
    @Positive(message = "BacklogId field should not be less than zero.")
    private Long backlogId;

    @ApiModelProperty
    (
        notes = "Backlog Description field."
    )
    private String backlogDescription;

    @JsonIgnore
    private LocalDateTime backlogUpdatedAt = LocalDateTime.now();

}
