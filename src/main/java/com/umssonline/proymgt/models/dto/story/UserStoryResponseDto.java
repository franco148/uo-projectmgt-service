package com.umssonline.proymgt.models.dto.story;

import com.umssonline.proymgt.models.dto.user.AssignedToResponseDto;
import com.umssonline.proymgt.models.entity.Priority;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@ApiModel(description = "UserStory Model")
@Getter
@Setter
public class UserStoryResponseDto {

    private Long id;
    private String name;
    private String description;
    private Priority priority;

    private AssignedToResponseDto assignedTo;
    private Integer estimatedTime;

    private LocalDateTime startedAt;
    private LocalDateTime completedAt;
}
