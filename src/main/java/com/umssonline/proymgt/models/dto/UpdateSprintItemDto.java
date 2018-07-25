package com.umssonline.proymgt.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.umssonline.proymgt.models.entity.Priority;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateSprintItemDto {

    @Id
    @NotNull
    private Long id;
    @NotNull
    private String name;
    private String description;
    private Priority priority;
    private Integer estimatedTime;

    @JsonIgnore
    private LocalDateTime updatedOn = LocalDateTime.now();
}
