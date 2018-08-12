package com.umssonline.proymgt.models.dto.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.umssonline.proymgt.models.dto.BaseCreateDto;
import com.umssonline.proymgt.models.entity.Priority;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateTaskDto extends BaseCreateDto {

    @NotBlank(message = "Name field should not be null or empty.")
    private String name;

    private String description;

    @NotBlank(message = "Priority field should not be null or empty.")
    private Priority priority;

    @Positive(message = "EstimatedTime field should not be less than zero.")
    private Integer estimatedTime;

    @Positive(message = "AssignedToId field should not be less than zero.")
    private Long assignedToId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime startedAt;
}
