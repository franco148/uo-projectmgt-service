package com.umssonline.proymgt.models.dto.task;

import com.umssonline.proymgt.models.dto.BaseCreateDto;
import com.umssonline.proymgt.models.entity.Priority;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateTaskDto extends BaseCreateDto {

    @NotBlank(message = "Name field should not be null or empty.")
    private String name;

    private String description;

    @NotNull(message = "Priority field should not be null or empty.")
    private Priority priority;

    @Positive(message = "EstimatedTime field should not be less than zero.")
    private Integer estimatedTime;

    @Positive(message = "AssignedToId field should not be less than zero.")
    private Long assignedToId;

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startedAt;
}
