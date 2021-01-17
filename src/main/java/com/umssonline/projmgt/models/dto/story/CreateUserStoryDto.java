package com.umssonline.projmgt.models.dto.story;

import com.umssonline.projmgt.models.dto.BaseCreateDto;
import com.umssonline.projmgt.models.entity.Priority;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@ApiModel(description = "UserStory Model")
@Getter
@Setter
public class CreateUserStoryDto extends BaseCreateDto {

    @ApiModelProperty
    (
        notes = "Name field should not be null or empty.",
        required = true
    )
    @NotBlank(message = "Name field should not be null or empty.")
    private String name;

    @ApiModelProperty
    (
        notes = "User story description."
    )
    private String description;

    @ApiModelProperty
    (
        notes = "Priority field should not be null or empty.",
        required = true
    )
    @NotNull(message = "Priority field should not be null or empty.")
    private Priority priority;

    @ApiModelProperty
    (
        notes = "EstimatedTime field should not be less than zero.",
        allowableValues = "greater than zero."
    )
    @Positive(message = "EstimatedTime field should not be less than zero.")
    private Integer estimatedTime;

    @ApiModelProperty
    (
        notes = "AssignedToId field should not be less than zero.",
        allowableValues = "greater than zero."
    )
    @Positive(message = "AssignedToId field should not be less than zero.")
    private Long assignedToId;

    @ApiModelProperty
    (
        notes = "Date where the user story starts.",
        example = "dd-MM-yyyy HH:mm:ss",
        dataType = "Date"
    )
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startedAt;
}
