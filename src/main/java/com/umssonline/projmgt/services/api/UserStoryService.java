package com.umssonline.projmgt.services.api;

import com.umssonline.projmgt.models.entity.Task;
import com.umssonline.projmgt.models.entity.UserStory;

public interface UserStoryService extends CrudService<UserStory> {

    Task addTask(Long userStoryId, Task task);
    void deleteTask(Long userStoryId, Long taskId);
    // UserStory loadTasks(Long userStoryId);
}
