package com.umssonline.proymgt.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.umssonline.proymgt.models.entity.Priority;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateSprintItemDto {

    @NotNull
    private String name;
    private String description;
    private Priority priority;
    private Integer estimatedTime;

    @JsonIgnore
    private LocalDate createdOn = LocalDate.now();
    @JsonIgnore
    private LocalDateTime updatedOn = LocalDateTime.now();
}
