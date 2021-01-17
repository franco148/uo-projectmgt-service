package com.umssonline.projmgt.models.dto.project;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.umssonline.projmgt.models.dto.BaseCreateDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ApiModel(description = "Project Model")
@Getter
@Setter
public class CreateProjectDto extends BaseCreateDto {

    @ApiModelProperty
    (
        notes = "Name field should not be null or empty.",
        required = true,
        example = "Google Maps REST Api"
    )
    @NotBlank(message = "Name field should not be null or empty.")
    @Size(max = 30, message = "Name field should have at most 30 characters.")
    private String name;

    @ApiModelProperty
    (
        notes = "Completed Date Estimation field can should not be null, and It should be future date.",
        required = true,
        example = "dd-MM-yyyy"
    )
    @Future(message = "Completed Date Estimation should be a future date.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate completedDateEstimation;

    @ApiModelProperty
    (
        notes = "Backlog Description field."
    )
    private String backlogDescription;

    @JsonIgnore
    private Integer backlogAmountOfUserStories = 0;

    @JsonIgnore
    private Boolean backlogIsDeleted = false;

    @JsonIgnore
    private LocalDateTime backlogCreatedAt = LocalDateTime.now();

    @JsonIgnore
    private LocalDateTime backlogUpdatedAt = LocalDateTime.now();

}
