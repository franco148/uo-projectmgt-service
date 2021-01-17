package com.umssonline.projmgt.models.dto.task;

import com.umssonline.projmgt.models.dto.BaseUpdateDto;
import com.umssonline.projmgt.models.entity.Priority;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateTaskDto extends BaseUpdateDto {

    @NotBlank(message = "Name field should not be null or empty.")
    private String name;

    private String description;

    @NotBlank(message = "Priority field should not be null or empty.")
    private Priority priority;

    @Positive(message = "EstimatedTime field should not be less than zero.")
    private Integer estimatedTime;

    @Positive(message = "AssignedToId field should not be less than zero.")
    private Long assignedToId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime completedAt;
}
