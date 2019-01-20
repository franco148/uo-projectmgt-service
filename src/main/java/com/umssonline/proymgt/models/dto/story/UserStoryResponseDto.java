package com.umssonline.proymgt.models.dto.story;

import com.umssonline.proymgt.models.dto.user.AssignedToResponseDto;
import com.umssonline.proymgt.models.entity.Priority;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@ApiModel(description = "UserStory Model")
@Getter
@Setter
public class UserStoryResponseDto {

    @ApiModelProperty
    (
        notes = "Name field should not be null or empty.",
        required = true
    )
    private Long id;

    @ApiModelProperty
    (
        notes = "Name field should not be null or empty.",
        required = true
    )
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
    private Priority priority;

    private AssignedToResponseDto assignedTo;

    @ApiModelProperty
    (
        notes = "EstimatedTime field should not be less than zero.",
        allowableValues = "greater than zero."
    )
    @Positive(message = "EstimatedTime field should not be less than zero.")
    private Integer estimatedTime;

    @ApiModelProperty
    (
        notes = "Date where the user story is going to start.",
        example = "dd-MM-yyyy",
        dataType = "Date"
    )
    private LocalDateTime startedAt;

    @ApiModelProperty
    (
        notes = "Date where the user story is completed.",
        example = "dd-MM-yyyy",
        dataType = "Date"
    )
    private LocalDateTime completedAt;
}
