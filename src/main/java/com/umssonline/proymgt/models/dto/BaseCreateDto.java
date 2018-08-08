package com.umssonline.proymgt.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseCreateDto {

    @JsonIgnore
    private LocalDateTime createdAt = LocalDateTime.now();

    @JsonIgnore
    private LocalDateTime updatedAt = LocalDateTime.now();

    @JsonIgnore
    private Boolean isDeleted = false;


    @ApiModelProperty
    (
        notes = "CreatedById field should not be null and less than zero.",
        required = true
    )
    @NotNull(message = "CreatedById field should not be null.")
    @Positive(message = "CreatedById field should not be less than zero.")
    private Long createdById;
}
