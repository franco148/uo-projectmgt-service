package com.umssonline.proymgt.models.dto.sprint;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.umssonline.proymgt.models.dto.BaseUpdateDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@ApiModel(description = "Sprint Model")
@Getter
@Setter
public class UpdateSprintDto extends BaseUpdateDto {


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
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startedOn;

    @ApiModelProperty
    (
        notes = "CompletedOn field refers when a sprint ends.",
        example = "dd-MM-yyyy"
    )
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate completedOn;

}
